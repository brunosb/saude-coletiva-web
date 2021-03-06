appSistemaSaude.controller("uueController", function($scope, $http) {

	$scope.locais = [];
	$scope.local = {};
	
	$http({
		method : 'GET',
		url : '/api/public/uue',
	}).then(function(response) {
		$scope.locais = response.data;
	    $scope.configMap();
		for (i = 0; i < $scope.locais.length; i++){
			$scope.createMarker($scope.locais[i]);
	    };
	}, function(response) {
		console.log(response.data);
		console.log(response.status);
	});
	
	$scope.cadastrar = function(){
		$http({
			method:'POST',
			url:'/api/public/uue',
			data:$scope.local	
		}).then(function(response){
			$scope.local = response.data
			$scope.createMarker(response.data)
			$scope.local={}
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.filtroMapa = function(tipo){
		$http({
			method : 'GET',
			url : '/api/public/uue/'+tipo,
		}).then(function(response) {
			$scope.locais = response.data;
		    $scope.configMap();
			for (i = 0; i < $scope.locais.length; i++){
				$scope.createMarker($scope.locais[i]);
		    };
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.configMap = function(){
		$("#map").googleMap({
			zoom: 10, // Initial zoom level (optional)
			coords: [-3.7958049, -38.5273391], // Map center (optional)
			type: "ROADMAP" // Map type (optional)
		});
	};    
	
    $scope.createMarker = function(local){
    	$("#map").addMarker({
    	  address: local.enderecoPostal, // GPS coords
	      title: local.tipo, // Title
	      text:  local.descricao
	    });
    };
});	