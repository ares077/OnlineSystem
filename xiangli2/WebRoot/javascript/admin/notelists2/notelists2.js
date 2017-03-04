
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
	var sid=$('#studentid').val();
	var uri='note/notelists2?nowPN='+page+'&&studentid='+sid;
	location.href=uri;
}

function Page1(){
	var page=1;
	var sid=$('#studentid').val();
   var uri='note/notelists2?nowPN='+page+'&&studentid='+sid;
	location.href=uri;
}
function prePage(){
	var page=parseInt($('#nowPN').text())-1;
	var sid=$('#studentid').val();
   var uri='note/notelists2?nowPN='+page+'&&studentid='+sid;
	location.href=uri;
}
function nextPage(){
	var page=parseInt($('#nowPN').text())+1;
	var sid=$('#studentid').val();
   var uri='note/notelists2?nowPN='+page+'&&studentid='+sid;
	location.href=uri;
}
function endPage(){
	var page=2147483647;
	var sid=$('#studentid').val();
   var uri='note/notelists2?nowPN='+page+'&&studentid='+sid;
	location.href=uri;
}