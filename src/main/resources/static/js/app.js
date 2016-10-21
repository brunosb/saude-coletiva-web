var appSistemaSaude = angular.module("appSistemaSaude",['ngRoute']);

appSistemaSaude.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/api/public/uue",{templateUrl:'./view/mapa-urgencia-emergencia.html', controller:'uueController'})
	.when("/login",{templateUrl: './view/login.html', controller:'loginController'})
	.when("/cadastro-usuario",{templateUrl: './view/cadastro-usuario.html', controller: 'cadastroUsuarioController'})
	.otherwise({rediretTo:'/'});
	
	$locationProvider.html5Mode(true);
});