<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/user_register.css" />
</head>

<script type="text/javascript">
    var serviceUrl = "/user/register";

    // Validate user data
    function validate() {
        return true;
    }

    // Send ajax create user request
    function create() {
        if (validate()) {
            var user = {
                login: $("#login").val(),
                firstname: $("#firstname").val(),
                lastname: $("#lastname").val(),
                password: $("#password").val(),
                email: $("#email").val()
            };

            $.ajax({
                url: serviceUrl,
                type: "PUT",
                contentType: 'application/json;charset=utf-8',
                dataType: "json",
                data: JSON.stringify(user),
                async: false,
                success: function (result) {
                    //
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    //
                }
            });
        }
    }
</script>

<body>
    <div class="wrap">
        <div class="container">
            <div class="form-group required">
                <label for="login" class="control-label">Login</label>
                <input id="login" class="form-control" placeholder="Please enter you login">
            </div>

            <div class="form-group required">
                <label for="firstname" class="control-label">Firstname</label>
                <input id="firstname" class="form-control" placeholder="Please enter you firstname">
            </div>

            <div class="form-group">
                <label for="lastname" class="control-label">Lastname</label>
                <input id="lastname" class="form-control" placeholder="Please enter you lastname">
            </div>

            <div class="form-group required">
                <label for="password" class="control-label">Password</label>
                <input id="password" type="password" class="form-control" placeholder="Please enter you password">
            </div>

            <div class="form-group required">
                <label for="password-repeat" class="control-label">Repeat password</label>
                <input id="password-repeat" type="password" class="form-control" placeholder="Please enter you password again">
            </div>

            <div class="form-group required">
                <label for="email" class="control-label">Email</label>
                <input id="email" class="form-control" placeholder="Please enter you email">
            </div>

            <button class="btn btn-lg btn-success" onclick="create()">Create</button>
        </div>
    </div>
</body>
</html>
