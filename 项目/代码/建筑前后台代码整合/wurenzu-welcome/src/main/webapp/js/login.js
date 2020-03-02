/*
 * 考虑在里边判断一下是否登录，登录后除非注销了，才能再次点击登录
 * 登录后，应该考虑把登录和注册两个按钮隐藏掉，把注销按钮加上
 */

function loginSubmit(){
	console.info("loginSubmit方法执行了");
	    var username= $("#username").val();
	    var password =$("#password1").val();
	    var flag=true;
	    if(username=="" || password==""){
	    	alert("输入不能为空");
	        flag=false;
	    }
	    //alert(USER_SERVICE);
	    if(flag){
	        $.ajax({
	        	//url:"http://localhost:8084/user/login",
	        	url:"/user/login",
	            type:"post",
	            data:{"name":username,"password":password},
	            dataType:"json",
	            success:function (result) {
	                if (result.code==0){
	                    var data = result.data;
	                    //将用户信息保存
	                    window.localStorage.setItem("id",data.id);
	                    window.localStorage.setItem("pass",data.password);
	                    window.localStorage.setItem("name",data.name);
	                    window.localStorage.setItem("image",data.image);
	                    window.localStorage.setItem("regtime",data.regtime);
	                    window.localStorage.setItem("firmName",data.firmName);
	                    window.localStorage.setItem("firmDetail",data.firmDetail);
	                    window.localStorage.setItem("email",data.email);
	                    window.localStorage.setItem("phone",data.phone);
	                    window.localStorage.setItem("represent",data.represent);
	                    window.localStorage.setItem("address",data.address);
	                    alert("登陆成功,正在跳转...");
	                    window.location.href="welcome.html";
	                }else if(result.code==-1){
	                	alert("用户名或密码不能为空");
	                }else if(result.code==2){
	                	alert("密码错误");
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



