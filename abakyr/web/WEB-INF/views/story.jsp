<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using stories</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script type="text/javascript">
    var service = '/story';
    var RestGet = function (id) {
        $.ajax({
            type: "GET",
            url: service + "/get/story/" +id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestGetAll = function () {
        $.ajax({
            type: "GET",
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestPut = function (client_name, client_date) {
        var JSONObject = {
            'name': client_name,
            'date': client_date
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            processData: false,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestDelete = function (client_id) {
        var JSONObject = {
            'id': client_id
        };
        $.ajax({
            type: "DELETE",
            url: service + "/delete/story",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestUpdate = function (client_id, client_name, client_date) {
        var JSONObject = {
            'id': client_id,
            'name': client_name,
            'date': client_date
        };
        $.ajax({
            type: "PUT",
            url: service + "/update/story",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

</script>

<body>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    </thead>
    <tbody>
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
            <form class="form-inline">
                name: <input type="text" id="putName" value="storyName"/>
                date: <input type="date" id="putDate" value="storyDate"/>
                <button type="button" onclick="RestPut($('#putName, #putDate').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>All Stories</td>
        <td><code><strong>GET</strong>/all</code></td>
        <td>
            GET All: <p id="getAllStories" value=""></p>
            <button type="button" onclick="RestGetAll($('#getAllStories'))">Try</button>
        </td>
    </tr>
    <tr>
        <td>Delete Story</td>
        <td><code><strong>DELETE</strong>/delete/story</code></td>
        <td>
            Id: <input type="text", id="deleteId" value="storyId"/>
            <button type="button" onclick="RestDelete($('#deleteId').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Update Story</td>
        <td><code><<strong>PUT</strong>/update/story</code></td>
        <td>
            <form class="form-inline">
                id: <input type="number" id="updateId" value="storyId"/>
                name: <input type="text" id="updateName" value="storyName"/>
                date: <input type="date" id="updateDate" value="storyDate"/>
                <button type="button" onclick="RestUpdate($('#updateName, #updateDate, #updateId').val())">Try</button>
            </form>
        </td>
    </tr>
    </tbody>
</table>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
