var service = '/story';
var RestGet = function (id) {
    $.ajax({
        type: 'GET',
        url: service + "/get/story/" + id,
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