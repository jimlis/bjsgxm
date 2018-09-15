
mui.ajax(noticeApiPath+"list",{
	data:{
		//deptId:deptId
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
				var id = item.id;
				var chrbt = item.chrbt;
				var dtmfbsj = item.dtmfbsj;
				var chrdjrbmmc = item.chrdjrbmmc;
				var chrdjrmc = item.chrdjrmc;
				mui(".mui-content")[0].innerHTML +=`
					<div class="mui-card" onclick="openNext(`+id+`)">
						<!--页眉，放置标题-->
						<div class="mui-card-header" id="title">
							`+chrbt+`
						</div>
						<!--内容区-->
						<div class="mui-card-content">
							<div class="mui-card-content-inner" id="synopsis">
								包含页眉页脚的卡片，页眉常用来显示面板标题，页脚用来显示额外信息或支持的操作（比如点赞、评论等）
							</div>
						</div>
						<!--页脚，放置补充信息或支持的操作-->
						<div class="mui-card-footer">
							<span id="time">
								`+dtmfbsj+`
							</span>
							<span id="name">
								`+chrdjrbmmc+'/'+chrdjrmc+`
							</span>
						</div>
					</div>
				`;
			})
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
 * 跳转公告详情
 */
function openNext(id){
		window.location.href="notice_detail.html?id="+id;
}