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
        <P> 
            GET_ALL_TRACK = "/tracks";<br>
            GET_TRACK = "/tracks/{id}";<br>
            CREATE_TRACK = "/tracks/create";<br>
            DELETE_TRACK = "/tracks/delete/{id}";<br>
            UPDATE_TRACK = "/tracks/update/{id}"; 
        </P>
        
        <P>
            <b>User registration related:</b> <br>
            
            Create users; Get all users = "/users";<br>
                Temporarily json parameters in order for test: email,password,confirmPassword
                     respond: 0 failed; 1 successful

        </P> 
            
        
    </body>
</html>
