<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
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
	<meta http-equiv="Pragma" content="no-cache">
 	<meta http-equiv="Cache-Control" content="no-cache">
 	<meta http-equiv="Expires" content="-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico?1">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png?1">

	<title>My Vietnamobile - Dashboard</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=77">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<!-- <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"> -->

	<script src="${pageContext.request.contextPath}/static/assets/script/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap.min.js" type="text/javascript"></script>
	<script>
	$(document).on('click', function (e) {
		
		$('[data-toggle="popover"],[data-original-title]').each(function () {
			if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            (($(this).popover('hide').data('bs.popover')||{}).inState||{}).click = false }
		});
	});
	</script>

</head>

<body>

<tiles:insertAttribute name="header"/>

<!-- Main Content -->
<div class="wrapper">
	<!-- Current locale code: ${pageContext.response.locale.language} -->
	<!-- Header -->
	<div class="header-dashboard"></div>
	<c:set var="avatarImage">
		<c:choose>
		<c:when test="${!empty userProfile and !empty userProfile.avatar}">${userProfile.avatar}</c:when>
		<c:otherwise>${pageContext.request.contextPath}/static/assets/image/default-avatar.png</c:otherwise>
		</c:choose>
	</c:set>
	<!-- Section: User Data -->
	<div class="col-sm-8 col-sm-offset-2">
		<div class="card card-raised">
			<div class="col-md-3 hidden-xs hidden-sm" id="avatarDesktop">
				<a href="javascript:;" data-toggle="modal" data-target="#fileUploadModal" data-backdrop="static" data-keyboard="false">
				<img src="${avatarImage}" alt="Avatar" class="img-responsive">
				</a>
			</div>
			<div class="visible-xs visible-sm" id="avatarMobile">
				<a href="javascript:;" data-toggle="modal" data-target="#fileUploadModal" data-backdrop="static" data-keyboard="false">
				<img src="${avatarImage}" alt="Avatar" class="img-responsive img-rounded img-raised">
				</a>
			</div>
			<div class="col-xs-12 col-md-6" id="userData">
				<h2>${userProfile.details.fullName}</h2>
				<h6>${userProfile.msisdn}</h6>
				<div class="userDataLabel">
					<span class="label userDataLabelDataType">${userProfile.classOfServiceName}</span>
					<!-- <span class="label userDataLabelDataType">${dataBalance.name}</span> -->
				</div>
			</div>
			<div class="col-xs-12 col-md-3" id="gameChar">
				<!-- <img src="${pageContext.request.contextPath}/static/assets/image/mons1.png" class="img-responsive"> -->
			</div>
		</div>
	</div>

	<!-- Section: Fatty Monster Details ------------------------------------------------------------------------------------------------------------>
	<div class="col-sm-8 col-sm-offset-2">
		<div class="card">
			<div class="col-xs-12 col-md-3" id="gameChar">
				<img src="${pageContext.request.contextPath}/static/assets/image/${petieMonsterImg}" class="img-responsive">
			</div>
			<div class="col-xs-12 col-md-9" style="text-align: center;" id="gameCharDetails">
				<h3 style="color: #FF6E00"><spring:message code="label.LoyaltyProgram" text="Loyalty Program"/></h3>
			</div>
			<div class="col-xs-12 col-md-9" style="text-align: center;" id="gameCharDetails">
				<hr>
			</div>
			<div class="col-xs-12 col-md-9" style="text-align: center;" id="gameCharDetails">
				<p><span style="font-weight: 600; font-size: 20px; color: #F57E20;"><spring:message code="label.Petie.Title" text="Petie"/> : ${petieMonsterWeight}kg</span></p>
			</div>
			<div class="col-xs-12 col-md-9" style="text-align: right; margin-top: 20px; padding-right:20px;" id="gameCharDetails">
				<a href="${pageContext.request.contextPath}/secure/petie" style="color: #FF6E00 "><spring:message code="label.Details" text="Details"/> >></a>
			</div>
		</div>
	</div>
	<!-------------------------------------------------------------------------------------------------------------------------------------------->

	<!-- ${currentBalance.coreBalance.expiryDate}, ${currentBalance.coreBalance.validityPeriod} -->
	<!-- Section: Status Details -->
	<c:set var="today" value="<%=new java.util.Date()%>" />
	<div class="col-sm-8 col-sm-offset-2">
		<div class="card">
			<div class="subCard col-sm-4" id="outstandingDetails">
				<h6 class="statusLabel">
					<a id="outstandingPopover" data-placement="top"><spring:message code="label.Postpaid.OutstandingBalance" text="Outstanding Balance"/> <i class="fa fa-angle-down"></i></a>
				</h6>
				<c:choose>
					<c:when test="${outstandingBalanceSize gt 0}">
						<div id="outstandingPopoverContent">
							<c:forEach items="${outstandingBalanceList}" var="outstanding" varStatus="ctr">
								<div class="statusDetail"><span class="wowText"><fmt:formatDate value="${outstanding.dueDateAsDate}" pattern="MMMMM yyyy"/></span></div>
								<div class="contentLeft">
									<p><spring:message code="label.Postpaid.Balance" text="Balance"/></p>
									<p><spring:message code="label.Postpaid.Status" text="Status"/></p>
									<p><spring:message code="label.Postpaid.PaymentDueDate" text="Due Date"/></p>
								</div>
								<div class="contentRight">
									<p><b><fmt:formatNumber value="${outstanding.amount}" pattern="#,##0"/>₫</b></p>
									<p style="font-size: 11px;"><b>${outstanding.status}</b></p>
									<p><b>${outstanding.dueDate}</b></p>
								</div>
								<div class="divider"></div><br/>
							</c:forEach>
							<div class="text-center">
								<!-- <c:if test="${currentBalance.outstandingBalance gt 0 }"></c:if> -->
								<button id="btnPayOutstanding" data-toggle="modal" data-target="#topupModal" class="btn btn-primary btn-round"><spring:message code="label.Pay" text="Pay"/></button>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="statusDetail">
							<p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="statusDetail" style="text-align: center;">
					<p><span class="wowText"><fmt:formatNumber value="${currentBalance.outstandingBalance}" pattern="#,##0"/>đ</span></p>
				</div>
			</div>
			<div class="subCard col-sm-4" id="unbilledDetails">
				<h6 class="statusLabel"><!-- role="button" data-toggle="popover" data-trigger="focus" -->
					<a id="unbilledPopover" data-placement="top" ><spring:message code="label.Postpaid.UnbilledAmount" text="Unbilled Balance"/> <i class="fa fa-angle-down"></i></a>
				</h6>
				<div id="unbilledPopoverContent">
					<div class="statusDetail"><span class="wowText"><fmt:formatDate value="${today}" pattern="MMMMM yyyy"/></span></div>
					<div class="contentLeft">
						<p><spring:message code="label.Postpaid.Balance" text="Balance"/></p>
						<p><spring:message code="label.Postpaid.FromDate" text="From Date"/></p>
						<p><spring:message code="label.Postpaid.ToDate" text="To Date"/></p>
					</div>
					<div class="contentRight">
						<p><b><fmt:formatNumber value="${unbilledBalance.totalAmount}" pattern="#,##0"/>₫</b></p>
						<p><b>${unbilledBalance.startDate}</b></p>
						<p><b>${unbilledBalance.endDate}</b></p>
					</div>
					<div class="divider"></div>
					<div class="text-center">
						<!-- <c:if test="${unbilledBalance.totalAmount gt 0}"></c:if> --> <!--   -->
						<button id="btnPayUnbilled" data-toggle="modal" data-target="#topupModal" class="btn btn-primary btn-round"><spring:message code="label.Pay" text="Pay"/></button>
					</div>
				</div>
				<div class="statusDetail" style="text-align: center;">
					<p><span class="wowText"><fmt:formatNumber value="${unbilledBalance.totalAmount}" pattern="#,##0"/>đ</span></p>
				</div>
			</div>
			<div class="subCard col-sm-4" id="dataDetails">
				<h6 class="statusLabel">
					<a id="dataPopover" data-placement="top"><spring:message code="label.Postpaid.DataUsage" text="Data Usage"/> <i class="fa fa-angle-down"></i></a>
				</h6>
				<c:choose>
					<c:when test="${dataBalanceListSize gt 0}">
						<div id="dataPopoverContent">
							<c:forEach items="${currentBalance.dataBalance.balanceList}" var="balance" varStatus="balanceCtr">
								<c:set var="balanceDisplayName">
									<c:choose><c:when test="${pageContext.response.locale.language eq 'en'}">${balance.displayNameEN}</c:when><c:otherwise>${balance.displayNameVI}</c:otherwise></c:choose>
								</c:set>
								<h5>${balanceDisplayName}</h5>
								<div class="contentLeft">
									<c:choose><c:when test="${balance.displayOption eq 'CONSUMED_VALUE'}"><p><spring:message code="label.Dashboard.DataConsumed" text="Consumption"/></p></c:when><c:otherwise><p><spring:message code="label.Dashboard.Remaining" text="Remaining"/></p></c:otherwise></c:choose>
									<p><spring:message code="label.Dashboard.Expired" text="Expired"/></p>
								</div>
								<c:set var="quotaInfo">
									<c:choose>
										<c:when test="${balance.serviceName eq 'facebook'}"><spring:message code="label.Free" text="Free"/></c:when>
										<c:otherwise>
											<c:choose><c:when test="${balance.displayOption eq 'CONSUMED_VALUE'}"><b><fmt:formatNumber value="${balance.consumedValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</b></c:when>
											<c:otherwise><b><fmt:formatNumber value="${balance.remainingValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</b></c:otherwise></c:choose>
										</c:otherwise>
									</c:choose>
								</c:set>
								<div class="contentRight">
									<p>${quotaInfo}</p>
									<p><b><fmt:formatDate value="${balance.endDate}" pattern="dd/MM/yyyy"/></b></p>
								</div>
								<c:if test="${balanceCtr.index < dataBalanceListSize - 1}"><div class="divider"></div></c:if>
							</c:forEach>
						</div>
						<div class="statusDetail" style="text-align: center;">
							<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/>: <span class="wowText"><fmt:formatNumber value="${currentBalance.dataBalance.availableValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</span></p>
						</div>

					</c:when>
					<c:otherwise>
						<div class="statusDetail">
							<p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<!-- Section: Shortcut -->
	<div class="col-sm-8 col-sm-offset-2" id="dashPage-shortcut">
		<div class="row">
			<a href="${pageContext.request.contextPath}/secure/account">
				<div class="subCard col-xs-4 col-sm-4">
					<div class="dashIcon">
						<i class="material-icons">info_outline</i>
					</div>
					<h6 class="statusLabel"><spring:message code="label.Dashboard.Detail" text="Detail"/></h6>
				</div>
			</a>
			<a href="${pageContext.request.contextPath}/secure/history">
				<div class="subCard col-xs-4 col-sm-4">
					<div class="dashIcon">
						<i class="material-icons">history</i>
					</div>
					<h6 class="statusLabel"><spring:message code="label.Dashboard.History" text="History"/></h6>
				</div>
			</a>
			<a href="javascript:;" data-toggle="modal" data-target="#topupModal">
				<div class="subCard col-xs-4 col-sm-4">
					<div class="dashIcon">
						<i class="material-icons">attach_money</i>
					</div>
					<h6 class="statusLabel"><spring:message code="label.Dashboard.Pay" text="Pay"/></h6>
				</div>
			</a>
		</div>
	</div>

	<!-- Section: Recommendation Article -->
	<div class="articleSection col-sm-12">
		<h3><spring:message code="label.Dashboard.Recommended" text="Recommended"/></h3>
		<c:forEach items="${recommendedProducts}" var="product">
		<div class="col-sm-4">
			<div class="articleSectionCard">
				<a href="${pageContext.request.contextPath}/shop/products/${product.productGroupId}"><img src="${product.mediumImage}"></a>
				<a href="${pageContext.request.contextPath}/shop/products/${product.productGroupId}"><h4>${utils:abbreviate(product.name, 35)}</h4></a>
				<p>${product.description}</p>
			</div>
		</div>
		</c:forEach>
		<!--
		<div class="articleSectionBtn col-sm-4 col-sm-offset-4">
			<button class="btn btn-primary btn-round"><spring:message code="label.Dashboard.SeeMore" text="See More"/></button>
		</div>
		-->
	</div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<!-- Main Content: End -->

