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

	<title>My Vietnamobile - Petie Monster</title>
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
	
	<!-- Breadcrumb -->
	<div class="container-fluid">
		<div class="col-sm-11 col-sm-offset-1" style="padding: 0;">
			<ul class="mod-breadcrumb gamify">
				<li><a href="${pageContext.request.contextPath}/secure/dashboard"><spring:message code="label.TopMenu.Home" text="Home"/></a></li>
				<li><a href="#">Petie</a></li>
			</ul>
		</div>
	</div>

	<!--------- Petie Monster --------->
	<div class="gamifyMonsters">
		<div class="container-fluid">
				<div class="row">
				<div class="nav-tabs-navigation">
					<div class="nav-tabs-wrapper">
						<ul class="nav nav-tabs" data-tabs="tabs">
							<li class="active">
								<a href="#monsters" data-toggle="tab"><spring:message code="label.Petie.MyMonsters" text="My Monsters"/></a>
							</li>
							<li>
								<a href="#rewards" data-toggle="tab"><spring:message code="label.Petie.Rewards" text="Rewards"/></a>
							</li>
						</ul>
					</div> <!-- .nav-tabs-navigation -->
				</div> <!-- .nav-tabs-wrapper -->
				</div>
				<!-- to level up: ${remainingPointToLevelUp} -->
				<div class="gamifyMonsters-content">
					<div class="tab-content">
						<!-- Tab: My Monsters -->
						<div class="tab-pane active" id="monsters">
							<!-- Slider -->
							<div class="row">
									 <div class="col-md-4 col-sm-offset-4" >
											<div class="carousel__slide glide__slide">
												<div class="card text-center">
													<h6><spring:message code="label.Petie.Title" text="Petie"/></h6>
													<p class="level"><spring:message code="label.Petie.Level" text="Level"/> ${petieLevel}</p>
													<p class="weight">${petieMonsterWeight}kg</p>
													<img src="${pageContext.request.contextPath}/static/assets/image/${petieMonsterImg}" style="width:168px; height: 155px;">
													<div class="progress">
														<div class="progress-bar" role="progressbar" aria-valuenow="${petieMonsterWeight}" aria-valuemin="0" aria-valuemax="${MAX_MONSTER_WEIGHT}" style="width: 0%;">
														</div>
													</div>
													<c:choose>
														<c:when test="${petieMonsterWeight gt MAX_MONSTER_WEIGHT}"><p class="advice"><spring:message code="label.Petie.Full" text="I am already full and healthy"/></p></c:when>
														<c:otherwise><p class="advice"><spring:message code="label.Petie.NeedMore" arguments="${remainingPointToLevelUp}" text="I need ${remainingPointToLevelUp} to get more bigger" /></p></c:otherwise>
													</c:choose>
												</div>
											</div>
									</div>
							</div> <!-- .row -->

							<div class="text-center" id="howModal" style="margin: 5px 0 25px;" data-toggle="modal" data-target="#howModalContent">
								<a href="#">
									<spring:message code="label.Petie.HowToGetWeight" text="How to get weight"/>?
								</a>
							</div>
						</div> <!-- .tab-pane -->
						<!--  ${tatalGift} || min: ${MIN_MONSTER_WEIGHT} || max: ${MAX_MONSTER_WEIGHT} -->
						<!-- Tab: Rewards -->
						<div class="tab-pane" id="rewards">
							<div class="col-sm-8 col-sm-offset-2">
								<div class="row">
									<!-- Left Section -->
									<div class="col-md-6">
										<div class="card">
											<h6><spring:message code="label.Petie.Title" text="Petie"/></h6>
											<img src="${pageContext.request.contextPath}/static/assets/image/${petieMonsterImg}" id="monster" style="width:168px; height: 155px;">
											<p>${petieMonsterWeight}kg</p>
											<div class="divider"></div>
											<div class="row">
												<div class="col-xs-6">
													<div id="giftTitle">
														<spring:message code="label.Petie.TotalGiftYouCanReceive" text="Total gift you can receive"/>
													</div>
												</div>
												<div class="col-xs-6">
													<div id="giftImage">
														<img src="${pageContext.request.contextPath}/static/assets/image/giftBox.png">
													</div>
													<div id="giftControl">
														<a href="#">
															<i class="material-icons">highlight_off</i>
														</a>
														<span id="totalGiftContainer">${tatalGift}</span>
													</div>
												</div>
											</div> <!-- .row -->
										</div> <!-- .card -->
										<div id="cardNote">
											<spring:message code="label.Petie.Note" text="Note: for every gift you receive, the weight of your monster will be deducted by 5kg. The minimum weight is 5kg."/>
										</div> <!-- #cardNote -->
									</div> <!-- .col-md-6 -->
									
									<c:if test="${petieMonsterWeight le MIN_MONSTER_WEIGHT}"><c:set var="input_ctrl_toggle" value="disabled"/></c:if>
									<!-- Right Section -->
									<div class="col-md-6">
										<form:form method="post" id="frmRedeem" action="${pageContext.request.contextPath}/secure/petie/redeem">
										<div id="rewards-right">
											<table class="table">
												<tbody>
													<tr>
														<td><fmt:formatNumber value="${ KEYWORD_MAPPINGS['CASHBACK'] }" pattern="#,##0"/> ₫</td>
														<td class="td-actions text-center">
															<i class="material-icons">close</i>
															<button type="button" class="btn btn-simple" id="btnCashbackMin" style="margin-left: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">remove_circle_outline</i>
															</button>
															<input id="CASHBACK" name="CASHBACK" type="number" value="0" min="0" ${input_ctrl_toggle}>
															<button type="button" class="btn btn-simple" id="btnCashbackPlus" style="margin-right: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">add_circle_outline</i>
															</button>
															<i class="material-icons">arrow_forward</i>
														</td>
														<td class="text-right"><span id="totalCashback">0</span> ₫</td>
													</tr>
													<tr>
														<td>${ KEYWORD_MAPPINGS['SMS'] } SMS</td>
														<td class="td-actions text-center">
															<i class="material-icons">close</i>
															<button type="button" class="btn btn-simple" id="btnSmsMin" style="margin-left: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">remove_circle_outline</i>
															</button>
															<input id="SMS" name="SMS" type="number" value="0" min="0" ${input_ctrl_toggle}>
															<button type="button" class="btn btn-simple" id="btnSmsPlus" style="margin-right: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">add_circle_outline</i>
															</button>
															<i class="material-icons">arrow_forward</i>
														</td>
														<td class="text-right"><span id="totalSMS">0</span> SMS</td>
													</tr>
													<tr>
														<td>${ KEYWORD_MAPPINGS['VOICE'] } Min</td>
														<td class="td-actions text-center">
															<i class="material-icons">close</i>
															<button type="button" class="btn btn-simple" id="btnVoiceMin" style="margin-left: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">remove_circle_outline</i>
															</button>
															<input id="VOICE" name="VOICE" type="number" value="0" min="0" ${input_ctrl_toggle}>
															<button type="button" class="btn btn-simple" id="btnVoicePlus" style="margin-right: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">add_circle_outline</i>
															</button>
															<i class="material-icons">arrow_forward</i>
														</td>
														<td class="text-right"><span id="totalVoice">0</span> Min</td>
													</tr>
													<tr style="border-bottom: 1px solid #EBEBEB;">
														<td>${ KEYWORD_MAPPINGS['DATA'] } MB</td>
														<td class="td-actions text-center">
															<i class="material-icons">close</i>
															<button type="button" class="btn btn-simple" id="btnDataMin" style="margin-left: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">remove_circle_outline</i>
															</button>
															<input id="DATA" name="DATA" type="number" value="0" min="0" ${input_ctrl_toggle}>
															<button type="button" class="btn btn-simple" id="btnDataPlus" style="margin-right: 10px;" ${input_ctrl_toggle}>
																<i class="material-icons">add_circle_outline</i>
															</button>
															<i class="material-icons">arrow_forward</i>
														</td>
														<td class="text-right"><span id="totalData">0</span> MB</td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<td style=" font-size: 14px; width:50%"><spring:message code="label.Petie.RemainingGift" text="Remaining Gift"/></td>

														<td class="td-actions text-center">
															<input type="number" id="remainingGift" value="${tatalGift}" readonly="readonly">
														</td>
														<td class="text-right">
															<button id="btnRedeem" type="submit" class="btn btn-primary btn-round" ${input_ctrl_toggle}><spring:message code="label.Petie.Redeem" text="Reedem"/></button>
														</td>
													</tr>
												</tfoot>
											</table>
										</div> <!-- .rewards-right -->
										</form:form>
									</div> <!-- .col-md-6 -->

								</div> <!-- .row -->

							</div> <!-- .col-sm-8.col-sm-offset-2 -->
						</div> <!-- .tab-pane -->

					</div> <!-- .tab-content -->
				</div> <!-- .petieMonsters-content -->

		</div> <!-- .container-fluid -->
	</div> <!-- .petieMonsters -->
	
	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

	<div class="modal fade" id="howModalContent" tabindex="-1" role="dialog" aria-labelledby="howModalContentLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h1><spring:message code="label.Petie.HowToGetWeight" text="How to get weight"/></h1>
				</div>
				<div class="modal-body">
					<ol>
						<li><spring:message code="label.Petie.HowToGetWeightStep1" text="Each 1,000₫ top up, get 0.1kg"/></li>
						<li><spring:message code="label.Petie.HowToGetWeightStep2" text="Each 1,000₫ spending, get 0.05kg"/></li>
						<li><spring:message code="label.Petie.HowToGetWeightStep3" text="Each special events (Birthday, New Year, National Day, Birthday of Monster Club, Lunar New Year, 30/4, 1/5), get 1kg"/></li>
					</ol>
				</div> <!-- .modal-body -->
			</div>
		</div>
	</div>
	
	<input type="hidden" id="tatalGift" value="${tatalGift}"/>
	<input type="hidden" id="CASHBACK_MULTIPLIER" value="${ KEYWORD_MAPPINGS['CASHBACK'] }"/>
	<input type="hidden" id="DATA_MULTIPLIER" value="${ KEYWORD_MAPPINGS['DATA'] }"/>
	<input type="hidden" id="SMS_MULTIPLIER" value="${ KEYWORD_MAPPINGS['SMS'] }"/>
	<input type="hidden" id="VOICE_MULTIPLIER" value="${ KEYWORD_MAPPINGS['VOICE'] }"/>
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

