window.onload = function(){
    //ввод данных о проэкте
    document.querySelector("#send").onclick = function(){               
    var a = document.querySelector("input[name = a]").value;
    var b = document.querySelector("input[name = b]").value;
    var c = document.querySelector("input[name = c]").value;
    var d = document.querySelector("input[name = d]").value;
    var e = document.querySelector("input[name = e]").value;    
    var param = "a=" + a + "&" + "b=" + b + "&" + "c=" + c + "&" + "d=" + d + "&" + "e=" + e;    
    ajaxPost(param);
    }    
}
//вызывается при вводе нового проэкта
function ajaxPost(param){
var request = new XMLHttpRequest();
request.onreadystatechange = function(){
    document.querySelector('#result').innerHTML = request.responseText;
    }
request.open("POST", "app.java");
request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
request.send(param);
} 
