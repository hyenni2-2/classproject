// 드래그 할 아이템, 파일이름, 드래그한 아이템 배열
var item;
var i;

$(document).ready(function () {
    $.ajax({
        url: 'http://localhost:8080/closet/codi',
        type: 'get',
        success: function (data) {

            var html = '<div class="container">';
            html += '<div class="row">';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'top\')" id="top" style="border:1px solid;">' + data[3].codiList + '<br>' + data[3].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'outer\')" id="outer" style="border:1px solid;" >' + data[1].codiList + '<br>' + data[1].codiPho + '</td>' + '</div>';
            html += '<div class="w-100"></div>';
            html += '<tr>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'bottom\')" id="bottom" style="border:1px solid;">' + data[0].codiList + '<br>' + data[0].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'shoes\')" id="shoes" style="border:1px solid;">' + data[2].codiList + '<br>' + data[2].codiPho + '</td>' + '</div>';
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

    item = value;

    $('#codi').remove();
    
    var html = '<table border="1" width="80%" height="auto">';
    html += '<tr>';
    for (i = 1; i < 4; i++) {
        html += '<td>' +  '<div class="dragev" id="dragev'+item+i+'">' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70"  id="codiInfo'+item+i+'">' + '</div> </td>';
    }
    html += '</tr>';
    html += '<tr>';
    for (i = 4; i < 7; i++) {
        html += '<td>' + '<div class="dragev" id="dragev'+item+i+'">' +  '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70" id="codiInfo'+item+i+'" >' + '</div> </td>';
    }
    html += '</div>';
    html += '</div>';
    $('#codiView').append(html).css('cursor:move','z-index:2');
    
    $('#codiView').on('mouseenter', 'img', function(){
    // 드래그한 후 이미지 남겨두기 위한 helper
    $(this).draggable({
        helper:"clone"
    });

    // 드롭한 후에 이미지 남겨주기
    $('#codibg').droppable({
        accept: 'img',
        drop: function(e, ui){
             var newImg = $(ui.helper).clone().remove('img');
             newImg.draggable();
             $(this).append(newImg);
        }
    });

    })

}






