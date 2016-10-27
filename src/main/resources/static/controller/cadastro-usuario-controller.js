appSistemaSaude.controller("cadastroUsuarioController", function($scope, $http){
		
	$scope.usuario = {};
		$scope.cadastrarUsuario = function(){
			$http({
				method:'POST',
				url:'api/private/user',
				data:$scope.usuario	

			
			}).then(function(response){
				$scope.usuario = response.data
			}, function(response) {
				console.log(response.data);
				console.log(response.status);
			});
		};
		
	
});