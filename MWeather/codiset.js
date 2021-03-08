$(document).ready(function () {
    $.ajax({
        url: 'http://localhost:8080/closet/codi',
        type: 'get',
        success: function (data) {

            var html = '<div class="container">';
            html += '<div class="row">';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'top\')" id="top" border="1">' + data[3].codiList + '<br>' + data[3].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'outer\')" id="outer" border="1">' + data[1].codiList + '<br>' + data[1].codiPho + '</td>' + '</div>';
            html += '<div class="w-100"></div>';
            html += '<tr>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'bottom\')" id="bottom" border="1">' + data[0].codiList + '<br>' + data[0].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'shoes\')" id="shoes" border="1">' + data[2].codiList + '<br>' + data[2].codiPho + '</td>' + '</div>';
            html += '</tr>';
            html += '</div>';
            html += '</div>';

            $('#codi').append(html);
        },
        error: function (e) {
            console.log("에러 발생 :" + e);
        }

    })

})

// 코디 세부 리스트 출력
function codiView(value) {

    $('#codi').remove();

    var html = '<table border="1" width="80%" height="auto">';
    html += '<tr>';
    for (i = 1; i < 4; i++) {
        html += '<td>' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70">' + '</td>';
    }
    html += '</tr>';
    html += '<tr>';
    for (i = 4; i < 7; i++) {
        html += '<td>' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70">' + '</td>';
    }
    html += '</div>';
    html += '</div>';
    $('#codiView').append(html);

}






