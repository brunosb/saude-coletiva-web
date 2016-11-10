appSistemaSaude.controller("loginController", function ($scope, $http) {
	
	$scope.usuario = {};
	
	$scope.autenticar = function(){
		$http.post("/api/permission/auth",$scope.usuario)
		.then(function(response){
			console.log("Sucesso "+response.data.token);
			localStorage.setItem("USER_TOKEN",response.data.token);
		},function(response){
			console.log("Falha "+response)
		});
		
	};
	
});