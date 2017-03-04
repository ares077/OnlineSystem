
function addInputCss(){
	var form1=document.getElementById("form1");
	var inputs=form1.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		var text=inputs[i].getAttribute("readonly");
		if(text=='readonly'){
			inputs[i].style.color='gray';
		}else{
			inputs[i].style.color='blue';
		}
	}
	var states=document.getElementById("states");
	states.style.color='red';
}
addLoadEvent(addInputCss);
function ison(){
	$('#isOn').val("1");
	var submit=document.getElementById("submit");
	submit.click();
}

function checkScore(){
	var sin = parseInt($('#singlecho').val());
	if (sin == "") {
		alert("请输入分数");
		return;
	}
	if (isNaN(sin)) {
		alert("请输入数字");
		$('#singlecho').val("");
		return;
	}
	if(sin<0){
		alert("请输入正确数字");
		$('#singlecho').val("");
		return;
	}
	var mul = parseInt($('#multicho').val());
	if (mul == "") {
		alert("请输入分数");
		return;
	}
	if (isNaN(mul)) {
		alert("请输入数字");
		$('#multicho').val("");
		return;
	}
		if(mul<0){
		alert("请输入正确数字");
		$('#singlecho').val("");
		return;
	}
		var form1=$('#form1');
		form1.submit();
}