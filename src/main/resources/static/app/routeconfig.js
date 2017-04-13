app.config(function ($routeProvider) {
    "use strict";
	
	$routeProvider
		.when('/', { 
			templateUrl : "templates/index.html",
			controller: "HomeController"
		})
		
		.when('/error', { 
			templateUrl : "templates/error/404.html"
		})
	
		.otherwise({redirectTo: '/'});


});