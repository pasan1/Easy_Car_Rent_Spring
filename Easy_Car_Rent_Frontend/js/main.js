function getImgPath(path) {
    let s = path.split("Easy_Car_Rent_Frontend");
    return s[1];
}

function uploadImage(data) {
    let result;
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/Easy_Car_Rent_Backend_war_exploded/file",
        processData: false,
        async: true,
        data: data,
        contentType: false,
        success: function (data) {
            console.log(data.data);
            $.session.set("imgPath", data.data);
            result = data.data;

        }, error: function (data) {
            alert("File : " + data.data);
            $.session.set("imgPath", "");
            result = data.data;
        }
    });
    return result;
}