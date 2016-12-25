/**
 * Created by chinmay_dutta on 12/25/16.
 */
var myAppModule = angular.module('demoApp', ['ngMaterial']);

myAppModule.controller('DemoController', DemoController);
DemoController.$inject = ['$http'];

function DemoController($http) {
    console.log('testing');
    var demoController = this;
    demoController.user = {};
    // getEmployee


    // getEmployees


    // addEmployee
    demoController.addEmployee = function(data) {
        var req = {
            method: 'POST',
            url: 'http://localhost:8080/demoApp/',
            data: data | {}
        };

        $http(req).then(function(response){
            console.log('post success');

        }, function(){
            console.log('post failed');

        });

    };

    // UpdateEmployee


    // Delete Employee

}