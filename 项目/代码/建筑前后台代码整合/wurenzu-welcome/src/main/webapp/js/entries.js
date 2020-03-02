/**
 * 查询最新一期所有状态码为1的参赛作品
 */
var app=angular.module("entriesapp",[]);


app.controller("entrctl",function($scope,$http){
	
    $scope.entries=[];//key存储企业信息  value存储作品信息
    
    $scope.huadong =  function(index){//序号
        $('html, body').animate({
             scrollTop: $("#item"+index).offset().top
        }, 1000);
    }
    
  
    $scope.huadongOver = function(event){//event代表把标签本身传进去
    	var id=event.target.getAttribute("id");  
    	  $("#"+id).css("opacity","0.6"); //设置透明度
    	
    }
    
    $scope.huadongLeave = function(event){
    	var id=event.target.getAttribute("id");   
    	 $("#"+id).css("opacity","1"); //设置透明度
    }
    
//    $scope.findMaxPeriod=function(){
//    	var p = $http({  
//    	    method: 'GET',  
//    	    url: 'http://localhost:8085/raceinfo/periodvalue'  
//    	  });  
//    	  p.success(function(result){  
//    		  if (result.code==0){//查询成功
//    			  $scope.maxperiod = result.data;
//    		  }
//    	  }); 
//    }
    
    $scope.showall=function(){
    	var p = $http({  
    	    method: 'GET',  
    	    //url: 'http://localhost:8085/work/all' 
    	    url: '/work/all'
    	  });  
    	  p.success(function(result){  
    		  if (result.code==0){//查询成功
    			  $scope.entries = result.data;
    		  }
    		 
    	  });  
    }
    
    
    
    //$scope.findMaxPeriod();//这个应该要先执行

    $scope.showall();


});