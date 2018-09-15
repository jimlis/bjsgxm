
var obj = getRequest(location.search);
var deptId = obj.deptId||0;
mui.ajax(deptApiPath+"getNextDeptAndUser",{
	data:{
		deptId:deptId
	},
	dataType:'json',//服务器返回json格式数据
	type:'post',//HTTP请求类型
	timeout:10000,//超时时间设置为10秒；
	headers:{'Content-Type':'application/x-www-form-urlencoded'},	              
	success:function(data){
		//服务器返回响应，根据响应结果，分析是否登录成功；
		if(data.code==0){
			var array = data.data;
			mui.each(array,function(index,item){
			  	var name = item.name;
			  	var lx = item.lx;
			 	var id = item.id;
				mui(".mui-content .mui-table-view")[0].innerHTML +="<li class=\"mui-table-view-cell\" onclick=\"openNext('"+lx+"','"+id+"');\">"+name+"</li>";
			})
			mui(".mui-content .mui-table-view-cell")[0].style.display="none";
		}else{
			mui(".mui-content .mui-table-view-cell")[0].innerHTML=data.msg;
		}
	},
	error:function(xhr,type,errorThrown){
		//异常处理；
		console.log(type);
		mui(".mui-content .mui-table-view-cell")[0].innerHTML='获取数据失败！错误码:'+type;
	}
})

/**
 * 跳转组织机构人员列表页面
 */
function openNext(lx,id){
	if(lx=='unit'){
		window.location.href="address_dept.html?deptId="+id;
	}else{
		window.location.href="address_user.html?userId="+id;
	}
}

