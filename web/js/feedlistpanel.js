(function(){
	var app = angular.module('brusselNieuwsRss',[]);

	app.controller('FeedmetalistPanelController', function(){
		this.tab = 1;

		this.selectTab = function(setTab) {
			this.tab = setTab;
		}

		this.isSelected = function(checkTab) {
			return this.tab === checkTab;
		}
	});
	
})();
