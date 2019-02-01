<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

 <t:page pagetitle="Checkout Page">
 
 <div class="container">
 	<table class="table">
		<tr>
	    	<th scope="col">Total:</th>
	    	<th scope="col">${cart.totalDisplay}</th>
	    </tr>
	    <tr>
	    	<th scope="col">Tax:</th>
	    	<th scope="col">${cart.taxDisplay}</th>
	    </tr>
	    <tr>
	    	<th scope="col">Payment:</th>
	    	<th scope="col">${cart.paymentDisplay}</th>
	    </tr> 		
 	
 	</table>
 
 
 
 
 	<form action="/ShoppingCart/checkOut" method="post">
 		<div class="form-group">
 			<label> Credit Card</label>
 			<input class="form-control" type="text" name="card">
 		</div>
		<div class="form-group">
 			<label> CCV</label>
 			<input class="form-control" type="text" name="ccv">
 		</div>
 		<div class="form-group">
 			<label> Name on card:</label>
 			<input class="form-control" type="text" name="name">
 		</div>
 		<div class="form-group">
 			<label> Address:</label>
 			<input class="form-control" type="text" name="address">
 		</div>
	
		<input class="btn btn-primary" type="submit" name="submit" value="Place Order"><br>
	
	</form>
 </div>
	
</t:page>