var app = angular.module('studentwebapp', ['ngRoute']);

app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "studentTable.html",
            controller: "AppCtrl"
        })
        .when("/update", {
            templateUrl: "updateStudent.html",
            // controller: "AppCtrl"
        })
        .when("/add", {
            templateUrl: "addStudent.html",
            controller: "studentFormCtrl"
        })
        .otherwise({
            redirectTo: '/'
        });

    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('');

});
app.factory('studentService', function(){
    var studentObj = null;
    return{
        getObject:function(){
            return studentObj;
        },
        setObject:function(obj){
            studentObj=obj;
        }
    }
});
app.controller("AppCtrl", function ($scope, $location, $http, studentService) {
    $scope.student = {
        rollno: "",
        name: "",
        degree: "",
        department: "",
        address: "",
        cgpa: ""
    };
    $scope.addStudent = function () {
        $location.path('/add');
    };

    $scope.editStudent = function (student) {
        
        $scope.student=student;
        console.log("****************");
        console.log($scope.student);
        console.log("****************");
        studentService.setObject($scope.student);
        $location.path('/update');
        
    };

    $scope.deleteStudent=function(student){
        alert('Data to be deleted: '+student.name);
        console.log(student);
        console.log(student.rollno);
        $http({
            method: 'DELETE',
            url: ('http://localhost:8080/studentapp/student/'+student.rollno),
        })
        console.log("**DELETED*******");
        console.log("redirecting to student list page");
        $location.path('/student');
    }
   
    $scope.students = []
    $http.get("http://localhost:8080/studentapp/students")
        .then(function (response) {
            $scope.students = response.data;
        });
});

app.controller("updateCtrl", function ($scope,$http,$location,studentService) {

    console.log("**updatePage");
    var newobj = studentService.getObject();
    $scope.studentData=newobj;
    $scope.degrees = ["B.E", "M.E", "M.B.A"];
    $scope.departments = ["CSE", "ECE", "MECH", "EEE"];

    $scope.updateStudentForm= function(){
        alert("update for Roll_No: "+$scope.studentData.rollno);
        console.log("Update Operation");
        console.log($scope.studentData);
        $http({
            method: 'PUT',
            url: ('http://localhost:8080/studentapp/student/'+$scope.studentData.rollno),
            data: $scope.studentData
            
        })
        console.log("**UPDATED*******");
        console.log("redirecting to student list page");
        $location.path('/student');
    }
});

app.controller("addCtrl", function ($scope) {
    $scope.student = {
        rollno: "",
        name: "",
        degree: "",
        department: "",
        address: "",
        cgpa: ""
    }

    $scope.degrees = ["B.E", "M.E", "M.B.A"];
    $scope.departments = ["CSE", "ECE", "MECH", "EEE"];
});

app.controller("studentFormCtrl", function ($scope, $http,$location) {

    $scope.studentData = {};
    $scope.degrees = ["B.E", "M.E", "M.B.A"];
    $scope.departments = ["CSE", "ECE", "MECH", "EEE"];
    $scope.studentData.degree= $scope.degrees[0];
    $scope.studentData.department= $scope.departments[0];
    $scope.processForm = function () {
        console.log('post opeartion');
        console.log($scope.studentData);
        $http({
            method: 'POST',
            url: 'http://localhost:8080/studentapp/student',
            data: $scope.studentData
        })
        console.log("redirecting to student list page");
        $location.path('/student');

    };
});

