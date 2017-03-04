function resetform(){
	$('#form1')[0].reset();
	loadEve();
}

function form1(){	
	if(checkmot()&&checkdecli()&&checksensch()){

		
			$('#form1').submit();

	}
}
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

function checkmot(){
	var mot = $('#mot').val();
	if (mot.toString().length < 2) {
		alert('logeur de mot insuffisante!');
		return false;
	} else {
		return true;
	}
}
function checksensch(){
	var sensch = $('#sensch').val();
	if (sensch.toString().length < 2) {
		alert('logeur de sensch insuffisante!');
		return false;
	} else {
		return true;
	}
}
function checkdecli(){
	var declinaison = $('#declinaison').val();
	if (declinaison.toString().length < 1) {
		alert('choisissez une declinaison!');
		return false;
	} else {
		return true;
	}
}

function isexist(){
	var mot=$('#mot').val();
	if(mot.toString().length<2){
		return;
	}
	$.post('mot/isexist.xiu', {
		'mot' : mot
	}, function(data) {
		if(data.flag=="exist"){
			$('#canadd').val("non");
			alert('mot déjà déposé!');		
		}else{
			$('#canadd').val("oui");
		}
	});
}

	
