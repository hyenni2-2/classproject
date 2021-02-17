// 드래그 할 아이템, 파일이름, 이미지의 zidx, 드래그한 아이템 배열, 대분류 리스트를 담을 변수
var listItem;
var i;
var img_zidx = 0;
var dragList = [];
var viewlist;

// 잊지말고 펑션 다 짠 후에 document.ready로 호출하기 - 페이지가 열렸을 때 반드시 표시되어야 하는 것만 함수 호출
$(document).ready(function () {
    list();
    // bigCategory();
})

// 리스트 부르는 함수
function list() {
    // 아래 div들 다 끄기
    //  $('#codiView').css('display','none');
    // $('#codibg').css('display','none');
    $.ajax({
        url: '/closet/list',
        type: 'GET',
        success: function (listData) {
            viewlist = listData;
            var listhtml = '<table class="closetList" id="closetList">';
            listhtml += '<tr>';
            for (var i = 0; i < 3; i++) {
                listhtml += '<td> <div class="clist" id="clist'+i+'" onclick="viewclick('+i+')">' + i + '</div> <img src="http://localhost:8080/closet/image/icon/emptyheart.png" id="emptyheart">'+listData[i].likecnt +'</td>';
            }
            listhtml += '</tr>';
            listhtml += '<tr>';
            for (var i = 3; i < 6; i++) {
                listhtml += '<td> <div class="clist" id="clist'+i+'" onclick="viewclick('+i+')">' + i + '</div> <img src="http://localhost:8080/closet/image/icon/emptyheart.png" id="emptyheart">'+listData[i].likecnt +'</td>';
            }
            listhtml += '</tr>';
            listhtml += '<tr>';
            for (var i = 6; i < 9; i++) {
                listhtml += '<td> <div class="clist" id="clist'+i+'" onclick="viewclick('+i+')">' + i + '</div> <img src="http://localhost:8080/closet/image/icon/emptyheart.png" id="emptyheart" ">'+listData[i].likecnt +'</td>';
            }
            listhtml += '</tr>';
            listhtml += '</table>';
            $('.content').append(listhtml);
        },
        error: function (e) {
            console.log("에러 발생 : " + e);
        }
    })
}

// 대분류 호출하는 펑션
function bigCategory() {
    $.ajax({
        url: '/closet/codi',
        type: 'get',
        async: false,
        success: function (data) {
            var html = '<div class="bigCategory">';
            html += '<div class="row">';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'top\')" id="top" style="color:grey;">' + data[3].codiList + '<br>' + data[3].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'outer\')" id="outer" style="color:grey;" >' + data[1].codiList + '<br>' + data[1].codiPho + '</td>' + '</div>';
            html += '<div class="w-100"></div>';
            html += '<tr>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'bottom\')" id="bottom" style="color:grey;">' + data[0].codiList + '<br>' + data[0].codiPho + '</td>' + '</div>';
            html += '<div class="col-6 col-sm-3" onclick="codiView(\'shoes\')" id="shoes" style="color:grey;">' + data[2].codiList + '<br>' + data[2].codiPho + '</td>' + '</div>';
            html += '</tr>';
            html += '</div>';
            html += '</div>';
            $('.content').append(html);
        },
        error: function (e) {
            console.log("에러 발생 :" + e);
        }
    })
}

