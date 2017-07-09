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
            widht:600px;
            height: 60px;
            line-height: 30px;
            text-align: center;
            color: #ff9900;
            border: 1px dotted black;
        }
        .navigation{
            widht:600px;
            height: 40px;
            line-height: 30px;
            text-align: left;
            text-indent: 20px;
            color: white;
            background-color: #4b4b4b;
            border: black 1px dotted;
        }
        .sidebar{
            widht:200px;
            height: 300px;
            border: 1px dotted ;
            float: left;
        }
        .content{
            widht:370px;
            height: 300px;
            border: 1px dotted black;
            margin-left: 230px;
        }
        .sidebarHeader{
            widht:199px;
            height: 50px;
            border: 1px dotted black;
        }
        .footer{
            widht:600px;
            height: 130px;
            border: 1px dotted black;
        }
    </style>
</head>
<!-- Forms request-string for storyController and returns  -->
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
                console.log(item.name);
                clear();
                document.getElementById('response').innerHTML += item.name + "<br>";
                });
                //$('#response').html(JSON.stringify(result));
            },
            error: function (jgXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(igXHR))
            }
        });
    };
    //test empty request
    var EmptyRequest = function () {
        alert("!!!")
        $.ajax();
        alert("end")
    };

    function clear() {
        document.getElementById('response').innerHTML = '1';
    }
</script>
<body>

 <div class="header"><h1>AERA</h1></div>
 <div class="navigation" ><A style="color: white" HREF="javascript:void(0);" OnClick="Javascript:GetAllStories();return false;">QUESTS</a>
     <A style="color: white" HREF="javascript:void(0);" OnClick="Javascript:EmptyRequest();return false;">EmptyRequest</a>
 |Menu1 |Menu1 |Menu1
 </div>
 <div class="sidebar" widt="200" id="response">
     <%--<div class="sidebarHeader">

     </div>--%>
 </div>
 <div class="content" ></div>
 <div class="footer" ></div>
 <br>
<table>
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
            <button type="button" onclick="GetAllStories()">Try</button>
        </td>
    </tr>
</table>
 <div class =  ></div>
    <div id="response"></div>

</body>
</html>
