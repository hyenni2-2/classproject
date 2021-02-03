$(document).ready(function(){
    $.ajax({
        url:'http://localhost:8080/closet/codi',
        type:'get',
        success:function(data){
            
                var html = '<div class="container">';
                html += '<div class="row">';
                html += '<div class="col-6 col-sm-3">'+data[0].codiList+'<br>'+data[0].codiPho+'</td>'+'</div>';
                html += '<div class="col-6 col-sm-3">'+data[1].codiList+'<br>'+data[1].codiPho+'</td>'+'</div>';
                html += '<div class="w-100"></div>';
              html += '<div class="col-6 col-sm-3">'+data[2].codiList+'<br>'+data[2].codiPho+'</td>'+'</div>';
              html += '<div class="col-6 col-sm-3">'+data[3].codiList+'<br>'+data[3].codiPho+'</td>'+'</div>';
                 html += '</div>';
                html += '</div>';
                
                $('#codi').append(html);
            },
        error:function(e){
            console.log("에러 발생 :"+e);
        }

    })
    
})

