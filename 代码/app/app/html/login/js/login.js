function login(){
	var account=$("#account").val();
	var password=$("#password").val();
	if(isEmpty(account)){
		alert("账号不能为空");
		return;
	}
	
	if(isEmpty(password)){
		alert("密码不能为空");
		return;
	}
	
	AJAX.POST(userApiPath+"login",{"mobile":account,"password":password},function(result){
		debugger
			if(result&&result.token){
				localStorage.setItem("token",result.token);
				window.location.href="../mian.html";
			}
	});
}
