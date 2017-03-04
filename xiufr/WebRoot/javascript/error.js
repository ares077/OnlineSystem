

var timer;
function startTimes(){
	timer=window.setInterval(showSeconds,1000);
}
var ii=5;
function showSeconds(){
	if(ii>0){
		ii--;
	document.getElementById("seconds").innerHTML=ii;
	}else{
		window.clearInterval(timer);
		location.href="loginfr.jsp";
	}
}
function resetTimer(){
	if(timer!=null&&timer!=undefined){
		window.clearInterval(timer);
		location.href="loginfr.jsp";
	}
}
addLoadEvent(startTimes);


