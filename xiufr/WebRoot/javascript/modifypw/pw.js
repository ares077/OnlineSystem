
function checkpw(){
	var opw=document.getElementById("newpw").value;
	var opwmsg=document.getElementById("newpw_msg");
	if(opw.toString().length<6){
		opwmsg.innerHTML="mot de passe 》 6";
		return false;
	}else{
		opwmsg.innerHTML="V";
		return true;
	}
}
function checkpw2(){
	var opw=document.getElementById("newpw2").value;
	var opw2=document.getElementById("newpw").value;
	var opwmsg=document.getElementById("newpw2_msg");
	if(opw.toString()==opw2.toString()){
		opwmsg.innerHTML="V";
		return true;
	}else{
		opwmsg.innerHTML="invalide ";
		return false;
	}
}
function checkoldpw(){
	var opw=document.getElementById("oldpw").value;
	var opwmsg=document.getElementById("oldpw_msg");
	if(opw.toString().length<6){
		opwmsg.innerHTML="mot de passe 》 6";
		return false;
	}else{
		opwmsg.innerHTML="V";
		return true;
	}
}
function form1(){
	var form=document.getElementById("form1");
	var mes=document.getElementById("form1_msg");
	if(checkoldpw()&&checkpw2()&&checkpw()){
		mes.innerHTML="";
		form.submit();
	}else{
		mes.innerHTML="invalide infos";
	}
}
function ccc(){
	window.close();
}