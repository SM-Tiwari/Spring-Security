<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="utils" uri="utils" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile - Active Subscriptions</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">

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
				<ul>
					<li><a href="${pageContext.request.contextPath}/secure/profile"><spring:message code="label.Profile" text="Profile"/></a></li>
					<li><spring:message code="label.Profile.Subscriptions" text="Subscriptions"/></li>
				</ul>
				<h1><spring:message code="label.Profile.Subscriptions" text="Subscriptions"/></h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12" id="activeSubs">
		<div class="col-sm-8 col-sm-offset-2" id="activeSubsContent">
			<div class="col-sm-3 desktop hidden-xs">
				<img src="${userProfile.avatar}" alt="Avatar" class="img-responsive">
				<h2>${userProfile.details.fullName}</h2>
			</div>
			<div class="col-xs-12 mobile visible-xs">
				<img src="${userProfile.avatar}" alt="Avatar" class="img-responsive img-rounded img-raised">
				<h2>${userProfile.details.fullName}</h2>
			</div>
			<div class="col-sm-9">
				<c:forEach items="${subscriptions}" var="subscription"> 
					<div class="card">
						<div class="package-title">
							<h6>${subscription.product.name}</h6>
						</div>
						<div class="package-body">
							<div class="row">
								<div class="col-xs-6 leftContent">
									<p><spring:message code="label.Status" text="Status"/></p>
									<p><spring:message code="label.Dashboard.Expired" text="Expired"/></p>
								</div>
								<div class="col-xs-6 rightContent">
									<p>${subscription.status}</p>
									<p><fmt:formatDate value="${subscription.endDate}" pattern="dd/MM/yyyy"/></p>
								</div>
								<div class="col-xs-6 leftContent"></div>
								<div class="col-xs-6 rightContent">
									<button onclick="unregister('${subscription.product.code}')" class="btn btn-primary btn-round" style="margin-left: 40%; margin-right: 60%; position: relative;"><spring:message code="label.Unregister" text="Unregister"/></button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>
</div> <!-- .wrapper -->

<!-- Main Content: End -->

</body>

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
	function unregister(productCode){
		var needReload = false;
		BootstrapDialog.show({
			type: BootstrapDialog.TYPE_WARNING,
			title: '',			 
			message: '<spring:message code="Message.Shop.ConfirmUnregisterPackage" text="Do you really want to unregister?"/>',
			buttons: [{
					label: '<spring:message code="label.OK" text="OK"/>',
					cssClass: 'btn btn-primary btn-round',
					autospin: true,
					action: function(dialogRef){
							dialogRef.enableButtons(false);
			                dialogRef.setClosable(false);
			                dialogRef.getModalBody().html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.Processing" text="Processing your request, please wait..."/>');
			                $.get( 
								"${pageContext.request.contextPath}/secure/unregpkg/" + productCode
			     							
			     			).done(function(data) {
			     				if (data == "1"){
			     					dialogRef.getModalBody().html('<spring:message code="Message.Shop.UnregisterSuccess" text="You have unregistered the package successfully."/>');
			     					needReload = true;
			     				}else{
			     					dialogRef.getModalBody().html('<spring:message code="Message.Shop.UnregisterFail" text="The unregistration has failed."/>');
			     				}
			                     	    
			     			}).fail(function(e) {
			     				dialogRef.getModalBody().html('<spring:message code="Message.Shop.UnregisterFail" text="The unregistration has failed."/>');
								console.log("Error: " + e);
								
			     			}).always(function() {
				                if (needReload){
				                		location.replace("${pageContext.request.contextPath}/secure/mysubscriptions");
				                }else{
					                setTimeout(function(){
				                        dialogRef.close();
				                    }, 3000);
				                }
			     			});
						}
	         	}, 
	         	{
					label: '<spring:message code="label.Cancel" text="Cancel"/>',
	            	cssClass: 'btn btn-secondary btn-round', 
	            	action: function(dialogRef){
						dialogRef.close();
	            	}
	         	}]         
	     });
	}
</script>
</html>