<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Type personage for Story</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/type_personage';

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
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/" + id,
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

    var RestPut = function (client_name) {
        var JSONObject = {
            'name': client_name
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

    var RestUpdate = function () {
        var JSONObject = {
            "id": $('#postId').val(),
            "name": $('#postName').val(),
            "chapter": $('#postPersonage').val()
        };
        $.ajax({
            type: 'POST',
            url: service + "/update",
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


    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + "/delete/" + id,
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
            <td>GET all type personage</td>
            <td><code><strong>GET</strong>/type_personage/all</code></td>
            <td>
                <button type="button" onclick="RestGetAll()">Try</button>
            </td>
        </tr>
        <tr>
            <td>GET type personage by ID</td>
            <td><code><strong>GET</strong>/type_personage/get/{id}</code></td>
            <td>
                Id: <input id = "getTypePersonId" value=""/>
                <button type="button" onclick="RestGet($('#getTypePersonId').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>ADD type personage </td>
            <td><code><strong>PUT</strong>/type_personage/add</code></td>
            <td>
                <form class="form-inline">
                    name: <input type="text" id="putName" value=""/>
                    <button type="button" onclick="RestPut($('#putName').val())">Try</button>
                </form>
            </td>
        </tr>
        <tr>
            <td>UPDATE type personage</td>
            <td><code><strong>POST</strong>/type_personage/update</code></td>
            <td>
                <form class="form-inline">
                    id: <input type="text" id="postId" value=""/>
                    <br>
                    name: <input type="text" id="postName" value=""/>
                    <br>
                    chapter: <input type="text" id="postPersonage" value=""/>
                    <button type="button" onclick="RestUpdate()">Try</button>
                </form>
            </td>
        </tr>
        <tr>
            <td>DELETE type personage by ID</td>
            <td><code><strong>GET</strong>/type_personage/delete/{id}</code></td>
            <td>
                Id: <input id = "deleteTypePersonId" value=""/>
                <button type="button" onclick="RestDelete($('#deleteTypePersonId').val())">Try</button>
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
