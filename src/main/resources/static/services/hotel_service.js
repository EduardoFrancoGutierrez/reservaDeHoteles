angular.module("reservas").service("hotelService", ['requestService',  function(requestService) {
	"use strict";
	
	this.findAll = function() {
		return requestService.request({ method: 'GET', url: '/api/hotels/androoms' });
	}
}]);