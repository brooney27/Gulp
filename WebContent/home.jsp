<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gulp - Home</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( ".tabs" ).tabs();
  } );
  </script>
    <!-- BEGIN Bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://bootswatch.com/sandstone/bootstrap.min.css" rel="stylesheet">
<!-- END Bootstrap -->
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>Welcome, ${user.gname} <img src="${gravatar}" height="60" width="60"/></h1>
<h3>Add restaurant:</h3>
<form action="AddRestaurant">
Name:<input type="text" name="name" id="name" value=""></input>
Address:<input type="text" name="address" id="address" value=""></input>
Description:<input type="text" name="description" id="description" value=""></input>
<input type="submit" name="submit" id="submit" value="Submit"></input>
</form>
<h3>Restaurants by rating:</h3>
<c:forEach var="r" items="${restaurants}">
<h4>
<c:out value="${r.gname}"/>: 
<c:forEach begin="1" end="${r.avgrating.avgrating}" varStatus="loop">
    <img src="http://businessoverbroadway.com/wp-content/uploads/2011/10/MobileApp_Reviews.png"  height="42" width="42">
</c:forEach> - 
<c:out value="${r.description}"/>
</h4>
<div class="tabs">
  <ul>
    <li><a href="#tabs-1">Reviews</a></li>
    <li><a href="#tabs-2">Add review</a></li>
  </ul>

<div id="tabs-1">
<c:forEach var="rev" items="${r.greviews}">
<img src="${rev.guser.gravatar}" width="42" height="42"/>
<c:out value="${rev.rating}"/>
<c:out value="${rev.text}"/><br/>
</c:forEach>
</div>

<div id="tabs-2">
Review this restaurant
<form action="AddReview" method="post">
Rating:<input type="text" name="rating" id="rating" value=""></input>
Review:<input type="text" name="review" id="review" value=""></input>
<input type="hidden" name="rid" id="rid" value="${r.grestaurantid}"></input>
<input type="submit" name="submit" id="submit" value="Submit"></input>
</form>
</div>
</div>
</c:forEach>
</body>
</html>