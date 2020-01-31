<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile - Invite Member</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>

<body>

<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<h1 class="no-breadcrumb"><spring:message code="label.InviteFriends.Title" text="Invite Friends"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="col-sm-6 col-sm-offset-3" id="memberGetContent" style="margin-top: 25px; margin-bottom: 25px;">
			<h3 class="text-center"><spring:message code="label.InviteFriends.Text1" text="Share MyVietnamobile app with your friends"/></h3>
			<p class="text-center"><spring:message code="label.InviteFriends.Text2" text="Enter Vietnamobile numbers"/></p>
			
			<form:form name="frmInvite" id="frmInvite" method="POST" action="${pageContext.request.contextPath}/secure/invite/confirm">
				<input type="hidden" id="svrMsg" value="${message}"/>
				
				<c:set var="phoneNumberPlaceHolder"><spring:message code='label.PhoneNumber' text='Phone Number'/></c:set>
				<div class="row phone_number_container" id="row1" style="margin-bottom: 25px;">
					<div class="col-md-4">
						<p id="label"><spring:message code="label.PhoneNumber" text="Phone Number"/> #1</p>
					</div>
					<div class="col-md-8">
						<div class="form-group has-error">
							<input type="text" name="phoneNumber" placeholder="${phoneNumberPlaceHolder}" class="form-control phone_number" />
							<!-- <span class="material-icons form-control-feedback">clear</span> -->
						</div>
					</div>
				</div>
				<div class="row phone_number_container" style="margin-bottom: 25px;">
					<div class="col-md-4">
						<p id="label"><spring:message code="label.PhoneNumber" text="Phone Number"/> #2</p>
					</div>
					<div class="col-md-8">
						<div class="form-group has-error">
							<input type="text" name="phoneNumber" placeholder="${phoneNumberPlaceHolder}" class="form-control phone_number" />
							<!-- <span class="material-icons form-control-feedback">clear</span> -->
						</div>
					</div>
				</div>
				<div class="row phone_number_container" style="margin-bottom: 25px;">
					<div class="col-md-4">
						<p id="label"><spring:message code="label.PhoneNumber" text="Phone Number"/> #3</p>
					</div>
					<div class="col-md-8">
						<div class="form-group has-error">
							<input type="text" name="phoneNumber" placeholder="${phoneNumberPlaceHolder}" class="form-control phone_number" />
							<!-- <span class="material-icons form-control-feedback">clear</span> -->
						</div>
					</div>
				</div>
				<div>
					<div class="col-md-4"></div>
					<div class="col-md-8">
						<div id="appMsgContainer" class="alert alert-warning alert-block" hidden="hidden">
							<button type="button" class="close" data-hide="alert">
								<i class="fa fa-times" aria-hidden="true"></i>
							</button>
							<span id="appMsg">${message}</span>
						</div> 
					</div>
				</div>
				<!-- 
				<div class="row" style="margin-top: 50px;">
					<div class="col-xs-12 text-center">
						<a href="#" onclick="addMoreNumber();" style="color: #FF6E00; font-size: 16px; text-decoration: underline;">
							<spring:message code="label.InviteFriends.AddMoreNumber" text="Add more number"/>
						</a>
					</div>
				</div>
				-->
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<button type="button" id="btnSubmit" class="btn btn-primary btn-round"><spring:message code="label.OK" text="OK"/></button>
					</div>
				</div>			
			</form:form>
		</div>
	</div>

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<!-- Main Content: End -->
<!--   Core Script Files   -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/dashboard.js"></script>

<!--  Plugins -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.bootstrap.js" type="text/javascript"></script>

<!--  Control for Material Kit -->
<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$(function(){
		    $("[data-hide]").on("click", function(){
		        $(this).closest("." + $(this).attr("data-hide")).hide();
		    });
		});

		$("input:text").focus(function() { $(this).select(); } );

		/*
		if (countEntry() > 0){
			$("#btnSubmit").prop("disabled", false);
		} else {
			$("#btnSubmit").prop("disabled", true);
		}
		
		$(".phone_number").blur(function(){
			if (countEntry() > 0){
				$("#btnSubmit").prop("disabled", false);
			}
		});
		*/
		
		if ($("#svrMsg").val() != ""){
			$("#appMsgContainer").show();
		}
	
		$("#btnSubmit").click(function(e){
			e.preventDefault();
			if (countEntry() > 0){
				$("#frmInvite").submit();
			} else {
				$('#appMsgContainer').show();
				$("#appMsg").html('<spring:message code="Message.InvalidPhoneNumber" text="Please enter a valid Vietnamobile number."/>');
			}
		});
	});

	function countEntry(){
		var ctr = 0;
		$(".phone_number").each(function() {
			if ($(this).val() != "") {
				ctr++;
			}
		});
		return ctr;
	}
	
	function addMoreNumber(){
		$("#row1").clone().insertAfter("div.phone_number_container:last");
	}
</script>
</html>