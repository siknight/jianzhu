/**
 * 退出
 * @returns
 */
  $("#loginout").click(function(){
	  if(confirm("确定要退出吗?")){
		  window.localStorage.removeItem('id');
		  window.localStorage.removeItem('name');
		  window.localStorage.removeItem('nick_name');
		  window.localStorage.removeItem('token');
		  window.location.href="login.html";
	  }else{
		  
	  }
  });