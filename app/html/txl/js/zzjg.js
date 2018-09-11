/**
 * 跳转组织机构人员列表页面
 */
function toZzjgRyPage(lx,id){
	if(lx=='unit'){
		window.location.href="zzjg.html?deptId="+id;
	}else{
		window.location.href="ry.html?userId="+id;
	}
	
}
var index=0;
function init(deptId){

	deptId=deptId||0;
	AJAX.POST(deptApiPath+"getNextDeptAndUser",{"deptId":deptId},function(reslut){
		var $unit=$("#unit");
		var $user=$("#user");
		$("#empty_li").remove();
		if(reslut&&reslut.length>0){
			for(i in reslut){
				var obj=reslut[i];
				var lx=obj.lx;
				var name=obj.name;
				var id=obj.id;
				if(lx=='unit'){
					$unit.append("<li class=\"mui-table-view-cell\" onclick=\"toZzjgRyPage('"+lx+"','"+id+"');\">"+name+"</li>");
				}else{
					$user.append("<li class=\"mui-table-view-cell\" onclick=\"toZzjgRyPage('"+lx+"','"+id+"');\">"+name+"</li>");
				}
			}
			
		}else if(index==0){
			$unit.append("<li id=\"empty_li\" class=\"mui-table-view-cell\" \">暂无数据</li>");
		}
		
		index++;	
		
	//	console.log(reslut);
	});
}
