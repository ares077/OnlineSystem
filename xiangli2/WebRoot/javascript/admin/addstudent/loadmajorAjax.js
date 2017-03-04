
function loadmajor(){
	var depart=$('#department').val();
	if(depart=='默认'){
		var selectm=document.getElementById('major');
			while(selectm.childNodes.length>0){
				selectm.removeChild(selectm.lastChild);
			}
			var option=document.createElement("option");
			option.value="未指定专业";
			option.innerHTML="请选择专业";
			selectm.appendChild(option);
		return false;
	}
	$.ajax({
		url:"student/loadmajor",
		type:"post",
		data:{'department':depart},
		dataType:"json",
		success:function(data){
			var majors=data;
			var selectm=document.getElementById('major');
			while(selectm.childNodes.length>0){
				selectm.removeChild(selectm.lastChild);
			}
			var option=document.createElement("option");
			option.value="未指定专业";
			option.innerHTML="请选择专业";
			selectm.appendChild(option);
			for(var i=0;i<majors.length;i++){
				var opt=document.createElement("option");
				opt.value=majors[i].majors;
				opt.innerHTML=majors[i].majors;
				selectm.appendChild(opt)
			}
		},
		error:function(){
			
		}	
		});
}