$(document).ready(function(){
    $.ajax({
        url:'http://localhost:8080/closet/codi',
        type:'get',
        success:function(data){
            
                var html = '<div class="container">';
                html += '<div class="row">';
                html += '<div class="col-6 col-sm-3" id="top" border="1">'+data[3].codiList+'<br>'+ '<img src="http://localhost:8080/closet/image/codi/1.png" width="100" height="100">'+'</td>'+'</div>';
                html += '<div class="col-6 col-sm-3" id="outer" border="1">'+data[1].codiList+'<br>'+'<img src="http://localhost:8080/closet/image/codi/2.png" width="100" height="100">'+'</td>'+'</div>';
                html += '<div class="w-100"></div>';
                html += '<tr>';
              html += '<div class="col-6 col-sm-3" id="bottom" border="1">'+data[0].codiList+'<br>'+'<img src="http://localhost:8080/closet/image/codi/3.png" width="100" height="100">'+'</td>'+'</div>';
              html += '<div class="col-6 col-sm-3" id="shoes" border="1">'+data[2].codiList+'<br>'+'<img src="http://localhost:8080/closet/image/codi/4.png" width="100" height="100">'+'</td>'+'</div>';
              html += '</tr>';
                 html += '</div>';
                html += '</div>';
                
                $('#codi').append(html);
            },
        error:function(e){
            console.log("에러 발생 :"+e);
        }

    })
    
})





// top 세부 리스트 출력
function codiView(){

    $('#top').on("click", function () {
        
        $('#codi').remove();
    
        var html = '<table border="1" width="80%">';
        html += '<tr>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/1.png" width="30" height="30">'+'</td>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/2.png" width="30" height="30">'+'</td>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/3.png" width="30" height="30">'+'</td>';
        html += '</tr>';
        html += '<tr>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/4.png" width="30" height="30">'+'</td>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/5.png" width="30" height="30">'+'</td>';
        html += '<td>'+'<img src="http://localhost:8080/closet/image/codi/top/6.png" width="30" height="30">'+'</td>';
        html += '</tr>';
        html += '</table>';
        html += '</div>';
    
        var codiView = document.querySelector(".codiView");
        console.log(codiView);
        codiView.innerHTML=html;

})

}




