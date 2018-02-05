var app=angular.module("app",[]);


app.controller("SeguroController",['$scope','$log','$http',function($scope,$log,$http) {
	  
	   
	 
	  $http({
	    method: 'GET', 
	    url: 'datos.json'
	  }).success(function(data, status, headers, config) {
	      $scope.seguro=data;
	  }).error(function(data, status, headers, config) {
	      alert("Ha fallado la petición. Estado HTTP:"+status);
	  });
	   
	}]);


app.controller('SeguroControllerEnvio',['$scope','$log','$http',function($scope,$log,$http) {
    $scope.count = 0;
    $scope.myFunc = function() {
        $scope.count++;
    };
    	
    $scope.postdata = function () {
      
    	$scope.count++;
    
    }
   
    
    app.run(function() {
    	  $scope.count = 10;
    	$scope.count++;
    	});
    
    
   }]);

