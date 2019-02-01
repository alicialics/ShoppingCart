package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/cartPage.jsp");  
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("movie"));
		String format = (String)request.getParameter("format");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		if(cart==null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		cart.removeFromCart(id, format);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		
		
		out.print(String.format("{\"total\":\"%s\",\"tax\":\"%s\",\"payment\":\"%s\"}", cart.getTotalDisplay(),cart.getTaxDisplay(),cart.getPaymentDisplay()));
		
	}

}
