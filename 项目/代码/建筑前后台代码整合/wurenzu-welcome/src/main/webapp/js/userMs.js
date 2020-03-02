/**
 * 用于用户个人信息管理
 * @returns
 */

//$(document).ready(function(){
//	console.info("userMs.js执行了");
//	$("#user_name").text(window.localStorage.getItem("name"));
//	});
	
 $(document).ready(function(){
	 showPerMs();
 });


//显示个人信息
function showPerMs(){
	  console.info("showPerMs方法执行了");
	  var id = window.localStorage.getItem("id");
      var username = window.localStorage.getItem("name");
      var image = window.localStorage.getItem("image");//图片地址
      var regtime = window.localStorage.getItem("regtime");
      var firmName = window.localStorage.getItem("firmName");
      var firmDetail = window.localStorage.getItem("firmDetail");
      var email = window.localStorage.getItem("email");
      var phone = window.localStorage.getItem("phone");
      var represent = window.localStorage.getItem("represent");
      var address = window.localStorage.getItem("address");
 	 
 	 $("#username").val(username);
 	 $("#brand").attr("src",image);//出错了
 	 $("regtime").text("用户注册时间："+regtime);
 	 $("#firmname").val(firmName);
 	 $("#firmbrief").text(firmDetail);
 	 $("#email").val(email);
 	 $("#phone").val(phone);
 	 $("#represent").val(represent);
 	 $("#address").val(address);
 	 notavailable();
 }

//进行数据的初始化 所有的文本框都不能点击
function notavailable(){
	 console.info("notavailable方法执行了");
	 $("#brand").attr("disabled","disabled");
	 $("#firmname").attr("disabled","disabled");
	  $("#firmbrief").attr("disabled","disabled");
	  $("#email").attr("disabled","disabled");
	  $("#phone").attr("disabled","disabled");
	  $("#represent").attr("disabled","disabled");
	  $("#address").attr("disabled","disabled");
	  $("#savebutton").attr("hidden",true);
	  $("#selbrand").attr("hidden",true);
	  $("#uploadfile").attr("hidden",true);
	  
}

 //允许修改的文本框可用
function available(){
	  console.info("updatePerMs方法执行了");
	  $("#brand").removeAttr("disabled");
	  $("#firmname").removeAttr("disabled");
	  $("#firmbrief").removeAttr("disabled");
	  $("#email").removeAttr("disabled");
	  $("#phone").removeAttr("disabled");
      $("#represent").removeAttr("disabled");
	  $("#address").removeAttr("disabled");	
	  $("#savebutton").attr("hidden",false);
	  $("#selbrand").attr("hidden",false);
	  $("#uploadfile").attr("hidden",false);
 }

//文件上传
function fileUpload(){
	//如果没有选择文件，就不让点击
    var formData = new FormData();
    var id = window.localStorage.getItem("id");
    var fis = $("#selbrand")[0].files[0];
    formData.append("fileimg", $("#selbrand")[0].files[0]);    //生成一对表单属性
    formData.append("id",id);
    var flag =  true;
    if(id=="" || fis==""){
    	flag = false;
    	alert("请选择文件后上传");
    }
    if(flag){
    	$.ajax({
            type: "POST",           //因为是传输文件，所以必须是post
            //url: 'http://localhost:8084/user/updateimg',         //对应的后台处理类的地址
            url:'/user/updateimg',
            data: formData,
            processData: false,
            contentType: false,
            success: function (result){
            	 var data = result.data;
            	if (result.code==0){
            		var data = result.data;
                    alert("文件上传成功");
                    window.localStorage.setItem("image",data.image);
                    var image =  window.localStorage.getItem("image");
                    $("#brand").attr("src",image);//出错了
            	}else if(result.code==-1){
            		alert("文件上传失败");
            	}
            	
            },
            error:function () {
                alert("网络错误，请稍后再试...");
            }
        });
    }
    
}
 
//保存修改的个人信息 点击保存后，应该让文本输入不了用
function savePerMs(){
	 console.info("savePerMs方法执行了");
	 notavailable();
	 var image = window.localStorage.getItem("image");
	 var firmName = $("#firmname").val();
	 var firmDetail1 = $("#firmbrief").val();
	 var email = $("#email").val();
	 var phone = $("#phone").val();
	 var represent = $("#represent").val();
	 var address =  $("#address").val();
	 var id = window.localStorage.getItem("id");
	 
	 console.info("phone="+phone);
 	 var flag = true;
 	 if(firmName=="" || firmDetail1=="" || email=="" || phone=="" || represent=="" || address=="" || id==""){
 		 flag = false;
 		alert("所有内容都不能为空，请检查无误后提交");
 	 }
 	
 	 if(flag){
 		 $.ajax({
 	    		//url:"http://localhost:8084/user/updateAlloutPass",
 			url:"/user/updateAlloutPass",
 	            type:"put",
 	            dataType:"json",
 	            data:{"firmName":firmName,"firmDetail":firmDetail1,"email":email,"phone": phone,"represent":represent,"address":address,"id":id},
 	            success:function (result) {
 	                if (result.code==0){//修改成功
 	                    var data = result.data;
 	                   console.info("firmDetail1="+firmDetail1);
 	                  
 	                   //将新的用户信息保存
	                    window.localStorage.setItem("id",data.id);
	                    window.localStorage.setItem("name",data.name);
	                    window.localStorage.setItem("image",data.image);
	                    window.localStorage.setItem("regtime",data.regtime);
	                    window.localStorage.setItem("firmName",data.firmName);
	                    window.localStorage.setItem("firmDetail",data.firmDetail);
	                    window.localStorage.setItem("email",data.email);
	                    window.localStorage.setItem("phone",data.phone);
	                    window.localStorage.setItem("represent",data.represent);
	                    window.localStorage.setItem("address",data.address);
 	                	console.info(username+"修改成功");
 	                	
 	                	alert("修改成功");
 	                }else if(result.code==-1){
 	                    //$("#password_error").html(result.msg);
 	                	alert("不能为空");
 	                }else if(result.code==1){
 	                	alert("查不到该用户");
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