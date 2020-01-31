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

	<title>My Vietnamobile - Self Package</title>
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
					<li><a href="#">Shop</a></li>
					<li><a href="#">Self Packages</a></li>
				</ul>
				<h1>Self Packages</h1>
			</div>
		</div>
	</div>
	
	<!--------------------------------- Self Packages ----------------------------------------------------------------------------->
	<div class="selfPackages">
		<div class="container">
			<div class="col-sm-8 col-sm-offset-2">
				
				<div class="nav-tabs-navigation">
					<div class="nav-tabs-wrapper">
						<ul class="nav nav-tabs" data-tabs="tabs">
							<li class="active">
								<a href="#DAILY" data-toggle="tab"><spring:message code="label.SelfPkg.Daily" text="Daily"/></a>
							</li>
							<li>
								<a href="#WEEKLY" data-toggle="tab"><spring:message code="label.SelfPkg.Weekly" text="Weekly"/></a>
							</li>
							<li>
								<a href="#MONTHLY" data-toggle="tab"><spring:message code="label.SelfPkg.Monthly" text="Monthly"/></a>
							</li>
						</ul>
					</div> <!-- .nav-tabs-navigation -->
				</div> <!-- .nav-tabs-wrapper -->
				<form:form method="post" id="frmSelfPkg" action="${pageContext.request.contextPath}/secure/selfpkg/register">
				<div class="selfPackages-content">
					<div class="tab-content text-center">
						<div class="tab-pane active" id="DAILY">
							<!-- amount -->
							<input type="hidden" name="total_amount_voice_onnet_daily" id="total_amount_voice_onnet_daily"/>
							<input type="hidden" name="total_amount_voice_offnet_daily" id="total_amount_voice_offnet_daily"/>
							<input type="hidden" name="total_amount_sms_onnet_daily" id="total_amount_sms_onnet_daily"/>
							<input type="hidden" name="total_amount_sms_offnet_daily" id="total_amount_sms_offnet_daily"/>
							<!-- money  -->
							<input type="hidden" name="total_money_voice_onnet_daily" id="total_money_voice_onnet_daily" value="0"/>
							<input type="hidden" name="total_money_voice_offnet_daily" id="total_money_voice_offnet_daily" value="0"/>
							<input type="hidden" name="total_money_sms_onnet_daily" id="total_money_sms_onnet_daily" value="0"/>
							<input type="hidden" name="total_money_sms_offnet_daily" id="total_money_sms_offnet_daily" value="0"/>
							<div class="sliderContentWrapper">
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOnNet" text="Voice OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_onnet_daily_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/> (<span id="total_money_voice_onnet_daily_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_onnet_daily"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOffNet" text="Voice OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_offnet_daily_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/> (<span id="total_money_voice_offnet_daily_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_offnet_daily"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOnNet" text="SMS OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_onnet_daily_ctr">0</span> (<span id="total_money_sms_onnet_daily_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_onnet_daily"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOffNet" text="SMS OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_offnet_daily_ctr">0</span> (<span id="total_money_sms_offnet_daily_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_offnet_daily"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								
							</div>
							
							<div class="card col-sm-6">
								<div class="col-xs-6 totalMoney-left">
									<spring:message code="label.Total" text="Total"/>
								</div>
								<div class="col-xs-6 totalMoney-right">
									<span id="total_money_daily_ctr"></span>₫
								</div>
							</div> <!-- .card -->

							<div class="renewWrapper">				
							</div>

							<div class="col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
								<div class="row">					
									<div class="col-xs-10">
										<button class="btn btn-primary btn-round" style="font-weight: bold; font-size: 18px"><spring:message code="label.OK" text="OK"/></button>
									</div>
								</div>
							</div>

						</div>
						
						<div class="tab-pane" id="WEEKLY">
							<input type="hidden" name="total_amount_voice_onnet_weekly" id="total_amount_voice_onnet_weekly"/>
							<input type="hidden" name="total_amount_voice_offnet_weekly" id="total_amount_voice_offnet_weekly"/>
							<input type="hidden" name="total_amount_sms_onnet_weekly" id="total_amount_sms_onnet_weekly"/>
							<input type="hidden" name="total_amount_sms_offnet_weekly" id="total_amount_sms_offnet_weekly"/>
							<!-- total money -->
							<input type="hidden" name="total_money_voice_onnet_weekly" id="total_money_voice_onnet_weekly" value="0"/>
							<input type="hidden" name="total_money_voice_offnet_weekly" id="total_money_voice_offnet_weekly" value="0"/>
							<input type="hidden" name="total_money_sms_onnet_weekly" id="total_money_sms_onnet_weekly" value="0"/>
							<input type="hidden" name="total_money_sms_offnet_weekly" id="total_money_sms_offnet_weekly" value="0"/>
							<div class="sliderContentWrapper">
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOnNet" text="Voice OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_onnet_weekly_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/>(<span id="total_money_voice_onnet_weekly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_onnet_weekly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOffNet" text="Voice OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_offnet_weekly_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/> (<span id="total_money_voice_offnet_weekly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_offnet_weekly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOnNet" text="SMS OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_onnet_weekly_ctr">0</span> (<span id="total_money_sms_onnet_weekly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_onnet_weekly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOffNet" text="SMS OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_offnet_weekly_ctr">0</span> (<span id="total_money_sms_offnet_weekly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_offnet_weekly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								
							</div>

							<div class="card col-sm-6">
								<div class="col-xs-6 totalMoney-left">
									<spring:message code="label.Total" text="Total"/>
								</div>
								<div class="col-xs-6 totalMoney-right">
									<span id="total_money_weekly_ctr"></span>₫
								</div>
							</div> <!-- .card -->

							<div class="renewWrapper">				
							</div>

							<div class="col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
								<div class="row">					
									<div class="col-xs-10">
										<button class="btn btn-primary btn-round" style="font-weight: bold; font-size: 18px"><spring:message code="label.OK" text="OK"/></button>
									</div>
								</div>
							</div>	
						</div>
						
						<div class="tab-pane" id="MONTHLY">
							<input type="hidden" name="total_amount_voice_onnet_monthly" id="total_amount_voice_onnet_monthly"/>
							<input type="hidden" name="total_amount_voice_offnet_monthly" id="total_amount_voice_offnet_monthly"/>
							<input type="hidden" name="total_amount_sms_onnet_monthly" id="total_amount_sms_onnet_monthly"/>
							<input type="hidden" name="total_amount_sms_offnet_monthly" id="total_amount_sms_offnet_monthly"/>
							<!-- total money -->
							<input type="hidden" name="total_money_voice_onnet_monthly" id="total_money_voice_onnet_monthly" value="0"/>
							<input type="hidden" name="total_money_voice_offnet_monthly" id="total_money_voice_offnet_monthly" value="0"/>
							<input type="hidden" name="total_money_sms_onnet_monthly" id="total_money_sms_onnet_monthly" value="0"/>
							<input type="hidden" name="total_money_sms_offnet_monthly" id="total_money_sms_offnet_monthly" value="0"/>
							<!-- total money no pkg -->
							<input type="hidden" name="total_money_nopkg_voice_onnet_monthly" id="total_money_nopkg_voice_onnet_monthly" value="0"/>
							<input type="hidden" name="total_money_nopkg_voice_offnet_monthly" id="total_money_nopkg_voice_offnet_monthly" value="0"/>
							<input type="hidden" name="total_money_nopkg_sms_onnet_monthly" id="total_money_nopkg_sms_onnet_monthly" value="0"/>
							<input type="hidden" name="total_money_nopkg_sms_offnet_monthly" id="total_money_nopkg_sms_offnet_monthly" value="0"/>
														
							<div class="sliderContentWrapper">
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOnNet" text="Voice OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_onnet_monthly_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/> (<span id="total_money_voice_onnet_monthly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_onnet_monthly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.VoiceOffNet" text="Voice OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="voice_offnet_monthly_ctr">0</span> <spring:message code="label.Minutes" text="Minutes"/> (<span id="total_money_voice_offnet_monthly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_voice_offnet_monthly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOnnet" text="SMS OnNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_onnet_monthly_ctr">0</span> (<span id="total_money_sms_onnet_monthly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_onnet_monthly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								<div class="row sliderTitle">
									<div class="col-xs-5 col-sm-3">
										<div class="sliderLabel"><spring:message code="label.SelfPkg.SmsOffNet" text="SMS OffNet"/>:</div>
									</div>
									<div class="col-xs-7 col-sm-6">
										<div class="sliderPoint"><span class="slider-range-value" id="sms_offnet_monthly_ctr">0</span> (<span id="total_money_sms_offnet_monthly_txt">0</span>₫)</div>
									</div>
								</div>
								<div class="slider col-xs-10" id="slider_sms_offnet_monthly"></div>
								<div class="col-xs-1" style="margin-top: 5px; padding: 0px;">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_minus.png" style="width: 20px; height: 20px">
								</div>
								<div class="col-xs-1" style="margin-top: 5px; margin-left: -40px ">
									<img src="${pageContext.request.contextPath}/static/assets/image/selfpackage_add.png" style="width: 20px; height: 20px">
								</div>
								
							</div>

							<div class="card">
								<div class="col-xs-6 totalMoney-left">
									<spring:message code="label.Total" text="Total"/>
								</div>
								<div class="col-xs-6 totalMoney-right">
									<span id="total_money_monthly_ctr"></span>₫
								</div>
								<div class="col-xs-12 divider"></div>	
								<div class="col-xs-6 totalMoney-left">
									<spring:message code="label.TotalIfNoPkg" text="Total If No Package"/>
								</div>
								<div class="col-xs-6 totalMoney-right">
									<span id="total_money_nopkg_monthly_ctr"></span>₫
								</div>
							</div> <!-- .card -->

							<div class="renewWrapper">
								
							</div>

							<div class="col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
								<div class="row">
									
									<div class="col-xs-10">
										<button id="btnSubmit" type="submit" class="btn btn-primary btn-round" style="font-weight: bold; font-size: 18px"><spring:message code="label.OK" text="OK"/></button>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
				<input type="hidden" name="selected_cycle" id="selected_cycle" value="daily">
				<input type="hidden" name="total_money_amount" id="total_money_amount" value="0">
				</form:form>
			</div>
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
<script src="${pageContext.request.contextPath}/static/assets/script/nouislider.min.js" type="text/javascript"></script>

<!--  Control for Material Kit -->
<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>

<script>

var lang = "${pageContext.request.locale.language}";

var voiceDailyIncr = parseInt("${COMMON_CONFIGS['VOICE_DAILY_INCR_VALUE']}");
var voiceDailyMaxVal = parseInt("${COMMON_CONFIGS['VOICE_DAILY_MAX_VALUE']}");
var smsDailyIncr = parseInt("${COMMON_CONFIGS['SMS_DAILY_INCR_VALUE']}");
var smsDailyMaxVal = parseInt("${COMMON_CONFIGS['SMS_DAILY_MAX_VALUE']}");

var voiceWeeklyIncr = parseInt("${COMMON_CONFIGS['VOICE_WEEKLY_INCR_VALUE']}");
var voiceWeeklyMaxVal = parseInt("${COMMON_CONFIGS['VOICE_WEEKLY_MAX_VALUE']}");
var smsWeeklyIncr = parseInt("${COMMON_CONFIGS['SMS_WEEKLY_INCR_VALUE']}");
var smsWeeklyMaxVal = parseInt("${COMMON_CONFIGS['SMS_WEEKLY_MAX_VALUE']}");

var voiceMonthlyIncr = parseInt("${COMMON_CONFIGS['VOICE_MONTHLY_INCR_VALUE']}");
var voiceMonthlyMaxVal = parseInt("${COMMON_CONFIGS['VOICE_MONTHLY_MAX_VALUE']}");
var smsMonthlyIncr = parseInt("${COMMON_CONFIGS['SMS_MONTHLY_INCR_VALUE']}");
var smsMonthlyMaxVal = parseInt("${COMMON_CONFIGS['SMS_MONTHLY_MAX_VALUE']}");

var sliderVoiceOnNetDaily = document.getElementById('slider_voice_onnet_daily');
var sliderVoiceOffNetDaily = document.getElementById('slider_voice_offnet_daily');
var sliderSmsOnNetDaily = document.getElementById('slider_sms_onnet_daily');
var sliderSmsOffNetDaily = document.getElementById('slider_sms_offnet_daily');

var sliderVoiceOnNetWeekly = document.getElementById('slider_voice_onnet_weekly');
var sliderVoiceOffNetWeekly = document.getElementById('slider_voice_offnet_weekly');
var sliderSmsOnNetWeekly = document.getElementById('slider_sms_onnet_weekly');
var sliderSmsOffNetWeekly = document.getElementById('slider_sms_offnet_weekly');

var sliderVoiceOnNetMonthly = document.getElementById('slider_voice_onnet_monthly');
var sliderVoiceOffNetMonthly = document.getElementById('slider_voice_offnet_monthly');
var sliderSmsOnNetMonthly = document.getElementById('slider_sms_onnet_monthly');
var sliderSmsOffNetMonthly = document.getElementById('slider_sms_offnet_monthly');

var priceMappings = JSON.parse('${PRICE_MAPPINGS}');

$(document).ready(function() {
	
    $("#DAILY").click(function(){
    	$("#selected_cycle").val("daily");
    });

    $("#WEEKLY").click(function(){
    	$("#selected_cycle").val("weekly");
    });

    $("#MONTHLY").click(function(){
    	$("#selected_cycle").val("monthly");
    });
	
	//daily slider
    noUiSlider.create(sliderVoiceOnNetDaily, {
        start: 0,
        step: voiceDailyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceDailyMaxVal
        }
    });
    attachEvent(sliderVoiceOnNetDaily, "voice_onnet_daily_ctr", "total_amount_voice_onnet_daily", 
    		"total_money_voice_onnet_daily_txt", "total_money_voice_onnet_daily", "", 'VOICE_ONNET', 0);
    
    noUiSlider.create(sliderVoiceOffNetDaily, {
        start: 0,
        step: voiceDailyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceDailyMaxVal
        }
    });
    attachEvent(sliderVoiceOffNetDaily, "voice_offnet_daily_ctr", "total_amount_voice_offnet_daily", 
    		"total_money_voice_offnet_daily_txt", "total_money_voice_offnet_daily", "", 'VOICE_OFFNET', 0);

    noUiSlider.create(sliderSmsOnNetDaily, {
        start: 0,
        step: smsDailyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsDailyMaxVal
        }
    });
    attachEvent(sliderSmsOnNetDaily, "sms_onnet_daily_ctr", "total_amount_sms_onnet_daily", 
    		"total_money_sms_onnet_daily_txt", "total_money_sms_onnet_daily", "", 'SMS_ONNET', 0);

    noUiSlider.create(sliderSmsOffNetDaily, {
        start: 0,
        step: smsDailyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsDailyMaxVal
        }
    });
    attachEvent(sliderSmsOffNetDaily, "sms_offnet_daily_ctr", "total_amount_sms_offnet_daily", "total_money_sms_offnet_daily_txt", 
    		"total_money_sms_offnet_daily", "", 'SMS_OFFNET', 0);

    //weekly slider
    noUiSlider.create(sliderVoiceOnNetWeekly, {
        start: 0,
        step: voiceWeeklyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceWeeklyMaxVal
        }
    });
    attachEvent(sliderVoiceOnNetWeekly, "voice_onnet_weekly_ctr", "total_amount_voice_onnet_weekly", 
    		"total_money_voice_onnet_weekly_txt", "total_money_voice_onnet_weekly", "", 'VOICE_ONNET', 1);
    
    noUiSlider.create(sliderVoiceOffNetWeekly, {
        start: 0,
        step: voiceWeeklyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceWeeklyMaxVal
        }
    });
    attachEvent(sliderVoiceOffNetWeekly, "voice_offnet_weekly_ctr", "total_amount_voice_offnet_weekly", 
    		"total_money_voice_offnet_weekly_txt", "total_money_voice_offnet_weekly", "", 'VOICE_OFFNET', 1);

    noUiSlider.create(sliderSmsOnNetWeekly, {
        start: 0,
        step: smsWeeklyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsWeeklyMaxVal
        }
    });
    attachEvent(sliderSmsOnNetWeekly, "sms_onnet_weekly_ctr", "total_amount_sms_onnet_weekly", 
    		"total_money_sms_onnet_weekly_txt", "total_money_sms_onnet_weekly", "", 'SMS_ONNET', 1);

    noUiSlider.create(sliderSmsOffNetWeekly, {
        start: 0,
        step: smsWeeklyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsWeeklyMaxVal
        }
    });
    attachEvent(sliderSmsOffNetWeekly, "sms_offnet_weekly_ctr", "total_amount_sms_offnet_weekly", 
    		"total_money_sms_offnet_weekly_txt", "total_money_sms_offnet_weekly", "", 'SMS_OFFNET', 1);   
    
    //monthly
    noUiSlider.create(sliderVoiceOnNetMonthly, {
        start: 0,
        step: voiceMonthlyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceMonthlyMaxVal
        }
    });
    attachEvent(sliderVoiceOnNetMonthly, "voice_onnet_monthly_ctr", "total_amount_voice_onnet_monthly", 
    		"total_money_voice_onnet_monthly_txt", "total_money_voice_onnet_monthly", "total_money_nopkg_voice_onnet_monthly", 'VOICE_ONNET', 2);
    
    noUiSlider.create(sliderVoiceOffNetMonthly, {
        start: 0,
        step: voiceMonthlyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': voiceMonthlyMaxVal
        }
    });
    attachEvent(sliderVoiceOffNetMonthly, "voice_offnet_monthly_ctr", "total_amount_voice_offnet_monthly", 
    		"total_money_voice_offnet_monthly_txt", "total_money_voice_offnet_monthly", "total_money_nopkg_voice_offnet_monthly", 'VOICE_OFFNET', 2);

    noUiSlider.create(sliderSmsOnNetMonthly, {
        start: 0,
        step: smsMonthlyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsMonthlyMaxVal
        }
    });
    attachEvent(sliderSmsOnNetMonthly, "sms_onnet_monthly_ctr", "total_amount_sms_onnet_monthly", 
    		"total_money_sms_onnet_monthly_txt", "total_money_sms_onnet_monthly", "total_money_nopkg_sms_onnet_monthly", 'SMS_ONNET', 2);

    noUiSlider.create(sliderSmsOffNetMonthly, {
        start: 0,
        step: smsMonthlyIncr,
        connect: 'lower',
        range: {
            'min': 0,
            'max': smsMonthlyMaxVal
        }
    });
    attachEvent(sliderSmsOffNetMonthly, "sms_offnet_monthly_ctr", "total_amount_sms_offnet_monthly", 
    		"total_money_sms_offnet_monthly_txt", "total_money_sms_offnet_monthly", "total_money_nopkg_sms_offnet_monthly", 'SMS_OFFNET', 2);   
    
    
    $("#frmSelfPkg").submit(function(e){
    	e.preventDefault();
    	
    	confirmRegister();
    });
    
    function attachEvent(slider, counterElementId, totalAmountElementId, totalMoneyTxtElementId, 
    		totalMoneyCtrElementId, totalMoneyNoPkgCtrElementId, type, cycle) {
    	
    	slider.noUiSlider.on('update', function( values, handle ) {
    		
    		var ctrValue = parseInt(values[handle]);
    		document.getElementById(counterElementId).innerHTML = ctrValue;
    		document.getElementById(totalAmountElementId).value = ctrValue;
    		
    		var priceMap = getPrice(type, cycle, ctrValue);
    		if (priceMap != null){
    			var priceValue = parseInt(priceMap.price) * ctrValue;
    			document.getElementById(totalMoneyTxtElementId).innerHTML = new Number(priceValue).toLocaleString(lang); //for showing amount of money
    			document.getElementById(totalMoneyCtrElementId).value = priceValue;
    			
    			if (cycle == 2){
    				document.getElementById(totalMoneyNoPkgCtrElementId).value = parseInt(priceMap.normalPrice) * ctrValue;
    			}
    		} else {
    			document.getElementById(totalMoneyTxtElementId).innerHTML = "0"; //for showing amount of money
    			document.getElementById(totalMoneyCtrElementId).value = 0;
    		}
    		
    		if (cycle == 0){
        		var totalDaily = parseInt(document.getElementById("total_money_voice_onnet_daily").value) + 
									parseInt(document.getElementById("total_money_voice_offnet_daily").value) + 
									parseInt(document.getElementById("total_money_sms_onnet_daily").value) + 
									parseInt(document.getElementById("total_money_sms_offnet_daily").value);

        		document.getElementById("total_money_daily_ctr").innerHTML = new Number(totalDaily).toLocaleString(lang);
        		
        		document.getElementById("total_money_amount").value = totalDaily;
        		
    		} else if (cycle == 1){
        		var totalWeekly = parseInt(document.getElementById("total_money_voice_onnet_weekly").value) + 
									parseInt(document.getElementById("total_money_voice_offnet_weekly").value) + 
									parseInt(document.getElementById("total_money_sms_onnet_weekly").value) + 
									parseInt(document.getElementById("total_money_sms_offnet_weekly").value);

        		document.getElementById("total_money_weekly_ctr").innerHTML = new Number(totalWeekly).toLocaleString(lang);
        		
        		document.getElementById("total_money_amount").value = totalWeekly;
    			
    		} else {
        		var totalMonthly = parseInt(document.getElementById("total_money_voice_onnet_monthly").value) + 
									parseInt(document.getElementById("total_money_voice_offnet_monthly").value) + 
									parseInt(document.getElementById("total_money_sms_onnet_monthly").value) + 
									parseInt(document.getElementById("total_money_sms_offnet_monthly").value);

        		document.getElementById("total_money_monthly_ctr").innerHTML = new Number(totalMonthly).toLocaleString(lang);
        		
        		document.getElementById("total_money_amount").value = totalMonthly;
        		
        		var totalNoPkgMonthly = parseInt(document.getElementById("total_money_nopkg_voice_onnet_monthly").value) + 
									parseInt(document.getElementById("total_money_nopkg_voice_offnet_monthly").value) + 
									parseInt(document.getElementById("total_money_nopkg_sms_onnet_monthly").value) + 
									parseInt(document.getElementById("total_money_nopkg_sms_offnet_monthly").value);
        		
        		document.getElementById("total_money_nopkg_monthly_ctr").innerHTML = new Number(totalNoPkgMonthly).toLocaleString(lang);
    		}
    	});
    }

    function getPrice(type, cycle, amount){
    	for (var i in priceMappings){
    		if (priceMappings[i].type == type && priceMappings[i].cycle == cycle 
    				&& amount >= priceMappings[i].minAmount && amount <= priceMappings[i].maxAmount){
    			
    			return priceMappings[i];
    		}
    	}
    }    
});

