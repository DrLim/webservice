/**
 * 
 */

angular.module('mainApp').controller("searchController", [ '$scope','documentFactory', function($scope, documentFactory) {
		$scope.query = '';
		$scope.book = {
				id:null,
				name:null,
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
			documentFactory.indexDocument(this.book)
			.then(function(response){
				$scope.status = 'OK : '+response.data;
			},function(error){
				$scope.status = 'Error retrieving customers! ' + error;
			});
		}

	} ]);