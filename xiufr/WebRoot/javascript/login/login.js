function change(image) {
	image.src="login/createImage.xiu?date="+new Date().getTime();
}
function changeState1(){
	var radio1=document.getElementById("radio1");
	radio1.click();
}
function changeState2(){
	var radio1=document.getElementById("radio2");
	radio1.click();
}
function changeState3(){
	var radio1=document.getElementById("radio3");
	radio1.click();
}
function subm(){

	var form=document.getElementById('form1');

	form.submit();

}
function checkCode(){
	$("#vcode_msg").text("vérifier......");
	var vcode=$('#vcode').val();
	$.post(
		'login/checkcode.xiu',
		{'vcode':vcode},
		function(data){
			var info=data;
			$("#vcode_msg").text(info.info);
		}
		);
//	$.ajax({
//		url:'login/checkcode',
//		type:'post',
//		data:{'vcode':vcode},
//		dataType:'json',
//		success:function(data){
//			alert('执行到此啦');
//			var info=data;
//			$("#vcode_msg").text(info);
//		}
//	});
}