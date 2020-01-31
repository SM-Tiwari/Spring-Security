<%-- 
    Document   : dokubuy
    Created on : Apr 19, 2017, 9:57:07 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", -1);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body onload="document.formRedirect.submit()">
        <form action="<c:out value="${URL}" />" method="POST" id="formRedirect" name="formRedirect">
            <input type="hidden" name="MALLID" value="<c:out value="${MALLID}" />" />
            <input type="hidden" name="CHAINMERCHANT" value="<c:out value="${CHAINMERCHANT}" />" />
            <input type="hidden" name="AMOUNT" value="<c:out value="${AMOUNT}" />" />
            <input type="hidden" name="PURCHASEAMOUNT" value="<c:out value="${PURCHASEAMOUNT}" />" />
            <input type="hidden" name="TRANSIDMERCHANT" value="<c:out value="${TRANSIDMERCHANT}" />" />
            <input type="hidden" name="WORDS" value="<c:out value="${WORDS}" />" />
            <input type="hidden" name="REQUESTDATETIME" value="<c:out value="${REQUESTDATETIME}" />" />
            <input type="hidden" name="CURRENCY" value="<c:out value="${CURRENCY}" />" />
            <input type="hidden" name="PURCHASECURRENCY" value="<c:out value="${PURCHASECURRENCY}" />" />
            <input type="hidden" name="SESSIONID" value="<c:out value="${SESSIONID}" />" />
            <input type="hidden" name="NAME" value="<c:out value="${NAME}" />" />
            <input type="hidden" name="EMAIL" value="<c:out value="${EMAIL}" />" />
            <input type="hidden" name="BASKET" value="<c:out value="${BASKET}" />" />
            <input type="hidden" name="PAYMENTCHANNEL" value="<c:out value="${PAYMENTCHANNEL}" />" />
        </form>
    </body>
</html>
