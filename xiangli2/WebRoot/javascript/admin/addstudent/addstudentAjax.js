function checkStudentid() {
	var studentid = $('#studentid').val();
	if (studentid == "") {
		$('#studentid_msg').text("请填写学号");
		return;
	}
	$.post('student/checkStudentid', {
		'studentid' : studentid
	}, function(data) {
		var infoStudentid = data;
		$('#studentid_msg').text(infoStudentid.message);
	});
}
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