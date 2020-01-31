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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link rel="icon" href="${pageContext.request.contextPath}/static/assets/image/favicon.ico">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile - Store List</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/jquery.smartmenus.bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/material-kit.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/style/vietnamobile.css?id=1">

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<style>
		#map-canvas {
			height: 400px;
		}
		.dataTables_filter {
			width: 75%;
			float: center;
			text-align: right;
		}
		.dataTable > thead > tr > th[class*="sort"]:after{
    			content: "" !important;
		}
		
	.vnmtabs{
       	display:flex;
       	justify-content:center;
       }
       
       .tabmain1{
       	background:#f8f8f8;
       	color:#000000;
       	flex:1;
       	border-top-left-radius:10px;
       	text-align:center;
       	padding:25px;
       	font-size:20px;
       }
       
       
       
     
       .tabmain1.active{
       	background:#dedede;
       	color:#000000;
       }
       
       
        .tabmain2{
       	background:#f8f8f8;
       	color:#000000;
       	flex:1;
       	border-top-right-radius:10px;
       	text-align:center;
       	padding:25px;
       	font-size:20px;
       	border-left: 1px solid #afafaf;
       }
       
       .tabmain2.active{
       	background:#dedede;
       	color:#000000;
       }
       
       
       #storeContent .card{
       padding:0!important;
       }
       
       .tabmain1:hover, .tabmain2:hover{
       	background:#dedede;
       	color:#000000;
       	text-decoration:none;
       }
       
       .vnm-content-list{
       	display:block;
       }
       
       .vnm-content-map{
       	display:none;
       }
       
       .table.dataTable{
       	margin-top:0!important;
       }
       
       .dataTables_filter{
       	width:99%!important;
       }
       
	</style>
</head>

<body>
<!--<spring:htmlEscape defaultHtmlEscape="true" />-->
<tiles:insertAttribute name="header"/>

<div class="wrapper">

	<!-- Header -->
	<div class="header-general">
		<div class="container">
			<div class="col-sm-11 col-sm-offset-1">
				<h1 class="no-breadcrumb"><spring:message code="label.StoreList.StoreList" text="Store List"/></h1>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-2">
			<!-- 
			<div class="col-sm-4 col-sm-offset-8" id="storePlace">
				<i class="material-icons">place</i>
				<p id="currentCity"></p>
			</div>
			 -->
		</div>
	</div>
	<!-- ${currCity} -->
	<div class="col-sm-12" id="storeContent">
		<form:form id="frmStore" name="frmStore" method="POST" acceptCharset="UTF-8"> 
		<input type="hidden" id="lon" name="lon" value="${longitude}">
		<input type="hidden" id="lat" name="lat" value="${latitude}">
		<input type="hidden" id="city" name="city" value="${currCity}">
		<div class="col-sm-8 col-sm-offset-2" style="margin-bottom: 25px;">
			<div class="row">
				<div class="container">
					<div class="col-sm-3" id="storeTitle">
						<h2><spring:message code="label.StoreList.StoreInfo1" text="There are"/> <span style="color: #FF6E00;">${storeCount}</span> <spring:message code="label.StoreList.StoreInfo2" text="store near you"/></h2>
					</div>
					<div class="col-sm-3 col-sm-offset-2 storeSearch">
						 <div class="form-group" id="storeCity">
							<div class="row">
								<div class="col-sm-5">
									<label for="province" style="line-height:35px;"><spring:message code="label.StoreList.City" text="City"/>:</label>
								</div>	
								<div class="col-sm-7">
								  <select class="form-control" id="province">
								  	<option value=""></option>
									<c:forEach var="provName" items="${provinceList}"><option value="${provName}" <c:if test="${provName eq currCity}">selected="true"</c:if>>${provName}</option></c:forEach>
								  </select>
								</div>  
							</div>  
						</div> 
					</div>
					<div class="col-sm-offset-2">
						<div class="col-sm-3" id="storeLoc">
							<a href="javascript:findNearByStores();"><i class="material-icons">my_locations</i></a>
							<a href="javascript:findNearByStores();"><p><spring:message code="label.StoreList.FindStore" text="Find a store near you"/></p></a>
						</div>
					</div>	
				</div>
			</div>
		</div>
		</form:form>
		
		
		<div class="col-sm-8 col-sm-offset-2">
					
			<div class="card">
			
			<div class="vnmtabs">
			<a href="#" class="tabmain1 active" onclick="displayList()" style="text-decoration: none;">Lists</a>
			<a href="#" class="tabmain2" onclick="displayMap()" style="text-decoration: none;">Map</a>
			</div>
			
			<div class="vnm-content-list active" id="latList">
				<div class="table-responsive">
					<table class="table table-hover" id="storeListTable">
						<thead>
							<tr><th></th></tr>
						</thead>
                        <tbody>
						<c:forEach items="${storeList}" var="store" varStatus="ctr">
							<tr>
								<td>
								
									<div class="col-xs-9 col-sm-10 storeDetails">
										<h6>${store.name}</h6>
										<i class="material-icons">place</i><p>${store.address}, ${store.province}</p><br>
										<i class="material-icons">phone</i><p>${store.phoneNumber}</p>
									</div>
									<div class="col-xs-3 col-sm-2 storeShowMap">
										<a href="javaScript:showMap(${store.latitude}, ${store.longitude});">
											<i class="material-icons">map</i>
											<p><spring:message code="label.StoreList.ShowInMap" text="Show in map"/></p>
										</a>
									</div>
								</td>
							</tr>
							<!--<c:if test="${ctr.index < storeCount - 1}"><div class="col-xs-12 divider"></div></c:if>-->
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
			
			<div class="vnm-content-map" id="latMap">
				<div id="map" style="width: 100%; height: 500px;"></div>
			</div>
		
			
		
                
			</div> <!-- .card -->
		</div>
	</div>

	<!-- Divider -->
	<div class="sectionDivider col-sm-12"></div>

	<!-- Footer -->
	<tiles:insertAttribute name="footer"/>

