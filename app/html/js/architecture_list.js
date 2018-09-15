(mui.ajax(archApiPath,{
	data:{
		
	},
	dataType:'json',//服务器返回json格式数据
	type:'post',//HTTP请求类型
	timeout:10000,//超时时间设置为10秒；
	headers:{'Content-Type':'application/json'},	              
	success:function(data){
		//服务器返回响应，根据响应结果，分析是否登录成功；
		
	},
	error:function(xhr,type,errorThrown){
		//异常处理；
		console.log(type);
		mui('.mui-content.mui-table-view-cell').innerHTML='获取数据失败！';
	}
}))()