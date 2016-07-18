<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.gname} - Profile</title>
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
<h1>Update Profile <img src="${gravatar}" height="42" width="42"/></h1>
<div class="container">
<div class="row">
<div class="columns small-8 medium-5">
<form action="UpdateUser" method="post">
<input type="text" class="form-control" placeholder="Email" name="email" id="email" value="${user.email}"></input>
<input type="text" class="form-control" placeholder="Name" name="name" id="name" value="${user.gname}"></input>
<input type="text" class="form-control" placeholder="Zipcode" name="zip" id="zip" value="${user.zip}"></input>
<input type="password" class="form-control" placeholder="Password" name="password" id="password" value=""></input>
<input type="submit" class="btn btn-lg btn-primary btn-block" name="submit" id="submit" value="Update"></input>
</form>
</div>
</div>
<c:forEach var="rev" items="${user.greviews}">
<form action="UpdateReview" method="post">
<h4>${rev.grestaurant.gname}</h4>
Rating:<input type="text" name="rating" id="rating" value="${rev.rating}"></input>
Review:<input type="text" name="review" id="review" value="${rev.text}"></input>
<input type="hidden" name="rid" id="rid" value="${rev.grestaurant.grestaurantid}"></input>
<input type="hidden" name="revid" id="revid" value="${rev.greviewid}"></input>
<input type="submit" name="submit" id="submit" value="Submit"></input>
</form>
</c:forEach>
</div>
</body>
</html>