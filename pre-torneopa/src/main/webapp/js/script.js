var app=angular.module("app",[]);


app.controller("SeguroController",['$scope','$log','$http',function($scope,$log,$http) {
	  
	   
	 
	  $http({
	    method: 'GET', 
	    url: 'datos.json'
	  }).success(function(data, status, headers, config) {
	      $scope.seguro=data;
	  }).error(function(data, status, headers, config) {
	      alert("Ha fallado la peticiÃ³n. Estado HTTP:"+status);
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

app.controller('userController',['$scope','$log','$http',function($scope,$log,$http) {
	
	$scope.vari=2;
	
	  $http({
		    method: 'GET', 
		    url: 'java/servicios/UserRestful'
		  }).success(function(data, status, headers, config) {
		      $scope.users=data;
		  }).error(function(data, status, headers, config) {
		      alert("Ha fallado la peticiÃ³n. Estado HTTP:"+status);
		  });
	
	 
	  $http({
		    method: 'GET', 
		    url: 'coches.json'
		  }).success(function(data, status, headers, config) {
		      $scope.cars=data;
		  }).error(function(data, status, headers, config) {
		      alert("Ha fallado la peticiÃ³n. Estado HTTP:"+status);
		  });
   }]);

	