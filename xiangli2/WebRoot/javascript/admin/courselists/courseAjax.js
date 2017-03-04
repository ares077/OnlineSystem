
function deletec(){
		var cid=$('#courseid').val();
	if(cid==null||cid=='默认'){
		alert('请选择课程编号');
		return false;
	}
	var uri='course/delete?courseid='+cid;
	location.href=uri;
}

function form1(){
	var cname=$('#coursename').val();
	if(cname==null||cname==''){
		alert('课程名不能为空');
		return false;
	}
	var submit=document.getElementById("form1");
	submit.submit();
}

function showID(){
	var cname=$('#s1').val();
	if(cname==null||cname=='默认'){
		var sel=document.getElementById("s1t1");
			while(sel.childNodes.length>0){
				sel.removeChild(sel.lastChild);
			}
		return false;
	}
	$.ajax({
		url:"course/loadcourse",
		type:"post",
		data:{'cname':cname},
		dataType:"json",
		success:function(data){
			var courses=data;
			var sel=document.getElementById("s1t1");
			while(sel.childNodes.length>0){
				sel.removeChild(sel.lastChild);
			}
			for(var i=0;i<courses.length;i++){
				var opt=document.createElement("option");
				opt.innerHTML=courses[i].courseid;
				sel.appendChild(opt);
			}
		},
		error:function(){	
		}
	});
}

function showName(){
	var cid=$('#courseid').val();
	if(cid==null||cid=='默认'){
		var inputcname=document.getElementById("coursename");
			inputcname.setAttribute("value",'');
		return false;
	}
	$.ajax({
		url:"course/loadcourse",
		type:"post",
		data:{'cid':cid},
		dataType:"json",
		success:function(data){
			var courses=data;
			var inputcname=document.getElementById("coursename");
			inputcname.value=courses[0].coursename;
		},
		error:function(){	
		}
	});
}