

 function Subm(isTrue){
	 if(isTrue){
		  $('#form1').submit();
		  alert('Time up ');
		  return;
	 }
	 var boo=window.confirm("Vous voulez vraiment quitter le test？");
	 if(boo){
		 $('#form1').submit();
	 }
 }
 
