


var id=getQueryString("id");


openFile(id);


function openFile(id) {
	document.getElementById("fileIframe").setAttribute("src",serverPath+"/js/plugins/PDFViewer/web/viewer.html?file=/api/file/down/"+id);
}