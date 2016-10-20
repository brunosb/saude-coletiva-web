// criação de controllers

appCliente.controller("clienteController", function($scope, $http) {

	$scope.clientes = [];
	$scope.clientes = {};//bindig com o form

	carregarClientes = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;
		}, function(response) {
			console.log(response.data);
			console.log(response.status);

		});
	};
	$scope.salvarCliente = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/clientes',
			data : $scope.cliente
		}).then(function(response) {
			carregarClientes();
			$scope.cancelarAlteracaoCliente();
		}, function(response) {
			console.log(response.data);
			console.log(response.status);

		});

	}
	$scope.excluirCliente = function(cliente) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/clientes/'+cliente.id
		}).then(function(response) {
			//busacr posiçao do cliente no array 
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);

		});

	}
	$scope.alterarCliente = function(cli){
		$scope.cliente = angular.copy(cli);
	};
	
	$scope.cancelarAlteracaoCliente=function(){
		$scope.cliente={};
	};
	
	carregarClientes();
	});
