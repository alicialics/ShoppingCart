package cart;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productController
 */
@WebServlet("/movies")
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieDatabase moviedata = new MovieDatabase();
		String genre = request.getParameter("genre");
		try {
			ArrayList<Movie> movielist = moviedata.getMovies(genre);
			request.setAttribute("movielist", movielist);
		}catch(SQLException se) {
			se.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		
		if(genre==null) {
			request.setAttribute("pagetitle", "Movies");
		}else if(genre.equals("action")) {
			request.setAttribute("pagetitle", "Action Movies");
		}else if(genre.equals("comedy")) {
			request.setAttribute("pagetitle", "Comedy Movies");
		}else if(genre.equals("adventure")) {
			request.setAttribute("pagetitle", "Adventure Movies");
		}else if(genre.equals("drama")) {
			request.setAttribute("pagetitle", "Drama Movies");
		}else {
			request.setAttribute("pagetitle", "Movies");
		}
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/productsPage.jsp");  
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
