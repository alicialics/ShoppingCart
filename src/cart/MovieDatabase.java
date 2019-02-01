package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MovieDatabase implements java.io.Serializable{
	
	private Connection conn;
	private String JDBC_DRIVER;  
    private String DB_URL;
    private String USER;
    private String PASS;
    
   
    public MovieDatabase(){
    	JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    	DB_URL="jdbc:mysql://localhost/shoppingcart";
    	USER = "root";
        PASS = "";
    }
    
    private void connect() throws SQLException{
    	if(conn==null || conn.isClosed()) {
    		try {
    			Class.forName(JDBC_DRIVER);
    			conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		}catch(ClassNotFoundException se) {
    			throw new SQLException(se);
    		}
    	}
    }
   

    private void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
    
   
	public ArrayList<Movie> getMovies(String genre) throws SQLException
	{
		ArrayList<Movie> movies = new ArrayList<>();
		
		connect();
		Statement stmt = conn.createStatement();
        String sql = "SELECT Id, Title, Poster, Genre, Description, Director,Actors, Year, Runtime, Rating FROM movies";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
        	//Retrieve by column name
        	
        	if(genre==null || genre.length() == 0 || genre.equalsIgnoreCase(rs.getString("Genre")))
        	{
	            movies.add(toMovie(rs));
        	}
        	
        }
        // Clean-up environment
        rs.close();
        stmt.close();
		disconnect();
	    
	    return movies;
	}
	
	private Movie toMovie(ResultSet rs) throws SQLException{
		Movie movie = new Movie();
		if(rs.next()) {
			movie.setId(rs.getInt("Id"));
            movie.setTitle(rs.getString("Title"));
            movie.setGenre(rs.getString("Genre"));
            movie.setPoster(rs.getString("Poster"));
            movie.setDescription(rs.getString("Description"));
            movie.setDirector(rs.getString("Director"));
            movie.setActors(rs.getString("Actors"));
            movie.setYear(rs.getInt("Year"));
            movie.setRuntime(rs.getInt("Runtime"));
            movie.setRating(rs.getDouble("Rating"));
		}
		return movie;
	}
	
	public Movie searchMovie(int id) throws SQLException{

		String sql = "SELECT * FROM movies WHERE id = ?";
		
		connect();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs= stmt.executeQuery();
		
		Movie movie=toMovie(rs);
		rs.close();
        stmt.close();
		disconnect();
		
		return movie;
	}
	
    
    
}