<!-- Modal: Top Up -->
	<div class="modal fade" id="topupModal" tabindex="-1" role="dialog" aria-labelledby="topupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="topupModalLabel"><spring:message code="label.Postpaid.ChoosePaymentMethod" text="Choose Payment Method"/></h4>
				</div>
				<div class="modal-body">
					<a href="javascript:;" onclick="vtopup();">
						<div class="topupContentOption">
							<img src="${pageContext.request.contextPath}/static/assets/image/topupIcon-1.png">
							<p><spring:message code="label.Postpaid.FromScratchCard" text="From Scratch Card"/></p>
						</div>
					</a>
					<div class="sectionDivider"></div>
					<a href="#topupModal" data-toggle="collapse" data-target="#bankinAccContent">
						<div class="topupContentOption">
							<img src="${pageContext.request.contextPath}/static/assets/image/topupIcon-2.png">
							<p><spring:message code="label.Postpaid.FromBankAccount" text="From Debit/Credit Card"/> <i class="fa fa-caret-down"></i></p>
						</div>
					</a>
					<div id="bankinAccContent" class="collapse">
						<div id="topupInput">
							<div class="form-group label-floating has-success">
								<label class="control-label"><spring:message code="label.Postpaid.InputAmountToPay" text="Input Amount to Pay"/></label>
								<input type="number" id="paymentAmt" name="paymentAmt" value="${currentBalance.outstandingBalance}" class="form-control" />
							</div>
						</div>
						<div id="topupBtn">
							<button id="btnEtopUp" class="btn btn-primary btn-round"><spring:message code="label.Next" text="Next"/></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <div class="modal fade" id="fileUploadModal" tabindex="-1" role="dialog" aria-labelledby="fileUploadModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- <div class="modal-header text-center"></div> -->
				<div class="modal-body">
					<h4><spring:message code="label.SelectAvatarFile" text="Select file to upload"/></h4>
					<form:form id="avatarFrm" method="POST" enctype="multipart/form-data">
						<input type="file" id="avatarFile" name="avatarFile" accept="image/*">
					</form:form>
					<br/><p style="color: #f44336;" id="uploadMsg"></p>
				</div> <!-- .modal-body -->
				<div class="modal-footer">
					<!-- data-dismiss="modal" -->
					<button data-dismiss="modal" class="btn btn-primary btn-round"><spring:message code="label.Cancel" text="Cancel"/></button>
					<button id="btnUploadFile" class="btn btn-secondary btn-round"><spring:message code="label.Submit" text="Submit"/></button>
				</div>
			</div>
		</div>
	</div> --%>
	
	<div class="modal fade" id="fileUploadModal" tabindex="-1" role="dialog" aria-labelledby="fileUploadModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- <div class="modal-header text-center"></div> -->
				<%-- <div class="modal-body">
					<h4><spring:message code="label.SelectAvatarFile" text="Select file to upload"/></h4>
					<form:form id="avatarFrm" method="POST" enctype="multipart/form-data">
						<input type="file" id="avatarFile" name="avatarFile" accept="image/*">
					</form:form>
					<br/><p style="color: #f44336;" id="uploadMsg"></p>
				</div> --%>
				<div class="modal-body">
					<h4>
						<spring:message code="label.SelectAvatarFile"
							text="Select file to upload" />
					</h4>
					<%-- <form:form id="avatarFrm" method="POST" enctype="multipart/form-data">
                                         <input type="file" id="avatarFile" name="avatarFile" accept="image/*">
                                  </form:form> --%>

					<form id="fileForm">
						<input type="file" id="avatarFile" name="avatarFile"
							accept="image/x-png,image/jpeg,image/jpg,image/JPG,image/PNG"  onchange="readURL(this)" />

						<canvas id="cannn" height=400 width=400 style="display:none"></canvas>

					</form>
					<div id="imgContainer"></div>

							<p id="ImgsizeError"
								style="color: red; padding-left: 10px; display: none; font-size: 10px;">
								<spring:message code="label.AttachmentSizeAvatar"
									text="Attachment size exceeds the allowable limit 200 KB" />
							</p>


					<!--   <input type="file" id="avatarFile" name="avatarFile" accept="image/*" onchange="encodeImageFileAsURL(this)" />
                                         <input id="avatarFiledata" name="avatarFiledata" type="hidden" value=""> -->
					<br />
					<p style="color: #f44336;" id="uploadMsg"></p>
				</div>
				
				
				 <!-- .modal-body -->
				<%-- <div class="modal-footer">
					<!-- data-dismiss="modal" -->
					<button data-dismiss="modal" class="btn btn-primary btn-round"><spring:message code="label.Cancel" text="Cancel"/></button>
					<button id="btnUploadFile" class="btn btn-secondary btn-round"><spring:message code="label.Submit" text="Submit"/></button>
				</div> --%>
				
				<div class="modal-footer">
					<!-- data-dismiss="modal" -->
					<button id="btnClear" data-dismiss="modal"
						class="btn btn-primary btn-round">
						<spring:message code="label.Cancel" text="Cancel" />
					</button>
					<button id="btnUpload" class="btn btn-secondary btn-round">
						<spring:message code="label.Submit" text="Submit" />
					</button>
				</div>
			</div>
		</div>
	</div>
