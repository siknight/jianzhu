/**
 * 用于修改密码
 */
function savePass(){
	var flag = true;
	var oldpass = $("#oldpass").val();
	var id = window.localStorage.getItem("id");
	var truePass = window.localStorage.getItem("pass");
	var pass1 = $("#password").val();
	var pass2 = $("#password2").val();
	if(oldpass == truePass){	//判断密码是否正确
		if(pass1=="" || pass2==""){
			 alert("密码不能为空");
			 flag = false;
		}else {
			if(pass1!=pass2){
				 alert("新密码与确认密码不一致!");
				 flag = false;
			}
		}
			
	}else{
		 alert("原密码输入不正确!");
		 flag = false;
	}
			
		
		if(flag){
	    	$.ajax({
	    		//url:"http://localhost:8084/user/updatePass",
	    		url:"/user/updatePass",
	            type:"put",
	            dataType:"json",
	            data:{"password":pass1,"id":id},
	            success:function (result) {
	                if (result.code==0){//成功
	                    var data = result.data;
	                	console.info(id+"密码修改成功");
	                	 alert(id+"密码修改成功");
	                	 window.localStorage.setItem("pass",data.password);
	                	// window.location.href="Test.html";
	                	 window.location.href="InfoCenter.html";
	                }else if(result.code==-1){
	                    //$("#password_error").html(result.msg);
	                	 alert("用户名或密码不能为空");
	                }else{
	                   // $("#password_error").html("未知错误");
	                	 alert("未知错误");
	                }
	            },
	            error:function () {
	            	 alert("网络错误，请稍后再试...");
	            }


	        });
		}
	
}