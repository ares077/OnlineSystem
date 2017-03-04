function addInputCss() {
	var form1 = document.getElementById("form1");
	var inputs = form1.getElementsByTagName("input");
	for ( var i = 0; i < inputs.length; i++) {
		var text = inputs[i].getAttribute("readonly");
		if (text == 'readonly') {
			inputs[i].style.color = 'gray';
		} else {
			inputs[i].style.color = 'blue';
		}
	}
}
addLoadEvent(addInputCss);

function form1() {
	if(checkidnumber()&&checkphonum()&&checkemail()&&checknotice()&&checkanswer()){
		$('#form1').submit();
	}else{
		alert('Invalide infos');
	}
}
function checkidnumber() {
	var idnumber = $('#idnumber').val();
	if (idnumber.toString().match("\\d{18}")) {
		$('#idnumber_msg').text("V");
		return true;
	} else {
		$('#idnumber_msg').text("invalide");
		return false;
	}
}
function checkphonum() {
	var phonum = $('#phonum').val();
	if (phonum.toString().match("^[1][3,4,5,8][0-9]{9}$")) {
		$('#phonum_msg').text("V");
		return true;
	} else {
		$('#phonum_msg').text("invalide");
		return false;
	}
}
function checkemail() {
	var email = $('#email').val();
	if (email
			.toString()
			.match(
					"\\w{3,20}@(qq|hotmail|sina|yahoo|126|163|sohu|sogou)+\\.(com|org|cn|net|gov)")) {
		$('#email_msg').text("V");
		return true;
	} else {
		$('#email_msg').text("invalide");
		return false;
	}
}
function checknotice() {
	var notice = $('#notice').val();
	if (notice.toString().length > 3 && notice.toString().length < 30) {
		$('#notice_msg').text("V");
		return true;
	} else {
		$('#notice_msg').text("3<infos<30");
		return false;
	}
}
function checkanswer() {
	var answer = $('#answer').val();
	if (answer.toString().length > 3 && answer.toString().length < 30) {
		$('#answer_msg').text("V");
		return true;
	} else {
		$('#answer_msg').text("3<infos<30");
		return false;
	}
}