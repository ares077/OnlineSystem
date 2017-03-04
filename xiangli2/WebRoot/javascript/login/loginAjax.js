function checkCode(){
	$("#vcode_msg").text("正在验证......");
	var vcode=$('#vcode').val();
	$.ajax({
		url:'login/checkCode',
		type:'post',
		data:{'vcode':vcode},
		dataType:'json',
		success:function(data){
			var info=data;
			$("#vcode_msg").text(info.message);
		}
	});
}
//function checkCode(){
//	var vcode=$('#vcode').val();
//	if(vcode==""){
//		$('#vcode_msg').text("请填写验证码");
//		return;
//	}
//	$.post(
//		'login/checkCode',
//		{'vcode':vcode},
//		function(data){
//		var info=data;
//		$('#vcode_msg').text(info.message);
//		}
//		);
//}