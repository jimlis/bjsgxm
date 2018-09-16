
/**服务端地址*/
var serverPath="http://127.0.0.1:8080/";
var userApiPath=serverPath+"api/user/";
var deptApiPath=serverPath+"api/dept/";
var fileApiPath=serverPath+"api/file/";
var noticeApiPath=serverPath+"api/gsgg/"


/**
 * 将null undefined  "null" 转换为 ""
 * @param {Object} str 字符串
 */ 
function nullToEmpty(str){
	return (str==null||typeof(str)=="undefined"||str=="null")?"":str;

}

/**
 * 判断字符是否为空
 * @param {Object} str 字符串
 * @return true-空 false-不为空
 */
function isEmpty(str){
	return nullToEmpty(str)=="";
}

/**
 * 判断字符是否不为空
 * @param {Object} str
 *  @return true-不为空 false-空
 */
function isNotEmpty(str){
	return !isEmpty(str);
}

function getRequest(url){
	var theRequest = new Object();
	if ( url.indexOf( "?" ) != -1 ) {
	  var str = url.substr( 1 ); //substr()方法返回从参数值开始到结束的字符串；
	  var strs = str.split( "&" );
	  for ( var i = 0; i < strs.length; i++ ) {
	    theRequest[ strs[ i ].split( "=" )[ 0 ] ] = ( strs[ i ].split( "=" )[ 1 ] );
	  }
	  //console.log( theRequest ); //此时的theRequest就是我们需要的参数；
	}
	return theRequest;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

/**
 *根据文件名称选择打开方式
 * @param fileId 文件id
 * @param fileName 文件名称
 */
function openFileByName(fileId,fileName) {
	if(fileName.slice(-".pdf".length)==".pdf"){//pdf文件
        window.location.href="open_file.html?id="+fileId;
	}else{
		window.open(fileApiPath+"/down/"+fileId);
	}
}