var lang = "${pageContext.request.locale.language}";

$(document).ready(function() {
	
	$('.progress-bar').each(function() {
		  var min = $(this).attr('aria-valuemin');
		  var max = $(this).attr('aria-valuemax');
		  var now = $(this).attr('aria-valuenow');
		  var siz = (now-min)*100/(max-min);
		  $(this).css('width', siz+'%');
	});
	
	$("#CASHBACK").change(function(){
		var count = parseInt($(this).val());
		if (count > 0){
			$("#btnRedeem").prop("disabled", false);
		} else {
			$("#btnRedeem").prop("disabled", true);
		}
	});
	
	$("#SMS").change(function(){
		var count = parseInt($(this).val());
		if (count > 0){
			$("#btnRedeem").prop("disabled", false);
		} else {
			$("#btnRedeem").prop("disabled", true);
		}
	});
	
	$("#VOICE").change(function(){
		var count = parseInt($(this).val());
		if (count > 0){
			$("#btnRedeem").prop("disabled", false);
		} else {
			$("#btnRedeem").prop("disabled", true);
		}
	});
	
	$("#DATA").change(function(){
		var count = parseInt($(this).val());
		if (count > 0){
			$("#btnRedeem").prop("disabled", false);
		} else {
			$("#btnRedeem").prop("disabled", true);
		}
	});
	
	$("#frmRedeem").submit(function(e){
		e.preventDefault();
		
		$("#btnRedeem").prop("disabled", true);
		
		var url = $("#frmRedeem").attr( "action" );    		
		$.post(url,	
			$("#frmRedeem").serialize()
			
		).done(function(data){
			console.log("success count: " + data);
			
    		$("#btnRedeem").prop("disabled", false);
    		if (data > 0){
    			BootstrapDialog.alert({
    				message: '<spring:message code="Message.Petie.RedeemSuccessful" text="You have successfully redeemed your point(s)."/>',
    				callback: function(result){
    					location.replace("${pageContext.request.contextPath}/secure/petie");
    				}
    			});
    		} else {
    			BootstrapDialog.alert('<spring:message code="Message.Petie.RedeemFailed" text="Your request could not be processed, please try again."/>');
    		}
		});
	});
	
	var cashback = parseFloat($("#CASHBACK").val());
	if (isNaN(cashback)) {
		$("#CASHBACK").val("0");
		cashback = 0;
	}
	
	//cashback
	$("#btnCashbackMin").click(function(){
		roll("CASHBACK", false);
		
		var total = new Number(getCurrentValue("CASHBACK") * $("#CASHBACK_MULTIPLIER").val()).toLocaleString(lang);
		$("#totalCashback").html(total);
		
		if (getCurrentValue("tatalGift") < new Number("${tatalGift}")){
			roll("tatalGift", true);	
		}
		
		$("#remainingGift").val(getCurrentValue("tatalGift"));
	});
	$("#btnCashbackPlus").click(function(){
		if (getCurrentValue("tatalGift") > 0){
			roll("CASHBACK", true);
			var total = new Number(getCurrentValue("CASHBACK") * $("#CASHBACK_MULTIPLIER").val()).toLocaleString(lang);
			$("#totalCashback").html(total);
			
			roll("tatalGift", false);
			$("#remainingGift").val(getCurrentValue("tatalGift"));
		}
	});
	
	//sms
	$("#btnSmsMin").click(function(){
		
		roll("SMS", false);
		
		var total = new Number(getCurrentValue("SMS") * $("#SMS_MULTIPLIER").val()).toLocaleString(lang);
		$("#totalSMS").html(total);
		
		if (getCurrentValue("tatalGift") < new Number("${tatalGift}")){
			roll("tatalGift", true);	
		}
		
		$("#remainingGift").val(getCurrentValue("tatalGift"));

	});
	$("#btnSmsPlus").click(function(){
		if (getCurrentValue("tatalGift") > 0){
			roll("SMS", true);
			var total = new Number(getCurrentValue("SMS") * $("#SMS_MULTIPLIER").val()).toLocaleString(lang);
			$("#totalSMS").html(total);
			
			roll("tatalGift", false);
			$("#remainingGift").val(getCurrentValue("tatalGift"));
		}
	});
	
	//voice
	$("#btnVoiceMin").click(function(){
		
		roll("VOICE", false);
		
		var total = new Number(getCurrentValue("VOICE") * $("#VOICE_MULTIPLIER").val()).toLocaleString(lang);
		$("#totalVoice").html(total);
		
		if (getCurrentValue("tatalGift") < new Number("${tatalGift}")){
			roll("tatalGift", true);	
		}
		
		$("#remainingGift").val(getCurrentValue("tatalGift"));

	});
	$("#btnVoicePlus").click(function(){
		if (getCurrentValue("tatalGift") > 0){
			roll("VOICE", true);
			var total = new Number(getCurrentValue("VOICE") * $("#VOICE_MULTIPLIER").val()).toLocaleString(lang);
			$("#totalVoice").html(total);
			
			roll("tatalGift", false);
			$("#remainingGift").val(getCurrentValue("tatalGift"));
		}
	});	
	
	//data
	$("#btnDataMin").click(function(){
		
		roll("DATA", false);
		
		var total = new Number(getCurrentValue("DATA") * $("#DATA_MULTIPLIER").val()).toLocaleString(lang);
		$("#totalData").html(total);
		
		if (getCurrentValue("tatalGift") < new Number("${tatalGift}")){
			roll("tatalGift", true);	
		}
		
		$("#remainingGift").val(getCurrentValue("tatalGift"));

	});
	$("#btnDataPlus").click(function(){
		if (getCurrentValue("tatalGift") > 0){
			roll("DATA", true);
			var total = new Number(getCurrentValue("DATA") * $("#DATA_MULTIPLIER").val()).toLocaleString(lang);
			$("#totalData").html(total);
			
			roll("tatalGift", false);
			$("#remainingGift").val(getCurrentValue("tatalGift"));
		}
	});	
		
});

function updateDisplay(elementId, value){
	$("#" + elementId).html(value);	
}

function getCurrentValue(elementId){
	
	var currentValue = parseFloat($("#" + elementId).val());
	if (isNaN(currentValue)) {
		$("#" + elementId).val("0");
		currentValue = 0;
	}
	
	return new Number(currentValue);
}

function roll(elementId, up){
	var currentValue = getCurrentValue(elementId);
	if (up){
		currentValue++;
	} else{
		currentValue > 0 ? currentValue-- : 0;
	}
	$("#" + elementId).val(currentValue);
}

</script>

</html>