var mapstraction;
var maposition;
var positions = new Array();
var markers = new Array();
var resultats = new Array();
var markersR = new Array();
            
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
								infoBubble: "Ma position: Latitude : " + position.coords.latitude + " Longitude : " + position.coords.longitude,
								label: "tooltip",
								date: "new Date()",
								marker: 4,
								iconShadow: "http://mapstraction.appspot.com/images/blank.png",
								iconShadowSize : [0,0],
								draggable : true,
								hover: true
				});
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
				/*		alert(positions.length);
				for(var i in markers){
								alert("geo");
								mapstraction.addMarker(markers[i]);
				}*/
                
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

            
$.fx.speeds._default = 500;
function setDialogWindow(idParc){
				$( '#InfoParc'+idParc ).dialog({
								autoOpen: true,
								show: 'blind',
								hide: 'explode'
				});
				$( '#openerInfoParc'+idParc).click(function() {
								$( '#InfoParc'+idParc ).dialog( 'open' );
								return false;
				});
}
												
												
function ajaxAmi(data, nom, prenom, lat, lon, select) {
				var ajaxStatus = data.status;
				switch (ajaxStatus) {
								case "begin": // Statut juste avant que la requête Ajax soit envoyée
												break;
 
								case "complete": // Statut juste après que la réponse à la requête soit reçue
												break;
 
								case "success": // Statut juste après que le traitement Ajax soit terminé
												afficherAmiCarte(nom, prenom, lat, lon, select);
												break;
				}
}
												
function afficherAmiCarte(nom, prenom, lat, lon, select){
				if (select){
								for(var i in positions){
												if (positions[i].lat==lat && positions[i].lon==lon){
																mapstraction.removeMarker(markers[i]);
																delete markers[i];
																delete positions[i];
												}
								}
				}
				else {
								var pos = new mxn.LatLonPoint(lat, lon);
								var mark = new mxn.Marker(pos);
								mark.setIcon("script/OpenLayers/img/marker-green.png");
								mark.setInfoBubble(nom+" "+prenom+" : Latitude : "+lat+" Longitude: "+lon);
								mark.setHover(true);
								positions.push(pos);
								markers.push(mark);
								mapstraction.addMarker(mark);
				}
				mapstraction.autoCenterAndZoom();
}

function ajaxParc(data) {
				var ajaxStatus = data.status;
				switch (ajaxStatus) {
								case "begin": // Statut juste avant que la requête Ajax soit envoyée
												break;
 
								case "complete": // Statut juste après que la réponse à la requête soit reçue
												break;
 
								case "success": // Statut juste après que le traitement Ajax soit terminé
												document.getElementById('cache').onchange();
												break;
				}
}

function afficherResultCarte(tabResLib, tabResLat, tabResLong) {
				var t = resultats.length;
				for (var i = 0; i<t; i++){
								mapstraction.removeMarker(markersR[i]);
								delete markersR[i];
								delete resultats[i];
				}
				var libs = tabResLib.toString().split(',');
				var lats = tabResLat.toString().split(',');
				var lons = tabResLong.toString().split(',');
				for (var p = 0; p<lats.length; p++){
								var res = new mxn.LatLonPoint(lats[p], lons[p]);
								var markRes = new mxn.Marker(res);
								if (p == 0){
												markRes.setIcon("script/OpenLayers/img/marker.png");
								}
								else {
												markRes.setIcon("script/OpenLayers/img/marker-blue.png");
								}
								markRes.setInfoBubble(libs[p]);
								markRes.setHover(true);
								resultats.push(res);
								markersR.push(markRes);
								mapstraction.addMarker(markRes);
				}
				mapstraction.autoCenterAndZoom();
}