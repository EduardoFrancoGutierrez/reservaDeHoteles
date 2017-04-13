angular.module("reservas").controller("CancelController", ['bookService', function(bookService) {
	var vm = this;
	
	vm.book = undefined;
	vm.error = undefined;
	vm.cancelMessage = undefined;
	
	vm.getBook = function(reservationCode) {
		vm.error = undefined;
		vm.book = undefined;
		if (!reservationCode) {
			vm.error = "Debe introducir un código de reserva";
			return;
		}
		angular.fromJson(bookService.getBookByReservationCode(reservationCode)
		.then(function(result){
			if (result === ""){
				vm.error = "No hay ninguna reserva asociada al código introducido"
			} else if (result.status === "CANCEL"){
				vm.error = "Esta reserva está ya cancelada"
			} else {
				vm.book = result;	
			}         	
		})
		.catch(function(error){
			vm.error = error;
		}));          
	}
	
	vm.cancelBooking = function(bookingId) {
		vm.cancelMessage = undefined;
		bookService.cancelBooking(bookingId)
		.then(function(result){
			vm.cancelMessage = "Reserva cancelada con éxito";
		})
		.catch(function(error){
			vm.cancelMessage = error;
		});
	}
}]);