var service = "/story";
//get all stories
var GetAllStories = function () {
    $.ajax({
        type: 'GET',
        url: service + "/all",
        dataType: 'json',
        async: false,
        success: function (result) {
            clear();
            result.forEach(function (item) {
                document.getElementById('response').innerHTML += buildStoryLink(item);
            });
        },
        error: function (jgXHR, textStatus, errorThrown) {
            $('#response').html(JSON.stringify(igXHR))
        }
    });
    //cleans body 'response' before filling
    function clear() {
        document.getElementById('response').innerHTML = ' ';
    }

    //build link to current story and places it to 'response' div
    function buildStoryLink(item) {
        var path = "/story/"+item.id;
        var link = "<a href='"+ path +"'>" + item.name + "</a><br>";
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
            document.getElementById('content').innerHTML="<h2>" + result.description +"</h2>";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $('#content').html(JSON.stringify(jqXHR))
        }
    });
};
//add new story with name and description
var AddNewStory = function (client_name,descr_name) {
    var JSONObject = {
        'name': client_name,
        'description': descr_name
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