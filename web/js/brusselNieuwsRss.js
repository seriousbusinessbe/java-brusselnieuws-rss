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

	app.controller('FeedsMetaController',['$http', function($http){
		var store = this;
		store.feedsMetaResponse = [];

		$http.get('http://127.0.0.1:8080/feedsMeta').success(function(data){
			store.feedsMetaResponse = data;
		});
	}]);

	var globalCategory='CULTURE';

	app.controller('FeedCategoriesController',['$http', function($http){
		var store = this;
		store.feedCategoriesResponse = [];

		$http.get('http://127.0.0.1:8080/feedCategories').success(function(data){
			store.feedCategoriesResponse = data;
		});

		this.category = 'CULTURE';

		this.selectCategory = function(category) {
			this.category = category;
			globalCategory=category;
		};

		this.isSelected = function(category) {
			return this.category === category;
		};
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