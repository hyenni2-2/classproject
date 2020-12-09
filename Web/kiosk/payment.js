// 결제창팝업

function payClick() {
    document.querySelector('#paystart').style.display = 'block';
    document.querySelector('.payment').style.display = 'block';
}



// 결제수단 고르기
function choosePay(index) {

    document.querySelector('#paystart').style.display = 'none';


    var payData = JSON.parse(payArr);
    var payHtml = '';

    console.log(payData[index]);

    // 결제세부창 띄우기
    document.querySelector('.payment').style.display = 'block';
    payHtml += '<div><table class="ptab2">';
    payHtml += '<tr><h2 class="title">결제</h2>';
    payHtml += '<hr align="center" width:95>';
    payHtml += '</tr>';
    payHtml += '<tbody class="tab2"><tr>';
    payHtml += '<td align="center"><img src="'
    payHtml += payData[index].img;
    payHtml += '" width="180" height="180"></td>';
    payHtml += ' </tr><tr align="center"><td>';
    payHtml += payData[index].name;
    payHtml += '</td>';
    payHtml += '</tr>';
    payHtml += '<tr align="center">';
    payHtml += '<td><img src="../load.gif" height="100" width="100"><td>';
    payHtml += ' </tr></tbody>';
    payHtml += '</table></div>';

    var payChk = document.querySelector('.payment');
    payChk.innerHTML = payHtml;

 

    // 2초 후 팝업창 끄고 실패창 부르기
    setTimeout(function () {
        document.querySelector('#payfail').style.display = 'block';
        

        // 실패창 닫는 메서드
        setTimeout(function () {
            document.querySelector('#payfail').style.display = 'none';
            document.querySelector('.payment').style.display = 'none';
        }, 2000);
    }, 2000);






}