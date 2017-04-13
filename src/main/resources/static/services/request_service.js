angular.module("reservas").service("requestService", ['$http', '$q', function($http, $q) {
	"use strict";
	
	this.request = function (config) {
        let deferred = $q.defer();
       
        $http(config).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            let errorMsg;
            
            if (response.data == null || response.data.error === undefined) {
                errorMsg = "";
            } else {
                errorMsg = " --- " + response.data.error + ":" + response.data.description;
            }
            deferred.reject(
                "Error (" + response.status + ":" + response.statusText + ")" + errorMsg);
        });
        return deferred.promise;
    }
}]);