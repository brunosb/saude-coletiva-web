appSistemaSaude.controller("uueController", function($scope, $http) {

	$scope.upas = [];

	carregarUpas = function() {
		$http({
			method : 'GET',
			url : '/api/public/uue'
		}).then(function(response) {
			$scope.upas = response.data;
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
});	