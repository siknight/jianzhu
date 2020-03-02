/**
 * 
 */
function loginout(){
	//window.localStorage.clear();//请谨慎使用,它会清空所有的本地存储数据
	//考虑移除之前需不需要判空，个人觉得不需要
	  if(confirm('确定要退出吗？')==true){
		  window.localStorage.removeItem("id");
			window.localStorage.removeItem("pass");
			window.localStorage.removeItem("name");
			window.localStorage.removeItem("image");
			window.localStorage.removeItem("regtime");
			window.localStorage.removeItem("firmName");
			window.localStorage.removeItem("firmDetail");
			window.localStorage.removeItem("email");
			window.localStorage.removeItem("phone");
			window.localStorage.removeItem("represent");
			window.localStorage.removeItem("address");
			window.localStorage.removeItem("maxperiod");
			window.localStorage.removeItem("workcount");
			 window.location.href="welcome.html";
			 
	       return true;

	    }else{

	       return false;

	    }
	
}