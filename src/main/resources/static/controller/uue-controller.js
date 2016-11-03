appSistemaSaude.controller("uueController", function($scope, $http) {

	$scope.upas = [];
	carregarMap = function() {
		$http({
			method : 'GET',
			url : '/api/public/uue',
		}).then(function(response) {
			$scope.upas = response.data;
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	carregarMap();
	var mapOptions = {
            zoom: 10,
            center: new google.maps.LatLng(-3.7913402,-38.6593579),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }

        $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

        $scope.markers = [];
        
        var infoWindow = new google.maps.InfoWindow();  
        	    
        var createMarker = function (upas){
            var marker = new google.maps.Marker({
                map: $scope.map,
                position: new google.maps.LatLng(upas.enderecoCoordenada),
                title: upas.nome
            });
            marker.content = '<div class="infoWindowContent">' + upas.especialidade + '<br />' + upas.enderecoPostal +  ' </div>';
            
            google.maps.event.addListener(marker, 'click', function(){
                infoWindow.setContent('<h2>' + marker.title + '</h2>' + 
                  marker.content);
                infoWindow.open($scope.map, marker);
            });
            
            $scope.markers.push(marker);
            
        }  
        
        for (i = 0; i < $scope.upas.length; i++){
        	createMarker($scope.upas[i]);
        }

        $scope.openInfoWindow = function(e, selectedMarker){
            e.preventDefault();
            google.maps.event.trigger(selectedMarker, 'click');
        }
});	