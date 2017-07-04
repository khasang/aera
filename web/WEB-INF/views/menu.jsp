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

        .header{
            widht:200px;
            height: 60px;
            line-height: 30px;
            text-align: center;
            color: #ff9900;
            border: 1px dotted black;
        }
        .navigation{
            widht:200px;
            height: 40px;
            line-height: 30px;
            text-align: left;
            text-indent: 20px;
            color: white;
            background-color: #4b4b4b;
            border: black 1px dotted;
        }
        .sidebar{
            widht:600px;
            height: 300px;
            border: 1px dotted ;
            float: left;
        }
        .content{
            widht:200px;
            height: 300px;
            border: 1px dotted black;
            margin-left: 200px;
        }

        .footer{
            widht:200px;
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
            success: function(result){
                result.forEach(function (item) {
                //console.log(item.name);

                   // document.getElementById('response')
                    //this.innerHTML = ' ';
                    document.getElementById('response').innerHTML += item.name +" -- " + item.description + "<br>";

                });
                //$('#response').html(JSON.stringify(result));
            },
            error: function (jgXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(igXHR))
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
               // document.getElementById('content').innerHTML = result.name;
                console.log("!!!");
                //console.log(result.description);
                $('#content').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#content').html(JSON.stringify(jqXHR))
            }
        });
    };
        //put story name
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
 <div class="navigation" ><A style="color: white" HREF="javascript:void(0);" OnClick="Javascript:GetAllStories();return false;">STORIES</a>
     Get Story by id <input type="text" id="putName" value=""/>
     <button type="button" onclick="GetStoryById($('#putName').val())">Try</button>
     Put Story name: <input type="text" id="ptName" value=""/>
     <button type="button" onclick="PutStoryName($('#ptName').val())">Try</button>
 </div>
 <div class="sidebar" widt="200" id="response">
     <%--<div class="sidebarHeader">

     </div>--%>
 </div>
 <div class="content" id="content" ></div>
 <div class="footer" ></div>

</body>
</html>