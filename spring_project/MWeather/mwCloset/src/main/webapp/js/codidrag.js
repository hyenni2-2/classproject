function drag(ev){
    console.log('drag start')
    ev.dataTransfer.setData("test", ev.target.id);
}

function drop(ev){
    ev.preventDefault();
    var data = ev.dataTransfer.getData("test");
    ev.target.appendChild(document.getElementById(data));
}

function allowDrop(ev){
    ev.preventDefault();
}

