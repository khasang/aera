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

    function clearForm() {
        $("#login").val("");
        $("#firstname").val("");
        $("#lastname").val("");
        $("#password").val("");
        $("#password-repeat").val("");
        $("#email").val("");
    }

    function update() {
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
                    $(".alert").addClass("alert-success");
                    $(".alert").html("User's profile has been successfuly updated!");
                    clearForm();
                    window.scrollTo(0, 0);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $(".alert").addClass("alert-danger");
                    $(".alert").html("An attempt to update user's profile failed!");
                    window.scrollTo(0, 0);
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