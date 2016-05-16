/**
 * 
 */


angular.module('mainApp')
    .factory('documentFactory', ['$http', function($http) {

    var urlBase = '/angularstruts/rest/';
    var documentFactory = {};

    documentFactory.search = function (query) {
        return $http.get(urlBase+ 'search/'+query);
    };
    
    documentFactory.indexDocument = function (book) {
        return $http.put(urlBase + 'index', JSON.stringify(book));
    };

//    documentFactory.getCustomer = function (id) {
//        return $http.get(urlBase + '/' + id);
//    };
//
//    dataFactory.insertCustomer = function (cust) {
//        return $http.post(urlBase, cust);
//    };
//

//
//    dataFactory.deleteCustomer = function (id) {
//        return $http.delete(urlBase + '/' + id);
//    };
//
//    dataFactory.getOrders = function (id) {
//        return $http.get(urlBase + '/' + id + '/orders');
//    };

    return documentFactory;
}]);


//angular.module('mainApp').factory( 'searchservice', [ '$resource', function( $resource ){
//
//	return new Searcher( $resource );
//
//}] );
//
//function Searcher( resource ) {
//
//	this.resource = resource; 
//	
////	this.createStudent = function ( student, scope ) {
////
////		// 
////	
////		// Save Action Method
////	
////		//
////	
////		var Student = resource('/angularstruts/rest/student/new');
////	
////		Student.save(student, function(response){
////	
////			scope.message = response.message;
////	
////		});
////
////	};
//
//	this.search = function ( query, scope ) {
//
//		//
//	
//		// GET Action Method
//	
//		//
//	
//		var Search = resource('/angularstruts/rest/search/:query', {query:'@query'});
//	
//		Search.get( {query:query}, function(result){
//	
//			scope.totalHits = result.totalHits;
//			scope.docs = result.docs;
//			scope.duration = result.duration;
//	
//		});
//
//	};
//	
//	this.indexDocument = function(number,scope) {
//		var Index = resource('/angularstruts/rest/indexDocument',{},{query:{method:'POST',params:{a:'number'}}});
//	
//		Index.get(number,function(result){
//			scope.isSend = result ;
//		});
//	};
//
////	this.getStudents = function( scope ) {
////
////		//
////	
////		// Query Action Method
////	
////		//
////	
////		var Students = resource('/angularstruts/rest/student/all');
////	
////		Students.query(function(students){
////	
////		scope.students = students;
////	
////		});
////
////	};
//
//}