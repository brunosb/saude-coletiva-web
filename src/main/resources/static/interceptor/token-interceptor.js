appSistemaSaude.factory("tokenInterceptor",function($q){
	
	return {
		'request': function(config){
			
			config.headers.Authorization = localStorage.getItem("USER_TOKEN");
			
			return config;
		}
	}
});