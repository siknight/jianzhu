/**
 * 重置
 */

$("#reset").click(function(){
    $("#username_error").html("");
    $("#password_error").html("");
    $("#username").val("");
    $("#password").val("");
});

/**
 * 登陆
 */

$("#login").click(function () {
    $("#username_error").html("");
    $("#password_error").html("");
    var username= $("#username").val();
    var password =$("#password").val();
    var flag=true;
    if(username==""){
        $("#username_error").html("用户名为空");
        flag=false;
    }
    if(password==""){
        $("#password_error").html("密码为空");
        flag=false;
    }
  
    
    if(flag){
        $.ajax({
            url:"/manager/login",
            type:"post",
            dataType:"json",
            data:{"name":username,"password":password},
            success:function (result) {
            	
                if (result.code==0){
                	
                    var data = result.data;
                    //将用户信息保存
                    window.localStorage.setItem("id",data.id);
                    window.localStorage.setItem("name",data.name);
                    window.localStorage.setItem("nick_name",data.nick_name);
                    window.localStorage.setItem("sex",data.sex);
                    window.localStorage.setItem("signature",data.signature);
                    window.localStorage.setItem("image",data.image);
                    window.localStorage.setItem("regtime",data.regtime);
                    window.localStorage.setItem("phone",data.phone);
                    window.localStorage.setItem("email",data.email);
                    window.localStorage.setItem("token",data.token);
                    alert("登陆成功,正在跳转...");
                    window.location.href="index.html";
                }else if(result.code==-1){
                    $("#password_error").html(result.msg);
                }else if(result.code==1){
                    $("#password_error").html(result.msg);
                }else if(result.code==2){
                    $("#password_error").html(result.msg);
                }else{
                    $("#password_error").html("未知错误");
                }
            },
            error:function () {
                alert("网络错误，请稍后再试...");
            }


        });
    }
});
