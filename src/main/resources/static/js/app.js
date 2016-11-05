var appSistemaSaude = angular.module("appSistemaSaude",['ngRoute']);

appSistemaSaude.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/home",{templateUrl:'./view/home.html',controller:'homeController'})
	.when("/home/mapa-urgencia-emergencia",{templateUrl:'./view/mapa-urgencia-emergencia.html', controller:'uueController'})
	.when("/login",{templateUrl: './view/login.html', controller:'loginController'})
	.when("/teste/cadastro-usuario",{templateUrl: './view/cadastro-usuario.html', controller: 'cadastroUsuarioController'})
	.otherwise({rediretTo:'/home'});
	
	$locationProvider.html5Mode(true);
});