jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    var mobile = /^1[345789]\d{9}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");


/**
 * 通用的下拉框初始方法
 * @param domid 下拉框dom节点id
 * @param url 请求url
 * @param data  参数
 * @param keyName  返回key名称
 * @param valueName 返回value名称
 */
function  initSel(domid,url,data,keyName,valueName) {
        $.ajax({
            url:url,
            type:"POST",
            dataType:"json",
            data:data||{},
            success:function(result){
                if(result&&result.length>0){
                    var $dom=$("#"+domid);
                    for(i in result){
                        var obj=result[i];
                        keyName=keyName||"key";
                        valueName=valueName||"value";
                        $dom.append("<option value='"+(obj[valueName]||"")+"'>"+(obj[keyName]||"")+"</option>");
                    }
                    $dom.selectpicker('refresh');
                }
            }
        });
}