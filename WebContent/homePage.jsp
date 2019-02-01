<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

 <t:page pagetitle="Home Page">
 <div class="container">
  <div class="row">
    <div class="col">
    <div class="text-center"><h3>$9.99 DVD sale!</h3></div>
      
    </div>
    
  </div>
  <div class="row">
    <div class="col">
    </div>
    
    <div class="col-6">
      <div id="moviescarousel" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#moviescarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#moviescarousel" data-slide-to="1"></li>
		    <li data-target="#moviescarousel" data-slide-to="2"></li>
		    <li data-target="#moviescarousel" data-slide-to="3"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <div class="text-center">Action Movies</div>
		      <a href="/ShoppingCart/movies?genre=action">
		      	<img class="d-block w-100" src="http://image.tmdb.org/t/p/w500/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg">
		      
		      </a>
		      <div class="carousel-caption d-none d-md-block">
		    
		  </div>
		    </div>
		    <div class="carousel-item">
		      <div class="text-center">Comedy Movies</div>
		      <a href="/ShoppingCart/movies?genre=comedy">
		      <img class="d-block w-100" src="http://image.tmdb.org/t/p/w500/ylXCdC106IKiarftHkcacasaAcb.jpg">
		      </a>
		      <div class="carousel-caption d-none d-md-block">
		    
		  </div>
		    </div>
		    <div class="carousel-item">
		      <div class="text-center">Drama Movies</div>
		      <a href="/ShoppingCart/movies?genre=drama">
		      <img class="d-block w-100" src="http://image.tmdb.org/t/p/w500/6cbIDZLfwUTmttXTmNi8Mp3Rnmg.jpg">
		      </a>
		      <div class="carousel-caption d-none d-md-block">
		  </div>
		    </div>
		    
		    
			
			<div class="carousel-item">
			<div class="text-center">Adventure Movies</div>
			<a href="/ShoppingCart/movies?genre=drama">
			<img class="d-block w-100" src="http://image.tmdb.org/t/p/w500/ng8ALjSDhUmwLl7vtjUWIZNQSlt.jpg">
			</a>
			<div class="carousel-caption d-none d-md-block">
			</div>
			</div>		    
		    
		  </div>
		  <a class="carousel-control-prev" href="#moviescarousel" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#moviescarousel" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
    </div>
    <div class="col">
    </div>
  </div>
</div>
   
</t:page>


