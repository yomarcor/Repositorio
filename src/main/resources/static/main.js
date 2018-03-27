var app = angular.module("EmpleadoManagement", []);
 
// Controller Part
app.controller("EmpleadoController", function($scope, $http) { 
    $scope.empleados = [];
    $scope.empleadoForm = {
	        empId: 1,
	        empNo: "",
	        empName: "",
	        empPosition: ""
	    };
 
    // Now load the data from server
    _refreshEmpleadoData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/Empleado
    $scope.submitEmpleado = function() {	 
	        var method = "";
	        var url = "";
	 
	        if ($scope.empleadoForm.empId == -1) {
	            method = "POST";
	            url = '/Empleado';
	        } else {
	            method = "PUT";
	            url = '/Empleado';
	        }
	 
	        $http({
	            method: method,
	            url: url,
	            data: angular.toJson($scope.empleadoForm),
	            headers: {'Content-Type': 'application/json'}
	        }).then(_success, _error);
	    };
 
    $scope.limpiaCampos = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete empleado by Id
    // Call: http://localhost:8080/Empleado/{empId}
    $scope.deleteEmpleado = function(empleado) {
        $http({
            method: 'DELETE',
            url: '/Empleado/' + empleado.empId
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editEmpleado = function(empleado) {
        $scope.empleadoForm.empId = empleado.empId;
        $scope.empleadoForm.empNo = empleado.empNo;
        $scope.empleadoForm.empName = empleado.empName;
        $scope.empleadoForm.empPosition = empleado.empPosition;
    };
 
    // Private Method  
    // HTTP GET- get all empleados collection
    // Call: http://localhost:8080/Empleados
    function _refreshEmpleadoData() {
	        $http({
	            method: 'GET',
	            url: '/Empleados'
	        }).then(
	            function(res) { // success
	                $scope.empleados = res.data;
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	    }
	 
	    function _success(res) {
	        _refreshEmpleadoData();
	        _clearFormData();
	    }
	 
	    function _error(res) {
	        var data = res.data;
	        var status = res.status;
	        var header = res.header;
	        var config = res.config;
	        alert(" ++++ Error: " + status + ":" + data);
	    }
	 
	    // Clear the form
	    function _clearFormData() {
	        $scope.empleadoForm.empId = -1;
	        $scope.empleadoForm.empNo = "";
	        $scope.empleadoForm.empName = "";
	        $scope.empleadoForm.empPosition = ""
	    };
});