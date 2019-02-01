package cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartItem implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String format;
	private String title;
	private double price;
	
	public CartItem() {
		id = 0;
		title = null;
		format = null;
		price = 0;
		
	}
	
	public CartItem(int _id, String _format,String _title) {
		id = _id;
		format = _format;
		title = _title;
		setPrice(_id, _format);
	}
	
	private void setPrice(int _id, String _format) {
		if(_format.equals("blu")) {
			price = 19.99;
		}else if(_format.equals("dvd")) {
			price = 9.99;
		}else {
			price = 12.99;
		}
	}
	public double getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}
	public String getFormat() {
		if(format.equals("blu")) {
			return "Blu-ray";
		}else if(format.equals("dvd")) {
			return "DVD";
		}else {
			return "3D";
		}
	}
	public int getId() {
		return id;
	}
}