angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.changeAge = function (studentId) {
        $http({
            url: contextPath + '/students/change_age',
            method: 'GET',
            params: {
                studentId: studentId
//                delta: delta
            }
        }).then(function (response) {
            $scope.loadStudents();
        });


    $scope.addStudent = function (studentId, studentName, studentAge) {
        $http({
            url: contextPath + '/students/stud_add',
            method: 'GET',
            params: {
                studentId: studentId,
                studentName: studentName,
                studentAge: studentAge
            }
        }).then(function (response) {
            $scope.loadStudents();
        });
    }


    $scope.loadStudents();
});