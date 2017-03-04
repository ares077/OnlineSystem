
function form2(){
	var cid=$('#courseid').val();
	var cname=$('#coursename').val();
	if(cid==''){
		alert('课程号不能为空');
		return false;
	}
	if(cname==''){
		alert('课程名不能为空');
		return false;
	}
	$('#form2').submit();
}
function checkcid(){
	var cid=$('#courseid').val();
	if(cid==''){
		return false;
	}
	$.ajax({
		url:"course/checkcid",
		type:"post",
		data:{'courseid':cid},
		dataType:"json",
		success:function(data){
			var msg=data;
			var span=document.getElementById("checkcid");
			span.innerHTML=msg;
		},
		error:function(){
			
		}
	});
}