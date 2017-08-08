app.controller("testCtrl", function($scope, Security, LangFactory) {
	$scope.values = {};
	$scope.SelQue = {};

	LangFactory.then(function(successResponse) {
		$scope.LoginTitleLog = successResponse.LTitle;
		$scope.LoginTitleReg = successResponse.RTitle;
		console.log(successResponse);
	});

	Security.then(function(successResponse) {
		$scope.secQue = successResponse;
	});

	$scope.GetValue = function() {
		$scope.SelQue = $scope.values.SecVal;
	}

	$scope.UserLogin = function() {
		alert("Hello");
	}

	$scope.UserRegister = function() {
		alert("HELLO");
	}

});
