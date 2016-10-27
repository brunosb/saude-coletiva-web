var cities = [
              {
                  place : 'India',
                  desc : 'A country of culture and tradition!',
                  lat : 23.200000,
                  long : 79.225487
              },
              {
                  place : 'New Delhi',
                  desc : 'Capital of India...',
                  lat : 28.500000,
                  long : 77.250000
              },
              {
                  place : 'Kolkata',
                  desc : 'City of Joy...',
                  lat : 22.500000,
                  long : 88.400000
              },
              {
                  place : 'Mumbai',
                  desc : 'Commercial city!',
                  lat : 19.000000,
                  long : 72.90000
              },
              {
                  place : 'Bangalore',
                  desc : 'Silicon Valley of India...',
                  lat : 12.9667,
                  long : 77.5667
              }
          ];

          //Angular App Module and Controller
         
		appSistemaSaude.controller('mapController', function ($scope) {
              
              var mapOptions = {
                  zoom: 4,
                  center: new google.maps.LatLng(25,80),
                  mapTypeId: google.maps.MapTypeId.ROADMAP
              }

              $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

              $scope.markers = [];
              
              var infoWindow = new google.maps.InfoWindow();
              
              var createMarker = function (info){
                  
                  var marker = new google.maps.Marker({
                      map: $scope.map,
                      position: new google.maps.LatLng(info.lat, info.long),
                      title: info.place
                  });
                  marker.content = '<div class="infoWindowContent">' + info.desc + '<br />' + info.lat + ' E,' + info.long +  ' N, </div>';
                  
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