/**
 * 参加报名
 */
var workcount = "";
var maxperiod = "";
var status = "";
 $(document).ready(function(){
	 //进行信息的初始化
	 //查询最新期是第几期
	 console.info("开始加载");
	// findMaxPeriod();
	  findworkcount();
	 var firmName = window.localStorage.getItem("firmName");
		if(firmName==null || firmName=="null"){
			  alert("请完善个人信息后提交");
			  //alert("比赛已经结束，不能提交作品");
			  window.location.href="welcome.html";
		  }
		//if(workcount!=null){//
		//	if(workcount!=0){
		//		alert("本期您已经提交过作品，不可重复提交");
		//		window.location.href="welcome.html";
		 //   }
	//	}
		
 });
 
 
 
//查询最新期，参赛者提交了多少个作品
 function findworkcount(){
	 var flag = true;
	 var id = window.localStorage.getItem("id");
	 if(flag){
	    	$.ajax({
	    		url:"http://localhost:8085/work/firmworkcoutbyperiod",
	    		//url:"/work/firmworkcoutbyperiod",
	            type:"get",
	            data:{"firmUserid":id},
	            dataType:"json",
	            success:function (result) {
	            	console.info("find_result="+result.code);
	                if (result.code==0){//查询成功
	                	var data =  result.data;
	                	workcount = data.count;
	                	maxperiod=data.newPeriod;
	                	status =  data.status;
	                	console.info("workcount2222="+workcount+",maxperiod222="+maxperiod);
	                	console.info("status="+status);
	                	 $("#canjiahead").text("第"+maxperiod+"期项目参赛快速通道");
	                  
	                   console.info("find_workcount="+workcount);
	                }else{
	                   // $("#password_error").html("未知错误");
	                	 alert("网络开小差了");
	                }
	            },
	            error:function () {
	            	 alert("网络错误，请稍后再试...");
	            }


	        });
	 }	
 }
//提交作品之前查询 比赛信息状态码
 
function baomin(){
	 console.info("baoming_workcount="+workcount);
	var workname = $("#firmname").val();
	var workinfo = $("#workinfo").val();
	var id = window.localStorage.getItem("id");
	var fis = $("#shangchuan")[0].files[0];
	var formData = new FormData();//表单对象
	formData.append("uploadFile", $("#shangchuan")[0].files[0]);    //生成一对表单属性
	formData.append("workname",workname);
	formData.append("details",workinfo);
	formData.append("firmUserid",id);
	formData.append("period",maxperiod);
	var flag = true;
	var firmName = window.localStorage.getItem("firmName");
	if(firmName=="null"){
		  flag = false;
		  alert("请完善个人信息后提交");
		
		  window.location.href="welcome.html";
	  }
	//alert("workcount="+workcount);
	if(status==""){
		flag = false;
		alert("本期还没有开始比赛，不可提交");	
	}
	if(status == 0){
		flag = false;
		alert("本期比赛已经结束，不可提交");	
	}
	if(workcount!=0){
		flag = false;
		alert("本期您已经提交过作品，不可重复提交");
		
		window.location.href="welcome.html";
    }else{
    	if(workname==null || workinfo==null || id==null || maxperiod==null || fis==null ){
    		flag = false;
    		alert("内容不能为空");
    	}
    }
	
	if(flag){
		$.ajax({
	        type: "POST",           //因为是传输文件，所以必须是post
	        url: 'http://localhost:8085/work/add',         //对应的后台处理类的地址
	        //url:"/work/add", 
	        data: formData,
	        processData: false,
	        contentType: false,
	        success: function (result){
	        	 var data = result.data;
	        	if (result.code==0){
	        		var data = result.data;
	                alert("文件上传成功,请点击参赛作品查看");
	                window.location.href="welcome.html";
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
 
 


