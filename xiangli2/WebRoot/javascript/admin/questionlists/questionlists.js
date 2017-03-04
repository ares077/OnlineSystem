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
	var uri='question/questionlists?nowPageQ='+page;
	location.href=uri;
}
function findPage2() {
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
	var paperid=$('#paperid').val();
	var type=$('#type').val();
	var level=$('#level').val();
	var key=$('#key').val();
	var uri='question/questionlists2?nowPageQ2='+page+'&paperid='+paperid+'&type='+type+'&level='+level+'&key='+key;
	location.href=uri;
}
function Page1(){
	var page=1;
	var paperid=$('#paperid').val();
	var type=$('#type').val();
	var level=$('#level').val();
	var key=$('#key').val();
	var uri='question/questionlists2?nowPageQ2='+page+'&paperid='+paperid+'&type='+type+'&level='+level+'&key='+key;
	location.href=uri;
}
function prePage(){
	var page=parseInt($('#nowPageQ2').text())-1;
	var paperid=$('#paperid').val();
	var type=$('#type').val();
	var level=$('#level').val();
	var key=$('#key').val();
	var uri='question/questionlists2?nowPageQ2='+page+'&paperid='+paperid+'&type='+type+'&level='+level+'&key='+key;
	location.href=uri;
}
function nextPage(){
	var page=parseInt($('#nowPageQ2').text())+1;
	var paperid=$('#paperid').val();
	var type=$('#type').val();
	var level=$('#level').val();
	var key=$('#key').val();
	var uri='question/questionlists2?nowPageQ2='+page+'&paperid='+paperid+'&type='+type+'&level='+level+'&key='+key;
	location.href=uri;
}
function endPage(){
	var page=2147483647;
	var paperid=$('#paperid').val();
	var type=$('#type').val();
	var level=$('#level').val();
	var key=$('#key').val();
	var uri='question/questionlists2?nowPageQ2='+page+'&paperid='+paperid+'&type='+type+'&level='+level+'&key='+key;
	location.href=uri;
}
