// 회원 정보를 저장할 배열 선언
var users = [];

// js를 실행할 함수 선언 & html api storage 에 저장할 거 선언하기
window.onload = function () {

}


// 생성자 만들기 - 객체로 선언하지 말고 펑션으로...ㅡㅡ 잊지말것.
function User(name, bd, pnum, pw) {
    this.uname = name;
    this.bd = bd;
    this.pnum = pnum;
    this.pw = pw;

}





// 회원정보 저장
function save() {

    // 변수 선언
    var uname = document.getElementById('uname');
    var bd = document.getElementById('bd');
    var pnum = document.querySelector('#pnum');
    var pw = document.getElementById('pw');
    var repw = document.getElementById('pwchk');
    // 체크하기 위한 불리언
    var chk = false;

    // 유효성 검사 : 
    if (uname.value.trim().length < 1) {
        document.querySelector('#uname+div.msg').style.display = 'block';
        chk = true;
    }

    if (bd.value.trim().length < 1) {
        document.querySelector('#bd+div.msg').style.display = 'block';
        chk = true;
    }

    if (pnum.value.trim().length < 1) {
        document.querySelector('#pnum+div.msg').style.display = 'block';
        chk = true;
    }

    if (pw.value.trim().length < 1) {
        document.querySelector('#pw+div.msg').style.display = 'block';
        chk = true;
    }

    if (repw.value.trim().length < 1 || pw.value != repw.value) {
        document.querySelector('#pwchk+div.msg').style.display = 'block';
        chk = true;
    }

    // 만약 유효성 검사에서 걸려서 true가 되었다면 false반환해주어서 아무것도 실행시키지 않게 하기 위해.
    if (chk) {
        return false;
    }



    // 이벤트 리스너 : 공백문자가 들어온 후에 폼에 포커스 넣었을 때 초기화해주고, 오류메세지 안뜨게 해줌.
    uname.addEventListener('focus', function () {
        document.querySelector('#uname+div.msg').style.display = 'none';
        uname.value = '';
    })

    bd.addEventListener('focus', function () {
        document.querySelector('#bd+div.msg').style.display = 'none';
        bd.value = '';
    })

    pnum.addEventListener('focus', function () {
        document.querySelector('#pnum+div.msg').style.display = 'none';
        pnum.value = '';


    })

    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').style.display = 'none';
        pw.value = '';
    })

    repw.addEventListener('focus', function () {
        document.querySelector('#pwchk.div.msg').style.display = 'none';
        repw.value = '';
    })


    // 정보 담는 객체
    var user = new User(uname.value, bd.value, pnum.value, pw.value);



    // 배열에 저장
    users.push(user);

    // 저장되었나 찍어보기.
    console.log('users', users);

    // 담고 난 후 리셋
    document.querySelector('#saveform').reset();

    set();


    return false;
}


// 리스트 보여주기!
function set() {

    // tbody를 DOM 객체로 만들기
    var tbody = document.querySelector('#tbody');

    // 테이블 객체 만들기 : 여기를 다시 선언해준 이유는, 이 부분은 html로 만들었다고 해도 이 부분을 생략하고 for문으로 돌리면 위의 라벨 부분이 없어지고 바로 데이터가 들어옴. html부분에 주석을 달아주면 앞부분이 안보이다가 데이터가 들어오면 표시됨!!!
    var sidet = '<tr>';
    sidet += '<th>INDEX</th>';
    sidet += '<th>NAME</th>';
    sidet += '<th>B.DAY</th>';
    sidet += '<th>P.NUM</th>';
    sidet += '<th>PW</th>';
    sidet += '<th>EDIT</th>';
    sidet += '</tr>';


    //for문으로 안에 내용물 넣기
    for (var i = 0; i < users.length; i++) {
        sidet += '<tr>';
        sidet += '<th>'+i+'</th>';
        sidet += '<th>'+users[i].uname+'</th>';
        sidet += '<th>'+users[i].bd+'</th>';
        sidet += '<th>'+users[i].pnum+'</th>';
        sidet += '<th>'+users[i].pw+'</th>';
        sidet += '<th><a>MODIFY</a>'+'  '+'<a>DELETE</a></th>';
        sidet += '</tr>';
    }

    // sidet의 내용물을 tbody에 담아서 표시.
    tbody.innerHTML = sidet;


}


// 리스트에서 수정하는 거 만들기
function modi(){
    
}