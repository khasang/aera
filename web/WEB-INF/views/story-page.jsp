<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story</title>
</head>
<body>
    <h1>Story: ${story.name}</h1>
    <h3>Date modified: ${story.dateModified.toLocalDate()}</h3>
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
</body>
</html>