function confirmRegister(){
	var url = $("#frmSelfPkg").attr( "action" );
	BootstrapDialog.show({
		type: BootstrapDialog.TYPE_WARNING,
		title: '',
		message: '<spring:message code="Message.SelfPkg.ConfirmRegisterPackage" text="Are you sure you want to register?"/>',
		buttons: [{
				label: '<spring:message code="label.OK" text="OK"/>',
				cssClass: 'btn btn-primary btn-round',
				autospin: true,
				action: function(dialogRef){
							dialogRef.enableButtons(false);
		                	dialogRef.setClosable(false);
		                	dialogRef.getModalBody().html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.ProcessingRequest" text="Processing your request, please wait..."/>');
			                	    		
		            		$.post(url,	
		            			$("#frmSelfPkg").serialize()
		            			
		            		).done(function(data) {
			     				dialogRef.getModalBody().html(data.value);
			     				dialogRef.enableButtons(false);
			     				
			     				//reload page if registration was successful
			     				if (data.key == "1"){
			     					setTimeout(function(){
			     						location.reload();
				                    }, 2000);
			     				}
			     			}).fail(function(jqXHR, textStatus) {
			     				dialogRef.getModalBody().html('<spring:message code="Message.SelfPkg.RegisterFail" text="Your registration to package has failed."/>');
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
</script>

</body>
</html>
