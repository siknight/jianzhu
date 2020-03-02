/**
 * 获奖展示 查询前几期的前三名作品
 */
var app=angular.module("prizeapp",[]);
app.controller("prizectl",function($scope,$http){
	
    $scope.priworks=[];
    
    $scope.maxperiod=[];
    
    //本期只有发布了奖品才能查本期的奖品
    
    /*期数切换，a为切换的期数；maxperiod为总期数*/
    $scope.show =  function(index,maxperiod=$scope.maxperiod){
    	var a = $scope.maxperiod-index;
        $("#term"+a).css("visibility","visible");//设置元素可见
    	
        var qishu=new Array(maxperiod);
        
    	for(i=0;i<=maxperiod-1;i++){
    		qishu[i]=i+1;//qishu[0]=1 qishu[2]=3
    		
    	}
    	qishu[a-1]=0;//要显示的期数，假设是第三期
    	for(i=0;i<=maxperiod-1;i++){
    		if(qishu[i]==0){//如果
    			x=i+1;
    			 $("#term"+x).css("visibility","visible");//设置元素可见

    		}
    	    else{
    			x=i+1;
    			 $("#term"+x).css("visibility","hidden");//设置元素不可见

    	    }
    	}  	
    }
    
    $scope.loadover = function(event,index){
    	var a = index+1;
    	
    	$('#wrap'+a+' ul li').hover(function(){
			$(this).stop().animate({
				width:'1100px'
			},1000).siblings().stop().animate({
				width: '150px'
			},1000);
		});
    	
    	
    	
    }
    
  
    $scope.topOver = function(event){//event代表把标签本身传进去
    	//window.alert('moouse over');    	
    	var id=event.target.getAttribute("id");  
    	  $("#"+id).css("background","grey"); //设置背景图片
    }
    
    $scope.topLeave = function(event){
    	//window.alert('mouse leave');
    	var id=event.target.getAttribute("id");   
    	 $("#"+id).css("background","none"); //设置背景图片
    }
    
    $scope.findMaxPeriod=function(){
    	var p = $http({  
    	    method: 'GET',  
    	    //url: 'http://localhost:8085/raceinfo/periodvalue'  
    	    url:'/raceinfo/periodvalue'  
    	  });  
    	  p.success(function(result){  
    		  if (result.code==0){//查询成功
    			  $scope.maxperiod = result.data;
    		  }
    	  }); 
    }
    
    $scope.showall=function(){
    	var p = $http({  
    	    method: 'GET',  
    	    //url: 'http://localhost:8085/work/allwin'  
    	    url: '/work/allwin'  
    	  });  
    	  p.success(function(result){  
    		  if (result.code==0){//查询成功
    			  $scope.priworks = result.data;
    		  }
    		 
    	  });  
    }
    
    
    
    $scope.findMaxPeriod();//这个应该要先执行

    $scope.showall();


});