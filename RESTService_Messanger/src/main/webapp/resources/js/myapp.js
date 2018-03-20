var myapp = angular.module('myApp',[]);



	myapp.controller('homeController', function($scope,$http) {
		$scope.message = "";
		$scope.author = "";
		$scope.created = "";
		$scope.allMessages = [];
		
		$scope.formSubmit = function(){
			
			var message = {message:$scope.message,created:$scope.created,author:$scope.author};
			
			//console.log(message.author);
			
			$http.post("webapi/messages",message)
				.then(function(response){
					console.log(response.data);
				},function(error){
					console.log(error);
				});
			
		};
		
		$scope.getAllMessages = function(){
			$http.get("webapi/messages")
			.then(function(data){
				console.log(data.data);
				$scope.allMessages = data.data;
			},function(error){
				console.log("error");
			})
		}
		
	});
	
	