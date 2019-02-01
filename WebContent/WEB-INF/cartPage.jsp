<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:page pagetitle="Cart Page">
<jsp:attribute name="scripts">
	<script type="application/javascript">
	function removeFromCart(id,movie,format){
		$.post("/ShoppingCart/cart",{movie, format},
				
				function(data, status){
					$("#removesuccess").fadeTo(2000,500).slideUp(500);
					$("#row_"+id).remove();
					$("#total").text(data.total);
					$("#tax").text(data.tax);
					$("#payment").text(data.payment);
				}
		).fail(
				function(data, status){
					$("#removefail").fadeTo(2000,500).slideUp(500);
				}
			
		);
	}
	</script>
</jsp:attribute>
<jsp:body>

<div class = "container">
	<div id="removefail" class="alert alert-danger" role="alert">
    		There's something wrong!
    		</div>
    		<div id="removesuccess" class="alert alert-danger" role="alert">
    		Item has been removed from the cart.
    		</div>
	<table class="table">
		<tr>
			<th scope="col">Title</th>
			<th scope="col">Format</th>
			<th scope="col">Price</th>
			<th scope="col">Action</th>
		</tr>
	
	<c:set var="i" value="0" scope="page" />
    <c:forEach items="${cart.cartItems}" var="item">
    	
    	<tr id="row_${i}">
    		<td scope="row">${item.title}</td>
    		<td scope="row">${item.format}</td>
    		<td scope="row">${item.price}</td>
    		<td scope="row"><button type="button" class="btn btn-info" onclick="removeFromCart(${i}, ${item.id}, '${item.format}')">Remove</button></td>
    	</tr>
    	<c:set var="i" value="${i + 1}" scope="page"/>
    </c:forEach>
    <tr>
    	<th />
    	<th scope="col">Total:</th>
    	<th id="total" scope="col">${cart.totalDisplay}</th>
    </tr>
    <tr>
    	<th />
    	<th scope="col">Tax:</th>
    	<th id="tax" scope="col">${cart.taxDisplay}</th>
    </tr>
    <tr>
    	<th />
    	<th scope="col">Payment:</th>
    	<th id="payment" scope="col">${cart.paymentDisplay}</th>
    </tr>
   <tr>
   		<th><th>
   		
   		<th>
	   		<c:if test = "${submit==null}">
	   			
	         	<a class="btn btn-primary" href="/ShoppingCart/checkOut">Check Out</a>
	      	</c:if>
   		
   			
   		
   		</th>
   </tr>
   
   </table>
</div>

</jsp:body>

</t:page>