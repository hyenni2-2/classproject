// 회원 정보를 저장할 배열 선언
var users=[];

// js를 실행할 함수 선언 & html api storage 에 저장할 거 선언하기
window.onload = function(){
    
}


// 생성자 만들기 - 객체로 선언하지 말고 펑션으로...ㅡㅡ 잊지말것.
function User(name,bd,pnum,pw){
    this.uname=name;
    this.bd=bd;
    this.pnum=pnum;
    this.pw=pw;
    
}

// 입력내용 확인하는 함수
User.prototype.makeHtml=function(index){
    console.log(this.uname+' : '+this.bd+' : '+this.pnum+' : '+this.pw);
}

// 회원정보 저장
function save(){
    
    // 변수 선언
    var uname = document.getElementById('uname');
    var bd = document.getElementById('bd');
    var pnum = document.querySelector('#pnum');
    var pw = document.getElementById('pw');
    // 체크하기 위한 불리언
    var chk = true;
    
    // 유효성 검사
    if(uname.value.trim().length<1){
        
    }
    
    
    // 정보 담는 객체
    var user = new User(uname.value,bd.value,pnum.value,pw.value);
    
    // 배열에 저장
    users.push(user);
    
    
    return true;
}
