function restStoryUpdate (id, name, dateCreated, chapters, imageBackground) {
    var JSONObject = {
        'id': id,
        'name': name,
        'dateCreated': dateCreated,
        'chapters': chapters,
        'imageBackground': imageBackground
    };
    $.ajax({
        type: 'POST',
        utl: '/story/update',
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
    })
};