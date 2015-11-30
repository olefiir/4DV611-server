<%-- 
    Document   : tpsuser
    Created on : Nov 29, 2015, 3:33:41 PM
    Author     : Nils
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User list!</h1>
        <table>
            <tr>
                <th>ID</th><th>Email</th>
                <c:forEach var="tpsuser" items="${users}">
                    <tr>
                        <td>
                            <c:out value="${tpsuser.getUserid()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${tpsuser.getUserEmail()}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>
