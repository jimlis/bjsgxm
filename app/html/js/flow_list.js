mui.ajax(fileApiPath+"wdlist",{
	data:{
		type:'2'
	},
	dataType:'json',//服务器返回json格式数据
	type:'post',//HTTP请求类型
	timeout:10000,//超时时间设置为10秒；
	headers:{'Content-Type':'application/x-www-form-urlencoded'},	              
	success:function(data){
	
		//服务器返回响应，根据响应结果，分析是否登录成功；
		if(data.code==0){
			var array = data.data;
				console.log(array);
			mui.each(array,function(index,item){
			  	var fileName = item.fileName;
			 	var id = item.id;
			 	var busType = item.busType;
				mui(".mui-content .mui-table-view")[0].innerHTML +="<li class=\"mui-table-view-cell\" onclick=\"openNext('"+busType+"','"+id+"');\">"+fileName+"</li>";
			})
			mui(".mui-content .mui-table-view-cell")[0].style.display="none";
		}else{
			mui(".mui-content .mui-table-view-cell")[0].innerHTML=data.msg;
		}
	},
	error:function(xhr,type,errorThrown){
		//异常处理；
		console.log(type+"==err==");
		mui(".mui-content .mui-table-view-cell")[0].innerHTML='获取数据失败！错误码:'+type;
	}
})

/**
 * 打开文件详情
 */
function openNext(busType,id){
		window.location.href="open_file.html?deptId="+id;
}