/**
 * 
 */

angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:6627/RentalAddaRest/customers.htm').
        then(function(response) {
            $scope.customer = response.data;
        });
});