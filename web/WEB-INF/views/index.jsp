<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aera project</title>
</head>
<body>
<!--<a href="/user/register">Register new user</a>-->

<h1>Welcome to Aera!</h1>
<br>
<a href="<c:url value="/user/login" />">Login</a> |
<a href="<c:url value="/user/register" />">Register</a>
</body>
</html>
