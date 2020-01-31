<%-- 
    Document   : product
    Created on : Aug 8, 2017, 6:08:40 PM
    Author     : edwin < edwinkun at gmail dot com >
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html> <html class="no-js"> 
    <head> 
        <meta charset="utf-8"/> 
        <title>Bima Plus - Akses Serunya Hidup - ${productname}</title> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
        <meta content="width=device-width,initial-scale=1.0" name="viewport"/> 
        <meta name="MobileOptimized" content="320"> 
        
        <meta property="og:title" content="${productname}"/> 
        <meta property="og:image" content="${productimage}"/> 
        <meta property="og:description" content="${productdesc}"/> 
        
        <meta name="twitter:title" content="${productname}"/> 
        <meta name="twitter:description" content="${productdesc}"/> 
        <meta name="twitter:image" content="${productimage2}"/> 
        <meta name="twitter:card" content="summary"/> 
        <meta name="twitter:creator" content="@triindonesia"/> 
        <meta name="twitter:site" content="@triindonesia"/> 
    </head>
    <body>
        <script>
            var url;
            setTimeout(continueExecution, 1000); 
            function continueExecution()
            {
               
                window.location.href = getMobileOperatingSystem();
            }
            
            function getMobileOperatingSystem() {
                <c:if test="${type == 'product'}">
                    return "${selfcareurl}/home-detail/${productid}/${productname}";
                </c:if>
                <c:if test="${type == 'sub_category'}">
                	return "${selfcareurl}/more/${categoryId}/${productid}/";
                </c:if>
                <c:if test="${type == 'profile'}">
                    return "${selfcareurl}/profile";
                </c:if>
                <c:if test="${type == 'category'}">
                    return "${selfcareurl}/${productid}/";
                </c:if>
                <c:if test="${type == 'reload'}">
                    return "${selfcareurl}/reload";
                </c:if>
                <c:if test="${type == 'settings'}">
                    return "${selfcareurl}/settings";
                </c:if>
                <c:if test="${type == 'bonstri'}">
                	return "http://bonstri.tri.co.id/nonmobile";
                </c:if>
                <c:if test="${type == 'ott'}">
                    return "${selfcareurl}/home-detail/${productid}/${productname}";
                </c:if>
                <c:if test="${type == 'notification'}">
                    return "${selfcareurl}/notification";
                </c:if>
                <c:if test="${type == 'leave'}">
                    return "${selfcareurl}/leave-msg";
                </c:if>
                <c:if test="${type == '3carechat'}">
                    return "${selfcareurl}/chat-care";
                </c:if>
            }
        </script>
    </body>
</html>