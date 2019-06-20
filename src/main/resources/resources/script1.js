window.onload = function(){
    //ввод имени программиста
    document.querySelector("#searchProger").onclick = function(){               
        var search = document.querySelector("input[name = search]").value; 
        var name = document.querySelector("#search").value;  
        document.querySelector('#title').innerHTML = "Список проэктов программиста " + name;         
        var param = "search=" + search;    
        ajaxPostProger(param);
        }
}
//вызывается при поиске программиста
function ajaxPostProger(param){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        document.querySelector('#output').innerHTML = request.responseText;
        }
    request.open("POST", "app.java");
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send(param);
    }