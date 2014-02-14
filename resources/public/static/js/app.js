(function() {
  'use strict';
  angular.module('herenowApp', ['ngCookies', 'ngResource', 'ngSanitize', 'ngRoute']).config(function($routeProvider) {
    return $routeProvider.when('/', {
      templateUrl: 'static/views/main.html',
      controller: 'MainCtrl'
    }).otherwise({
      redirectTo: '/'
    });
  });

  $(function() {
    var navMain;
    navMain = $("#main-menu");
    return navMain.on("click", "a", null, function() {
      return navMain.collapse('hide');
    });
  });

}).call(this);

(function() {
  'use strict';
  angular.module('herenowApp').controller('MainCtrl', function($scope, $http) {
    var loadNiceThings;
    $scope.niceThings = [];
    loadNiceThings = function() {
      return $http({
        method: 'GET',
        url: '/api/nicethings',
        headers: {
          'Accept': 'application/json'
        }
      }).success(function(data) {
        return $scope.niceThings = data.things;
      });
    };
    return loadNiceThings();
  });

}).call(this);
