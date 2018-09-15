
var userId = getRequest(location.search).userId;
console.log(userId);
mui.ajax(userApiPath+"getUserById",{
	data:{
		userId:userId
	},
	dataType:'json',//服务器返回json格式数据
	type:'post',//HTTP请求类型
	timeout:10000,//超时时间设置为10秒；
	headers:{'Content-Type':'application/x-www-form-urlencoded'},	              
	success:function(data){
		//服务器返回响应，根据响应结果，分析是否登录成功；
		if(data.code==0){
			var user = data.data;
			console.log(user);
			var userId=user.id;//用户id
			var deptId=user.deptId;//部门id
			var deptName=user.deptName||"";//部门名称
			var name=user.name||"";//用户名称
			var mobile=user.mobile||"";//手机
			var email=user.email||""//邮箱
			console.log(mui(".mui-content .mui-table-view")[0]);
			mui("header .mui-title")[0].innerHTML = name;
			mui(".mui-content .mui-table-view")[0].innerHTML +=`
				<li class="mui-table-view-cell">
					<span>姓名：`+name+`</span>
				</li>
				<li class="mui-table-view-cell"><span>电话：`+mobile+`</span></li>
				<li class="mui-table-view-cell" ><span>邮箱：`+email+`</span></li>
				<li class="mui-table-view-cell"><span>部门：`+deptName+`</span></li>
			`;
		}
	},
	error:function(xhr,type,errorThrown){
		//异常处理；
		console.log(type);
		//mui(".mui-content .mui-table-view-cell")[0].innerHTML='获取数据失败！错误码:'+type;
	}
})



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