</div> <!-- .wrapper -->

<div id="mapModal" class="modal fade modal-info">
	<div class="modal-dialog modal-lg">
        <div class="modal-content">
		    <div class="modal-body">
		        <div id="map-canvas"></div>
		    </div>
		    <div class="modal-footer">
		    		<div class="text-center"><button type="button" data-dismiss="modal" class="btn btn-primary" data-value="0"><spring:message code="label.Close" text="Close"/></button></div>
		    </div>
        </div>
	</div>	       
</div>

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
<script src="${pageContext.request.contextPath}/static/assets/script/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/dataTables.bootstrap.min" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/bootstrap-dialog.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/assets/script/app.js" type="text/javascript"></script>
<!-- AIzaSyAOw9ZQ42qrDW8TK_MGbTeseDVMZ45YCHM --> <!-- AIzaSyAYQyfN5BjpO_YPc9NpiGR4bzHr855p5p0 -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAOw9ZQ42qrDW8TK_MGbTeseDVMZ45YCHM" type="text/javascript"></script> 
<script>
	$(document).ready(function() {
		$('body').on('hidden.bs.modal', '.modal', function () {
			$(this).removeData('bs.modal');
		});
		
		//alert("Hello");
		var store = '${storeListLat}';
		//var obj = store.name;
		 var locations = jQuery.parseJSON(store);
		
		 var map = new google.maps.Map(document.getElementById('map'), {
		      zoom: 10,
		      center: new google.maps.LatLng(locations[0]["latitude"],  locations[0]["longitude"]),
		      mapTypeId: google.maps.MapTypeId.ROADMAP
		    });

		    var infowindow = new google.maps.InfoWindow();

		    var marker, i;

		    for (i = 0; i < locations.length; i++) {  
		      marker = new google.maps.Marker({
		    	  
		        position: new google.maps.LatLng(locations[i]["latitude"], locations[i]["longitude"]),
		        map: map
		      });

		      google.maps.event.addListener(marker, 'click', (function(marker, i) {
		        return function() {
		          infowindow.setContent(locations[i]["address"]);
		          infowindow.open(map, marker);
		        }
		      })(marker, i));
		    }
		 
		 
		 /* $(store).each(function(i, item){
		    console.log(item.address +"  .....  "+ item.latitude +"  .....  "+ item.longitude)
		}); */ 
		$("#province").change(function(e){
			e.preventDefault();

			var prv = $("#province").val();
			/*
			$("#city").val(prv);
			$("#frmStore").attr("accept-charset", "UTF-8");
			$("#frmStore").attr("action", "${pageContext.request.contextPath}/store/city").submit();
			*/
			location.replace("${pageContext.request.contextPath}/store/city?city=" + prv);
		});
		
		$("#storeListTable").DataTable({
			scrollY : "480px",
			scrollCollapse : true,
			searching : true,
			info : false,
			paging : false,
			aoColumnDefs : [
		        { 'bSortable': false, 'aTargets': [ -1 ] }
		    ],
			language: {
			    infoEmpty: '<spring:message code="label.StoreList.NoDataFound" text="No matching records found."/>',
			    emptyTable: '<spring:message code="label.StoreList.NoDataFound" text="No matching records found."/>',
			    zeroRecords: '<spring:message code="label.StoreList.NoDataFound" text="No matching records found."/>',
			    search: "_INPUT_",
		        searchPlaceholder: '<spring:message code="label.StoreList.Search" text="Search..."/>'
			}
		});

		$('.dataTables_filter input').addClass('form-control');

		/*
		//show current city
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function (pos) {
			    //replace with params for testing purpose
			    var lng = pos.coords.latitude;
			    var lat = pos.coords.longitude;
			    console.log("lng: " + lng + ", lat= " + lat);
			    
			    var latlng = new google.maps.LatLng(lat, lng);

			    var geocoder = new google.maps.Geocoder();
			    //reverse geocode the coordinates, returning location information.
			    geocoder.geocode({latLng: latlng}, function(results, status) {
					if (status == google.maps.GeocoderStatus.OK) {
			          	if (results[1]) {
			            	
			          		var arrAddress = results;
			            	$.each(arrAddress, function(i, address_component) {
			              		if (address_component.types[0] == "locality") {
			                		console.log("City: " + address_component.address_components[0].long_name);
			                		$('#currentCity').text(address_component.address_components[0].long_name);
			              		}
			            	});
			          	} else {
			            	console.log("No results found");
			          	}
			        } else {
			        	//<spring:message code="label.StoreList.ShowInMap" text="Show in map"/>
			        	$('#currentCity').text('<spring:message code="label.StoreList.UnknownLocation" text="Unknown Location"/>');
			         	console.log("Geocoder failed due to: " + status);
			        }
				});			
			});
			
		}else{
			console.log("Location not supported!");
		}
		*/
	});
	
	function findNearByStores(){
		$("#province").val('');
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function (pos) {
			    //replace with params for testing purpose
			    var lat = pos.coords.latitude;
			    var lng = pos.coords.longitude;
			    console.log("lng: " + lng + ", lat= " + lat);
			    
			    //location.replace("${pageContext.request.contextPath}/store/nearby?lon=" + lng + "&lat=" + lat + "&dist=20");
			    $("#lon").val(lng);
			    $("#lat").val(lat);
			    $("#frmStore").attr("action", "${pageContext.request.contextPath}/store/nearby").submit();
			});
	          
		} else {
			console.log("Location not supported!");
		}
	}
	
	function showMap(lat, lon){
		var center = new google.maps.LatLng(lat, lon);

		var mapOptions = {
	        zoom: 15,
	        mapTypeId: google.maps.MapTypeId.ROADMAP,
	        center: center
	    	};

		map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		
	    var marker = new google.maps.Marker({
	        map: map,
	        position: center
	    });
	    
	    $('#mapModal').modal({
	    		backdrop: 'static',
	    		closeOnEscape: true
	        
	    }).on('shown.bs.modal', function () {
	        google.maps.event.trigger(map, 'resize');
	        map.setCenter(center);
	    });
    
	}
	
	
	function displayMap() {
		$("#latList").hide();
		$("#latMap").show();
		
	}
	function displayList() {
		$("#latList").show();
		$("#latMap").hide();
	}
</script>


</html>