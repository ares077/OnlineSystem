function relistparlimit(intpage){
	var page;
	if(intpage==1){
		page=1;
	}else if(intpage==-1){
		page=999999;
	}else if(intpage==-2){
		page=parseInt($('#nowPageparlimit').text())+1;
	}else if(intpage==-3){
		page=parseInt($('#nowPageparlimit').text())-1;
	}else{
		page=intpage;
	}
	var mot=$('#mot').val();
	var declinaison=$('#declinaison').val();
	var aaaa=$('#aaaa').val();
	var mm=$('#mm').val();
	var jj=$('#jj').val();
	var uri='motre/relistparlimit.xiu?nowPageparlimit='+page+'&mot='+mot+'&declinaison='+declinaison+'&aaaa='+aaaa+'&mm='+mm+'&jj='+jj;
	location.href=uri;
}
function hier(){
	var aujour= new Date();
	var aaaa=aujour.getFullYear();
	var mm=(aujour.getMonth()+1);
	var jj=(aujour.getDate()-1);
	if(mm.toString().length==1){
		mm="0"+mm;
	}
	$('#aaaa').val(aaaa);
	$('#mm').val(mm);
	$('#jj').val(jj);
}
function resettout(){
	$('#aaaa').val('');
	$('#mm').val('');
	$('#jj').val('');
	$('#declinaison').val('');
	$('#mot').val('');
}
function doit(intm){
	if(intm==1){
		
		var jjn=parseInt($('#jj').val());
		if(jjn<31){
			jjn+=1;
			$('#jj').val(jjn);
		}
	}else{
		var jjn=parseInt($('#jj').val());
		if(jjn>1){
			jjn-=1;
			$('#jj').val(jjn);
		}
	}
}
function cleanmot(){
	$('#mot').val('');
}