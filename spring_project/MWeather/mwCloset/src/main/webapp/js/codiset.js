// 드래그 할 아이템, 파일이름, 이미지의 zidx, 드래그한 아이템 배열, 대분류 리스트를 담을 변수
var listItem;
var cIdx;
var img_zidx = 0;
var dragList = [];
var page = 1;
var likeChk;


// 잊지말고 펑션 다 짠 후에 document.ready로 호출하기 - 페이지가 열렸을 때 반드시 표시되어야 하는 것만 함수 호출
$(document).ready(function () {
    list(page);
    //bigCategory();
})

window.onscroll = function(e){
    var view = $('.closetList');
    if(view) {
         //window height + window scrollY 값이 document height보다 클 경우,
         if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
                list(page);
                page++;
    }
}
 }

//    console.log(listData.closetList);
// var noonmool = JSON.parse(listData.closetList[9].cphoto);
// console.log('제이슨:',noonmool);
// console.log('제이슨:',noonmool[0].src);
// var listphoto = (listData.closetList[9].cphoto[0]);
// console.log('리스트'+listphoto);
// 3으로 나눠서 나머지가 0일때, 열만들기 

// 리스트 부르는 함수
function list(page) {
    $.ajax({
        url: '/closet/list/' + page,
        type: 'GET',
        success: function (listData) {
            // 데이터가 들어왔을 때
            console.log(listData.closetList.length);
            if (listData.closetList.length > 0) {
                var listhtml = '<table class="closetList" id="closetList">';
                for (var i = 0; i < listData.closetList.length; i++) {
                    if ((i == 0) || (i % 3 == 0)) {
                        listhtml += '<tr>';
                    }
                    listhtml += '<td> <div class="clist" id="clist' + i + '"onclick="viewclick(' + listData.closetList[i].cidx + ')">' + listData.closetList[i].ctext + '</div>';
                    // 좋아요 클릭 여부에 따른 하트 변화 = 내 좋아요 카운트 기준
                    if(listData.closetList[i].myLikeCnt==0){
                        listhtml += '<img src="http://localhost:8080/closet/image/icon/emptyheart.png" onclick="clickLike(' + listData.closetList[i].cidx + ',' +1+ ')" id="emptyheart">' + listData.closetList[i].clikecnt + '</td>';
                    } else {
                        listhtml += '<img src="http://localhost:8080/closet/image/icon/heart.png" onclick="clickLike(' + listData.closetList[i].cidx + ',' +2+ ')" id="emptyheart">' + listData.closetList[i].clikecnt + '</td>';
                    }
                    if ((i == 2) || (i % 3 == 2)) {
                        listhtml += '</tr>';
                    }
                }
                listhtml += '</table>';
            }
            $('.closet').append(listhtml);
        },
        error: function (e) {
            console.log("에러 발생 : " + e);
        }
    })
}


// 게시물 세부 페이지
function viewclick(cIdx) {
    console.log('자스:' + cIdx);
    console.log('멤버:' + memIdx);
    // 리스트 페이지 비우기
    $('.closet').empty();
    // 세부페이지 호출하기
    $.ajax({
        url: '/closet/list/view/' + cIdx,
        type: 'GET',
        success: function (viewData) {
            var viewhtml = '<h3>' + viewData.name + '님의 옷장 </h3>';
            viewhtml += '<div class="closetView" id="closetView">' + viewData.cphoto + '</div>';
            viewhtml += '<input type=hidden id="memIdx" name="memIdx" value="' + viewData.memIdx + '">';
            viewhtml += '<div class="viewbtns">';
            // 좋아요 하트 클릭 유무에 따른 다른 이미지 보여주기
            if(viewData.myLikeCnt==0){
                viewhtml += '<img src="http://localhost:8080/closet/image/icon/emptyheart.png" id="heartview'+cIdx+'" onclick="clickLike(' + cIdx + ','+1+')">'+viewData.clikecnt;
            } else {
                viewhtml += '<img src="http://localhost:8080/closet/image/icon/heart.png" id="heartview'+cIdx+'" onclick="clickLike(' + cIdx + ','+2+')">'+viewData.clikecnt;
            }
            // memIdx가 현재 로그인한 사람과 같을 경우 삭제,편집 페이지 보여주기
            if (viewData.memIdx == memIdx) {
                viewhtml += '<button type="button" class="btn btn-light" id="del" onclick="del(' + cIdx + ')">삭제</button>';
                viewhtml += '<button type="button" class="btn btn-light" id="edit" onclick="edit(' + cIdx + ')">수정</button>';
            }
            // 삭제, 편집 페이지 종료
            viewhtml += '</div>';
            viewhtml += '<div class="closetText" id="closetText"> <h5>' + viewData.ctext + '</h5> </div>';
            $('.closet').append(viewhtml);
        },
        error:function(e){
            console.log('에러'+e);
        }

    })
}


