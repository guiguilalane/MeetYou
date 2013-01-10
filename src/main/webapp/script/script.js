var mapstraction;
var maposition;
var autrePosition;
            
/*
             *Fonction utilisant la technologie Ajax, prend en paramètre une url et la fonction de traitement du résultat
             *@param url - Correspond au fichier(ou servlet) de traitement de la requête.
             *@param callback - nom de la fonction de traitement du résultat de la requête.*/
function requestXML(url, callback){
				var xhr = getXMLHttpRequest();
                
				xhr.onreadystatechange = function() {
								if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
												callback(xhr.responseXML); // C'est bon \o/
								}
				};
                
				xhr.open("GET", url, true);
				xhr.send();
}
            
function maPosition(position)
{
				var POI = new mxn.LatLonPoint(position.coords.latitude, position.coords.longitude);
				maposition = POI;
				var myMarker = new mxn.Marker(POI);
				mapstraction.addMarkerWithData(myMarker, {
								infoBubble: "Ma position, latitude : " + position.coords.latitude + " longitude : " + position.coords.longitude,
								label: "tooltip",
								date: "new Date()",
								marker: 4,
								iconShadow: "http://mapstraction.appspot.com/images/blank.png",
								iconShadowSize : [0,0],
								draggable : true,
								hover: true
				});
				autrePosition = new mxn.LatLonPoint(47.26652, -1.51364);
				var otherMarker = new mxn.Marker(autrePosition);
				mapstraction.addMarker(otherMarker);
				mapstraction.autoCenterAndZoom();
}

function erreurPosition(error) {
				var info = "Erreur lors de la géolocalisation : ";
				switch(error.code) {
								case error.TIMEOUT:
												info += "Timeout !";
												break;
								case error.PERMISSION_DENIED:
												info += "Vous n’avez pas donné la permission";
												break;
								case error.POSITION_UNAVAILABLE:
												info += "La position n’a pu être déterminée";
												maposition = new mxn.LatLonPoint(47.218371, -1.553621);
												break;
								case error.UNKNOWN_ERROR:
												info += "Erreur inconnue";
												break;
				}
				alert(info);
}
            
function getParcours(sData){
				//                var coord = 'maposlat='+maposition.lat+'&maposlon='+maposition.lon+'&autreposlat='+autrePosition.lat+'&autreposlon='+autrePosition.lon;
				//                var url = "dataReceiver?" + coord;
				//                  alert(sData);
				var coordonne = sData.getElementsByTagName("coord");
				//                  alert(coordonne[0].getAttribute("lat"));
				var polyLine = new Array();
				for(var i = 0; i < coordonne.length; i++){
								polyLine.push(new mxn.LatLonPoint(coordonne[i].getAttribute("lat"), coordonne[i].getAttribute("long")));
				}
				var myPoly = new mxn.Polyline(polyLine);
				myPoly.setWidth(2);
				myPoly.setColor("#b72a3a");
				mapstraction.addPolyline(myPoly);
}

function geolocalisation(){
				mapstraction = new mxn.Mapstraction('OpenStreetMap', 'openlayers');
                
				if(navigator.geolocation)
				{
								navigator.geolocation.getCurrentPosition(maPosition, erreurPosition, {
												enableHighAccuracy:true
								});
				}
				else
				{
								alert("La géolocalisation n'est pas supportée par votre navigateur.");
				}
}