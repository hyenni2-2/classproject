function draw(){
    var img = new Image();
    img.addEventListener("load",function(){
        var ctx = document.getElementById('testCanvas').getContext('2d');
        ctx.drawImage(img, 50, 50);
    });
    
    img.src="mwCloset/codi2/bottom/1.png";
}