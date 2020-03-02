var a=angular.module("main",[]);

a.controller("mainctrl",function($scope,$http){
    $scope.id="";
    $scope.menus=[];
    $scope.sss=[];

    $scope.fun1=function(){
    	
        $scope.id=window.localStorage.getItem("id");
       // var f=$http.get(managerserver+"/manager/menu?id="+ $scope.id);
        var f=$http.get("/manager/menu?id="+ $scope.id);
        f.success(function(result){
        	$scope.menus = result.data;
            $scope.sss=[];
            for(var i=0;i<$scope.menus.length;i++){
                $scope.sss.push(false);  //每个都menu首先都为false
            }
           // $scope.sss[0]=true;
            

        });
    };
    
    $scope.fun_verify=function(index){
    	
        for(var i=0;i<$scope.sss.length;i++){
        	if(i==index){
        		
        		break;
        	}
            $scope.sss[i]=false;
        }
        if($scope.sss[index]==true){
        	$scope.sss[index]=false;
        } else{
        	$scope.sss[index]=true;
        }
        	
    };

    $scope.fun1();

});