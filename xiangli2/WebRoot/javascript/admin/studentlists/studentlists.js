function findPage() {
	var page = parseInt($('#whichPage').val());
	if (page == "") {
		alert("请输入页码");
		return;
	}
	if (isNaN(page)) {
		alert("请输入数字");
		$('#whichPage').val("");
		return;
	}
	var uri='student/studentlists?nowPage='+page;
	location.href=uri;
}
function findPage3() {
	var page = parseInt($('#whichPage').val());
	if (page == "") {
		alert("请输入页码");
		return;
	}
	if (isNaN(page)) {
		alert("请输入数字");
		$('#whichPage').val("");
		return;
	}
	var uri='note/notelists?nowPageN='+page;
	location.href=uri;
}

