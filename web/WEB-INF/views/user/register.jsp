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
    
    function validatePasswordsEqual() {
        var password = $("#password").val();
        var password_repeat = $("#password-repeat").val();

        if (password != password_repeat) {
            $("#password").parent().addClass("has-error");
            $("#password").parent().children(".help-block").html("Passwords are not equals");
            $("#password-repeat").parent().addClass("has-error");
            $("#password-repeat").parent().children(".help-block").html("Passwords are not equals");
            return false;
        }
        else {
            $("#password").parent().removeClass("has-error");
            $("#password-repeat").parent().removeClass("has-error");
            return true;
        }
    }

    function validateRequiredField(field) {
        if (field.val() == "") {
            field.parent().addClass("has-error");
            field.parent().children(".help-block").html("Attribute can not be blank");
            return false;
        }
        else {
            field.parent().removeClass("has-error");
            return true;
        }
    }

    function validateRequiredFields() {
        if (!validateRequiredField($("#login")))
            return false;
        if (!validateRequiredField($("#firstname")))
            return false;
        if (!validateRequiredField($("#password")))
            return false;
        if (!validateRequiredField($("#password-repeat")))
            return false;
        if (!validateRequiredField($("#email")))
            return false;
        return true;
    }

    function validateForm() {
        if (!validateRequiredFields())
            return false;
        if (!validatePasswordsEqual())
            return false;
        return true;
    }

    // Send ajax create user request
    function create() {
        if (validateForm()) {
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

    jQuery(document).ready(function () {
        $("#login").on("blur", function () {
            validateRequiredField($(this));
        });
        $("#firstname").on("blur", function () {
            validateRequiredField($(this));
        });
        $("#password").on("blur", function () {
            if (validateRequiredField($(this)))
                validatePasswordsEqual();
        });
        $("#password-repeat").on("blur", function () {
            if (validateRequiredField($(this)))
                validatePasswordsEqual();
        });
        $("#email").on("blur", function () {
            validateRequiredField($(this));
        });
    })

</script>

<body>
    <div class="wrap">
        <div class="container">
            <div class="form-group required">
                <label for="login" class="control-label">Login</label>
                <input id="login" class="form-control" placeholder="Please enter you login">
                <div class="help-block"></div>
            </div>

            <div class="form-group required">
                <label for="firstname" class="control-label">Firstname</label>
                <input id="firstname" class="form-control" placeholder="Please enter you firstname">
                <div class="help-block"></div>
            </div>

            <div class="form-group">
                <label for="lastname" class="control-label">Lastname</label>
                <input id="lastname" class="form-control" placeholder="Please enter you lastname">
                <div class="help-block"></div>
            </div>

            <div class="form-group required">
                <label for="password" class="control-label">Password</label>
                <input id="password" type="password" class="form-control" placeholder="Please enter you password">
                <div class="help-block"></div>
            </div>

            <div class="form-group required">
                <label for="password-repeat" class="control-label">Repeat password</label>
                <input id="password-repeat" type="password" class="form-control" placeholder="Please enter you password again">
                <div class="help-block"></div>
            </div>

            <div class="form-group required">
                <label for="email" class="control-label">Email</label>
                <input id="email" class="form-control" placeholder="Please enter you email">
                <div class="help-block"></div>
            </div>

            <button class="btn btn-lg btn-success" onclick="create()">Create</button>
        </div>
    </div>
</body>
</html>
