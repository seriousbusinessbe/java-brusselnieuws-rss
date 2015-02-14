(function(){
	var app = angular.module('brusselNieuwsRss',[]);

	/* Set defaults at runtime: */
	/*
	app.run(function($http) {
		$http.defaults.useXDomain = true;
		$http.defaults.withCredentials = true;
		delete $http.defaults.headers.common["X-Requested-With"];
		$http.defaults.headers.common["Accept"] = "application/json";
		$http.defaults.headers.common["Content-Type"] = "application/json";
		$http.defaults.headers.get = { 'Access-Control-Allow-Origin' : '*' };
	});
	*/

	app.config(function($httpProvider){
		//$httpProvider.defaults.useXDomain = true;
		//$httpProvider.defaults.withCredentials = true;
	    //delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    //$httpProvider.defaults.headers.common["Accept"] = "application/json";
		//$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
		//$httpProvider.defaults.headers.get = { 'Access-Control-Allow-Origin' : '*' };
	});

	app.controller('FeedsCategoriesController',['$http', function($http){
		var store = this;
		store.feedsCategoriesResponse = [];

		$http.get('http://127.0.0.1:8080/feedsCategories').success(function(data){
			store.feedsCategoriesResponse = data;
		});

		this.feedCategoryResponseName = 'CULTURE';

		this.selectCategoryByName = function(feedCategoryResponseName) {
			this.feedCategoryResponseName = feedCategoryResponseName;
		};

		this.isSelected = function(feedCategoryResponseName) {
			return this.feedCategoryResponseName === feedCategoryResponseName;
		};

		this.getCategoryName = function() {
			return this.feedCategoryResponseName;
		};
	}]);

	app.controller('FeedsMetaController',['$http','$scope', function($http,$scope){
		var store = this;
		store.feedsMetaResponse = [];

		$http.get('http://127.0.0.1:8080/feedsMeta').success(function(data){
			store.feedsMetaResponse = data;
		});

		this.feedMetaResponseRequestId = 0;
		$scope.feedRequestId = 1;

		this.selectFeedByRequestId = function(feedMetaResponseRequestId) {
			this.feedMetaResponseRequestId = feedMetaResponseRequestId;
			$scope.feedRequestId = feedMetaResponseRequestId;
		};

		this.isSelected = function(feedMetaResponseRequestId) {
			return this.feedMetaResponseRequestId === feedMetaResponseRequestId;
		};

		this.getFeedRequestId = function() {
			return feedMetaResponseRequestId;
		}

	}]);

	app.controller('FeedController',['$http','$scope', function($http,$scope){
		var store = this;
		store.feedResponse = [];

		$scope.$watch('feedRequestId', function(newValue, oldValue) {
			store.feedResponse = [];

			$http.get('http://127.0.0.1:8080/feed/' + newValue).success(function(data){
				store.feedResponse = data;
			});
		});

	}]);

	/*
	app.controller('FeedmetalistController', function(){
		this.feedmetalist = feedmetalist;
	});

	app.controller('FeedmetalistPanelController', function(){
		this.tab = 1;

		this.selectTab = function(setTab) {
			this.tab = setTab;
		};

		this.isSelected = function(checkTab) {
			return this.tab === checkTab;
		};
	});

	app.controller('ReviewController', function(){
		this.review = {};
		
		this.addReview = function(feedmeta){
			feedmeta.reviews.push(this.review);
			this.review = {};
		};
		
	});

	app.directive('FeedmetaTitle', function(){
		return {
			restrict: 'E',
			templateUrl: "feedmetatitle.html"
		};
	});
	*/
	
})();