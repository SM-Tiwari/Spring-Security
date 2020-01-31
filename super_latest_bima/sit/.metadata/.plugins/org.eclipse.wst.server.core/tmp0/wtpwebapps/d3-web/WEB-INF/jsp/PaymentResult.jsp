<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   
	<link rel="icon" href="">
	<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/static/assets/image/apple-touch-icon.png">

	<title>My Vietnamobile</title>
	<meta name="description" content="#">
	<meta name="keywords" content="#">
	<meta name="author" content="Vietnamobile">

	<!-- Stylesheets -->
	
	<%-- <link rel="stylesheet" href="<c:url value="/static/assets/style/bootstrap.min.css" />">
	
	<link rel="stylesheet" href="<c:url value="/static/assets/style/material-kit.css" />">
	<link rel="stylesheet" href="<c:url value="/static/assets/style/vietnamobile.css" />"> --%>
	
	<!-- <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="material-kit.css">
	<link rel="stylesheet" type="text/css" href="vietnamobile.css"> -->

	<!-- Typefaces -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>

html * {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

*, *:after, *:before {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

::-moz-selection {
    background: transparent;
}

::selection {
    background: transparent;
}

/*::-webkit-scrollbar {
	display: none;
}*/

.sectionDivider {
    border-bottom: 1px solid #979797;
}

.dividerRight {
    border-right: 1px solid rgba(74, 74, 74, 0.10);
}

.strong {
    font-weight: 600;
}

/* -----------------------------
------- 2. Common Styles -------
------------------------------*/

body {
    background-color: #F2F2F2;
}


body, h1, h2, h3, h4, h5, h6 {
    font-family: "Poppins", sans-serif;
    font-weight: 400;
}

/* ------------------------------
------- 3. Common Classes -------
-------------------------------*/

/*--- Floating Action Button ---*/

.action-button-desktop {
    position: fixed;
    top: 220px;
    right: 30px;
    z-index: 5;
}

.act-btn-desktop {
    display: block;
    width: 50px; 
    height: 50px;
    background: #FFFFFF;
    box-shadow: 0 3px 6px rgba(0,0,0,.275);
    border: none;
    outline: none;
    border-radius: 50%;
    margin-bottom: 20px;
}

.action-button-mobile {
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    margin: 0 auto 40px;
    z-index: 2000;
}

.act-btn-mobile {
    position: relative;
    top: 0;
    z-index: 1;
    width: 70px;
    height: 70px;
    font-size: 1.5em;
    color: #FFFFFF;
    background: #FFFFFF;
    border: none;
    border-radius: 50%;
    box-shadow: 0 3px 6px rgba(0,0,0,.275);
    outline: none;
}

.act-btn-mobile.trigger {
    background: #FF6E00;
}

.act-btn-mobile > .material-icons {
    font-size: 40px
}

.act-btn-toggle {
    z-index: 5;
    width: 90px;
    height: 90px;
    margin: 0 auto;
}
.act-btn-toggle span {
    -webkit-transform: none;
    transform:         none;
    -webkit-transition: -webkit-transform .175s cubic-bazier(.175,.67,.83,.67);
    transition:         transform .175s cubic-bazier(.175,.67,.83,.67);
}
.act-btn-toggle.open {
    -webkit-transform: scale(1.3,1.3);
    transform:         scale(1.3,1.3);
    -webkit-animation: toggleBtnAnim .175s;
    animation:         toggleBtnAnim .175s;
}
.act-btn-toggle.open span {
    -webkit-transform: rotate(45deg);
    transform:         rotate(45deg);
    -webkit-transition: -webkit-transform .175s cubic-bazier(.175,.67,.83,.67);
    transition:         transform .175s cubic-bazier(.175,.67,.83,.67);
}

#options {
    height: 70px;
}

.option {
    position: relative;
}

.option .option1,
.option .option2,
.option .option3 {
    filter: blur(5px);
    -webkit-filter: blur(5px);
    -webkit-transition: all .175s;
    transition:         all .175s;
}

.option .option1 {
    -webkit-transform: translate3d(90px,90px,0) scale(.8,.8);
    transform:         translate3d(90px,90px,0) scale(.8,.8);
}

.option .option2 {
    -webkit-transform: translate3d(0,90px,0) scale(.8,.8);
    transform:         translate3d(0,90px,0) scale(.8,.8);
}

.option .option3 {
    -webkit-transform: translate3d(-90px,90px,0) scale(.8,.8);
    transform:         translate3d(-90px,90px,0) scale(.8,.8);
}

.option.scale-on .option1, 
.option.scale-on .option2,
.option.scale-on .option3 {
    filter: blur(0);
    -webkit-filter: blur(0);
    -webkit-transform: none;
    transform:         none;
    -webkit-transition: all .175s;
    transition:         all .175s;
}

.option.scale-on .option2 {
    -webkit-transform: translateY(-28px) translateZ(0);
    transform:         translateY(-28px) translateZ(0);
    -webkit-transition: all .175s;
    transition:         all .175s;
}

@keyframes toggleBtnAnim {
    0% {
        -webkit-transform: scale(1,1);
        transform:         scale(1,1);
    }
    25% {
        -webkit-transform: scale(1.4,1.4);
        transform:         scale(1.4,1.4); 
    }
    75% {
        -webkit-transform: scale(1.2,1.2);
        transform:         scale(1.2,1.2);
    }
    100% {
        -webkit-transform: scale(1.3,1.3);
        transform:         scale(1.3,1.3);
    }
}

@-webkit-keyframes toggleBtnAnim {
    0% {
        -webkit-transform: scale(1,1);
        transform:         scale(1,1);
    }
    25% {
        -webkit-transform: scale(1.4,1.4);
        transform:         scale(1.4,1.4); 
    }
    75% {
        -webkit-transform: scale(1.2,1.2);
        transform:         scale(1.2,1.2);
    }
    100% {
        -webkit-transform: scale(1.3,1.3);
        transform:         scale(1.3,1.3);
    }
}

/*--- Navigation Bar ---*/

.nav .open>a, 
.nav .open>a:focus, 
.nav .open>a:hover {
    background-color: transparent;
}

.navbar {
    border: 0;
    box-shadow: none;
    padding: 10px 0;
    margin-bottom: 0;
}

.navbar.navbar-default {
    background: -webkit-linear-gradient(left, rgba(225,229,94,1) 0%, rgba(245,129,51,1) 30%, rgba(242,105,84,1) 70%, rgba(238,55,128,1) 100%);
}

/* Language Options */

.togglebutton.langOpt {
    position: relative;
    float: right;
    margin-top: 14px;
    margin-right: 10px;
}

.togglebutton.langOpt.desktop {
    margin-top: 20px;
    margin-right: 20px;
}

.togglebutton.langOpt label .toggle, 
.togglebutton.langOpt label input[type=checkbox][disabled] + .toggle {
    content: "";
    display: inline-block;
    width: 45px;
    height: 20px;
    padding: 5px 8px;
    margin: 0;
    background-color: #FFFFFF;
    border-radius: 15px;
    transition: background 0.3s ease;
    vertical-align: middle;
    color: #D7D5D5;
    font-weight: 600;
    font-size: 9px;
    text-align: left;
}

.togglebutton.langOpt label input[type=checkbox]:checked + .toggle {
    background-color: #FFFFFF;
}

.togglebutton.langOpt label .toggle > span {
    margin-left: 9px;
}

.togglebutton.langOpt label .toggle:after {
    content: 'VI';
    display: inline-block;
    position: relative;
    top: -19px;
    left: -10px;
    width: 25px;
    height: 25px;
    border: 0;
    border-radius: 50%;
    background-color: #F57E20;
    transition: left 0.3s ease, background 0.3s ease, box-shadow 0.1s ease;
    box-shadow: 
        0 0px 2px 0 rgba(0, 0, 0, 0.10), 
        0 0px 1px -2px rgba(0, 0, 0, 0.2), 
        0 0px 10px 0 rgba(0, 0, 0, 0.15);
    color: #FFFFFF;
    font-weight: 600;
    font-size: 9px;
    text-align: center;
    line-height: 25px;
}

.togglebutton.langOpt label input[type=checkbox]:checked + .toggle:after {
    content: 'EN';
    left: 13px;
}

/* Dropdown Menu */

.navbar.navbar-default .dropdown-menu {
    border-radius: 0 !important;
}

.navbar .navbar-nav .dropdown-menu > li > a {
    color: #424242;
    font-weight: 600;
}

.navbar.navbar-default .dropdown-menu li > a:hover, 
.navbar.navbar-default .dropdown-menu li > a:focus {
    color: #FF6E00;
    background-color: transparent;
    box-shadow: none;
}

.navbar .navbar-nav.navbar-left > .active > a, 
.navbar .navbar-nav.navbar-left > .open > a.has-submenu, 
.navbar .navbar-nav.navbar-left > li > a:hover {
    background-color: rgba(255, 255, 255, 0.12);
    border-radius: 50px;
}

.navbar .navbar-nav.navbar-right > .active > a,
.navbar .navbar-nav.navbar-right > .open > a.has-submenu, 
.navbar .navbar-nav.navbar-right > li > a:hover {
    background-color: rgba(255, 255, 255, 0.12);
    border-radius: 20px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu {
    padding-top: 0;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData {
    width: 200px;
    padding: 20px 20px 5px;
    color: white;
    background-color: #FAFAFA;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData > h6 {
    color: #FF6E00;
    font-size: 17px;
    text-transform: capitalize;
    margin-top: 0;
    margin-bottom: 5px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData > p {
    color: #262626;
    font-size: 12px;
    font-weight: 600;
    margin-bottom: 5px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData .userDataLabel {
    margin-top: 5px;
    margin-bottom: 20px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData .label.userDataLabelStatus {
    font-size: 9px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData .label.userDataLabelDataType {
    font-size: 9px;
}

.navbar .navbar-nav.navbar-right .dropdown-menu > li > a > .material-icons {
    color: #D6D6D6;
    font-size: 22px;
    margin-right: 20px;
}

.navbar .navbar-nav > li > a {
    color: #FFFFFF;
    padding: 10px 25px;
    font-weight: 500;
    font-size: 14px;
    text-transform: capitalize;
    margin-right: 10px;
}

.navbar .navbar-nav > li:last-child > a {
    margin-right: 0;
}

.modLeft {
    padding-left: 70px;
    margin-top: 10px;
}

.navbar .navbar-nav.navbar-right > li > a {
    color: inherit;
    padding: 10px 25px 0;
    font-weight: 400;
    font-size: 11px;
    letter-spacing: 0.5px;
    text-align: center;
    margin-top: 0;
    margin-right: 0;
}

.navbar .navbar-nav.navbar-right > li > a > i {
    font-size: 30px;
    margin-bottom: 5px;
}

.navbar .navbar-nav > li > a:not(.btn-just-icon) .material-icons {
    margin-right: 10px;
}

.navbar .bubble {
    background-color: #FFFFFF;
    color: #D0011B;
    border-radius: 20px;
    font-family: "Poppins", sans-serif;
    font-size: 10px;
    font-weight: 600;
    height: 18px;
    line-height: 18px;
    min-width: 18px;
    position: absolute;
    right: -20px;
    text-align: center;
    text-shadow: none;
    top: -10px;
    padding: 0px 5px;
}

.navbar .navbar-nav.navbar-right > li > a p {
    margin-bottom: 0;
}

.overlay {
    background: #000000;
    position: fixed;
    top: 80px;
    left: 0;
    height: 100%;
    width: 100%;
    opacity: .5;
    z-index: 200;
    display: none;
}

.overlay.active {
    display: block;
}

/*--- Header ---*/

.wrapper > .header-dashboard {
    background: url('../image/dashboard-bg.png') no-repeat top center;
    background-size: cover;
    min-height: 237px;
}

.wrapper > .header-general {
    background: url('../image/general-bg.png') no-repeat top center;
    background-size: cover;
    min-height: 180px;
}

.header-general ul, .mod-breadcrumb {
    margin-top: 10px;
    padding-left: 65px;
}

.header-general ul > li, .mod-breadcrumb > li {
    display: inline;
}

.header-general ul > li:after, .mod-breadcrumb > li:after {
    color: #FFFFFF;
    content: '>';
    padding: 0 10px;
}

.header-general ul > li:last-child:after, .mod-breadcrumb > li:last-child:after {
    content: '';
    padding: 0;
}

.header-general ul > li > a, .mod-breadcrumb > li > a {
    color: #FFFFFF;
    font-size: 12px;
    letter-spacing: 0.5px;
}

.header-general h1 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 25px;
    padding-left: 65px;
    margin-top: 0;
}

.header-general h1.no-breadcrumb {
    margin-top: 42px;
}

/*--- Footer ---*/

.footer {
    padding: 25px 0;
    color: #9B9B9B;
    font-size: 12px;
}

.footer p {
    margin-bottom: 5px;
}

.footer .footer-left {
    float: left;
}

.footer .footer-left img {
    width: 115px;
    margin-right: 5px;
}

.footer .footer-right {
    float: right;
    text-align: right;
}

.footer .footer-right ul {
    margin-bottom: 10px;
}

.footer .footer-right ul li {
    display: inline;
    margin-left: 30px;
    font-size: 24px;
}

.footer .footer-right ul li:first-child {
    margin-left: 0;
}

.footer .footer-right ul li a {
    color: #9B9B9B;
}

/*--- Card ---*/

.card {
    color: #696969;
    box-shadow: 
        0 0px 2px 0 rgba(0, 0, 0, 0.10), 
        0 0px 1px -2px rgba(0, 0, 0, 0.2), 
        0 0px 10px 0 rgba(0, 0, 0, 0.15);
    border-radius: 10px;
    margin-bottom: 25px;
}

.card.card-raised {
    margin: -100px 0 30px;
    box-shadow: 
        0 0px 10px 0 rgba(0, 0, 0, 0.10), 
        0 0px 5px -2px rgba(0, 0, 0, 0.2), 
        0 0px 20px 0 rgba(0, 0, 0, 0.15);
    z-index: 3;
}

.cardLabel {
    text-transform: uppercase;
    font-weight: 600;
    color: #696969;
    font-size: 14px;
}

.subCard {
    padding: 5px 30px;
    text-align: center;
}

/*--- Button ---*/

.btn {
    border: none;
    font-size: 14px;
    font-weight: 500;
    text-transform: capitalize;
}

.btn.btn-round {
    border-radius: 50px;
}

.btn.btn-primary {
    background-color: #ff6e00;
    color: #ffffff;
    border: 1px solid #ff6e00;
    box-shadow: 
        0 0px 2px 0 rgba(0, 0, 0, 0.10), 
        0 0px 1px -2px rgba(0, 0, 0, 0.2), 
        0 0px 10px 0 rgba(0, 0, 0, 0.15);
}

.btn.btn-secondary {
    background-color: transparent;
    color: #ff6e00;
    border: 1px solid #ff6e00;
}

.btn.btn-primary:hover, 
.btn.btn-primary:focus, 
.btn.btn-primary:active, 
.btn.btn-primary.active, 
.btn.btn-primary:active:focus, 
.btn.btn-primary:active:hover, 
.btn.btn-primary.active:focus, 
.btn.btn-primary.active:hover, 
.open > .btn.btn-primary.dropdown-toggle, 
.open > .btn.btn-primary.dropdown-toggle:focus, 
.open > .btn.btn-primary.dropdown-toggle:hover, 
.navbar .navbar-nav > li > a.btn.btn-primary, 
.navbar .navbar-nav > li > a.btn.btn-primary:hover, 
.navbar .navbar-nav > li > a.btn.btn-primary:focus, 
.navbar .navbar-nav > li > a.btn.btn-primary:active, 
.navbar .navbar-nav > li > a.btn.btn-primary.active, 
.navbar .navbar-nav > li > a.btn.btn-primary:active:focus, 
.navbar .navbar-nav > li > a.btn.btn-primary:active:hover, 
.navbar .navbar-nav > li > a.btn.btn-primary.active:focus, 
.navbar .navbar-nav > li > a.btn.btn-primary.active:hover, 
.open > .navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle, 
.open > .navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle:focus, 
.open > .navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle:hover {
    background-color: #ff6e00;
}

.btn.btn-primary:focus, 
.btn.btn-primary:active, 
.btn.btn-primary:hover, 
.navbar .navbar-nav > li > a.btn.btn-primary:focus, 
.navbar .navbar-nav > li > a.btn.btn-primary:active, 
.navbar .navbar-nav > li > a.btn.btn-primary:hover {
    box-shadow: 
    0 14px 26px -12px rgba(255, 110, 0, 0.42), 
    0 4px 23px 0px rgba(0, 0, 0, 0.12), 
    0 8px 10px -5px rgba(255, 110, 0, 0.2);
}

.btn.btn-secondary:focus, 
.btn.btn-secondary:active, 
.btn.btn-secondary:hover {
    background-color: #ff6e00;
    color: #ffffff;
    box-shadow: none;
}

/*--- Label ---*/

.label {
    border-radius: 50px;
}

/*--- Tabs ---*/

.nav-tabs-navigation > .nav-tabs-wrapper {
    text-align: center;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs {
    display: inline-block;
    padding: 0;
    border-radius: 0;
    background: transparent;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li {
    padding: 10px 25px;
    border: 1px solid #FF6E00;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li:first-child {
    border-radius: 25px 0 0 25px;
    border-right: 0;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li:last-child {
    border-radius: 0 25px 25px 0;
    border-left: 0;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li.active {
    background-color: #FF6E00;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li > a {
    color: #FF6E00 !important;
    font-weight: 600;
    font-size: 18px;
    text-transform: capitalize;
    padding: 0;
}

.nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li.active > a {
    color: #FFFFFF !important;
    background-color: transparent;
}

/*--- Slider ---*/

.slider {
    background: #FF6E00;
}

.slider .noUi-handle {
    border-color: #FF6E00;
}

/* ------------------------------
------- 4. Dashboard Page -------
-------------------------------*/

/*--- Section: User Data ---*/

#avatarDesktop {
    padding: 0;
}

#avatarDesktop img {
    height: 180px;
    border-radius: 10px 0 0 10px;
}

#avatarMobile img {
    max-width: 200px;
    margin: -100px auto 0;
}

#userData {
    padding: 30px 20px;
}

#userData h2 {
    color: #FF6E00;
    font-weight: 300;
    font-size: 24px;
    margin-top: 0;
}

#userData h6 {
    color: #262626;
    font-weight: 600;
    font-size: 16px;
}

#userData .userDataLabel {
    margin-top: 20px;
}

.label.userDataLabelStatus {
    font-weight: 400;
    font-size: 12px;
    letter-spacing: 1.5px;
    margin-right: 5px;
    background-color: #d8d8d8;
}

.label.userDataLabelDataType {
    font-weight: 400;
    font-size: 12px;
    letter-spacing: 1.5px;
    background-color: #FF6E00;
}

#gameChar {
    padding: 0;
}

#gameChar img {
    width: 96px;
    margin: 40px auto;
}

/*#gameChar {
    padding: 0;
    background: url('../image/mons1.png') no-repeat center;
    background-size: 96px;
    min-height: 180px;
}*/

/*--- Section: Status Details ---*/

.statusLabel {
    font-size: 14px;
    color: #696966;
    text-transform: none;
    text-align: center;
    margin-bottom: 20px;
}

.statusLabel .fa {
    color: #FF6E00;
}

.statusLabel a {
    color: #696966;
    cursor: pointer;
}

.statusLabel a:hover {
    text-decoration: none;
}

.statusDetail {
    font-size: 14px;
    color: #9B9B9B;
    letter-spacing: 0.5px;
    line-height: 25px;
    text-align: left;
}

.statusDetail .promoEmpty {
    font-weight: 600;
    font-size: 20px;
    color: #D8D8D8;
    text-align: center;
}

.statusDetail .wowText {
    font-weight: 600;
    font-size: 20px;
    color: #F57E20;
}

/*--- Promo & Data Popover ---*/

#promoPopoverContent, #dataPopoverContent {
    display: none;
}

.popover-content a {
    display: block;
    margin-bottom: 5px;
    color: #FF6E00;
    text-align: right;
}

.popover-content a .material-icons {
    font-size: 20px;
}

.popover-content h5 {
    font-weight: 500;
    font-size: 14px;
    color: #4A4A4A;
}

.popover-content p {
    font-size: 14px;
    color: #4A4A4A;
}

.popover-content .divider {
    clear: both;
    border-bottom: 1px solid #9B9B9B;
}

.popover-content .contentLeft {
    float: left;
    margin-right: 100px;
}

.popover-content .contentRight {
    float: right;
    text-align: right;
}

/*--- Section: Shortcut ---*/

.dashIcon {
    display: block;
    width: 65px;
    height: 65px;
    margin: 0 auto;
    border-radius: 50%;
    background: #FF6E00;
    box-shadow: 0 3px 6px rgba(0,0,0,.275);
}

.dashIcon > .material-icons {
    color: #FFFFFF;
    font-size: 40px;
    line-height: 65px
}

#topupModal .modal-dialog {
    margin-top: 50px;
}

#topupModal .modal-content {
    border-radius: 10px;
}

#topupModal .modal-header {
    text-align: center;
    padding: 15px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    background: -webkit-linear-gradient(left, rgba(225,229,94,1) 0%, rgba(245,129,51,1) 20%, rgba(242,105,84,1) 100%);  
}

#topupModal .modal-header > .modal-title {
    color: #FFFFFF;
    font-weight: 600;
    font-size: 18px;
}

#topupModal .modal-body {
    padding: 0 0 5px;
}

#topupModal .modal-body a {
    text-decoration: none;
}

#topupModal .modal-body a:hover {
    text-decoration: none;
}

#topupModal .modal-body .sectionDivider {
    border-bottom: 1px solid #FF6E00;
}

#topupModal .modal-body .topupContentOption {
    padding-left: 20px;
    margin: 15px 0;
}

#topupModal .modal-body .topupContentOption img {
    margin-right: 20px;
}

#topupModal .modal-body .topupContentOption p {
    display: inline;
    color: #424242;
    font-weight: 600;
    font-size: 15px;
}

#topupModal .modal-body .topupContentOption p > .fa {
    margin-left: 5px;
}

#bankinAccContent {
    padding: 20px;
}

#topupInput label, #topupAmount label {
    color: #424242;
    font-weight: 600;
    font-size: 12px;
    text-transform: uppercase;
}

#nav-pills-topup {
    display: flex;
    justify-content: center;
    margin-top: 5px;
    margin-bottom: 5px;
}

#nav-pills-topup > li {
    padding: 0 5px;
}

#nav-pills-topup > li:last-child {
    margin-right: 0;
}

#nav-pills-topup > li > a {
    width: 100%;
    min-width: 70px;
    height: 70px;
    color: #B0B0B0;
    font-weight: 600;
    font-size: 12px;
    line-height: 0;
    text-transform: none;
    border-radius: 50%;
    background-color: #F5F5F5;
}

#nav-pills-topup > li.active > a, 
#nav-pills-topup > li.active > a:focus, 
#nav-pills-topup > li.active > a:hover {
    color: #FFFFFF;
    background-color: #FF6E00;
    box-shadow: none;
}

#nav-pills-topup > li > a > span {
    display: block;
    font-weight: 700;
    font-size: 22px;
    margin-bottom: 15px;
    margin-top: 20px;
}

#topupBtn {
    text-align: center;
}

#topupBtn .btn {
    font-weight: 600;
    margin-bottom: 0;
}

/*--- Section: Data Package ---*/

.textInCircle {
    border: 1px solid #FF6E00;
    border-radius: 50%;
    width: 70px;
    height: 70px;
    text-align: center;
    vertical-align: middle;
    margin: 20px auto;
}

.textInCircle h6 {
    font-weight: 600;
    color: #FF6E00;
    font-size: 20px;
    margin-top: 22px;
}

#dashPage-dataPack .statusLabel {
    margin-bottom: 10px;
}

#dashPage-dataPack .btn.btn-secondary {
    width: 184.43px;
    margin-bottom: 20px;
}

#datapackLine {
    position: relative;
    top: 75px;
    width: 200px;
    height: 1px;
    margin: 0 auto;
    background-color: #DFDFDF;
}

#nav-pills-datapack {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}

#nav-pills-datapack > li {
    padding: 0 5px;
}

#nav-pills-datapack > li > a, 
#nav-pills-datapack > li > a:focus, 
#nav-pills-datapack > li > a:hover {
    min-width: 0;
    color: #30302F;
    font-weight: 400;
    font-size: 13px;
    background-color: transparent;
}

#nav-pills-datapack > li.active > a, 
#nav-pills-datapack > li.active > a:focus, 
#nav-pills-datapack > li.active > a:hover {
    background-color: transparent;
    box-shadow: none;
}

#nav-pills-datapack > li > a > span {
    display: block;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    border: 1px solid #DFDFDF;
    color: #989898;
    font-weight: 600;
    font-size: 14px;
    padding-top: 12px;
    margin: 5px auto;
    background-color: #FFFFFF;
}

#nav-pills-datapack > li.active > a > span {
    color: #FFFFFF;
    border: 1px solid #FF6E00;
    background-color: #FF6E00;
}

/*--- Section: Recommendation Article ---*/

.articleSection {
    background-image: url('../image/dashboard-bg-2.png');
    background-position: top center;
    background-size: cover;
    min-height: 451px;
    padding: 25px 130px;
}

.articleSection h3 {
    color: #ffffff;
    font-weight: 500;
    font-size: 18px;
    text-align: center; 
    text-transform: uppercase;
    margin-top: 0px;
    margin-bottom: 25px;
}

.articleSection .articleSectionBtn {
    text-align: center;
}

.articleSectionCard {
    padding: 10px;
    margin-bottom: 20px;
    border-radius: 10px;
    background-color: #ffffff;
}

.articleSectionCard a:hover {
    text-decoration: none;
}

.articleSectionCard img {
    width: 100%;
    max-height: 300px;
    border-radius: 10px;
}

.articleSectionCard h4 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    margin-bottom: 0;
}

.articleSectionCard p {
    color: #4A4A4A;
    font-size: 14px;
    line-height: 18px;
}

/* -----------------------------------
------- 5. Detail Account Page -------
------------------------------------*/

/*--- Section: User Options ---*/

#accDetails {
    padding: 0;
    margin-top: 50px;
}

.accDetailsSubcard {
    position: relative;
    padding: 30px;
}

.accDetailsSubcard:after {
    content: '';
    height: 300px;
    width: 1px;
    position: absolute;
    right: 0;
    top: 30px;
    background-color: rgba(74, 74, 74, 0.10);
}

.accDetailsOptions {
    clear: both;
    float: left;
    padding-bottom: 50px;
}

.accDetailsOptions > .accOption-img {
    float: left;
    margin-right: 20px;
    margin-bottom: 20px;
}

.accDetailsOptions > .accOption-img img {
    max-width: 60px;
}

.accDetailsOptions > .accOption-content {
    float: left;
}

.accDetailsOptions > .accOption-content > h5 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 14;
    text-transform: uppercase;
    margin: 0 0 5px;
}

.accDetailsOptions > .accOption-content > h6 {
    color: #4A4A4A;
    font-weight: 600;
    font-size: 14;
    text-transform: capitalize;
    margin: 5px 0;
}

.accDetailsOptions > .accOption-content .divider {
    clear: both;
    border-bottom: 1px solid #9B9B9B;
}

.accDetailsOptions > .accOption-content > .accContent-left {
    float: left;
    margin-right: 65px;
}

.accDetailsOptions > .accOption-content > .accContent-left > p {
    color: #4A4A4A;
    font-size: 14px;
    margin: 0 0 5px;
}

.accDetailsOptions > .accOption-content > .accContent-right {
    float: right;
}

.accDetailsOptions > .accOption-content > .accContent-right > p {
    color: #4A4A4A;
    font-weight: 600;
    font-size: 14px;
    text-align: right;
    margin: 0 0 5px;
}

/* ----------------------------
------- 7. Scratch Card -------
-----------------------------*/

#scratchCardSection {
    padding: 0;
    margin-top: 50px;
}

#scratchCardSection .card {
    margin-bottom: 50px;
}

#scratchCardContent {
    width: 300px;
    margin: 50px auto;
}

#scratchCardContent label {
    color: #424242;
    font-weight: 600;
    font-size: 14px;
    text-transform: uppercase;
}

#scratchCardContent .form-group {
    margin: 0 0 10px;
}

.form-group.is-focused .form-control {
    background-image: linear-gradient(#FF6E00, #FF6E00), linear-gradient(#DFDFDF, #DFDFDF);
}

.scratchCardBtn {
    padding: 0;
    margin-bottom: 25px;
}

#scratchCardContent .btn {
    width: 100%;
}

/* ----------------------------
------- 8. Profile Page -------
-----------------------------*/

/*--- Section: User Profile ---*/

#userProfile {
    padding: 0;
}

#userProfile img {
    max-width: 150px;
    margin: -80px auto 0;
}

#userProfile h2 {
    color: #FF6E00;
    font-size: 25px;
    text-align: center;
}

/*--- Section: User Options ---*/

#userOptions {
    padding: 0;
    margin-top: 50px;
    margin-bottom: 100px;
}

.userOptionsCard {
    margin-bottom: 5px;
}

.userOptions-icon {
    float: left;
    padding: 10px;
    margin-left: 10px;
    margin-right: 10px;
}

.userOptions-icon .material-icons {
    color: #D6D6D6;
    font-size: 30px;
}

.userOptions-title {
    float: left;
    padding: 10px;
    margin-top: 5px;
}

.userOptions-title > h6 {
    color: #424242;
    font-weight: 600;
    font-size: 16px;
    text-transform: capitalize;
    margin: 0;
}

.userOptions-body {
    text-align: right;
    float: right;
    padding: 10px;
    margin-top: 7px;
    margin-right: 10px;
}

.userOptions-body > a {
    color: #424242;
}

.userOptions-body p {
    float: left;
    color: #424242;
    font-size: 16px;
    margin: 0;
}

.userOptions-body .material-icons {
    float: right;
    margin-top: -3px;
}

/* --------------------
------- 9. FAQs -------
---------------------*/

#faqContent {
    padding-top: 25px;
    padding-left: 0;
    padding-right: 0;
    margin-bottom: 50px;
}

#faqContent h2 {
    color: #696966;
    font-weight: 600;
    font-size: 16px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 25px;
}

.faqCard {
    margin-bottom: 5px;
}

.faq-title {
    float: left;
    padding: 15px;
}

.faq-title > h6 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-transform: none;
    margin: 0;
}

.faq-icon {
    text-align: right;
    float: right;
    padding: 12px 12px 12px 0;
}

.faq-icon > a {
    color: #D6D6D6;
    cursor: pointer;
}

.faq-icon .material-icons {
    float: right;
    font-size: 30px;
}

.faq-body {
    clear: both;
    padding: 15px;
    border-radius: 0 0 10px 10px;
    background-color: #FBFBFB;
}

.faq-body p {
    color: #4A4A4A;
    font-size: 14px;
    line-height: 24px;
    margin: 0;
}

/* ---------------------------
------- 10. Store List -------
----------------------------*/

#storePlace {
    border-radius: 25px;
    background-color: #FFFFFF;
    padding: 15px;
    overflow: hidden;
}

#storePlace .material-icons {
    float: left;
    width: 10%;
    color: #DCDCDC;
}

#storePlace p {
    float: left;
    width: 90%;
    color: #F57E20;
    font-size: 16px;
    text-align: center;
    padding-top: 2px;
    margin-bottom: 0;
}

#storeContent {
    padding-top: 25px;
    padding-left: 0;
    padding-right: 0;
    margin-bottom: 50px;
}

#storeContent .divider {
    margin: 20px 0;
    border-bottom: 1px solid rgba(74, 74, 74, 0.10);
}

#storeTitle {
    padding: 0;
}

#storeTitle h2 {
    color: #696966;
    font-weight: 600;
    font-size: 18px;
    margin: 15px 0;
}

#storeLoc {
    padding: 15px;
    text-align: center;
    border-radius: 25px;
    background-color: #FF6E00;
    overflow: hidden;
}

#storeLoc .material-icons {
    float: left;
    width: 20%;
    color: #FFFFFF;
}

#storeLoc p {
    float: left;
    width: 80%;
    color: #FFFFFF;
    font-weight: 600;
    font-size: 14px;
    padding-top: 2px;
    margin-bottom: 0;
}

#storeContent .card {
    padding: 20px 0;
}

.storeDetails {
    padding: 0 0 0 20px;
}

.storeDetails h6 {
    color: #424242;
    font-weight: 600;
    font-size: 16px;
    text-transform: capitalize;
    margin-top: 0;
}

.storeDetails .material-icons {
    float: left;
    width: 10%;
    color: #DCDCDC;
    font-size: 18px;
}

.storeDetails p {
    float: left;
    width: 90%;
    display: inline;
    color: #424242;
    font-size: 14px;
}

.storeShowMap {
    text-align: center;
    padding: 10px 20px;
}

.storeShowMap a:hover {
    text-decoration: none;
}

.storeShowMap .material-icons {
    color: #FF6E00;
    font-size: 40px;
    margin-bottom: 5px;
}

.storeShowMap p {
    color: #FF6E00;
    font-size: 12px;
    margin: 0;
}

/* ------------------------------------
------- #. Active Subscriptions -------
-------------------------------------*/

#activeSubs {
    padding: 0;
    margin-top: 50px;
    margin-bottom: 50px;
}

#activeSubs .desktop img {
    margin: 0 auto;
    border-radius: 10px;
    box-shadow:
        0 0px 2px 0 rgba(0, 0, 0, 0.10), 
        0 0px 1px -2px rgba(0, 0, 0, 0.2), 
        0 0px 10px 0 rgba(0, 0, 0, 0.15);
}

#activeSubs .mobile img {
    max-width: 150px;
    margin: -130px auto 0;
}

#activeSubs h2 {
    color: #FF6E00;
    font-size: 20px;
    text-align: center;
    margin-bottom: 20px;
}

#activeSubs .card {
    padding: 10px 20px;
    margin-bottom: 25px;
}

.package-title h6 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    text-transform: none;
}

.package-body .leftContent {
    color: #4A4A4A;
    font-size: 14px;
}

.package-body .rightContent {
    color: #4A4A4A;
    font-weight: 600;
    font-size: 14px;
    text-align: right;
}

/* -------------------------------
------- #. Change Password -------
--------------------------------*/

#changePass {
    padding: 0;
    margin-top: 50px;
}

#changePass .card {
    margin-bottom: 50px;
}

#changePassHeader {
    float: left;
    width: 100%;
    padding: 20px;
    margin-bottom: 30px;
    border-radius: 10px 10px 0 0;
    background: -webkit-linear-gradient(left, rgba(225,229,94,0.10) 0%, rgba(245,129,51,0.10) 30%, rgba(242,105,84,0.10) 70%, rgba(238,55,128,0.10) 100%);
}

#changePassHeader > .wrapper {
    padding: 0;
}

#changePassHeader > .wrapper > img {
    float: left;
    width: 80px;
    height: 80px;
    margin-right: 20px
}

#changePassHeader > .wrapper > h6 {
    color: #9B9B9B;
    font-size: 20px;
    line-height: 26px;
    text-transform: none;
    margin-top: 30px;
}

#changePassContent {
    clear: both;
    width: 300px;
    margin: 20px auto;
}

#changePassContent .form-group {
    margin: 0 0 10px;
}


#changePassContent .form-group.is-focused .form-control {
    background-image: linear-gradient(#FF6E00, #FF6E00), linear-gradient(#DFDFDF, #DFDFDF);
}

#changePassContent label {
    color: #424242;
    font-weight: 600;
    font-size: 14px;
    text-transform: uppercase;
}

#changePassContent .btn {
    width: 100%;
}

/* -----------------------------
------- #. Notifications -------
------------------------------*/

#notifContent {
    padding: 0;
    margin-top: 50px;
    margin-bottom: 50px;
}

.notifCard {
    margin-bottom: 25px;
}

.notif-title {
    padding: 15px;
    border-bottom: 1px solid #FF6E00;
}

.notif-title > h6 {
    display: inline-block;
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-transform: capitalize;
    margin: 0;
}

.notif-title > a > .material-icons {
    color: #FF6E00;
    float: right;
}

.notif-body {
    padding: 15px;
}

.notif-body p {
    color: #424242;
    font-size: 16px;
    line-height: 24px;
    margin: 0;
}

.notif-body .divider {
    margin: 15px 0;
    border-bottom: 1px solid #979797;
}

/* -----------------------
------- #. History -------
------------------------*/

#historyContent {
    padding-top: 25px;
    padding-left: 0;
    padding-right: 0;
    margin-bottom: 25px;
}

#historyContent h2 {
    color: #696966;
    font-weight: 600;
    font-size: 16px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 25px;
}

#historyContent .card {
    max-height: 300px;
    padding: 0;
    margin-bottom: 25px;
    overflow: scroll;
}

.historyTable {
    margin-bottom: 0;
}

.historyTable > thead {
    background: -webkit-linear-gradient(left, rgba(225,229,94,1) 0%, rgba(245,129,51,1) 30%, rgba(242,105,84,1) 70%, rgba(238,55,128,1) 100%);
}

.historyTable > thead > tr > th {
    padding: 12px;
    color: #FFFFFF;
    font-weight: 600;
    font-size: 12px;
    text-transform: uppercase;
    border-bottom: 0;
}

.historyTable > thead > tr > th:first-child {
    border-radius: 10px 0 0 0;
}

.historyTable > thead > tr > th:last-child {
    border-radius: 0 10px 0 0;
}

.historyTable > tbody > tr > td {
    padding: 12px;
    color: #6B6B6B;
    font-size: 12px;
}

.historyTable > tbody > tr > td > .material-icons {
    color: #D6D6D6;
    font-size: 12px;
    margin-right: 5px;
}

.historyTable > tbody > tr > td.phoneNumber {
    color: #424242;
    font-weight: 600;
}

.historyTable > tbody > tr > td.duration {
    color: #FF6E00;
}

/* ------------------------------
------- #. Top Up History -------
-------------------------------*/

#topupHistoryContent {
    padding-top: 50px;
    padding-left: 0;
    padding-right: 0;
    margin-bottom: 25px;
}

#topupHistoryContent .historyTable > thead {
    background: -webkit-linear-gradient(left, rgba(225,229,94,0.10) 0%, rgba(245,129,51,0.10) 30%, rgba(242,105,84,0.10) 70%, rgba(238,55,128,0.10) 100%);
}

#topupHistoryContent .historyTable > thead > tr > th {
    color: #424242;
}

#topupHistoryContent .historyTable > tbody > tr > td {
    color: #424242;
    font-size: 14px;
}

#topupHistoryContent .amount {
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-align: center;
}

/* --------------------------
------- #. Shop Pages -------
---------------------------*/

.shopPages .content {
    height: 350px;
    max-height: 350px;
    padding: 35px 70px;
    overflow: hidden;
    background-color: #FFFFFF;
}

.shopPages .subpageContent {
    height: 400px;
    max-height: 400px;
}

.shopPages .content h2 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 25px;
    margin-top: 0;
}

.shopPages .content p {
    color: #9B9B9B;
    font-size: 14px;
    line-height: 20px;
    text-align: justify; /* Untuk meniadakan river effect, hapus properti ini sehingga perataan teks kembali ke default (left) */
}

.shopPages .content ul li {
    color: #9B9B9B;
    font-size: 14px;
    line-height: 20px;
}

.shopPages .content .btn {
    font-weight: 600;
    font-size: 14px;
    padding: 5px 10px;
    box-shadow: none;
}

.shopPages .photo {
    position: relative;
    height: 350px;
    max-height: 350px;
    padding: 0;
    overflow: hidden;
}

.shopPages .subpagePhoto {
    height: 400px;
    max-height: 400px;
}

.shopPages .photo img {
    position: absolute;
    top: -9999px;
    bottom: -9999px;
    left: -9999px;
    right: -9999px;
    width: 100%;
    height: 120%;
    margin: auto;
}

/* ----------------------
------- #. Gamify -------
-----------------------*/

.landingPage {
    border-top: 1px solid #F2F2F2;
    background: -webkit-linear-gradient(left, rgba(225,229,94,1) 0%, rgba(245,129,51,1) 30%, rgba(242,105,84,1) 70%, rgba(238,55,128,1) 100%);
}

.landingPage .row {
    margin-left: 0;
    margin-right: 0;
}

.landingPage .landingPage-title {
    text-align: center;
    padding: 20px;
    margin-top: 25px;
    margin-bottom: 25px;
    border-radius: 10px;
    border: 1px solid #FFFFFF;
}

.landingPage .landingPage-title h1 {
    color: #FFFFFF;
    font-weight: 600;
    font-size: 25px;
    line-height: 1;
    margin: 0;
}

.landingPage .landingPage-content {
    margin-bottom: 25px;
}

.landingPage .landingPage-image {
    text-align: center;
    margin-bottom: 25px;
}

.landingPage .landingPage-image img {
    width: 100%;
}

.landingPage .landingPage-body p {
    color: #FFFFFF;
    font-size: 14px;
}

.landingPage .landingPage-body h2 {
    color: #FFFFFF;
    font-size: 30px;
    line-height: 1.2;
    margin-bottom: 0;
}

.landingPage .landingPage-cta {
    width: 200px;
    padding: 15px 20px;
    margin: 0 auto 25px;
    border-radius: 10px;
    background-color: #FFFFFF;
}

.landingPage .landingPage-cta p {
    color: #F57E20;
    font-weight: 600;
    font-size: 25px;
    text-align: center;
    margin: 0;
}

.landingPage a.fakeBtn:hover {
    text-decoration: none;
}

.landingPage .landingPage-app .landingPage-appContent {
    width: 300px;
    margin: 0 auto 25px;
}

.landingPage .landingPage-app .landingPage-appContent .appContentIcon .fa {
    color: #FFFFFF;
    font-size: 35px;
}

.landingPage .landingPage-app .landingPage-appContent .appContentBody {
}

.landingPage .landingPage-app .landingPage-appContent .appContentBody > h6 {
    color: #FFFFFF;
    font-weight: 600;
    font-size: 22px;
    text-transform: none;
    margin-top: 0;
}

.landingPage .landingPage-app .landingPage-appContent .appContentBody > p {
    color: #FFFFFF;
    font-size: 14px;
    margin-top: 0;
}

.landingPage .landingPage-app .landingPage-appContent .appContentBody > a {
    color: #FFFFFF;
}

.landingPage .landingPage-app .landingPage-appContent .appContentBody > a > .fa {
    margin-right: 10px;
}

/* ----------------------------
------- #. Market Pages -------
-----------------------------*/

.marketPage .mod-breadcrumb > li > a {
    color: #FF6E00;
}

.marketPage .mod-breadcrumb > li:after {
    color: #FF6E00;
}

.marketPage-banner {
    position: relative;
    height: 400px;
    max-height: 400px;
    padding: 0;
    margin-bottom: 50px;
    overflow: hidden;
}

.marketPage-banner > img {
    position: absolute;
    top: -9999px;
    bottom: -9999px;
    left: -9999px;
    right: -9999px;
    width: 120%;
    margin: auto;
}

.marketPage-sectionTitle {
    padding: 0;
    margin-bottom: 25px;
}

.marketPage-sectionTitle .sectionTitle-title > h2 {
    color: #424242;
    font-weight: 600;
    font-size: 24px;
    text-transform: uppercase;
    margin-top: 0;
    margin-bottom: 0;
}

.marketPage-sectionTitle .sectionTitle-more {
    text-align: right;
    padding-top: 7px;
}

.marketPage-sectionTitle .sectionTitle-more > a {
    color: #FF6E00;
    font-size: 16px;
    text-decoration: none;
}

.marketPage-sectionMovie, .marketPage-sectionGame {
    margin-bottom: 25px;
}

.marketPage-sectionMovie .moviePoster,
.marketPage-sectionGame .gameThumb {
    margin-bottom: 15px;
    overflow: hidden;
}

.marketPage-sectionMovie .moviePoster > a > img,
.marketPage-sectionGame .gameThumb > a > img {
    width: 100%;
}

.marketPage-sectionGame .gameThumb > a > img {
    border-radius: 20px;
}

.marketPage-sectionMovie .movieName,
.marketPage-sectionGame .gameName {
    margin-bottom: 25px;
    padding-right: 0;
}

.marketPage-sectionMovie .movieName > a:hover,
.marketPage-sectionGame .gameName > a:hover {
    text-decoration: none;
}

.marketPage-sectionMovie .movieName > a > h6,
.marketPage-sectionGame .gameName > a > h6 {
    color: #424242;
    font-weight: 600;
    font-size: 12px;
    text-transform: none;
    margin: 0;
}

.marketPage-sectionMovie .movieRate > p,
.marketPage-sectionGame .gameRate > p {
    color: #FF6E00;
    font-size: 12px;
    text-align: right;
    margin: 0;
}

/* ------------------------------------
------- #. Movie & Game Details -------
-------------------------------------*/

.movieDetails-details {
    margin-bottom: 25px;
}

.movieDetails-details .detailsPoster {
    margin-bottom: 25px;
}

.movieDetails-details .detailsPoster > img {
    width: 100%;
}

.movieDetails-details .detailsMovie > h1 {
    color: #F57E20;
    font-weight: 600;
    font-size: 36px;
    text-transform: capitalize;
    margin-top: 0;
    margin-bottom: 25px;
}

.movieDetails-details .detailsMovie .imdbLogo > img {
    width: 100%;
}

.movieDetails-details .detailsMovie .imdbRate {
    margin-bottom: 25px;
}

.movieDetails-details .detailsMovie .imdbRate > h6 {
    color: #000000;
    font-weight: 600;
    font-size: 36px;
    line-height: 1;
    text-align: center;
    margin: 0;
}

.movieDetails-details .detailsMovie .imdbRate {
    padding: 0;
}

.movieDetails-details .detailsMovie .imdbRate > p {
    color: #D6D6D6;
    font-weight: 600;
    font-size: 14px;
    text-align: center;
    margin: 0;
}

.table.movieMeta {
    margin-bottom: 25px;
}

.table.movieMeta > tbody > tr > th {
    color: #424242;
    font-weight: 600;
    font-size: 18px;
}

.table.movieMeta > tbody > tr > td {
    color: #4A4A4A;
    font-size: 18px;
}

.table.movieMeta > tbody > tr > th,
.table.movieMeta > tbody > tr > td {
    border-top: 0px;
}

.movieDetails-details .detailsMovie .detailsCTA .btn {
    width: 100%;
    border-radius: 10px;
    padding: 10px 5px;
}

.sectionTitle-storyline {
    margin-top: 25px;
}

.sectionTitle-storyline > p {
    color: #424242;
    font-size: 14px;
    line-height: 20px;
}

#transactionModal .modal-dialog {
    margin-top: 200px;
}

#transactionModal .modal-dialog > .modal-content {
    border-radius: 10px;
}

#transactionModal .modal-dialog > .modal-content > .modal-body {
    padding: 50px 20px;
}

#transactionModal .modal-dialog > .modal-content > .modal-body > img {
    display: block;
    margin: 0 auto 25px;
}

#transactionModal .modal-dialog > .modal-content > .modal-body > p {
    color: #424242;
    font-weight: 600;
    font-size: 14px;
    text-align: center;
    margin: 0;
}

.gameDetails {
    margin-bottom: 25px;
    border-bottom: 1px solid #979797;
}

.gameDetails .gameDetails-image > img {
    width: 100%;
    border-radius: 20px;
}

.gameDetails .gameDetails-title {
    margin-bottom: 10px;
}

.gameDetails .gameDetails-title > h1 {
    color: #424242;
    font-weight: 600;
    font-size: 24px;
    line-height: 1;
    margin-top: 0;
}

.gameDetails .gameDetails-title > p {
    color: #FF6E00;
    font-size: 14px;
    margin-bottom: 0;
}

.gameDetails .gameDetails-meta .metaDownload,
.gameDetails .gameDetails-meta .metaRating {
    color: #F57E20;
    font-weight: 700;
    font-size: 46px;
    line-height: 1.7;
    text-align: center;
    position: relative;
    width: 125px;
    height: 125px;
    padding: 20px;
    border-radius: 50%;
    border: 3px solid #F57E20;
}

.gameDetails .gameDetails-meta .metaRating {
    color: #424242;
    border: 3px solid #F2C31A;
}

.gameDetails .gameDetails-meta .metaDownload > .metaDownload-caption,
.gameDetails .gameDetails-meta .metaRating > .metaRating-caption {
    color: #FFFFFF;
    font-weight: 400;
    font-size: 14px;
    text-align: center;
    position: absolute;
    bottom: -4px;
    left: 0;
    width: 120px;
    padding: 5px 20px;
    border-radius: 20px;
    background-color: #F57E20;
}

.gameDetails .gameDetails-meta .metaRating > .metaRating-caption {
    background-color: #F2C31A;
}

.gameDetails .gameDetails-meta .metaDownload-title,
.gameDetails .gameDetails-meta .metaRating-title {
    color: #424242;
    font-size: 14px;
    text-align: center;
    width: 125px;
    margin-top: 5px;
}

.gameDetails .buyGameCTA .btn {
    width: 100%;
    padding: 5px 10px;
}

.gameDetails .buyGameCTA .btn > p {
    font-size: 14px;
    margin: 5px 0 0;
}

.gameDetails .movieMeta > tbody > tr > th,
.gameDetails .movieMeta > tbody > tr > td {
    font-size: 16px;
}

/* -----------------------------
------- #. Self Packages -------
------------------------------*/

.selfPackages {
    margin: 25px 0;
}

.selfPackages .selfPackages-content {
    margin-top: 25px;
}

.selfPackages .selfPackages-content .sliderContentWrapper {
    margin: 50px 0;
}

.selfPackages .selfPackages-content .sliderTitle {
    margin-bottom: 25px;
}

.selfPackages .selfPackages-content .sliderTitle .sliderLabel {
    color: #424242;
    font-weight: 600;
    font-size: 16px;
    text-align: left;
    text-transform: uppercase;
}

.selfPackages .selfPackages-content .sliderTitle .sliderPoint {
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-align: left;
}

.selfPackages .selfPackages-content .noUi-horizontal {
    margin: 15px 0 30px;
}

.selfPackages .selfPackages-content .card {
    box-shadow: none;
    border-radius: 0;
}

.selfPackages .selfPackages-content .card > .totalMoney-left {
    color: #424242;
    font-weight: 600;
    font-size: 12px;
    text-align: left;
    text-transform: uppercase;
    padding: 20px;
}

.selfPackages .selfPackages-content .card > .totalMoney-right {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    text-align: right;
    padding: 20px;
}

.selfPackages .selfPackages-content .card > .divider {
    border-bottom: 1px solid #979797;
}

.selfPackages .selfPackages-content .renewWrapper {
    color: #424242;
    font-size: 18px;
    text-align: left;
}

.selfPackages .selfPackages-content .renewWrapper .material-icons {
    color: #FF6E00;
}

.selfPackages .selfPackages-content .renewWrapper .form-group.is-focused .form-control {
    background-image: linear-gradient(#FF6E00, #FF6E00), linear-gradient(#DFDFDF, #DFDFDF);
}

.selfPackages .selfPackages-content .btn {
    width: 100%;
    padding: 10px 0;
}

/* -------------------------------
------- #. Gamify Monsters -------
--------------------------------*/

.mod-breadcrumb.gamify > li:after {
    color: #FF6E00;
}

.mod-breadcrumb.gamify > li > a {
    color: #FF6E00;
}

.gamifyMonsters {
    margin: 25px 0;
}

.gamifyMonsters .gamifyMonsters-content {
    margin-top: 50px;
}

/* Tab: My Monsters */
/* Slider */
.glide--horizontal .carousel__arrows {
    width: 46%;
    margin-left: 27%;
} 

.carousel__arrow {
    padding: 8px 10px;
    border: 0;
    border-radius: 50%;
    background-color: #FF6E00;
}

.carousel__wrapper {
    -webkit-transition: all .3s ease-in-out;
    -moz-transition: all .3s ease-in-out;
    transition: all .3s ease-in-out;
}

.carousel__slide {
    -webkit-transition: all .2s ease;
    -moz-transition: all .2s ease;
    transition: all .2s ease;
    -webkit-transform-origin: 50% 50%;
    -moz-transform-origin: 50% 50%;
    -ms-transform-origin: 50% 50%;
    -o-transform-origin: 50% 50%;
    transform-origin: 50% 50%
}

.carousel__slide.active {
    -webkit-transform: scale(1.02);
    -moz-transform: scale(1.02);
    -ms-transform: scale(1.02);
    -o-transform: scale(1.02);
    transform: scale(1.02)
}

.carousel__slide.pre {
    -webkit-transform: perspective(60em) rotateY(18deg);
    -moz-transform: perspective(60em) rotateY(18deg);
    -ms-transform: perspective(60em) rotateY(18deg);
    -o-transform: perspective(60em) rotateY(18deg);
    transform: perspective(60em) rotateY(18deg)
}

.carousel__slide.following {
    -webkit-transform: perspective(60em) rotateY(-18deg);
    -moz-transform: perspective(60em) rotateY(-18deg);
    -ms-transform: perspective(60em) rotateY(-18deg);
    -o-transform: perspective(60em) rotateY(-18deg);
    transform: perspective(60em) rotateY(-18deg)
}

.carousel__slide > .card {
    width: 100%;
    height: 450px;
    padding: 20px;
    border-radius: 10px;
    margin: 25px 0;
}

.carousel__slide > .card > h6 {
    color: #424242;
    font-weight: 600;
    font-size: 22px;
    text-transform: capitalize;
    margin: 0 0 15px;
}

.carousel__slide > .card > .level {
   color: #30302F;
   font-size: 14px;
   margin: 0 0 15px;
}

.carousel__slide > .card > .weight {
   color: #FF6E00;
   font-weight: 600;
   font-size: 20px;
   margin: 0 0 40px;
}

.carousel__slide > .card > .progress {
   height: 9px;
   margin-top: 40px;
   border-radius: 25px;
}

.carousel__slide > .card > .progress .progress-bar {
    background: -webkit-linear-gradient(left, rgba(225,229,94,1) 0%, rgba(245,129,51,1) 20%, rgba(242,105,84,1) 100%);
}

.carousel__slide > .card > .advice {
   color: #30302F;
   font-weight: 600;
   font-size: 13px;
   margin: 25px 0;
}

/* Modal */

#howModal > a {
    color: #FF6E00;
    font-size: 13px;
    text-decoration: underline;
}

#howModalContent > .modal-dialog {
    margin-top: 200px;
}

#howModalContent > .modal-dialog > .modal-content {
    padding: 25px;
    border-radius: 25px;
}

#howModalContent > .modal-dialog > .modal-content > .modal-header {
    padding: 0;
}

#howModalContent > .modal-dialog > .modal-content > .modal-header > h1 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    margin-top: 0;
}

#howModalContent > .modal-dialog > .modal-content > .modal-body {
    padding: 0;
}

#howModalContent > .modal-dialog > .modal-content > .modal-body > ol {
    padding-left: 20px;
    margin-bottom: 0;
}

#howModalContent > .modal-dialog > .modal-content > .modal-body > ol > li {
    color: #4A4A4A;
    font-size: 14px;
    line-height: 2;
}

/* Tab: Rewards */
/* Section: Left */

.gamifyMonsters .gamifyMonsters-content #rewards .card {
    width: 100%;
    max-width: 400px;
    padding-top: 20px;
    margin: 0 auto 25px;
    display: block;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card > h6 {
    color: #424242;
    font-weight: 600;
    font-size: 20px;
    text-align: center;
    text-transform: capitalize;
    margin: 0 0 20px;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card > img#monster {
    display: block;
    margin: 30px auto;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card > p {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    text-align: center;
    margin: 20px 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card > .divider {
    border-bottom: 1px solid #D8D8D8;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card #giftTitle {
    color: #424242;
    font-size: 20px;
    padding: 35px 0 15px 20px;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card #giftImage {
    float: left;
    width: 50%;
    padding: 15px 20px 15px 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card #giftControl {
    color: #6B6B6B;
    font-weight: 700;
    font-size: 24px;
    text-align: center;
    float: right;
    width: 50%;
    padding: 40px 20px 15px 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card #giftControl > a > .material-icons {
    color: #FF6E00;
    margin-right: 5px;
    margin-bottom: 5px;
}

.gamifyMonsters .gamifyMonsters-content #rewards .card #giftControl > a:hover {
    text-decoration: none;
}

.gamifyMonsters .gamifyMonsters-content #rewards #cardNote {
    color: #424242;
    font-size: 14px;
    line-height: 19px;
    width: 100%;
    max-width: 400px;
    margin: 0 auto;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td {
    vertical-align: middle;
    border-top: 0;
    padding: 20px 5px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:first-child {
    color: #4A4A4A;
    font-size: 18px;
    width: 20%;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:last-child {
    color: #FF6E00;
    font-weight: 600;
    font-size: 18px;
    width: 20%;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:last-child > .btn {
    width: 100%;
    padding: 10px;
    box-shadow: none;
    border-radius: 25px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td.td-actions {
    width: 60%; 
    min-width: 170px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table > tbody > tr > td.td-actions > .material-icons {
    color: #D6D6D6;
    font-size: 14px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table > tbody > tr > td.td-actions > button {
    display: inline;
    padding: 0;
    margin: 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table > tbody > tr > td.td-actions > button > .material-icons {
    color: #FF6E00;
    font-weight: 600;
    font-size: 22px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td.td-actions > input {
    text-align: center;
    width: 30px;
    padding: 5px;
    margin: 0 5px;
    border: 0;
    border-radius: 5px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td.td-actions > input::-webkit-outer-spin-button,
.gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td.td-actions > input::-webkit-inner-spin-button {
    /* display: none; <- Crashes Chrome on hover */
    -webkit-appearance: none;
    margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
}

/* Rewards Claim */

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim > .card {
    color: #FF6E00;
    font-weight: 600;
    font-size: 20px;
    vertical-align: middle;
    width: 100%;
    max-width: 100%;
    padding: 10px;
    margin: 20px 0;
    box-shadow: none;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim > .card span {
    float: left;
    padding-top: 5px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim > .card img {
    float: right;
    width: 50%;
    margin-left: 10px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr.active > td,
.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table.table-hover > tbody > tr:hover {
    background-color: #EAEAEA;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr.active > td:first-child,
.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table.table-hover > tbody > tr:hover > td:first-child {
    border-radius: 10px 0 0 10px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr.active > td:last-child,
.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table.table-hover > tbody > tr:hover > td:last-child {
    border-radius: 0 10px 10px 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td {
    vertical-align: middle;
    border-top: 0;
    padding: 10px 20px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl {
    width: 30%;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > button {
    display: inline;
    padding: 0;
    margin: 0;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > button > .material-icons {
    color: #FF6E00;
    font-weight: 600;
    font-size: 22px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > input {
    text-align: center;
    width: 30px;
    padding: 5px;
    margin: 0 5px;
    border: 0;
    border-radius: 5px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > input::-webkit-outer-spin-button,
.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > input::-webkit-inner-spin-button {
    /* display: none; <- Crashes Chrome on hover */
    -webkit-appearance: none;
    margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.char {
    width: 50%;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.char > img {
    margin: 0 20px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.char > .material-icons {
    color: #D6D6D6;
    font-size: 14px;
}

.gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td:last-child {
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-align: right;
    width: 20%;
}

/* -------------------
------- #. 404 -------
--------------------*/

#patnolpat .header-dashboard {
    padding-top: 40px;
}

#patnolpat .card {
    padding: 50px;
}

#patnolpat .card.card-raised {
    margin: -90px 0 25px;
}

#patnolpatContent > h1 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 24px;
    margin-top: 0;
    margin-bottom: 25px;
}

#patnolpat .btn {
    width: 100%;
    padding: 10px 0;
    margin: 0 0 10px;
}

#patnolpat footer > ul > li > a {
    color: #9B9B9B;
    font-size: 24px;
}

#patnolpat footer > p {
    color: #9B9B9B;
    font-size: 12px;
    margin: 0;
}

/* ---------------------------------
------- #. Member Get Member -------
----------------------------------*/

#memberGetContent > p {
    color: #4A4A4A;
    font-size: 16px;
    line-height: 20px;
    margin-bottom: 50px;
}

#memberGetContent #label {
    color: #FF6E00;
    font-weight: 600;
    font-size: 16px;
    text-transform: uppercase;
    padding-top: 10px;
    margin-bottom: 0;
}

#memberGetContent .form-group {
    padding-bottom: 0;
    margin: 0;
}

#memberGetContent .form-control {
    padding: 0;
    margin-bottom: 0;
}

#memberGetContent .btn {
    width: 100%;
    padding: 10px 0;
}

#alertModal > .modal-dialog {
    width: 400px;
    margin-top: 200px;
}

#alertModal > .modal-dialog > .modal-content {
    border-radius: 10px;
}

#alertModal > .modal-dialog > .modal-content > .modal-header > h2 {
    color: #FF6E00;
    font-weight: 600;
    font-size: 22px;
    text-transform: uppercase;
    margin: 0;
}

#alertModal > .modal-dialog > .modal-content > .modal-body > p {
    color: #4A4A4A;
    font-size: 16px;
    margin-bottom: 10px;
}

#alertModal > .modal-dialog > .modal-content > .modal-footer {
    padding: 0;
    border-radius: 0 0 10px 10px;
    background-color: #FF6E00;
}

#alertModal > .modal-dialog > .modal-content > .modal-footer a {
    color: #FFFFFF;
    font-weight: 600;
    font-size: 22px;
}

#alertModal > .modal-dialog > .modal-content > .modal-footer a > .col-xs-6 {
    padding: 20px 0;
}


/* ---------------------------------
------- #. All Media Queries -------
----------------------------------*/

@media only screen and (min-width: 1200px) {

    /*---- ACCOUNT DETAILS ----*/

    .accDetailsOptions.alt {
        padding-bottom: 0;
    }

    /*---- STORE LIST ----*/

    #storeLoc .material-icons {
        width: 10%;
    }

    #storeLoc p {
        width: 90%;
    }

    .storeDetails .material-icons {
        width: 5%;
    }

    .storeDetails p {
        width: 95%;
    }
}

@media only screen and (min-width: 768px) {

    .navbar>.container .navbar-brand {
        margin-top: 4px;
    }

    .navbar .navbar-nav.navbar-left > li > .dropdown-menu {
        margin-top: 20% !important;
    }

    .navbar .navbar-nav.navbar-right > li > .dropdown-menu {
        margin-top: 8% !important;
    }

    .navbar .navbar-nav.navbar-left .dropdown-menu.first:after {
        border-bottom: 11px solid #FFFFFF;
        border-left: 11px solid rgba(0,0,0,0);
        border-right: 11px solid rgba(0,0,0,0);
        content: "";
        display: inline-block;
        position: absolute;
        left: 30px;
        top: -10px;
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu:after {
        border-bottom: 11px solid #FAFAFA;
        border-left: 11px solid rgba(0,0,0,0);
        border-right: 11px solid rgba(0,0,0,0);
        content: "";
        display: inline-block;
        position: absolute;
        right: 40px;
        top: -10px;
    }

    /*---- DASHBOARD ----*/

    /* Top Up Modal */

    #topupModal .modal-dialog {
        width: 450px;
    }

    /*---- MOVIE & GAME DETAILS ----*/

    #transactionModal .modal-dialog {
        width: 400px;
    }

    /* Rewards Claim */
    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.char {
        padding-right: 60px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim > .card span {
        padding-top: 10px;
        padding-left: 20px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim > .card img {
        width: 30%;
        margin-left: 10px;
        margin-right: 20px;
    }
}

@media only screen and (max-width: 991px) {
    #userData {
        padding: 30px;
    }

    #changePassHeader > .wrapper > h6 {
        margin-top: 5px;
    }

    /*---- SHOP PAGES ----*/

    .shopPages .content h2 {
        font-size: 22px;
    }

    .shopPages .content p {
        font-size: 12px;
        line-height: 16px;
    }

    .shopPages .content .btn {
        font-size: 12px;
    }

    .shopPages .photo img {
        width: 130%;
    }

    /*---- MARKET PAGES ----*/

    .marketPage-banner {
        height: 300px;
        max-height: 300px;
    }

    /* MOVIE & GAME DETAILS */

    .gameDetails .gameDetails-meta .metaDownload,
    .gameDetails .gameDetails-meta .metaRating {
        font-size: 34px;
        line-height: 1.5;
        width: 80px;
        height: 80px;
        padding: 10px;
        border: 2px solid #F57E20;
    }

    .gameDetails .gameDetails-meta .metaRating {
        border: 2px solid #F2C31A;
    }

    .gameDetails .gameDetails-meta .metaDownload > .metaDownload-caption,
    .gameDetails .gameDetails-meta .metaRating > .metaRating-caption {
        font-size: 10px;
        width: 75px;
        padding: 5px;
    }

    .gameDetails .gameDetails-meta .metaDownload-title,
    .gameDetails .gameDetails-meta .metaRating-title {
        font-size: 10px;
        width: 80px;
    }

    /*---- GAMIFY MONSTERS ----*/

    .gamifyMonsters .gamifyMonsters-content #rewards #cardNote {
        text-align: center;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right {
        margin-top: 25px;
    }

}

@media only screen and (max-width: 768px) {

    .overlay.active {
        display: none;
    }

    /*---- Navigation Bar ----*/

    .navbar .navbar-nav > li > a {
        margin-right: 0;
    }

    .dropdown-menu li > a:hover, 
    .dropdown-menu li > a:focus {
        box-shadow: none;
    }

    .modLeft {
        padding-left: 0px; 
        text-align: center;
    }

    .navbar-nav.sm-collapsible a.has-submenu {
        padding-right: 25px;
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData {
        width: 100%;
        padding: 20px 30px 5px;
        background-color: transparent;
    }

    .dividerBottom {
        border-bottom: 1px solid rgba(74, 74, 74, 0.10);
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData > h6 {
        color: #FFFFFF;
        text-align: center;
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu > li.navUserData > p {
        color: #FFFFFF;
        text-align: center;
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu > li > a {
        color: #FFFFFF;
    }

    .navbar .navbar-nav.navbar-left .dropdown-menu > li > a {
        color: #FFFFFF;
    }

    .navbar .navbar-nav.navbar-right .dropdown-menu > li > a > .material-icons {
        color: #FFFFFF;
    }

    /* Header */

    .header-general h1.no-breadcrumb {
        margin-top: 30px;
    }

    /*---- DASHBOARD ----*/

    .dividerRight {
        border-right: 0;
    }

    /* Section: Recommended Article */

    .articleSection {
        padding: 25px 0;
    }

    /*---- PROFILE ----*/

    /* Section: Meta Header */

    .header-general ul, .mod-breadcrumb {
        text-align: center;
        padding-left: 0;
    }

    .header-general h1 {
        text-align: center;
        padding-left: 0;
    }

    /*---- ACCOUNT DETAILS ----*/

    .accDetailsSubcard:after {
        height: 0;
        width: 0;
    }

    /*---- SHOP PAGES ----*/

    .shopPages .photo img {
        width: 120%;
    }

    /*---- LANDING PAGE ----*/

    .landingPage .landingPage-content .landingPage-body {
        text-align: center;
    }

    .landingPage .landingPage-cta {
        margin-bottom: 50px;
    }

    .landingPage .landingPage-app {
        margin-bottom: 25px;
    }

    .landingPage .landingPage-app .landingPage-appContent {
        width: 100%;
    }

    .landingPage .landingPage-app .landingPage-appContent .appContentIcon {
        margin-bottom: 10px;
    }

    .landingPage .landingPage-app .landingPage-appContent .appContentIcon, 
    .landingPage .landingPage-app .landingPage-appContent .appContentBody {
        text-align: center;
    }

    /*---- MOVIE & GAME DETAILS ----*/

    .movieDetails-details .detailsMovie > h1 {
        text-align: center;
    }

    .movieDetails-details .detailsMovie .imdbLogo {
        text-align: right;
    }

    .movieDetails-details .detailsMovie .imdbLogo > img {
        width: auto;
    } 

    .movieDetails-details .detailsMovie .imdbRate {
        padding-left: 15px;
    }

    .gameDetails-metaMobile {
        margin: 25px 0;
    }

    .metaDownload, .metaRating {
        color: #F57E20;
        font-weight: 700;
        font-size: 46px;
        line-height: 1.7;
        text-align: center;
        position: relative;
        width: 125px;
        height: 125px;
        padding: 20px;
        margin: 0 auto;
        border-radius: 50%;
        border: 3px solid #F57E20;
    }

    .metaRating {
        color: #424242;
        border: 3px solid #F2C31A;
    }

    .metaDownload > .metaDownload-caption,
    .metaRating > .metaRating-caption {
        color: #FFFFFF;
        font-weight: 400;
        font-size: 14px;
        text-align: center;
        position: absolute;
        bottom: -4px;
        left: 0;
        width: 120px;
        padding: 5px 20px;
        border-radius: 20px;
        background-color: #F57E20;
    }

    .metaRating > .metaRating-caption {
        background-color: #F2C31A;
    }

    .metaDownload-title,
    .metaRating-title {
        color: #424242;
        font-size: 14px;
        text-align: center;
        margin-top: 5px;
    }

    /* My Monsters */

    .glide--horizontal .carousel__arrows {
        width: 50%;
        margin-left: 25%;
    }    
}

@media only screen and (max-width: 600px) {

    /* Footer */

    .footer {
        margin-bottom: 130px;
    }

    .footer .footer-left {
        float: none;
        text-align: center;
        margin-bottom: 30px;
    }

    .footer .footer-right {
        float: none;
        text-align: center;
    }

    .footer .footer-right ul {
        padding-left: 0;
        text-align: center;
    }

    /*---- DASHBOARD ----*/

    /* Section: User Data */

    .userDataLabel .label.userDataLabelStatus {
        font-weight: 400;
        font-size: 12px;
        padding: 5px 10px;
    }

    .userDataLabel .label.userDataLabelDataType {
        font-weight: 400;
        font-size: 12px;
        padding: 5px 10px;
    }

    /* Section: Status Detail */

    .subCard .statusDetail, .subCard .statusDetail .promoEmpty {
        text-align: center;
    }

    .statusDetail .wowText {
        font-weight: 400;
        font-size: 14px;
        color: #9B9B9B;
        letter-spacing: 0.5px;
        line-height: 25px;
    }

    /* Section: Shortcut */

    #dashPage-shortcut img {
        width: 100%
    }

    /*---- MARKET PAGES ----*/

    .marketPage-banner {
        height: 200px;
        max-height: 200px;
    }

    .marketPage-banner img {
        width: 150%;
    }

    /* Rewards Claim */

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td {
        padding: 8px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td:last-child {
        font-size: 14px;
    }

    /* Member Get Member */

    #alertModal > .modal-dialog {
        width: auto;
        margin-top: 10px;
    }
}

@media only screen and (max-width: 435px) {

    /* Navigation Bar */

    .navbar > .container .navbar-brand {
        margin-top: 0;
    }

    /* Mod Breadcrumb */

    .mod-breadcrumb > li:after, .mod-breadcrumb > li > a {
        font-size: 10px;
    }

    /*---- DASHBOARD ----*/

    /* Section: User Data */

    .userDataLabel .label.userDataLabelStatus {
        display: block;
        font-weight: 400;
        font-size: 9px;
        padding: 5px 5px;
        margin-right: 0;
        margin-bottom: 5px;
    }

    .userDataLabel .label.userDataLabelDataType {
        display: block;
        font-weight: 400;
        font-size: 9px;
        padding: 5px 5px;
    }

    /* Section: Shortcut */

    #dashPage-shortcut .subCard {
        padding: 5px 0;
    }

    /* Section: Data Package > Top Up Modal */

    #bankinAccContent {
        padding: 5px 20px 20px;
    }

    #topupModal .modal-dialog {
        margin-top: 10px;
    }

    #nav-pills-topup > li {
        padding: 0 2px;
    }

    #nav-pills-topup > li > a {
        width: 50px;
        min-width: 50px;
        height: 50px;
        padding: 0;
        font-size: 9px;
    }

    #nav-pills-topup > li > a > span {
        font-size: 16px;
        line-height: 40px;
        margin-top: 0;
        margin-bottom: -5px;
    }

    /*---- PROFILE ----*/

    .userOptions-icon {
        margin-right: 0;
    }

    .userOptions-icon .material-icons {
        font-size: 26px;
    }

    .userOptions-title h6 {
        font-size: 14px;
    }

    /*---- CHANGE PASSWORD ----*/

    #changePassHeader > .wrapper > img {
        width: 20%;
        height: auto;
        margin-right: 0;
    }

    #changePassHeader > .wrapper > h6 {
        float: right;
        width: 80%;
        padding-left: 10px;
    }

    /*---- SCRATCH CARD & CHANGE PASS ----*/

    #scratchCardContent, #changePassContent {
        width: 250px;
    }

    /*---- STORE LIST ----*/

    #storeTitle h2 {
        text-align: center;
    }

    #storePlace p {
        padding-right: 25px;
    }

    #storeLoc p {
        padding-right: 40px;
    }

    /*---- SHOP PAGES ----*/

    .shopPages .content {
        height: auto;
        max-height: 100%;
    }

    .shopPages .photo img {
        width: 180%;
    }

    /*---- MARKET PAGES ----*/

    .marketPage-sectionTitle .sectionTitle-title > h2 {
        font-size: 14px;
    }

    .marketPage-sectionTitle .sectionTitle-more {
        padding-top: 0;
    }

    .marketPage-sectionTitle .sectionTitle-more > a {
        font-size: 14px;
    }

    /*---- MOVIE & GAME DETAILS ----*/

    .table.movieMeta > tbody > tr > th,
    .table.movieMeta > tbody > tr > td {
        font-size: 14px;
    }

    #transactionModal .modal-dialog {
        margin-top: 10px;
    }

    /*---- SELF PACKAGES ----*/

    .nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li {
        padding: 10px 15px;
        border: 1px solid #FF6E00;
    }

    .nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li > a {
        color: #FF6E00 !important;
        font-weight: 600;
        font-size: 14px;
        text-transform: capitalize;
        padding: 0;
    }

    .nav-tabs-navigation > .nav-tabs-wrapper > .nav-tabs > li.active > a {
        color: #FFFFFF !important;
        background-color: transparent;
    }

    .selfPackages .selfPackages-content .sliderTitle .sliderLabel {
        font-size: 12px;
    }

    .selfPackages .selfPackages-content .sliderTitle .sliderPoint {
        font-size: 12px;
        text-align: right;
    }

    /*---- GAMIFY MONSTERS ----*/

    .gamifyMonsters .gamifyMonsters-content #rewards .card #giftTitle {
        font-size: 16px;
        line-height: 1;
        padding: 25px 0 15px 20px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards .card #giftImage {
        padding: 20px 20px 15px 0;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards .card #giftImage > img {
        width: 50px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards .card #giftControl {
        padding: 25px 20px 15px 0;
    }

    #howModalContent > .modal-dialog {
        margin-top: 10px;
    }

    /* Rewards */

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:last-child > .btn {
        font-size: 14px;
        width: 100%;
        padding: 10px;
        box-shadow: none;
        border-radius: 25px;
    }

    .glide--horizontal .carousel__arrows {
        width: 96%;
        margin-left: 2%;
    }    
}

@media only screen and (max-width: 375px) {
    /* Rewards */

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td {
        padding: 20px 0;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:first-child {
        font-size: 12px;
        width: 10%;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td.td-actions {
        width: 80%;
        min-width: 160px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:last-child {
        font-size: 12px;
        width: 10%
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table tr > td:last-child > .btn {
        font-size: 10px;
        width: 100%;
        padding: 8px;
        box-shadow: none;
        border-radius: 25px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewards-right > .table > tbody > tr > td.td-actions > button > .material-icons {
        font-size: 16px;
    }

    /* Rewards Claim */

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl {
        min-width: 110px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > button > .material-icons {
        font-size: 18px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.claimControl > input {
        width: 20px;
    }

    .gamifyMonsters .gamifyMonsters-content #rewards #rewardsClaim .table > tbody > tr > td.char > img {
        margin: 0 5px;
    }
}



/*!
 * Bootstrap v3.3.7 (http://getbootstrap.com)
 * Copyright 2011-2016 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 *//*! normalize.css v3.0.3 | MIT License | github.com/necolas/normalize.css */html{font-family:sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%}body{margin:0}article,aside,details,figcaption,figure,footer,header,hgroup,main,menu,nav,section,summary{display:block}audio,canvas,progress,video{display:inline-block;vertical-align:baseline}audio:not([controls]){display:none;height:0}[hidden],template{display:none}a{background-color:transparent}a:active,a:hover{outline:0}abbr[title]{border-bottom:1px dotted}b,strong{font-weight:700}dfn{font-style:italic}h1{margin:.67em 0;font-size:2em}mark{color:#000;background:#ff0}small{font-size:80%}sub,sup{position:relative;font-size:75%;line-height:0;vertical-align:baseline}sup{top:-.5em}sub{bottom:-.25em}img{border:0}svg:not(:root){overflow:hidden}figure{margin:1em 40px}hr{height:0;-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box}pre{overflow:auto}code,kbd,pre,samp{font-family:monospace,monospace;font-size:1em}button,input,optgroup,select,textarea{margin:0;font:inherit;color:inherit}button{overflow:visible}button,select{text-transform:none}button,html input[type=button],input[type=reset],input[type=submit]{-webkit-appearance:button;cursor:pointer}button[disabled],html input[disabled]{cursor:default}button::-moz-focus-inner,input::-moz-focus-inner{padding:0;border:0}input{line-height:normal}input[type=checkbox],input[type=radio]{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;padding:0}input[type=number]::-webkit-inner-spin-button,input[type=number]::-webkit-outer-spin-button{height:auto}input[type=search]{-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;-webkit-appearance:textfield}input[type=search]::-webkit-search-cancel-button,input[type=search]::-webkit-search-decoration{-webkit-appearance:none}fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver}legend{padding:0;border:0}textarea{overflow:auto}optgroup{font-weight:700}table{border-spacing:0;border-collapse:collapse}td,th{padding:0}/*! Source: https://github.com/h5bp/html5-boilerplate/blob/master/src/css/main.css */@media print{*,:after,:before{color:#000!important;text-shadow:none!important;background:0 0!important;-webkit-box-shadow:none!important;box-shadow:none!important}a,a:visited{text-decoration:underline}a[href]:after{content:" (" attr(href) ")"}abbr[title]:after{content:" (" attr(title) ")"}a[href^="javascript:"]:after,a[href^="#"]:after{content:""}blockquote,pre{border:1px solid #999;page-break-inside:avoid}thead{display:table-header-group}img,tr{page-break-inside:avoid}img{max-width:100%!important}h2,h3,p{orphans:3;widows:3}h2,h3{page-break-after:avoid}.navbar{display:none}.btn>.caret,.dropup>.btn>.caret{border-top-color:#000!important}.label{border:1px solid #000}.table{border-collapse:collapse!important}.table td,.table th{background-color:#fff!important}.table-bordered td,.table-bordered th{border:1px solid #ddd!important}}@font-face{font-family:'Glyphicons Halflings';src:url(../fonts/glyphicons-halflings-regular.eot);src:url(../fonts/glyphicons-halflings-regular.eot?#iefix) format('embedded-opentype'),url(../fonts/glyphicons-halflings-regular.woff2) format('woff2'),url(../fonts/glyphicons-halflings-regular.woff) format('woff'),url(../fonts/glyphicons-halflings-regular.ttf) format('truetype'),url(../fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular) format('svg')}.glyphicon{position:relative;top:1px;display:inline-block;font-family:'Glyphicons Halflings';font-style:normal;font-weight:400;line-height:1;-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale}.glyphicon-asterisk:before{content:"\002a"}.glyphicon-plus:before{content:"\002b"}.glyphicon-eur:before,.glyphicon-euro:before{content:"\20ac"}.glyphicon-minus:before{content:"\2212"}.glyphicon-cloud:before{content:"\2601"}.glyphicon-envelope:before{content:"\2709"}.glyphicon-pencil:before{content:"\270f"}.glyphicon-glass:before{content:"\e001"}.glyphicon-music:before{content:"\e002"}.glyphicon-search:before{content:"\e003"}.glyphicon-heart:before{content:"\e005"}.glyphicon-star:before{content:"\e006"}.glyphicon-star-empty:before{content:"\e007"}.glyphicon-user:before{content:"\e008"}.glyphicon-film:before{content:"\e009"}.glyphicon-th-large:before{content:"\e010"}.glyphicon-th:before{content:"\e011"}.glyphicon-th-list:before{content:"\e012"}.glyphicon-ok:before{content:"\e013"}.glyphicon-remove:before{content:"\e014"}.glyphicon-zoom-in:before{content:"\e015"}.glyphicon-zoom-out:before{content:"\e016"}.glyphicon-off:before{content:"\e017"}.glyphicon-signal:before{content:"\e018"}.glyphicon-cog:before{content:"\e019"}.glyphicon-trash:before{content:"\e020"}.glyphicon-home:before{content:"\e021"}.glyphicon-file:before{content:"\e022"}.glyphicon-time:before{content:"\e023"}.glyphicon-road:before{content:"\e024"}.glyphicon-download-alt:before{content:"\e025"}.glyphicon-download:before{content:"\e026"}.glyphicon-upload:before{content:"\e027"}.glyphicon-inbox:before{content:"\e028"}.glyphicon-play-circle:before{content:"\e029"}.glyphicon-repeat:before{content:"\e030"}.glyphicon-refresh:before{content:"\e031"}.glyphicon-list-alt:before{content:"\e032"}.glyphicon-lock:before{content:"\e033"}.glyphicon-flag:before{content:"\e034"}.glyphicon-headphones:before{content:"\e035"}.glyphicon-volume-off:before{content:"\e036"}.glyphicon-volume-down:before{content:"\e037"}.glyphicon-volume-up:before{content:"\e038"}.glyphicon-qrcode:before{content:"\e039"}.glyphicon-barcode:before{content:"\e040"}.glyphicon-tag:before{content:"\e041"}.glyphicon-tags:before{content:"\e042"}.glyphicon-book:before{content:"\e043"}.glyphicon-bookmark:before{content:"\e044"}.glyphicon-print:before{content:"\e045"}.glyphicon-camera:before{content:"\e046"}.glyphicon-font:before{content:"\e047"}.glyphicon-bold:before{content:"\e048"}.glyphicon-italic:before{content:"\e049"}.glyphicon-text-height:before{content:"\e050"}.glyphicon-text-width:before{content:"\e051"}.glyphicon-align-left:before{content:"\e052"}.glyphicon-align-center:before{content:"\e053"}.glyphicon-align-right:before{content:"\e054"}.glyphicon-align-justify:before{content:"\e055"}.glyphicon-list:before{content:"\e056"}.glyphicon-indent-left:before{content:"\e057"}.glyphicon-indent-right:before{content:"\e058"}.glyphicon-facetime-video:before{content:"\e059"}.glyphicon-picture:before{content:"\e060"}.glyphicon-map-marker:before{content:"\e062"}.glyphicon-adjust:before{content:"\e063"}.glyphicon-tint:before{content:"\e064"}.glyphicon-edit:before{content:"\e065"}.glyphicon-share:before{content:"\e066"}.glyphicon-check:before{content:"\e067"}.glyphicon-move:before{content:"\e068"}.glyphicon-step-backward:before{content:"\e069"}.glyphicon-fast-backward:before{content:"\e070"}.glyphicon-backward:before{content:"\e071"}.glyphicon-play:before{content:"\e072"}.glyphicon-pause:before{content:"\e073"}.glyphicon-stop:before{content:"\e074"}.glyphicon-forward:before{content:"\e075"}.glyphicon-fast-forward:before{content:"\e076"}.glyphicon-step-forward:before{content:"\e077"}.glyphicon-eject:before{content:"\e078"}.glyphicon-chevron-left:before{content:"\e079"}.glyphicon-chevron-right:before{content:"\e080"}.glyphicon-plus-sign:before{content:"\e081"}.glyphicon-minus-sign:before{content:"\e082"}.glyphicon-remove-sign:before{content:"\e083"}.glyphicon-ok-sign:before{content:"\e084"}.glyphicon-question-sign:before{content:"\e085"}.glyphicon-info-sign:before{content:"\e086"}.glyphicon-screenshot:before{content:"\e087"}.glyphicon-remove-circle:before{content:"\e088"}.glyphicon-ok-circle:before{content:"\e089"}.glyphicon-ban-circle:before{content:"\e090"}.glyphicon-arrow-left:before{content:"\e091"}.glyphicon-arrow-right:before{content:"\e092"}.glyphicon-arrow-up:before{content:"\e093"}.glyphicon-arrow-down:before{content:"\e094"}.glyphicon-share-alt:before{content:"\e095"}.glyphicon-resize-full:before{content:"\e096"}.glyphicon-resize-small:before{content:"\e097"}.glyphicon-exclamation-sign:before{content:"\e101"}.glyphicon-gift:before{content:"\e102"}.glyphicon-leaf:before{content:"\e103"}.glyphicon-fire:before{content:"\e104"}.glyphicon-eye-open:before{content:"\e105"}.glyphicon-eye-close:before{content:"\e106"}.glyphicon-warning-sign:before{content:"\e107"}.glyphicon-plane:before{content:"\e108"}.glyphicon-calendar:before{content:"\e109"}.glyphicon-random:before{content:"\e110"}.glyphicon-comment:before{content:"\e111"}.glyphicon-magnet:before{content:"\e112"}.glyphicon-chevron-up:before{content:"\e113"}.glyphicon-chevron-down:before{content:"\e114"}.glyphicon-retweet:before{content:"\e115"}.glyphicon-shopping-cart:before{content:"\e116"}.glyphicon-folder-close:before{content:"\e117"}.glyphicon-folder-open:before{content:"\e118"}.glyphicon-resize-vertical:before{content:"\e119"}.glyphicon-resize-horizontal:before{content:"\e120"}.glyphicon-hdd:before{content:"\e121"}.glyphicon-bullhorn:before{content:"\e122"}.glyphicon-bell:before{content:"\e123"}.glyphicon-certificate:before{content:"\e124"}.glyphicon-thumbs-up:before{content:"\e125"}.glyphicon-thumbs-down:before{content:"\e126"}.glyphicon-hand-right:before{content:"\e127"}.glyphicon-hand-left:before{content:"\e128"}.glyphicon-hand-up:before{content:"\e129"}.glyphicon-hand-down:before{content:"\e130"}.glyphicon-circle-arrow-right:before{content:"\e131"}.glyphicon-circle-arrow-left:before{content:"\e132"}.glyphicon-circle-arrow-up:before{content:"\e133"}.glyphicon-circle-arrow-down:before{content:"\e134"}.glyphicon-globe:before{content:"\e135"}.glyphicon-wrench:before{content:"\e136"}.glyphicon-tasks:before{content:"\e137"}.glyphicon-filter:before{content:"\e138"}.glyphicon-briefcase:before{content:"\e139"}.glyphicon-fullscreen:before{content:"\e140"}.glyphicon-dashboard:before{content:"\e141"}.glyphicon-paperclip:before{content:"\e142"}.glyphicon-heart-empty:before{content:"\e143"}.glyphicon-link:before{content:"\e144"}.glyphicon-phone:before{content:"\e145"}.glyphicon-pushpin:before{content:"\e146"}.glyphicon-usd:before{content:"\e148"}.glyphicon-gbp:before{content:"\e149"}.glyphicon-sort:before{content:"\e150"}.glyphicon-sort-by-alphabet:before{content:"\e151"}.glyphicon-sort-by-alphabet-alt:before{content:"\e152"}.glyphicon-sort-by-order:before{content:"\e153"}.glyphicon-sort-by-order-alt:before{content:"\e154"}.glyphicon-sort-by-attributes:before{content:"\e155"}.glyphicon-sort-by-attributes-alt:before{content:"\e156"}.glyphicon-unchecked:before{content:"\e157"}.glyphicon-expand:before{content:"\e158"}.glyphicon-collapse-down:before{content:"\e159"}.glyphicon-collapse-up:before{content:"\e160"}.glyphicon-log-in:before{content:"\e161"}.glyphicon-flash:before{content:"\e162"}.glyphicon-log-out:before{content:"\e163"}.glyphicon-new-window:before{content:"\e164"}.glyphicon-record:before{content:"\e165"}.glyphicon-save:before{content:"\e166"}.glyphicon-open:before{content:"\e167"}.glyphicon-saved:before{content:"\e168"}.glyphicon-import:before{content:"\e169"}.glyphicon-export:before{content:"\e170"}.glyphicon-send:before{content:"\e171"}.glyphicon-floppy-disk:before{content:"\e172"}.glyphicon-floppy-saved:before{content:"\e173"}.glyphicon-floppy-remove:before{content:"\e174"}.glyphicon-floppy-save:before{content:"\e175"}.glyphicon-floppy-open:before{content:"\e176"}.glyphicon-credit-card:before{content:"\e177"}.glyphicon-transfer:before{content:"\e178"}.glyphicon-cutlery:before{content:"\e179"}.glyphicon-header:before{content:"\e180"}.glyphicon-compressed:before{content:"\e181"}.glyphicon-earphone:before{content:"\e182"}.glyphicon-phone-alt:before{content:"\e183"}.glyphicon-tower:before{content:"\e184"}.glyphicon-stats:before{content:"\e185"}.glyphicon-sd-video:before{content:"\e186"}.glyphicon-hd-video:before{content:"\e187"}.glyphicon-subtitles:before{content:"\e188"}.glyphicon-sound-stereo:before{content:"\e189"}.glyphicon-sound-dolby:before{content:"\e190"}.glyphicon-sound-5-1:before{content:"\e191"}.glyphicon-sound-6-1:before{content:"\e192"}.glyphicon-sound-7-1:before{content:"\e193"}.glyphicon-copyright-mark:before{content:"\e194"}.glyphicon-registration-mark:before{content:"\e195"}.glyphicon-cloud-download:before{content:"\e197"}.glyphicon-cloud-upload:before{content:"\e198"}.glyphicon-tree-conifer:before{content:"\e199"}.glyphicon-tree-deciduous:before{content:"\e200"}.glyphicon-cd:before{content:"\e201"}.glyphicon-save-file:before{content:"\e202"}.glyphicon-open-file:before{content:"\e203"}.glyphicon-level-up:before{content:"\e204"}.glyphicon-copy:before{content:"\e205"}.glyphicon-paste:before{content:"\e206"}.glyphicon-alert:before{content:"\e209"}.glyphicon-equalizer:before{content:"\e210"}.glyphicon-king:before{content:"\e211"}.glyphicon-queen:before{content:"\e212"}.glyphicon-pawn:before{content:"\e213"}.glyphicon-bishop:before{content:"\e214"}.glyphicon-knight:before{content:"\e215"}.glyphicon-baby-formula:before{content:"\e216"}.glyphicon-tent:before{content:"\26fa"}.glyphicon-blackboard:before{content:"\e218"}.glyphicon-bed:before{content:"\e219"}.glyphicon-apple:before{content:"\f8ff"}.glyphicon-erase:before{content:"\e221"}.glyphicon-hourglass:before{content:"\231b"}.glyphicon-lamp:before{content:"\e223"}.glyphicon-duplicate:before{content:"\e224"}.glyphicon-piggy-bank:before{content:"\e225"}.glyphicon-scissors:before{content:"\e226"}.glyphicon-bitcoin:before{content:"\e227"}.glyphicon-btc:before{content:"\e227"}.glyphicon-xbt:before{content:"\e227"}.glyphicon-yen:before{content:"\00a5"}.glyphicon-jpy:before{content:"\00a5"}.glyphicon-ruble:before{content:"\20bd"}.glyphicon-rub:before{content:"\20bd"}.glyphicon-scale:before{content:"\e230"}.glyphicon-ice-lolly:before{content:"\e231"}.glyphicon-ice-lolly-tasted:before{content:"\e232"}.glyphicon-education:before{content:"\e233"}.glyphicon-option-horizontal:before{content:"\e234"}.glyphicon-option-vertical:before{content:"\e235"}.glyphicon-menu-hamburger:before{content:"\e236"}.glyphicon-modal-window:before{content:"\e237"}.glyphicon-oil:before{content:"\e238"}.glyphicon-grain:before{content:"\e239"}.glyphicon-sunglasses:before{content:"\e240"}.glyphicon-text-size:before{content:"\e241"}.glyphicon-text-color:before{content:"\e242"}.glyphicon-text-background:before{content:"\e243"}.glyphicon-object-align-top:before{content:"\e244"}.glyphicon-object-align-bottom:before{content:"\e245"}.glyphicon-object-align-horizontal:before{content:"\e246"}.glyphicon-object-align-left:before{content:"\e247"}.glyphicon-object-align-vertical:before{content:"\e248"}.glyphicon-object-align-right:before{content:"\e249"}.glyphicon-triangle-right:before{content:"\e250"}.glyphicon-triangle-left:before{content:"\e251"}.glyphicon-triangle-bottom:before{content:"\e252"}.glyphicon-triangle-top:before{content:"\e253"}.glyphicon-console:before{content:"\e254"}.glyphicon-superscript:before{content:"\e255"}.glyphicon-subscript:before{content:"\e256"}.glyphicon-menu-left:before{content:"\e257"}.glyphicon-menu-right:before{content:"\e258"}.glyphicon-menu-down:before{content:"\e259"}.glyphicon-menu-up:before{content:"\e260"}*{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}:after,:before{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}html{font-size:10px;-webkit-tap-highlight-color:rgba(0,0,0,0)}body{font-family:"Helvetica Neue",Helvetica,Arial,sans-serif;font-size:14px;line-height:1.42857143;color:#333;background-color:#fff}button,input,select,textarea{font-family:inherit;font-size:inherit;line-height:inherit}a{color:#337ab7;text-decoration:none}a:focus,a:hover{color:#23527c;text-decoration:underline}a:focus{outline:5px auto -webkit-focus-ring-color;outline-offset:-2px}figure{margin:0}img{vertical-align:middle}.carousel-inner>.item>a>img,.carousel-inner>.item>img,.img-responsive,.thumbnail a>img,.thumbnail>img{display:block;max-width:100%;height:auto}.img-rounded{border-radius:6px}.img-thumbnail{display:inline-block;max-width:100%;height:auto;padding:4px;line-height:1.42857143;background-color:#fff;border:1px solid #ddd;border-radius:4px;-webkit-transition:all .2s ease-in-out;-o-transition:all .2s ease-in-out;transition:all .2s ease-in-out}.img-circle{border-radius:50%}hr{margin-top:20px;margin-bottom:20px;border:0;border-top:1px solid #eee}.sr-only{position:absolute;width:1px;height:1px;padding:0;margin:-1px;overflow:hidden;clip:rect(0,0,0,0);border:0}.sr-only-focusable:active,.sr-only-focusable:focus{position:static;width:auto;height:auto;margin:0;overflow:visible;clip:auto}[role=button]{cursor:pointer}.h1,.h2,.h3,.h4,.h5,.h6,h1,h2,h3,h4,h5,h6{font-family:inherit;font-weight:500;line-height:1.1;color:inherit}.h1 .small,.h1 small,.h2 .small,.h2 small,.h3 .small,.h3 small,.h4 .small,.h4 small,.h5 .small,.h5 small,.h6 .small,.h6 small,h1 .small,h1 small,h2 .small,h2 small,h3 .small,h3 small,h4 .small,h4 small,h5 .small,h5 small,h6 .small,h6 small{font-weight:400;line-height:1;color:#777}.h1,.h2,.h3,h1,h2,h3{margin-top:20px;margin-bottom:10px}.h1 .small,.h1 small,.h2 .small,.h2 small,.h3 .small,.h3 small,h1 .small,h1 small,h2 .small,h2 small,h3 .small,h3 small{font-size:65%}.h4,.h5,.h6,h4,h5,h6{margin-top:10px;margin-bottom:10px}.h4 .small,.h4 small,.h5 .small,.h5 small,.h6 .small,.h6 small,h4 .small,h4 small,h5 .small,h5 small,h6 .small,h6 small{font-size:75%}.h1,h1{font-size:36px}.h2,h2{font-size:30px}.h3,h3{font-size:24px}.h4,h4{font-size:18px}.h5,h5{font-size:14px}.h6,h6{font-size:12px}p{margin:0 0 10px}.lead{margin-bottom:20px;font-size:16px;font-weight:300;line-height:1.4}@media (min-width:768px){.lead{font-size:21px}}.small,small{font-size:85%}.mark,mark{padding:.2em;background-color:#fcf8e3}.text-left{text-align:left}.text-right{text-align:right}.text-center{text-align:center}.text-justify{text-align:justify}.text-nowrap{white-space:nowrap}.text-lowercase{text-transform:lowercase}.text-uppercase{text-transform:uppercase}.text-capitalize{text-transform:capitalize}.text-muted{color:#777}.text-primary{color:#337ab7}a.text-primary:focus,a.text-primary:hover{color:#286090}.text-success{color:#3c763d}a.text-success:focus,a.text-success:hover{color:#2b542c}.text-info{color:#31708f}a.text-info:focus,a.text-info:hover{color:#245269}.text-warning{color:#8a6d3b}a.text-warning:focus,a.text-warning:hover{color:#66512c}.text-danger{color:#a94442}a.text-danger:focus,a.text-danger:hover{color:#843534}.bg-primary{color:#fff;background-color:#337ab7}a.bg-primary:focus,a.bg-primary:hover{background-color:#286090}.bg-success{background-color:#dff0d8}a.bg-success:focus,a.bg-success:hover{background-color:#c1e2b3}.bg-info{background-color:#d9edf7}a.bg-info:focus,a.bg-info:hover{background-color:#afd9ee}.bg-warning{background-color:#fcf8e3}a.bg-warning:focus,a.bg-warning:hover{background-color:#f7ecb5}.bg-danger{background-color:#f2dede}a.bg-danger:focus,a.bg-danger:hover{background-color:#e4b9b9}.page-header{padding-bottom:9px;margin:40px 0 20px;border-bottom:1px solid #eee}ol,ul{margin-top:0;margin-bottom:10px}ol ol,ol ul,ul ol,ul ul{margin-bottom:0}.list-unstyled{padding-left:0;list-style:none}.list-inline{padding-left:0;margin-left:-5px;list-style:none}.list-inline>li{display:inline-block;padding-right:5px;padding-left:5px}dl{margin-top:0;margin-bottom:20px}dd,dt{line-height:1.42857143}dt{font-weight:700}dd{margin-left:0}@media (min-width:768px){.dl-horizontal dt{float:left;width:160px;overflow:hidden;clear:left;text-align:right;text-overflow:ellipsis;white-space:nowrap}.dl-horizontal dd{margin-left:180px}}abbr[data-original-title],abbr[title]{cursor:help;border-bottom:1px dotted #777}.initialism{font-size:90%;text-transform:uppercase}blockquote{padding:10px 20px;margin:0 0 20px;font-size:17.5px;border-left:5px solid #eee}blockquote ol:last-child,blockquote p:last-child,blockquote ul:last-child{margin-bottom:0}blockquote .small,blockquote footer,blockquote small{display:block;font-size:80%;line-height:1.42857143;color:#777}blockquote .small:before,blockquote footer:before,blockquote small:before{content:'\2014 \00A0'}.blockquote-reverse,blockquote.pull-right{padding-right:15px;padding-left:0;text-align:right;border-right:5px solid #eee;border-left:0}.blockquote-reverse .small:before,.blockquote-reverse footer:before,.blockquote-reverse small:before,blockquote.pull-right .small:before,blockquote.pull-right footer:before,blockquote.pull-right small:before{content:''}.blockquote-reverse .small:after,.blockquote-reverse footer:after,.blockquote-reverse small:after,blockquote.pull-right .small:after,blockquote.pull-right footer:after,blockquote.pull-right small:after{content:'\00A0 \2014'}address{margin-bottom:20px;font-style:normal;line-height:1.42857143}code,kbd,pre,samp{font-family:Menlo,Monaco,Consolas,"Courier New",monospace}code{padding:2px 4px;font-size:90%;color:#c7254e;background-color:#f9f2f4;border-radius:4px}kbd{padding:2px 4px;font-size:90%;color:#fff;background-color:#333;border-radius:3px;-webkit-box-shadow:inset 0 -1px 0 rgba(0,0,0,.25);box-shadow:inset 0 -1px 0 rgba(0,0,0,.25)}kbd kbd{padding:0;font-size:100%;font-weight:700;-webkit-box-shadow:none;box-shadow:none}pre{display:block;padding:9.5px;margin:0 0 10px;font-size:13px;line-height:1.42857143;color:#333;word-break:break-all;word-wrap:break-word;background-color:#f5f5f5;border:1px solid #ccc;border-radius:4px}pre code{padding:0;font-size:inherit;color:inherit;white-space:pre-wrap;background-color:transparent;border-radius:0}.pre-scrollable{max-height:340px;overflow-y:scroll}.container{padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}@media (min-width:768px){.container{width:750px}}@media (min-width:992px){.container{width:970px}}@media (min-width:1200px){.container{width:1170px}}.container-fluid{padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}.row{margin-right:-15px;margin-left:-15px}.col-lg-1,.col-lg-10,.col-lg-11,.col-lg-12,.col-lg-2,.col-lg-3,.col-lg-4,.col-lg-5,.col-lg-6,.col-lg-7,.col-lg-8,.col-lg-9,.col-md-1,.col-md-10,.col-md-11,.col-md-12,.col-md-2,.col-md-3,.col-md-4,.col-md-5,.col-md-6,.col-md-7,.col-md-8,.col-md-9,.col-sm-1,.col-sm-10,.col-sm-11,.col-sm-12,.col-sm-2,.col-sm-3,.col-sm-4,.col-sm-5,.col-sm-6,.col-sm-7,.col-sm-8,.col-sm-9,.col-xs-1,.col-xs-10,.col-xs-11,.col-xs-12,.col-xs-2,.col-xs-3,.col-xs-4,.col-xs-5,.col-xs-6,.col-xs-7,.col-xs-8,.col-xs-9{position:relative;min-height:1px;padding-right:15px;padding-left:15px}.col-xs-1,.col-xs-10,.col-xs-11,.col-xs-12,.col-xs-2,.col-xs-3,.col-xs-4,.col-xs-5,.col-xs-6,.col-xs-7,.col-xs-8,.col-xs-9{float:left}.col-xs-12{width:100%}.col-xs-11{width:91.66666667%}.col-xs-10{width:83.33333333%}.col-xs-9{width:75%}.col-xs-8{width:66.66666667%}.col-xs-7{width:58.33333333%}.col-xs-6{width:50%}.col-xs-5{width:41.66666667%}.col-xs-4{width:33.33333333%}.col-xs-3{width:25%}.col-xs-2{width:16.66666667%}.col-xs-1{width:8.33333333%}.col-xs-pull-12{right:100%}.col-xs-pull-11{right:91.66666667%}.col-xs-pull-10{right:83.33333333%}.col-xs-pull-9{right:75%}.col-xs-pull-8{right:66.66666667%}.col-xs-pull-7{right:58.33333333%}.col-xs-pull-6{right:50%}.col-xs-pull-5{right:41.66666667%}.col-xs-pull-4{right:33.33333333%}.col-xs-pull-3{right:25%}.col-xs-pull-2{right:16.66666667%}.col-xs-pull-1{right:8.33333333%}.col-xs-pull-0{right:auto}.col-xs-push-12{left:100%}.col-xs-push-11{left:91.66666667%}.col-xs-push-10{left:83.33333333%}.col-xs-push-9{left:75%}.col-xs-push-8{left:66.66666667%}.col-xs-push-7{left:58.33333333%}.col-xs-push-6{left:50%}.col-xs-push-5{left:41.66666667%}.col-xs-push-4{left:33.33333333%}.col-xs-push-3{left:25%}.col-xs-push-2{left:16.66666667%}.col-xs-push-1{left:8.33333333%}.col-xs-push-0{left:auto}.col-xs-offset-12{margin-left:100%}.col-xs-offset-11{margin-left:91.66666667%}.col-xs-offset-10{margin-left:83.33333333%}.col-xs-offset-9{margin-left:75%}.col-xs-offset-8{margin-left:66.66666667%}.col-xs-offset-7{margin-left:58.33333333%}.col-xs-offset-6{margin-left:50%}.col-xs-offset-5{margin-left:41.66666667%}.col-xs-offset-4{margin-left:33.33333333%}.col-xs-offset-3{margin-left:25%}.col-xs-offset-2{margin-left:16.66666667%}.col-xs-offset-1{margin-left:8.33333333%}.col-xs-offset-0{margin-left:0}@media (min-width:768px){.col-sm-1,.col-sm-10,.col-sm-11,.col-sm-12,.col-sm-2,.col-sm-3,.col-sm-4,.col-sm-5,.col-sm-6,.col-sm-7,.col-sm-8,.col-sm-9{float:left}.col-sm-12{width:100%}.col-sm-11{width:91.66666667%}.col-sm-10{width:83.33333333%}.col-sm-9{width:75%}.col-sm-8{width:66.66666667%}.col-sm-7{width:58.33333333%}.col-sm-6{width:50%}.col-sm-5{width:41.66666667%}.col-sm-4{width:33.33333333%}.col-sm-3{width:25%}.col-sm-2{width:16.66666667%}.col-sm-1{width:8.33333333%}.col-sm-pull-12{right:100%}.col-sm-pull-11{right:91.66666667%}.col-sm-pull-10{right:83.33333333%}.col-sm-pull-9{right:75%}.col-sm-pull-8{right:66.66666667%}.col-sm-pull-7{right:58.33333333%}.col-sm-pull-6{right:50%}.col-sm-pull-5{right:41.66666667%}.col-sm-pull-4{right:33.33333333%}.col-sm-pull-3{right:25%}.col-sm-pull-2{right:16.66666667%}.col-sm-pull-1{right:8.33333333%}.col-sm-pull-0{right:auto}.col-sm-push-12{left:100%}.col-sm-push-11{left:91.66666667%}.col-sm-push-10{left:83.33333333%}.col-sm-push-9{left:75%}.col-sm-push-8{left:66.66666667%}.col-sm-push-7{left:58.33333333%}.col-sm-push-6{left:50%}.col-sm-push-5{left:41.66666667%}.col-sm-push-4{left:33.33333333%}.col-sm-push-3{left:25%}.col-sm-push-2{left:16.66666667%}.col-sm-push-1{left:8.33333333%}.col-sm-push-0{left:auto}.col-sm-offset-12{margin-left:100%}.col-sm-offset-11{margin-left:91.66666667%}.col-sm-offset-10{margin-left:83.33333333%}.col-sm-offset-9{margin-left:75%}.col-sm-offset-8{margin-left:66.66666667%}.col-sm-offset-7{margin-left:58.33333333%}.col-sm-offset-6{margin-left:50%}.col-sm-offset-5{margin-left:41.66666667%}.col-sm-offset-4{margin-left:33.33333333%}.col-sm-offset-3{margin-left:25%}.col-sm-offset-2{margin-left:16.66666667%}.col-sm-offset-1{margin-left:8.33333333%}.col-sm-offset-0{margin-left:0}}@media (min-width:992px){.col-md-1,.col-md-10,.col-md-11,.col-md-12,.col-md-2,.col-md-3,.col-md-4,.col-md-5,.col-md-6,.col-md-7,.col-md-8,.col-md-9{float:left}.col-md-12{width:100%}.col-md-11{width:91.66666667%}.col-md-10{width:83.33333333%}.col-md-9{width:75%}.col-md-8{width:66.66666667%}.col-md-7{width:58.33333333%}.col-md-6{width:50%}.col-md-5{width:41.66666667%}.col-md-4{width:33.33333333%}.col-md-3{width:25%}.col-md-2{width:16.66666667%}.col-md-1{width:8.33333333%}.col-md-pull-12{right:100%}.col-md-pull-11{right:91.66666667%}.col-md-pull-10{right:83.33333333%}.col-md-pull-9{right:75%}.col-md-pull-8{right:66.66666667%}.col-md-pull-7{right:58.33333333%}.col-md-pull-6{right:50%}.col-md-pull-5{right:41.66666667%}.col-md-pull-4{right:33.33333333%}.col-md-pull-3{right:25%}.col-md-pull-2{right:16.66666667%}.col-md-pull-1{right:8.33333333%}.col-md-pull-0{right:auto}.col-md-push-12{left:100%}.col-md-push-11{left:91.66666667%}.col-md-push-10{left:83.33333333%}.col-md-push-9{left:75%}.col-md-push-8{left:66.66666667%}.col-md-push-7{left:58.33333333%}.col-md-push-6{left:50%}.col-md-push-5{left:41.66666667%}.col-md-push-4{left:33.33333333%}.col-md-push-3{left:25%}.col-md-push-2{left:16.66666667%}.col-md-push-1{left:8.33333333%}.col-md-push-0{left:auto}.col-md-offset-12{margin-left:100%}.col-md-offset-11{margin-left:91.66666667%}.col-md-offset-10{margin-left:83.33333333%}.col-md-offset-9{margin-left:75%}.col-md-offset-8{margin-left:66.66666667%}.col-md-offset-7{margin-left:58.33333333%}.col-md-offset-6{margin-left:50%}.col-md-offset-5{margin-left:41.66666667%}.col-md-offset-4{margin-left:33.33333333%}.col-md-offset-3{margin-left:25%}.col-md-offset-2{margin-left:16.66666667%}.col-md-offset-1{margin-left:8.33333333%}.col-md-offset-0{margin-left:0}}@media (min-width:1200px){.col-lg-1,.col-lg-10,.col-lg-11,.col-lg-12,.col-lg-2,.col-lg-3,.col-lg-4,.col-lg-5,.col-lg-6,.col-lg-7,.col-lg-8,.col-lg-9{float:left}.col-lg-12{width:100%}.col-lg-11{width:91.66666667%}.col-lg-10{width:83.33333333%}.col-lg-9{width:75%}.col-lg-8{width:66.66666667%}.col-lg-7{width:58.33333333%}.col-lg-6{width:50%}.col-lg-5{width:41.66666667%}.col-lg-4{width:33.33333333%}.col-lg-3{width:25%}.col-lg-2{width:16.66666667%}.col-lg-1{width:8.33333333%}.col-lg-pull-12{right:100%}.col-lg-pull-11{right:91.66666667%}.col-lg-pull-10{right:83.33333333%}.col-lg-pull-9{right:75%}.col-lg-pull-8{right:66.66666667%}.col-lg-pull-7{right:58.33333333%}.col-lg-pull-6{right:50%}.col-lg-pull-5{right:41.66666667%}.col-lg-pull-4{right:33.33333333%}.col-lg-pull-3{right:25%}.col-lg-pull-2{right:16.66666667%}.col-lg-pull-1{right:8.33333333%}.col-lg-pull-0{right:auto}.col-lg-push-12{left:100%}.col-lg-push-11{left:91.66666667%}.col-lg-push-10{left:83.33333333%}.col-lg-push-9{left:75%}.col-lg-push-8{left:66.66666667%}.col-lg-push-7{left:58.33333333%}.col-lg-push-6{left:50%}.col-lg-push-5{left:41.66666667%}.col-lg-push-4{left:33.33333333%}.col-lg-push-3{left:25%}.col-lg-push-2{left:16.66666667%}.col-lg-push-1{left:8.33333333%}.col-lg-push-0{left:auto}.col-lg-offset-12{margin-left:100%}.col-lg-offset-11{margin-left:91.66666667%}.col-lg-offset-10{margin-left:83.33333333%}.col-lg-offset-9{margin-left:75%}.col-lg-offset-8{margin-left:66.66666667%}.col-lg-offset-7{margin-left:58.33333333%}.col-lg-offset-6{margin-left:50%}.col-lg-offset-5{margin-left:41.66666667%}.col-lg-offset-4{margin-left:33.33333333%}.col-lg-offset-3{margin-left:25%}.col-lg-offset-2{margin-left:16.66666667%}.col-lg-offset-1{margin-left:8.33333333%}.col-lg-offset-0{margin-left:0}}table{background-color:transparent}caption{padding-top:8px;padding-bottom:8px;color:#777;text-align:left}th{text-align:left}.table{width:100%;max-width:100%;margin-bottom:20px}.table>tbody>tr>td,.table>tbody>tr>th,.table>tfoot>tr>td,.table>tfoot>tr>th,.table>thead>tr>td,.table>thead>tr>th{padding:8px;line-height:1.42857143;vertical-align:top;border-top:1px solid #ddd}.table>thead>tr>th{vertical-align:bottom;border-bottom:2px solid #ddd}.table>caption+thead>tr:first-child>td,.table>caption+thead>tr:first-child>th,.table>colgroup+thead>tr:first-child>td,.table>colgroup+thead>tr:first-child>th,.table>thead:first-child>tr:first-child>td,.table>thead:first-child>tr:first-child>th{border-top:0}.table>tbody+tbody{border-top:2px solid #ddd}.table .table{background-color:#fff}.table-condensed>tbody>tr>td,.table-condensed>tbody>tr>th,.table-condensed>tfoot>tr>td,.table-condensed>tfoot>tr>th,.table-condensed>thead>tr>td,.table-condensed>thead>tr>th{padding:5px}.table-bordered{border:1px solid #ddd}.table-bordered>tbody>tr>td,.table-bordered>tbody>tr>th,.table-bordered>tfoot>tr>td,.table-bordered>tfoot>tr>th,.table-bordered>thead>tr>td,.table-bordered>thead>tr>th{border:1px solid #ddd}.table-bordered>thead>tr>td,.table-bordered>thead>tr>th{border-bottom-width:2px}.table-striped>tbody>tr:nth-of-type(odd){background-color:#f9f9f9}.table-hover>tbody>tr:hover{background-color:#f5f5f5}table col[class*=col-]{position:static;display:table-column;float:none}table td[class*=col-],table th[class*=col-]{position:static;display:table-cell;float:none}.table>tbody>tr.active>td,.table>tbody>tr.active>th,.table>tbody>tr>td.active,.table>tbody>tr>th.active,.table>tfoot>tr.active>td,.table>tfoot>tr.active>th,.table>tfoot>tr>td.active,.table>tfoot>tr>th.active,.table>thead>tr.active>td,.table>thead>tr.active>th,.table>thead>tr>td.active,.table>thead>tr>th.active{background-color:#f5f5f5}.table-hover>tbody>tr.active:hover>td,.table-hover>tbody>tr.active:hover>th,.table-hover>tbody>tr:hover>.active,.table-hover>tbody>tr>td.active:hover,.table-hover>tbody>tr>th.active:hover{background-color:#e8e8e8}.table>tbody>tr.success>td,.table>tbody>tr.success>th,.table>tbody>tr>td.success,.table>tbody>tr>th.success,.table>tfoot>tr.success>td,.table>tfoot>tr.success>th,.table>tfoot>tr>td.success,.table>tfoot>tr>th.success,.table>thead>tr.success>td,.table>thead>tr.success>th,.table>thead>tr>td.success,.table>thead>tr>th.success{background-color:#dff0d8}.table-hover>tbody>tr.success:hover>td,.table-hover>tbody>tr.success:hover>th,.table-hover>tbody>tr:hover>.success,.table-hover>tbody>tr>td.success:hover,.table-hover>tbody>tr>th.success:hover{background-color:#d0e9c6}.table>tbody>tr.info>td,.table>tbody>tr.info>th,.table>tbody>tr>td.info,.table>tbody>tr>th.info,.table>tfoot>tr.info>td,.table>tfoot>tr.info>th,.table>tfoot>tr>td.info,.table>tfoot>tr>th.info,.table>thead>tr.info>td,.table>thead>tr.info>th,.table>thead>tr>td.info,.table>thead>tr>th.info{background-color:#d9edf7}.table-hover>tbody>tr.info:hover>td,.table-hover>tbody>tr.info:hover>th,.table-hover>tbody>tr:hover>.info,.table-hover>tbody>tr>td.info:hover,.table-hover>tbody>tr>th.info:hover{background-color:#c4e3f3}.table>tbody>tr.warning>td,.table>tbody>tr.warning>th,.table>tbody>tr>td.warning,.table>tbody>tr>th.warning,.table>tfoot>tr.warning>td,.table>tfoot>tr.warning>th,.table>tfoot>tr>td.warning,.table>tfoot>tr>th.warning,.table>thead>tr.warning>td,.table>thead>tr.warning>th,.table>thead>tr>td.warning,.table>thead>tr>th.warning{background-color:#fcf8e3}.table-hover>tbody>tr.warning:hover>td,.table-hover>tbody>tr.warning:hover>th,.table-hover>tbody>tr:hover>.warning,.table-hover>tbody>tr>td.warning:hover,.table-hover>tbody>tr>th.warning:hover{background-color:#faf2cc}.table>tbody>tr.danger>td,.table>tbody>tr.danger>th,.table>tbody>tr>td.danger,.table>tbody>tr>th.danger,.table>tfoot>tr.danger>td,.table>tfoot>tr.danger>th,.table>tfoot>tr>td.danger,.table>tfoot>tr>th.danger,.table>thead>tr.danger>td,.table>thead>tr.danger>th,.table>thead>tr>td.danger,.table>thead>tr>th.danger{background-color:#f2dede}.table-hover>tbody>tr.danger:hover>td,.table-hover>tbody>tr.danger:hover>th,.table-hover>tbody>tr:hover>.danger,.table-hover>tbody>tr>td.danger:hover,.table-hover>tbody>tr>th.danger:hover{background-color:#ebcccc}.table-responsive{min-height:.01%;overflow-x:auto}@media screen and (max-width:767px){.table-responsive{width:100%;margin-bottom:15px;overflow-y:hidden;-ms-overflow-style:-ms-autohiding-scrollbar;border:1px solid #ddd}.table-responsive>.table{margin-bottom:0}.table-responsive>.table>tbody>tr>td,.table-responsive>.table>tbody>tr>th,.table-responsive>.table>tfoot>tr>td,.table-responsive>.table>tfoot>tr>th,.table-responsive>.table>thead>tr>td,.table-responsive>.table>thead>tr>th{white-space:nowrap}.table-responsive>.table-bordered{border:0}.table-responsive>.table-bordered>tbody>tr>td:first-child,.table-responsive>.table-bordered>tbody>tr>th:first-child,.table-responsive>.table-bordered>tfoot>tr>td:first-child,.table-responsive>.table-bordered>tfoot>tr>th:first-child,.table-responsive>.table-bordered>thead>tr>td:first-child,.table-responsive>.table-bordered>thead>tr>th:first-child{border-left:0}.table-responsive>.table-bordered>tbody>tr>td:last-child,.table-responsive>.table-bordered>tbody>tr>th:last-child,.table-responsive>.table-bordered>tfoot>tr>td:last-child,.table-responsive>.table-bordered>tfoot>tr>th:last-child,.table-responsive>.table-bordered>thead>tr>td:last-child,.table-responsive>.table-bordered>thead>tr>th:last-child{border-right:0}.table-responsive>.table-bordered>tbody>tr:last-child>td,.table-responsive>.table-bordered>tbody>tr:last-child>th,.table-responsive>.table-bordered>tfoot>tr:last-child>td,.table-responsive>.table-bordered>tfoot>tr:last-child>th{border-bottom:0}}fieldset{min-width:0;padding:0;margin:0;border:0}legend{display:block;width:100%;padding:0;margin-bottom:20px;font-size:21px;line-height:inherit;color:#333;border:0;border-bottom:1px solid #e5e5e5}label{display:inline-block;max-width:100%;margin-bottom:5px;font-weight:700}input[type=search]{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}input[type=checkbox],input[type=radio]{margin:4px 0 0;margin-top:1px\9;line-height:normal}input[type=file]{display:block}input[type=range]{display:block;width:100%}select[multiple],select[size]{height:auto}input[type=file]:focus,input[type=checkbox]:focus,input[type=radio]:focus{outline:5px auto -webkit-focus-ring-color;outline-offset:-2px}output{display:block;padding-top:7px;font-size:14px;line-height:1.42857143;color:#555}.form-control{display:block;width:100%;height:34px;padding:6px 12px;font-size:14px;line-height:1.42857143;color:#555;background-color:#fff;background-image:none;border:1px solid #ccc;border-radius:4px;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075);box-shadow:inset 0 1px 1px rgba(0,0,0,.075);-webkit-transition:border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;-o-transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s;transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s}.form-control:focus{border-color:#66afe9;outline:0;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)}.form-control::-moz-placeholder{color:#999;opacity:1}.form-control:-ms-input-placeholder{color:#999}.form-control::-webkit-input-placeholder{color:#999}.form-control::-ms-expand{background-color:transparent;border:0}.form-control[disabled],.form-control[readonly],fieldset[disabled] .form-control{background-color:#eee;opacity:1}.form-control[disabled],fieldset[disabled] .form-control{cursor:not-allowed}textarea.form-control{height:auto}input[type=search]{-webkit-appearance:none}@media screen and (-webkit-min-device-pixel-ratio:0){input[type=date].form-control,input[type=time].form-control,input[type=datetime-local].form-control,input[type=month].form-control{line-height:34px}.input-group-sm input[type=date],.input-group-sm input[type=time],.input-group-sm input[type=datetime-local],.input-group-sm input[type=month],input[type=date].input-sm,input[type=time].input-sm,input[type=datetime-local].input-sm,input[type=month].input-sm{line-height:30px}.input-group-lg input[type=date],.input-group-lg input[type=time],.input-group-lg input[type=datetime-local],.input-group-lg input[type=month],input[type=date].input-lg,input[type=time].input-lg,input[type=datetime-local].input-lg,input[type=month].input-lg{line-height:46px}}.form-group{margin-bottom:15px}.checkbox,.radio{position:relative;display:block;margin-top:10px;margin-bottom:10px}.checkbox label,.radio label{min-height:20px;padding-left:20px;margin-bottom:0;font-weight:400;cursor:pointer}.checkbox input[type=checkbox],.checkbox-inline input[type=checkbox],.radio input[type=radio],.radio-inline input[type=radio]{position:absolute;margin-top:4px\9;margin-left:-20px}.checkbox+.checkbox,.radio+.radio{margin-top:-5px}.checkbox-inline,.radio-inline{position:relative;display:inline-block;padding-left:20px;margin-bottom:0;font-weight:400;vertical-align:middle;cursor:pointer}.checkbox-inline+.checkbox-inline,.radio-inline+.radio-inline{margin-top:0;margin-left:10px}fieldset[disabled] input[type=checkbox],fieldset[disabled] input[type=radio],input[type=checkbox].disabled,input[type=checkbox][disabled],input[type=radio].disabled,input[type=radio][disabled]{cursor:not-allowed}.checkbox-inline.disabled,.radio-inline.disabled,fieldset[disabled] .checkbox-inline,fieldset[disabled] .radio-inline{cursor:not-allowed}.checkbox.disabled label,.radio.disabled label,fieldset[disabled] .checkbox label,fieldset[disabled] .radio label{cursor:not-allowed}.form-control-static{min-height:34px;padding-top:7px;padding-bottom:7px;margin-bottom:0}.form-control-static.input-lg,.form-control-static.input-sm{padding-right:0;padding-left:0}.input-sm{height:30px;padding:5px 10px;font-size:12px;line-height:1.5;border-radius:3px}select.input-sm{height:30px;line-height:30px}select[multiple].input-sm,textarea.input-sm{height:auto}.form-group-sm .form-control{height:30px;padding:5px 10px;font-size:12px;line-height:1.5;border-radius:3px}.form-group-sm select.form-control{height:30px;line-height:30px}.form-group-sm select[multiple].form-control,.form-group-sm textarea.form-control{height:auto}.form-group-sm .form-control-static{height:30px;min-height:32px;padding:6px 10px;font-size:12px;line-height:1.5}.input-lg{height:46px;padding:10px 16px;font-size:18px;line-height:1.3333333;border-radius:6px}select.input-lg{height:46px;line-height:46px}select[multiple].input-lg,textarea.input-lg{height:auto}.form-group-lg .form-control{height:46px;padding:10px 16px;font-size:18px;line-height:1.3333333;border-radius:6px}.form-group-lg select.form-control{height:46px;line-height:46px}.form-group-lg select[multiple].form-control,.form-group-lg textarea.form-control{height:auto}.form-group-lg .form-control-static{height:46px;min-height:38px;padding:11px 16px;font-size:18px;line-height:1.3333333}.has-feedback{position:relative}.has-feedback .form-control{padding-right:42.5px}.form-control-feedback{position:absolute;top:0;right:0;z-index:2;display:block;width:34px;height:34px;line-height:34px;text-align:center;pointer-events:none}.form-group-lg .form-control+.form-control-feedback,.input-group-lg+.form-control-feedback,.input-lg+.form-control-feedback{width:46px;height:46px;line-height:46px}.form-group-sm .form-control+.form-control-feedback,.input-group-sm+.form-control-feedback,.input-sm+.form-control-feedback{width:30px;height:30px;line-height:30px}.has-success .checkbox,.has-success .checkbox-inline,.has-success .control-label,.has-success .help-block,.has-success .radio,.has-success .radio-inline,.has-success.checkbox label,.has-success.checkbox-inline label,.has-success.radio label,.has-success.radio-inline label{color:#3c763d}.has-success .form-control{border-color:#3c763d;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075);box-shadow:inset 0 1px 1px rgba(0,0,0,.075)}.has-success .form-control:focus{border-color:#2b542c;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #67b168;box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #67b168}.has-success .input-group-addon{color:#3c763d;background-color:#dff0d8;border-color:#3c763d}.has-success .form-control-feedback{color:#3c763d}.has-warning .checkbox,.has-warning .checkbox-inline,.has-warning .control-label,.has-warning .help-block,.has-warning .radio,.has-warning .radio-inline,.has-warning.checkbox label,.has-warning.checkbox-inline label,.has-warning.radio label,.has-warning.radio-inline label{color:#8a6d3b}.has-warning .form-control{border-color:#8a6d3b;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075);box-shadow:inset 0 1px 1px rgba(0,0,0,.075)}.has-warning .form-control:focus{border-color:#66512c;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #c0a16b;box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #c0a16b}.has-warning .input-group-addon{color:#8a6d3b;background-color:#fcf8e3;border-color:#8a6d3b}.has-warning .form-control-feedback{color:#8a6d3b}.has-error .checkbox,.has-error .checkbox-inline,.has-error .control-label,.has-error .help-block,.has-error .radio,.has-error .radio-inline,.has-error.checkbox label,.has-error.checkbox-inline label,.has-error.radio label,.has-error.radio-inline label{color:#a94442}.has-error .form-control{border-color:#a94442;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075);box-shadow:inset 0 1px 1px rgba(0,0,0,.075)}.has-error .form-control:focus{border-color:#843534;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #ce8483;box-shadow:inset 0 1px 1px rgba(0,0,0,.075),0 0 6px #ce8483}.has-error .input-group-addon{color:#a94442;background-color:#f2dede;border-color:#a94442}.has-error .form-control-feedback{color:#a94442}.has-feedback label~.form-control-feedback{top:25px}.has-feedback label.sr-only~.form-control-feedback{top:0}.help-block{display:block;margin-top:5px;margin-bottom:10px;color:#737373}@media (min-width:768px){.form-inline .form-group{display:inline-block;margin-bottom:0;vertical-align:middle}.form-inline .form-control{display:inline-block;width:auto;vertical-align:middle}.form-inline .form-control-static{display:inline-block}.form-inline .input-group{display:inline-table;vertical-align:middle}.form-inline .input-group .form-control,.form-inline .input-group .input-group-addon,.form-inline .input-group .input-group-btn{width:auto}.form-inline .input-group>.form-control{width:100%}.form-inline .control-label{margin-bottom:0;vertical-align:middle}.form-inline .checkbox,.form-inline .radio{display:inline-block;margin-top:0;margin-bottom:0;vertical-align:middle}.form-inline .checkbox label,.form-inline .radio label{padding-left:0}.form-inline .checkbox input[type=checkbox],.form-inline .radio input[type=radio]{position:relative;margin-left:0}.form-inline .has-feedback .form-control-feedback{top:0}}.form-horizontal .checkbox,.form-horizontal .checkbox-inline,.form-horizontal .radio,.form-horizontal .radio-inline{padding-top:7px;margin-top:0;margin-bottom:0}.form-horizontal .checkbox,.form-horizontal .radio{min-height:27px}.form-horizontal .form-group{margin-right:-15px;margin-left:-15px}@media (min-width:768px){.form-horizontal .control-label{padding-top:7px;margin-bottom:0;text-align:right}}.form-horizontal .has-feedback .form-control-feedback{right:15px}@media (min-width:768px){.form-horizontal .form-group-lg .control-label{padding-top:11px;font-size:18px}}@media (min-width:768px){.form-horizontal .form-group-sm .control-label{padding-top:6px;font-size:12px}}.btn{display:inline-block;padding:6px 12px;margin-bottom:0;font-size:14px;font-weight:400;line-height:1.42857143;text-align:center;white-space:nowrap;vertical-align:middle;-ms-touch-action:manipulation;touch-action:manipulation;cursor:pointer;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;background-image:none;border:1px solid transparent;border-radius:4px}.btn.active.focus,.btn.active:focus,.btn.focus,.btn:active.focus,.btn:active:focus,.btn:focus{outline:5px auto -webkit-focus-ring-color;outline-offset:-2px}.btn.focus,.btn:focus,.btn:hover{color:#333;text-decoration:none}.btn.active,.btn:active{background-image:none;outline:0;-webkit-box-shadow:inset 0 3px 5px rgba(0,0,0,.125);box-shadow:inset 0 3px 5px rgba(0,0,0,.125)}.btn.disabled,.btn[disabled],fieldset[disabled] .btn{cursor:not-allowed;filter:alpha(opacity=65);-webkit-box-shadow:none;box-shadow:none;opacity:.65}a.btn.disabled,fieldset[disabled] a.btn{pointer-events:none}.btn-default{color:#333;background-color:#fff;border-color:#ccc}.btn-default.focus,.btn-default:focus{color:#333;background-color:#e6e6e6;border-color:#8c8c8c}.btn-default:hover{color:#333;background-color:#e6e6e6;border-color:#adadad}.btn-default.active,.btn-default:active,.open>.dropdown-toggle.btn-default{color:#333;background-color:#e6e6e6;border-color:#adadad}.btn-default.active.focus,.btn-default.active:focus,.btn-default.active:hover,.btn-default:active.focus,.btn-default:active:focus,.btn-default:active:hover,.open>.dropdown-toggle.btn-default.focus,.open>.dropdown-toggle.btn-default:focus,.open>.dropdown-toggle.btn-default:hover{color:#333;background-color:#d4d4d4;border-color:#8c8c8c}.btn-default.active,.btn-default:active,.open>.dropdown-toggle.btn-default{background-image:none}.btn-default.disabled.focus,.btn-default.disabled:focus,.btn-default.disabled:hover,.btn-default[disabled].focus,.btn-default[disabled]:focus,.btn-default[disabled]:hover,fieldset[disabled] .btn-default.focus,fieldset[disabled] .btn-default:focus,fieldset[disabled] .btn-default:hover{background-color:#fff;border-color:#ccc}.btn-default .badge{color:#fff;background-color:#333}.btn-primary{color:#fff;background-color:#337ab7;border-color:#2e6da4}.btn-primary.focus,.btn-primary:focus{color:#fff;background-color:#286090;border-color:#122b40}.btn-primary:hover{color:#fff;background-color:#286090;border-color:#204d74}.btn-primary.active,.btn-primary:active,.open>.dropdown-toggle.btn-primary{color:#fff;background-color:#286090;border-color:#204d74}.btn-primary.active.focus,.btn-primary.active:focus,.btn-primary.active:hover,.btn-primary:active.focus,.btn-primary:active:focus,.btn-primary:active:hover,.open>.dropdown-toggle.btn-primary.focus,.open>.dropdown-toggle.btn-primary:focus,.open>.dropdown-toggle.btn-primary:hover{color:#fff;background-color:#204d74;border-color:#122b40}.btn-primary.active,.btn-primary:active,.open>.dropdown-toggle.btn-primary{background-image:none}.btn-primary.disabled.focus,.btn-primary.disabled:focus,.btn-primary.disabled:hover,.btn-primary[disabled].focus,.btn-primary[disabled]:focus,.btn-primary[disabled]:hover,fieldset[disabled] .btn-primary.focus,fieldset[disabled] .btn-primary:focus,fieldset[disabled] .btn-primary:hover{background-color:#337ab7;border-color:#2e6da4}.btn-primary .badge{color:#337ab7;background-color:#fff}.btn-success{color:#fff;background-color:#5cb85c;border-color:#4cae4c}.btn-success.focus,.btn-success:focus{color:#fff;background-color:#449d44;border-color:#255625}.btn-success:hover{color:#fff;background-color:#449d44;border-color:#398439}.btn-success.active,.btn-success:active,.open>.dropdown-toggle.btn-success{color:#fff;background-color:#449d44;border-color:#398439}.btn-success.active.focus,.btn-success.active:focus,.btn-success.active:hover,.btn-success:active.focus,.btn-success:active:focus,.btn-success:active:hover,.open>.dropdown-toggle.btn-success.focus,.open>.dropdown-toggle.btn-success:focus,.open>.dropdown-toggle.btn-success:hover{color:#fff;background-color:#398439;border-color:#255625}.btn-success.active,.btn-success:active,.open>.dropdown-toggle.btn-success{background-image:none}.btn-success.disabled.focus,.btn-success.disabled:focus,.btn-success.disabled:hover,.btn-success[disabled].focus,.btn-success[disabled]:focus,.btn-success[disabled]:hover,fieldset[disabled] .btn-success.focus,fieldset[disabled] .btn-success:focus,fieldset[disabled] .btn-success:hover{background-color:#5cb85c;border-color:#4cae4c}.btn-success .badge{color:#5cb85c;background-color:#fff}.btn-info{color:#fff;background-color:#5bc0de;border-color:#46b8da}.btn-info.focus,.btn-info:focus{color:#fff;background-color:#31b0d5;border-color:#1b6d85}.btn-info:hover{color:#fff;background-color:#31b0d5;border-color:#269abc}.btn-info.active,.btn-info:active,.open>.dropdown-toggle.btn-info{color:#fff;background-color:#31b0d5;border-color:#269abc}.btn-info.active.focus,.btn-info.active:focus,.btn-info.active:hover,.btn-info:active.focus,.btn-info:active:focus,.btn-info:active:hover,.open>.dropdown-toggle.btn-info.focus,.open>.dropdown-toggle.btn-info:focus,.open>.dropdown-toggle.btn-info:hover{color:#fff;background-color:#269abc;border-color:#1b6d85}.btn-info.active,.btn-info:active,.open>.dropdown-toggle.btn-info{background-image:none}.btn-info.disabled.focus,.btn-info.disabled:focus,.btn-info.disabled:hover,.btn-info[disabled].focus,.btn-info[disabled]:focus,.btn-info[disabled]:hover,fieldset[disabled] .btn-info.focus,fieldset[disabled] .btn-info:focus,fieldset[disabled] .btn-info:hover{background-color:#5bc0de;border-color:#46b8da}.btn-info .badge{color:#5bc0de;background-color:#fff}.btn-warning{color:#fff;background-color:#f0ad4e;border-color:#eea236}.btn-warning.focus,.btn-warning:focus{color:#fff;background-color:#ec971f;border-color:#985f0d}.btn-warning:hover{color:#fff;background-color:#ec971f;border-color:#d58512}.btn-warning.active,.btn-warning:active,.open>.dropdown-toggle.btn-warning{color:#fff;background-color:#ec971f;border-color:#d58512}.btn-warning.active.focus,.btn-warning.active:focus,.btn-warning.active:hover,.btn-warning:active.focus,.btn-warning:active:focus,.btn-warning:active:hover,.open>.dropdown-toggle.btn-warning.focus,.open>.dropdown-toggle.btn-warning:focus,.open>.dropdown-toggle.btn-warning:hover{color:#fff;background-color:#d58512;border-color:#985f0d}.btn-warning.active,.btn-warning:active,.open>.dropdown-toggle.btn-warning{background-image:none}.btn-warning.disabled.focus,.btn-warning.disabled:focus,.btn-warning.disabled:hover,.btn-warning[disabled].focus,.btn-warning[disabled]:focus,.btn-warning[disabled]:hover,fieldset[disabled] .btn-warning.focus,fieldset[disabled] .btn-warning:focus,fieldset[disabled] .btn-warning:hover{background-color:#f0ad4e;border-color:#eea236}.btn-warning .badge{color:#f0ad4e;background-color:#fff}.btn-danger{color:#fff;background-color:#d9534f;border-color:#d43f3a}.btn-danger.focus,.btn-danger:focus{color:#fff;background-color:#c9302c;border-color:#761c19}.btn-danger:hover{color:#fff;background-color:#c9302c;border-color:#ac2925}.btn-danger.active,.btn-danger:active,.open>.dropdown-toggle.btn-danger{color:#fff;background-color:#c9302c;border-color:#ac2925}.btn-danger.active.focus,.btn-danger.active:focus,.btn-danger.active:hover,.btn-danger:active.focus,.btn-danger:active:focus,.btn-danger:active:hover,.open>.dropdown-toggle.btn-danger.focus,.open>.dropdown-toggle.btn-danger:focus,.open>.dropdown-toggle.btn-danger:hover{color:#fff;background-color:#ac2925;border-color:#761c19}.btn-danger.active,.btn-danger:active,.open>.dropdown-toggle.btn-danger{background-image:none}.btn-danger.disabled.focus,.btn-danger.disabled:focus,.btn-danger.disabled:hover,.btn-danger[disabled].focus,.btn-danger[disabled]:focus,.btn-danger[disabled]:hover,fieldset[disabled] .btn-danger.focus,fieldset[disabled] .btn-danger:focus,fieldset[disabled] .btn-danger:hover{background-color:#d9534f;border-color:#d43f3a}.btn-danger .badge{color:#d9534f;background-color:#fff}.btn-link{font-weight:400;color:#337ab7;border-radius:0}.btn-link,.btn-link.active,.btn-link:active,.btn-link[disabled],fieldset[disabled] .btn-link{background-color:transparent;-webkit-box-shadow:none;box-shadow:none}.btn-link,.btn-link:active,.btn-link:focus,.btn-link:hover{border-color:transparent}.btn-link:focus,.btn-link:hover{color:#23527c;text-decoration:underline;background-color:transparent}.btn-link[disabled]:focus,.btn-link[disabled]:hover,fieldset[disabled] .btn-link:focus,fieldset[disabled] .btn-link:hover{color:#777;text-decoration:none}.btn-group-lg>.btn,.btn-lg{padding:10px 16px;font-size:18px;line-height:1.3333333;border-radius:6px}.btn-group-sm>.btn,.btn-sm{padding:5px 10px;font-size:12px;line-height:1.5;border-radius:3px}.btn-group-xs>.btn,.btn-xs{padding:1px 5px;font-size:12px;line-height:1.5;border-radius:3px}.btn-block{display:block;width:100%}.btn-block+.btn-block{margin-top:5px}input[type=button].btn-block,input[type=reset].btn-block,input[type=submit].btn-block{width:100%}.fade{opacity:0;-webkit-transition:opacity .15s linear;-o-transition:opacity .15s linear;transition:opacity .15s linear}.fade.in{opacity:1}.collapse{display:none}.collapse.in{display:block}tr.collapse.in{display:table-row}tbody.collapse.in{display:table-row-group}.collapsing{position:relative;height:0;overflow:hidden;-webkit-transition-timing-function:ease;-o-transition-timing-function:ease;transition-timing-function:ease;-webkit-transition-duration:.35s;-o-transition-duration:.35s;transition-duration:.35s;-webkit-transition-property:height,visibility;-o-transition-property:height,visibility;transition-property:height,visibility}.caret{display:inline-block;width:0;height:0;margin-left:2px;vertical-align:middle;border-top:4px dashed;border-top:4px solid\9;border-right:4px solid transparent;border-left:4px solid transparent}.dropdown,.dropup{position:relative}.dropdown-toggle:focus{outline:0}.dropdown-menu{position:absolute;top:100%;left:0;z-index:1000;display:none;float:left;min-width:160px;padding:5px 0;margin:2px 0 0;font-size:14px;text-align:left;list-style:none;background-color:#fff;-webkit-background-clip:padding-box;background-clip:padding-box;border:1px solid #ccc;border:1px solid rgba(0,0,0,.15);border-radius:4px;-webkit-box-shadow:0 6px 12px rgba(0,0,0,.175);box-shadow:0 6px 12px rgba(0,0,0,.175)}.dropdown-menu.pull-right{right:0;left:auto}.dropdown-menu .divider{height:1px;margin:9px 0;overflow:hidden;background-color:#e5e5e5}.dropdown-menu>li>a{display:block;padding:3px 20px;clear:both;font-weight:400;line-height:1.42857143;color:#333;white-space:nowrap}.dropdown-menu>li>a:focus,.dropdown-menu>li>a:hover{color:#262626;text-decoration:none;background-color:#f5f5f5}.dropdown-menu>.active>a,.dropdown-menu>.active>a:focus,.dropdown-menu>.active>a:hover{color:#fff;text-decoration:none;background-color:#337ab7;outline:0}.dropdown-menu>.disabled>a,.dropdown-menu>.disabled>a:focus,.dropdown-menu>.disabled>a:hover{color:#777}.dropdown-menu>.disabled>a:focus,.dropdown-menu>.disabled>a:hover{text-decoration:none;cursor:not-allowed;background-color:transparent;background-image:none;filter:progid:DXImageTransform.Microsoft.gradient(enabled=false)}.open>.dropdown-menu{display:block}.open>a{outline:0}.dropdown-menu-right{right:0;left:auto}.dropdown-menu-left{right:auto;left:0}.dropdown-header{display:block;padding:3px 20px;font-size:12px;line-height:1.42857143;color:#777;white-space:nowrap}.dropdown-backdrop{position:fixed;top:0;right:0;bottom:0;left:0;z-index:990}.pull-right>.dropdown-menu{right:0;left:auto}.dropup .caret,.navbar-fixed-bottom .dropdown .caret{content:"";border-top:0;border-bottom:4px dashed;border-bottom:4px solid\9}.dropup .dropdown-menu,.navbar-fixed-bottom .dropdown .dropdown-menu{top:auto;bottom:100%;margin-bottom:2px}@media (min-width:768px){.navbar-right .dropdown-menu{right:0;left:auto}.navbar-right .dropdown-menu-left{right:auto;left:0}}.btn-group,.btn-group-vertical{position:relative;display:inline-block;vertical-align:middle}.btn-group-vertical>.btn,.btn-group>.btn{position:relative;float:left}.btn-group-vertical>.btn.active,.btn-group-vertical>.btn:active,.btn-group-vertical>.btn:focus,.btn-group-vertical>.btn:hover,.btn-group>.btn.active,.btn-group>.btn:active,.btn-group>.btn:focus,.btn-group>.btn:hover{z-index:2}.btn-group .btn+.btn,.btn-group .btn+.btn-group,.btn-group .btn-group+.btn,.btn-group .btn-group+.btn-group{margin-left:-1px}.btn-toolbar{margin-left:-5px}.btn-toolbar .btn,.btn-toolbar .btn-group,.btn-toolbar .input-group{float:left}.btn-toolbar>.btn,.btn-toolbar>.btn-group,.btn-toolbar>.input-group{margin-left:5px}.btn-group>.btn:not(:first-child):not(:last-child):not(.dropdown-toggle){border-radius:0}.btn-group>.btn:first-child{margin-left:0}.btn-group>.btn:first-child:not(:last-child):not(.dropdown-toggle){border-top-right-radius:0;border-bottom-right-radius:0}.btn-group>.btn:last-child:not(:first-child),.btn-group>.dropdown-toggle:not(:first-child){border-top-left-radius:0;border-bottom-left-radius:0}.btn-group>.btn-group{float:left}.btn-group>.btn-group:not(:first-child):not(:last-child)>.btn{border-radius:0}.btn-group>.btn-group:first-child:not(:last-child)>.btn:last-child,.btn-group>.btn-group:first-child:not(:last-child)>.dropdown-toggle{border-top-right-radius:0;border-bottom-right-radius:0}.btn-group>.btn-group:last-child:not(:first-child)>.btn:first-child{border-top-left-radius:0;border-bottom-left-radius:0}.btn-group .dropdown-toggle:active,.btn-group.open .dropdown-toggle{outline:0}.btn-group>.btn+.dropdown-toggle{padding-right:8px;padding-left:8px}.btn-group>.btn-lg+.dropdown-toggle{padding-right:12px;padding-left:12px}.btn-group.open .dropdown-toggle{-webkit-box-shadow:inset 0 3px 5px rgba(0,0,0,.125);box-shadow:inset 0 3px 5px rgba(0,0,0,.125)}.btn-group.open .dropdown-toggle.btn-link{-webkit-box-shadow:none;box-shadow:none}.btn .caret{margin-left:0}.btn-lg .caret{border-width:5px 5px 0;border-bottom-width:0}.dropup .btn-lg .caret{border-width:0 5px 5px}.btn-group-vertical>.btn,.btn-group-vertical>.btn-group,.btn-group-vertical>.btn-group>.btn{display:block;float:none;width:100%;max-width:100%}.btn-group-vertical>.btn-group>.btn{float:none}.btn-group-vertical>.btn+.btn,.btn-group-vertical>.btn+.btn-group,.btn-group-vertical>.btn-group+.btn,.btn-group-vertical>.btn-group+.btn-group{margin-top:-1px;margin-left:0}.btn-group-vertical>.btn:not(:first-child):not(:last-child){border-radius:0}.btn-group-vertical>.btn:first-child:not(:last-child){border-top-left-radius:4px;border-top-right-radius:4px;border-bottom-right-radius:0;border-bottom-left-radius:0}.btn-group-vertical>.btn:last-child:not(:first-child){border-top-left-radius:0;border-top-right-radius:0;border-bottom-right-radius:4px;border-bottom-left-radius:4px}.btn-group-vertical>.btn-group:not(:first-child):not(:last-child)>.btn{border-radius:0}.btn-group-vertical>.btn-group:first-child:not(:last-child)>.btn:last-child,.btn-group-vertical>.btn-group:first-child:not(:last-child)>.dropdown-toggle{border-bottom-right-radius:0;border-bottom-left-radius:0}.btn-group-vertical>.btn-group:last-child:not(:first-child)>.btn:first-child{border-top-left-radius:0;border-top-right-radius:0}.btn-group-justified{display:table;width:100%;table-layout:fixed;border-collapse:separate}.btn-group-justified>.btn,.btn-group-justified>.btn-group{display:table-cell;float:none;width:1%}.btn-group-justified>.btn-group .btn{width:100%}.btn-group-justified>.btn-group .dropdown-menu{left:auto}[data-toggle=buttons]>.btn input[type=checkbox],[data-toggle=buttons]>.btn input[type=radio],[data-toggle=buttons]>.btn-group>.btn input[type=checkbox],[data-toggle=buttons]>.btn-group>.btn input[type=radio]{position:absolute;clip:rect(0,0,0,0);pointer-events:none}.input-group{position:relative;display:table;border-collapse:separate}.input-group[class*=col-]{float:none;padding-right:0;padding-left:0}.input-group .form-control{position:relative;z-index:2;float:left;width:100%;margin-bottom:0}.input-group .form-control:focus{z-index:3}.input-group-lg>.form-control,.input-group-lg>.input-group-addon,.input-group-lg>.input-group-btn>.btn{height:46px;padding:10px 16px;font-size:18px;line-height:1.3333333;border-radius:6px}select.input-group-lg>.form-control,select.input-group-lg>.input-group-addon,select.input-group-lg>.input-group-btn>.btn{height:46px;line-height:46px}select[multiple].input-group-lg>.form-control,select[multiple].input-group-lg>.input-group-addon,select[multiple].input-group-lg>.input-group-btn>.btn,textarea.input-group-lg>.form-control,textarea.input-group-lg>.input-group-addon,textarea.input-group-lg>.input-group-btn>.btn{height:auto}.input-group-sm>.form-control,.input-group-sm>.input-group-addon,.input-group-sm>.input-group-btn>.btn{height:30px;padding:5px 10px;font-size:12px;line-height:1.5;border-radius:3px}select.input-group-sm>.form-control,select.input-group-sm>.input-group-addon,select.input-group-sm>.input-group-btn>.btn{height:30px;line-height:30px}select[multiple].input-group-sm>.form-control,select[multiple].input-group-sm>.input-group-addon,select[multiple].input-group-sm>.input-group-btn>.btn,textarea.input-group-sm>.form-control,textarea.input-group-sm>.input-group-addon,textarea.input-group-sm>.input-group-btn>.btn{height:auto}.input-group .form-control,.input-group-addon,.input-group-btn{display:table-cell}.input-group .form-control:not(:first-child):not(:last-child),.input-group-addon:not(:first-child):not(:last-child),.input-group-btn:not(:first-child):not(:last-child){border-radius:0}.input-group-addon,.input-group-btn{width:1%;white-space:nowrap;vertical-align:middle}.input-group-addon{padding:6px 12px;font-size:14px;font-weight:400;line-height:1;color:#555;text-align:center;background-color:#eee;border:1px solid #ccc;border-radius:4px}.input-group-addon.input-sm{padding:5px 10px;font-size:12px;border-radius:3px}.input-group-addon.input-lg{padding:10px 16px;font-size:18px;border-radius:6px}.input-group-addon input[type=checkbox],.input-group-addon input[type=radio]{margin-top:0}.input-group .form-control:first-child,.input-group-addon:first-child,.input-group-btn:first-child>.btn,.input-group-btn:first-child>.btn-group>.btn,.input-group-btn:first-child>.dropdown-toggle,.input-group-btn:last-child>.btn-group:not(:last-child)>.btn,.input-group-btn:last-child>.btn:not(:last-child):not(.dropdown-toggle){border-top-right-radius:0;border-bottom-right-radius:0}.input-group-addon:first-child{border-right:0}.input-group .form-control:last-child,.input-group-addon:last-child,.input-group-btn:first-child>.btn-group:not(:first-child)>.btn,.input-group-btn:first-child>.btn:not(:first-child),.input-group-btn:last-child>.btn,.input-group-btn:last-child>.btn-group>.btn,.input-group-btn:last-child>.dropdown-toggle{border-top-left-radius:0;border-bottom-left-radius:0}.input-group-addon:last-child{border-left:0}.input-group-btn{position:relative;font-size:0;white-space:nowrap}.input-group-btn>.btn{position:relative}.input-group-btn>.btn+.btn{margin-left:-1px}.input-group-btn>.btn:active,.input-group-btn>.btn:focus,.input-group-btn>.btn:hover{z-index:2}.input-group-btn:first-child>.btn,.input-group-btn:first-child>.btn-group{margin-right:-1px}.input-group-btn:last-child>.btn,.input-group-btn:last-child>.btn-group{z-index:2;margin-left:-1px}.nav{padding-left:0;margin-bottom:0;list-style:none}.nav>li{position:relative;display:block}.nav>li>a{position:relative;display:block;padding:10px 15px}.nav>li>a:focus,.nav>li>a:hover{text-decoration:none;background-color:#eee}.nav>li.disabled>a{color:#777}.nav>li.disabled>a:focus,.nav>li.disabled>a:hover{color:#777;text-decoration:none;cursor:not-allowed;background-color:transparent}.nav .open>a,.nav .open>a:focus,.nav .open>a:hover{background-color:#eee;border-color:#337ab7}.nav .nav-divider{height:1px;margin:9px 0;overflow:hidden;background-color:#e5e5e5}.nav>li>a>img{max-width:none}.nav-tabs{border-bottom:1px solid #ddd}.nav-tabs>li{float:left;margin-bottom:-1px}.nav-tabs>li>a{margin-right:2px;line-height:1.42857143;border:1px solid transparent;border-radius:4px 4px 0 0}.nav-tabs>li>a:hover{border-color:#eee #eee #ddd}.nav-tabs>li.active>a,.nav-tabs>li.active>a:focus,.nav-tabs>li.active>a:hover{color:#555;cursor:default;background-color:#fff;border:1px solid #ddd;border-bottom-color:transparent}.nav-tabs.nav-justified{width:100%;border-bottom:0}.nav-tabs.nav-justified>li{float:none}.nav-tabs.nav-justified>li>a{margin-bottom:5px;text-align:center}.nav-tabs.nav-justified>.dropdown .dropdown-menu{top:auto;left:auto}@media (min-width:768px){.nav-tabs.nav-justified>li{display:table-cell;width:1%}.nav-tabs.nav-justified>li>a{margin-bottom:0}}.nav-tabs.nav-justified>li>a{margin-right:0;border-radius:4px}.nav-tabs.nav-justified>.active>a,.nav-tabs.nav-justified>.active>a:focus,.nav-tabs.nav-justified>.active>a:hover{border:1px solid #ddd}@media (min-width:768px){.nav-tabs.nav-justified>li>a{border-bottom:1px solid #ddd;border-radius:4px 4px 0 0}.nav-tabs.nav-justified>.active>a,.nav-tabs.nav-justified>.active>a:focus,.nav-tabs.nav-justified>.active>a:hover{border-bottom-color:#fff}}.nav-pills>li{float:left}.nav-pills>li>a{border-radius:4px}.nav-pills>li+li{margin-left:2px}.nav-pills>li.active>a,.nav-pills>li.active>a:focus,.nav-pills>li.active>a:hover{color:#fff;background-color:#337ab7}.nav-stacked>li{float:none}.nav-stacked>li+li{margin-top:2px;margin-left:0}.nav-justified{width:100%}.nav-justified>li{float:none}.nav-justified>li>a{margin-bottom:5px;text-align:center}.nav-justified>.dropdown .dropdown-menu{top:auto;left:auto}@media (min-width:768px){.nav-justified>li{display:table-cell;width:1%}.nav-justified>li>a{margin-bottom:0}}.nav-tabs-justified{border-bottom:0}.nav-tabs-justified>li>a{margin-right:0;border-radius:4px}.nav-tabs-justified>.active>a,.nav-tabs-justified>.active>a:focus,.nav-tabs-justified>.active>a:hover{border:1px solid #ddd}@media (min-width:768px){.nav-tabs-justified>li>a{border-bottom:1px solid #ddd;border-radius:4px 4px 0 0}.nav-tabs-justified>.active>a,.nav-tabs-justified>.active>a:focus,.nav-tabs-justified>.active>a:hover{border-bottom-color:#fff}}.tab-content>.tab-pane{display:none}.tab-content>.active{display:block}.nav-tabs .dropdown-menu{margin-top:-1px;border-top-left-radius:0;border-top-right-radius:0}.navbar{position:relative;min-height:50px;margin-bottom:20px;border:1px solid transparent}@media (min-width:768px){.navbar{border-radius:4px}}@media (min-width:768px){.navbar-header{float:left}}.navbar-collapse{padding-right:15px;padding-left:15px;overflow-x:visible;-webkit-overflow-scrolling:touch;border-top:1px solid transparent;-webkit-box-shadow:inset 0 1px 0 rgba(255,255,255,.1);box-shadow:inset 0 1px 0 rgba(255,255,255,.1)}.navbar-collapse.in{overflow-y:auto}@media (min-width:768px){.navbar-collapse{width:auto;border-top:0;-webkit-box-shadow:none;box-shadow:none}.navbar-collapse.collapse{display:block!important;height:auto!important;padding-bottom:0;overflow:visible!important}.navbar-collapse.in{overflow-y:visible}.navbar-fixed-bottom .navbar-collapse,.navbar-fixed-top .navbar-collapse,.navbar-static-top .navbar-collapse{padding-right:0;padding-left:0}}.navbar-fixed-bottom .navbar-collapse,.navbar-fixed-top .navbar-collapse{max-height:340px}@media (max-device-width:480px) and (orientation:landscape){.navbar-fixed-bottom .navbar-collapse,.navbar-fixed-top .navbar-collapse{max-height:200px}}.container-fluid>.navbar-collapse,.container-fluid>.navbar-header,.container>.navbar-collapse,.container>.navbar-header{margin-right:-15px;margin-left:-15px}@media (min-width:768px){.container-fluid>.navbar-collapse,.container-fluid>.navbar-header,.container>.navbar-collapse,.container>.navbar-header{margin-right:0;margin-left:0}}.navbar-static-top{z-index:1000;border-width:0 0 1px}@media (min-width:768px){.navbar-static-top{border-radius:0}}.navbar-fixed-bottom,.navbar-fixed-top{position:fixed;right:0;left:0;z-index:1030}@media (min-width:768px){.navbar-fixed-bottom,.navbar-fixed-top{border-radius:0}}.navbar-fixed-top{top:0;border-width:0 0 1px}.navbar-fixed-bottom{bottom:0;margin-bottom:0;border-width:1px 0 0}.navbar-brand{float:left;height:50px;padding:15px 15px;font-size:18px;line-height:20px}.navbar-brand:focus,.navbar-brand:hover{text-decoration:none}.navbar-brand>img{display:block}@media (min-width:768px){.navbar>.container .navbar-brand,.navbar>.container-fluid .navbar-brand{margin-left:-15px}}.navbar-toggle{position:relative;float:right;padding:9px 10px;margin-top:8px;margin-right:15px;margin-bottom:8px;background-color:transparent;background-image:none;border:1px solid transparent;border-radius:4px}.navbar-toggle:focus{outline:0}.navbar-toggle .icon-bar{display:block;width:22px;height:2px;border-radius:1px}.navbar-toggle .icon-bar+.icon-bar{margin-top:4px}@media (min-width:768px){.navbar-toggle{display:none}}.navbar-nav{margin:7.5px -15px}.navbar-nav>li>a{padding-top:10px;padding-bottom:10px;line-height:20px}@media (max-width:767px){.navbar-nav .open .dropdown-menu{position:static;float:none;width:auto;margin-top:0;background-color:transparent;border:0;-webkit-box-shadow:none;box-shadow:none}.navbar-nav .open .dropdown-menu .dropdown-header,.navbar-nav .open .dropdown-menu>li>a{padding:5px 15px 5px 25px}.navbar-nav .open .dropdown-menu>li>a{line-height:20px}.navbar-nav .open .dropdown-menu>li>a:focus,.navbar-nav .open .dropdown-menu>li>a:hover{background-image:none}}@media (min-width:768px){.navbar-nav{float:left;margin:0}.navbar-nav>li{float:left}.navbar-nav>li>a{padding-top:15px;padding-bottom:15px}}.navbar-form{padding:10px 15px;margin-top:8px;margin-right:-15px;margin-bottom:8px;margin-left:-15px;border-top:1px solid transparent;border-bottom:1px solid transparent;-webkit-box-shadow:inset 0 1px 0 rgba(255,255,255,.1),0 1px 0 rgba(255,255,255,.1);box-shadow:inset 0 1px 0 rgba(255,255,255,.1),0 1px 0 rgba(255,255,255,.1)}@media (min-width:768px){.navbar-form .form-group{display:inline-block;margin-bottom:0;vertical-align:middle}.navbar-form .form-control{display:inline-block;width:auto;vertical-align:middle}.navbar-form .form-control-static{display:inline-block}.navbar-form .input-group{display:inline-table;vertical-align:middle}.navbar-form .input-group .form-control,.navbar-form .input-group .input-group-addon,.navbar-form .input-group .input-group-btn{width:auto}.navbar-form .input-group>.form-control{width:100%}.navbar-form .control-label{margin-bottom:0;vertical-align:middle}.navbar-form .checkbox,.navbar-form .radio{display:inline-block;margin-top:0;margin-bottom:0;vertical-align:middle}.navbar-form .checkbox label,.navbar-form .radio label{padding-left:0}.navbar-form .checkbox input[type=checkbox],.navbar-form .radio input[type=radio]{position:relative;margin-left:0}.navbar-form .has-feedback .form-control-feedback{top:0}}@media (max-width:767px){.navbar-form .form-group{margin-bottom:5px}.navbar-form .form-group:last-child{margin-bottom:0}}@media (min-width:768px){.navbar-form{width:auto;padding-top:0;padding-bottom:0;margin-right:0;margin-left:0;border:0;-webkit-box-shadow:none;box-shadow:none}}.navbar-nav>li>.dropdown-menu{margin-top:0;border-top-left-radius:0;border-top-right-radius:0}.navbar-fixed-bottom .navbar-nav>li>.dropdown-menu{margin-bottom:0;border-top-left-radius:4px;border-top-right-radius:4px;border-bottom-right-radius:0;border-bottom-left-radius:0}.navbar-btn{margin-top:8px;margin-bottom:8px}.navbar-btn.btn-sm{margin-top:10px;margin-bottom:10px}.navbar-btn.btn-xs{margin-top:14px;margin-bottom:14px}.navbar-text{margin-top:15px;margin-bottom:15px}@media (min-width:768px){.navbar-text{float:left;margin-right:15px;margin-left:15px}}@media (min-width:768px){.navbar-left{float:left!important}.navbar-right{float:right!important;margin-right:-15px}.navbar-right~.navbar-right{margin-right:0}}.navbar-default{background-color:#f8f8f8;border-color:#e7e7e7}.navbar-default .navbar-brand{color:#777}.navbar-default .navbar-brand:focus,.navbar-default .navbar-brand:hover{color:#5e5e5e;background-color:transparent}.navbar-default .navbar-text{color:#777}.navbar-default .navbar-nav>li>a{color:#777}.navbar-default .navbar-nav>li>a:focus,.navbar-default .navbar-nav>li>a:hover{color:#333;background-color:transparent}.navbar-default .navbar-nav>.active>a,.navbar-default .navbar-nav>.active>a:focus,.navbar-default .navbar-nav>.active>a:hover{color:#555;background-color:#e7e7e7}.navbar-default .navbar-nav>.disabled>a,.navbar-default .navbar-nav>.disabled>a:focus,.navbar-default .navbar-nav>.disabled>a:hover{color:#ccc;background-color:transparent}.navbar-default .navbar-toggle{border-color:#ddd}.navbar-default .navbar-toggle:focus,.navbar-default .navbar-toggle:hover{background-color:#ddd}.navbar-default .navbar-toggle .icon-bar{background-color:#888}.navbar-default .navbar-collapse,.navbar-default .navbar-form{border-color:#e7e7e7}.navbar-default .navbar-nav>.open>a,.navbar-default .navbar-nav>.open>a:focus,.navbar-default .navbar-nav>.open>a:hover{color:#555;background-color:#e7e7e7}@media (max-width:767px){.navbar-default .navbar-nav .open .dropdown-menu>li>a{color:#777}.navbar-default .navbar-nav .open .dropdown-menu>li>a:focus,.navbar-default .navbar-nav .open .dropdown-menu>li>a:hover{color:#333;background-color:transparent}.navbar-default .navbar-nav .open .dropdown-menu>.active>a,.navbar-default .navbar-nav .open .dropdown-menu>.active>a:focus,.navbar-default .navbar-nav .open .dropdown-menu>.active>a:hover{color:#555;background-color:#e7e7e7}.navbar-default .navbar-nav .open .dropdown-menu>.disabled>a,.navbar-default .navbar-nav .open .dropdown-menu>.disabled>a:focus,.navbar-default .navbar-nav .open .dropdown-menu>.disabled>a:hover{color:#ccc;background-color:transparent}}.navbar-default .navbar-link{color:#777}.navbar-default .navbar-link:hover{color:#333}.navbar-default .btn-link{color:#777}.navbar-default .btn-link:focus,.navbar-default .btn-link:hover{color:#333}.navbar-default .btn-link[disabled]:focus,.navbar-default .btn-link[disabled]:hover,fieldset[disabled] .navbar-default .btn-link:focus,fieldset[disabled] .navbar-default .btn-link:hover{color:#ccc}.navbar-inverse{background-color:#222;border-color:#080808}.navbar-inverse .navbar-brand{color:#9d9d9d}.navbar-inverse .navbar-brand:focus,.navbar-inverse .navbar-brand:hover{color:#fff;background-color:transparent}.navbar-inverse .navbar-text{color:#9d9d9d}.navbar-inverse .navbar-nav>li>a{color:#9d9d9d}.navbar-inverse .navbar-nav>li>a:focus,.navbar-inverse .navbar-nav>li>a:hover{color:#fff;background-color:transparent}.navbar-inverse .navbar-nav>.active>a,.navbar-inverse .navbar-nav>.active>a:focus,.navbar-inverse .navbar-nav>.active>a:hover{color:#fff;background-color:#080808}.navbar-inverse .navbar-nav>.disabled>a,.navbar-inverse .navbar-nav>.disabled>a:focus,.navbar-inverse .navbar-nav>.disabled>a:hover{color:#444;background-color:transparent}.navbar-inverse .navbar-toggle{border-color:#333}.navbar-inverse .navbar-toggle:focus,.navbar-inverse .navbar-toggle:hover{background-color:#333}.navbar-inverse .navbar-toggle .icon-bar{background-color:#fff}.navbar-inverse .navbar-collapse,.navbar-inverse .navbar-form{border-color:#101010}.navbar-inverse .navbar-nav>.open>a,.navbar-inverse .navbar-nav>.open>a:focus,.navbar-inverse .navbar-nav>.open>a:hover{color:#fff;background-color:#080808}@media (max-width:767px){.navbar-inverse .navbar-nav .open .dropdown-menu>.dropdown-header{border-color:#080808}.navbar-inverse .navbar-nav .open .dropdown-menu .divider{background-color:#080808}.navbar-inverse .navbar-nav .open .dropdown-menu>li>a{color:#9d9d9d}.navbar-inverse .navbar-nav .open .dropdown-menu>li>a:focus,.navbar-inverse .navbar-nav .open .dropdown-menu>li>a:hover{color:#fff;background-color:transparent}.navbar-inverse .navbar-nav .open .dropdown-menu>.active>a,.navbar-inverse .navbar-nav .open .dropdown-menu>.active>a:focus,.navbar-inverse .navbar-nav .open .dropdown-menu>.active>a:hover{color:#fff;background-color:#080808}.navbar-inverse .navbar-nav .open .dropdown-menu>.disabled>a,.navbar-inverse .navbar-nav .open .dropdown-menu>.disabled>a:focus,.navbar-inverse .navbar-nav .open .dropdown-menu>.disabled>a:hover{color:#444;background-color:transparent}}.navbar-inverse .navbar-link{color:#9d9d9d}.navbar-inverse .navbar-link:hover{color:#fff}.navbar-inverse .btn-link{color:#9d9d9d}.navbar-inverse .btn-link:focus,.navbar-inverse .btn-link:hover{color:#fff}.navbar-inverse .btn-link[disabled]:focus,.navbar-inverse .btn-link[disabled]:hover,fieldset[disabled] .navbar-inverse .btn-link:focus,fieldset[disabled] .navbar-inverse .btn-link:hover{color:#444}.breadcrumb{padding:8px 15px;margin-bottom:20px;list-style:none;background-color:#f5f5f5;border-radius:4px}.breadcrumb>li{display:inline-block}.breadcrumb>li+li:before{padding:0 5px;color:#ccc;content:"/\00a0"}.breadcrumb>.active{color:#777}.pagination{display:inline-block;padding-left:0;margin:20px 0;border-radius:4px}.pagination>li{display:inline}.pagination>li>a,.pagination>li>span{position:relative;float:left;padding:6px 12px;margin-left:-1px;line-height:1.42857143;color:#337ab7;text-decoration:none;background-color:#fff;border:1px solid #ddd}.pagination>li:first-child>a,.pagination>li:first-child>span{margin-left:0;border-top-left-radius:4px;border-bottom-left-radius:4px}.pagination>li:last-child>a,.pagination>li:last-child>span{border-top-right-radius:4px;border-bottom-right-radius:4px}.pagination>li>a:focus,.pagination>li>a:hover,.pagination>li>span:focus,.pagination>li>span:hover{z-index:2;color:#23527c;background-color:#eee;border-color:#ddd}.pagination>.active>a,.pagination>.active>a:focus,.pagination>.active>a:hover,.pagination>.active>span,.pagination>.active>span:focus,.pagination>.active>span:hover{z-index:3;color:#fff;cursor:default;background-color:#337ab7;border-color:#337ab7}.pagination>.disabled>a,.pagination>.disabled>a:focus,.pagination>.disabled>a:hover,.pagination>.disabled>span,.pagination>.disabled>span:focus,.pagination>.disabled>span:hover{color:#777;cursor:not-allowed;background-color:#fff;border-color:#ddd}.pagination-lg>li>a,.pagination-lg>li>span{padding:10px 16px;font-size:18px;line-height:1.3333333}.pagination-lg>li:first-child>a,.pagination-lg>li:first-child>span{border-top-left-radius:6px;border-bottom-left-radius:6px}.pagination-lg>li:last-child>a,.pagination-lg>li:last-child>span{border-top-right-radius:6px;border-bottom-right-radius:6px}.pagination-sm>li>a,.pagination-sm>li>span{padding:5px 10px;font-size:12px;line-height:1.5}.pagination-sm>li:first-child>a,.pagination-sm>li:first-child>span{border-top-left-radius:3px;border-bottom-left-radius:3px}.pagination-sm>li:last-child>a,.pagination-sm>li:last-child>span{border-top-right-radius:3px;border-bottom-right-radius:3px}.pager{padding-left:0;margin:20px 0;text-align:center;list-style:none}.pager li{display:inline}.pager li>a,.pager li>span{display:inline-block;padding:5px 14px;background-color:#fff;border:1px solid #ddd;border-radius:15px}.pager li>a:focus,.pager li>a:hover{text-decoration:none;background-color:#eee}.pager .next>a,.pager .next>span{float:right}.pager .previous>a,.pager .previous>span{float:left}.pager .disabled>a,.pager .disabled>a:focus,.pager .disabled>a:hover,.pager .disabled>span{color:#777;cursor:not-allowed;background-color:#fff}.label{display:inline;padding:.2em .6em .3em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em}a.label:focus,a.label:hover{color:#fff;text-decoration:none;cursor:pointer}.label:empty{display:none}.btn .label{position:relative;top:-1px}.label-default{background-color:#777}.label-default[href]:focus,.label-default[href]:hover{background-color:#5e5e5e}.label-primary{background-color:#337ab7}.label-primary[href]:focus,.label-primary[href]:hover{background-color:#286090}.label-success{background-color:#5cb85c}.label-success[href]:focus,.label-success[href]:hover{background-color:#449d44}.label-info{background-color:#5bc0de}.label-info[href]:focus,.label-info[href]:hover{background-color:#31b0d5}.label-warning{background-color:#f0ad4e}.label-warning[href]:focus,.label-warning[href]:hover{background-color:#ec971f}.label-danger{background-color:#d9534f}.label-danger[href]:focus,.label-danger[href]:hover{background-color:#c9302c}.badge{display:inline-block;min-width:10px;padding:3px 7px;font-size:12px;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:middle;background-color:#777;border-radius:10px}.badge:empty{display:none}.btn .badge{position:relative;top:-1px}.btn-group-xs>.btn .badge,.btn-xs .badge{top:0;padding:1px 5px}a.badge:focus,a.badge:hover{color:#fff;text-decoration:none;cursor:pointer}.list-group-item.active>.badge,.nav-pills>.active>a>.badge{color:#337ab7;background-color:#fff}.list-group-item>.badge{float:right}.list-group-item>.badge+.badge{margin-right:5px}.nav-pills>li>a>.badge{margin-left:3px}.jumbotron{padding-top:30px;padding-bottom:30px;margin-bottom:30px;color:inherit;background-color:#eee}.jumbotron .h1,.jumbotron h1{color:inherit}.jumbotron p{margin-bottom:15px;font-size:21px;font-weight:200}.jumbotron>hr{border-top-color:#d5d5d5}.container .jumbotron,.container-fluid .jumbotron{padding-right:15px;padding-left:15px;border-radius:6px}.jumbotron .container{max-width:100%}@media screen and (min-width:768px){.jumbotron{padding-top:48px;padding-bottom:48px}.container .jumbotron,.container-fluid .jumbotron{padding-right:60px;padding-left:60px}.jumbotron .h1,.jumbotron h1{font-size:63px}}.thumbnail{display:block;padding:4px;margin-bottom:20px;line-height:1.42857143;background-color:#fff;border:1px solid #ddd;border-radius:4px;-webkit-transition:border .2s ease-in-out;-o-transition:border .2s ease-in-out;transition:border .2s ease-in-out}.thumbnail a>img,.thumbnail>img{margin-right:auto;margin-left:auto}a.thumbnail.active,a.thumbnail:focus,a.thumbnail:hover{border-color:#337ab7}.thumbnail .caption{padding:9px;color:#333}.alert{padding:15px;margin-bottom:20px;border:1px solid transparent;border-radius:4px}.alert h4{margin-top:0;color:inherit}.alert .alert-link{font-weight:700}.alert>p,.alert>ul{margin-bottom:0}.alert>p+p{margin-top:5px}.alert-dismissable,.alert-dismissible{padding-right:35px}.alert-dismissable .close,.alert-dismissible .close{position:relative;top:-2px;right:-21px;color:inherit}.alert-success{color:#3c763d;background-color:#dff0d8;border-color:#d6e9c6}.alert-success hr{border-top-color:#c9e2b3}.alert-success .alert-link{color:#2b542c}.alert-info{color:#31708f;background-color:#d9edf7;border-color:#bce8f1}.alert-info hr{border-top-color:#a6e1ec}.alert-info .alert-link{color:#245269}.alert-warning{color:#8a6d3b;background-color:#fcf8e3;border-color:#faebcc}.alert-warning hr{border-top-color:#f7e1b5}.alert-warning .alert-link{color:#66512c}.alert-danger{color:#a94442;background-color:#f2dede;border-color:#ebccd1}.alert-danger hr{border-top-color:#e4b9c0}.alert-danger .alert-link{color:#843534}@-webkit-keyframes progress-bar-stripes{from{background-position:40px 0}to{background-position:0 0}}@-o-keyframes progress-bar-stripes{from{background-position:40px 0}to{background-position:0 0}}@keyframes progress-bar-stripes{from{background-position:40px 0}to{background-position:0 0}}.progress{height:20px;margin-bottom:20px;overflow:hidden;background-color:#f5f5f5;border-radius:4px;-webkit-box-shadow:inset 0 1px 2px rgba(0,0,0,.1);box-shadow:inset 0 1px 2px rgba(0,0,0,.1)}.progress-bar{float:left;width:0;height:100%;font-size:12px;line-height:20px;color:#fff;text-align:center;background-color:#337ab7;-webkit-box-shadow:inset 0 -1px 0 rgba(0,0,0,.15);box-shadow:inset 0 -1px 0 rgba(0,0,0,.15);-webkit-transition:width .6s ease;-o-transition:width .6s ease;transition:width .6s ease}.progress-bar-striped,.progress-striped .progress-bar{background-image:-webkit-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:-o-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);-webkit-background-size:40px 40px;background-size:40px 40px}.progress-bar.active,.progress.active .progress-bar{-webkit-animation:progress-bar-stripes 2s linear infinite;-o-animation:progress-bar-stripes 2s linear infinite;animation:progress-bar-stripes 2s linear infinite}.progress-bar-success{background-color:#5cb85c}.progress-striped .progress-bar-success{background-image:-webkit-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:-o-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent)}.progress-bar-info{background-color:#5bc0de}.progress-striped .progress-bar-info{background-image:-webkit-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:-o-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent)}.progress-bar-warning{background-color:#f0ad4e}.progress-striped .progress-bar-warning{background-image:-webkit-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:-o-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent)}.progress-bar-danger{background-color:#d9534f}.progress-striped .progress-bar-danger{background-image:-webkit-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:-o-linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-image:linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent)}.media{margin-top:15px}.media:first-child{margin-top:0}.media,.media-body{overflow:hidden;zoom:1}.media-body{width:10000px}.media-object{display:block}.media-object.img-thumbnail{max-width:none}.media-right,.media>.pull-right{padding-left:10px}.media-left,.media>.pull-left{padding-right:10px}.media-body,.media-left,.media-right{display:table-cell;vertical-align:top}.media-middle{vertical-align:middle}.media-bottom{vertical-align:bottom}.media-heading{margin-top:0;margin-bottom:5px}.media-list{padding-left:0;list-style:none}.list-group{padding-left:0;margin-bottom:20px}.list-group-item{position:relative;display:block;padding:10px 15px;margin-bottom:-1px;background-color:#fff;border:1px solid #ddd}.list-group-item:first-child{border-top-left-radius:4px;border-top-right-radius:4px}.list-group-item:last-child{margin-bottom:0;border-bottom-right-radius:4px;border-bottom-left-radius:4px}a.list-group-item,button.list-group-item{color:#555}a.list-group-item .list-group-item-heading,button.list-group-item .list-group-item-heading{color:#333}a.list-group-item:focus,a.list-group-item:hover,button.list-group-item:focus,button.list-group-item:hover{color:#555;text-decoration:none;background-color:#f5f5f5}button.list-group-item{width:100%;text-align:left}.list-group-item.disabled,.list-group-item.disabled:focus,.list-group-item.disabled:hover{color:#777;cursor:not-allowed;background-color:#eee}.list-group-item.disabled .list-group-item-heading,.list-group-item.disabled:focus .list-group-item-heading,.list-group-item.disabled:hover .list-group-item-heading{color:inherit}.list-group-item.disabled .list-group-item-text,.list-group-item.disabled:focus .list-group-item-text,.list-group-item.disabled:hover .list-group-item-text{color:#777}.list-group-item.active,.list-group-item.active:focus,.list-group-item.active:hover{z-index:2;color:#fff;background-color:#337ab7;border-color:#337ab7}.list-group-item.active .list-group-item-heading,.list-group-item.active .list-group-item-heading>.small,.list-group-item.active .list-group-item-heading>small,.list-group-item.active:focus .list-group-item-heading,.list-group-item.active:focus .list-group-item-heading>.small,.list-group-item.active:focus .list-group-item-heading>small,.list-group-item.active:hover .list-group-item-heading,.list-group-item.active:hover .list-group-item-heading>.small,.list-group-item.active:hover .list-group-item-heading>small{color:inherit}.list-group-item.active .list-group-item-text,.list-group-item.active:focus .list-group-item-text,.list-group-item.active:hover .list-group-item-text{color:#c7ddef}.list-group-item-success{color:#3c763d;background-color:#dff0d8}a.list-group-item-success,button.list-group-item-success{color:#3c763d}a.list-group-item-success .list-group-item-heading,button.list-group-item-success .list-group-item-heading{color:inherit}a.list-group-item-success:focus,a.list-group-item-success:hover,button.list-group-item-success:focus,button.list-group-item-success:hover{color:#3c763d;background-color:#d0e9c6}a.list-group-item-success.active,a.list-group-item-success.active:focus,a.list-group-item-success.active:hover,button.list-group-item-success.active,button.list-group-item-success.active:focus,button.list-group-item-success.active:hover{color:#fff;background-color:#3c763d;border-color:#3c763d}.list-group-item-info{color:#31708f;background-color:#d9edf7}a.list-group-item-info,button.list-group-item-info{color:#31708f}a.list-group-item-info .list-group-item-heading,button.list-group-item-info .list-group-item-heading{color:inherit}a.list-group-item-info:focus,a.list-group-item-info:hover,button.list-group-item-info:focus,button.list-group-item-info:hover{color:#31708f;background-color:#c4e3f3}a.list-group-item-info.active,a.list-group-item-info.active:focus,a.list-group-item-info.active:hover,button.list-group-item-info.active,button.list-group-item-info.active:focus,button.list-group-item-info.active:hover{color:#fff;background-color:#31708f;border-color:#31708f}.list-group-item-warning{color:#8a6d3b;background-color:#fcf8e3}a.list-group-item-warning,button.list-group-item-warning{color:#8a6d3b}a.list-group-item-warning .list-group-item-heading,button.list-group-item-warning .list-group-item-heading{color:inherit}a.list-group-item-warning:focus,a.list-group-item-warning:hover,button.list-group-item-warning:focus,button.list-group-item-warning:hover{color:#8a6d3b;background-color:#faf2cc}a.list-group-item-warning.active,a.list-group-item-warning.active:focus,a.list-group-item-warning.active:hover,button.list-group-item-warning.active,button.list-group-item-warning.active:focus,button.list-group-item-warning.active:hover{color:#fff;background-color:#8a6d3b;border-color:#8a6d3b}.list-group-item-danger{color:#a94442;background-color:#f2dede}a.list-group-item-danger,button.list-group-item-danger{color:#a94442}a.list-group-item-danger .list-group-item-heading,button.list-group-item-danger .list-group-item-heading{color:inherit}a.list-group-item-danger:focus,a.list-group-item-danger:hover,button.list-group-item-danger:focus,button.list-group-item-danger:hover{color:#a94442;background-color:#ebcccc}a.list-group-item-danger.active,a.list-group-item-danger.active:focus,a.list-group-item-danger.active:hover,button.list-group-item-danger.active,button.list-group-item-danger.active:focus,button.list-group-item-danger.active:hover{color:#fff;background-color:#a94442;border-color:#a94442}.list-group-item-heading{margin-top:0;margin-bottom:5px}.list-group-item-text{margin-bottom:0;line-height:1.3}.panel{margin-bottom:20px;background-color:#fff;border:1px solid transparent;border-radius:4px;-webkit-box-shadow:0 1px 1px rgba(0,0,0,.05);box-shadow:0 1px 1px rgba(0,0,0,.05)}.panel-body{padding:15px}.panel-heading{padding:10px 15px;border-bottom:1px solid transparent;border-top-left-radius:3px;border-top-right-radius:3px}.panel-heading>.dropdown .dropdown-toggle{color:inherit}.panel-title{margin-top:0;margin-bottom:0;font-size:16px;color:inherit}.panel-title>.small,.panel-title>.small>a,.panel-title>a,.panel-title>small,.panel-title>small>a{color:inherit}.panel-footer{padding:10px 15px;background-color:#f5f5f5;border-top:1px solid #ddd;border-bottom-right-radius:3px;border-bottom-left-radius:3px}.panel>.list-group,.panel>.panel-collapse>.list-group{margin-bottom:0}.panel>.list-group .list-group-item,.panel>.panel-collapse>.list-group .list-group-item{border-width:1px 0;border-radius:0}.panel>.list-group:first-child .list-group-item:first-child,.panel>.panel-collapse>.list-group:first-child .list-group-item:first-child{border-top:0;border-top-left-radius:3px;border-top-right-radius:3px}.panel>.list-group:last-child .list-group-item:last-child,.panel>.panel-collapse>.list-group:last-child .list-group-item:last-child{border-bottom:0;border-bottom-right-radius:3px;border-bottom-left-radius:3px}.panel>.panel-heading+.panel-collapse>.list-group .list-group-item:first-child{border-top-left-radius:0;border-top-right-radius:0}.panel-heading+.list-group .list-group-item:first-child{border-top-width:0}.list-group+.panel-footer{border-top-width:0}.panel>.panel-collapse>.table,.panel>.table,.panel>.table-responsive>.table{margin-bottom:0}.panel>.panel-collapse>.table caption,.panel>.table caption,.panel>.table-responsive>.table caption{padding-right:15px;padding-left:15px}.panel>.table-responsive:first-child>.table:first-child,.panel>.table:first-child{border-top-left-radius:3px;border-top-right-radius:3px}.panel>.table-responsive:first-child>.table:first-child>tbody:first-child>tr:first-child,.panel>.table-responsive:first-child>.table:first-child>thead:first-child>tr:first-child,.panel>.table:first-child>tbody:first-child>tr:first-child,.panel>.table:first-child>thead:first-child>tr:first-child{border-top-left-radius:3px;border-top-right-radius:3px}.panel>.table-responsive:first-child>.table:first-child>tbody:first-child>tr:first-child td:first-child,.panel>.table-responsive:first-child>.table:first-child>tbody:first-child>tr:first-child th:first-child,.panel>.table-responsive:first-child>.table:first-child>thead:first-child>tr:first-child td:first-child,.panel>.table-responsive:first-child>.table:first-child>thead:first-child>tr:first-child th:first-child,.panel>.table:first-child>tbody:first-child>tr:first-child td:first-child,.panel>.table:first-child>tbody:first-child>tr:first-child th:first-child,.panel>.table:first-child>thead:first-child>tr:first-child td:first-child,.panel>.table:first-child>thead:first-child>tr:first-child th:first-child{border-top-left-radius:3px}.panel>.table-responsive:first-child>.table:first-child>tbody:first-child>tr:first-child td:last-child,.panel>.table-responsive:first-child>.table:first-child>tbody:first-child>tr:first-child th:last-child,.panel>.table-responsive:first-child>.table:first-child>thead:first-child>tr:first-child td:last-child,.panel>.table-responsive:first-child>.table:first-child>thead:first-child>tr:first-child th:last-child,.panel>.table:first-child>tbody:first-child>tr:first-child td:last-child,.panel>.table:first-child>tbody:first-child>tr:first-child th:last-child,.panel>.table:first-child>thead:first-child>tr:first-child td:last-child,.panel>.table:first-child>thead:first-child>tr:first-child th:last-child{border-top-right-radius:3px}.panel>.table-responsive:last-child>.table:last-child,.panel>.table:last-child{border-bottom-right-radius:3px;border-bottom-left-radius:3px}.panel>.table-responsive:last-child>.table:last-child>tbody:last-child>tr:last-child,.panel>.table-responsive:last-child>.table:last-child>tfoot:last-child>tr:last-child,.panel>.table:last-child>tbody:last-child>tr:last-child,.panel>.table:last-child>tfoot:last-child>tr:last-child{border-bottom-right-radius:3px;border-bottom-left-radius:3px}.panel>.table-responsive:last-child>.table:last-child>tbody:last-child>tr:last-child td:first-child,.panel>.table-responsive:last-child>.table:last-child>tbody:last-child>tr:last-child th:first-child,.panel>.table-responsive:last-child>.table:last-child>tfoot:last-child>tr:last-child td:first-child,.panel>.table-responsive:last-child>.table:last-child>tfoot:last-child>tr:last-child th:first-child,.panel>.table:last-child>tbody:last-child>tr:last-child td:first-child,.panel>.table:last-child>tbody:last-child>tr:last-child th:first-child,.panel>.table:last-child>tfoot:last-child>tr:last-child td:first-child,.panel>.table:last-child>tfoot:last-child>tr:last-child th:first-child{border-bottom-left-radius:3px}.panel>.table-responsive:last-child>.table:last-child>tbody:last-child>tr:last-child td:last-child,.panel>.table-responsive:last-child>.table:last-child>tbody:last-child>tr:last-child th:last-child,.panel>.table-responsive:last-child>.table:last-child>tfoot:last-child>tr:last-child td:last-child,.panel>.table-responsive:last-child>.table:last-child>tfoot:last-child>tr:last-child th:last-child,.panel>.table:last-child>tbody:last-child>tr:last-child td:last-child,.panel>.table:last-child>tbody:last-child>tr:last-child th:last-child,.panel>.table:last-child>tfoot:last-child>tr:last-child td:last-child,.panel>.table:last-child>tfoot:last-child>tr:last-child th:last-child{border-bottom-right-radius:3px}.panel>.panel-body+.table,.panel>.panel-body+.table-responsive,.panel>.table+.panel-body,.panel>.table-responsive+.panel-body{border-top:1px solid #ddd}.panel>.table>tbody:first-child>tr:first-child td,.panel>.table>tbody:first-child>tr:first-child th{border-top:0}.panel>.table-bordered,.panel>.table-responsive>.table-bordered{border:0}.panel>.table-bordered>tbody>tr>td:first-child,.panel>.table-bordered>tbody>tr>th:first-child,.panel>.table-bordered>tfoot>tr>td:first-child,.panel>.table-bordered>tfoot>tr>th:first-child,.panel>.table-bordered>thead>tr>td:first-child,.panel>.table-bordered>thead>tr>th:first-child,.panel>.table-responsive>.table-bordered>tbody>tr>td:first-child,.panel>.table-responsive>.table-bordered>tbody>tr>th:first-child,.panel>.table-responsive>.table-bordered>tfoot>tr>td:first-child,.panel>.table-responsive>.table-bordered>tfoot>tr>th:first-child,.panel>.table-responsive>.table-bordered>thead>tr>td:first-child,.panel>.table-responsive>.table-bordered>thead>tr>th:first-child{border-left:0}.panel>.table-bordered>tbody>tr>td:last-child,.panel>.table-bordered>tbody>tr>th:last-child,.panel>.table-bordered>tfoot>tr>td:last-child,.panel>.table-bordered>tfoot>tr>th:last-child,.panel>.table-bordered>thead>tr>td:last-child,.panel>.table-bordered>thead>tr>th:last-child,.panel>.table-responsive>.table-bordered>tbody>tr>td:last-child,.panel>.table-responsive>.table-bordered>tbody>tr>th:last-child,.panel>.table-responsive>.table-bordered>tfoot>tr>td:last-child,.panel>.table-responsive>.table-bordered>tfoot>tr>th:last-child,.panel>.table-responsive>.table-bordered>thead>tr>td:last-child,.panel>.table-responsive>.table-bordered>thead>tr>th:last-child{border-right:0}.panel>.table-bordered>tbody>tr:first-child>td,.panel>.table-bordered>tbody>tr:first-child>th,.panel>.table-bordered>thead>tr:first-child>td,.panel>.table-bordered>thead>tr:first-child>th,.panel>.table-responsive>.table-bordered>tbody>tr:first-child>td,.panel>.table-responsive>.table-bordered>tbody>tr:first-child>th,.panel>.table-responsive>.table-bordered>thead>tr:first-child>td,.panel>.table-responsive>.table-bordered>thead>tr:first-child>th{border-bottom:0}.panel>.table-bordered>tbody>tr:last-child>td,.panel>.table-bordered>tbody>tr:last-child>th,.panel>.table-bordered>tfoot>tr:last-child>td,.panel>.table-bordered>tfoot>tr:last-child>th,.panel>.table-responsive>.table-bordered>tbody>tr:last-child>td,.panel>.table-responsive>.table-bordered>tbody>tr:last-child>th,.panel>.table-responsive>.table-bordered>tfoot>tr:last-child>td,.panel>.table-responsive>.table-bordered>tfoot>tr:last-child>th{border-bottom:0}.panel>.table-responsive{margin-bottom:0;border:0}.panel-group{margin-bottom:20px}.panel-group .panel{margin-bottom:0;border-radius:4px}.panel-group .panel+.panel{margin-top:5px}.panel-group .panel-heading{border-bottom:0}.panel-group .panel-heading+.panel-collapse>.list-group,.panel-group .panel-heading+.panel-collapse>.panel-body{border-top:1px solid #ddd}.panel-group .panel-footer{border-top:0}.panel-group .panel-footer+.panel-collapse .panel-body{border-bottom:1px solid #ddd}.panel-default{border-color:#ddd}.panel-default>.panel-heading{color:#333;background-color:#f5f5f5;border-color:#ddd}.panel-default>.panel-heading+.panel-collapse>.panel-body{border-top-color:#ddd}.panel-default>.panel-heading .badge{color:#f5f5f5;background-color:#333}.panel-default>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#ddd}.panel-primary{border-color:#337ab7}.panel-primary>.panel-heading{color:#fff;background-color:#337ab7;border-color:#337ab7}.panel-primary>.panel-heading+.panel-collapse>.panel-body{border-top-color:#337ab7}.panel-primary>.panel-heading .badge{color:#337ab7;background-color:#fff}.panel-primary>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#337ab7}.panel-success{border-color:#d6e9c6}.panel-success>.panel-heading{color:#3c763d;background-color:#dff0d8;border-color:#d6e9c6}.panel-success>.panel-heading+.panel-collapse>.panel-body{border-top-color:#d6e9c6}.panel-success>.panel-heading .badge{color:#dff0d8;background-color:#3c763d}.panel-success>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#d6e9c6}.panel-info{border-color:#bce8f1}.panel-info>.panel-heading{color:#31708f;background-color:#d9edf7;border-color:#bce8f1}.panel-info>.panel-heading+.panel-collapse>.panel-body{border-top-color:#bce8f1}.panel-info>.panel-heading .badge{color:#d9edf7;background-color:#31708f}.panel-info>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#bce8f1}.panel-warning{border-color:#faebcc}.panel-warning>.panel-heading{color:#8a6d3b;background-color:#fcf8e3;border-color:#faebcc}.panel-warning>.panel-heading+.panel-collapse>.panel-body{border-top-color:#faebcc}.panel-warning>.panel-heading .badge{color:#fcf8e3;background-color:#8a6d3b}.panel-warning>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#faebcc}.panel-danger{border-color:#ebccd1}.panel-danger>.panel-heading{color:#a94442;background-color:#f2dede;border-color:#ebccd1}.panel-danger>.panel-heading+.panel-collapse>.panel-body{border-top-color:#ebccd1}.panel-danger>.panel-heading .badge{color:#f2dede;background-color:#a94442}.panel-danger>.panel-footer+.panel-collapse>.panel-body{border-bottom-color:#ebccd1}.embed-responsive{position:relative;display:block;height:0;padding:0;overflow:hidden}.embed-responsive .embed-responsive-item,.embed-responsive embed,.embed-responsive iframe,.embed-responsive object,.embed-responsive video{position:absolute;top:0;bottom:0;left:0;width:100%;height:100%;border:0}.embed-responsive-16by9{padding-bottom:56.25%}.embed-responsive-4by3{padding-bottom:75%}.well{min-height:20px;padding:19px;margin-bottom:20px;background-color:#f5f5f5;border:1px solid #e3e3e3;border-radius:4px;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.05);box-shadow:inset 0 1px 1px rgba(0,0,0,.05)}.well blockquote{border-color:#ddd;border-color:rgba(0,0,0,.15)}.well-lg{padding:24px;border-radius:6px}.well-sm{padding:9px;border-radius:3px}.close{float:right;font-size:21px;font-weight:700;line-height:1;color:#000;text-shadow:0 1px 0 #fff;filter:alpha(opacity=20);opacity:.2}.close:focus,.close:hover{color:#000;text-decoration:none;cursor:pointer;filter:alpha(opacity=50);opacity:.5}button.close{-webkit-appearance:none;padding:0;cursor:pointer;background:0 0;border:0}.modal-open{overflow:hidden}.modal{position:fixed;top:0;right:0;bottom:0;left:0;z-index:1050;display:none;overflow:hidden;-webkit-overflow-scrolling:touch;outline:0}.modal.fade .modal-dialog{-webkit-transition:-webkit-transform .3s ease-out;-o-transition:-o-transform .3s ease-out;transition:transform .3s ease-out;-webkit-transform:translate(0,-25%);-ms-transform:translate(0,-25%);-o-transform:translate(0,-25%);transform:translate(0,-25%)}.modal.in .modal-dialog{-webkit-transform:translate(0,0);-ms-transform:translate(0,0);-o-transform:translate(0,0);transform:translate(0,0)}.modal-open .modal{overflow-x:hidden;overflow-y:auto}.modal-dialog{position:relative;width:auto;margin:10px}.modal-content{position:relative;background-color:#fff;-webkit-background-clip:padding-box;background-clip:padding-box;border:1px solid #999;border:1px solid rgba(0,0,0,.2);border-radius:6px;outline:0;-webkit-box-shadow:0 3px 9px rgba(0,0,0,.5);box-shadow:0 3px 9px rgba(0,0,0,.5)}.modal-backdrop{position:fixed;top:0;right:0;bottom:0;left:0;z-index:1040;background-color:#000}.modal-backdrop.fade{filter:alpha(opacity=0);opacity:0}.modal-backdrop.in{filter:alpha(opacity=50);opacity:.5}.modal-header{padding:15px;border-bottom:1px solid #e5e5e5}.modal-header .close{margin-top:-2px}.modal-title{margin:0;line-height:1.42857143}.modal-body{position:relative;padding:15px}.modal-footer{padding:15px;text-align:right;border-top:1px solid #e5e5e5}.modal-footer .btn+.btn{margin-bottom:0;margin-left:5px}.modal-footer .btn-group .btn+.btn{margin-left:-1px}.modal-footer .btn-block+.btn-block{margin-left:0}.modal-scrollbar-measure{position:absolute;top:-9999px;width:50px;height:50px;overflow:scroll}@media (min-width:768px){.modal-dialog{width:600px;margin:30px auto}.modal-content{-webkit-box-shadow:0 5px 15px rgba(0,0,0,.5);box-shadow:0 5px 15px rgba(0,0,0,.5)}.modal-sm{width:300px}}@media (min-width:992px){.modal-lg{width:900px}}.tooltip{position:absolute;z-index:1070;display:block;font-family:"Helvetica Neue",Helvetica,Arial,sans-serif;font-size:12px;font-style:normal;font-weight:400;line-height:1.42857143;text-align:left;text-align:start;text-decoration:none;text-shadow:none;text-transform:none;letter-spacing:normal;word-break:normal;word-spacing:normal;word-wrap:normal;white-space:normal;filter:alpha(opacity=0);opacity:0;line-break:auto}.tooltip.in{filter:alpha(opacity=90);opacity:.9}.tooltip.top{padding:5px 0;margin-top:-3px}.tooltip.right{padding:0 5px;margin-left:3px}.tooltip.bottom{padding:5px 0;margin-top:3px}.tooltip.left{padding:0 5px;margin-left:-3px}.tooltip-inner{max-width:200px;padding:3px 8px;color:#fff;text-align:center;background-color:#000;border-radius:4px}.tooltip-arrow{position:absolute;width:0;height:0;border-color:transparent;border-style:solid}.tooltip.top .tooltip-arrow{bottom:0;left:50%;margin-left:-5px;border-width:5px 5px 0;border-top-color:#000}.tooltip.top-left .tooltip-arrow{right:5px;bottom:0;margin-bottom:-5px;border-width:5px 5px 0;border-top-color:#000}.tooltip.top-right .tooltip-arrow{bottom:0;left:5px;margin-bottom:-5px;border-width:5px 5px 0;border-top-color:#000}.tooltip.right .tooltip-arrow{top:50%;left:0;margin-top:-5px;border-width:5px 5px 5px 0;border-right-color:#000}.tooltip.left .tooltip-arrow{top:50%;right:0;margin-top:-5px;border-width:5px 0 5px 5px;border-left-color:#000}.tooltip.bottom .tooltip-arrow{top:0;left:50%;margin-left:-5px;border-width:0 5px 5px;border-bottom-color:#000}.tooltip.bottom-left .tooltip-arrow{top:0;right:5px;margin-top:-5px;border-width:0 5px 5px;border-bottom-color:#000}.tooltip.bottom-right .tooltip-arrow{top:0;left:5px;margin-top:-5px;border-width:0 5px 5px;border-bottom-color:#000}.popover{position:absolute;top:0;left:0;z-index:1060;display:none;max-width:276px;padding:1px;font-family:"Helvetica Neue",Helvetica,Arial,sans-serif;font-size:14px;font-style:normal;font-weight:400;line-height:1.42857143;text-align:left;text-align:start;text-decoration:none;text-shadow:none;text-transform:none;letter-spacing:normal;word-break:normal;word-spacing:normal;word-wrap:normal;white-space:normal;background-color:#fff;-webkit-background-clip:padding-box;background-clip:padding-box;border:1px solid #ccc;border:1px solid rgba(0,0,0,.2);border-radius:6px;-webkit-box-shadow:0 5px 10px rgba(0,0,0,.2);box-shadow:0 5px 10px rgba(0,0,0,.2);line-break:auto}.popover.top{margin-top:-10px}.popover.right{margin-left:10px}.popover.bottom{margin-top:10px}.popover.left{margin-left:-10px}.popover-title{padding:8px 14px;margin:0;font-size:14px;background-color:#f7f7f7;border-bottom:1px solid #ebebeb;border-radius:5px 5px 0 0}.popover-content{padding:9px 14px}.popover>.arrow,.popover>.arrow:after{position:absolute;display:block;width:0;height:0;border-color:transparent;border-style:solid}.popover>.arrow{border-width:11px}.popover>.arrow:after{content:"";border-width:10px}.popover.top>.arrow{bottom:-11px;left:50%;margin-left:-11px;border-top-color:#999;border-top-color:rgba(0,0,0,.25);border-bottom-width:0}.popover.top>.arrow:after{bottom:1px;margin-left:-10px;content:" ";border-top-color:#fff;border-bottom-width:0}.popover.right>.arrow{top:50%;left:-11px;margin-top:-11px;border-right-color:#999;border-right-color:rgba(0,0,0,.25);border-left-width:0}.popover.right>.arrow:after{bottom:-10px;left:1px;content:" ";border-right-color:#fff;border-left-width:0}.popover.bottom>.arrow{top:-11px;left:50%;margin-left:-11px;border-top-width:0;border-bottom-color:#999;border-bottom-color:rgba(0,0,0,.25)}.popover.bottom>.arrow:after{top:1px;margin-left:-10px;content:" ";border-top-width:0;border-bottom-color:#fff}.popover.left>.arrow{top:50%;right:-11px;margin-top:-11px;border-right-width:0;border-left-color:#999;border-left-color:rgba(0,0,0,.25)}.popover.left>.arrow:after{right:1px;bottom:-10px;content:" ";border-right-width:0;border-left-color:#fff}.carousel{position:relative}.carousel-inner{position:relative;width:100%;overflow:hidden}.carousel-inner>.item{position:relative;display:none;-webkit-transition:.6s ease-in-out left;-o-transition:.6s ease-in-out left;transition:.6s ease-in-out left}.carousel-inner>.item>a>img,.carousel-inner>.item>img{line-height:1}@media all and (transform-3d),(-webkit-transform-3d){.carousel-inner>.item{-webkit-transition:-webkit-transform .6s ease-in-out;-o-transition:-o-transform .6s ease-in-out;transition:transform .6s ease-in-out;-webkit-backface-visibility:hidden;backface-visibility:hidden;-webkit-perspective:1000px;perspective:1000px}.carousel-inner>.item.active.right,.carousel-inner>.item.next{left:0;-webkit-transform:translate3d(100%,0,0);transform:translate3d(100%,0,0)}.carousel-inner>.item.active.left,.carousel-inner>.item.prev{left:0;-webkit-transform:translate3d(-100%,0,0);transform:translate3d(-100%,0,0)}.carousel-inner>.item.active,.carousel-inner>.item.next.left,.carousel-inner>.item.prev.right{left:0;-webkit-transform:translate3d(0,0,0);transform:translate3d(0,0,0)}}.carousel-inner>.active,.carousel-inner>.next,.carousel-inner>.prev{display:block}.carousel-inner>.active{left:0}.carousel-inner>.next,.carousel-inner>.prev{position:absolute;top:0;width:100%}.carousel-inner>.next{left:100%}.carousel-inner>.prev{left:-100%}.carousel-inner>.next.left,.carousel-inner>.prev.right{left:0}.carousel-inner>.active.left{left:-100%}.carousel-inner>.active.right{left:100%}.carousel-control{position:absolute;top:0;bottom:0;left:0;width:15%;font-size:20px;color:#fff;text-align:center;text-shadow:0 1px 2px rgba(0,0,0,.6);background-color:rgba(0,0,0,0);filter:alpha(opacity=50);opacity:.5}.carousel-control.left{background-image:-webkit-linear-gradient(left,rgba(0,0,0,.5) 0,rgba(0,0,0,.0001) 100%);background-image:-o-linear-gradient(left,rgba(0,0,0,.5) 0,rgba(0,0,0,.0001) 100%);background-image:-webkit-gradient(linear,left top,right top,from(rgba(0,0,0,.5)),to(rgba(0,0,0,.0001)));background-image:linear-gradient(to right,rgba(0,0,0,.5) 0,rgba(0,0,0,.0001) 100%);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#80000000', endColorstr='#00000000', GradientType=1);background-repeat:repeat-x}.carousel-control.right{right:0;left:auto;background-image:-webkit-linear-gradient(left,rgba(0,0,0,.0001) 0,rgba(0,0,0,.5) 100%);background-image:-o-linear-gradient(left,rgba(0,0,0,.0001) 0,rgba(0,0,0,.5) 100%);background-image:-webkit-gradient(linear,left top,right top,from(rgba(0,0,0,.0001)),to(rgba(0,0,0,.5)));background-image:linear-gradient(to right,rgba(0,0,0,.0001) 0,rgba(0,0,0,.5) 100%);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#00000000', endColorstr='#80000000', GradientType=1);background-repeat:repeat-x}.carousel-control:focus,.carousel-control:hover{color:#fff;text-decoration:none;filter:alpha(opacity=90);outline:0;opacity:.9}.carousel-control .glyphicon-chevron-left,.carousel-control .glyphicon-chevron-right,.carousel-control .icon-next,.carousel-control .icon-prev{position:absolute;top:50%;z-index:5;display:inline-block;margin-top:-10px}.carousel-control .glyphicon-chevron-left,.carousel-control .icon-prev{left:50%;margin-left:-10px}.carousel-control .glyphicon-chevron-right,.carousel-control .icon-next{right:50%;margin-right:-10px}.carousel-control .icon-next,.carousel-control .icon-prev{width:20px;height:20px;font-family:serif;line-height:1}.carousel-control .icon-prev:before{content:'\2039'}.carousel-control .icon-next:before{content:'\203a'}.carousel-indicators{position:absolute;bottom:10px;left:50%;z-index:15;width:60%;padding-left:0;margin-left:-30%;text-align:center;list-style:none}.carousel-indicators li{display:inline-block;width:10px;height:10px;margin:1px;text-indent:-999px;cursor:pointer;background-color:#000\9;background-color:rgba(0,0,0,0);border:1px solid #fff;border-radius:10px}.carousel-indicators .active{width:12px;height:12px;margin:0;background-color:#fff}.carousel-caption{position:absolute;right:15%;bottom:20px;left:15%;z-index:10;padding-top:20px;padding-bottom:20px;color:#fff;text-align:center;text-shadow:0 1px 2px rgba(0,0,0,.6)}.carousel-caption .btn{text-shadow:none}@media screen and (min-width:768px){.carousel-control .glyphicon-chevron-left,.carousel-control .glyphicon-chevron-right,.carousel-control .icon-next,.carousel-control .icon-prev{width:30px;height:30px;margin-top:-10px;font-size:30px}.carousel-control .glyphicon-chevron-left,.carousel-control .icon-prev{margin-left:-10px}.carousel-control .glyphicon-chevron-right,.carousel-control .icon-next{margin-right:-10px}.carousel-caption{right:20%;left:20%;padding-bottom:30px}.carousel-indicators{bottom:20px}}.btn-group-vertical>.btn-group:after,.btn-group-vertical>.btn-group:before,.btn-toolbar:after,.btn-toolbar:before,.clearfix:after,.clearfix:before,.container-fluid:after,.container-fluid:before,.container:after,.container:before,.dl-horizontal dd:after,.dl-horizontal dd:before,.form-horizontal .form-group:after,.form-horizontal .form-group:before,.modal-footer:after,.modal-footer:before,.modal-header:after,.modal-header:before,.nav:after,.nav:before,.navbar-collapse:after,.navbar-collapse:before,.navbar-header:after,.navbar-header:before,.navbar:after,.navbar:before,.pager:after,.pager:before,.panel-body:after,.panel-body:before,.row:after,.row:before{display:table;content:" "}.btn-group-vertical>.btn-group:after,.btn-toolbar:after,.clearfix:after,.container-fluid:after,.container:after,.dl-horizontal dd:after,.form-horizontal .form-group:after,.modal-footer:after,.modal-header:after,.nav:after,.navbar-collapse:after,.navbar-header:after,.navbar:after,.pager:after,.panel-body:after,.row:after{clear:both}.center-block{display:block;margin-right:auto;margin-left:auto}.pull-right{float:right!important}.pull-left{float:left!important}.hide{display:none!important}.show{display:block!important}.invisible{visibility:hidden}.text-hide{font:0/0 a;color:transparent;text-shadow:none;background-color:transparent;border:0}.hidden{display:none!important}.affix{position:fixed}@-ms-viewport{width:device-width}.visible-lg,.visible-md,.visible-sm,.visible-xs{display:none!important}.visible-lg-block,.visible-lg-inline,.visible-lg-inline-block,.visible-md-block,.visible-md-inline,.visible-md-inline-block,.visible-sm-block,.visible-sm-inline,.visible-sm-inline-block,.visible-xs-block,.visible-xs-inline,.visible-xs-inline-block{display:none!important}@media (max-width:767px){.visible-xs{display:block!important}table.visible-xs{display:table!important}tr.visible-xs{display:table-row!important}td.visible-xs,th.visible-xs{display:table-cell!important}}@media (max-width:767px){.visible-xs-block{display:block!important}}@media (max-width:767px){.visible-xs-inline{display:inline!important}}@media (max-width:767px){.visible-xs-inline-block{display:inline-block!important}}@media (min-width:768px) and (max-width:991px){.visible-sm{display:block!important}table.visible-sm{display:table!important}tr.visible-sm{display:table-row!important}td.visible-sm,th.visible-sm{display:table-cell!important}}@media (min-width:768px) and (max-width:991px){.visible-sm-block{display:block!important}}@media (min-width:768px) and (max-width:991px){.visible-sm-inline{display:inline!important}}@media (min-width:768px) and (max-width:991px){.visible-sm-inline-block{display:inline-block!important}}@media (min-width:992px) and (max-width:1199px){.visible-md{display:block!important}table.visible-md{display:table!important}tr.visible-md{display:table-row!important}td.visible-md,th.visible-md{display:table-cell!important}}@media (min-width:992px) and (max-width:1199px){.visible-md-block{display:block!important}}@media (min-width:992px) and (max-width:1199px){.visible-md-inline{display:inline!important}}@media (min-width:992px) and (max-width:1199px){.visible-md-inline-block{display:inline-block!important}}@media (min-width:1200px){.visible-lg{display:block!important}table.visible-lg{display:table!important}tr.visible-lg{display:table-row!important}td.visible-lg,th.visible-lg{display:table-cell!important}}@media (min-width:1200px){.visible-lg-block{display:block!important}}@media (min-width:1200px){.visible-lg-inline{display:inline!important}}@media (min-width:1200px){.visible-lg-inline-block{display:inline-block!important}}@media (max-width:767px){.hidden-xs{display:none!important}}@media (min-width:768px) and (max-width:991px){.hidden-sm{display:none!important}}@media (min-width:992px) and (max-width:1199px){.hidden-md{display:none!important}}@media (min-width:1200px){.hidden-lg{display:none!important}}.visible-print{display:none!important}@media print{.visible-print{display:block!important}table.visible-print{display:table!important}tr.visible-print{display:table-row!important}td.visible-print,th.visible-print{display:table-cell!important}}.visible-print-block{display:none!important}@media print{.visible-print-block{display:block!important}}.visible-print-inline{display:none!important}@media print{.visible-print-inline{display:inline!important}}.visible-print-inline-block{display:none!important}@media print{.visible-print-inline-block{display:inline-block!important}}@media print{.hidden-print{display:none!important}}
/*# sourceMappingURL=bootstrap.min.css.map */






body {
  background-color: #CCCCCC;
}
body.inverse {
  background: #333333;
}
body.inverse, body.inverse .form-control {
  color: #ffffff;
}
body.inverse .modal,
body.inverse .modal .form-control,
body.inverse .panel-default,
body.inverse .panel-default .form-control,
body.inverse .card,
body.inverse .card .form-control {
  background-color: initial;
  color: initial;
}

.life-of-material-kit {
  background: #FFFFFF;
}

body, h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4 {
  font-family: "Roboto", "Helvetica", "Arial", sans-serif;
  font-weight: 300;
  line-height: 1.5em;
}

a, a:hover, a:focus {
  color: #9c27b0;
}
a .material-icons, a:hover .material-icons, a:focus .material-icons {
  vertical-align: middle;
}

/*           Animations              */
.animation-transition-general, .carousel .carousel-indicators li {
  -webkit-transition: all 300ms linear;
  -moz-transition: all 300ms linear;
  -o-transition: all 300ms linear;
  -ms-transition: all 300ms linear;
  transition: all 300ms linear;
}

.animation-transition-slow {
  -webkit-transition: all 370ms linear;
  -moz-transition: all 370ms linear;
  -o-transition: all 370ms linear;
  -ms-transition: all 370ms linear;
  transition: all 370ms linear;
}

.animation-transition-fast, .navbar {
  -webkit-transition: all 150ms ease 0s;
  -moz-transition: all 150ms ease 0s;
  -o-transition: all 150ms ease 0s;
  -ms-transition: all 150ms ease 0s;
  transition: all 150ms ease 0s;
}

.form-horizontal .radio,
.form-horizontal .checkbox,
.form-horizontal .radio-inline,
.form-horizontal .checkbox-inline {
  padding-top: 0;
}
.form-horizontal .radio {
  margin-bottom: 10px;
}
.form-horizontal label {
  text-align: right;
}
.form-horizontal label.control-label {
  margin: 0;
}

.btn,
.navbar .navbar-nav > li > a.btn {
  border: none;
  border-radius: 3px;
  position: relative;
  padding: 12px 30px;
  margin: 10px 1px;
  font-size: 12px;
  font-weight: 400;
  text-transform: uppercase;
  letter-spacing: 0;
  will-change: box-shadow, transform;
  transition: box-shadow 0.2s cubic-bezier(0.4, 0, 1, 1), background-color 0.2s cubic-bezier(0.4, 0, 0.2, 1);
}
.btn::-moz-focus-inner,
.navbar .navbar-nav > li > a.btn::-moz-focus-inner {
  border: 0;
}
.btn, .btn.btn-default,
.navbar .navbar-nav > li > a.btn,
.navbar .navbar-nav > li > a.btn.btn-default {
  box-shadow: 0 2px 2px 0 rgba(153, 153, 153, 0.14), 0 3px 1px -2px rgba(153, 153, 153, 0.2), 0 1px 5px 0 rgba(153, 153, 153, 0.12);
}
.btn, .btn:hover, .btn:focus, .btn:active, .btn.active, .btn:active:focus, .btn:active:hover, .btn.active:focus, .btn.active:hover, .open > .btn.dropdown-toggle, .open > .btn.dropdown-toggle:focus, .open > .btn.dropdown-toggle:hover, .btn.btn-default, .btn.btn-default:hover, .btn.btn-default:focus, .btn.btn-default:active, .btn.btn-default.active, .btn.btn-default:active:focus, .btn.btn-default:active:hover, .btn.btn-default.active:focus, .btn.btn-default.active:hover, .open > .btn.btn-default.dropdown-toggle, .open > .btn.btn-default.dropdown-toggle:focus, .open > .btn.btn-default.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn,
.navbar .navbar-nav > li > a.btn:hover,
.navbar .navbar-nav > li > a.btn:focus,
.navbar .navbar-nav > li > a.btn:active,
.navbar .navbar-nav > li > a.btn.active,
.navbar .navbar-nav > li > a.btn:active:focus,
.navbar .navbar-nav > li > a.btn:active:hover,
.navbar .navbar-nav > li > a.btn.active:focus,
.navbar .navbar-nav > li > a.btn.active:hover, .open >
.navbar .navbar-nav > li > a.btn.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-default,
.navbar .navbar-nav > li > a.btn.btn-default:hover,
.navbar .navbar-nav > li > a.btn.btn-default:focus,
.navbar .navbar-nav > li > a.btn.btn-default:active,
.navbar .navbar-nav > li > a.btn.btn-default.active,
.navbar .navbar-nav > li > a.btn.btn-default:active:focus,
.navbar .navbar-nav > li > a.btn.btn-default:active:hover,
.navbar .navbar-nav > li > a.btn.btn-default.active:focus,
.navbar .navbar-nav > li > a.btn.btn-default.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-default.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-default.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-default.dropdown-toggle:hover {
  background-color: #999999;
  color: #FFFFFF;
}
.btn:focus, .btn:active, .btn:hover, .btn.btn-default:focus, .btn.btn-default:active, .btn.btn-default:hover,
.navbar .navbar-nav > li > a.btn:focus,
.navbar .navbar-nav > li > a.btn:active,
.navbar .navbar-nav > li > a.btn:hover,
.navbar .navbar-nav > li > a.btn.btn-default:focus,
.navbar .navbar-nav > li > a.btn.btn-default:active,
.navbar .navbar-nav > li > a.btn.btn-default:hover {
  box-shadow: 0 14px 26px -12px rgba(153, 153, 153, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(153, 153, 153, 0.2);
}
.btn.disabled, .btn.disabled:hover, .btn.disabled:focus, .btn.disabled.focus, .btn.disabled:active, .btn.disabled.active, .btn:disabled, .btn:disabled:hover, .btn:disabled:focus, .btn:disabled.focus, .btn:disabled:active, .btn:disabled.active, .btn[disabled], .btn[disabled]:hover, .btn[disabled]:focus, .btn[disabled].focus, .btn[disabled]:active, .btn[disabled].active, fieldset[disabled] .btn, fieldset[disabled] .btn:hover, fieldset[disabled] .btn:focus, fieldset[disabled] .btn.focus, fieldset[disabled] .btn:active, fieldset[disabled] .btn.active, .btn.btn-default.disabled, .btn.btn-default.disabled:hover, .btn.btn-default.disabled:focus, .btn.btn-default.disabled.focus, .btn.btn-default.disabled:active, .btn.btn-default.disabled.active, .btn.btn-default:disabled, .btn.btn-default:disabled:hover, .btn.btn-default:disabled:focus, .btn.btn-default:disabled.focus, .btn.btn-default:disabled:active, .btn.btn-default:disabled.active, .btn.btn-default[disabled], .btn.btn-default[disabled]:hover, .btn.btn-default[disabled]:focus, .btn.btn-default[disabled].focus, .btn.btn-default[disabled]:active, .btn.btn-default[disabled].active, fieldset[disabled] .btn.btn-default, fieldset[disabled] .btn.btn-default:hover, fieldset[disabled] .btn.btn-default:focus, fieldset[disabled] .btn.btn-default.focus, fieldset[disabled] .btn.btn-default:active, fieldset[disabled] .btn.btn-default.active,
.navbar .navbar-nav > li > a.btn.disabled,
.navbar .navbar-nav > li > a.btn.disabled:hover,
.navbar .navbar-nav > li > a.btn.disabled:focus,
.navbar .navbar-nav > li > a.btn.disabled.focus,
.navbar .navbar-nav > li > a.btn.disabled:active,
.navbar .navbar-nav > li > a.btn.disabled.active,
.navbar .navbar-nav > li > a.btn:disabled,
.navbar .navbar-nav > li > a.btn:disabled:hover,
.navbar .navbar-nav > li > a.btn:disabled:focus,
.navbar .navbar-nav > li > a.btn:disabled.focus,
.navbar .navbar-nav > li > a.btn:disabled:active,
.navbar .navbar-nav > li > a.btn:disabled.active,
.navbar .navbar-nav > li > a.btn[disabled],
.navbar .navbar-nav > li > a.btn[disabled]:hover,
.navbar .navbar-nav > li > a.btn[disabled]:focus,
.navbar .navbar-nav > li > a.btn[disabled].focus,
.navbar .navbar-nav > li > a.btn[disabled]:active,
.navbar .navbar-nav > li > a.btn[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn, fieldset[disabled]
.navbar .navbar-nav > li > a.btn:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.active,
.navbar .navbar-nav > li > a.btn.btn-default.disabled,
.navbar .navbar-nav > li > a.btn.btn-default.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-default.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-default.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-default.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-default.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-default:disabled,
.navbar .navbar-nav > li > a.btn.btn-default:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-default:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-default:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-default:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-default:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-default[disabled],
.navbar .navbar-nav > li > a.btn.btn-default[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-default[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-default[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-default[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-default[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-default.active {
  box-shadow: none;
}
.btn.btn-simple, .btn.btn-default.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-default.btn-simple {
  background-color: transparent;
  color: #999999;
  box-shadow: none;
}
.btn.btn-simple:hover, .btn.btn-simple:focus, .btn.btn-simple:active, .btn.btn-default.btn-simple:hover, .btn.btn-default.btn-simple:focus, .btn.btn-default.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-default.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-default.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-default.btn-simple:active {
  background-color: transparent;
  color: #999999;
}
.btn.btn-primary,
.navbar .navbar-nav > li > a.btn.btn-primary {
  box-shadow: 0 2px 2px 0 rgba(156, 39, 176, 0.14), 0 3px 1px -2px rgba(156, 39, 176, 0.2), 0 1px 5px 0 rgba(156, 39, 176, 0.12);
}
.btn.btn-primary, .btn.btn-primary:hover, .btn.btn-primary:focus, .btn.btn-primary:active, .btn.btn-primary.active, .btn.btn-primary:active:focus, .btn.btn-primary:active:hover, .btn.btn-primary.active:focus, .btn.btn-primary.active:hover, .open > .btn.btn-primary.dropdown-toggle, .open > .btn.btn-primary.dropdown-toggle:focus, .open > .btn.btn-primary.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-primary,
.navbar .navbar-nav > li > a.btn.btn-primary:hover,
.navbar .navbar-nav > li > a.btn.btn-primary:focus,
.navbar .navbar-nav > li > a.btn.btn-primary:active,
.navbar .navbar-nav > li > a.btn.btn-primary.active,
.navbar .navbar-nav > li > a.btn.btn-primary:active:focus,
.navbar .navbar-nav > li > a.btn.btn-primary:active:hover,
.navbar .navbar-nav > li > a.btn.btn-primary.active:focus,
.navbar .navbar-nav > li > a.btn.btn-primary.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-primary.dropdown-toggle:hover {
  background-color: #9c27b0;
  color: #FFFFFF;
}
.btn.btn-primary:focus, .btn.btn-primary:active, .btn.btn-primary:hover,
.navbar .navbar-nav > li > a.btn.btn-primary:focus,
.navbar .navbar-nav > li > a.btn.btn-primary:active,
.navbar .navbar-nav > li > a.btn.btn-primary:hover {
  box-shadow: 0 14px 26px -12px rgba(156, 39, 176, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(156, 39, 176, 0.2);
}
.btn.btn-primary.disabled, .btn.btn-primary.disabled:hover, .btn.btn-primary.disabled:focus, .btn.btn-primary.disabled.focus, .btn.btn-primary.disabled:active, .btn.btn-primary.disabled.active, .btn.btn-primary:disabled, .btn.btn-primary:disabled:hover, .btn.btn-primary:disabled:focus, .btn.btn-primary:disabled.focus, .btn.btn-primary:disabled:active, .btn.btn-primary:disabled.active, .btn.btn-primary[disabled], .btn.btn-primary[disabled]:hover, .btn.btn-primary[disabled]:focus, .btn.btn-primary[disabled].focus, .btn.btn-primary[disabled]:active, .btn.btn-primary[disabled].active, fieldset[disabled] .btn.btn-primary, fieldset[disabled] .btn.btn-primary:hover, fieldset[disabled] .btn.btn-primary:focus, fieldset[disabled] .btn.btn-primary.focus, fieldset[disabled] .btn.btn-primary:active, fieldset[disabled] .btn.btn-primary.active,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-primary.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-primary:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-primary[disabled],
.navbar .navbar-nav > li > a.btn.btn-primary[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-primary[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-primary[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-primary[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-primary[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-primary.active {
  box-shadow: none;
}
.btn.btn-primary.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-primary.btn-simple {
  background-color: transparent;
  color: #9c27b0;
  box-shadow: none;
}
.btn.btn-primary.btn-simple:hover, .btn.btn-primary.btn-simple:focus, .btn.btn-primary.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-primary.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-primary.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-primary.btn-simple:active {
  background-color: transparent;
  color: #9c27b0;
}
.btn.btn-info,
.navbar .navbar-nav > li > a.btn.btn-info {
  box-shadow: 0 2px 2px 0 rgba(3, 169, 244, 0.14), 0 3px 1px -2px rgba(3, 169, 244, 0.2), 0 1px 5px 0 rgba(3, 169, 244, 0.12);
}
.btn.btn-info, .btn.btn-info:hover, .btn.btn-info:focus, .btn.btn-info:active, .btn.btn-info.active, .btn.btn-info:active:focus, .btn.btn-info:active:hover, .btn.btn-info.active:focus, .btn.btn-info.active:hover, .open > .btn.btn-info.dropdown-toggle, .open > .btn.btn-info.dropdown-toggle:focus, .open > .btn.btn-info.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-info,
.navbar .navbar-nav > li > a.btn.btn-info:hover,
.navbar .navbar-nav > li > a.btn.btn-info:focus,
.navbar .navbar-nav > li > a.btn.btn-info:active,
.navbar .navbar-nav > li > a.btn.btn-info.active,
.navbar .navbar-nav > li > a.btn.btn-info:active:focus,
.navbar .navbar-nav > li > a.btn.btn-info:active:hover,
.navbar .navbar-nav > li > a.btn.btn-info.active:focus,
.navbar .navbar-nav > li > a.btn.btn-info.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-info.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-info.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-info.dropdown-toggle:hover {
  background-color: #03a9f4;
  color: #FFFFFF;
}
.btn.btn-info:focus, .btn.btn-info:active, .btn.btn-info:hover,
.navbar .navbar-nav > li > a.btn.btn-info:focus,
.navbar .navbar-nav > li > a.btn.btn-info:active,
.navbar .navbar-nav > li > a.btn.btn-info:hover {
  box-shadow: 0 14px 26px -12px rgba(3, 169, 244, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(3, 169, 244, 0.2);
}
.btn.btn-info.disabled, .btn.btn-info.disabled:hover, .btn.btn-info.disabled:focus, .btn.btn-info.disabled.focus, .btn.btn-info.disabled:active, .btn.btn-info.disabled.active, .btn.btn-info:disabled, .btn.btn-info:disabled:hover, .btn.btn-info:disabled:focus, .btn.btn-info:disabled.focus, .btn.btn-info:disabled:active, .btn.btn-info:disabled.active, .btn.btn-info[disabled], .btn.btn-info[disabled]:hover, .btn.btn-info[disabled]:focus, .btn.btn-info[disabled].focus, .btn.btn-info[disabled]:active, .btn.btn-info[disabled].active, fieldset[disabled] .btn.btn-info, fieldset[disabled] .btn.btn-info:hover, fieldset[disabled] .btn.btn-info:focus, fieldset[disabled] .btn.btn-info.focus, fieldset[disabled] .btn.btn-info:active, fieldset[disabled] .btn.btn-info.active,
.navbar .navbar-nav > li > a.btn.btn-info.disabled,
.navbar .navbar-nav > li > a.btn.btn-info.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-info.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-info.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-info.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-info.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-info:disabled,
.navbar .navbar-nav > li > a.btn.btn-info:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-info:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-info:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-info:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-info:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-info[disabled],
.navbar .navbar-nav > li > a.btn.btn-info[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-info[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-info[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-info[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-info[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-info.active {
  box-shadow: none;
}
.btn.btn-info.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-info.btn-simple {
  background-color: transparent;
  color: #03a9f4;
  box-shadow: none;
}
.btn.btn-info.btn-simple:hover, .btn.btn-info.btn-simple:focus, .btn.btn-info.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-info.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-info.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-info.btn-simple:active {
  background-color: transparent;
  color: #03a9f4;
}
.btn.btn-success,
.navbar .navbar-nav > li > a.btn.btn-success {
  box-shadow: 0 2px 2px 0 rgba(76, 175, 80, 0.14), 0 3px 1px -2px rgba(76, 175, 80, 0.2), 0 1px 5px 0 rgba(76, 175, 80, 0.12);
}
.btn.btn-success, .btn.btn-success:hover, .btn.btn-success:focus, .btn.btn-success:active, .btn.btn-success.active, .btn.btn-success:active:focus, .btn.btn-success:active:hover, .btn.btn-success.active:focus, .btn.btn-success.active:hover, .open > .btn.btn-success.dropdown-toggle, .open > .btn.btn-success.dropdown-toggle:focus, .open > .btn.btn-success.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-success,
.navbar .navbar-nav > li > a.btn.btn-success:hover,
.navbar .navbar-nav > li > a.btn.btn-success:focus,
.navbar .navbar-nav > li > a.btn.btn-success:active,
.navbar .navbar-nav > li > a.btn.btn-success.active,
.navbar .navbar-nav > li > a.btn.btn-success:active:focus,
.navbar .navbar-nav > li > a.btn.btn-success:active:hover,
.navbar .navbar-nav > li > a.btn.btn-success.active:focus,
.navbar .navbar-nav > li > a.btn.btn-success.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-success.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-success.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-success.dropdown-toggle:hover {
  background-color: #4caf50;
  color: #FFFFFF;
}
.btn.btn-success:focus, .btn.btn-success:active, .btn.btn-success:hover,
.navbar .navbar-nav > li > a.btn.btn-success:focus,
.navbar .navbar-nav > li > a.btn.btn-success:active,
.navbar .navbar-nav > li > a.btn.btn-success:hover {
  box-shadow: 0 14px 26px -12px rgba(76, 175, 80, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(76, 175, 80, 0.2);
}
.btn.btn-success.disabled, .btn.btn-success.disabled:hover, .btn.btn-success.disabled:focus, .btn.btn-success.disabled.focus, .btn.btn-success.disabled:active, .btn.btn-success.disabled.active, .btn.btn-success:disabled, .btn.btn-success:disabled:hover, .btn.btn-success:disabled:focus, .btn.btn-success:disabled.focus, .btn.btn-success:disabled:active, .btn.btn-success:disabled.active, .btn.btn-success[disabled], .btn.btn-success[disabled]:hover, .btn.btn-success[disabled]:focus, .btn.btn-success[disabled].focus, .btn.btn-success[disabled]:active, .btn.btn-success[disabled].active, fieldset[disabled] .btn.btn-success, fieldset[disabled] .btn.btn-success:hover, fieldset[disabled] .btn.btn-success:focus, fieldset[disabled] .btn.btn-success.focus, fieldset[disabled] .btn.btn-success:active, fieldset[disabled] .btn.btn-success.active,
.navbar .navbar-nav > li > a.btn.btn-success.disabled,
.navbar .navbar-nav > li > a.btn.btn-success.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-success.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-success.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-success.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-success.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-success:disabled,
.navbar .navbar-nav > li > a.btn.btn-success:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-success:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-success:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-success:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-success:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-success[disabled],
.navbar .navbar-nav > li > a.btn.btn-success[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-success[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-success[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-success[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-success[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-success.active {
  box-shadow: none;
}
.btn.btn-success.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-success.btn-simple {
  background-color: transparent;
  color: #4caf50;
  box-shadow: none;
}
.btn.btn-success.btn-simple:hover, .btn.btn-success.btn-simple:focus, .btn.btn-success.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-success.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-success.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-success.btn-simple:active {
  background-color: transparent;
  color: #4caf50;
}
.btn.btn-warning,
.navbar .navbar-nav > li > a.btn.btn-warning {
  box-shadow: 0 2px 2px 0 rgba(251, 192, 45, 0.14), 0 3px 1px -2px rgba(251, 192, 45, 0.2), 0 1px 5px 0 rgba(251, 192, 45, 0.12);
}
.btn.btn-warning, .btn.btn-warning:hover, .btn.btn-warning:focus, .btn.btn-warning:active, .btn.btn-warning.active, .btn.btn-warning:active:focus, .btn.btn-warning:active:hover, .btn.btn-warning.active:focus, .btn.btn-warning.active:hover, .open > .btn.btn-warning.dropdown-toggle, .open > .btn.btn-warning.dropdown-toggle:focus, .open > .btn.btn-warning.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-warning,
.navbar .navbar-nav > li > a.btn.btn-warning:hover,
.navbar .navbar-nav > li > a.btn.btn-warning:focus,
.navbar .navbar-nav > li > a.btn.btn-warning:active,
.navbar .navbar-nav > li > a.btn.btn-warning.active,
.navbar .navbar-nav > li > a.btn.btn-warning:active:focus,
.navbar .navbar-nav > li > a.btn.btn-warning:active:hover,
.navbar .navbar-nav > li > a.btn.btn-warning.active:focus,
.navbar .navbar-nav > li > a.btn.btn-warning.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-warning.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-warning.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-warning.dropdown-toggle:hover {
  background-color: #fbc02d;
  color: #FFFFFF;
}
.btn.btn-warning:focus, .btn.btn-warning:active, .btn.btn-warning:hover,
.navbar .navbar-nav > li > a.btn.btn-warning:focus,
.navbar .navbar-nav > li > a.btn.btn-warning:active,
.navbar .navbar-nav > li > a.btn.btn-warning:hover {
  box-shadow: 0 14px 26px -12px rgba(251, 192, 45, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(251, 192, 45, 0.2);
}
.btn.btn-warning.disabled, .btn.btn-warning.disabled:hover, .btn.btn-warning.disabled:focus, .btn.btn-warning.disabled.focus, .btn.btn-warning.disabled:active, .btn.btn-warning.disabled.active, .btn.btn-warning:disabled, .btn.btn-warning:disabled:hover, .btn.btn-warning:disabled:focus, .btn.btn-warning:disabled.focus, .btn.btn-warning:disabled:active, .btn.btn-warning:disabled.active, .btn.btn-warning[disabled], .btn.btn-warning[disabled]:hover, .btn.btn-warning[disabled]:focus, .btn.btn-warning[disabled].focus, .btn.btn-warning[disabled]:active, .btn.btn-warning[disabled].active, fieldset[disabled] .btn.btn-warning, fieldset[disabled] .btn.btn-warning:hover, fieldset[disabled] .btn.btn-warning:focus, fieldset[disabled] .btn.btn-warning.focus, fieldset[disabled] .btn.btn-warning:active, fieldset[disabled] .btn.btn-warning.active,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-warning.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-warning:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-warning[disabled],
.navbar .navbar-nav > li > a.btn.btn-warning[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-warning[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-warning[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-warning[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-warning[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-warning.active {
  box-shadow: none;
}
.btn.btn-warning.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-warning.btn-simple {
  background-color: transparent;
  color: #fbc02d;
  box-shadow: none;
}
.btn.btn-warning.btn-simple:hover, .btn.btn-warning.btn-simple:focus, .btn.btn-warning.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-warning.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-warning.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-warning.btn-simple:active {
  background-color: transparent;
  color: #fbc02d;
}
.btn.btn-danger,
.navbar .navbar-nav > li > a.btn.btn-danger {
  box-shadow: 0 2px 2px 0 rgba(244, 67, 54, 0.14), 0 3px 1px -2px rgba(244, 67, 54, 0.2), 0 1px 5px 0 rgba(244, 67, 54, 0.12);
}
.btn.btn-danger, .btn.btn-danger:hover, .btn.btn-danger:focus, .btn.btn-danger:active, .btn.btn-danger.active, .btn.btn-danger:active:focus, .btn.btn-danger:active:hover, .btn.btn-danger.active:focus, .btn.btn-danger.active:hover, .open > .btn.btn-danger.dropdown-toggle, .open > .btn.btn-danger.dropdown-toggle:focus, .open > .btn.btn-danger.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-danger,
.navbar .navbar-nav > li > a.btn.btn-danger:hover,
.navbar .navbar-nav > li > a.btn.btn-danger:focus,
.navbar .navbar-nav > li > a.btn.btn-danger:active,
.navbar .navbar-nav > li > a.btn.btn-danger.active,
.navbar .navbar-nav > li > a.btn.btn-danger:active:focus,
.navbar .navbar-nav > li > a.btn.btn-danger:active:hover,
.navbar .navbar-nav > li > a.btn.btn-danger.active:focus,
.navbar .navbar-nav > li > a.btn.btn-danger.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-danger.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-danger.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-danger.dropdown-toggle:hover {
  background-color: #f44336;
  color: #FFFFFF;
}
.btn.btn-danger:focus, .btn.btn-danger:active, .btn.btn-danger:hover,
.navbar .navbar-nav > li > a.btn.btn-danger:focus,
.navbar .navbar-nav > li > a.btn.btn-danger:active,
.navbar .navbar-nav > li > a.btn.btn-danger:hover {
  box-shadow: 0 14px 26px -12px rgba(244, 67, 54, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(244, 67, 54, 0.2);
}
.btn.btn-danger.disabled, .btn.btn-danger.disabled:hover, .btn.btn-danger.disabled:focus, .btn.btn-danger.disabled.focus, .btn.btn-danger.disabled:active, .btn.btn-danger.disabled.active, .btn.btn-danger:disabled, .btn.btn-danger:disabled:hover, .btn.btn-danger:disabled:focus, .btn.btn-danger:disabled.focus, .btn.btn-danger:disabled:active, .btn.btn-danger:disabled.active, .btn.btn-danger[disabled], .btn.btn-danger[disabled]:hover, .btn.btn-danger[disabled]:focus, .btn.btn-danger[disabled].focus, .btn.btn-danger[disabled]:active, .btn.btn-danger[disabled].active, fieldset[disabled] .btn.btn-danger, fieldset[disabled] .btn.btn-danger:hover, fieldset[disabled] .btn.btn-danger:focus, fieldset[disabled] .btn.btn-danger.focus, fieldset[disabled] .btn.btn-danger:active, fieldset[disabled] .btn.btn-danger.active,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-danger.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-danger:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-danger[disabled],
.navbar .navbar-nav > li > a.btn.btn-danger[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-danger[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-danger[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-danger[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-danger[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-danger.active {
  box-shadow: none;
}
.btn.btn-danger.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-danger.btn-simple {
  background-color: transparent;
  color: #f44336;
  box-shadow: none;
}
.btn.btn-danger.btn-simple:hover, .btn.btn-danger.btn-simple:focus, .btn.btn-danger.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-danger.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-danger.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-danger.btn-simple:active {
  background-color: transparent;
  color: #f44336;
}
.btn.btn-upgrade,
.navbar .navbar-nav > li > a.btn.btn-upgrade {
  box-shadow: 0 2px 2px 0 rgba(233, 30, 99, 0.14), 0 3px 1px -2px rgba(233, 30, 99, 0.2), 0 1px 5px 0 rgba(233, 30, 99, 0.12);
}
.btn.btn-upgrade, .btn.btn-upgrade:hover, .btn.btn-upgrade:focus, .btn.btn-upgrade:active, .btn.btn-upgrade.active, .btn.btn-upgrade:active:focus, .btn.btn-upgrade:active:hover, .btn.btn-upgrade.active:focus, .btn.btn-upgrade.active:hover, .open > .btn.btn-upgrade.dropdown-toggle, .open > .btn.btn-upgrade.dropdown-toggle:focus, .open > .btn.btn-upgrade.dropdown-toggle:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade,
.navbar .navbar-nav > li > a.btn.btn-upgrade:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade.active,
.navbar .navbar-nav > li > a.btn.btn-upgrade:active:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade:active:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade.active:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade.active:hover, .open >
.navbar .navbar-nav > li > a.btn.btn-upgrade.dropdown-toggle, .open >
.navbar .navbar-nav > li > a.btn.btn-upgrade.dropdown-toggle:focus, .open >
.navbar .navbar-nav > li > a.btn.btn-upgrade.dropdown-toggle:hover {
  background-color: #e91e63;
  color: #FFFFFF;
}
.btn.btn-upgrade:focus, .btn.btn-upgrade:active, .btn.btn-upgrade:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade:hover {
  box-shadow: 0 14px 26px -12px rgba(233, 30, 99, 0.42), 0 4px 23px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(233, 30, 99, 0.2);
}
.btn.btn-upgrade.disabled, .btn.btn-upgrade.disabled:hover, .btn.btn-upgrade.disabled:focus, .btn.btn-upgrade.disabled.focus, .btn.btn-upgrade.disabled:active, .btn.btn-upgrade.disabled.active, .btn.btn-upgrade:disabled, .btn.btn-upgrade:disabled:hover, .btn.btn-upgrade:disabled:focus, .btn.btn-upgrade:disabled.focus, .btn.btn-upgrade:disabled:active, .btn.btn-upgrade:disabled.active, .btn.btn-upgrade[disabled], .btn.btn-upgrade[disabled]:hover, .btn.btn-upgrade[disabled]:focus, .btn.btn-upgrade[disabled].focus, .btn.btn-upgrade[disabled]:active, .btn.btn-upgrade[disabled].active, fieldset[disabled] .btn.btn-upgrade, fieldset[disabled] .btn.btn-upgrade:hover, fieldset[disabled] .btn.btn-upgrade:focus, fieldset[disabled] .btn.btn-upgrade.focus, fieldset[disabled] .btn.btn-upgrade:active, fieldset[disabled] .btn.btn-upgrade.active,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade.disabled.active,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled.focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade:disabled.active,
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled],
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled]:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled]:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled].focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled]:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade[disabled].active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade:hover, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade:focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade.focus, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade:active, fieldset[disabled]
.navbar .navbar-nav > li > a.btn.btn-upgrade.active {
  box-shadow: none;
}
.btn.btn-upgrade.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-upgrade.btn-simple {
  background-color: transparent;
  color: #e91e63;
  box-shadow: none;
}
.btn.btn-upgrade.btn-simple:hover, .btn.btn-upgrade.btn-simple:focus, .btn.btn-upgrade.btn-simple:active,
.navbar .navbar-nav > li > a.btn.btn-upgrade.btn-simple:hover,
.navbar .navbar-nav > li > a.btn.btn-upgrade.btn-simple:focus,
.navbar .navbar-nav > li > a.btn.btn-upgrade.btn-simple:active {
  background-color: transparent;
  color: #e91e63;
}
.btn.btn-white, .btn.btn-white:focus, .btn.btn-white:hover,
.navbar .navbar-nav > li > a.btn.btn-white,
.navbar .navbar-nav > li > a.btn.btn-white:focus,
.navbar .navbar-nav > li > a.btn.btn-white:hover {
  background-color: #FFFFFF;
  color: #999999;
}
.btn.btn-white.btn-simple,
.navbar .navbar-nav > li > a.btn.btn-white.btn-simple {
  color: #FFFFFF;
  background: transparent;
  box-shadow: none;
}
.btn:focus, .btn:active, .btn:active:focus,
.navbar .navbar-nav > li > a.btn:focus,
.navbar .navbar-nav > li > a.btn:active,
.navbar .navbar-nav > li > a.btn:active:focus {
  outline: 0;
}
.btn.btn-round,
.navbar .navbar-nav > li > a.btn.btn-round {
  border-radius: 30px;
}
.btn:not(.btn-just-icon):not(.btn-fab) .fa,
.navbar .navbar-nav > li > a.btn:not(.btn-just-icon):not(.btn-fab) .fa {
  font-size: 18px;
  margin-top: -2px;
  position: relative;
  top: 2px;
}
.btn.btn-fab,
.navbar .navbar-nav > li > a.btn.btn-fab {
  border-radius: 50%;
  font-size: 24px;
  height: 56px;
  margin: auto;
  min-width: 56px;
  width: 56px;
  padding: 0;
  overflow: hidden;
  position: relative;
  line-height: normal;
}
.btn.btn-fab .ripple-container,
.navbar .navbar-nav > li > a.btn.btn-fab .ripple-container {
  border-radius: 50%;
}
.btn.btn-fab.btn-fab-mini, .btn-group-sm .btn.btn-fab,
.navbar .navbar-nav > li > a.btn.btn-fab.btn-fab-mini, .btn-group-sm
.navbar .navbar-nav > li > a.btn.btn-fab {
  height: 40px;
  min-width: 40px;
  width: 40px;
}
.btn.btn-fab.btn-fab-mini.material-icons, .btn-group-sm .btn.btn-fab.material-icons,
.navbar .navbar-nav > li > a.btn.btn-fab.btn-fab-mini.material-icons, .btn-group-sm
.navbar .navbar-nav > li > a.btn.btn-fab.material-icons {
  top: -3.5px;
  left: -3.5px;
}
.btn.btn-fab.btn-fab-mini .material-icons, .btn-group-sm .btn.btn-fab .material-icons,
.navbar .navbar-nav > li > a.btn.btn-fab.btn-fab-mini .material-icons, .btn-group-sm
.navbar .navbar-nav > li > a.btn.btn-fab .material-icons {
  font-size: 17px;
}
.btn.btn-fab i.material-icons,
.navbar .navbar-nav > li > a.btn.btn-fab i.material-icons {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-12px, -12px);
  line-height: 24px;
  width: 24px;
  font-size: 24px;
}
.btn.btn-lg, .btn-group-lg .btn,
.navbar .navbar-nav > li > a.btn.btn-lg, .btn-group-lg
.navbar .navbar-nav > li > a.btn {
  font-size: 14px;
  padding: 18px 36px;
}
.btn.btn-sm, .btn-group-sm .btn,
.navbar .navbar-nav > li > a.btn.btn-sm, .btn-group-sm
.navbar .navbar-nav > li > a.btn {
  padding: 5px 20px;
  font-size: 11px;
}
.btn.btn-xs, .btn-group-xs .btn,
.navbar .navbar-nav > li > a.btn.btn-xs, .btn-group-xs
.navbar .navbar-nav > li > a.btn {
  padding: 4px 15px;
  font-size: 10px;
}
.btn.btn-just-icon,
.navbar .navbar-nav > li > a.btn.btn-just-icon {
  font-size: 18px;
  padding: 10px 10px;
  line-height: 1em;
}
.btn.btn-just-icon i,
.navbar .navbar-nav > li > a.btn.btn-just-icon i {
  width: 20px;
}
.btn.btn-just-icon.btn-lg,
.navbar .navbar-nav > li > a.btn.btn-just-icon.btn-lg {
  font-size: 22px;
  padding: 13px 18px;
}

.btn .material-icons {
  vertical-align: middle;
  font-size: 17px;
  top: -1px;
  position: relative;
}

.navbar .navbar-nav > li > a.btn {
  margin-top: 2px;
  margin-bottom: 2px;
}
.navbar .navbar-nav > li > a.btn.btn-fab {
  margin: 5px 2px;
}
.navbar .navbar-nav > li > a:not(.btn) .material-icons {
  margin-top: -3px;
  top: 0px;
  position: relative;
  margin-right: 3px;
}
.navbar .navbar-nav > li > .profile-photo {
  margin: 5px 2px;
}

.navbar-default:not(.navbar-transparent) .navbar-nav > li > a.btn.btn-white.btn-simple {
  color: #555555;
}

.btn-group,
.btn-group-vertical {
  position: relative;
  margin: 10px 1px;
}
.btn-group.open > .dropdown-toggle.btn, .btn-group.open > .dropdown-toggle.btn.btn-default,
.btn-group-vertical.open > .dropdown-toggle.btn,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-default {
  background-color: #EEEEEE;
}
.btn-group.open > .dropdown-toggle.btn.btn-inverse,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-inverse {
  background-color: #3f51b5;
}
.btn-group.open > .dropdown-toggle.btn.btn-primary,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-primary {
  background-color: #9c27b0;
}
.btn-group.open > .dropdown-toggle.btn.btn-success,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-success {
  background-color: #4caf50;
}
.btn-group.open > .dropdown-toggle.btn.btn-info,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-info {
  background-color: #03a9f4;
}
.btn-group.open > .dropdown-toggle.btn.btn-warning,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-warning {
  background-color: #fbc02d;
}
.btn-group.open > .dropdown-toggle.btn.btn-danger,
.btn-group-vertical.open > .dropdown-toggle.btn.btn-danger {
  background-color: #f44336;
}
.btn-group .dropdown-menu,
.btn-group-vertical .dropdown-menu {
  border-radius: 0 0 3px 3px;
}
.btn-group.btn-group-raised,
.btn-group-vertical.btn-group-raised {
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
}
.btn-group .btn + .btn,
.btn-group .btn,
.btn-group .btn:active,
.btn-group .btn-group,
.btn-group-vertical .btn + .btn,
.btn-group-vertical .btn,
.btn-group-vertical .btn:active,
.btn-group-vertical .btn-group {
  margin: 0;
}

.close {
  font-size: inherit;
  color: #FFFFFF;
  opacity: .9;
  text-shadow: none;
}
.close:hover, .close:focus {
  opacity: 1;
  color: #FFFFFF;
}
.close i {
  font-size: 20px;
}

.checkbox label {
  cursor: pointer;
  padding-left: 0;
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .checkbox label {
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .checkbox label:hover, .form-group.is-focused .checkbox label:focus {
  color: rgba(0,0,0, .54);
}
fieldset[disabled] .form-group.is-focused .checkbox label {
  color: rgba(0,0,0, 0.26);
}
.checkbox input[type=checkbox] {
  opacity: 0;
  position: absolute;
  margin: 0;
  z-index: -1;
  width: 0;
  height: 0;
  overflow: hidden;
  left: 0;
  pointer-events: none;
}
.checkbox .checkbox-material {
  vertical-align: middle;
  position: relative;
  top: 1px;
  padding-right: 5px;
  display: inline-block;
}
.checkbox .checkbox-material:before {
  display: block;
  position: absolute;
  left: 0;
  content: "";
  background-color: rgba(0, 0, 0, 0.84);
  height: 20px;
  width: 20px;
  border-radius: 100%;
  z-index: 1;
  opacity: 0;
  margin: 0;
  top: 0;
  -webkit-transform: scale3d(2.3,2.3,1);
  -moz-transform: scale3d(2.3,2.3,1);
  -o-transform: scale3d(2.3,2.3,1);
  -ms-transform: scale3d(2.3,2.3,1);
  transform: scale3d(2.3,2.3,1);
}
.checkbox .checkbox-material .check {
  position: relative;
  display: inline-block;
  width: 20px;
  height: 20px;
  border: 1px solid rgba(0,0,0, .54);
  overflow: hidden;
  z-index: 1;
  border-radius: 3px;
}
.checkbox .checkbox-material .check:before {
  position: absolute;
  content: "";
  transform: rotate(45deg);
  display: block;
  margin-top: -3px;
  margin-left: 7px;
  width: 0;
  height: 0;
  background: red;
  box-shadow: 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0 inset;
  -webkit-animation: checkbox-off 0.3s forwards;
  -moz-animation: checkbox-off 0.3s forwards;
  -o-animation: checkbox-off 0.3s forwards;
  -ms-animation: checkbox-off 0.3s forwards;
  animation: checkbox-off 0.3s forwards;
}
.checkbox input[type=checkbox]:focus + .checkbox-material .check:after {
  opacity: 0.2;
}
.checkbox input[type=checkbox]:checked + .checkbox-material .check {
  background: #9c27b0;
}
.checkbox input[type=checkbox]:checked + .checkbox-material .check:before {
  color: #FFFFFF;
  box-shadow: 0 0 0 10px, 10px -10px 0 10px, 32px 0 0 20px, 0px 32px 0 20px, -5px 5px 0 10px, 20px -12px 0 11px;
  -webkit-animation: checkbox-on 0.3s forwards;
  -moz-animation: checkbox-on 0.3s forwards;
  -o-animation: checkbox-on 0.3s forwards;
  -ms-animation: checkbox-on 0.3s forwards;
  animation: checkbox-on 0.3s forwards;
}
.checkbox input[type=checkbox]:checked + .checkbox-material:before {
  -webkit-animation: rippleOn 500ms;
  -moz-animation: rippleOn 500ms;
  -o-animation: rippleOn 500ms;
  -ms-animation: rippleOn 500ms;
  animation: rippleOn 500ms;
}
.checkbox input[type=checkbox]:checked + .checkbox-material .check:after {
  -webkit-animation: rippleOn 500ms forwards;
  -moz-animation: rippleOn 500ms forwards;
  -o-animation: rippleOn 500ms forwards;
  -ms-animation: rippleOn 500ms forwards;
  animation: rippleOn 500ms forwards;
}
.checkbox input[type=checkbox]:not(:checked) + .checkbox-material:before {
  -webkit-animation: rippleOff 500ms;
  -moz-animation: rippleOff 500ms;
  -o-animation: rippleOff 500ms;
  -ms-animation: rippleOff 500ms;
  animation: rippleOff 500ms;
}
.checkbox input[type=checkbox]:not(:checked) + .checkbox-material .check:after {
  -webkit-animation: rippleOff 500ms;
  -moz-animation: rippleOff 500ms;
  -o-animation: rippleOff 500ms;
  -ms-animation: rippleOff 500ms;
  animation: rippleOff 500ms;
}
fieldset[disabled] .checkbox, fieldset[disabled] .checkbox input[type=checkbox],
.checkbox input[type=checkbox][disabled] ~ .checkbox-material .check,
.checkbox input[type=checkbox][disabled] + .circle {
  opacity: 0.5;
}
.checkbox input[type=checkbox][disabled] ~ .checkbox-material .check {
  border-color: #000000;
  opacity: .26;
}
.checkbox input[type=checkbox][disabled] + .checkbox-material .check:after {
  background-color: rgba(0,0,0, 0.87);
  transform: rotate(-45deg);
}

@keyframes checkbox-on {
  0% {
    box-shadow: 0 0 0 10px, 10px -10px 0 10px, 32px 0 0 20px, 0px 32px 0 20px, -5px 5px 0 10px, 15px 2px 0 11px;
  }
  50% {
    box-shadow: 0 0 0 10px, 10px -10px 0 10px, 32px 0 0 20px, 0px 32px 0 20px, -5px 5px 0 10px, 20px 2px 0 11px;
  }
  100% {
    box-shadow: 0 0 0 10px, 10px -10px 0 10px, 32px 0 0 20px, 0px 32px 0 20px, -5px 5px 0 10px, 20px -12px 0 11px;
  }
}
@keyframes rippleOn {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.2;
  }
  100% {
    opacity: 0;
  }
}
@keyframes rippleOff {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.2;
  }
  100% {
    opacity: 0;
  }
}
.togglebutton {
  vertical-align: middle;
}
.togglebutton, .togglebutton label, .togglebutton input, .togglebutton .toggle {
  user-select: none;
}
.togglebutton label {
  cursor: pointer;
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .togglebutton label {
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .togglebutton label:hover, .form-group.is-focused .togglebutton label:focus {
  color: rgba(0,0,0, .54);
}
fieldset[disabled] .form-group.is-focused .togglebutton label {
  color: rgba(0,0,0, 0.26);
}
.togglebutton label input[type=checkbox] {
  opacity: 0;
  width: 0;
  height: 0;
}
.togglebutton label .toggle {
  text-align: left;
  margin-left: 5px;
}
.togglebutton label .toggle,
.togglebutton label input[type=checkbox][disabled] + .toggle {
  content: "";
  display: inline-block;
  width: 30px;
  height: 15px;
  background-color: rgba(80, 80, 80, 0.7);
  border-radius: 15px;
  margin-right: 15px;
  transition: background 0.3s ease;
  vertical-align: middle;
}
.togglebutton label .toggle:after {
  content: "";
  display: inline-block;
  width: 20px;
  height: 20px;
  background-color: #FFFFFF;
  border-radius: 20px;
  position: relative;
  box-shadow: 0 1px 3px 1px rgba(0, 0, 0, 0.4);
  left: -5px;
  top: -3px;
  border: 1px solid rgba(0,0,0, .54);
  transition: left 0.3s ease, background 0.3s ease, box-shadow 0.1s ease;
}
.togglebutton label input[type=checkbox][disabled] + .toggle:after, .togglebutton label input[type=checkbox][disabled]:checked + .toggle:after {
  background-color: #BDBDBD;
}
.togglebutton label input[type=checkbox] + .toggle:active:after, .togglebutton label input[type=checkbox][disabled] + .toggle:active:after {
  box-shadow: 0 1px 3px 1px rgba(0, 0, 0, 0.4), 0 0 0 15px rgba(0, 0, 0, 0.1);
}
.togglebutton label input[type=checkbox]:checked + .toggle:after {
  left: 15px;
}
.togglebutton label input[type=checkbox]:checked + .toggle {
  background-color: rgba(156, 39, 176, 0.7);
}
.togglebutton label input[type=checkbox]:checked + .toggle:after {
  border-color: #9c27b0;
}
.togglebutton label input[type=checkbox]:checked + .toggle:active:after {
  box-shadow: 0 1px 3px 1px rgba(0, 0, 0, 0.4), 0 0 0 15px rgba(156, 39, 176, 0.1);
}

.radio label {
  cursor: pointer;
  padding-left: 35px;
  position: relative;
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .radio label {
  color: rgba(0,0,0, 0.26);
}
.form-group.is-focused .radio label:hover, .form-group.is-focused .radio label:focus {
  color: rgba(0,0,0, .54);
}
fieldset[disabled] .form-group.is-focused .radio label {
  color: rgba(0,0,0, 0.26);
}
.radio label span {
  display: block;
  position: absolute;
  left: 10px;
  top: 2px;
  transition-duration: 0.2s;
}
.radio label .circle {
  border: 1px solid rgba(0,0,0, .54);
  height: 15px;
  width: 15px;
  border-radius: 100%;
}
.radio label .check {
  height: 15px;
  width: 15px;
  border-radius: 100%;
  background-color: #9c27b0;
  -webkit-transform: scale3d(0,0,0);
  -moz-transform: scale3d(0,0,0);
  -o-transform: scale3d(0,0,0);
  -ms-transform: scale3d(0,0,0);
  transform: scale3d(0,0,0);
}
.radio label .check:after {
  display: block;
  position: absolute;
  content: "";
  background-color: rgba(0,0,0, 0.87);
  left: -18px;
  top: -18px;
  height: 50px;
  width: 50px;
  border-radius: 100%;
  z-index: 1;
  opacity: 0;
  margin: 0;
  -webkit-transform: scale3d(1.5,1.5,1);
  -moz-transform: scale3d(1.5,1.5,1);
  -o-transform: scale3d(1.5,1.5,1);
  -ms-transform: scale3d(1.5,1.5,1);
  transform: scale3d(1.5,1.5,1);
}
.radio label input[type=radio]:not(:checked) ~ .check:after {
  -webkit-animation: rippleOff 500ms;
  -moz-animation: rippleOff 500ms;
  -o-animation: rippleOff 500ms;
  -ms-animation: rippleOff 500ms;
  animation: rippleOff 500ms;
}
.radio label input[type=radio]:checked ~ .check:after {
  -webkit-animation: rippleOff 500ms;
  -moz-animation: rippleOff 500ms;
  -o-animation: rippleOff 500ms;
  -ms-animation: rippleOff 500ms;
  animation: rippleOff 500ms;
}
.radio input[type=radio] {
  opacity: 0;
  height: 0;
  width: 0;
  overflow: hidden;
}
.radio input[type=radio]:checked ~ .check, .radio input[type=radio]:checked ~ .circle {
  opacity: 1;
}
.radio input[type=radio]:checked ~ .check {
  background-color: #9c27b0;
}
.radio input[type=radio]:checked ~ .circle {
  border-color: #9c27b0;
}
.radio input[type=radio]:checked ~ .check {
  -webkit-transform: scale3d(0.65, 0.65, 1);
  -moz-transform: scale3d(0.65, 0.65, 1);
  -o-transform: scale3d(0.65, 0.65, 1);
  -ms-transform: scale3d(0.65, 0.65, 1);
  transform: scale3d(0.65, 0.65, 1);
}
.radio input[type=radio][disabled] ~ .check, .radio input[type=radio][disabled] ~ .circle {
  opacity: 0.26;
}
.radio input[type=radio][disabled] ~ .check {
  background-color: #000000;
}
.radio input[type=radio][disabled] ~ .circle {
  border-color: #000000;
}

@keyframes rippleOn {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.2;
  }
  100% {
    opacity: 0;
  }
}
@keyframes rippleOff {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.2;
  }
  100% {
    opacity: 0;
  }
}
legend {
  margin-bottom: 20px;
  font-size: 21px;
}

output {
  padding-top: 8px;
  font-size: 14px;
  line-height: 1.42857;
}

.form-control {
  height: 36px;
  padding: 7px 0;
  font-size: 14px;
  line-height: 1.42857;
}

@media screen and (-webkit-min-device-pixel-ratio: 0) {
  input[type="date"].form-control,
  input[type="time"].form-control,
  input[type="datetime-local"].form-control,
  input[type="month"].form-control {
    line-height: 36px;
  }
  input[type="date"].input-sm, .input-group-sm input[type="date"],
  input[type="time"].input-sm, .input-group-sm
  input[type="time"],
  input[type="datetime-local"].input-sm, .input-group-sm
  input[type="datetime-local"],
  input[type="month"].input-sm, .input-group-sm
  input[type="month"] {
    line-height: 24px;
  }
  input[type="date"].input-lg, .input-group-lg input[type="date"],
  input[type="time"].input-lg, .input-group-lg
  input[type="time"],
  input[type="datetime-local"].input-lg, .input-group-lg
  input[type="datetime-local"],
  input[type="month"].input-lg, .input-group-lg
  input[type="month"] {
    line-height: 44px;
  }
}
.radio label,
.checkbox label {
  min-height: 20px;
}

.form-control-static {
  padding-top: 8px;
  padding-bottom: 8px;
  min-height: 34px;
}

.input-sm .input-sm {
  height: 24px;
  padding: 3px 0;
  font-size: 11px;
  line-height: 1.5;
  border-radius: 0;
}
.input-sm select.input-sm {
  height: 24px;
  line-height: 24px;
}
.input-sm textarea.input-sm,
.input-sm select[multiple].input-sm {
  height: auto;
}

.form-group-sm .form-control {
  height: 24px;
  padding: 3px 0;
  font-size: 11px;
  line-height: 1.5;
}
.form-group-sm select.form-control {
  height: 24px;
  line-height: 24px;
}
.form-group-sm textarea.form-control,
.form-group-sm select[multiple].form-control {
  height: auto;
}
.form-group-sm .form-control-static {
  height: 24px;
  min-height: 31px;
  padding: 4px 0;
  font-size: 11px;
  line-height: 1.5;
}

.input-lg .input-lg {
  height: 44px;
  padding: 9px 0;
  font-size: 18px;
  line-height: 1.33333;
  border-radius: 0;
}
.input-lg select.input-lg {
  height: 44px;
  line-height: 44px;
}
.input-lg textarea.input-lg,
.input-lg select[multiple].input-lg {
  height: auto;
}

.form-group-lg .form-control {
  height: 44px;
  padding: 9px 0;
  font-size: 18px;
  line-height: 1.33333;
}
.form-group-lg select.form-control {
  height: 44px;
  line-height: 44px;
}
.form-group-lg textarea.form-control,
.form-group-lg select[multiple].form-control {
  height: auto;
}
.form-group-lg .form-control-static {
  height: 44px;
  min-height: 38px;
  padding: 10px 0;
  font-size: 18px;
  line-height: 1.33333;
}

.form-horizontal .radio,
.form-horizontal .checkbox,
.form-horizontal .radio-inline,
.form-horizontal .checkbox-inline {
  padding-top: 8px;
}
.form-horizontal .radio,
.form-horizontal .checkbox {
  min-height: 28px;
}
@media (min-width: 768px) {
  .form-horizontal .control-label {
    padding-top: 8px;
  }
}
@media (min-width: 768px) {
  .form-horizontal .form-group-lg .control-label {
    padding-top: 13.0px;
    font-size: 18px;
  }
}
@media (min-width: 768px) {
  .form-horizontal .form-group-sm .control-label {
    padding-top: 4px;
    font-size: 11px;
  }
}

.label {
  border-radius: 2px;
}
.label, .label.label-default {
  background-color: #9e9e9e;
}
.label.label-inverse {
  background-color: #3f51b5;
}
.label.label-primary {
  background-color: #9c27b0;
}
.label.label-success {
  background-color: #4caf50;
}
.label.label-info {
  background-color: #03a9f4;
}
.label.label-warning {
  background-color: #fbc02d;
}
.label.label-danger {
  background-color: #f44336;
}

.form-control,
.form-group .form-control {
  border: 0;
  background-image: linear-gradient(#9c27b0, #9c27b0), linear-gradient(#D2D2D2, #D2D2D2);
  background-size: 0 2px, 100% 1px;
  background-repeat: no-repeat;
  background-position: center bottom, center calc(100% - 1px);
  background-color: transparent;
  transition: background 0s ease-out;
  float: none;
  box-shadow: none;
  border-radius: 0;
  font-weight: 400;
}
.form-control::-moz-placeholder,
.form-group .form-control::-moz-placeholder {
  color: #AAAAAA;
  font-weight: 400;
}
.form-control:-ms-input-placeholder,
.form-group .form-control:-ms-input-placeholder {
  color: #AAAAAA;
  font-weight: 400;
}
.form-control::-webkit-input-placeholder,
.form-group .form-control::-webkit-input-placeholder {
  color: #AAAAAA;
  font-weight: 400;
}
.form-control[readonly], .form-control[disabled], fieldset[disabled] .form-control,
.form-group .form-control[readonly],
.form-group .form-control[disabled], fieldset[disabled]
.form-group .form-control {
  background-color: transparent;
}
.form-control[disabled], fieldset[disabled] .form-control,
.form-group .form-control[disabled], fieldset[disabled]
.form-group .form-control {
  background-image: none;
  border-bottom: 1px dotted #D2D2D2;
}

.form-group {
  position: relative;
}
.form-group.label-static label.control-label, .form-group.label-placeholder label.control-label, .form-group.label-floating label.control-label {
  position: absolute;
  pointer-events: none;
  transition: 0.3s ease all;
}
.form-group.label-floating label.control-label {
  will-change: left, top, contents;
}
.form-group.label-placeholder:not(.is-empty) label.control-label {
  display: none;
}
.form-group .help-block {
  position: absolute;
  display: none;
}
.form-group.is-focused .form-control {
  outline: none;
  background-image: linear-gradient(#9c27b0, #9c27b0), linear-gradient(#D2D2D2, #D2D2D2);
  background-size: 100% 2px, 100% 1px;
  box-shadow: none;
  transition-duration: 0.3s;
}
.form-group.is-focused .form-control .material-input:after {
  background-color: #9c27b0;
}
.form-group.is-focused label,
.form-group.is-focused label.control-label {
  color: #9c27b0;
}
.form-group.is-focused.label-placeholder label,
.form-group.is-focused.label-placeholder label.control-label {
  color: #AAAAAA;
}
.form-group.is-focused .help-block {
  display: block;
}
.form-group.has-warning .form-control {
  box-shadow: none;
}
.form-group.has-warning.is-focused .form-control {
  background-image: linear-gradient(#fbc02d, #fbc02d), linear-gradient(#D2D2D2, #D2D2D2);
}
.form-group.has-warning label.control-label,
.form-group.has-warning .help-block {
  color: #fbc02d;
}
.form-group.has-error .form-control {
  box-shadow: none;
}
.form-group.has-error.is-focused .form-control {
  background-image: linear-gradient(#f44336, #f44336), linear-gradient(#D2D2D2, #D2D2D2);
}
.form-group.has-error label.control-label,
.form-group.has-error .help-block {
  color: #f44336;
}
.form-group.has-success .form-control {
  box-shadow: none;
}
.form-group.has-success.is-focused .form-control {
  background-image: linear-gradient(#4caf50, #4caf50), linear-gradient(#D2D2D2, #D2D2D2);
}
.form-group.has-success label.control-label,
.form-group.has-success .help-block {
  color: #4caf50;
}
.form-group.has-info .form-control {
  box-shadow: none;
}
.form-group.has-info.is-focused .form-control {
  background-image: linear-gradient(#03a9f4, #03a9f4), linear-gradient(#D2D2D2, #D2D2D2);
}
.form-group.has-info label.control-label,
.form-group.has-info .help-block {
  color: #03a9f4;
}
.form-group textarea {
  resize: none;
}
.form-group textarea ~ .form-control-highlight {
  margin-top: -11px;
}
.form-group select {
  appearance: none;
}
.form-group select ~ .material-input:after {
  display: none;
}

.form-control {
  margin-bottom: 7px;
}
.form-control::-moz-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-control:-ms-input-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-control::-webkit-input-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}

.checkbox label,
.radio label,
label {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}

label.control-label {
  font-size: 11px;
  line-height: 1.07143;
  color: #AAAAAA;
  font-weight: 400;
  margin: 16px 0 0 0;
}

.help-block {
  margin-top: 0;
  font-size: 11px;
}

.form-group {
  padding-bottom: 7px;
  margin: 27px 0 0 0;
}
.form-group .form-control {
  margin-bottom: 7px;
}
.form-group .form-control::-moz-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group .form-control:-ms-input-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group .form-control::-webkit-input-placeholder {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group .checkbox label,
.form-group .radio label,
.form-group label {
  font-size: 14px;
  line-height: 1.42857;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group label.control-label {
  font-size: 11px;
  line-height: 1.07143;
  color: #AAAAAA;
  font-weight: 400;
  margin: 16px 0 0 0;
}
.form-group .help-block {
  margin-top: 0;
  font-size: 11px;
}
.form-group.label-floating label.control-label, .form-group.label-placeholder label.control-label {
  top: -7px;
  font-size: 14px;
  line-height: 1.42857;
}
.form-group.label-static label.control-label, .form-group.label-floating.is-focused label.control-label, .form-group.label-floating:not(.is-empty) label.control-label {
  top: -28px;
  left: 0;
  font-size: 11px;
  line-height: 1.07143;
}
.form-group.label-floating input.form-control:-webkit-autofill ~ label.control-label label.control-label {
  top: -28px;
  left: 0;
  font-size: 11px;
  line-height: 1.07143;
}

.form-group.form-group-sm {
  padding-bottom: 3px;
  margin: 21px 0 0 0;
}
.form-group.form-group-sm .form-control {
  margin-bottom: 3px;
}
.form-group.form-group-sm .form-control::-moz-placeholder {
  font-size: 11px;
  line-height: 1.5;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-sm .form-control:-ms-input-placeholder {
  font-size: 11px;
  line-height: 1.5;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-sm .form-control::-webkit-input-placeholder {
  font-size: 11px;
  line-height: 1.5;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-sm .checkbox label,
.form-group.form-group-sm .radio label,
.form-group.form-group-sm label {
  font-size: 11px;
  line-height: 1.5;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-sm label.control-label {
  font-size: 9px;
  line-height: 1.125;
  color: #AAAAAA;
  font-weight: 400;
  margin: 16px 0 0 0;
}
.form-group.form-group-sm .help-block {
  margin-top: 0;
  font-size: 9px;
}
.form-group.form-group-sm.label-floating label.control-label, .form-group.form-group-sm.label-placeholder label.control-label {
  top: -11px;
  font-size: 11px;
  line-height: 1.5;
}
.form-group.form-group-sm.label-static label.control-label, .form-group.form-group-sm.label-floating.is-focused label.control-label, .form-group.form-group-sm.label-floating:not(.is-empty) label.control-label {
  top: -25px;
  left: 0;
  font-size: 9px;
  line-height: 1.125;
}
.form-group.form-group-sm.label-floating input.form-control:-webkit-autofill ~ label.control-label label.control-label {
  top: -25px;
  left: 0;
  font-size: 9px;
  line-height: 1.125;
}

.form-group.form-group-lg {
  padding-bottom: 9px;
  margin: 30px 0 0 0;
}
.form-group.form-group-lg .form-control {
  margin-bottom: 9px;
}
.form-group.form-group-lg .form-control::-moz-placeholder {
  font-size: 18px;
  line-height: 1.33333;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-lg .form-control:-ms-input-placeholder {
  font-size: 18px;
  line-height: 1.33333;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-lg .form-control::-webkit-input-placeholder {
  font-size: 18px;
  line-height: 1.33333;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-lg .checkbox label,
.form-group.form-group-lg .radio label,
.form-group.form-group-lg label {
  font-size: 18px;
  line-height: 1.33333;
  color: #AAAAAA;
  font-weight: 400;
}
.form-group.form-group-lg label.control-label {
  font-size: 14px;
  line-height: 1.0;
  color: #AAAAAA;
  font-weight: 400;
  margin: 16px 0 0 0;
}
.form-group.form-group-lg .help-block {
  margin-top: 0;
  font-size: 14px;
}
.form-group.form-group-lg.label-floating label.control-label, .form-group.form-group-lg.label-placeholder label.control-label {
  top: -5px;
  font-size: 18px;
  line-height: 1.33333;
}
.form-group.form-group-lg.label-static label.control-label, .form-group.form-group-lg.label-floating.is-focused label.control-label, .form-group.form-group-lg.label-floating:not(.is-empty) label.control-label {
  top: -32px;
  left: 0;
  font-size: 14px;
  line-height: 1.0;
}
.form-group.form-group-lg.label-floating input.form-control:-webkit-autofill ~ label.control-label label.control-label {
  top: -32px;
  left: 0;
  font-size: 14px;
  line-height: 1.0;
}

select.form-control {
  border: 0;
  box-shadow: none;
  border-radius: 0;
}
.form-group.is-focused select.form-control {
  box-shadow: none;
  border-color: #D2D2D2;
}
select.form-control[multiple], .form-group.is-focused select.form-control[multiple] {
  height: 85px;
}

.input-group-btn .btn {
  margin: 0 0 7px 0;
}

.form-group.form-group-sm .input-group-btn .btn {
  margin: 0 0 3px 0;
}
.form-group.form-group-lg .input-group-btn .btn {
  margin: 0 0 9px 0;
}

.input-group .input-group-btn {
  padding: 0 12px;
}
.input-group .input-group-addon {
  border: 0;
  background: transparent;
  padding: 12px 15px 0px;
}

.form-group input[type=file] {
  opacity: 0;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 100;
}

.form-control-feedback {
  opacity: 0;
}
.has-success .form-control-feedback {
  color: #4caf50;
  opacity: 1;
}
.has-error .form-control-feedback {
  color: #f44336;
  opacity: 1;
}

.pagination > li > a,
.pagination > li > span {
  border: 0;
  border-radius: 30px !important;
  transition: all .3s;
  padding: 0px 11px;
  margin: 0 3px;
  min-width: 30px;
  height: 30px;
  line-height: 30px;
  color: #999999;
  font-weight: 400;
  font-size: 12px;
  text-transform: uppercase;
  background: transparent;
}
.pagination > li > a:hover, .pagination > li > a:focus,
.pagination > li > span:hover,
.pagination > li > span:focus {
  color: #999999;
}
.pagination > .active > a,
.pagination > .active > span {
  color: #999999;
}
.pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover,
.pagination > .active > span,
.pagination > .active > span:focus,
.pagination > .active > span:hover {
  background-color: #9c27b0;
  border-color: #9c27b0;
  color: #FFFFFF;
  box-shadow: 0 4px 5px 0 rgba(156, 39, 176, 0.14), 0 1px 10px 0 rgba(156, 39, 176, 0.12), 0 2px 4px -1px rgba(156, 39, 176, 0.2);
}
.pagination.pagination-info > .active > a, .pagination.pagination-info > .active > a:focus, .pagination.pagination-info > .active > a:hover,
.pagination.pagination-info > .active > span,
.pagination.pagination-info > .active > span:focus,
.pagination.pagination-info > .active > span:hover {
  background-color: #03a9f4;
  border-color: #03a9f4;
  box-shadow: 0 4px 5px 0 rgba(3, 169, 244, 0.14), 0 1px 10px 0 rgba(3, 169, 244, 0.12), 0 2px 4px -1px rgba(3, 169, 244, 0.2);
}
.pagination.pagination-success > .active > a, .pagination.pagination-success > .active > a:focus, .pagination.pagination-success > .active > a:hover,
.pagination.pagination-success > .active > span,
.pagination.pagination-success > .active > span:focus,
.pagination.pagination-success > .active > span:hover {
  background-color: #4caf50;
  border-color: #4caf50;
  box-shadow: 0 4px 5px 0 rgba(76, 175, 80, 0.14), 0 1px 10px 0 rgba(76, 175, 80, 0.12), 0 2px 4px -1px rgba(76, 175, 80, 0.2);
}
.pagination.pagination-warning > .active > a, .pagination.pagination-warning > .active > a:focus, .pagination.pagination-warning > .active > a:hover,
.pagination.pagination-warning > .active > span,
.pagination.pagination-warning > .active > span:focus,
.pagination.pagination-warning > .active > span:hover {
  background-color: #fbc02d;
  border-color: #fbc02d;
  box-shadow: 0 4px 5px 0 rgba(251, 192, 45, 0.14), 0 1px 10px 0 rgba(251, 192, 45, 0.12), 0 2px 4px -1px rgba(251, 192, 45, 0.2);
}
.pagination.pagination-danger > .active > a, .pagination.pagination-danger > .active > a:focus, .pagination.pagination-danger > .active > a:hover,
.pagination.pagination-danger > .active > span,
.pagination.pagination-danger > .active > span:focus,
.pagination.pagination-danger > .active > span:hover {
  background-color: #f44336;
  border-color: #f44336;
  box-shadow: 0 4px 5px 0 rgba(244, 67, 54, 0.14), 0 1px 10px 0 rgba(244, 67, 54, 0.12), 0 2px 4px -1px rgba(244, 67, 54, 0.2);
}

.label {
  border-radius: 10px;
  padding: 5px 12px;
  text-transform: uppercase;
  font-size: 10px;
}
.label.label-default {
  background-color: #999999;
}

.nav-pills > li > a {
  line-height: 24px;
  text-transform: uppercase;
  font-size: 12px;
  font-weight: 500;
  min-width: 100px;
  text-align: center;
  color: #555555;
  transition: all .3s;
}
.nav-pills > li > a:hover {
  background-color: rgba(200, 200, 200, 0.2);
}
.nav-pills > li i {
  display: block;
  font-size: 30px;
  padding: 15px 0;
}
.nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {
  background-color: #9c27b0;
  color: #FFFFFF;
  box-shadow: 0 16px 26px -10px rgba(156, 39, 176, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(156, 39, 176, 0.2);
}
.nav-pills.nav-pills-info > li.active > a, .nav-pills.nav-pills-info > li.active > a:focus, .nav-pills.nav-pills-info > li.active > a:hover {
  background-color: #03a9f4;
  box-shadow: 0 16px 26px -10px rgba(3, 169, 244, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(3, 169, 244, 0.2);
}
.nav-pills.nav-pills-success > li.active > a, .nav-pills.nav-pills-success > li.active > a:focus, .nav-pills.nav-pills-success > li.active > a:hover {
  background-color: #4caf50;
  box-shadow: 0 16px 26px -10px rgba(76, 175, 80, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(76, 175, 80, 0.2);
}
.nav-pills.nav-pills-warning > li.active > a, .nav-pills.nav-pills-warning > li.active > a:focus, .nav-pills.nav-pills-warning > li.active > a:hover {
  background-color: #fbc02d;
  box-shadow: 0 16px 26px -10px rgba(251, 192, 45, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(251, 192, 45, 0.2);
}
.nav-pills.nav-pills-danger > li.active > a, .nav-pills.nav-pills-danger > li.active > a:focus, .nav-pills.nav-pills-danger > li.active > a:hover {
  background-color: #f44336;
  box-shadow: 0 16px 26px -10px rgba(244, 67, 54, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(244, 67, 54, 0.2);
}

.tab-space {
  padding: 20px 0 50px 0px;
}

footer {
  padding: 15px 0;
}
footer ul {
  margin-bottom: 0;
  padding: 0;
  list-style: none;
}
footer ul li {
  display: inline-block;
}
footer ul li a {
  color: inherit;
  padding: 15px;
  font-weight: 500;
  font-size: 12px;
  text-transform: uppercase;
  border-radius: 3px;
  text-decoration: none;
  position: relative;
  display: block;
}
footer ul li a:hover {
  text-decoration: none;
}
footer .copyright {
  padding: 15px 0;
}
footer .copyright .material-icons {
  font-size: 18px;
  position: relative;
  top: 3px;
}

legend {
  border-bottom: 0;
}

.navbar {
  border: 0;
  border-radius: 3px;
  box-shadow: 0 10px 20px -12px rgba(0, 0, 0, 0.42), 0 3px 20px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
  padding: 10px 0;
}
.navbar .navbar-brand {
  position: relative;
  height: 50px;
  line-height: 30px;
  color: inherit;
  padding: 10px 15px;
}
.navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
  color: inherit;
  background-color: transparent;
}
.navbar .navbar-text {
  color: inherit;
  margin-top: 15px;
  margin-bottom: 15px;
}
.navbar .navbar-nav > li > a {
  color: inherit;
  padding-top: 15px;
  padding-bottom: 15px;
  font-weight: 400;
  font-size: 12px;
  text-transform: uppercase;
  border-radius: 3px;
}
.navbar .navbar-nav > li > a:hover, .navbar .navbar-nav > li > a:focus {
  color: inherit;
  background-color: transparent;
}
.navbar .navbar-nav > li > a .material-icons,
.navbar .navbar-nav > li > a .fa {
  font-size: 20px;
  max-width: 20px;
}
.navbar .navbar-nav > li > a:not(.btn-just-icon) .fa {
  position: relative;
  top: 2px;
  margin-top: -4px;
  margin-right: 4px;
}
.navbar .navbar-nav > li > .dropdown-menu {
  margin-top: -20px;
}
.navbar .navbar-nav > li.open > .dropdown-menu {
  margin-top: 0;
}
.navbar .navbar-nav > .active > a, .navbar .navbar-nav > .active > a:hover, .navbar .navbar-nav > .active > a:focus {
  color: inherit;
  background-color: rgba(255, 255, 255, 0.1);
}
.navbar .navbar-nav > .disabled > a, .navbar .navbar-nav > .disabled > a:hover, .navbar .navbar-nav > .disabled > a:focus {
  color: inherit;
  background-color: transparent;
  opacity: 0.9;
}
.navbar .navbar-toggle {
  border: 0;
}
.navbar .navbar-toggle:hover, .navbar .navbar-toggle:focus {
  background-color: transparent;
}
.navbar .navbar-toggle .icon-bar {
  background-color: inherit;
  border: 1px solid;
}
.navbar .navbar-default .navbar-toggle,
.navbar .navbar-inverse .navbar-toggle {
  border-color: transparent;
}
.navbar .navbar-collapse,
.navbar .navbar-form {
  border-top: none;
  box-shadow: none;
}
.navbar .navbar-nav > .open > a, .navbar .navbar-nav > .open > a:hover, .navbar .navbar-nav > .open > a:focus {
  background-color: transparent;
  color: inherit;
}
@media (max-width: 767px) {
  .navbar .navbar-nav .navbar-text {
    color: inherit;
    margin-top: 15px;
    margin-bottom: 15px;
  }
  .navbar .navbar-nav .open .dropdown-menu > .dropdown-header {
    border: 0;
    color: inherit;
  }
  .navbar .navbar-nav .open .dropdown-menu .divider {
    border-bottom: 1px solid;
    opacity: 0.08;
  }
  .navbar .navbar-nav .open .dropdown-menu > li > a {
    color: inherit;
  }
  .navbar .navbar-nav .open .dropdown-menu > li > a:hover, .navbar .navbar-nav .open .dropdown-menu > li > a:focus {
    color: inherit;
    background-color: transparent;
  }
  .navbar .navbar-nav .open .dropdown-menu > .active > a, .navbar .navbar-nav .open .dropdown-menu > .active > a:hover, .navbar .navbar-nav .open .dropdown-menu > .active > a:focus {
    color: inherit;
    background-color: transparent;
  }
  .navbar .navbar-nav .open .dropdown-menu > .disabled > a, .navbar .navbar-nav .open .dropdown-menu > .disabled > a:hover, .navbar .navbar-nav .open .dropdown-menu > .disabled > a:focus {
    color: inherit;
    background-color: transparent;
  }
}
.navbar.navbar-default .logo-container .brand {
  color: #555555;
}
.navbar .navbar-link {
  color: inherit;
}
.navbar .navbar-link:hover {
  color: inherit;
}
.navbar .btn {
  margin-top: 0;
  margin-bottom: 0;
}
.navbar .btn-link {
  color: inherit;
}
.navbar .btn-link:hover, .navbar .btn-link:focus {
  color: inherit;
}
.navbar .btn-link[disabled]:hover, .navbar .btn-link[disabled]:focus, fieldset[disabled] .navbar .btn-link:hover, fieldset[disabled] .navbar .btn-link:focus {
  color: inherit;
}
.navbar .navbar-form {
  margin: 4px 0 0;
}
.navbar .navbar-form .form-group {
  margin: 0;
  padding: 0;
}
.navbar .navbar-form .form-group .material-input:before, .navbar .navbar-form .form-group.is-focused .material-input:after {
  background-color: inherit;
}
.navbar .navbar-form .form-group .form-control,
.navbar .navbar-form .form-control {
  border-color: inherit;
  color: inherit;
  padding: 0;
  margin: 0;
  height: 28px;
  font-size: 14px;
  line-height: 1.42857;
}
.navbar, .navbar.navbar-default {
  background-color: #9c27b0;
  color: #ffffff;
}
.navbar .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar .navbar-form input.form-control::-moz-placeholder, .navbar.navbar-default .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-default .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar .navbar-form input.form-control:-ms-input-placeholder, .navbar.navbar-default .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-default .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar .navbar-form input.form-control::-webkit-input-placeholder, .navbar.navbar-default .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-default .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar .dropdown-menu, .navbar.navbar-default .dropdown-menu {
  border-radius: 3px !important;
}
.navbar .dropdown-menu li > a:hover, .navbar .dropdown-menu li > a:focus, .navbar.navbar-default .dropdown-menu li > a:hover, .navbar.navbar-default .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #9c27b0;
}
.navbar .dropdown-menu .active > a, .navbar.navbar-default .dropdown-menu .active > a {
  background-color: #9c27b0;
  color: #ffffff;
}
.navbar .dropdown-menu .active > a:hover, .navbar .dropdown-menu .active > a:focus, .navbar.navbar-default .dropdown-menu .active > a:hover, .navbar.navbar-default .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar.navbar-inverse {
  background-color: #3f51b5;
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-inverse .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-inverse .navbar-form input.form-control::-moz-placeholder {
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-inverse .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-inverse .navbar-form input.form-control:-ms-input-placeholder {
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-inverse .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-inverse .navbar-form input.form-control::-webkit-input-placeholder {
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-inverse .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-inverse .dropdown-menu li > a:hover, .navbar.navbar-inverse .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #3f51b5;
}
.navbar.navbar-inverse .dropdown-menu .active > a {
  background-color: #3f51b5;
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-inverse .dropdown-menu .active > a:hover, .navbar.navbar-inverse .dropdown-menu .active > a:focus {
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.navbar.navbar-primary {
  background-color: #9c27b0;
  color: #ffffff;
}
.navbar.navbar-primary .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-primary .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar.navbar-primary .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-primary .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-primary .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-primary .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-primary .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-primary .dropdown-menu li > a:hover, .navbar.navbar-primary .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #9c27b0;
}
.navbar.navbar-primary .dropdown-menu .active > a {
  background-color: #9c27b0;
  color: #ffffff;
}
.navbar.navbar-primary .dropdown-menu .active > a:hover, .navbar.navbar-primary .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar.navbar-success {
  background-color: #4caf50;
  color: #ffffff;
}
.navbar.navbar-success .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-success .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar.navbar-success .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-success .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-success .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-success .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-success .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-success .dropdown-menu li > a:hover, .navbar.navbar-success .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #4caf50;
}
.navbar.navbar-success .dropdown-menu .active > a {
  background-color: #4caf50;
  color: #ffffff;
}
.navbar.navbar-success .dropdown-menu .active > a:hover, .navbar.navbar-success .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar.navbar-info {
  background-color: #03a9f4;
  color: #ffffff;
}
.navbar.navbar-info .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-info .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar.navbar-info .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-info .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-info .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-info .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-info .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-info .dropdown-menu li > a:hover, .navbar.navbar-info .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #03a9f4;
}
.navbar.navbar-info .dropdown-menu .active > a {
  background-color: #03a9f4;
  color: #ffffff;
}
.navbar.navbar-info .dropdown-menu .active > a:hover, .navbar.navbar-info .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar.navbar-warning {
  background-color: #fbc02d;
  color: #ffffff;
}
.navbar.navbar-warning .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-warning .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar.navbar-warning .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-warning .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-warning .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-warning .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-warning .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-warning .dropdown-menu li > a:hover, .navbar.navbar-warning .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #fbc02d;
}
.navbar.navbar-warning .dropdown-menu .active > a {
  background-color: #fbc02d;
  color: #ffffff;
}
.navbar.navbar-warning .dropdown-menu .active > a:hover, .navbar.navbar-warning .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar.navbar-danger {
  background-color: #f44336;
  color: #ffffff;
}
.navbar.navbar-danger .navbar-form .form-group input.form-control::-moz-placeholder,
.navbar.navbar-danger .navbar-form input.form-control::-moz-placeholder {
  color: #ffffff;
}
.navbar.navbar-danger .navbar-form .form-group input.form-control:-ms-input-placeholder,
.navbar.navbar-danger .navbar-form input.form-control:-ms-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-danger .navbar-form .form-group input.form-control::-webkit-input-placeholder,
.navbar.navbar-danger .navbar-form input.form-control::-webkit-input-placeholder {
  color: #ffffff;
}
.navbar.navbar-danger .dropdown-menu {
  border-radius: 3px !important;
}
.navbar.navbar-danger .dropdown-menu li > a:hover, .navbar.navbar-danger .dropdown-menu li > a:focus {
  color: #FFFFFF;
  background-color: #f44336;
}
.navbar.navbar-danger .dropdown-menu .active > a {
  background-color: #f44336;
  color: #ffffff;
}
.navbar.navbar-danger .dropdown-menu .active > a:hover, .navbar.navbar-danger .dropdown-menu .active > a:focus {
  color: #ffffff;
}
.navbar-inverse {
  background-color: #3f51b5;
}
.navbar.navbar-transparent {
  background-color: transparent;
  box-shadow: none;
  color: #fff;
  padding-top: 25px;
}
.navbar.navbar-transparent .logo-container .brand {
  color: #FFFFFF;
}
.navbar-fixed-top {
  border-radius: 0;
}
@media (max-width: 1199px) {
  .navbar {
    /*
        .navbar-form {
          margin-top: 10px;
        }
    */
  }
  .navbar .navbar-brand {
    height: 50px;
    padding: 10px 15px;
  }
  .navbar .navbar-nav > li > a {
    padding-top: 15px;
    padding-bottom: 15px;
  }
}
.navbar .alert {
  border-radius: 0;
  left: 0;
  position: absolute;
  right: 0;
  top: 85px;
  width: 100%;
  z-index: 3;
  transition: all 0.3s;
}

.dropdown-menu {
  border: 0;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26);
}
.dropdown-menu .divider {
  background-color: rgba(0, 0, 0, 0.12);
}
.dropdown-menu li > a {
  font-size: 13px;
  padding: 10px 20px;
  margin: 0 5px;
  border-radius: 2px;
  -webkit-transition: all 150ms linear;
  -moz-transition: all 150ms linear;
  -o-transition: all 150ms linear;
  -ms-transition: all 150ms linear;
  transition: all 150ms linear;
}
.dropdown-menu li > a:hover, .dropdown-menu li > a:focus {
  box-shadow: 0 8px 10px 1px rgba(0, 0, 0, 0.14), 0 3px 14px 2px rgba(0, 0, 0, 0.12), 0 5px 5px -3px rgba(0, 0, 0, 0.2);
}
.dropdown-menu li {
  position: relative;
}
.dropdown-menu li a:hover,
.dropdown-menu li a:focus,
.dropdown-menu li a:active {
  background-color: #9c27b0;
  color: #FFFFFF;
}
.dropdown-menu .divider {
  margin: 5px 0;
}

@media (min-width: 992px) {
  .dropdown .dropdown-menu {
    -webkit-transition: all 150ms linear;
    -moz-transition: all 150ms linear;
    -o-transition: all 150ms linear;
    -ms-transition: all 150ms linear;
    transition: all 150ms linear;
    margin-top: -20px;
    opacity: 0;
    visibility: hidden;
    display: block;
  }
  .dropdown.open .dropdown-menu {
    opacity: 1;
    visibility: visible;
    margin-top: 1px;
  }
}
.info {
  max-width: 360px;
  margin: 0 auto;
  padding: 70px 0 30px;
}
.info .icon {
  color: #999999;
}
.info .icon > i {
  font-size: 4.4em;
}
.info .info-title {
  color: #3C4858;
  margin: 30px 0 15px;
}
.info p {
  color: #999999;
}

.icon.icon-primary {
  color: #9c27b0;
}
.icon.icon-info {
  color: #03a9f4;
}
.icon.icon-success {
  color: #4caf50;
}
.icon.icon-warning {
  color: #fbc02d;
}
.icon.icon-danger {
  color: #f44336;
}

.alert {
  border: 0;
  border-radius: 0;
  padding: 20px 15px;
  line-height: 20px;
}
.alert b {
  font-weight: 500;
  text-transform: uppercase;
  font-size: 12px;
}
.alert, .alert.alert-default {
  background-color: white;
  color: #ffffff;
}
.alert a, .alert .alert-link, .alert.alert-default a, .alert.alert-default .alert-link {
  color: #ffffff;
}
.alert.alert-inverse {
  background-color: #4558be;
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.alert.alert-inverse a, .alert.alert-inverse .alert-link {
  color: contrast-color(#3f51b5, #000000, #ffffff);
}
.alert.alert-primary {
  background-color: #a72abd;
  color: #ffffff;
}
.alert.alert-primary a, .alert.alert-primary .alert-link {
  color: #ffffff;
}
.alert.alert-success {
  background-color: #55b559;
  color: #ffffff;
}
.alert.alert-success a, .alert.alert-success .alert-link {
  color: #ffffff;
}
.alert.alert-info {
  background-color: #0ab1fc;
  color: #ffffff;
}
.alert.alert-info a, .alert.alert-info .alert-link {
  color: #ffffff;
}
.alert.alert-warning {
  background-color: #fbc53c;
  color: #ffffff;
}
.alert.alert-warning a, .alert.alert-warning .alert-link {
  color: #ffffff;
}
.alert.alert-danger {
  background-color: #f55145;
  color: #ffffff;
}
.alert.alert-danger a, .alert.alert-danger .alert-link {
  color: #ffffff;
}
.alert-info, .alert-danger, .alert-warning, .alert-success {
  color: #ffffff;
}
.alert-default a, .alert-default .alert-link {
  color: rgba(0,0,0, 0.87);
}
.alert .alert-icon {
  display: block;
  float: left;
  margin-right: 15px;
}
.alert .alert-icon i {
  margin-top: -7px;
  top: 5px;
  position: relative;
}

.progress {
  height: 4px;
  border-radius: 0;
  box-shadow: none;
  background: #DDDDDD;
}
.progress .progress-bar {
  box-shadow: none;
}
.progress .progress-bar, .progress .progress-bar.progress-bar-default {
  background-color: #9c27b0;
}
.progress .progress-bar.progress-bar-inverse {
  background-color: #3f51b5;
}
.progress .progress-bar.progress-bar-primary {
  background-color: #9c27b0;
}
.progress .progress-bar.progress-bar-success {
  background-color: #4caf50;
}
.progress .progress-bar.progress-bar-info {
  background-color: #03a9f4;
}
.progress .progress-bar.progress-bar-warning {
  background-color: #fbc02d;
}
.progress .progress-bar.progress-bar-danger {
  background-color: #f44336;
}
.progress.progress-line-primary {
  background: rgba(156, 39, 176, 0.2);
}
.progress.progress-line-info {
  background: rgba(3, 169, 244, 0.2);
}
.progress.progress-line-success {
  background: rgba(76, 175, 80, 0.2);
}
.progress.progress-line-warning {
  background: rgba(251, 192, 45, 0.2);
}
.progress.progress-line-danger {
  background: rgba(244, 67, 54, 0.2);
}

h1, .h1 {
  font-size: 3.8em;
  line-height: 1.15em;
}

h2, .h2 {
  font-size: 2.6em;
}

h3, .h3 {
  font-size: 1.825em;
  line-height: 1.4em;
  margin: 20px 0 10px;
}

h4, .h4 {
  font-size: 1.3em;
  line-height: 1.4em;
}

h5, .h5 {
  font-size: 1.25em;
  line-height: 1.4em;
  margin-bottom: 15px;
}

h6, .h6 {
  font-size: 1em;
  text-transform: uppercase;
}

.title,
.card-title,
.info-title,
.footer-brand,
.footer-big h5,
.footer-big h4,
.media .media-heading {
  font-weight: 700;
}
.title,
.title a,
.card-title,
.card-title a,
.info-title,
.info-title a,
.footer-brand,
.footer-brand a,
.footer-big h5,
.footer-big h5 a,
.footer-big h4,
.footer-big h4 a,
.media .media-heading,
.media .media-heading a {
  color: #3C4858;
  text-decoration: none;
}

h2.title {
  margin-bottom: 30px;
}

.description,
.card-description,
.footer-big p {
  color: #999999;
}

.text-warning {
  color: #fbc02d;
}

.text-primary {
  color: #9c27b0;
}

.text-danger {
  color: #f44336;
}

.text-success {
  color: #4caf50;
}

.text-info {
  color: #03a9f4;
}

.nav-tabs {
  background: #9c27b0;
  border: 0;
  border-radius: 3px;
  padding: 0 15px;
}
.nav-tabs > li > a {
  color: #FFFFFF;
  border: 0;
  margin: 0;
  border-radius: 3px;
  line-height: 24px;
  text-transform: uppercase;
  font-size: 12px;
}
.nav-tabs > li > a:hover {
  background-color: transparent;
  border: 0;
}
.nav-tabs > li > a, .nav-tabs > li > a:hover, .nav-tabs > li > a:focus {
  background-color: transparent;
  border: 0 !important;
  color: #FFFFFF !important;
  font-weight: 500;
}
.nav-tabs > li.disabled > a, .nav-tabs > li.disabled > a:hover {
  color: rgba(255, 255, 255, 0.5);
}
.nav-tabs > li .material-icons {
  margin: -1px 5px 0 0;
}
.nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
  background-color: rgba(255, 255, 255, 0.2);
  transition: background-color .1s .2s;
}

.popover, .tooltip-inner {
  color: #555555;
  line-height: 1.5em;
  background: #FFFFFF;
  border: none;
  border-radius: 3px;
  box-shadow: 0 8px 10px 1px rgba(0, 0, 0, 0.14), 0 3px 14px 2px rgba(0, 0, 0, 0.12), 0 5px 5px -3px rgba(0, 0, 0, 0.2);
}

.popover {
  padding: 0;
  box-shadow: 0 16px 24px 2px rgba(0, 0, 0, 0.14), 0 6px 30px 5px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
}
.popover.left > .arrow, .popover.right > .arrow, .popover.top > .arrow, .popover.bottom > .arrow {
  border: none;
}

.popover-title {
  background-color: #FFFFFF;
  border: none;
  padding: 15px 15px 5px;
  font-size: 1.3em;
}

.popover-content {
  padding: 10px 15px 15px;
  line-height: 1.4;
}

.tooltip.in {
  opacity: 1;
  -webkit-transform: translate3d(0, 0px, 0);
  -moz-transform: translate3d(0, 0px, 0);
  -o-transform: translate3d(0, 0px, 0);
  -ms-transform: translate3d(0, 0px, 0);
  transform: translate3d(0, 0px, 0);
}

.tooltip {
  opacity: 0;
  transition: opacity, transform .2s ease;
  -webkit-transform: translate3d(0, 5px, 0);
  -moz-transform: translate3d(0, 5px, 0);
  -o-transform: translate3d(0, 5px, 0);
  -ms-transform: translate3d(0, 5px, 0);
  transform: translate3d(0, 5px, 0);
}
.tooltip.left .tooltip-arrow {
  border-left-color: #FFFFFF;
}
.tooltip.right .tooltip-arrow {
  border-right-color: #FFFFFF;
}
.tooltip.top .tooltip-arrow {
  border-top-color: #FFFFFF;
}
.tooltip.bottom .tooltip-arrow {
  border-bottom-color: #FFFFFF;
}

.tooltip-inner {
  padding: 10px 15px;
  min-width: 130px;
}

.carousel .carousel-control {
  width: 50%;
}
.carousel .carousel-control.left, .carousel .carousel-control.right {
  background-image: none;
}
.carousel .carousel-control .material-icons,
.carousel .carousel-control .fa {
  display: none;
}
.carousel .left {
  cursor: url("../img/arrow-left.png"), url("../img/arrow-left.cur"), default !important;
}
.carousel .right {
  cursor: url("../img/arrow-right.png"), url("../img/arrow-right.cur"), default !important;
}
.carousel .carousel-indicators {
  bottom: 5px;
}
.carousel .carousel-indicators li,
.carousel .carousel-indicators .active {
  margin: 11px 10px;
}
.carousel .carousel-indicators li {
  background: #FFFFFF;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
  border-radius: 2px;
}
.carousel .carousel-indicators .active {
  margin-top: 10px;
  -webkit-transform: scale(1.5);
  -moz-transform: scale(1.5);
  -o-transform: scale(1.5);
  -ms-transform: scale(1.5);
  transform: scale(1.5);
  box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12), 0 2px 4px -1px rgba(0, 0, 0, 0.2);
}
.carousel .carousel-caption {
  padding-bottom: 45px;
}
.carousel .carousel-caption .material-icons {
  position: relative;
  top: 5px;
}

.card {
  display: inline-block;
  position: relative;
  width: 100%;
  border-radius: 3px;
  color: rgba(0,0,0, 0.87);
  background: #fff;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
}
.card .card-height-indicator {
  margin-top: 100%;
}
.card .card-content {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.card .card-image {
  height: 60%;
  position: relative;
  overflow: hidden;
}
.card .card-image img {
  width: 100%;
  height: 100%;
  border-top-left-radius: 2px;
  border-top-right-radius: 2px;
  pointer-events: none;
}
.card .card-image .card-image-headline {
  position: absolute;
  bottom: 16px;
  left: 18px;
  color: #fff;
  font-size: 2em;
}
.card .content {
  padding: 15px;
}
.card .card-body {
  height: 30%;
  padding: 18px;
}
.card .card-footer {
  height: 10%;
  padding: 18px;
}
.card .card-footer button, .card .card-footer a {
  margin: 0 !important;
  position: relative;
  bottom: 25px;
  width: auto;
}
.card .card-footer button:first-child, .card .card-footer a:first-child {
  left: -15px;
}
.card .header {
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
  margin: 15px;
  border-radius: 3px;
  padding: 15px 0;
  background-color: #FFFFFF;
}
.card .header-primary {
  background: linear-gradient(60deg, #ab47bc, #7b1fa2);
}
.card .header-info {
  background: linear-gradient(60deg, #29b6f6, #0288d1);
}
.card .header-success {
  background: linear-gradient(60deg, #66bb6a, #388e3c);
}
.card .header-warning {
  background: linear-gradient(60deg, #fdd835, #fbc02d);
}
.card .header-danger {
  background: linear-gradient(60deg, #ef5350, #d32f2f);
}
.card [class*="header-"] {
  color: #FFFFFF;
}

.card-raised {
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
}

.card-signup .header {
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
  margin-left: 20px;
  margin-right: 20px;
  margin-top: -40px;
  padding: 20px 0;
}
.card-signup .text-divider {
  margin-top: 30px;
  margin-bottom: 0px;
  text-align: center;
}
.card-signup .content {
  padding: 0px 30px 0px 10px;
}
.card-signup .checkbox {
  margin-top: 20px;
}
.card-signup .checkbox label {
  margin-left: 17px;
}
.card-signup .checkbox .checkbox-material {
  padding-right: 12px;
}
.card-signup .social-line {
  margin-top: 15px;
  text-align: center;
}
.card-signup .social-line .btn {
  color: #FFFFFF;
  margin-left: 5px;
  margin-right: 5px;
}

.card-nav-tabs {
  margin-top: 45px;
}
.card-nav-tabs .header {
  margin-top: -30px;
}
.card-nav-tabs .nav-tabs {
  background: transparent;
}

.card-plain {
  background: transparent;
  box-shadow: none;
}
.card-plain .header {
  margin-left: 0;
  margin-right: 0;
}
.card-plain .content {
  padding-left: 0;
  padding-right: 0;
}

.modal-content {
  box-shadow: 0 27px 24px 0 rgba(0, 0, 0, 0.2), 0 40px 77px 0 rgba(0, 0, 0, 0.22);
  border-radius: 3px;
  border: none;
}
.modal-content .modal-header {
  border-bottom: none;
  padding-top: 24px;
  padding-right: 24px;
  padding-bottom: 0;
  padding-left: 24px;
}
.modal-content .modal-body {
  padding-top: 24px;
  padding-right: 24px;
  padding-bottom: 16px;
  padding-left: 24px;
}
.modal-content .modal-footer {
  border-top: none;
  padding: 7px;
}
.modal-content .modal-footer button {
  margin: 0;
  padding-left: 16px;
  padding-right: 16px;
  width: auto;
}
.modal-content .modal-footer button.pull-left {
  padding-left: 5px;
  padding-right: 5px;
  position: relative;
  left: -5px;
}
.modal-content .modal-footer button + button {
  margin-bottom: 16px;
}
.modal-content .modal-body + .modal-footer {
  padding-top: 0;
}

.modal-backdrop {
  background: rgba(0, 0, 0, 0.3);
}

.modal .modal-dialog {
  margin-top: 100px;
}
.modal .modal-header .close {
  color: #555555;
}
.modal .modal-header .close:hover, .modal .modal-header .close:focus {
  opacity: 1;
  color: #555555;
}

.panel {
  border-radius: 2px;
  border: 0;
  box-shadow: 0 1px 6px 0 rgba(0, 0, 0, 0.12), 0 1px 6px 0 rgba(0, 0, 0, 0.12);
}
.panel > .panel-heading, .panel.panel-default > .panel-heading {
  background-color: #eeeeee;
}
.panel.panel-inverse > .panel-heading {
  background-color: #3f51b5;
}
.panel.panel-primary > .panel-heading {
  background-color: #9c27b0;
}
.panel.panel-success > .panel-heading {
  background-color: #4caf50;
}
.panel.panel-info > .panel-heading {
  background-color: #03a9f4;
}
.panel.panel-warning > .panel-heading {
  background-color: #fbc02d;
}
.panel.panel-danger > .panel-heading {
  background-color: #f44336;
}

[class*="panel-"] > .panel-heading {
  color: #ffffff;
  border: 0;
}

.panel-default > .panel-heading, .panel:not([class*="panel-"]) > .panel-heading {
  color: rgba(0,0,0, 0.87);
}

.panel-footer {
  background-color: #eeeeee;
}

hr.on-dark {
  color: #1a1a1a;
}
hr.on-light {
  color: white;
}
@media (-webkit-min-device-pixel-ratio: 0.75), (min--moz-device-pixel-ratio: 0.75), (-o-device-pixel-ratio: 3 / 4), (min-device-pixel-ratio: 0.75), (min-resolution: 0.75dppx), (min-resolution: 120dpi) {
  hr {
    height: 0.75px;
  }
}
@media (-webkit-min-device-pixel-ratio: 1), (min--moz-device-pixel-ratio: 1), (-o-device-pixel-ratio: 1), (min-device-pixel-ratio: 1), (min-resolution: 1dppx), (min-resolution: 160dpi) {
  hr {
    height: 1px;
  }
}
@media (-webkit-min-device-pixel-ratio: 1.33), (min--moz-device-pixel-ratio: 1.33), (-o-device-pixel-ratio: 133 / 100), (min-device-pixel-ratio: 1.33), (min-resolution: 1.33dppx), (min-resolution: 213dpi) {
  hr {
    height: 1.333px;
  }
}
@media (-webkit-min-device-pixel-ratio: 1.5), (min--moz-device-pixel-ratio: 1.5), (-o-device-pixel-ratio: 3 / 2), (min-device-pixel-ratio: 1.5), (min-resolution: 1.5dppx), (min-resolution: 240dpi) {
  hr {
    height: 1.5px;
  }
}
@media (-webkit-min-device-pixel-ratio: 2), (min--moz-device-pixel-ratio: 2), (-o-device-pixel-ratio: 2 / 1), (min-device-pixel-ratio: 2), (min-resolution: 2dppx), (min-resolution: 380dpi) {
  hr {
    height: 2px;
  }
}
@media (-webkit-min-device-pixel-ratio: 3), (min--moz-device-pixel-ratio: 3), (-o-device-pixel-ratio: 3 / 1), (min-device-pixel-ratio: 3), (min-resolution: 3dppx), (min-resolution: 480dpi) {
  hr {
    height: 3px;
  }
}
@media (-webkit-min-device-pixel-ratio: 4), (min--moz-device-pixel-ratio: 4), (-o-device-pixel-ratio: 4 / 1), (min-device-pixel-ratio: 3), (min-resolution: 4dppx), (min-resolution: 640dpi) {
  hr {
    height: 4px;
  }
}

.img-thumbnail {
  border-radius: 16px;
}

.img-raised {
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
}

* {
  -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
  -webkit-tap-highlight-color: transparent;
}
*:focus {
  outline: 0;
}

a:focus, a:active,
button:active, button:focus, button:hover,
button::-moz-focus-inner,
input[type="reset"]::-moz-focus-inner,
input[type="button"]::-moz-focus-inner,
input[type="submit"]::-moz-focus-inner,
select::-moz-focus-inner,
input[type="file"] > input[type="button"]::-moz-focus-inner {
  outline: 0 !important;
}

.section {
  padding: 70px 0;
}

.section-navbars {
  padding-bottom: 0;
}

.section-full-screen {
  height: 100vh;
}

.section-signup {
  padding-top: 20vh;
}

.noUi-target,
.noUi-target * {
  -webkit-touch-callout: none;
  -ms-touch-action: none;
  user-select: none;
  box-sizing: border-box;
}

.noUi-base {
  width: 100%;
  height: 100%;
  position: relative;
}

.noUi-origin {
  position: absolute;
  right: 0;
  top: 0;
  left: 0;
  bottom: 0;
}

.noUi-handle {
  position: relative;
  z-index: 1;
  box-sizing: border-box;
}

.noUi-stacking .noUi-handle {
  z-index: 10;
}

.noUi-state-tap .noUi-origin {
  transition: left 0.3s, top 0.3s;
}

.noUi-state-drag * {
  cursor: inherit !important;
}

.noUi-horizontal {
  height: 10px;
}

.noUi-handle {
  box-sizing: border-box;
  width: 14px;
  height: 14px;
  left: -10px;
  top: -6px;
  cursor: pointer;
  border-radius: 100%;
  transition: all 0.2s ease-out;
  border: 1px solid;
  background: #FFFFFF;
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
}

.noUi-vertical .noUi-handle {
  margin-left: 5px;
  cursor: ns-resize;
}

.noUi-horizontal.noUi-extended {
  padding: 0 15px;
}

.noUi-horizontal.noUi-extended .noUi-origin {
  right: -15px;
}

.noUi-background {
  height: 2px;
  margin: 20px 0;
}

.noUi-origin {
  margin: 0;
  border-radius: 0;
  height: 2px;
  background: #c8c8c8;
}
.noUi-origin[style^="left: 0"] .noUi-handle {
  background-color: #fff;
  border: 2px solid #c8c8c8;
}
.noUi-origin[style^="left: 0"] .noUi-handle.noUi-active {
  border-width: 1px;
}

.noUi-target {
  border-radius: 3px;
}

.noUi-horizontal {
  height: 2px;
  margin: 15px 0;
}

.noUi-vertical {
  height: 100%;
  width: 2px;
  margin: 0 15px;
  display: inline-block;
}

.noUi-handle.noUi-active {
  transform: scale3d(2, 2, 1);
}

[disabled].noUi-slider {
  opacity: 0.5;
}

[disabled] .noUi-handle {
  cursor: not-allowed;
}

.slider {
  background: #c8c8c8;
}

.slider.noUi-connect {
  background-color: #9c27b0;
}
.slider .noUi-handle {
  border-color: #9c27b0;
}
.slider.slider-info .noUi-connect, .slider.slider-info.noUi-connect {
  background-color: #03a9f4;
}
.slider.slider-info .noUi-handle {
  border-color: #03a9f4;
}
.slider.slider-success .noUi-connect, .slider.slider-success.noUi-connect {
  background-color: #4caf50;
}
.slider.slider-success .noUi-handle {
  border-color: #4caf50;
}
.slider.slider-warning .noUi-connect, .slider.slider-warning.noUi-connect {
  background-color: #fbc02d;
}
.slider.slider-warning .noUi-handle {
  border-color: #fbc02d;
}
.slider.slider-danger .noUi-connect, .slider.slider-danger.noUi-connect {
  background-color: #f44336;
}
.slider.slider-danger .noUi-handle {
  border-color: #f44336;
}

.dropdownjs::after {
  right: 5px;
  top: 3px;
  font-size: 25px;
  position: absolute;
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  content: "\e5c5";
  pointer-events: none;
  color: #757575;
}

/*!
 * Datepicker for Bootstrap
 *
 * Copyright 2012 Stefan Petre
 * Licensed under the Apache License v2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */
/*
 *
 *   SCSS by Creative Tim
 *   http://www.creative-tim.com
 *
 */
.datepicker {
  top: 0;
  left: 0;
  padding: 4px;
  margin-top: 1px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.datepicker > div {
  display: none;
}
.datepicker table {
  width: 100%;
  margin: 0;
}
.datepicker td,
.datepicker th {
  text-align: center;
  width: 20px;
  height: 20px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.datepicker td {
  text-align: center;
}
.datepicker td p {
  font-size: 1em;
  font-weight: 400;
  border-radius: 50%;
  height: 29px;
  line-height: 29px;
  margin: 3px 0 8px;
  width: 29px;
}
.datepicker td :hover {
  cursor: pointer;
}
.datepicker th {
  font-weight: 500;
}
.datepicker th.switch-datepicker {
  font-size: 1em;
}
.datepicker .prev p,
.datepicker .next p {
  font-size: 1.825em;
}
.datepicker p:hover {
  background: #eeeeee;
}
.datepicker .day.disabled {
  color: #eeeeee;
}
.datepicker td.old,
.datepicker td.new {
  color: #999999;
  border-top: 0;
}
.datepicker td.active p,
.datepicker td.active:hover p {
  box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12), 0 2px 4px -1px rgba(0, 0, 0, 0.2);
  color: #ffffff;
  background-color: #9c27b0;
}
.datepicker td.primary p,
.datepicker td.primary:hover p {
  background-color: #9c27b0;
}
.datepicker td.info p,
.datepicker td.info:hover p {
  background-color: #03a9f4;
}
.datepicker td.success p,
.datepicker td.success:hover p {
  background-color: #4caf50;
}
.datepicker td.warning p,
.datepicker td.warning:hover p {
  background-color: #fbc02d;
}
.datepicker td.danger p,
.datepicker td.danger:hover p {
  background-color: #f44336;
}
.datepicker span {
  display: block;
  width: 55px;
  height: 54px;
  line-height: 54px;
  float: left;
  margin: 2px;
  cursor: pointer;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.datepicker span.old {
  color: #999999;
}
.datepicker span.active, .datepicker span.active:focus, .datepicker span.active:hover, .datepicker span.active:active {
  background-color: #9c27b0;
  box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12), 0 2px 4px -1px rgba(0, 0, 0, 0.2);
}
.datepicker span.active {
  color: #FFFFFF;
}
.datepicker span:hover {
  background-color: #EEEEEE;
}
.datepicker span.primary,
.datepicker span.primary:hover {
  background-color: #9c27b0;
}
.datepicker span.info,
.datepicker span.info:hover {
  background-color: #03a9f4;
}
.datepicker span.success,
.datepicker span.success:hover {
  background-color: #4caf50;
}
.datepicker span.warning,
.datepicker span.warning:hover {
  background-color: #fbc02d;
}
.datepicker span.danger,
.datepicker span.danger:hover {
  background-color: #f44336;
}
.datepicker th.switch-datepicker {
  width: 145px;
}
.datepicker th.next,
.datepicker th.prev {
  font-size: 21px;
}
.datepicker thead tr:first-child th {
  cursor: pointer;
}
.datepicker thead tr:first-child th:hover {
  background: #eeeeee;
}
.datepicker.dropdown-menu {
  border-radius: 3px;
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.56), 0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
  -webkit-transition: all 150ms linear;
  -moz-transition: all 150ms linear;
  -o-transition: all 150ms linear;
  -ms-transition: all 150ms linear;
  transition: all 150ms linear;
  margin-top: -20px;
  opacity: 0;
  visibility: hidden;
}
.datepicker.dropdown-menu.open {
  opacity: 1;
  visibility: visible;
  margin-top: 1px;
}
.datepicker .table-condensed > tbody > tr > td {
  padding: 2px;
}
.datepicker .table-condensed > thead > tr > th {
  padding: 0;
}

.input-append.date .add-on i,
.input-prepend.date .add-on i {
  display: block;
  cursor: pointer;
  width: 16px;
  height: 16px;
}

.datepicker-months thead {
  padding: 0 0 3px;
  display: block;
}

.withripple {
  position: relative;
}

.ripple-container {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  width: 100%;
  height: 100%;
  overflow: hidden;
  border-radius: inherit;
  pointer-events: none;
}

.ripple {
  position: absolute;
  width: 20px;
  height: 20px;
  margin-left: -10px;
  margin-top: -10px;
  border-radius: 100%;
  background-color: #000;
  background-color: rgba(0, 0, 0, 0.05);
  transform: scale(1);
  transform-origin: 50%;
  opacity: 0;
  pointer-events: none;
}

.ripple.ripple-on {
  transition: opacity 0.15s ease-in 0s, transform 0.5s cubic-bezier(0.4, 0, 0.2, 1) 0.1s;
  opacity: 0.1;
}

.ripple.ripple-out {
  transition: opacity 0.1s linear 0s !important;
  opacity: 0;
}

.wrapper > .header {
  min-height: 300px;
  background-position: center center;
  background-size: cover;
}

.main {
  background: #FFFFFF;
  position: relative;
  z-index: 3;
}

.main-raised {
  margin: -60px 30px 0px;
  border-radius: 6px;
  box-shadow: 0 16px 24px 2px rgba(0, 0, 0, 0.14), 0 6px 30px 5px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
}

.title {
  font-weight: 500;
  color: #3C4858;
}

h2.title {
  margin-bottom: 30px;
}

.description {
  color: #999999;
}

.header-filter {
  position: relative;
}
.header-filter:after {
  position: absolute;
  z-index: 1;
  width: 100%;
  height: 100%;
  display: block;
  left: 0;
  top: 0;
  content: "";
  background-color: rgba(0, 0, 0, 0.4);
}
.header-filter .container {
  z-index: 2;
  position: relative;
}

.gallery .image img {
  width: 100%;
}

.features {
  padding: 80px 0 0;
}

.team {
  margin-top: 80px;
}
.team .team-player .title {
  margin: 30px auto;
}
.team .team-player img {
  max-width: 170px;
}

.nav-align-center {
  text-align: center;
}
.nav-align-center .nav-pills {
  display: inline-block;
}

.navbar-absolute {
  position: absolute;
  width: 100%;
  padding-top: 10px;
  z-index: 1031;
}

.index-page .wrapper > .header {
  height: 90vh;
}
.index-page .brand {
  margin-top: 30vh;
  color: #FFFFFF;
  text-align: center;
}
.index-page .brand h1 {
  font-size: 4.8em;
  font-weight: 600;
}
.index-page .brand h3 {
  font-size: 1.5em;
  text-transform: uppercase;
  max-width: 400px;
  margin: 10px auto 0;
}
.index-page .section-basic {
  padding-top: 15px;
}
.index-page .header-filter:after {
  background: rgba(101, 47, 142, 0.64);
  background: linear-gradient(45deg, rgba(101, 47, 142, 0.88) 0%, rgba(125, 46, 185, 0.45) 100%);
  background: -moz-linear-gradient(135deg, rgba(101, 47, 142, 0.88) 0%, rgba(125, 46, 185, 0.45) 100%);
  background: -webkit-linear-gradient(135deg, rgba(101, 47, 142, 0.88) 0%, rgba(125, 46, 185, 0.45) 100%);
}

.landing-page .header {
  height: 100vh;
}
.landing-page .header .container {
  padding-top: 26vh;
  color: #FFFFFF;
}
.landing-page .header .share {
  margin-top: 150px;
}
.landing-page .header h1 {
  font-weight: 600;
}
.landing-page .header .title {
  color: #FFFFFF;
}
.landing-page .wrapper {
  background: #CCCCCC;
}

.profile-page .header {
  height: 380px;
  background-position: top center;
}
.profile-page .profile {
  text-align: center;
}
.profile-page .profile img {
  max-width: 160px;
  margin: -80px auto 0;
}
.profile-page .description {
  margin: 30px auto 0;
  max-width: 600px;
}
.profile-page .profile-tabs {
  margin-top: 60px;
}
.profile-page .gallery {
  margin-top: 45px;
  padding-bottom: 50px;
}
.profile-page .gallery img {
  width: 100%;
  margin-bottom: 30px;
}

.signup-page .wrapper > .header {
  min-height: 100vh;
}
.signup-page .wrapper .card-signup {
  margin: 160px 0 40px;
}
.signup-page .footer .copyright,
.signup-page .footer a {
  color: #FFFFFF;
}

.landing-page .navbar-transparent,
.profile-page .navbar-transparent,
.signup-page .navbar-transparent,
.index-page .navbar-transparent {
  padding-top: 25px;
}

@media (max-width: 991px) {
  .landing-page .header {
    height: auto;
    min-height: 100vh;
  }
  .landing-page .header .container {
    padding-bottom: 70px;
  }
}
@media (max-width: 768px) {
  .footer .copyright {
    display: inline-block;
    text-align: center;
    padding: 10px 0;
    float: none !important;
    width: 100%;
  }

  .navbar.navbar-transparent {
    background-color: rgba(0, 0, 0, 0.4);
    padding-top: 10px;
    border-radius: 0;
  }

  .main-raised {
    margin-left: 10px;
    margin-right: 10px;
  }
}
</style>	
</head>

<body>

<div class="wrapper" id="patnolpat">

	<div class="header-dashboard">
		<div class="container">
			<div class="col-sm-6 col-sm-offset-3 text-center">
			<img src="data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAARIAAABwCAYAAADSfP/GAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyFpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDIxIDc5LjE1NDkxMSwgMjAxMy8xMC8yOS0xMTo0NzoxNiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6OTUyRDA5MUI1MDc1MTFFOUJGMzg4NDYzNDg1QjU5NTUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6OTUyRDA5MUE1MDc1MTFFOUJGMzg4NDYzNDg1QjU5NTUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkFBNTJGM0M0NTA3NDExRTlCQTVBREE4QkZFRjcyRTZGIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkFBNTJGM0M1NTA3NDExRTlCQTVBREE4QkZFRjcyRTZGIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+1qZWmAAADnFJREFUeNrsnQu0VFUZxz+EBIQrl8clBdKEQEqUh6YuDEsq87WWlhIZoKhoWiqKIiBUuhAVkxICJVQCQgx1peaLJQYmlJQohAS4wHDxUBCIR7y5QN+fvYnxNufsfWbmzJyZ+f/X+taCOXvO3bNnn9/sx7e/r9bBgweFil+1atViIxRY7Ovx6Sg2AeWh89QWqHVnU1BpfyhJaY5IQlRb7edqQ+2PzgG1EWr3qu3niIQiSAgSl1qoTbWjkZqardZHbS1BQhEkBEmQzrcQqQops0Gtt9rrBAlFkBAkqaqjNlztLvFbP8NU5xdqw9SqCRKChCJIWqlNU+uWwXvnqPVSW02QECRU+YLkYrXJak2zuMcmtavVXiFICBKqvEDyObX71e5AFXPxrKqNUrtbbR9BQpBQpQ+SE9Smq50dw73nqfVUW0WQECRU6YLkMrWJao1j/Btb1K5Re4EgIUio0gJJXbUH1frnaCrjM9UZrTZYbQ9BQpBQxQ+Sk9SeUTujAH97vtr31VYSJAQJVbwg6aE2Qa2ygHXYqna92rMECUFCFRdI6olxGLs5QU0xVm2g2m6ChCChkg+StnYq0ymBzbHQTnWWEyQECZVckFypNl7t2AQ3yTa1m8R40xIkBAmVIJBgKoNdkhuKqGmwdtM/H1Md9nWChCBxq72dypxahM2zWMyC8DKChCChCgcSxAZ5VK1hETfRdrWfqE0hSAgSKr8gOUZtnFrfEmqqSRYoOwkSgoSKHyQd1H6vdkoJNtcSMWd1FhMkBAkVH0hwhmWsHZGUqjAiuUXMmSCChCChcggSrIFgW7dXGTXdU2o3illDIUgIEoIkS3W0U5n2Zdh82M2Bb8xCgoQgIUgyF/xC4B9Sr4ybEH4m8DeZQJAQJARJNMEz9XEx7uSUEQ799RPjGUuQECQEiUNd7FSmLVvv/7TcTnXeJUgIEoIkWDit+7CYQERUeiFQ0p1idq8IEoKEIEkR4oU8qfY9tpi3nle7VkxoR4KEICl7kCByGc7KnMTWiixEXoMD2zsECUFSriDBhdvURopJD0FlJqS/GKT2iJhYsQQJQVI2IGlqpzKXsoVyphfVrhOTsIsgIUhKHiTIJ4O8MiewdXKuVXaqM48gIUhKFST4B5J0D+dUJlYhqTmSmz90eKrDvk6QlApIqtR+KybXLpUfIRcxDjluYF8nSEoFJABIS7ZG3rUWQGFfJ0hKaWpDFUjs6wQJQUIRJAQJFSNIfiDpc9cg9umSBDcJHO/SHUZEnV8iSIpLddgERS9sI/dP8/oHCQdJZzEJzWtqTFwgoeLTUWyCoteGgNebJ7zeVQGvb+JXSpBQ+dcnAa+3S3i9gyK9reNXSpBQ+deHAa93SXi9Owa8voJfafGJi635auj4FlubqG0U4zGbKnh24iyPbyQx5OE9MYt6rBaTY8dH9dU2S/p4K81DpmtZiX2dICFIwrU0YKrQW0wUdh89p3Z5FnV4Qe27nmUvExNHJN1oJLaIcOzrnNpQ4Zod8PoVEe7xXpZ1iBL2sG/A62/wq+SIhCrciORCtVfTvH5A7WTPdQckH1+URR1OU3vfo1wbMekl0rkeXCLmbAxHJByRUAUQfsk/Dfh+h3jeAxCYleHfn+kJEWhYAESwzvM6v0qChCqcEB1sSsC1q9XO8rwPUmRGTd69Q+1Wz7Kox1UB1ybZz0FxakMVaGoDIUAS0jQcHTDaQEzYvR73wQll5I6p71F2l5hA1TM8yiJP8d8lfdLzvXbKsybOBmJf54iEcgtRwYKy0GH940nP+2CNoqu4F18X2HIzPO87JgAiYuu9hl8hRyRU4UckUDMxC5lNA67/TExkNt8fGYxOkLAc53mQ9Q8+KfPVponZ7j3gea/Bag8EXINL/MmSB9d49nWChCDxF3xHfhdyHQflhuTxow9Vuy/kOk4vT89HRdjXCRKCJJomS/Ci5uHryOa3PcY61LXTmRtCyjym9uN8NQr7OkFCkEQTFlxfU+seUmaZHQ38I4a/D5+SiWqnh5R5U+074rcATJAQJFQBQAI1UpsjZqE1SDiPM1rM+kUu1iiwRnO3He2ERch/z0JkYz4bhH2dICFIMtNxdmTSyVFuq9oTar8Rs4UcVZ3sFKaPWkNH2bliPFi35rsx2NcJEoIkc2G35Sn78PoIU5231N5WWyjGY/bfciQNZmMxPiuYvpypdpFaa89746AeFoN3FqIh2NcJEoIkO2Erd6Bkl5Rri1plhu/dI8Y1fpQE5OUlSAgSKvkgOSyMIuD8dVYe/+Zf1G5UW1zoD8++TpAQJLkdnfRQu0eCwx3mQvC0vVdMZsFEdDL2dYKEIMm9aovxWh2SY6AgZMEjYhZv9yTpA7OvEyQESbyCvwdOCfeUzKLPYwfmZbWpYkIBHEjih2RfJ0gIkvyNUhA0upuYLV2cgfmCGJ8UnN7FaV+ct0EuXQSdRlS0v4rZ4alO+odjXydICBKKICFIKIKEICFIqP+pTp3Mspzu37+fjVfoeVvt2hm9r7q6mo1HkCQDJFTxiiAhSOIEyUxHUWytfhpjVc5V+5MEJ4JHeMXT+I0RJHl5LtgEGetbjuv1Yv77Ffz+qKSIMVspiiJIKIoiSCiKIkgoiqIIEoqiciBu/0ZUyvavq+FOFHOUPi7h/MuXQq7jXMwSfmPZi9u/BEkpg4QiSAgSgoQiSAgSgiQ6SJBrBk5sX7NTksb29c1qK9XmifFU3eZZFcReDYvYvj/NvVD5ipD3IChzzWBE7dQuUOusViUm8RUSa32k9o6YOCSuOuPvwhP3HDGhCRDzBKcYkY4CwaaRP3hhll9NE/s3zrBtjwj6lfbv/Edth5jwB0ttvZHQfB9BQpAUC0iwoH2rmHwvVY73YF0DEd+He4xmLrYPcZDSucgDYnNC3oOsd4/ZfyMfzigLv1oO+PxKTFrO3WkAgs9+u1orx+fBg32no37phPw4t9l6RvH0RTBr5C8eJyafMUGShbhrE6/wyzvbPmhVHuXrq/UTs0jar4D1vtw+2N92QARCwCPk933NjlYO63gxAY9GeUAEQmqLN9Xu8qwj2vMVO5q5QKIfF8Bopa8dncxS+zK7K0GSRFXZDnpuBu9toPa4hCffjkuo7zSJflboG2q/Tvnsb9lpRtT+OFJtkKNcGwuAi3L0mc9T+5vkN7o+QUJ5CdHTT8nyHvilH5DHOjdVm27XczJRP7sO8rSEb027NELt7IBrANyLduqYS1XY+zZl1yVIkqRTc3SfBzL4Zc9UmFYcl8X7MQ36g9o3s6wHIhDdH3BtUA4AHaTPi1lvoaJ+8VxsjaYIi6251Hy7hpD6N+NYbI1TO+0Pl++U6aCdwqxMeQ3rMWvFnfFvvf2ca8TsQqF8OzvKqe9476qaox0utnJEkhRhi/N2ObL1iwjtvexQ2gdIGJFcksf6ItfvHRZEzexw/6tikoxHvQ92bbDw2sA+xBipPeE5uule47XzHRBBW/5UTOT7HrbNB4vJ9Id7tbTTrjAhr3ErdtmIP7Bsglh1uGNjenIgDVywqIlty+fEuLyH6Wa1l/JQ539Z4H2SBgoYGX2g9kuP+8B3o6stnyqk7rxebYOY5FxhqrnO4poyARJhC9Tw2elr79PcAZM17L4ckSRFmOePkPCEUW/YX0/XyMTV+XOlAWkgkqrRFjYuDU0DkVTBV2aX4x4ta/y/g6P8SI967RW381sjdl2OSJKij8TkvvXRTPtr+sOQMrUtTJ6Osc54yGY4ygCKL9spS5AAiImO+6AMfFW+HlKm5jRmkR3JBN1vkeeU6QT+wBIkxaIJ4umCbTXOARLozJhBgpGIT77efzquY6Fzh8d9Njiu19yG7p/l56tvR4nt2T0JkmLRqxHLv20frDAP2Li9Lzd6ltvsuL4swggoTA2y+CzH2pFHGwsOnBXCYm1jdk2CpFiEB2RxxPdgjWSB7exBins3YZdnuZ1ZXs+1ANhudsT2FTEHA5uwGxIkxS74OmSSWm+l43oFm/YzI46b1K6x4KAIkpLTtgzft9nj4aFErlB7VPwOQlJ5EFen49H2DN93MKb7lpKwPf1MFhBB3JdlbEaOSIpBlRm+z+W+vavM2xXHAh4Wd2iDmtNMbAtjq3mGBQm2r7lzQ5AkXi0zfF8zx/X1Mde7UcL76lgPiCDf8lS1P8uRnTCKICnaEUlr8fMATVVnx/UVZT4a+aKjDHxE7hG3/87R7KK5FddI4tOFEcu3ELefyPtlDpIwPSvGLd/HCbAZuydBUizqG7H8VR7fx9wybk9XDJKJnvfBKJzbxQRJ0QhH/3t6lsUx/YGOMuvU3i3j9nTt0qz1vA+CRR/D7kmQFJPGiztSGubrk8XtiYkQiPvLuC1rO64397zHfeyWBEmxqdJOR26R9Fu7XcTksnHN/3HidmyZt6Vr9+VKx3XkAJoiJqgUlWNx1yZ+wRt1jNqDYuJgrLft3i7CXB0PwIoyb0ecXQqL8n6t2sdqD8lnHfcwbUQ0OkRKO54/sARJsQvz8q4ZvA+RyYaw+Q45kV0Xch3+JYhGN8ACe58FR9sMwMAzTQRJYobhdSX7szFwmUeKh3Vs0kMgWW7BECaEHjjHUeZDMeEFgsRQAxHFIVw8woPfR6IFNkonpLB8PuBauYU2r7ZQzeZzH7RTnGGOcl3YhQmSpOiPYlJfZnLQDvE8cDw+LMjyjjJsU2Tv6yWZxTtZb78PxHVd6igLn54fsQsTJEkRor7D7d037QS2d+Gh2VFtEpsvrXDy93Txz8+DUSGc1TqkjO5wiO9jx5R/PJvaX0yQFVEpCbJahxRDhLSa6QyQWuFS+xBgfl5hQY4YJAhoNNeCZ7VvVeTIoiDu08ijDkhO1SJivdMJC8dhGfm2iFkkdgm+Hw1Dru92PPDYxektZhEb30elHa1ssrCYZcGcrk0rxL1GeCg+DBNkESRxgoQqExEkbv1XgAEAPu3jQERuQeoAAAAASUVORK5CYII=




smile

laugh"  alt="Vietnamobile Logo">
			<%-- <img src="<c:url value="/static/assets/image/logo.png" alt="Vietnamobile Logo" />" /> --%>
				<%-- <img src="${favicon}" alt="Vietnamobile Logo"> --%>
			</div>
		</div>
	</div>
	<div class="col-sm-6 col-sm-offset-3">
        <input type="hidden" id="trxResultFlag" value="${resultFlag}">
        <input type="hidden" id="orderId" value="${orderId}">
		<div class="card card-raised text-center" id="patnolpatContent">
			<h3>${message}</h3>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4 text-center">
				<button id="btnOK" onclick="window.close();" class="btn btn-primary btn-round">OK</button>
			</div>
		</div>
	</div>
	<footer class="col-sm-12 text-center">
		<ul>
			<li><a href="https://www.facebook.com/VietnamobileVNM" target="_blank"><span class="fa fa-facebook"></span></a></li>
			<li><a href="https://www.youtube.com/user/vietnamobileofficial" target="_blank"><span class="fa fa-youtube-play"></span></a></li>
		</ul>
		<p>Copyright 2017 Vietnamobile. All right reserved.</p>
	</footer>

</div>
</body>
<script type="text/javascript">
 function closeWindow() {
    setTimeout(function() {
    window.close();
    }, 3000);
    }

    window.onload = closeWindow();
    </script>
</html>