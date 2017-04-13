app.config(function ($routeProvider) {
    "use strict";
	
	$routeProvider
		.when('/', { 
			templateUrl : "templates/hotel_list_to_book.html",
			controller: "BookController"
		})
		
		.when('/error', { 
			templateUrl : "templates/error/404.html"
		})
	
		.otherwise({redirectTo: '/'});


});