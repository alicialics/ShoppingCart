package cart;


import java.util.*;

public class Cart implements java.io.Serializable {
	  
	private static final long serialVersionUID = 1L;

    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>(); 

   public Cart() {
   }
   public ArrayList<CartItem> getCartItems(){
      return cartItems;
   }
   
   public void addCartItem(int id, String format, String title){
	  CartItem item = new CartItem(id, format, title);
      cartItems.add(item);
   }
  
   public String getTotalDisplay() {
	  
	   return String.format("%.2f", getTotal());
   }
   
   private double getTotal() {
	   double _total = 0;
	   for(CartItem item: cartItems) {
		   _total+=item.getPrice();
	   }
	   return _total;
   }
   
   private double getTax() {
	   return getTotal()*0.13;
   }
   
   public String getTaxDisplay() {
	   
	   return String.format("%.2f",getTax());
   }
   
   public String getPaymentDisplay() {
	   
	   return String.format("%.2f", getTotal()+getTax());
   }
   
   public void clearCart() {
	   cartItems.clear();
   }
   
   public void removeFromCart(int movie, String format) {
	   for(CartItem item:cartItems) {
		   if(item.getId()==movie && item.getFormat().equals(format)) {
			   cartItems.remove(item);
			   break;
		   }
	   }
   }
 
}