<input type="hidden" id="base64DatavId" value="">
	<input type="hidden" id="etopupOrderId" name="etopupOrderId" value="${sessionScope['ETOPUP_SESSION'].refTrxId}">
</body>

<!--   Core Script Files   -->
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
<script src="${pageContext.request.contextPath}/static/assets/script/ImageTools.js"	type="text/javascript"></script>

<script type="text/javascript">

	//var formData = null;
	var isJpg = function(name) {
		return name.match(/jpg$/i)
	};

	var isPng = function(name) {
		return name.match(/png$/i)
	};

	$(document).ready(function() {
						var file = $('[name="avatarFile"]');
						var imgContainer = $('#imgContainer');
						var uploadImg = $("#uploadMsg");
						uploadImg.html('');

						//formData = new FormData(document.getElementById("fileForm")) ;
						
						$('#btnUpload').on('click',function() {
											var filename = $.trim(file.val());
											 var base64dataval = document.getElementById("base64DatavId").value;
											
											 var payload = {            
													userImgBase64: base64dataval,   
													userImgName:filename
							                    };
											
											
											if (file.val() == "") {
												uploadImg
														.html('<spring:message code="Message.Avatar.NoFileSelected" text="Please select an image file."/>');
												return false;
											}

											if (!(isJpg(filename) || isPng(filename))) {

												uploadImg
														.html('<spring:message code="Message.Avatar.ExtensionIssue" text="Please select an image file."/>');

												//alert('Please browse a JPG/PNG file to upload ...');
												return false;
											}

											$('#btnUpload')
													.html(
															'<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.Uploading" text="Uploading..."/>');
											//$('#btnUpload').prop("disabled",true);

											$('#btnClear').hide();

											$.ajax({url : "${pageContext.request.contextPath}/secure/uploadavatar?${_csrf.parameterName}=${_csrf.token}",
																type : "POST",
																data : JSON.stringify(payload),
																contentType: "application/json",
																processData : false
																
															})
													.success(function(data) {
														file.val('');
														location.reload();

													})
													.error(
															function(jqXHR,
																	textStatus) {
																//alert(jqXHR.responseText);
																uploadImg
																		.html('<spring:message code="Message.Avatar.ExtensionIssue" text="Please select an image file."/>');
																alert('File upload failed ...');
															})
													.complete(
															function(data) {

																setTimeout(
																		function() {
																			// location.reload();

																			$(
																					'#btnUpload')
																					.html(
																							'<spring:message code="label.Submit" text="Submit"/>');
																			$(
																					'#btnUpload')
																					.prop(
																							"disabled",
																							false);

																			$(
																					"#uploadMsg")
																					.html(
																							'');

																			$(
																					'#btnClear')
																					.show();

																		}, 3000);

															});

										});

						$('#btnClear').on('click', function() {
							imgContainer.html('');
							file.val('');
							uploadImg.html('');
							//location.reload();
							 $('#ImgsizeError').hide();
							 $('#btnUpload').show();
							 $('#btnClear').show();
						});
						
						
						
						
						
						

					});
	
	function callback(base64data) {		
		document.getElementById("base64DatavId").value = base64data;
	}
	function rotateBase64ImageCust(base64data, callback) {
		//console.log("rotateBase64ImageCust INN  ");
		
	
	    var canvas = document.getElementById("cannn");
	    var ctx = canvas.getContext("2d");

	    var image = new Image();
	    image.src = base64data;
	    image.onload = function() {
	    	
	    	ctx.clearRect(0,0,canvas.width,canvas.height);
	        ctx.save();
	        ctx.translate(canvas.width/2,canvas.height/2);
	        ctx.rotate(90*Math.PI/180);
	        ctx.drawImage(image,-image.width/2,-image.width/2);
	        ctx.restore();      
	        
	        
	        window.eval(""+callback+"('"+canvas.toDataURL()+"')");
	    };

	}

	function getOrientation(file, callback) {
		  var reader = new FileReader();

		  reader.onload = function(event) {
		    var view = new DataView(event.target.result);

		    if (view.getUint16(0, false) != 0xFFD8) return callback(-2);

		    var length = view.byteLength,
		        offset = 2;

		    while (offset < length) {
		      var marker = view.getUint16(offset, false);
		      offset += 2;

		      if (marker == 0xFFE1) {
		        if (view.getUint32(offset += 2, false) != 0x45786966) {
		          return callback(-1);
		        }
		        var little = view.getUint16(offset += 6, false) == 0x4949;
		        offset += view.getUint32(offset + 4, little);
		        var tags = view.getUint16(offset, little);
		        offset += 2;

		        for (var i = 0; i < tags; i++)
		          if (view.getUint16(offset + (i * 12), little) == 0x0112)
		            return callback(view.getUint16(offset + (i * 12) + 8, little));
		      }
		      else if ((marker & 0xFF00) != 0xFF00) break;
		      else offset += view.getUint16(offset, false);
		    }
		    return callback(-1);
		  };

		  reader.readAsArrayBuffer(file.slice(0, 64 * 1024));
		};
	
	function readURL(input) {
	   console.log(input.files[0].size);
	   var actualSize=input.files[0].size;
	   
	   if (input.files && input.files[0]) {
		   //console.log("first");
				var readers = new FileReader();
				readers.onload = function(e) {
					//console.log("second");
					
					if(actualSize<2000)
					  { 
						getOrientation(input.files[0], function(orientation) {
							
							if(orientation==6)
							{	//console.log("third");						
								rotateBase64ImageCust(e.target.result, 'callback');
							} 
							else{
								document.getElementById("base64DatavId").value = e.target.result;
							}
							
						});
					  }
					else
						{
						ImageTools.resize(input.files[0], {
					        width: 400, // maximum width
					        height: 400 // maximum height
					    }, function(blob, didItResize) {					    		
					    	 var reader = new FileReader();
					   		 reader.readAsDataURL(blob); 
					   		 reader.onloadend = function() {
					   			var base64datas = reader.result;					   			
					   			getOrientation(input.files[0], function(orientation) {
									//alert(orientation);
									if(orientation==6)
									{									
									rotateBase64ImageCust(base64datas, 'callback');
									}
									else{
										document.getElementById("base64DatavId").value = base64datas;
									}
									
								  });
					   			}
							 });
						}
					
				}
				
				readers.readAsDataURL(input.files[0]);
	   }
	   
	    var actualSize = input.files[0].size;
	    if (actualSize > 10485760) {  //5242880 //3145728
		   // alert('ok');
		    
		    $('#ImgsizeError').show();
		    $('#btnUpload').hide();
		    //$('#btnClear').hide();
		    }
	    else
	    	{
	    	  $('#ImgsizeError').hide();
	    	  
	    	  $('#btnUpload').show();
			  //  $('#btnClear').show();
	    	}
	  }
	
	/* $(document).on(function() {
		  $('#avatarFile').on('change', function(evt) {
		    console.log(this.files[0].size);
		    
		    if (actualSize > 2000) {
		    alert('ok');
		    }
		    
		  });
		}); */

	
	
	


