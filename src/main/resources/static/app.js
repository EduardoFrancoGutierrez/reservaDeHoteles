/**
 * CommonJS file to define the angular module for our application.
 * This module has 'ngRoute' and 'angularCSS' modules as dependencies.
 */

var mainApplicationModuleName = 'reservas';

angular.module(mainApplicationModuleName, ['ngRoute', 'angularCSS', 'ui.bootstrap.datetimepicker', 'ui.dateTimeInput']);

angular.element(document).ready(function () {
    angular.bootstrap(document, [mainApplicationModuleName]);
});
