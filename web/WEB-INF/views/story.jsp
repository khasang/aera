<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List usages</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/story';
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
    };

    var RestPut = function (client_name, client_age) {
        var JSONObject = {
            'name': client_name,
            'age': client_age
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>

<body>
    <table class="table">
        <thead/>
        <tr>
            <th>ID</th>
            <th>NAME</th>
        </tr>
        <thead/>
        <tr>
            <td>GET Story by ID</td>
            <td><code><strong>GET</strong>/get/story/{id}</code></td>
            <td>
                Id: <input id = "getStoryId" value=""/>
                <button type="button" onclick="RestGet($('#getStoryId').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>Add story</td>
            <td><code><strong>PUT</strong>/story/add</code></td>
            <td>
                <form class="form-select-button">
                    name: <input type="text" id="putName" value="storyName"/>
                </form>
                <form class="form-inline">
                    age: <input type="number" id="putAge" value="99"/>
                    <button type="button" onclick="RestPut($('#putName').val(), ($('#putAge').val()))">Try</button>
                </form>
            </td>
        </tr>
    </table>

    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
    </div>
</body>
</html>
