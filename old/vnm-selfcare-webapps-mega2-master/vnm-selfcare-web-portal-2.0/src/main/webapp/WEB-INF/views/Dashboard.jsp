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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/customize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/slick-theme.css">
    
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
	
	//mic close the mic popup
	function hidepopup() {
		$('.popup').hide();
	}
	function closepopup() {
		$('.offer-popup').hide();
	}
	</script>

<style type="text/css">
.mask {
	height: 100%;
	width: 100%;
	background: #00000085;
	z-index: 9999;
	position: fixed;
	top: 0;
	display: none;
}
.popover-content .contentLeft {
    float: left;
    margin-right: 60px!important;
}

.textInCircle {
    border: 1px solid #FF6E00;
    border-radius: 50%;
    width: 75px!important;
    height: 75px!important;
    text-align: center;
    vertical-align: middle;
    margin: 20px auto;
}

.textInCircle h6 {
    font-weight: 600;
    color: #FF6E00;
    font-size: 12px!important;
    margin-top: 22px!important;
}
.masking {
	background: rgba(255, 255, 255, 0.3);
	position: fixed;
	height: 100%;
	width: 100%;
	z-index: 99999;
}
</style>
<style type="text/css">
	.popup-body label {
    font-weight: 600;
    font-size: 18px;
    letter-spacing: 0.09px;
    color: #ff6e01;
    margin-bottom: 5px; 
    }
	
.form-group .form-control{margin-bottom:0!important;}