// 코디 세부 리스트 출력
function codiView(value) {
    $('.bigCategory').remove();

    listItem = value;

    var html = '<div class="codi" id="codi" name="codi">';
    html += '<table width="80%" height="auto" style="color:#FDF1AE;">';
    html += '<tr>';
    for (i = 1; i < 4; i++) {
        html += '<td class=' + i + '>' + '<div class="dragev" id="dragev' + listItem + i + '">' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70" id="codiInfo' + listItem + i + '">' + '</div> </td>';
    }
    html += '</tr>';
    html += '<tr>';
    for (i = 4; i < 7; i++) {
        html += '<td class=' + i + '>' + '<div class="dragev" id="dragev' + listItem + i + '">' + '<img src="http://localhost:8080/closet/image/codi/' + value + '/' + i + '.png" width="70" height="70" id="codiInfo' + listItem + i + '" >' + '</div> </td>';
    }
    html += '</tr>';
    html += '</table>';
    html += '</div>';
    html += '<div class="codicon" id="codicon" name="codicon">';
    html += '<img src="http://localhost:8080/closet/image/icon/back.png" id="codiback" onclick="backDrag()">';
    html += '<img src="http://localhost:8080/closet/image/icon/list.png" id="codilist" onclick="showList()">';
    html += '<img src="http://localhost:8080/closet/image/icon/save.png" id="codisave" onclick="saveDrag()">';
    html += '<img src="http://localhost:8080/closet/image/icon/reset.png" id="codireset" onclick="resetDrag()">';
    html += '</div>';
    html += '<div class="codibg" id="codibg" name="codibg"></div>';
    $('.content').append(html);

    // 이미지 드래그해서 끌어다놓고, x, y좌표 얻기
    $('#codi').on('mouseenter', 'img', function () {
        //드래그 시 clone 생성해서 이동
        $('#codi img').draggable({
            helper: 'clone',
            cursor: 'hand'
        });

        // 드롭될 때 발생하는 이벤트
        $('#codibg').droppable({
            activeClass: 'ui-state-hover',
            accept: 'img',
            containment: '#codibg',
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

    // 게시물 세부 페이지
    function viewclick(value){
        i=value;
        $('.closetList').remove();
        location.href = '/list/'+viewlist[i].cIdx;
        var viewhtml = '<h3>'+viewlist[i].name+'님의 옷장 </h3>';
        viewhtml += '<div class="closetView" id="closetView">'+i+'</div>';
        viewhtml += '<img src="http://localhost:8080/closet/image/icon/emptyheart.png" id="heartview">'+viewlist[i].likecnt;
        viewhtml += '<div class="closetText" id="closetText"> <h5>'+viewlist[i].text+'</h5> </div>';
        $('.content').append(viewhtml);
}




// 리셋하는 함수
function resetDrag() {
    if ($('#codibg').length > 0) {
        $('#codibg').empty();
        console.log('draglist' + dragList);
        dragList.clear();
    }
}

// 아이템 클릭 동작 뒤로가는(기존 아이템을 삭제하는)함수
function backDrag() {
    $('#codibg img').last().remove();
}

// 버튼 누르면 배열에 드래그 정보를 저장하는 이벤트:이미지경로, xy좌표, z-index
function saveDrag() {
    $('#codibg img').each(function (index, item) {
        var dragsrc = $(item).attr('src');
        var dragoffleft = $(item).offset().left;
        var dragofftop = $(item).offset().top;
        var dragoffzidx = $(item).css('z-index');
        // console.log('dragsrc:' + dragsrc, 'dragoffleft:' + dragoffleft, 'dragofftop:' + dragofftop, 'zIdx:' + dragoffzidx);
        dragList.push({ src: dragsrc, x: dragoffleft, y: dragofftop, z: dragoffzidx });
        // 배열 위치 확인
        // console.log('dragList:' + dragList.src + dragList.x + dragList.y + dragList.z);

    })
    console.log(dragList);

    if (dragList.length < 0) {
        alert('저장된 조합이 없습니다. 다시 시도해주세요.');
    }
    // 글쓰기 화면 보여주기 -> 세부 리스트 내용 비워주기
    $('#codi').remove();
    // 코디아이콘 디스플레이 없애기
    $('#codicon').remove();
    // 코디 드래거블 해제
    $('#codibg img').draggable({ disabled: true });
    $('#codibg').css('position', 'relative');
    $('#codibg').css('top', '10');
    // 텍스트에리어 만들어주기
    var cHtml = '<form action="POST" id="closetRegForm">';
    cHtml += '<div class="form-floating">';
    cHtml += '  <textarea class="form-control" placeholder="Leave a comment here" id="closetText" style="height: 100px"></textarea>';
    cHtml += '  <label for="floatingTextarea2"></label>';
    cHtml += '</div>';
    cHtml += '<button type="button" class="btn btn-light" id="savebuttn">SAVE</button>';
    cHtml += '</div>';
    $('.content').append(cHtml);

    // 이미지 리스트 넘겨주는 ajax
    $('#savebuttn').on('click', function () {
        // db로 보내주기 위한 객체
        var img = {
            memIdx: memIdx,
            name: cName,
            photo: dragList,
            text: $('#closetText').val()
        };
        console.log(img);
        // 배열 JSON으로 변환
        var jsonDrag = JSON.stringify(img);
        console.log('json : ' + jsonDrag);
        console.log('jsonDrag length:' + jsonDrag.length);
        $.ajax({
            url: '/closet/write',
            type: 'POST',
            dataType: 'JSON',
            data: jsonDrag,
            contentType: 'application/json; charset=utf-8',
            success: function (jsonDrag) {
                // 성공 시 jsonDrag 콘솔에 찍기
                console.log('jsonDrag:' + jsonDrag);
            },
            error: function (e) {
                console.log('에러' + e);
            }
        })

    })
}

// 리스트로 돌아가는 함수
function showList() {
    // 코디div 비우기
    $('#codi').remove();
    // 코디아이콘 css none
    $('#codicon').css('display', 'none');
    // 대분류리스트 부르기
    bigCategory();
}