// 좋아요 늘려주는 카운트(likeChk=1:등록, 2:삭제)
function clickLike(cIdx, likeChk) {
    if(likeChk==1){
        $('#emptyheart'+cIdx).attr('src','http://localhost:8080/closet/image/icon/heart.png');
        redirect();
    } else {
        $('#emptyheart'+cIdx).attr('src','http://localhost:8080/closet/image/icon/emptyheart.png');
        redirect();
    }
    var like = {
        memIdx:memIdx,
        cidx:cIdx,
        likeChk: likeChk
    };
    $.ajax({
        url: '/closet/list/like',
        type: 'post',
        data:like,
        success: function (data) {
            console.log('데이터값'+data);
        }, 
        error: function(e){
            console.log('에러:'+e);
        }
    })
}

// 좋아요 빼주는 기능
function delLike(){

}


//  수정하기
function edit(cIdx) {
    $('.closet').empty();
    console.log(cIdx);
    // 수정 폼 만들어주기 -> ajax로 수정
    var edithtml = '<div class="editCloset" id="editCloset">' + viewlist.closetList[i].cphoto + '</div>';
    edithtml += '';
    edithtml += '<div class="form-floating" id="editText">';
    edithtml += ' <form action="POST" id="closetEditForm">';
    edithtml += '<input type=hidden id="cIdx" name="cIdx" value="' + cIdx + '">';
    edithtml += '  <textarea class="form-control" id="closetEditText" style="height: 100px">' + viewlist.closetList[i].ctext + '</textarea>';
    edithtml += '  <label for="floatingTextarea2"></label>';
    edithtml += '</div>';
    edithtml += '<button type="button" class="btn btn-light" id="editView" onclick="editCall(' + cIdx + ')">수정</button>';
    edithtml += '<button type="button" class="btn btn-light" id="edit" onclick="redirect()">취소</button>';
    $('.closet').append(edithtml);

}

// 수정 ajax 호출
function editCall(cIdx) {
    console.log('게시물번호:' + cIdx);
    var edit = {
        cIdx: cIdx,
        ctext: $('#closetEditText').val()
    };
    var editData = JSON.stringify(edit);
    $.ajax({
        url: '/closet/edit',
        type: 'POST',
        dataType: 'JSON',
        data: editData,
        contentType: 'application/json; charset=utf-8',
        success: function (editData) {
            console.log('수정데이터:' + editData);
            alert('수정완료');
            redirect();
        },
        error: function (e) {
            console.log('에러') + e;
        }
    })
}

// 페이지 뒤로 가기
function redirect() {
    $('.closet').empty();
    list(page);
}

// // 삭제하기
function del(cIdx) {
    var delConfirm = confirm('정말로 삭제하시겠습니까?');
    if (delConfirm) {
        $.ajax({
            url: '/closet/delete/' + cIdx,
            type: 'GET',
            success: function (delData) {
                alert('삭제되었습니다.');
                $('.closet').empty();
                list(page);
            }, error: function (e) {
                console.log("에러 발생" + e);
            }
        })
    }
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
            $('.closet').append(html);
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
    $('.closet').append(html);

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
    cHtml += '  <textarea class="form-control" id="closetText" style="height: 100px"></textarea>';
    cHtml += '  <label for="floatingTextarea2"></label>';
    cHtml += '</div>';
    cHtml += '<button type="button" class="btn btn-light" id="savebuttn">SAVE</button>';
    cHtml += '</div>';
    $('.closet').append(cHtml);

    // 이미지 리스트 넘겨주는 ajax
    $('#savebuttn').on('click', function () {
        // db로 보내주기 위한 객체
        var img = {
            cidx: cIdx,
            memIdx: memIdx,
            name: cName,
            cphoto: dragList,
            ctext: $('#closetText').val()
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

