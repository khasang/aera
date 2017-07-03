<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
    <form:form id="register-form" method="post" action="/user/register" modelAttribute="user">
        <div class="form-group required">
            <form:label path="login" cssClass="control-label">Login</form:label>
            <form:input path="login" cssClass="form-control" placeholder="Please enter you login" />
        </div>
        <div class="form-group required">
            <form:label path="firstname">Firstname</form:label>
            <form:input path="firstname" placeholder="Please enter you firstname" />
        </div >
        <div class="form-group">
            <form:label path="lastname">Lastname</form:label>
            <form:input path="lastname" placeholder="Please enter you lastname" />
        </div>
        <div class="form-group required">
            <form:label path="password">Password</form:label>
            <form:password path="password" placeholder="Please enter you password" />
        </div>
        <div class="form-group required">
            <label>Password</label>
            <input id="password-repeat" type="password" placeholder="Please enter you password again" />
        </div>
        <div class="form-group required">
            <form:label path="email">Email</form:label>
            <form:input path="email" placeholder="Please enter your email" />
        </div>
        <input type="submit" value="Register">
    </form:form>
</body>
</html>