.form-group, .form-group .form-control {
    float: none;
    padding: 0;
    border: 0;
    border-radius: 0;
    background-image: linear-gradient(#f58233, #f58233), linear-gradient(#D2D2D2, #D2D2D2);
    background-size: 0 2px, 100% 1px;
    background-repeat: no-repeat;
    background-position: center bottom, center calc(100% - 1px);
    background-color: transparent;
    transition: background 0s ease-out;
    box-shadow: none;
    margin:0 auto;
}

.input-group .input-group-addon {
  padding: 0px 8px 0px;
}

.fatty{
	text-align:center;
}

.fatty img{
	width:60%;
	margin:15px 0;
}

.redumption{
	padding:10px 0 0 0;
}

.expiry{
	color:red;
}

.weight{
	color:#000000;
}

.redeem-btn{
	background:#FF6E00!important;
	color:#ffffff!important;
	padding: 8px 25px;
}

.fatty-popup{
	position:fixed;
	width:40%;
	top:50%;
	left:50%;
	transform:translate(-50%, -50%);
	background:#ffffff;
	display:none;
	z-index:9999!important;
	text-align:center;
	box-shadow: 0px 0px 10px 4px #6b6b6b;
    border-radius: 20px;
    padding: 20px 0;
}

.fattyclose{
	position:absolute;
	top:0; right:0;
}

@media screen and (max-width: 768px)
	{
		.offer-popup{
			width:85%!important;
		}
	}
	
	@media screen and (min-width: 320px) and (max-width: 640px)
	{
		.slick-slide img{
			height:500px!important;
		}
	}

	.footer {
    
    color: #9B9B9B!important;
  
}

</style>



<script type="text/javascript">
	/* $('#convert').click(function(){
	  $('.loader, .overlay').show();      
	  return false();  
	}) */

	function showLoader() {
		//alert("hello");
		$('.loader, .masking').show();
		return false;
	}
	function hideLoader() {
		$('.loader, .masking').hide();
		return true;
	}
</script>

</head>
 

<body>
<div class="mask"></div>
<tiles:insertAttribute name="header"/>


<div class="fatty-popup">
	<div class="close" >
            <a href="#" title="close" style="color:#757575!important;" class="fattyclose" ><i class="fa fa-close"></i></a>
        </div>
	<figure style="margin-bottom:20px;"><img src="${fattyDetails.fattyImageUrl}"></figure>
	<c:if test="${fattyDetails.avilableForRedeem==true}"><a href="javascript:void(0);" class="btn redeem-btn" id="redeemoffer">Redeem</a></c:if>
	<c:if test="${fattyDetails.avilableForRedeem==false}"><a href="javascript:void(0);" class="btn redeem-btn" pointer-events: none; >Redeem</a></c:if>
</div>

<!-- Main Content -->
<div class="wrapper">
	<!-- Current locale code: ${pageContext.response.locale.language} -->
	
	<div class="wrapper">
<!-- Popup  -->
<div id ="closePopup" class="col-sm-3 popup switchpopup" style="display: none; background:#ffffff!important;">
        <div class="close"  >
            <a href="#" title="close" style="color:#757575!important;" id="switchclose" onclick="cosePopup();" ><i class="fa fa-close"></i></a>
        </div>
 
        <div class="popup-body">
        <label><spring:message code="label.EnterYourPassword" text="Enter Your Password"/></label>
           <div class="form-group col-sm-10">
									
									<br clear="all">
									<div class="input-group">
										<span class="input-group-addon">
											<img src="${pageContext.request.contextPath}/static/assets/image/form-icon-lock.png">
										</span>
										<input class="form-control" type="password" id="passwordmsisdn" name="passwordmsisdn" autocomplete="off" placeholder="<spring:message code="label.Password" text="Password"/>"  style="background-image:none!important;">
										
										
									</div>
									
								<span class="material-input"></span></div>
								<span id="statusResponseNotOk" style="display: none"><spring:message code="label.Notupdatesecurity" text="Not Updated Try Again"/></span>
								<span id="statusResponseMismatch" style="display: none"><spring:message code="label.passwordMismatch" text="Password Mismatch"/></span>
        </div>
 
        <form>
            <button id="historySecurityIdSubmit" type="button" class="btn btn-default proceed" ><spring:message code="label.Submit" text="Submit"/></button>
            
        </form>
    </div>
	
	<!-- slider popup -->
<div class="col-md-5 offer-popup" style="display: none;" >
    
    <div class="popup-close" onclick="closepopup()"><a href="#" id="popupbannerId"><i class="fa fa-close fa-1x"></i></a></div>
    
    <div class="slick-popup">
    
    <c:forEach items="${popupBannerData}" var="popupBanner">
        <div class="slick-item">
            <figure>
            
            <a href="${popupBanner.detail_url}" target="_blank"><img src="${popupBanner.mediumImage}"></a>
            </figure>
            <div class="shope-btn">
            <h4><a href="${popupBanner.detail_url}" target="_blank">Shop Online</a></h4>
            </div>
        </div>
        </c:forEach>
        
        
        
    
    </div>
    
</div>  

	
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
		<div class="card" style="display: none;">
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
	
	
	
	<%-- <div class="col-sm-8 col-sm-offset-2">
		
		<div class="card">
			
			<div class="col-sm-4">
				<div class="fatty">
					<img src="${pageContext.request.contextPath}/static/assets/image/pack100.png">
				</div>
			</div>
			
			<div class="col-sm-8">
				<div class="redumption">
					<h4 class="expiry"><img src="${pageContext.request.contextPath}/static/assets/image/01.png"> Expired on ${fattyDetails.remainingDays} days!</h4>
					<h4 class="weight"><img src="${pageContext.request.contextPath}/static/assets/image/02.png">Weight : ${fattyDetails.weight}</h4>
					
					    <a href="javascript:void(0);" class="btn redeem-btn" id="redeem">Redeem</a>
						
				</div>
			</div>
			
		</div>
		
	</div> --%>
	
	
	
	<!-- ${currentBalance.coreBalance.expiryDate}, ${currentBalance.coreBalance.validityPeriod} -->
	<!-- Section: Status Details -->
	<div class="col-sm-8 col-sm-offset-2">
		<div class="card">
			<div class="subCard col-sm-4">
				<h6 class="statusLabel"><spring:message code="label.Dashboard.MainBalance" text="Main Balance"/></h6>
				<div class="statusDetail" style="text-align: center;">
					<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/>: <span class="wowText"><fmt:formatNumber value="${currentBalance.coreBalance.availableValue}" pattern="#,##0"/>đ</span></p>
					<c:if test="${currentBalance.coreBalance.validityPeriod gt 0}"><p><spring:message code="label.Dashboard.Expired" text="Expired"/>: <fmt:formatDate value="${currentBalance.coreBalance.expiryDate}" pattern="dd/MM/yyyy"/></p></c:if>
				</div>
			</div>
			<div class="subCard col-sm-4" id="promoDetails">
				<h6 class="statusLabel">
					<a id="promoPopover" data-placement="bottom"><spring:message code="label.Dashboard.Promotion" text="Promotion"/> <i class="fa fa-angle-down"></i></a>
				</h6>
				<c:choose>
					<c:when test="${promoBalanceListSize gt 0}">
						<div id="promoPopoverContent">
							<c:forEach items="${currentBalance.promotionBalance.balanceList}" var="promo" varStatus="promoCtr">
								<c:choose>
									<c:when test="${pageContext.response.locale.language eq 'en'}"><h5>${promo.displayNameEN}</h5></c:when>
									<c:otherwise><h5>${promo.displayNameVI}</h5></c:otherwise>
								</c:choose>
								<div class="contentLeft">
									<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/></p>
									<p><spring:message code="label.Dashboard.Expired" text="Expired"/></p>
								</div>
								<div class="contentRight">
									<p><b><fmt:formatNumber value="${promo.availableValue}" pattern="#,##0"/>₫</b></p>
									<p><b><fmt:formatDate value="${promo.expiryDate}" pattern="dd/MM/yyyy"/></b></p>
								</div>
								<c:if test="${promoCtr.index < promoBalanceListSize - 1}"><div class="divider"></div></c:if>
							</c:forEach>
						</div>
						<div class="statusDetail" style="text-align: center;">
							<p><spring:message code="label.Dashboard.Remaining" text="Remaining"/>: <span class="wowText"><fmt:formatNumber value="${currentBalance.promotionBalance.availableValue}" pattern="#,##0"/>đ</span></p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="statusDetail">
							<p class="promoEmpty"><spring:message code="label.Dashboard.None" text="None"/></p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="subCard col-sm-4" id="dataDetails">
				<h6 class="statusLabel">
					<a id="dataPopover" data-placement="bottom"><spring:message code="label.Dashboard.Data" text="Data"/> <i class="fa fa-angle-down"></i></a>
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
			<%-- <a href="${pageContext.request.contextPath}/secure/history"> --%>
				<div class="subCard col-xs-4 col-sm-4" id="checkCallSmsSecurity">
					<div class="dashIcon">
						<i class="material-icons">history</i>
					</div>
					<h6 class="statusLabel"><spring:message code="label.Dashboard.History" text="History"/></h6>
				</div>
			<!-- </a> -->
			<a href="javascript:;" data-toggle="modal" data-target="#topupModal">
				<div class="subCard col-xs-4 col-sm-4">
					<div class="dashIcon">
						<i class="material-icons">attach_money</i>
					</div>
					<h6 class="statusLabel"><spring:message code="label.Dashboard.TopUp" text="Top Up"/></h6>
				</div>
			</a>
		</div>
	</div>

	<div class="col-sm-8 col-sm-offset-2" id="dashPage-dataPack">
		<h5 class="cardLabel"><spring:message code="label.Dashboard.Data" text="Data"/></h5>
		<div class="card">
			<div class="subCard col-sm-6 dividerRight">
				<div class="textInCircle">
					<h6><c:choose><c:when test="${pageContext.response.locale.language eq 'en'}">${dataBalance.displayNameEN}</c:when><c:otherwise>${dataBalance.displayNameVI}</c:otherwise></c:choose></h6>
				</div>
				<h6 class="statusLabel"><fmt:formatNumber value="${dataBalance.remainingValue / (1024 * 1024)}" maxFractionDigits="2"/> GB</h6>
				<button class="btn btn-primary btn-round" id="btnChangePkg" <c:if test="${empty productListForChangePkg}">disabled</c:if>><spring:message code="label.Dashboard.ChangePackage" text="Change Package"/></button>
				<h6 class="dividerBottom"></h6>
			</div>
			<div class="subCard col-sm-6">
				<div id="datapackLine"></div>
				<ul class="nav nav-pills" id="nav-pills-datapack">
					<c:forEach items="${extraDataProducts}" var="extraData" varStatus="ctr">
					<li <c:if test="${ctr.index eq 0}">class="active"</c:if>>
						<a href="#" onclick="selectXtraData('${extraData.code}');" role="tab" data-toggle="tab">
							${extraData.quota}
							<span>${extraData.name}</span>
							<fmt:formatNumber value="${extraData.price}" pattern="#,##0"/>₫
						</a>
					</li>
					</c:forEach>
				</ul>
				<input type="hidden" id="xproductCode">
				<button id="btnExtraData" class="btn btn-secondary btn-round" <c:if test="${!extraPkgEnabled}">disabled</c:if>><spring:message code="label.Dashboard.BuyMore" text="Buy More"/></button>
			</div>
		</div><!-- .card -->
	</div>

 <!-- Section:hotnews Article -->
    <div class="articleSection col-sm-12">
        <h3><spring:message code="label.Dashboard.hotnews" text="hotnews"/></h3>
        <c:forEach items="${hotnewsData}" var="hotnews">
        <div class="col-sm-4">
            <div class="articleSectionCard">			
			<c:if test="${hotnews.myselectLink eq '0'}">		
		   <div class="description">
				<h4><a href="${hotnews.detail_url}" target="_blank"><h4>${utils:abbreviate(hotnews.name, 35)}</h4></a></h4>
				<p><a href="${hotnews.detail_url}" target="_blank" style="color: white;"><p >${hotnews.description}</p></a></p>
				<p><a href="${hotnews.detail_url}" target="_blank"><p>${hotnews.detail_url}</p></a></p>
			</div>
			<a href="${hotnews.detail_url}" target="_blank"><img src="${hotnews.mediumImage}"></a>
			</c:if>
			
			
			<c:if test="${hotnews.myselectLink eq 'Top Up'}">		
		   <div class="description">
				<h4><a href="${pageContext.request.contextPath}/secure/dashboard#topupModal"><h4>${utils:abbreviate(hotnews.name, 35)}</h4></a></h4>
				<p><a href="${pageContext.request.contextPath}/secure/dashboard#topupModal"  style="color: white;"><p >${hotnews.description}</p></a></p>
				
			</div>
			<a href="${pageContext.request.contextPath}/secure/dashboard#topupModal"><img src="${hotnews.mediumImage}"></a>
			</c:if>
			
			<c:if test="${hotnews.myselectLink eq 'Notification'}">		
		   <div class="description">
				<h4><a href="${pageContext.request.contextPath}/secure/notifications"><h4>${utils:abbreviate(hotnews.name, 35)}</h4></a></h4>
				<p><a href="${pageContext.request.contextPath}/secure/notifications"  style="color: white;"><p >${hotnews.description}</p></a></p>
				
			</div>
			<a href="${pageContext.request.contextPath}/secure/notifications"><img src="${hotnews.mediumImage}"></a>
			</c:if>
			</div>
        </div>
        </c:forEach>
        <!--
        <div class="articleSectionBtn col-sm-4 col-sm-offset-4">
            <button class="btn btn-primary btn-round"><spring:message code="label.Dashboard.SeeMore" text="See More"/></button>
        </div>
        -->
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
					<h4 class="modal-title" id="topupModalLabel"><spring:message code="label.Dashboard.TopUp" text="Top Up"/></h4>
				</div>
				<div class="modal-body">
					<a href="javascript:;" onclick="vtopup();">
						<div class="topupContentOption">
							<img src="${pageContext.request.contextPath}/static/assets/image/topupIcon-1.png">
							<p><spring:message code="label.TopUp.FromScratchCard" text="From Scratch Card"/></p>
						</div>
					</a>
					<div class="sectionDivider"></div>
					<a href="#topupModal" data-toggle="collapse" data-target="#bankinAccContent">
						<div class="topupContentOption">
							<img src="${pageContext.request.contextPath}/static/assets/image/topupIcon-2.png">
							<p><spring:message code="label.TopUp.FromBankAccount" text="From Bank Account"/> <i class="fa fa-caret-down"></i></p>
						</div>
					</a>
					<div id="bankinAccContent" class="collapse">
						<div id="topupInput">
							<div class="form-group label-floating has-success">
								<label class="control-label"><spring:message code="label.TopUp.Number" text="Number"/></label>
								<input type="text" id="msisdn" name="msisdn" value="${userProfile.msisdn}" class="form-control" />
								<input type="hidden" id="selectedTopupAmt" value="50">
								<span class="form-control-feedback">
									<i class="material-icons">done</i>
								</span>
							</div>
						</div>
						<div id="topupAmount">
							<label><spring:message code="label.TopUp.SelectAmount" text="Select Amount"/></label>
							<ul class="nav nav-pills" id="nav-pills-topup" role="tablist">
								<li>
									<a href="#" onclick="javaScript:setTopupAmount('10');" role="tab" data-toggle="tab">
										<span>10</span>
										,000₫
									</a>
								</li>
								<li>
									<a href="#" onclick="javaScript:setTopupAmount('20');" role="tab" data-toggle="tab">
										<span>20</span>
										,000₫
									</a>
								</li>
								<li class="active">
									<a href="#" onclick="javaScript:setTopupAmount('50');" role="tab" data-toggle="tab">
										<span>50</span>
										,000₫
									</a>
								</li>
								<li>
									<a href="#" onclick="javaScript:setTopupAmount('100');" role="tab" data-toggle="tab">
										<span>100</span>
										,000₫
									</a>
								</li>
								<li>
									<a href="#" onclick="javaScript:setTopupAmount('200');" role="tab" data-toggle="tab">
										<span>200</span>
										,000₫
									</a>
								</li>
								<li>
									<a href="#" onclick="javaScript:setTopupAmount('500');" role="tab" data-toggle="tab">
										<span>500</span>
										,000₫
									</a>
								</li>
							</ul>
						</div>
						<div id="topupBtn">
							<button id="btnEtopUp" class="btn btn-primary btn-round"><spring:message code="label.TopUp.SelectAmount" text="Select Amount"/></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

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

	<div class="modal fade" id="weakMonsterPopup" tabindex="-1" role="dialog" aria-labelledby="topupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="topupModalLabel">${hungryMsgTitle} <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></h4>
                </div>
				<div class="modal-body">
					<div class="img-responsive">
						<p style="text-align: center; margin-top:20px;">
						<img class="img-responsive" src="${hungryMonsterImg}"></p>
						<p style="text-align: center;"></p>
						<p style="text-align: center; margin-left:40px; margin-right:40px; color: grey; font-weight:bold;">${hungryMsgTxt}</p>
					</div>
					<div class="sectionDivider" style="margin-bottom: 10px; margin-top:20px;"></div>
					
					<div id="topupBtn" >
						<button class="btn btn-primary btn-round" id="btnWeakMonster" style="width:150px; margin-bottom: 15px;"><spring:message code="label.OK" text="OK"/></button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="strongMonsterPopup" tabindex="-1" role="dialog" aria-labelledby="topupModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="topupModalLabel">${fullMsgTitle} <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></h4>
               </div>
			<div class="modal-body">
				<div class="img-responsive">
					<p style="text-align: center; margin-top:20px;">
					<img class="img-responsive" src="${fullMonsterImg}"></p>
					<p style="text-align: center;"></p>
					<p style="text-align: center; margin-left:40px; margin-right:40px; color: grey; font-weight:bold;">${fullMsgTxt}</p>
				</div>
				<div class="sectionDivider" style="margin-bottom: 10px; margin-top:20px;"></div>
					<div id="topupBtn" >
						<button data-dismiss="modal" class="btn btn-primary btn-round" style="width:150px; margin-bottom: 15px;"><spring:message code="label.OK" text="OK"/></button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- popup for mic -->

	<div class="col-sm-4 popup" id="popupDisplay" style="display: none;">
		<div class="close">
			<a href="#" title="close"><i class="fa fa-close"
				onclick="hidepopup()"></i></a>
		</div>

		<div class="popup-body">
			<%-- <h1><spring:message code="label.update" text="update"/></h1> --%>
			<h1 style="margin: 0 !important;">
				<spring:message code="label.UPDATECustomerInfo"
					text="CustomerInformation" />
			</h1>
			<h4>
				<spring:message code="label.abutinfo"
					text="Update Customer Information" />
			</h4>
		</div>
		<form method="get"
			action="${pageContext.request.contextPath}/secure/information">
			<button type="submit" class="btn btn-default proceed">
				<spring:message code="label.UPDATEMICProceed" text="Proceed" />
			</button>
		</form>
	</div>


	<div class="col-sm-4 popup" id="popupDisplaysucess"
		style="display: none;">
		<!-- <div class="close"><a href="#" title="close"><i class="fa fa-close" onclick="hidepopup()"></i></a></div> -->

		<div class="popup-body">
			<h1>
				<spring:message code="label.CustomerInformation"
					text="CustomerInformation" />
			</h1>
			<h4>
				<spring:message code="label.SucesssfullyUpdatedinfo"
					text="Update Customer Information" />
			</h4>
		</div>

		<!--   <button type="button" class="btn btn-default proceed"  onClick="hidepopup()"><spring:message code="label.OK" text="OK"/></button>-->
		<form method="get"
			action="${pageContext.request.contextPath}/secure/dashboard">
			<button type="submit" class="btn btn-default proceed">
				<spring:message code="label.OK" text="OK" />
			</button>
		</form>
	</div>

	<div class="col-sm-4 popup" id="popupDisplaystatusfailed"
		style="display: none;">
		 

		<div class="popup-body">
			<h1>
				<spring:message code="label.CustomerInformation"
					text="CustomerInformation" />
			</h1>
			<h4 id="idForFailed">
				<spring:message code="label.FailedUpdatedinfo"
					text="Updation Failed" />
			</h4>
			<h3 id="idFormorethan03sub">
				<spring:message code="label.responseMsg"
					text="Updation Failed" />
			</h3>
			
		</div>

		<form method="get"
			action="${pageContext.request.contextPath}/secure/dashboard">
			<button type="submit" class="btn btn-default proceed">
				<spring:message code="label.OK" text="OK" />
			</button>
		</form>
		<input type="hidden" id="base64DatavId" value="">

	</div>
	<!-- end popup for mic -->
	
	<!-- ${sessionScope['WEAK_MONSTER_POPUP_SHOWN']} -->				
	<input type="hidden" id="min_core_balance" value="${minCoreBalance}"/>
	<input type="hidden" id="core_balance" value="${currentBalance.coreBalance.availableValue}"/>
	<input type="hidden" id="etopupOrderId" name="etopupOrderId" value="${sessionScope['ETOPUP_SESSION'].refTrxId}">
	<input type="hidden" id="last_topup_was_petie_triggered" value="${sessionScope['last_topup_was_petie_triggered']}"/>


</body>

<!--   Core Script Files   -->
<script src="${pageContext.request.contextPath}/static/assets/script/material.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/modified-material.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/dashboard.js"></script>

<!--  Plugins -->
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.smartmenus.bootstrap.js" type="text/javascript"></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/static/assets/script/slick.min.js'></script>

<!--  Control for Material Kit -->
<script src="${pageContext.request.contextPath}/static/assets/script/material-kit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/langswitcher.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/ImageTools.js"	type="text/javascript"></script>

<script type="text/javascript">
	$('#redeem').click(function(){
		$('.fatty-popup').show()
		
	})
	
	$('.fattyclose').click(function(){
		$('.fatty-popup').hide()
	})
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
		var successMic = "${successMic}";

		var myVar = "${micstatus}";

		//alert(" successMic " + successMic + "myVar  "+ myVar)
		console.log(" successMic == " + successMic
				+ "myVar == " + myVar);
		if (parseInt("${showWeakMonsterPopup}") == 1){	
			$("#weakMonsterPopup").modal("show");
			
		} else if (parseInt("${showStrongMonsterPopup}") == 1){
			$("#strongMonsterPopup").modal("show");
		}	
		else if (successMic == 2) {
			 $('#popupDisplaysucess, .mask').show();
        } else if (successMic == 3) {

			document.getElementById('idForFailed').style.display = "block";
			document.getElementById('idFormorethan03sub').style.display = "none"; 

			$('#popupDisplaystatusfailed, .mask').show();
		     }
		else if(successMic == 7)
		{
		
			document.getElementById('idFormorethan03sub').style.display = "block";
			document.getElementById('idForFailed').style.display = "none"; 

			$('#popupDisplaystatusfailed, .mask').show();
		}
		else if (myVar == 0) {
			$('#popupDisplay').show();
			 
		}
	
		
		$("#btnWeakMonster").click(function(){
			$("#weakMonsterPopup").modal("hide");
			//etopUp("PETIE");
			$("#last_topup_was_petie_triggered").val("1");
			$('#topupModal').modal('show');
		});
		
 		$("#btnEtopUp").click(function(e){
 	 		e.preventDefault();
 	 		etopUp();

 	 		/*
 			if(etopupOrderId != '' || typeof(napasWin) != "undefined" || (typeof(napasWin) == "object" && !napasWin.closed)){
 				BootstrapDialog.show({
 					title: '',
 					type: BootstrapDialog.TYPE_WARNING,
 					message: '<spring:message code="Message.eTopup.NotFinished" text="Please finish your current eTopup transaction."/>'
 				});

 				if(typeof(napasWin) != "undefined" || (typeof(napasWin) == "object" && !napasWin.closed)){
 					napasWin.focus();
 				}
 				
 			} else {
 				etopUp();
 	 	 	}
 	 	 	*/
		});

		$("#btnExtraData").click(function(){
			var productCode = $("#xproductCode").val();
			BootstrapDialog.show({
				size: BootstrapDialog.SIZE_LARGE,
				type: BootstrapDialog.TYPE_WARNING,
				title: '<spring:message code="label.ExtraPackage" text="Extra Package"/>',
				message: '<spring:message code="Message.Shop.ConfirmRegisterPackage" text="Are you sure you want to register?"/>',
				buttons: [{
						label: '<spring:message code="label.Register" text="Register"/>',
						cssClass: 'btn btn-primary btn-round',
						autospin: true,
						action: function(dialogRef){
								dialogRef.enableButtons(false);
				                dialogRef.setClosable(false);
								dialogRef.getModalBody().html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.Processing" text="Processing your request, please wait..."/>');
				                $.get(
									"${pageContext.request.contextPath}/secure/regpkg/" + productCode
				     			).done(function(data) {
					     			var arr = data.split("|");
					     			var respcode = arr[0];
					     			var txtmsg = arr[1];
				     				dialogRef.getModalBody().html(txtmsg);

					     			if (respcode == "1"){
					     				setTimeout(function(){
					                        location.reload();
					                    }, 3000);
					     			}

				     			}).fail(function(e) {
				     				dialogRef.getModalBody().html('<spring:message code="Message.Shop.PurchaseFail" text="The registration has failed."/>');
									console.log("Error: " + e);

				     			}).always(function() {
					                setTimeout(function(){
					                		dialogRef.enableButtons(true);
					                		//dialogRef.close();
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
		});

		var optionsHtml = "";
		<c:forEach items="${productListForChangePkg}" var="pkg">
		optionsHtml += '<option value="${pkg.code}">${pkg.name}</option>';
		</c:forEach>

		$("#btnChangePkg").click(function(){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '<spring:message code="label.SelectPackage" text="Select Package"/>',
				message: '<select id="changePkgOpt">' + optionsHtml + '</select>',
				buttons: [{
						label: '<spring:message code="label.Register" text="Register"/>',
						cssClass: 'btn btn-primary btn-round',
						autospin: false,
						action: function(dialogRef){

								var selectedPkgCode = $("#changePkgOpt").val();

								dialogRef.enableButtons(false);
				                dialogRef.setClosable(false);
				                dialogRef.getModalBody().html('<i class="fa fa-spin fa-spinner"></i> <spring:message code="label.Processing" text="Processing your request, please wait..."/>');
				                $.get(
									"${pageContext.request.contextPath}/secure/regpkg/" + selectedPkgCode
				     			).done(function(data) {
				     				//dialogRef.getModalBody().html(data);
					     			var arr = data.split("|");
					     			var respcode = arr[0];
					     			var txtmsg = arr[1];
				     				dialogRef.getModalBody().html(txtmsg);

					     			if (respcode == "1"){
					     				setTimeout(function(){
					                        location.reload();
					                    }, 5000);
					     			}

				     			}).fail(function(e) {
				     				dialogRef.getModalBody().html('<spring:message code="Message.Shop.PurchaseFail" text="The registration has failed."/>');
									console.log("Error: " + e);

				     			}).always(function() {
					                setTimeout(function(){
				                        dialogRef.close();
				                    }, 5000);
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
		var checkInterval = 10 * 1000;
        
		var trxTimer = setInterval(function(){

			$.get("${pageContext.request.contextPath}/secure/etopup/status/" + orderId
				).done(function(data) {
					var respcode = data.status;
					var msg = data.message;

					console.log("etopup_status: " + respcode + ", msg= " + msg);
					
					//PROCESSING, SUCCESS, FAIL, CANCELED, NOT_FOUND, ROLL_BACK, TIME_OUT;
					if (respcode != "PROCESSING"){
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
								/*
								if ( $("#last_topup_was_petie_triggered").val() != "" ){
									location.replace("${pageContext.request.contextPath}/secure/dashboard?petie=1");									
								} else {
									location.reload();
								}
								*/
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
		var petieTriggered = $("#last_topup_was_petie_triggered").val(); 
		 $("#last_topup_was_petie_triggered").val("");//clear out
    	location.replace("${pageContext.request.contextPath}/secure/vtopup?petie=" + petieTriggered);	
    }
    
	function etopUp(){
		var petieTriggered = $("#last_topup_was_petie_triggered").val(); 
		var msisdn = $("#msisdn").val();
		var amount = $("#selectedTopupAmt").val() * 1000;
		var _url = "${pageContext.request.contextPath}/secure/etopup/init/" + msisdn + "/" + amount + "?petie=" + petieTriggered;

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
				
				//for petie
				/* if (referer != "") {
					$("#PETIE_ETOPUP_REF_ORDER_ID").val(orderId);
				} */
				
				$("#last_topup_was_petie_triggered").val("");//clear out
				var pmtURL = "${pageContext.request.contextPath}/secure/etopup/pay/" + orderId + "?petie=" + petieTriggered;
				queryEtopupStatus(orderId);

		        napasWin.location.href = pmtURL;
				napasWin.focus();
				
			} else {
				console.log("Could not initiate eTopup");
				BootstrapDialog.show({
					title: '',
					type: BootstrapDialog.TYPE_WARNING,
					//btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
					message: '<spring:message code="Message.Topup.Fail" text="Recharge unsuccessful, please try again."/>'
				});
			}
			
		}).fail(function(){
			console.log("Could not initiate eTopup");
			BootstrapDialog.show({
				title: '',
				type: BootstrapDialog.TYPE_WARNING,
				//btnOKLabel: '<spring:message code="label.OK" text="OK"/>',
				message: '<spring:message code="Message.Topup.Fail" text="Recharge unsuccessful, please try again."/>'
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
	function encodeImageFileAsURL(element) {
		var file = element.files[0];
		var reader = new FileReader();
		reader.onloadend = function() {
			// alert('RESULT'+reader.result)
			//avatarFile
			document.getElementById('avatarFiledata').value = reader.result;
			// alert('RESULT'+document.getElementById('avatarFile').value);
		}
		reader.readAsDataURL(file);
	}
</script>

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
	  // console.log(input.files[0].size);
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


<script type="text/javascript">

$("#checkCallSmsSecurity").click(function(){  
		//alert("Hello1");	
	 var smsCallHistoryStatus = "${smsCallHistoryStatus}";
    	//alert("Hello" +smsCallHistoryStatus);
    	if(smsCallHistoryStatus =="0")
   		{
    		$(".switchpopup").show();
   		}
    	else if(smsCallHistoryStatus =="1")
   		{
    		//alert("1");
    		window.location.href="${pageContext.request.contextPath}/secure/history";
    		
   		}
    });

</script>


<script type="text/javascript">


$(document).ready(function() {	
	
    $('#historySecurityIdSubmit').click(function(e) {
    	e.preventDefault();
    	
    	
        	var returnVal = document.getElementById("passwordmsisdn").value;
            if(returnVal==null || returnVal=="")
           	{
           	console.log("Cancel");
           	
           	}
            else
           	{ 
            $.post('${pageContext.request.contextPath}/secure/getValidationforHistory?${_csrf.parameterName}=${_csrf.token}',   // url
     			   { myData: returnVal, }, // data to be submit
     			   function(data, status, jqXHR) {// success callback
     						console.log("adada" +data)
     						
     						if(data== "OK")
   							{     							
     							
     							$(".switchpopup").hide();
     							window.location.href="${pageContext.request.contextPath}/secure/topuphistory";
   							}
     						else if(data== "NOTOK")
   							{
     							$('#statusResponseNotOk').show();
     							$('#statusResponseMismatch').hide();
     							
     							$(".switchpopup").show();
   							}
     						else{
     							$('#statusResponseNotOk').hide();
     							$('#statusResponseMismatch').show();
     							
     							$(".switchpopup").show();
     						}
     				});
     			
           	console.log(returnVal);
           	
           	
           	}
        	
           /*  var returnVal = confirm("Are you sure?");
            $(this).prop("checked", returnVal); */
        
                
    });
});
</script>
<script type="text/javascript">
function cosePopup() {
	
	$(".switchpopup").hide();
}
</script>
<script type="text/javascript">



$("#switchopen").click(function(){
	$(".switchpopup").show();
});

$("#switchclose").click(function(){
	$(".switchpopup").hide();
	$('#statusResponseNotOk').hide();
	$('#statusResponseMismatch').hide();
	
});



$("#redeemoffer").click(function(){
	var bodyRequest={
	      "msisdn":"${userProfile.msisdn}",
	      "keyward":"${fattyDetails.keyward}",
	      "point":${fattyDetails.point},
	      "weight":"${fattyDetails.weight}"
	     }
	$('.loader, .masking').show();
	  $.ajax({
	        type: "POST",
	        url: "${pageContext.request.contextPath}/secure/fatty/redeemPoint/?${_csrf.parameterName}=${_csrf.token}",
	        data: JSON.stringify(bodyRequest),
	       
	        dataType: 'json',
            contentType: 'application/json',
	        success: function (data) {
	        	//hideLoader();
	        	console.log("response from svr= " + data);
				/* location.reload(); */
	        },
	        error: function (e) {
	        	$("#uploadMsg").html('<spring:message code="Message.Avatar.ErrorUpload" text="Error uploading file, please try again."/>');
	            console.log("Error uploading file: ", e);
	        }
	    });
});
$("#popupbannerId").click(function(){
    $(".offer-popup").hide();
});
</script>

<script type="text/javascript">
    $(document).ready(function(){
      $('.slick-popup').slick({
        autoplay: false,
		speed: 1000,
		arrows: true,
		dots: true,
		draggable: true,
		slidesToShow: 1,
  		slidesToScroll: 1
      });
      
      responsive: [
    	    {
    	      breakpoint: 1024,
    	      settings: "unslick"
    	    },
    	    {
    	      breakpoint: 600,
    	      settings: {
    	        slidesToShow: 1,
    	        slidesToScroll: 1
    	      }
    	    },
    	    {
    	      breakpoint: 480,
    	      settings: {
    	        slidesToShow: 1,
    	        slidesToScroll: 1
    	      }
    	    }
    	    // You can unslick at a given breakpoint now by adding:
    	    // settings: "unslick"
    	    // instead of a settings object
    	  ]
    });
</script>


</html>
