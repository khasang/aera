<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Story</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value="../../static/css/story_chapter-page.css"/>" rel="stylesheet"/>
</head>
<body>
    <div class="generic-container">
        <div class="well lead">Chapter Edit Form</div>
        <form:form method="post" modelAttribute="chapter" cssClass="form-horizontal">
            <form:input path="id" id="id" type="hidden"/>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-label" for="name">Chapter name</label>
                    <div class="col-md-7">
                        <form:input path="name" id="name" type="text" cssClass="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" cssClass="help-block"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-label" for="goldPrice">Gold price, in $</label>
                    <div class="col-md-7">
                        <form:input path="goldPrice" id="goldPrice" type="text" cssClass="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="goldPrice" cssClass="help-block"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group floatRight">
                    <c:if test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm" href="/">
                        or
                        <a href="<c:url value="/chapter/${chapter.id}"/>">Cancel</a>
                    </c:if>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
