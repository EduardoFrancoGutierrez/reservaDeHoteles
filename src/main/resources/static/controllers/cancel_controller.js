angular.module("reservas").controller("CancelController", ['bookService', function(bookService) {
	var vm = this;
	
	vm.book = {};
	vm.error = {};
	
	vm.getBook = function(reservationCode) {
		angular.fromJson(bookService.getBookByReservationCode(reservationCode)
		.then(function(result){
			vm.book = result;	          	
		})
		.catch(function(error){
			vm.error = error;
		}));          
	}
	
	vm.cancelBooking = function(bookingId) {
		bookService.cancelBooking(bookingId).catch(function(error){
			vm.error = error;
		});
	}
}]);