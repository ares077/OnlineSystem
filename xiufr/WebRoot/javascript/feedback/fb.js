
function form1(){
	var form=document.getElementById("form1");
	var feedback=document.getElementById("feedback");
	if(feedback.value.toString().length<10){
		var msg=document.getElementById("msg");
		msg.innerHTML="votre avis devraient plus de 10 mots";
	}else{
		form.submit();
		form.reset();
		alert('Votre avis a bien enregistrés, merci beaucoup');
	}
}