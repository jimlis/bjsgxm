
/*通用跳转
 fa:父级选择器
 sub：需要点击的选择器
 id：如果使用预加载的情况下直接通过id跳转
 url：在id失效的情况下使用url直接跳转*/
function open(fa,sub,id,url) {
    mui(fa).on('tap', sub, function () {
        //console.log(mui(fa).getAttribute("date"));
        url = this.getAttribute("url");
        if (url!=null) {
	        	 //打开页面
	        mui.openWindow({
	            id: id,
	            url: url
	        });
        } else{
        		console.log('没有url');
        }
       
    });
}
/**服务端地址*/
var serverPath="http://127.0.0.1:8080/";
var userApiPath=serverPath+"api/user/";
var deptApiPath=serverPath+"api/dept/";
var archApiPath=serverPath+"api/arch";

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
