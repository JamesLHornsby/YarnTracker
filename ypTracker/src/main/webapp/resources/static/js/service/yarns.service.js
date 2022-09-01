'use strict';
angular.module('YarnPatternMatcherApp').factory('YarnPatternMatcherService', ['$http', '$q', function($http, $q) {
	
	var REST_SERVICE_URI = 'yarns/';
	var REST_SERVICE_URL = 'patterns/';
	
	var factory = {
		fetchAllYarn: fetchAllYarn,
		createYarn: createYarn,
		updateYarn: updateYarn,
		deleteYarn: deleteYarn,
		
		fetchAllPatterns: fetchAllPatterns,
		createPattern: createPattern,
		updatePattern: updatePattern,
		deletePattern: deletePattern
	};
	
	return factory;
	
	function fetchAllYarn() {
		return $http.get(REST_SERVICE_URI).then(function(response) {
			return response.data
		});
	}
	
	function createYarn(yarn) {
		return $http.post(REST_SERVICE_URI, yarn).then(function(response) {
			
			return response.data;
		});
	}
	
	function updateYarn(yarn, id) {
		var deferred = $q.defer();
		$http.put(REST_SERVICE_URI+id, yarn)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse) {
				console.error('Error while updating yarn');
				deferred.reject(errResponse);
			}
		);
		return deferred.promise;
	}
	
	function deleteYarn(yarnId) {
		return $http.delete(REST_SERVICE_URI + yarnId).then(function(response) {
			
			return response.data;
		});
	}
	
	
/* Patterns below... */
	function fetchAllPatterns() {
		return $http.get(REST_SERVICE_URL).then(function(response) {
			return response.data
		});
	}
	
	function createPattern(yarn) {
		return $http.post(REST_SERVICE_URL, yarn).then(function(response) {
			
			return response.data;
		});
	}
	
	function updatePattern(pattern, id) {
		var deferred = $q.defer();
		$http.put(REST_SERVICE_URL+id, pattern)
		.then(
			function (response) {
				deferred.resolve(response.data);
			},
			function(errResponse) {
				console.error('Error while updating pattern');
				deferred.reject(errResponse);
			}
		);
		return deferred.promise;
	}
	
	function deletePattern(patternId) {
		return $http.delete(REST_SERVICE_URL + patternId).then(function(response) {
			
			return response.data;
		});
	}
	
}]);