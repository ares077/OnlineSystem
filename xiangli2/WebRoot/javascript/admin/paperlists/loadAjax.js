
function showID(){
	var pname=$('#pname').val();
	if(pname=='默认'){
		return false;
	}
	$.ajax({
		url:"paper/loadpaper",
		type:"post",
		data:{"pname":pname},
		dataType:"json",
		success:function(data){
			var paper=data;
			var inputid=document.getElementById("pid");
			var inputcid=document.getElementById("cid");
			inputid.value=paper.paperid;
			inputcid.value=paper.courseid;
		},
		error:function(){
			
		}
	});
}
function showname(){
	var pid=$('#paperid').val();
	if(pid=='默认'){
		return false;
	}
	var url1='paper/loadpaper?date='+new Date().getTime();
	$.ajax({
		url:url1,
		type:"post",
		data:{"pid":pid},
		dataType:"json",
		success:function(data){
//			alert('name执行到此');
			var paper=data;
			var inputpn=document.getElementById("papername");
			var inputcid=document.getElementById("courseid");
		//	inputpn.setAttribute("value",paper.papername);
			inputpn.value=paper.papername;
			inputcid.value=paper.courseid;
		},
		error:function(){
			
		}
	});
}
function form1(){
	var pid=$('#paperid').val();
	if(pid=='默认'){
		alert('请选择试卷ID');
		return false;
	}
	var pname=$('#papername').val();
	if(pname==''){
		alert('请输入名字');
		return false;
	}
	$('#form1').submit();
}

function deletep(){
	var pid=$('#paperid').val();
	if(pid=='默认'){
		alert('请选择试卷ID');
		return false;
	}
	uri='paper/delete?paperid='+pid;
	location.href=uri;
}