function addaction(){
	var pid=$('#paperid').val();
	if(pid==''){
		var msg=document.getElementById("msg");
		msg.innerHTML="请输入ID";
		return false;
	}
	var pname=$('#papername').val();
	if(pname==''){
		var msg=document.getElementById("msg");
		msg.innerHTML="请输入名称";
		return false;
	}
	var cid=$('#courseid').val();
	if(cid==''){
		var msg=document.getElementById("msg");
		msg.innerHTML="请选择所属试卷";
		return false;
	}
	$('#form2').submit();
}
function checkid(){
	var pid=$('#paperid').val();
	if(pid==''){
		var msg=document.getElementById("pid_msg");
		msg.innerHTML="请输入ID";
		return false;
	}
	$.ajax({
		url:'paper/check',
		type:'post',
		data:{'paperid':pid},
		dataType:'json',
		success:function(data){
			var checkp_mag=data;
			var msg=document.getElementById("pid_msg");
		msg.innerHTML=checkp_mag;
		},
		error:function(){}
	});
}
function checkname(){
	var pname=$('#paperid').val();
	if(pname==''){
		var msg=document.getElementById("pname_msg");
		msg.innerHTML="请输入名称";
		return false;
	}
	$.ajax({
		url:'paper/check',
		type:'post',
		data:{'papername':pname},
		dataType:'json',
		success:function(data){
			var checkp_mag=data;
			var msg=document.getElementById("pname_msg");
		msg.innerHTML=checkp_mag;
		},
		error:function(){}
	});
}