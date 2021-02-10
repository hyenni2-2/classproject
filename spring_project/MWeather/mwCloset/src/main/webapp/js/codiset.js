// 드래그 할 아이템, 파일이름, 이미지의 zidx, 드래그한 아이템 배열
var listItem;
var i;
var img_zidx = 0;
var dragList = [];

// 잊지말고 펑션 다 짠 후에 document.ready로 호출하기 - 페이지가 열렸을 때 반드시 표시되어야 하는 것만 함수 호출
$(document).ready(function(){
    bigCategory();
})

// 대분류 호출하는 펑션
function bigCategory(){
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
}

// 코디 세부 리스트 출력
function codiView(value) {
    listItem = value;
    $('#codi').remove();
    $('#codicon').css('display','block');

    var html = '<table border="1" width="80%" height="auto">';
    html += '<tr>';
    for (i = 1; i < 4; i++) {
        html += '<td class=' + i + '>' + '<div class="dragev" id="dragev' + listItem + i + '">' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70" id="codiInfo' + listItem + i + '">' + '</div> </td>';
    }
    html += '</tr>';
    html += '<tr>';
    for (i = 4; i < 7; i++) {
        html += '<td class=' + i + '>' + '<div class="dragev" id="dragev' + listItem + i + '">' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70" id="codiInfo' + listItem + i + '" >' + '</div> </td>';
    }
    html += '</div>';
    html += '</div>';
    $('#codiView').append(html).css('cursor:move');

     // 이미지 드래그해서 끌어다놓고, x, y좌표 얻기
     $('#codiView').on('mouseenter', 'img', function () {
        //드래그 시 clone 생성해서 이동
        $('#codiView img').draggable({
            helper: 'clone',
            cursor: 'hand'
        });
    
        // 드롭될 때 발생하는 이벤트
        $('#codibg').droppable({
            activeClass: 'ui-state-hover',
            accept: 'img',
            drop: function (e, ui) {
                if (!ui.draggable.hasClass('dropped'))
                    $(this).append($(ui.draggable).clone().addClass('dropped').draggable());
            }
        });
    
        // 이미지 클릭하면 항상 위로 오게 만들기
        $('img').mousedown(function () {
            $(this).css('z-index', img_zidx);
            img_zidx++;
        })
    })
}

 // 리셋하는 함수
 function resetDrag(){
    if($('#codibg').length > 0){
        $('#codibg').empty();
    }
}

// 버튼 누르면 배열에 드래그 정보를 저장하는 이벤트:이미지경로, xy좌표, z-index
function saveDrag() {
    $('#codibg img').each(function (index, item) {
        var dragsrc = $(item).attr('src');
        var dragoffleft = $(item).offset().left;
        var dragofftop = $(item).offset().top;
        var dragoffzidx = $(item).css('z-index');
        console.log('dragsrc:' + dragsrc, 'dragoffleft:' + dragoffleft, 'dragofftop:' + dragofftop, 'zIdx:'+dragoffzidx);
        dragList.push(dragsrc, dragoffleft, dragofftop, dragoffzidx);
        console.log('dragList:' + dragList);

        // 배열 JSON으로 변환
        var jsonDrag = JSON.stringify(dragList); 
        console.log('json : ' + jsonDrag);
    
      })
       // 글쓰기 화면 보여주기 -> 세부 리스트 내용 비워주기
       $('#codiView').remove();
       // 코디아이콘 디스플레이 없애기
       $('#codicon').css('display','none');

       
       var cHtml = '<form action="POST" id="closetRegForm">';
       cHtml += '<textarea name="closetWrite" id="closetWrite" rows="10" cols="20">';
       cHtml += '</textarea><br>';
       cHtml += '<button type="button" class="btn btn-light">SAVE</button>';
       cHtml += '</div>';
       

       $('#closetReg').append(cHtml);
}











// // 드래그한 후 이미지 남겨두기 위한 helper
// $(this).draggable({
//     helper:"clone"
// });

// console.log(this);

// // 드롭한 후에 이미지 남겨주기
// $('#codibg').droppable({
//     accept: 'img',
//     drop: function(e, ui){
//          var newImg = $(ui.helper).clone().remove('img');
//          newImg.draggable();
//          $(this).append(newImg);
//     }
// });

// })




    // // 이미지 드래그해서 끌어다놓고, x, y좌표 얻기
    // $('#codiView').on('mouseenter', 'img', function () {
    //     //드래그 시 clone 생성해서 이동
    //     $(this).draggable({
    //         helper: 'clone',
    //         cursor: 'hand',
    //         // 드래그 종료 시 xy좌표 얻는 함수
    //         stop: function () {
    //             var offset = $(this).offset();
    //             var xPos = offset.left;
    //             var yPos = offset.top;
    //             console.log('xPos:' + xPos);
    //             console.log('yPos:' + yPos);
    //             // dragList 배열에 경로와 xy좌표 넣기
    //             dragList.push(this.src, xPos, yPos);
    //             console.log('dragList:' + dragList);

    //         }
    //     });

    //     console.log('img 정보:' + this.src);
    //     var tdClass = this.src.substr((this.src.length-5), 1);
    //     console.log(tdClass);
    //     console.log('.'+tdClass);




    //     // 드롭한 후에 이미지 남겨주기
    //     $('#codibg').droppable({
    //         activeClass: 'ui-state-hover',
    //         accept: 'img',
    //         drop: function (e, ui) {
    //             var newImg = $(ui.helper).clone().offset({left:0,top:0});
    //             console.log('newImg:' + newImg)
    //             newImg.append('.'+tdClass);


    //         }




