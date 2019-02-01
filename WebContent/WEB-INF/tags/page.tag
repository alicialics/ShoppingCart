<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="pagetitle" required="true"%>
<%@attribute name="scripts" fragment="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/ShoppingCart/page.css">
<title>${pagetitle}</title>
</head>
<body>
<script
  src="http://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<jsp:invoke fragment="scripts"/>
<nav class="navbar navbar-expand-sm bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
  

	<li class="nav-item">
		
      <a class="nav-link" href="/ShoppingCart/homePage.jsp">
		<svg width="20" height="20">
		  <circle cx="10" cy="10" r="10" stroke="green" stroke-width="1" fill="yellowgreen" />
		  <text fill="#ffffff" font-size="15" font-family="Verdana" x="4" y="17">M</text>
		</svg>      
      </a>
    </li>


    <li class="nav-item">
      <a class="nav-link" href="/ShoppingCart/movies">Movies</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/ShoppingCart/cart">Cart</a>
    </li>
<%
    if(session.getAttribute("email")==null)
    {
%>
    	<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#loginModal" data-whatever="@mdo">Log in</button>
<%
    }else
    {
%>    	
    	<a href="logoutController"><button type="button" class="btn btn-primary"  >Log out</button></a>
<%
    }
%>
   
      </ul>

</nav>


<div class="modal fade" id="loginModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">Please log in</h5>
        <button type="button" class="close" data-dismiss="modal" >
          <span >&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="loginController" method="post">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label"> Email:</label>
            <input type="text" class="form-control" name="email">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Password:</label>
            <input type="password" class="form-control" name="password">
          </div>
          </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <input type="submit" class="btn btn-primary" value="Log in">
	      </div>
	      </div>
        </form>
      
  </div>
</div>

<jsp:doBody/>

</body>
</html>