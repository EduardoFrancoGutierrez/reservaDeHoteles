angular.module("reservas").controller('BooksController',
		function(getHotelsService, getBooksByHotelService, bookService) {
			"use strict";
	
			const THERE_IS_NOT_HOTELS 				= "ERROR. No existen hoteles registrados en la aplicación";
			const SELECTED_HOTEL_OPTION_IS_EMPTY 	= "ERROR. Seleccione al menos un hotel";
			const THERE_IS_NOT_BOOKS_IN_HOTEL 		= "No existen reservas para este hotel";
			const OK_RESPONSE_CODE 					= 200;

			var vm = this;

			vm.hotels 	= [];
			vm.books 	= [];
			
			vm.cancelId = 0;
			vm.showError = false;
			
			vm.setCancel = function(bookingId) {
				vm.cancelId = bookingId;
			}
			
			vm.cancelBooking = function(bookingId) {
				vm.cancelMessage = undefined;
				bookService.cancelBooking(bookingId)
				.then(function(result){
					vm.cancelMessage = "Reserva cancelada con éxito";
					vm.requestToGetBooks(getBooksByHotelService, vm.hotel);
				})
				.catch(function(error){
					vm.cancelMessage = error;
				});
			}

			vm.getHotels = function() {
				getHotelsService.getHotels().then(function(serverResponse) {
					var serverResponse = angular.fromJson(serverResponse);
	                
	                if (serverResponse.status === OK_RESPONSE_CODE) {
	                	vm.hotels = serverResponse.data;
	                	
	                	if (vm.hotels.length === 0) {
	                		vm.showError = true;
	                		vm.error = THERE_IS_NOT_HOTELS;
	                	}
	                    else {
	                    	vm.showError = false;
	                    	vm.error = null;
	                    }	
	                }
	                else {
	                	vm.showError = true;
	                	vm.error = THERE_IS_NOT_HOTELS;
	                }
				}, function() {
					vm.showError = true;
					vm.error = vm.error = THERE_IS_NOT_HOTELS;;
				});
			};
			
			vm.getBooks = function () {
	            if ((vm.hotel !== undefined) && (vm.hotel.length > 0)) {
	                vm.error = null;
	                vm.showError = false;
	                
	                vm.requestToGetBooks(getBooksByHotelService, vm.hotel);
	            }
	            else {
	            	vm.showError = true;
	            	vm.error = SELECTED_HOTEL_OPTION_IS_EMPTY;
	            }
	        };
	        
	        vm.requestToGetBooks = function (serviceToGetBooks, queryParameter) {
	        	serviceToGetBooks.getBooks(queryParameter).then(function(serverResponse) {
					var serverResponse = angular.fromJson(serverResponse);
	                
	                if (serverResponse.status === OK_RESPONSE_CODE) {
	                	vm.books = serverResponse.data;
	                	
	                	if (vm.hotels.length === 0) {
	                		vm.showError = true;
	                		vm.error = THERE_IS_NOT_BOOKS_IN_HOTEL;
	                	}
	                    else {
	                    	vm.showError = false;
	                    	vm.error = null;
	                    }
	                }
	                else {
	                	vm.showError = true;
	                	vm.error = THERE_IS_NOT_BOOKS_IN_HOTEL;
	                }
				}, function() {
					vm.showError = true;
					vm.error = vm.error = THERE_IS_NOT_BOOKS_IN_HOTEL;
				});
	        }
		});