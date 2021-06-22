function getImgPath(path) {
    let s = path.split("Easy_Car_Rent_Frontend");
    return s[1];
}

function uploadImage(data) {
    var result;
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/Easy_Car_Rent_Backend_war_exploded/file",
        processData: false,
        async: false,
        data: data,
        contentType: false,
        success: function (data) {
            result = data.data;
            console.log("result : " + result);
        }, error: function (data) {
            alert("File : " + data.data);
            result = data.data;
        }
    });
    return result;
}