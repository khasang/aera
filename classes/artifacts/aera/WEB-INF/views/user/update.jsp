<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Profile</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/user_register.css" />
</head>

<script type="text/javascript">
    var serviceUrl = "/user/update";

    function update() {
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
                window.scrollTo(0, 0);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                window.scrollTo(0, 0);
            }
        });
    }

</script>

<body>
<div class="wrap">
    <div class="container">
        <div class="alert"></div>
        <div class="form-group required">
            <label for="login" class="control-label">Login</label>
            <input id="login" class="form-control" placeholder="Please enter your new login"/>
            <div class="help-block"></div>
        </div>

        <div class="form-group required">
            <label for="firstname" class="control-label">Firstname</label>
            <input id="firstname" class="form-control" placeholder="Please enter your new First Name"/>
            <div class="help-block"></div>
        </div>

        <div class="form-group">
            <label for="lastname" class="control-label">Lastname</label>
            <input id="lastname" class="form-control" placeholder="Please enter your new Last Name"/>
            <div class="help-block"></div>
        </div>

        <div class="form-group required">
            <label for="password" class="control-label">Password</label>
            <input id="password" type="password" class="form-control" placeholder="Please enter your new password">
            <div class="help-block"></div>
        </div>

        <div class="form-group required">
            <label for="password-repeat" class="control-label">Repeat password</label>
            <input id="password-repeat" type="password" class="form-control" placeholder="Please enter your new password again">
            <div class="help-block"></div>
        </div>

        <div class="form-group required">
            <label for="email" class="control-label">Email</label>
            <input id="email" class="form-control" placeholder="Please enter your new email">
            <div class="help-block"></div>
        </div>

        <button class="btn btn-lg btn-success" onclick="update()">Update</button>
    </div>
</div>
</body>
</html>