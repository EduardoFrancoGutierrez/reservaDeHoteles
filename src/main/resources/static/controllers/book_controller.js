angular.module("reservas").controller("BookController", ['hotelService', 'bookService', function(hotelService, bookService) {
	var vm = this;
	
	vm.hotels = [];
	
	vm.clearBook = {
		client: {
			name: '',
			surname: '',
			nif: '',
			movil: '',
			email: '',
			address: ''
		},
		hotel: { 
			name: ''
		},
		room: {}
	}
	
	vm.book = {};
	
	vm.getHotels = function() {
		return vm.requestToGetHotels(hotelService);
	}
	
	vm.requestToGetHotels = function(hotelService) {
		  angular.fromJson(hotelService.findAll().then(function(result){
	          	vm.hotels			= result;	          	
          }));            
	}
	
	vm.getHotels();
	
	vm.showRooms = function(hotel) {
		hotel.showRooms = true;
	}
	
	vm.bookRoom = function(hotel, room) {
		vm.book = vm.clearBook;
		vm.book.hotel = hotel;
		vm.book.room = room;
	}
	
	vm.createBook = function(book) {
		book.endDate =  moment(book.startDate).add(book.hours, 'hours').unix();		
		book.startDate = moment(book.startDate).unix();		
		vm.requestToCreateBook(bookService, book);
	}
	
	vm.requestToCreateBook = function(bookService, book) {
		bookService.create(book);
	}
}]);