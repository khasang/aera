<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/RestUpdateFunction.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<script type="text/javascript">
    var service = '/story';
    var RestGet = function (id) {
        $.ajax ({
            type: 'GET',
            url: service + "/getById/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#responce').html(JSON.stringify(jqXHR))
            }
        });
    };
    var RestPut = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description,
            'date': new Date().getUTCDate(),
            'chapters': null
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#responce').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestUpdate = function () {
        var JSONObject = {
            'id': $('#storyId_update').val(),
            'name': $('#storyName_update').val(),
            'description': $('#storyDescription_update').val(),
            'date': new Date().getUTCDate(),
            'chapters': $('#chapters_update').val() == "" ? null : $('#chapters_update').val()
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


    var getAllStories = function () {
        $.ajax ({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#responce').html(JSON.stringify(jqXHR))
            }
        });
    }

    var deleteStoryById = function (id) {
        $.ajax ({
            type: 'DELETE',
            url: service + "/delete/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#responce').html(JSON.stringify(jqXHR))
            }
        });
    }
</script>


<body>
    <table class="table">
        <thead>
            <tr>
                <th>NAME</th>
                <th>PATH</th>
                <th>OPERATIONS</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Get Story by ID</td>
                <td><code><strong>GET</strong>/story/getById/{id}</code></td>
                <td>
                    Id: <input id = "getStoryId" value="">
                    <button type="button" onclick="RestGet($('#getStoryId').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get all Stories</td>
                <td><code><strong>GET</strong>/story/all</code></td>
                <td>
                    <button type="button" onclick="getAllStories()">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add story</td>
                <td><code><strong>PUT</strong>/story/add</code></td>
                <td>
                    <form class="form-inline">
                        name: <input type="text" id="addName" value="">
                        description: <input type="text" id="addDescription" value="">
                        <button type="button" onclick="RestPut(
                            $('#addName').val(),
                            $('#addDescription').val()
                        )">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Update story</td>
                <td><code><strong>POST</strong>/story/update</code></td>
                <td>
                    <form class="form-inline">
                        id: <input type="text" id="storyId_update" value=""><br/>
                        name: <input type="text" id="storyName_update" value=""><br/>
                        description: <input type="text" id="storyDescription_update" value=""><br/>
                        chapters: <input type="text" id="chapters_update" value=""><br/>
                        <button type="button" onclick="RestUpdate()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete Story by ID</td>
                <td><code><strong>DELETE</strong>/story/delete/{id}</code></td>
                <td>
                    Id: <input id = "deleteStoryId" value="">
                    <button type="button" onclick="deleteStoryById($('#deleteStoryId').val())">Try</button>
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
