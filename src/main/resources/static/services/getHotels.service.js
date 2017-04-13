angular.module("reservas").factory('getHotelsService', function ($http) {
    const endpoint = '/api/hotels';

    return {
        getHotels: function () {
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