</script>




<script>
	var napasWin;

	var etopupOrderId = $("#etopupOrderId").val();
	if (etopupOrderId != ''){
		queryEtopupStatus(etopupOrderId);
	}

	$(document).ready(function() {

		$('body').on('hidden.bs.modal', '.modal', function () {
			  $(this).removeData('bs.modal');
		});

		$('body').on('shown.bs.modal', '.modal', function() {
			//$('[data-toggle="popover"],[data-original-title]').each(function () {
			$('.popover').each(function () {	
				//$('.popover')
				$(this).popover('hide');
			});
		});
		
 		$("#btnEtopUp").click(function(e){
 	 		e.preventDefault();
 	 		etopUp();
		});
 		
		$("#btnUploadFile").click(function(e){
			e.preventDefault();

			if ($("#avatarFile").val() == ""){
				$("#uploadMsg").html('<spring:message code="Message.Avatar.NoFileSelected" text="Please select an image file."/>');
				return false;
			}

			$(this).html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.Uploading" text="Uploading..."/>');
			$(this).prop("disabled", true);
			$("#uploadMsg").html('');

		    //var form = $('#avatarFrm')[0];
		    var formData = new FormData(document.getElementById("avatarFrm"));
		    formData.append("avatarFile", $("#avatarFile"));

		    $.ajax({
		        type: "POST",
		        enctype: 'multipart/form-data',
		        url: "${pageContext.request.contextPath}/secure/uploadavatar?${_csrf.parameterName}=${_csrf.token}",
		        data: formData,
		        processData: false, //prevent jQuery from automatically transforming the data into a query string
		        contentType: false,
		        cache: false,
		        timeout: 600000,
		        success: function (data) {
		        	console.log("response from svr= " + data);
					location.reload();
		        },
		        error: function (e) {
		        	$("#uploadMsg").html('<spring:message code="Message.Avatar.ErrorUpload" text="Error uploading file, please try again."/>');
		            console.log("Error uploading file: ", e);
		        }
		    });
		});
	});

	function closeNapasPage() {
		//alert(typeof(napasWin));
		//if (typeof(napasWin) != "undefined"){
		if (typeof(napasWin) == "object" && !napasWin.closed){
			napasWin.close();
		}
	}

    function queryEtopupStatus(orderId){
		//default trx timeout = 1800 * 1000 ms
		var checkInterval = 30 * 1000;

		var trxTimer = setInterval(function(){

			$.get("${pageContext.request.contextPath}/secure/epay/status/" + orderId
				).done(function(data) {
					var respcode = data.status;
					var msg = data.message;

					console.log("respcode = " + respcode + ", etopup_status: " + respcode + ", msg= " + msg);

					//PROCESSING, SUCCESS, FAIL, CANCELED, NOT_FOUND, ROLL_BACK, TIME_OUT;
					if (respcode != null && respcode != "PROCESSING"){
						$("#etopupOrderId").val('');
						clearInterval(trxTimer);

						closeNapasPage();

						if (respcode == "SUCCESS"){
							//success
							BootstrapDialog.show({
								title: '',
								type: BootstrapDialog.TYPE_INFO,
								message: msg
							});

							//location.reload();
							setTimeout(function(){
								location.reload();
		                    }, 3000);

						}  else {
							BootstrapDialog.show({
								title: '',
								type: BootstrapDialog.TYPE_WARNING,
								message: msg
							});
						}

					}

				}).fail(function(e) {
					console.log("Error querying trx status: " + e);
				});

		}, checkInterval);
	}

    function vtopup(){
    	location.replace("${pageContext.request.contextPath}/secure/scardbillpmt");
    }

	function etopUp(){
		var msisdn = "${userProfile.msisdn}";
		var amount = $("#paymentAmt").val();
		var _url = "${pageContext.request.contextPath}/secure/epay/init/" + msisdn + "/" + amount + "/1";

	    //napasWin = window.open('', '_blank');
		if(typeof(napasWin) == "undefined" || (typeof(napasWin) == "object" && napasWin.closed)){
            napasWin = window.open('', '_blank', '', true);
	    }

		$.get(_url).done(function(data){
			var orderId = data;
			console.log("--- receiving orderId: " + orderId);

			if (orderId != "" && orderId != "-1" && orderId != undefined){
				$("#etopupOrderId").val(orderId);
				$('#topupModal').modal('hide');

				var pmtURL = "${pageContext.request.contextPath}/secure/epay/pay/" + orderId;
				queryEtopupStatus(orderId);

		        napasWin.location.href = pmtURL;
				napasWin.focus();

			} else {
				console.log("Could not initiate eTopup");
				BootstrapDialog.show({
					title: '',
					type: BootstrapDialog.TYPE_WARNING,
					//btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
					message: '<spring:message code="Message.Payment.Fail" text="Payment unsuccessful, please try again."/>'
				});
			}

		}).fail(function(){
			console.log("Could not initiate eTopup");
			BootstrapDialog.show({
				title: '',
				type: BootstrapDialog.TYPE_WARNING,
				//btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
				message: '<spring:message code="Message.Payment.Fail" text="Payment unsuccessful, please try again."/>'
			});
		});
	}

	function setTopupAmount(amount){
		document.getElementById("selectedTopupAmt").value = amount;
	}

	function selectXtraData(productCode){
		document.getElementById("xproductCode").value = productCode;
	}

	function callus(){
		window.location.href="callto:${contactus_phoneno}";
	}

	function mailus(){
		window.location.href="mailto:${contactus_email_addr}?subject=${contactus_email_subject} [${userProfile.msisdn}]";
	}

	function popupBlocked(){
		var host = window.location.hostname;
		var prot = window.location.protocol;
		var loc = "about:blank";
		var win = window.open(loc, "", "height=100,width=100");
		console.log("#popupBlocked -- test win= " + typeof(win));
		if (typeof(win) == "undefined"){
			return true;
		} else {
			win.close();
			return false;
		}
	}

</script>
</html>
