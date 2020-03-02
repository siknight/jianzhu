/**
 * 查询所有状态码为1专家
 */

var app=angular.module("specialapp",[]);


app.controller("spectl",function($scope,$http){
	
    $scope.specials=[];
   
    $scope.tiaozhuan =  function(index){//序号
    	
    	//window.alert('Should not see me'+index);
    	
            $('html, body').animate(
            		{scrollTop: $("#architect"+index).offset().top}, 1000
            		);
    }
    
  
    $scope.architectOver = function(event){//event代表把标签本身传进去
    	//window.alert('moouse over');    	
    	var id=event.target.getAttribute("id");    
    	  $("#"+id).css("opacity","1"); //设置透明度
    	
    }
    
    $scope.architectLeave = function(event){
    	//window.alert('mouse leave');
    	var id=event.target.getAttribute("id");   
    	 $("#"+id).css("opacity","0.8"); //设置透明度
    }
    
    $scope.showall=function(){
    	var p = $http({  
    	    method: 'GET',  
    	    //url: 'http://localhost:8085/expert/findAll'  
    	    url: '/expert/findAll' 
    	  });  
    	  p.success(function(result){  
    		  if (result.code==0){//查询成功
    			  $scope.specials = result.data;
    			  
    		  }
    		 
    	  });  
    }
    

    $scope.showall();


});