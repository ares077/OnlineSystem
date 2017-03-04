function findPage3() {
	var page = parseInt($('#whichPage').val());
	if (page == "") {
		alert("Pas de page");
		return;
	}
	if (isNaN(page)) {
		alert("Numéro invalide");
		$('#whichPage').val("");
		return;
	}
	var uri='note/notelist.xiu?nowPage='+page;
	location.href=uri;
}
function findPage2() {
	var page = parseInt($('#whichPage').val());
	if (page == "") {
		alert("Pas de page");
		return;
	}
	if (isNaN(page)) {
		alert("Numéro invalide");
		$('#whichPage').val("");
		return;
	}
	var cid=$('#courseid').val();
	var uri='note/notelist2.xiu?nowPage2='+page+'&&courseid='+cid;
	location.href=uri;
}
function Page1(){
	var page=1;
	var cid=$('#courseid').val();
	var uri='note/notelist2.xiu?nowPage2='+page+'&&courseid='+cid;
	location.href=uri;
}
function prePage(){
	var page=parseInt($('#nowPage2').text())-1;
	var cid=$('#courseid').val();
	var uri='note/notelist2.xiu?nowPage2='+page+'&&courseid='+cid;
	location.href=uri;
}
function nextPage(){
	var page=parseInt($('#nowPage2').text())+1;
	var cid=$('#courseid').val();
	var uri='note/notelist2.xiu?nowPage2='+page+'&&courseid='+cid;
	location.href=uri;
}
function endPage(){
	var page=2147483647;
	var cid=$('#courseid').val();
	var uri='note/notelist2.xiu?nowPage2='+page+'&&courseid='+cid;
	location.href=uri;
}