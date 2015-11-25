<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>
            Welcome to 4DV611-server!  
        </h1>
        Main requests:<br><br>
        <P>  GET_ALL_PROD = "/products";<br>
            GET_PROD = "/products/{id}";<br>
            CREATE_PROD = "/products/create";<br>
            DELETE_PROD = "/products/delete/{id}";<br>
            UPDATE_PROD = "/products/update/{id}";<br>

            GET_ALL_TRACK = "/tracks";<br>
            GET_TRACK = "/tracks/{id}";<br>
            CREATE_TRACK = "/tracks/create";<br>
            DELETE_TRACK = "/tracks/delete/{id}";<br>
            UPDATE_TRACK = "/tracks/update/{id}"; </P>
    </body>
</html>
