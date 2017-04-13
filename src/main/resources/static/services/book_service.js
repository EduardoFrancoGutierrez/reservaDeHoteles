angular.module("reservas").service("bookService", ['requestService',  function(requestService) {
	"use strict";
	
	this.create = function(book) {
		return requestService.request({ method: 'POST', url: '/api/books', data: book });
	}
}]);