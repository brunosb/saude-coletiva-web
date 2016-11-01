

/*var cities = [
              {
                  place : 'UPA Itaperi',
                  desc : 'Pediatria',
                  lat : -3.7956203,
                  long : -38.5544505,
                  adress:'R. Betel - Dendê, Fortaleza - CE'
              },
              {
                  place : 'UPA Canindezinho',
                  desc : 'Saúde da mulher',
                  lat : -3.8216391,
                  long : -38.6088886,
                  adress:'R. José Paixão de Lima, S/n - Canindezinho, Fortaleza - CE'
              },
              {
                  place : 'UPA José Walte',
                  desc : 'Saúde do homem',
                  lat : -3.8255751,
                  long : -38.541341,
                  adress:'Av. Presidente Costa e Silva, s/n - Prefeito José Walter, Fortaleza - CE'
              }
          ];*/

          //Angular App Module and Controller
         
		appSistemaSaude.controller('mapController', function ($scope,$http) {
			
			$scope.localidades = [];
			carregarLocalidades = function() {
				$http({
					method : 'GET',
					url : '/api/public/uue',
				}).then(function(response) {
					$scope.localidades = response.data;
				}, function(response) {
					console.log(response.data);
					console.log(response.status);
				});
			};
			//carregarlocalidades();
			
			
              var mapOptions = {
                  zoom: 10,
                  center: new google.maps.LatLng(-3.7913402,-38.6593579),
                  mapTypeId: google.maps.MapTypeId.ROADMAP
              }

              $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

              $scope.markers = [];
              
              var infoWindow = new google.maps.InfoWindow();
              
              var createMarker = function (info){
                  
                  var marker = new google.maps.Marker({
                      map: $scope.map,
                      position: new google.maps.LatLng(info.endecoCoordenada),
                      title: info.place
                  });
                  marker.content = '<div class="infoWindowContent">' + info.desc + '<br />' + info.adress +  ' </div>';
                  
                  google.maps.event.addListener(marker, 'click', function(){
                      infoWindow.setContent('<h2>' + marker.title + '</h2>' + 
                        marker.content);
                      infoWindow.open($scope.map, marker);
                  });
                  
                  $scope.markers.push(marker);
                  
              }  
              
              for (i = 0; i < cities.length; i++){
                  createMarker(cities[i]);
              }

              $scope.openInfoWindow = function(e, selectedMarker){
                  e.preventDefault();
                  google.maps.event.trigger(selectedMarker, 'click');
              }

          });