var appSistemaSaude = angular.module(appSistemaSaude,['ngRoute']);

appSistemaSaude.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/api/public/uue",{templateUrl:'view/mapa-urgencia-emergencia.html', controller:'uueController'})
	.otherwise({rediretTo:'/'});
	
	$locationProvider.html5Mode(true);
});