package cart;

import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addToCartController
 */
@WebServlet("/addToCart")
public class addToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("movie"));
		String format = (String)request.getParameter("format");
		
		MovieDatabase data = new MovieDatabase();
		try {
			Movie movie = data.searchMovie(id);
			if(movie!=null && (format.equals("blu")||format.equals("dvd")||format.equals("3d"))) {
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				if(cart == null) {
					Cart aCart = new Cart();
					aCart.addCartItem(id, format,movie.getTitle());
					session.setAttribute("cart", aCart);
				}else {
					cart.addCartItem(id, format,movie.getTitle());
				}
				
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

}
