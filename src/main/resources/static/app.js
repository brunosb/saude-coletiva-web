//criação do modulo principal da aplicaçao
var appCliente = angular.module("appCliente", ['ngRoute']);

appCliente.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/about",{templateUrl:'telas/about.html', controller:'clienteController'})
	.otherwise({rediretTo:'/'});
	
	$locationProvider.html5Mode(true);
});
	
