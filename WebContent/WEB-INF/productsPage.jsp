<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>


<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<t:page pagetitle="${pagetitle}">
<jsp:attribute name="scripts">
	<script type="application/javascript">
	function addToCart(id) {
		$.post("/ShoppingCart/addToCart",
				{movie: id, format: $("#format_"+id).val()},
				function(data, status){
			        $("#addsuccess_"+id).fadeTo(2000,500).slideUp(500);
			    }
		).fail(
				function(data, status){
	        $("#addfail_"+id).fadeTo(2000,500).slideUp(500);
	    });
	    
	}
	</script>
</jsp:attribute>

<jsp:body>

<div class="container-fluid">
  <div class="row">
    <div class="col-4">
    <div>
		<ul class="nav flex-column">
		  <li class="nav-item">
		    <a class="nav-link active" href="/ShoppingCart/movies?genre=action">Action</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/ShoppingCart/movies?genre=comedy">Comedy</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/ShoppingCart/movies?genre=drama">Drama</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/ShoppingCart/movies?genre=adventure">Adventure</a>
		  </li>
		</ul>

	</div>
      
    </div>
    <div class="col-8">
    	<h4>${pagetitle}</h4>
		<c:forEach items="${movielist}" var="movie">
			<div class="media">
			  <img class="mr-3" src="http://image.tmdb.org/t/p/w200${movie.poster}">
			  <div class="media-body">
			  	<div id="addsuccess_${movie.id}" class="alert alert-success" role="alert">
			  	${movie.title} added to the cart successfully!
			  	</div>
			  	<div id="addfail_${movie.id}" class="alert alert-danger" role="alert">
			  	There's something wrong!
			  	</div>
			    <h5 class="mt-0">${movie.title} (${movie.year})</h5>
				${movie.description}		
			    <br>
				<select id="format_${movie.id}" class="form-control form-control-sm">
				  <option value="blu">Blu-ray $19.99</option>
				  <option value="dvd">DVD $9.99</option>
				  <option value="3d">3D $12.99</option>
				  <option value="5d">5D (sold out)</option>
				</select>
				<br>
							    
			    <button type="button" class="btn btn-info" onclick="addToCart(${movie.id})">Add to cart</button>
			  </div>
			</div>
			<br>
						
		</c:forEach>

    </div>
  </div>
  </div>


</jsp:body>



</t:page>

