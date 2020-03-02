<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("PATH", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>  
<link rel="stylesheet" type="text/css" href="${PATH }/manager/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${PATH }/manager/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${PATH }/manager/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${PATH }/manager/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${PATH }/manager/static/h-ui.admin/css/style.css" />
<title>新增图片</title>
<link href="${PATH }/manager/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<form class="form form-horizontal" id="form-banner-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>图片标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="bannerTitle" name="bannerTitle">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>终端类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="terminal_type" id="terminal_type" class="select">
					<option value="0">PC</option>
					<option value="1">移动APP</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="" id="bannerno" name="bannerno">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="" id="bannerUrl" name="bannerUrl">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2" for="nameInput">头像：</label>
			<div class="form-group">
				<input type="file" class="form-control" name="imageFile" id="imageFile" style="width:245px;">
				<input type="text" class="form-control" name="bannerimg" id="hiddenImage" style="display: none;">
				<button type="button" onclick="uploadImage()"  class="btn btn-warning">上传</button> 
				<img id="imagehow" src="" style="width:100px;border:1px solid #FFFFFF;">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="onSubmit()" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${PATH }/manager/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${PATH }/manager/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${PATH }/manager/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${PATH }/manager/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="./common/js/ajaxfileupload.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${PATH }/manager/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${PATH }/manager/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${PATH }/manager/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">

var baseUrl = '${pageContext.request.contextPath }';
var curWwwPath=window.document.location.href; 
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos); 
function validateImgFile(fileId){
   var fileVal = $("#"+fileId).val();
   if(fileVal == ""){
   	   layer.alert('请选择上传的文件!', {icon: 5});
	   return;
   }
   if(fileVal.lastIndexOf(".") == -1){
	  layer.alert('上传图片格式只支持:jpg、jpeg、png等文件格式', {icon: 5});
	  return;
   }
   var fileSuffix = fileVal.substring(fileVal.lastIndexOf(".")+1,fileVal.length);
   var upperSuffix = fileSuffix.toUpperCase();
   if("JPEG" != upperSuffix && "PNG" != upperSuffix && "JPG" != upperSuffix){
	   layer.alert('上传图片格式只支持:jpg、jpeg、png等文件格式', {icon: 5});
	   return;
   }
   return true;
}
function uploadImage() {
	   var validSuccess = validateImgFile("imageFile");
	   if(validSuccess){
		   $.ajaxFileUpload({  
	      	 url : baseUrl+"/uploadImgs.do",  
	       	 secureuri : false,  
	       	 fileElementId : 'imageFile',  
	       	 dataType : 'json',  
	       	 success : function(data,status) {
	        		if("success" == status){
	        			layer.alert('上传图片成功', {icon: 6});
		           		$("#hiddenImage").val(data.filepath); 
		           	    $("#imagehow").attr("src",baseUrl+"\\"+data.filepath);
		           	}else{
		           	  console.log(44);
		           		layer.alert('上传图片失败', {icon: 5});
		           	}
	        }
	     });  
	   }
	}  
 	
 	function onSubmit(){
	   var send = {
			 bannertitle: $('#bannerTitle').val(),
			 terminalType: $('#terminal_type').val(),
			 bannerno: $('#bannerno').val(),
			 bannerurl: $('#bannerUrl').val(),
			 bannerimg:$('#hiddenImage').val()
      }
   	 $.post( baseUrl+"/bannerAdd.do",send, function( data ) {
            if(data.code == 100){
            		layer.alert('添加成功', {icon: 6});
						layer.alert('添加成功', {
						    closeBtn: 1    // 是否显示关闭按钮
						    ,btn: ['确定'] //按钮
						    ,icon: 6    // icon
						    ,yes:function(){
						       parent.$('.btn-refresh').click();
								var index = parent.layer.getFrameIndex(window.name);
								window.parent.location.reload(); //刷新父页面
						    }});
			}else{
				layer.alert('添加失败', {icon: 5});
			}
        });
	}
</script>
</body>
</html>