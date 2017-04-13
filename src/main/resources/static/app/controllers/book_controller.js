app.controller("BookController", ['hotelService', 'bookService', function(hotelService, bookService) {
	var vm = this;
	
	vm.hotels = [];
	
	vm.getHotels = function() {
		return vm.requestToGetHotels(hotelService);
	}
	
	vm.requestToGetHotels = function(hotelService) {
		  angular.fromJson(hotelService.findAll().then(function(result){
	          	vm.hotels			= result;	          	
          }));            
	}
	
	vm.greeting = 'Hola!';
	
	vm.getHotels();
}]);