
var userId = getRequest(location.search).userId;
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
			var userId=user.id;//用户id
			var deptId=user.deptId;//部门id
			var deptName=user.deptName||"";//部门名称
			var name=user.name||"";//用户名称
			var mobile=user.mobile||"";//手机
			var email=user.email||""//邮箱
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





