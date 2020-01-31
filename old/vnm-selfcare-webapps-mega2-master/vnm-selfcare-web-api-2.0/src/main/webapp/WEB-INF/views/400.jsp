<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

<title>My Vietnamobile - 404</title>
<meta name="description" content="#">
<meta name="keywords" content="#">
<meta name="author" content="Vietnamobile">

<!-- Stylesheets -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css">

<!-- Typefaces -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>

<body>

<!-- Main Content -->

<div class="wrapper" id="patnolpat">

<!-- Header -->
<div class="header-dashboard">
<div class="container">
<div class="col-sm-6 col-sm-offset-3 text-center">
<a href="http://vietnamobile.com.vn" target="_blank"><img src="${pageContext.request.contextPath}/static/assets/image/logo.png" alt="Vietnamobile Logo"></a>
</div>
</div>
</div>

<!-- Section: 404 Content -->
<div class="col-sm-6 col-sm-offset-3">
<div class="card card-raised text-center" id="patnolpatContent">
<h1><span style="font-weight: 700">We're sorry</span> something has gone wrong on our end.</h1>
<p>Well, something technical went wrong on our site. We might have removed the page when we redesigned our website or the link you clicked might be old and does not work anymore, or you might have accidentally typed the wrong URL in the address bar.</p>
</div>
<div class="row">
<div class="col-md-6">
<a href="javascript:;" onclick="window.history.back();" id="btnBack" class="btn btn-primary btn-round">Back to previous page</a>
</div>
<div class="col-md-6">
<a href="javascript:;" onclick="window.location.replace('${pageContext.request.contextPath}/')" id="btnHome" class="btn btn-primary btn-round">Back to home page</a>
</div>
</div>
</div>

<!-- Footer -->
<footer class="col-sm-12 text-center">
<ul>
<li><a href="https://www.facebook.com/VietnamobileVNM" target="_blank"><span class="fa fa-facebook"></span></a></li>
<li><a href="https://www.youtube.com/user/vietnamobileofficial" target="_blank"><span class="fa fa-youtube-play"></span></a></li>
</ul>
<p>Copyright 2017 Vietnamobile. All right reserved.</p>
</footer>

</div>

</body>

<!-- Core Script Files -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>

<!-- Control for Material Kit -->
<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
$("#btnHome").click(function(){
location.replace("${pageContext.request.contextPath}/secure/dashboard");
});

$("#btnBack").click(function(){
history.back();
});

});
</script>

</html>