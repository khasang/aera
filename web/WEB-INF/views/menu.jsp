<%--
  Just shows the Game menu
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/> -->
    <style>

        .header {
            widht: 200px;
            height: 60px;
            line-height: 30px;
            text-align: center;
            color: #ff9900;
            border: 1px dotted black;
        }

        .navigation {
            widht: 200px;
            height: 40px;
            line-height: 30px;
            text-align: left;
            text-indent: 20px;
            color: white;
            background-color: #4b4b4b;
            border: black 1px dotted;
        }

        .sidebar {
            widht: 600px;
            height: 300px;
            border: 1px dotted;
            float: left;
        }

        .content {
            widht: 200px;
            height: 300px;
            border: 1px dotted black;
            margin-left: 200px;
        }

        .footer {
            widht: 200px;
            height: 130px;
            border: 1px dotted black;
        }
    </style>
</head>
<!-- Makes request-string for storyController and returns  -->
<!-- get all stories  -->
<script type="text/javascript">
    var service = "/story";
    var GetAllStories = function () {
        $.ajax({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                result.forEach(function (item) {
                    document.getElementById('response').innerHTML += item.name + " -- " + item.description + "<br>";
                });
            },
            error: function (jgXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jgXHR))
            }
        });
    };

    // gets story by id
    var GetStoryById = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/story/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#content').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#content').html(JSON.stringify(jqXHR))
            }
        });
    };

    //add new story - put name
    var PutStoryName = function (client_name) {
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
                $('#content').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

</script>
<body>

<div class="header"><h1>AERA</h1></div>
<div class="navigation">
    <a style="color: white" href="javascript:void(0);"  onclick="GetAllStories();return false;">STORIES</a>
    Get Story by id <input type="text" id="story_id" value=""/>
    <button type="button" onclick="GetStoryById($('#story_id').val())">Try</button>
    Put Story name: <input type="text" id="putStoryName" value=""/>
    <button type="button" onclick="PutStoryName($('#putStoryName').val())">Try</button>
</div>
<div class="sidebar" widt="200" id="response">
</div>
<div class="content" id="content"></div>
<div class="footer"></div>

</body>
</html>