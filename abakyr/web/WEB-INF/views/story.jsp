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

    var RestPut = function () {
        var JSONObject = {
            "name": $('#putName').val(),
            "date": $('#putDate').val(),
            "storyChapters": [{"name": $('#chapter1PutName').val(), "goldPrice": $('#chapter1PutPrice').val()},
                {"name": $('#chapter2PutName').val(), "goldPrice": $('#chapter2PutPrice').val()}]
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

    var RestDelete = function () {
        var JSONObject = {
            'id': $('#deleteId').val(),
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

    var RestUpdate = function () {
        var JSONObject = {
            "id": $('#postId').val(),
            "name": $('#postName').val(),
            "date": $('#postDate').val(),
            "storyChapters":
                [{"id": $('#postIdChapter1').val(),"name": $('#chapter1Name').val(), "goldPrice": $('#chapter1Price').val()},
                {"id": $('#postIdChapter2').val(),"name": $('#chapter2Name').val(), "goldPrice": $('#chapter2Price').val()}]
        };
        $.ajax({
            type: 'PUT',
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
            Id:<br> <input id = "getStoryId" value=""/>
            <button type="button" onclick="RestGet($('#getStoryId').val())">Try</button>
        </td>
    </tr>
    <tr>
        <td>Get All Stories</td>
        <td><code><strong>GET</strong>/all</code></td>
        <td>
            <button type="button" onclick="RestGetAll()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Add story</td>
        <td><code><strong>PUT</strong>/story/add</code></td>
        <td>
            <form class="form-inline">
                name:<br> <input type="text" id="putName" value="storyName"/>
                <br>
                date:<br> <input type="date" id="putDate" value="storyDate"/>
                <br>
                chapters:<form method="post">
                    <br>
                    <input type="text" id="chapter1PutName" value="Chapter1Name"/>
                    <input type="text" id="chapter1PutPrice" value="Chapter1Price"/>
                    <br>
                    <input type="text" id="chapter2PutName" value="Chapter2Name"/>
                    <input type="text" id="chapter2PutPrice" value="Chapter2Price"/>
                </form>
                <button type="button" onclick="RestPut()">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete Story</td>
        <td><code><strong>DELETE</strong>/delete/story</code></td>
        <td>
            Id:<br> <input type="text", id="deleteId" value="storyId"/>
            <button type="button" onclick="RestDelete()">Try</button>
        </td>
    </tr>
    <tr>
        <td>Update Story</td>
        <td><code><strong>PUT</strong>/update/story</code></td>
        <td>
            <form class="form-inline">
                id:<br> <input type="text" id="postId" value=""/>
                <br>
                name:<br> <input type="text" id="postName" value="storyName"/>
                <br>
                date:<br> <input type="date" id="postDate" value="storyDate"/>
                <br>
                chapters:<form method="post">
                    <br>
                    <input type="text" id="postIdChapter1" value=""/>
                    <input type="text" id="chapter1Name" value="Chapter1Name"/>
                    <input type="text" id="chapter1Price" value="Chapter1Price"/>
                    <br>
                    <input type="text" id="postIdChapter2" value=""/>
                    <input type="text" id="chapter2Name" value="Chapter2Name"/>
                    <input type="text" id="chapter2Price" value="Chapter2Price"/>
                </form>
                <button type="button" onclick="RestUpdate()">Try</button>
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