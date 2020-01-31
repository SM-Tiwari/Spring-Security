<%-- 
    Document   : thankyou
    Created on : Apr 18, 2017, 3:58:48 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>	
<title>Thank you -- HCPT</title>
<style>
.main-content {
       /* float: left; */
    /* margin: 5px; */
    
    /* width: 100%; */
	font-family: 'Roboto', sans-serif;
	padding: 15px;
    height: 100%;
	line-height: 24px;
} 

.main-content h4 {
   
    font-size: 12pt;
	padding-left: 14px;
	margin-bottom: 0.5em;
	 
}
	
.succes-btn{
	
    background-color: #E91C24;
    border: none;
    color: white;
    padding: 7px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
  	margin: 10px;
	display: block;
  
}
.main-content table {
	padding-left: 14px;
	margin-top: 0.5em;
    margin-bottom: 0.5em;
	line-height: 2em;
}	
.lines{
	padding-left: 14px;
	height: 2px;
	background-color: #ddd;
	display: block;
	margin-right: 10px;
	margin-left: 10px;
}
.ok-btn{
	background-color: #fff;
    border-style: solid;
	border-width: 2px;
    border-color: #00a9a6;
    color: #000;
    padding: 7px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
  	margin: 10px;
	display: block;
	margin: 10px;
    margin-top: 60px;
    padding: 2px 45px 2px 45px;
    float: right;
  
	

  
	
}
</style>

<script>
    function close_window() {
        window.location.href = "${pageContext.request.contextPath}/api/v1/inbound/close";
    }
</script>

</head>
	
<body>
<form >
<div class="main-content">
    <c:if test = "${empty ErrDesc}">
         <a href="#" class="succes-btn"><b>SUKSES</span></b></a>
    </c:if>
    <c:if test = "${not empty ErrDesc}">
         <a href="#" class="succes-btn"><b>Failed</span></b></a>
    </c:if>

<h4>Payment Status</h4>
<div class="lines"></div>
<table>
  <tr>
    <td>Status</td>
    <td>:</td>
    <td><b>
            <c:if test = "${empty ErrDesc}">
                SUKSES
           </c:if>
            <c:if test = "${not empty ErrDesc}">
                Failed : ${ErrDesc}
           </c:if>
    </b></td>
  </tr>
</table>
<div class="lines"></div>
<a href="javascript:close_window();" class="ok-btn" id="ok-btn"><b>OK</b></a> 
</div>
</form>
</body>
</html>