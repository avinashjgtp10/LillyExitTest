app
		.controller(
				"testCtrl",
				function($scope, Security, LangFactory, $http, $window,
						$cookies) {
					$scope.values = {};
					$scope.SelQue = {};

					LangFactory.then(function(successResponse) {
						$scope.LoginTitleLog = successResponse.LTitle;
						$scope.LoginTitleReg = successResponse.RTitle;

					});

					Security.then(function(successResponse) {
						$scope.secQue = successResponse;
					});

					$scope.GetValue = function() {
						$scope.SelQue = $scope.values.SecVal.toString();
					}

					$scope.UserLillyId = "";
					$scope.userNameFromDb = "";
					$scope.userLillyIdFromDb = "";

					$scope.UserLogin = function() {
						$http({
							method : 'Post',
							url : 'log',
							data : {
								'LillyId' : $scope.user.username,
								'Password' : $scope.user.password,
							}
						})
								.then(
										function successCallback(response) {
											$scope.msg = response.data.items.Message;

											if ($scope.msg === "Invalid") {
												alert("System Id and passowrd is invalid")
											} else {
												$window.location.href = 'MainPage.jsp';

												$cookies
														.put(
																'UserName',
																response.data.items.UserName);
												$cookies
														.put(
																'LillyId',
																response.data.items.LillyId);
											}
										}, function errorCallback(response) {
											console.log(response);
										});

					}

					$scope.userNameFromDb = $cookies.get('UserName');
					$scope.userLillyIdFromDb = $cookies.get('LillyId');

					// Get Question
					$scope.queArr=[];
					
					return $http({
						method : 'GET',
						url : 'Asset/Lang/Question.json'
					}).then(function successCallback(response) {
						
						$scope.queArr.push(response.data.Question);
					}, function errorCallback(response) {
						console.log(response.data);
					});
					
					console.log($scope.queArr);
					
					

					$scope.UserRegister = function() {
						if (typeof ($scope.SelQue.length) === "undefined") {
							alert("Please select security question")
						} else {

							$http({
								method : "POST",
								url : 'UserRegister',
								data : {
									'LillyId' : $scope.user.sysid,
									'Name' : $scope.user.Rname,
									'Password' : $scope.user.password,
									'Question' : $scope.SelQue,
									'Answer' : $scope.user.ans,

								}
							})
									.then(
											function success(response) {
												console.log(response.data);
												if (response.data == "Successs") {
													$scope.alertMsg = "Your account has been successfully registered.";
													alert("Your account has been successfully registered. \n Please click on sign in.");

												} else if (response.data == "Already") {
													alert("Your account is already exist. \n Please click on sign in. ");
												} else {
													alert("Something is wrong please contact admin.")
												}
											});

						}
					};

				});
