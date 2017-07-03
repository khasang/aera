<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = "/story"
    var RestGet = function (id) {
        $.ajax({
                type: 'GET',
                url: service + "/get/story/" + id,
                dataType: 'json',
                async: false,
                success: function (result) {
                    $('#response').html(JSON.stringify(result));
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR))
                } 
        });

    }
</script>

<body>

</body>
</html>
