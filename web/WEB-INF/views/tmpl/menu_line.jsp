<%-- Content--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navigation">
    <a style="color: white" HREF="javascript:void(0);"
       OnClick="Javascript:GetAllStories();return false;">
        STORIES
    </a>
    Get Story by id <input type="text" id="storyId" value=""/>
    <button type="button" onclick="GetStoryById($('#storyId').val())">Try</button>
    Put Story name: <input type="text" id="putStoryName" value=""/>
    Description: <input type="text" id="putStoryDescription" value=""/>
    <button type="button" onclick="AddNewStory($('#putStoryName').val(),$('#putStoryDescription').val())">
        Try
    </button>
</div>