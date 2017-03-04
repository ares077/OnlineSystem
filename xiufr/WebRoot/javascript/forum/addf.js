addLoadEvent(loadEve);
function loadEve(){
	var aujour= new Date();
	var mm=aujour.getMonth()+1;
	var jj=aujour.getDate();
	if(mm.toString().length==1){
		mm="0"+mm;
	}
	if(jj.toString().length==1){
		jj="0"+jj;
	}
	var formataujour=""+aujour.getFullYear()+mm+jj;
	$('#jour').val(formataujour);
}
function resetform(){
	$('#form1')[0].reset();
	loadEve();
}

function form1(){
	if(checktitle()&&checkcategory()&&check()){
	$('#form1').submit();
	}
}
function form2(){
	var title=$('#title').val();
	var category=$('#category').val();
	var content=$('#content').val();
	var lien=$('#lien').val();
	var postsid=$('#postsid').val();
	if(checktitle()&&checkcategory()&&check()){
		$.post('forum/modi.xiu', {
			'title' : title,
			'category':category,
			'content':content,
			'lien':lien,
			'postsid':postsid
		}, function(data) {
			if(data.flag=="modi"){
				alert('midi_réussi');
			}else{
				alert('falied');
			}
		});
	}
}
function effacer(){
	 var a=document.getElementById ("spa3mes");
    a.innerHTML = "";
}

function checktitle(){
	var mot = $('#title').val();
	if (mot.toString().length < 2) {
		alert('logeur de title insuffisante!');
		return false;
	} else {
		return true;
	}
}
function checkcategory(){
	var sensch = $('#category').val();
	if (sensch.toString().length < 1) {
		alert('choisissez une category!');
		return false;
	} else {
		return true;
	}
}
function check(){
	var content = $('#content').val();
	var lien = $('#lien').val();
	if (content.toString().length < 1 && lien.toString().length < 1) {
		alert('saisissez au moins de (content ou lien)!');
		return false;
	} else {
		return true;
	}
}