<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/user_register.css" />
</head>

<script type="text/javascript">
    /*var serviceUrl = "/user/login";

    var Login = function () {
        var JSONObject = {
            "login": $('#login').val(),
            "password": $('#password').val()
        };
        $.ajax({
            type: 'PUT',
            url: serviceUrl,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $(".alert").addClass("alert-success");
                $(".alert").html("User successfuly logged!");
                window.scrollTo(0, 0);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $(".alert").addClass("alert-danger");
                $(".alert").html("Login failed!");
                window.scrollTo(0, 0);
            }
        });
    };*/

</script>

<body>

<div class="wrap">
    <div class="container">
        <form name="f" action="/user/login" method="POST">
        <div class="alert"></div>
        <div class="form-group required">
            <label for="login" class="control-label">Login</label>
            <input name="login" id="login" class="form-control" placeholder="Please enter you login">
            <div class="help-block"></div>
        </div>

        <div class="form-group required">
            <label for="password" class="control-label">Password</label>
            <input name="password" id="password" type="password" class="form-control" placeholder="Please enter you password">
            <div class="help-block"></div>
        </div>
        <input name="submit" type="submit" value="Log in">
        </form>
    </div>
</div>
</body>
</html>
