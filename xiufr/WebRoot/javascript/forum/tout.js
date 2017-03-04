function relistparlimit(intpage){
	var page;
	if(intpage==1){
		page=1;
	}else if(intpage==-1){
		page=999999;
	}else if(intpage==-2){
		page=parseInt($('#nowPageforum').text())+1;
	}else if(intpage==-3){
		page=parseInt($('#nowPageforum').text())-1;
	}else{
		page=intpage;
	}
	var title=$('#title').val();
	var category=$('#category').val();
	var author=$('#author').val();
	var uri='forum/forummain.xiu?nowPageforum='+page+'&title='+title+'&category='+category+'&author='+author;
	location.href=uri;
}
function cleantitle(){
	$('#title').val('');
}
function cleanauthor(){
	$('#author').val('');
}
function resettout(){
	cleantitle();
	cleanauthor();
	$('#category').val('');
}
addLoadEvent(loadEve);
function loadEve(){
	
}