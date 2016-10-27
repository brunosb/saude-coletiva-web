var appSistemaSaude = angular.module("appSistemaSaude",['ngRoute']);

appSistemaSaude.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/mapa-urgencia-emergencia",{templateUrl:'./view/mapa-urgencia-emergencia.html', controller:'mapController'})
	.when("/login",{templateUrl: './view/login.html', controller:'loginController'})
	.when("/cadastro-usuario",{templateUrl: './view/cadastro-usuario.html', controller: 'cadastroUsuarioController'})
	.when("/home",{templateUrl:'./view/home.html',controller:'homeController'})
	.otherwise({rediretTo:'/'});
	
	$locationProvider.html5Mode(true);
});