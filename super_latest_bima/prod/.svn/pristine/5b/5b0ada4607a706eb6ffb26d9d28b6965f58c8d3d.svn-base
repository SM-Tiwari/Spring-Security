<%-- 
    Document   : sprint
    Created on : Apr 24, 2017, 3:49:02 PM
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
            <input type="hidden" name="klikPayCode" value="<c:out value="${klikPayCode}" />" />
            <input type="hidden" name="transactionNo" value="<c:out value="${transactionNo}" />" />
            <input type="hidden" name="totalAmount" value="<c:out value="${totalAmount}" />" />
            <input type="hidden" name="currency" value="<c:out value="${currency}" />" />
            <input type="hidden" name="payType" value="<c:out value="${payType}" />" />
            <input type="hidden" name="callback" value="<c:out value="${callback}" />" />
            <input type="hidden" name="transactionDate" value="<c:out value="${transactionDate}" />" />
            <input type="hidden" name="descp" value="<c:out value="${descp}" />" />
            <input type="hidden" name="miscFee" value="<c:out value="${miscFee}" />" />
            <input type="hidden" name="signature" value="<c:out value="${signature}" />" />
        </form>
    </body>
</html>