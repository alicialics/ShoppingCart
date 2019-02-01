package cart;

public class User implements java.io.Serializable {
	  
	private static final long serialVersionUID = 1L;
	
    private String firstName = null;
    private String lastName = null;
    private String userName = null;
    private int password = 0;
    private int id = 0;

   public User() {
   }
   public String getFirstName(){
      return firstName;
   }
   public String getLastName(){
      return lastName;
   }
   public String getUserName() {
	   return userName;
   }
   public int getPassword() {
	   return password;
   }
   public int getId(){
      return id;
   }
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }
   public void setLastName(String lastName){
      this.lastName = lastName;
   }
   public void setUserName(String userName) {
	   this.userName = userName;
   }
   public void setPassword(int password) {
	   this.password = password;
   }
   public void setAge(int id){
      this.id = id;
   }
}