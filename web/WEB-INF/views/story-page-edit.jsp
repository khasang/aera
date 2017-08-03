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
    <link href="<c:url value="../../static/css/app.css"/>">
</head>
<body>
    <div class="generic-container">
        <div class="well lead">Story Edit Form</div>
        <form:form method="post" modelAttribute="story" cssClass="form-horizontal">
            <form:input path="id" id="id" type="hidden"/>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-label" for="name">Story name</label>
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
                    <label class="col-md-3 control-label" for="description">Story description</label>
                    <div class="col-md-7">
                        <form:input path="description" id="description" type="text" cssClass="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="description" cssClass="help-block"/>
                        </div>
                    </div>
                </div>
            </div>

            <%--<div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-label" for="backgroundImage">Story background</label>
                        <form:input path="backgroundImage.content" type="file" id="backgroundImage" cssClass="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="backgroundImage.content" cssClass="help-block"/>
                        </div>
                    <div class="col-md-7">

                    </div>
                </div>
            </div>--%>
            <%--<div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-label">Story background</label>
                    <form method="post" action="/doUpload" enctype="multipart/form-data">
                        <tr>
                            <td>Pick file #1:</td>
                            <td><input type="file" name="fileToUpload" size="50" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                        </tr>
                    </form>
                    <div class="col-md-7">

                    </div>
                </div>
            </div>--%>

            <div class="row">
                <div class="form-actions floatRight">
                    <c:if test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"> or <a href="/story/${story.id}">Cancel</a>
                    </c:if>
                </div>
            </div>
        </form:form>


        <div id="backgroundImage">
            <div class="">
                <img id="backgroundImg" class="img-responsive img-rounded" width="320" height="180"
                        <c:choose>
                            <c:when test="${empty story.backgroundImage.documentId}">
                                src="<c:url value="../../static/images/background.jpg"/>"
                            </c:when>
                            <c:otherwise>
                                src="<c:url value="/show-document-${story.id}-${story.backgroundImage.documentId}"/>"
                            </c:otherwise>
                        </c:choose>
                />
            </div>

            <div>
                <label>Select background image</label>
                <div>
                    <form method="post" action="/doUpload-${story.id}" enctype="multipart/form-data">
                        <tr>
                            <td>Pick file:</td>
                            <td><input type="file" name="fileToUpload" size="50" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                        </tr>
                    </form>
                </div>

                <div class="btn btn-danger">
                    <button onclick="<c:url value="/remove-document-${story.id}-${story.backgroundImage.documentId}"/>"
                            <c:if test="${empty story.backgroundImage.documentId}">
                                style="display: none"
                            </c:if>
                    >Remove customer's image</button>

                    <a href="<c:url value="/remove-document-${story.id}-${story.backgroundImage.documentId}"/>"
                       class="btn btn-info btn-lg"
                            <c:if test="${empty story.backgroundImage.documentId}">
                                style="display: none"
                            </c:if>>
                        <span class="glyphicon glyphicon-remove"></span> Remove
                    </a>

                    <button type="button" class="btn btn-default btn-sm"
                            onclick="<c:url value="/remove-document-${story.id}-${story.backgroundImage.documentId}"/>"
                            <c:if test="${empty story.backgroundImage.documentId}">
                                style="display: none"
                            </c:if>>
                        <span class="glyphicon glyphicon-remove"></span> Remove
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
