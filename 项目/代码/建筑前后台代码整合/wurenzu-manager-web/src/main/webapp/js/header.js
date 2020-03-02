
	$(function () {
		loadManager();
    });

	
	function loadManager() {
		
        var id=window.localStorage.getItem("id");
        var name=window.localStorage.getItem("name");
        var nick_name=window.localStorage.getItem("nick_name");
        var sex=window.localStorage.getItem("sex");
        var signature=window.localStorage.getItem("signature");
        var image=window.localStorage.getItem("image");
        var regtime=window.localStorage.getItem("regtime");
        
        console.info(name);
        console.info("")

        if(name!=""&&name!=null){
            $("#username").html(name+'<i class="Hui-iconfont">&#xe6d5;</i>');
		}else{
			 $("#username").html('外星人'+'<i class="Hui-iconfont">&#xe6d5;</i>');
		 }
    }
