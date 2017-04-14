angular.module("reservas").factory('getBooksByHotelService', function($http) {
	const URI = '/api/books/hotel/';
	
	return {
		getBooks : function(hotelID) {		
			var endpoint = URI + hotelID;
			
			return $http.get(endpoint)
	            .then(function (result) {
	                    return result;
	                },
	                function (result) {
	                    return result;
	                });
		}
	}
});