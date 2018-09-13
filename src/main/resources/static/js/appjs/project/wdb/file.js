$().ready(function() {
    //加载文件列表
    initFileShow($("#busType").val(),$("#busId").val());

});

function  downFile(id) {
    if($("#downForm").length>0){
        $("#downForm").remove();
    }
    var $form=$('<form id="downForm" method="post" action="/common/sysFile/downFile/'+id+'"></form>');
    $(document.body).append($form);
    $form.submit();
}

/**
 * 加载文件显示列表
 * @param busType  业务表名称
 * @param busId 业务id
 */
function initFileShow(busType,busId) {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/common/sysFile/listAll",
        data : {"busType":busType,"busId":busId},// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("未知错误");
        },
        success : function(r) {
            if(r.code==0){
                var $fileList=$("#fileList");
        		if(r.data.length>0){
        			for (i  in r.data){
                        var file=r.data[i];
                        var fileId=file.id;
                        var fileName=file.fileName||"";
                        $fileList.append("<div id=\"" + fileId + "\" fileId=\""+fileId+"\" title=\""+fileName+"\" class=\"file-item\"><a href=\"javascript:void(0);\" style='color:blue;' onclick=\"downFile("+fileId+")\">"+ fileName + "</a>" +
                            "</div>");
					}
				}

            }else{
                layer.msg(r.msg);
            }

        }
    });

}
