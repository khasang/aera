<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>

<h1>Welcome!</h1>
<p>UserName: <strong>${user.firstname}</strong></p>
<p>UserLastName: <strong>${user.lastname}</strong></p>
<p>UserEmail: <strong>${user.email}</strong></p>
<br>
<p><a href="<c:url value="/user/update" />">Update</a></p>
</body>
</html>
