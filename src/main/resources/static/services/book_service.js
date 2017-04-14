angular.module("reservas").service("bookService", ['requestService',  function(requestService) {
	"use strict";
	
	this.create = function(book) {
		return requestService.request({ method: 'POST', url: '/api/books', data: book });
	}
	
	this.getBookByReservationCode = function(reservationCode) {
		return requestService.request({ method: 'GET', url: '/api/books/client/' + reservationCode });
	}
	
	this.cancelBooking = function(bookingId) {
		return requestService.request({ method: 'DELETE', url: '/api/books', data: bookingId });
	}
}]);