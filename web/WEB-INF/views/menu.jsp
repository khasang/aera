<%@ taglib prefix="h" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="../../static/js/menu.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="../../static/css/menu.css"/>"/>
</head>

<body>
<div class="header"><h1>AERA</h1></div>
<div class="navigation">
    <a style="color: white" HREF="javascript:void(0);"
       OnClick="Javascript:GetAllStories();return false;">
        STORIES
    </a>
    Get Story by id <input type="text" id="storyId" value=""/>
    <button type="button" onclick="GetStoryById($('#storyId').val())">Try</button>
    Put Story name: <input type="text" id="putStoryName" value=""/>
    Description: <input type="text" id="putStoryDescription" value=""/>
    <button type="button" onclick="AddNewStory($('#putStoryName').val(),$('#putStoryDescription').val())">
        Try</button>
</div>
<div class="sidebar" id="response">
</div>
<div class="content" id="content"></div>
<div class="footer"></div>

</body>
</html>