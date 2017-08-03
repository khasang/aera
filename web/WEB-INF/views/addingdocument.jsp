<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring MVC - Hibernate File Upload to Database Demo</title>
</head>
<body>
<div align="center">
    <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
    <form method="post" action="doUpload" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Pick file #1:</td>
                <td><input type="file" name="fileToUpload" size="50" /></td>
            </tr>
            <%--<tr>
                <td>Pick file #2:</td>
                <td><input type="file" name="fileToUpload" size="50" /></td>
            </tr>--%>

            <tr>
                <td colspan="1" align="center"><input type="submit" value="Upload" /></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
