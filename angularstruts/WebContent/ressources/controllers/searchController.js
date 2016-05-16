/**
 * 
 */

angular.module('mainApp').controller("searchController", [ '$scope','documentFactory', function($scope, documentFactory) {
		$scope.query = '';
		$scope.document = {
				id:null,
				title:null,
				path:null
		};
		$scope.onSearch = function() {
			documentFactory.search(this.query)
			.then(function (response) {
				$scope.totalHits = response.data.totalHits;
				$scope.docs = response.data.docs;
				$scope.duration = response.data.duration;
			},function(error){
				$scope.status = 'Error retrieving customers! ' + error.message;
			});
		}
		
		$scope.onSend = function() {
			documentFactory.indexDocument(this.document)
			.then(function(response){
				$scope.status = 'OK : '+angular.toJson(response.data, false);
			},function(error){
				$scope.status = 'Error retrieving customers! ' + error;
			});
		}

	} ]);