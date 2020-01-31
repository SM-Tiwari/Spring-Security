<%-- 
    Document   : e2paybuy
    Created on : Apr 22, 2017, 2:47:51 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body onload="document.formRedirect.submit()">
        <form action="<c:out value="${URL}" />" method="POST" id="formRedirect" name="formRedirect">
            <input type="hidden" name="MerchantCode" value="<c:out value="${MerchantCode}" />" />
            <input type="hidden" name="PaymentId" value="<c:out value="${PaymentId}" />" />
            <input type="hidden" name="RefNo" value="<c:out value="${RefNo}" />" />
            <input type="hidden" name="Amount" value="<c:out value="${Amount}" />" />
            <input type="hidden" name="Currency" value="<c:out value="${Currency}" />" />
            <input type="hidden" name="ProdDesc" value="<c:out value="${ProdDesc}" />" />
            <input type="hidden" name="Lang" value="<c:out value="${Lang}" />" />
            <input type="hidden" name="UserName" value="<c:out value="${UserName}" />" />
            <input type="hidden" name="UserEmail" value="<c:out value="${UserEmail}" />" />
            <input type="hidden" name="UserContact" value="<c:out value="${UserContact}" />" />
            <input type="hidden" name="ResponseURL" value="<c:out value="${ResponseURL}" />" />
            <input type="hidden" name="BackendURL" value="<c:out value="${BackendURL}" />" />
            <input type="hidden" name="Remark" value="<c:out value="${Remark}" />" />
            <input type="hidden" name="Signature" value="<c:out value="${Signature}" />" />
        </form>
    </body>
</html>
