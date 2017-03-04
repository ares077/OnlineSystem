
function checkStudentpw() {
	var studentpw = $('#studentpw').val();
	if (studentpw == "") {
		$('#studentpw_msg').text("请填写密码");
		return;
	}
	$.post('student/checkStudentpw', {
		'studentpw' : studentpw
	}, function(data) {
		var infoStudentpw = data;
		$('#studentpw_msg').text(infoStudentpw.message);
	});
}

function checkStudentclass(){
	var classinfo = $('#classinfo').val();
	if (classinfo == "") {
		$('#classinfo_msg').text("请填写班级");
		return;
	}
	$.post('student/checkclassinfo', {
		'classinfo' : classinfo
	}, function(data) {
		var infoclassinfo = data;
		$('#classinfo_msg').text(infoclassinfo.message);
	});
}
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