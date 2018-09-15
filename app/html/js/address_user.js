/**
 * 跳转到组织机构页面
 */
function toZzjgPage(deptId){
	window.location.href="zzjg.html?deptId="+deptId;
}

/**
 * 加载人员信息
 * @param {Object} userId
 */
function init(userId){
	AJAX.POST(userApiPath+"getUserById",{"userId":userId},function(result){
		if(result){

			var userId=result.id;//用户id
			var deptId=result.deptId;//部门id
			var deptName=result.deptName||"";//部门名称
			var name=result.name||"";//用户名称
			var mobile=result.mobile||"";//手机
			var email=result.email||""//邮箱
			var html="<li class=\"mui-table-view-cell\">";
				html+="<p>";
				html+="<span class=\"acolor\" onclick=\"toZzjgPage('"+deptId+"')\">功能组别</span>";
				html+="<span class=\"acolor\">/</span><span class=\"acolor\" onclick=\"toZzjgPage('"+deptId+"')\">"+deptName+"</span>";
				html+="</p>";
				html+="</li>";
				html+="<li class=\"mui-table-view-cell\">";
				html+="<span>姓名："+name+"</span>";
				html+="</li>";
				html+="<li class=\"mui-table-view-cell\"><span>电话："+mobile+"</span></li>";
				html+="<li class=\"mui-table-view-cell\" ><span>邮箱："+mobile+"</span></li>";
				html+="<li class=\"mui-table-view-cell\"><span>部门："+deptName+"</span></li>";		
				$("#user").html(html);
		}
	});
}

