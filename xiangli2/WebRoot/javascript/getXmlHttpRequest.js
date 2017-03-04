
function getXmlHttpRequest(){
	var xhr=null;
	if((typeof XMLHttpRequest)!='undefined'){
		xhr=new XMLHttpRequest();
	}else{
		xhr=new ActiveObject('Microsoft.XMLHttp');
	}
	return xhr;
}