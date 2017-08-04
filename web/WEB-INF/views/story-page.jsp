<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story</title>
    <link rel="stylesheet" href="<c:url value="../../static/css/story-page.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    body{
        background-image: <c:choose>
            <c:when test="${empty story.backgroundImage.documentId}">
                url("<c:url value="../../static/images/background.jpg"/>");
            </c:when>
            <c:otherwise>
                url("<c:url value="/show-document-${story.id}-${story.backgroundImage.documentId}"/>")
            </c:otherwise>
        </c:choose>;
        background-repeat: repeat;
        background-position: center bottom;
        position: relative;
        width: 100%;
    }
</style>
<body>
    <div class="generic-container">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Story: ${story.name}</span></div>
            <div class="table-container">
                <table>
                    <thead>
                    <tr>
                        <td>Chapter name</td>
                        <td>Chapter price</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${story.chapters}" var="chapter">
                        <tr>
                            <td>
                                <a href="/chapter/${chapter.id}"><c:out value="${chapter.name}"/></a>
                            </td>
                            <td><c:out value="${chapter.goldPrice}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="story-edit">
            <p>Edit icon as a link:
                <a href="<c:url value="/story/edit-story-${story.id}"/>">
                    <span class="glyphicon glyphicon-edit"></span>
                </a>
            </p>
        </div>
    </div>
</body>
</html>
