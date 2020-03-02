
	$(function(){
		menuShow();
	});
	/**
	 * 菜单显示
	 */
	function menuShow(){
		
		
		var id=window.localStorage.getItem("id");
		$.ajax({
			 	url:"/manager/menu",
	            type："get",
	            dataType:"json",
	            data:{"id":id},
	            success:function (result) {
	            	if(result.code==0){
	            		var data = result.data;
		            	for(var i=0;i<data.lenght;i++){
		            		var menuid=data[i].menuid;
		            		//var pid=data[i].pid;
		            		var menuname=data[i].menuname;
		            	//	var url=data[i].url;
		            		var ziMenu=data[i].ziMenu;
		            		var str='';
		            		str+='<dl>;'
		            		str+='<dt><i class="Hui-iconfont">&#xe613;</i>'+menuname+'<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>;'
		            		str+='<dd>;'
		            		str+='	<ul>;'
		            		for(var j=0;j<ziMenu.length;j++){
		            			var z_id=ziMenu[j].menuid;
		            			var z_menuname=ziMenu[j].menuname;
		            			var z_url=ziMenu[j].url;
		            			str+='	<li><a href="'+z_url+'" title="'+z_menuname+'">'+z_menuname+'</a></li>;'
		            		}
		            		str+='	</ul>;'
		            		str+='	</dd>;'
		            		str+='</dl>;'
		            		
		            		$("#quanxian").append(str);
		            			
		            	}
	            	}
	            	
	            	
	            },
	            error:function(){
	            	alert("网络错误,请稍后再试");
	            }
		});
		
	}