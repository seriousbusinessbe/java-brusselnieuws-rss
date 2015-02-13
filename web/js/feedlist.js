(function(){
	var app = angular.module('brusselNieuwsRss',[]);

	app.controller('FeedmetalistliveController',['$http', function($http){
		var store = this;
		store.feedmetalistlive = [];

		$http.get('http://127.0.0.1:8080/feed/1').success(function(data){
			store.feedmetalistlive = data;
		});
	}]);

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

	//var feedmetalistlive = $http({ method: 'GET', url: 'http://127.0.0.1:8080/feed/1'});

	var feedmetalist = [
		{
			name: 'Product 1',
			price: 1.95,
			description: 'The best product ever',
			publicationDate: 1423664620000,
			buyable: true,
			soldout: true,
			media: [],
			reviews: []
		},
		{
			name: 'Product 2',
			price: 2.95,
			description: 'The second best product ever',
			publicationDate: 1423657199000,
			buyable: true,
			soldout: false,
			media: [],
			reviews: []
		},
		{
			name: 'Product 3',
			price: 3.95,
			description: 'The third best product ever',
			publicationDate: 1423641984000,
			buyable: false,
			soldout: false,
			media: [],
			reviews: []
		},
		{
			name: 'Product 4',
			price: 4,
			description: 'The fourth best product ever',
			publicationDate: 1423562275000,
			media:[
				{size:72478,link:"http://www.brusselnieuws.be/sites/default/files/styles/bn_460/public/article_media/images/urinoirs.jpg?itok=6FoviRjE",type:"image/jpeg"},
				{size:36239,link:"http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/urinoirs.jpg?itok=6FoviRjE",type:"image/jpeg"}
				],
			buyable: true,
			soldout: false,
			reviews:[{stars:1,author:"test@test.com",body:"Awesome product!"}]
		}
	];
	
})();
