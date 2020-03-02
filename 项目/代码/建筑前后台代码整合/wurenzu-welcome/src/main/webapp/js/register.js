function registerSubmit(){
	console.info("registerSubmit方法执行了");
	var username2= $("#username2").val();
    var password2 =$("#password3").val();
    var password3 =$("#password4").val();
    var flag=true;
    if(username2=="" || password2=="" || password3==""  ){
    	flag=false;
    	alert("内容不能为空");
    }else{
    	 if(password3!=password2 ){
    	    	flag=false;
    	    	alert("密码不一致");
    	    }
    }
   
    if(flag){
    	$.ajax({
    		//url:"http://localhost:8084/user/add",
    		url:"/user/add",
            type:"put",
            dataType:"json",
            data:{"name":username2,"password":password2},
            success:function (result) {
                if (result.code==0){
                	 alert(username2+"注册成功");
                	 login();
                	 $("#username").val(username2);
                	 alert("请登录后完善个人信息");
                }else{
                	 alert("未知错误");
                }
            },
            error:function () {
            	 alert("网络错误，请稍后再试...");
            }


        });
    	
    }
    
}