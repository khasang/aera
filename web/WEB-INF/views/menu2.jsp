<%-- Page with templates--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%-- includes css style --%>
<style>
   <%@include file='/WEB-INF/css/common.css'%>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
<title>Stories</title>
</head>
<!-- Makes request-string for storyController and returns  -->
<script type="text/javascript">
    var service = "/story";
    //get all stories
    $("p").click(function () {
        //alert("!!!");
        console.log("!!!");
    });
    var GetAllStories = function () {
        $.ajax({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                clear();
                $.each(result, function () {
                    var currentStory = this;
                    document.getElementById('response').innerHTML += buildStoryLink(currentStory);
                });
            },
            error: function (jgXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(igXHR))
            }
        });
        //cleans body 'response' before filling
        function clear() {
            document.getElementById('response').innerHTML = '';
        }

        //build link to current story and places it to 'response' div
        function buildStoryLink(currenStory) {
            var path = "/story/" + currenStory.id;
            var link = "<strong><a href='" + path + "'>" + currenStory.name + "</a></strong><br>";
            return link;
        }
    };
    // gets story by id
    var GetStoryById = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/getById/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                document.getElementById('content').innerHTML = buildChapterLink(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#content').html(JSON.stringify(jqXHR))
            }
        });
        function buildChapterLink(result) {
            var link = "";
            $.each(result.chapters, function () {
                var currentChapter = this;
                var chapterName = currentChapter.name;
                var chapterPrice = currentChapter.price;
                var link ="<h1>" + result.name + ":" + "</h1><br>"
                    + "<strong>" + currentChapter.name + " -- " + "</strong><br>";
            });
        }
    };

</script>
<body>
<%-- include header.jsp--%>
<%@include file='tmpl/header.jsp'%>
<%--- include menu_line.jsp --%>
<%@include file="tmpl/menu_line.jsp" %>
<%--- include content.jsp --%>
<%@include file="tmpl/content.jsp" %>
<%-- include footer.html --%>
<%@include file="tmpl/footer.jsp" %>
</body>
</html>