<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chapter</title>
    <link rel="stylesheet" href="<c:url value="../../static/css/story_chapter-page.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Chapter: ${chapter.name}</h1>
    <h3>Date modified: ${chapter.dateModified}</h3>
    <h3>Price: ${chapter.goldPrice}$</h3>

    <div class="story-edit">
        <a href="<c:url value="/chapter/edit-chapter-${chapter.id}"/>" class="btn btn-info btn-lg">
            <span class="glyphicon glyphicon-edit"></span> Edit
        </a>
    </div>
</body>
</html>
