$(function(){
	webIntercepter();
	myselfinfo();
});

function webIntercepter(){
		var manager_name=window.localStorage.getItem("name");
		var token=window.localStorage.getItem("token");
		if(manager_name==null||manager_name==""||token==null||token==""){
			window.location.href="/login.html";
			return;
		}
	}
function myselfinfo(){
		 //   var id=window.localStorage.getItem("id");
	        var name=window.localStorage.getItem("name");
	        var nick_name=window.localStorage.getItem("nick_name");
	        var sex=window.localStorage.getItem("sex");
	        var signature=window.localStorage.getItem("signature");
	        var image=window.localStorage.getItem("image");
	        var phone=window.localStorage.getItem("phone");
	        var email=window.localStorage.getItem("email");
	        console.info("phone="+phone);
	        console.info("email="+email);
	        var regtime=window.localStorage.getItem("regtime");
	       // $("#userid").html(id);
	         $("#touxiang").html('<img src="'+image+'"  style="width:35px;heigth:35px;" alt="图片">');
	       
	        $("#name").html(name);
	        $("#nick_name").html(nick_name);
	        $("#sex").html(sex);
	        $("#signature").html(signature);
	        $("#phone").html(phone);
	        $("#email").html(email);
	       
      
	}
