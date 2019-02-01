package cart;

public class Movie implements java.io.Serializable {
private static final long serialVersionUID = 1L;
	
	private int id=0;
    private String title = null;
    private String poster = null;
    private String genre = null;
    private String description = null;
    private String director = null;
    private String actors = null;
    private int year = 0;
    private int runtime = 0;
    private double rating = 0;
    private int votes = 0;
    private double price = 0;
    private double revenue = 0;
    private int metascore = 0;
 
    

   public Movie() {
   }
   public int getId(){
      return id;
   }
   public double getPrice(){
      return price;
   }
   public String getPoster() {
	   return poster;
   }
   public String getTitle() {
	   return title;
   }
   public String getGenre() {
	   return genre;
   }
   public String getDescription() {
	   return description;
   }
   public int getYear() {
	   return year;
   }
   
   public void setTitle(String title){
      this.title = title;
   }
  
   public void setId(int id){
      this.id = id;
   }
   public void setPoster(String poster) {
	   this.poster= poster;
   }
   public void setGenre(String genre) {
	   this.genre = genre;
   }
   public void setDescription(String description) {
	   this.description = description;
   }
   public void setDirector(String director) {
	   this.director = director;
   }
   public void setActors(String actors) {
	   this.actors = actors;
   }
   public void setYear(int year) {
	   this.year = year;
   }
   public void setRuntime(int runtime) {
	   this.runtime = runtime;
   }
   public void setRating(double rating) {
	   this.rating = rating;
   }
}
