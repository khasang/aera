<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List usages</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
                $('#response').html(JSON.stringify(jgXHR))
            }
        });
    };

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jgXHR))
            }
        });
    };


    var RestPut = function (client_name) {
        var JSONObject = {
            "name": client_name
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jgXHR))
            }

        });
    };

    var RestUpdate = function () {
        var JSONObject = {
            'id': $('#postId').val(),
            'name': $('#postName').val(),
            'chapter': $('#postChapter').val()
        };
        $.ajax({
            type: 'POST',
            url: service + "/update",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jgXHR))
            }

        });
    };


</script>
<body>
<table class="table>">


    <tr>
        <th>id</th>
        <th>NAME</th>
    </tr>
    <tr>
        <td>GET Story by ID</td>
        <td><code><strong>GET</strong>/get/story/{id}</code></td>
        <td>
            Id: <input id="getStoryId" value=""/>
            <button type="button" onclick="RestGet($('#getStoryId').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Get all story</td>
        <td><code><strong>Get</strong>/story/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add story</td>
        <td><code><strong>PUT</strong>/story/add</code></td>
        <td>
            <form class="form-inline">
                name:<input type="text" id="putName" value="-"/>
                <button type="button" onclick="RestPut($('#putName').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update story</td>
        <td><code><strong>POST</strong>/story/update</code></td>
        <td>
            <form class="form-inline">
                id:<input type="text" id="postId" value=""/>
                <br>
                name:<input type="text" id="postName" value=""/>
                <br>
                chapter:<input type="text" id="postChapter" value=""/>

                <button type="button" onclick="RestUpdate()">Try</button>
            </form>
        </td>
    </tr>


</table>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response">

    </div>
</div>
</body>
</html>
