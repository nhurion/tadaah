'use strict';

angular.module('tadaahAngularApp')
    .controller('MainCtrl', function ($scope, $http) {

      $scope.currentTodo = '';
      $scope.setCurrentTodo = function (todo) {
        $scope.currentTodo = todo;
      };

      $http.get('/todo').
          success(function (todos) {
            $scope.todos = todos;
          }).error(function (data) {
            console.error('Error fetching feed:', data);
          }
      );
    });
