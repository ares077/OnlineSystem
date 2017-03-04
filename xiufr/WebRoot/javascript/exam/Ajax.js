
function showName() {
	var courseid = $('#courseid').val();
	if (courseid == 'nul') {
		$('#cname').val("");
		$('#pname').val("");
		return false;
	}
	$.post('exload/cname.xiu', {
		'courseid' : courseid
	}, function(data) {
		var info = data;
		$('#cname').val(info.cname);
	});
}
function showpName() {
	var paperid = $('#paperid').val();
	if (paperid == 'nul') {
		$('#pname').val("");
		return false;
	}
	$.post('exload/pname.xiu', {
		'paperid' : paperid
	}, function(data) {
		var info = data;
		$('#pname').val(info.pname);
	});
}
function showPid() {
	var courseid = $('#courseid').val();
	if (courseid == 'nul') {
		$('#cname').val("");
		var selectm = document.getElementById('paperid');
		while (selectm.childNodes.length > 0) {
			selectm.removeChild(selectm.lastChild);
		}
		var option = document.createElement("option");
		option.value = "nul";
		option.innerHTML = "Choisir cours";
		selectm.appendChild(option);
		return false;
	}
	$.post('exload/pid.xiu', {
		'courseid' : courseid
	}, function(data) {
		var info = data;
		var selectm = document.getElementById('paperid');
		while (selectm.childNodes.length > 0) {
			selectm.removeChild(selectm.lastChild);
		}
		var option = document.createElement("option");
		option.value = "nul";
		option.innerHTML = "Choisir cours";
		selectm.appendChild(option);
		for ( var i = 0; i < info.length; i++) {
			var opt = document.createElement("option");
			opt.value = info[i].paperid;
			opt.innerHTML = info[i].paperid;
			selectm.appendChild(opt);
		}
	});
}
function sub() {
	$('#msg').text('');
	var studentid=$('#studentid').val();
	var courseid = $('#courseid').val();
	var paperid = $('#paperid').val();
	if (courseid == 'nul' || paperid == 'nul') {
		$('#msg').text('invalide infos');
		return false;
	} else {
		//$('#form1').submit();
		 window.open("http://localhost:8080/xiu/exam/exam.xiu?courseid=" + courseid + "&paperid=" + paperid +"&studentid="+studentid,"_blank","toolpar=no");
	}
}
