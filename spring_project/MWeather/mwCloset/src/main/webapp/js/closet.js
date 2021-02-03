
	
$(document).ready(function(){
    $.ajax({
        url:'http://localhost:8080/closet/list',
        type:'GET',
        success:function(data){
            for(var i=0; i<data.length; i++){
                var html = '<div class="col">';
                html += '<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">';
                html += '<title>Placeholder</title>';
                //html += '<rect width="100%" height="100%" fill="#55595c"/>'+data[i].cPhotoOut+'<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>';
                html += '<rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">'+data[i].cphotoOut+'</text></svg>';
                html += '<div class="card-body">';
                html += '<div class="d-flex justify-content-between align-items-center">';
                html += '<div class="btn-group">';
                html += '<button type="button" class="btn btn-sm btn-outline-secondary">좋아요'+data[i].clikeCnt+'</button>';
                html += '<button type="button" class="btn btn-sm btn-outline-secondary">북마크'+data[i].cbmkCnt+'</button>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                html += '</div>';
                
                $('#content').append(html);
            }
        },
        error : function(e){
            console.log("에러 발생 : " + e);
        }
    })
})

