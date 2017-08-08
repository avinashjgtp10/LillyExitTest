app.service("Security", function($http) {

	return $http({
		method : 'GET',
		url : 'Asset/Lang/Security.json'
	}).then(function successCallback(response) {
		return response.data;
	}, function errorCallback(response) {
		return response;
	});
});

app.factory("LangFactory",function($http){
	return $http({
		method : 'GET',
		url : 'Asset/Lang/Lang.json'
	}).then(function successCallback(response) {
		return response.data;
	}, function errorCallback(response) {
		return response;
	});
});