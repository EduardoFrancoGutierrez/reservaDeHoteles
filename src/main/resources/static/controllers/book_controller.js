angular.module(mainApplicationModuleName).controller("BookController", ['hotelService', 'bookService', function(hotelService, bookService) {
	"use strict";
	const ERROR_CREATE_BOOK 	= "ERROR AL CREAR UNA RESERVA";
	
	var vm = this;
	
	vm.hotels = [];
	vm.showOKCreate=false;
	vm.showModalBookForm=false;
	vm.showErrorCreate=false;
	vm.errorCreate="";
	
	vm.getHotels = function() {
		return vm.requestToGetHotels(hotelService);
	}
	
	vm.requestToGetHotels = function(hotelService) {
		  angular.fromJson(hotelService.findAll().then(function(result){
	          	vm.hotels = result;	          	
          }));            
	}
	
	vm.getHotels();
	
	vm.showRooms = function(hotel) {
		hotel.showRooms = true;
	}
	
	vm.bookRoom = function(hotel, room) {
		vm.book = {};
		vm.book.hotel = hotel;
		vm.book.room = room;
		vm.showModalBookForm=true;
	}
	
	vm.createBook = function(book) {
		book.startDate = book.startDate.getTime();
		book.endDate = book.startDate + (book.hours * 60 * 60 * 1000);
		vm.requestToCreateBook(bookService, book);
	}
	
	vm.requestToCreateBook = function(bookService, book) {
		bookService.create(book).then(function(result){
			vm.showErrorCreate=false;
		})
		.catch(function(error){
			vm.showErrorCreate=true;
			vm.errorCreate=ERROR_CREATE_BOOK;
		});
	}
}]);