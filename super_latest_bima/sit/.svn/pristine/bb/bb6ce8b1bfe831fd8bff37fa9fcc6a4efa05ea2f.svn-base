<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email verified</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<c:if test="${result == true}">
<!-- <h3>Successfully verified</h3> -->
<center>

<div class="jumbotron text-xs-center" style="height:650px;">

<img src="http://103.129.188.37/assets/img/logo-bima.png" alt="Bima">

  <h1 class="display-3">Sucessfully verified!</h1>
  <p class="lead"><strong>Please check your email</strong> for further instructions on how to complete your account setup.</p>
  <hr>
  
 <!--  <p class="lead">
    <a class="btn btn-primary btn-sm" href="#" role="button">Continue to homepage</a>
  </p> -->
  </div>
</center>
</c:if>
<c:if test="${result == false}">
<center>
<img src="logo.png" alt="Bima">
<div class="jumbotron text-xs-center" style="height:800px;">
  <h1 class="display-3">Oops Problem In Email Verification!</h1>
  <p class="lead"><strong>Please check your email</strong> for further instructions on how to complete your account setup.</p>
  <hr>
  
  <!-- <p class="lead">
    <a class="btn btn-primary btn-sm" href="#" role="button" onclick="window.open( form.url.value, 'http://103.129.188.37/' ); return false" href="">Continue to homepage</a>
  </p> -->
  </div>
</center>
</c:if>
</body>
</html>