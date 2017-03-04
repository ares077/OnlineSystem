var timer;
function startTimes(){
	timer=window.setInterval(showSeconds,1000);
}
var ii=120;
function showSeconds(){
	if(ii>0){
		ii--;
		var mi=ii/60;
	document.getElementById("mi").innerHTML=Math.floor(mi);
	document.getElementById("se").innerHTML=ii%60;
	}else{
		window.clearInterval(timer);
		Subm(true);
	}
}
function resetTimer(){
	if(timer!=null&&timer!=undefined){
		window.clearInterval(timer);
		Subm(true);
	}
}
addLoadEvent(startTimes);