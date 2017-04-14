angular.module("reservas").controller('BooksController',
		function(getHotelsService, getBooksByHotelService) {
			const THERE_IS_NOT_HOTELS 				= "ERROR. No existen hoteles registrados en la aplicación";
			const SELECTED_HOTEL_OPTION_IS_EMPTY 	= "ERROR. Seleccione al menos un hotel";
			const THERE_IS_NOT_BOOKS_IN_HOTEL 		= "No existen reservas para este hotel";
			const OK_RESPONSE_CODE 		= 200;

			var vm = this;

			vm.hotels 	= [];
			vm.books 	= [];

			vm.getHotels = function() {
				getHotelsService.getHotels().then(function(serverResponse) {
					var serverResponse = angular.fromJson(serverResponse);
	                
	                if (serverResponse.status === OK_RESPONSE_CODE) {
	                	vm.hotels = serverResponse.data;
	                	
	                	if (vm.hotels.length === 0)
	                    	vm.error = THERE_IS_NOT_HOTELS;
	                    else
	                    	vm.error = null;
	                }
	                else
	                	vm.error = THERE_IS_NOT_HOTELS;
				}, function() {
					vm.error = vm.error = THERE_IS_NOT_HOTELS;;
				});
			};
			
			vm.getBooks = function () {
	            if ((vm.hotel !== undefined) && (vm.hotel.length > 0)) {
	                vm.error = null;
	                
	                vm.requestToGetBooks(getBooksByHotelService, vm.hotel);
	            }
	            else 
	            	vm.error = SELECTED_HOTEL_OPTION_IS_EMPTY;
	        };
	        
	        vm.requestToGetBooks = function (serviceToGetBooks, queryParameter) {
	        	vm.books = angular.fromJson(serviceToGetBooks.getBooks(queryParameter));
	        }
		});