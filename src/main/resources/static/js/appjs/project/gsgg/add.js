var editor;
$().ready(function() {
    initSel("chrlx","/common/sysDict/list/wjlx",{},"name","value");

    intEditor();

	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var chrnr = editor.getContent();
    if(chrnr.length ==0){
        parent.layer.alert("请输入公告内容");
      return;
    }

    $("#fileIds").val(fileIds.join(","));

    $("#chrggnr").val(chrnr);

	$.ajax({
		cache : true,
		type : "POST",
		url : "/project/gsgg/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            chrbt : {
				required : true
			},
            intxh : {
                required : true,
                digits:true
            }
		},
		messages : {
            chrbt : {
				required : icon + "请输入公告名称"
			},
            intxh : {
                required : icon + "请输入序号",
                digits: icon + "请输入整数"
            },
		}
	})
}

var fileIds=[];

layui.use('upload', function () {
    var upload = layui.upload;
    //执行实例
    var uploadInst = upload.render({
        elem: '#test1', //绑定元素
        url: '/common/sysFile/upload', //上传接口
        size: fileUploadSize,
        accept: 'file',
        done: function (r) {
            if(r.code==0){
                var file=r.data;
                var fileId=file.id;
                var fileName=file.fileName||"";
                fileIds.push(fileId);
                var $fileList=$("#fileList");
                $fileList.append("<div id=\"" + fileId + "\" fileId=\""+fileId+"\" title=\""+fileName+"\" class=\"file-item\"><a href=\"javascript:void(0);\" style='color:blue;' onclick=\"downFile("+fileId+")\">"+ fileName + "</a>" +
                    "<a href=\"javascript:void(0);\" class=\"glyphicon glyphicon-remove\" style=\"color: red\" aria-hidden=\"false\" onclick=\"removeFile("+fileId+",this)\"></a></div>");
                $fileList.append("");
            }else{
                layer.msg(r.msg);
            }
        },
        error: function (r) {
            layer.msg(r.msg);
        }
    });
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
 * 删除文件
 * @param id
 */
function  removeFile(id,obj) {
    layer.confirm('删除不可以恢复，确定删除文件？', {
        btn : [ '确定', '取消' ],title: "提示"//按钮
    }, function(index) {
        $.ajax({
            cache : true,
            type : "POST",
            url : "/common/sysFile/remove",
            data : {"id":id},// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("未知错误");
            },
            success : function(data) {
                if (data.code == 0) {
                    debugger;
                    var index = $.inArray(id,fileIds);
                    if(index>=0){//存在 就删除
                        fileIds.splice(index,1);
                    }
                    $(obj).parent().remove();
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
        layer.close(index);
    });

}


function intEditor(){
    editor = UE.getEditor('myEditor', {
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo','bold', 'italic',
                'underline', 'fontborder', 'strikethrough','removeformat',
                'formatmatch', '|', 'justifyleft','justifyright','justifycenter','justifyjustify',
                'forecolor', 'backcolor', 'insertorderedlist',
                'insertunorderedlist','fontfamily','fontsize',
                'simpleupload']
        ],
        autoHeightEnabled: true,
        autoFloatEnabled: true,
        zIndex : 500
    });
}