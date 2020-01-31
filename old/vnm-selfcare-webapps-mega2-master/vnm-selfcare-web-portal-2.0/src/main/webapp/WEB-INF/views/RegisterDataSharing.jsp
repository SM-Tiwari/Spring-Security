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

	<title>My Vietnamobile - Register Data Sharing</title>
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
				<ul>
					<li><a href="${pageContext.request.contextPath}/shop/voice_n_sms"><spring:message code="label.TopMenu.Shop" text="Shop"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/group_sharing"><spring:message code="label.TopMenu.GroupSharing" text="Group Sharing"/></a></li>
					<li><a href="${pageContext.request.contextPath}/shop/grpshare/datashare"><spring:message code="label.TopMenu.DataSharing" text="Data Sharing"/></a></li>
					<li><a href="#">${product.name}</a></li>
				</ul>
				<h1>${product.name}</h1>
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="col-sm-6 col-sm-offset-3" id="memberGetContent" style="margin-top: 25px; margin-bottom: 25px;">
			<div class="card">
				<p class="text-center" style="margin-top: 10px;"><spring:message code="Label.DataSharing.InviteNumbers" text="Please enter number to invite members to your group."/></p>
				<p class="text-center" style=""> <spring:message code="Label.DataSharing.Maximum" text="(Maximum = 10 members)."/></p>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div id="appMsgContainer" class="alert alert-warning alert-block" hidden="hidden">
						<button type="button" class="close" data-hide="alert">
							<i class="fa fa-times" aria-hidden="true"></i>
						</button>
						<span id="appMsg"></span>
					</div> 
				</div>
			</div>
			<input type="hidden" id="svrMsg" value="${message}"/>
			<input type="hidden" id="phoneNumberRegex" value="/${phoneNumberRegex}/"/>
			<form:form id="frmDataSharing" method="POST" action="${pageContext.request.contextPath}/secure/datasharing/${productCode}/reg">
			<div class="row phone_number_container" style="margin-bottom: 25px;">
				<div class="col-md-3">
					<p id="label"><spring:message code="Label.DataSharing.Number" text="Number"/> 1:</p>
				</div>
				<div class="col-md-9">
					<div class="form-group has-error">
						<input type="text" name="phoneNumber" placeholder="092 345 6789" class="form-control phone_number" />
						<span class="material-icons form-control-feedback">clear</span>
					</div>
				</div>
			</div>
			<div class="row phone_number_container" style="margin-bottom: 25px;">
				<div class="col-md-3">
					<p id="label"><spring:message code="Label.DataSharing.Number" text="Number"/> 2:</p>
				</div>
				<div class="col-md-9">
					<div class="form-group has-error">
						<input type="text" name="phoneNumber" placeholder="092 345 6789" class="form-control phone_number" />
						<span class="material-icons form-control-feedback">clear</span>
					</div>
				</div>
			</div>
			<div class="row phone_number_container" style="margin-bottom: 25px;">
				<div class="col-md-3">
					<p id="label"><spring:message code="Label.DataSharing.Number" text="Number"/> 3:</p>
				</div>
				<div class="col-md-9">
					<div class="form-group has-error">
						<input type="text" name="phoneNumber" placeholder="092 345 6789" class="form-control phone_number" />
						<span class="material-icons form-control-feedback">clear</span>
					</div>
				</div>
			</div>
			<div class="row phone_number_container" style="margin-bottom: 25px;">
				<div class="col-md-3">
					<p id="label"><spring:message code="Label.DataSharing.Number" text="Number"/> 4:</p>
				</div>
				<div class="col-md-9">
					<div class="form-group has-error">
						<input type="text" name="phoneNumber" placeholder="092 345 6789" class="form-control phone_number" />
						<span class="material-icons form-control-feedback">clear</span>
					</div>
				</div>
			</div>
			<div class="row phone_number_container" id="lastRow" style="margin-bottom: 50px;">
				<div class="col-md-3">
					<p id="label"><spring:message code="Label.DataSharing.Number" text="Number"/> 5:</p>
				</div>
				<div class="col-md-9">
					<div class="form-group has-error">
						<input type="text" name="phoneNumber" placeholder="092 345 6789" class="form-control phone_number" />
						<span class="material-icons form-control-feedback">clear</span>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12 text-center">
					<a href="javascript:;" onclick="addMoreMember();" style="color: #FF6E00; font-size: 16px; text-decoration: underline;">
						<spring:message code="Label.DataSharing.AddMoreNumber" text="Add one more number"/>
					</a>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<button id="btnSubmit" type="submit" class="btn btn-primary btn-round"><spring:message code="Label.OK" text="OK"/></button>
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
	var phoneRegex = /${phoneNumberRegex}/;
	
	$(document).ready(function() {
		$(function(){
		    $("[data-hide]").on("click", function(){
		        $(this).closest("." + $(this).attr("data-hide")).hide();
		    });
		});

		$("input:text").focus(function() { $(this).select(); } );

		if ($("#svrMsg").val() != ""){
			$("#appMsgContainer").show();
		}

		if (countEntries() > 0){
			$("#btnSubmit").prop("disabled", false);
		} else {
			$("#btnSubmit").prop("disabled", true);
		}
		
		$(".phone_number").change(function(){
			var phone = $(this).val();
			if ( phone == "${principal.username}" || !phone.match(phoneRegex) ){
				BootstrapDialog.alert({
					title: '',
					message : '<spring:message code="Message.InvalidPhoneNumber" text="Please enter a valid Vietnamobile number."/>'
				});
				$(this).focus();
			}
		});
		
		$(".phone_number").blur(function(){
			if (countEntries() > 0){
				$("#btnSubmit").prop("disabled", false);
			}
		});
		
		$("#btnSubmit").click(function(e){
			e.preventDefault();
			if (countEntries() > 0){
				confirmRegister();
				
			} else {
				$('#appMsgContainer').show();
				$("#appMsg").html('<spring:message code="Message.InvalidPhoneNumber" text="Please enter a valid Vietnamobile number."/>');
			}
		});
	});


	function confirmRegister(){
		var url = $("#frmDataSharing").attr( "action" );
		BootstrapDialog.show({
			type: BootstrapDialog.TYPE_WARNING,
			title: '',
			message: '<spring:message code="Message.DataSharing.ConfirmRegistration" text="Are you sure you want to register?"/>',
			buttons: [{
					label: '<spring:message code="label.OK" text="OK"/>',
					cssClass: 'btn btn-primary btn-round',
					autospin: true,
					action: function(dialogRef){
								dialogRef.enableButtons(false);
			                	dialogRef.setClosable(false);
			                	dialogRef.getModalBody().html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.ProcessingRequest" text="Processing your request, please wait..."/>');
				                	    		
			            		$.post(url,	
			            			$("#frmDataSharing").serialize()
			            		).done(function(data) {
			            			console.log("response= " + data.key + ", " + data.value);
				     				dialogRef.getModalBody().html(data.value);
				     				dialogRef.enableButtons(false);
				     				
				     				//reload page if registration was successful
				     				if (data.key == "1"){
				     					setTimeout(function(){
				     						location.replace("${pageContext.request.contextPath}/shop/group_sharing/products/${productGroup.id}");
					                    }, 2000);
				     				} else {
				     					
				     				}
				     			}).fail(function(jqXHR, textStatus) {
				     				dialogRef.getModalBody().html('<spring:message code="Message.DataSharing.RegisterFail" text="Your registration to package has failed."/>');
									console.log("Error: " + textStatus);
		
				     			})
				     			.always(function() {
					                setTimeout(function(){
				                        dialogRef.close();
				                    }, 3000);
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
	
	function countEntries(){
		var ctr = 0;
		$(".phone_number").each(function() {
			if ($(this).val() != "") {
				ctr++;
			}
		});
		return ctr;
	}
	
	function addMoreMember(){
		var count = $('.phone_number_container').length;
		if (count < 10){
			$("#lastRow").clone().insertAfter("div.phone_number_container:last");	
		}
	}
</script>
</html>