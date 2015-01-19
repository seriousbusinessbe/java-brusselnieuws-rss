package be.seriousbusiness.brusselnieuws.rss.reader;

import java.net.URL;

import org.springframework.beans.factory.annotation.Required;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.reader.model.factory.FeedFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.manager.FeedManager;

public class BrusselNieuwsRss<MEDIUMTYPE extends MediumType,
						   MEDIUM extends Medium<MEDIUMTYPE>,
						   CATEGORY extends Category,
						   AUTHOR extends Author,
						   ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR>,
						   FEED extends Feed<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE>> {
	private FeedManager<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> feedManager;
	private BrusselNieuwsRssReader<FEED> brusselNieuwsRssReader;
	private FeedFactory<FEED> feedFactory;
	private URL newsHeadlinesURL,newsSurveyURL,societyNewsURL,politicalNewsURL,economicalNewsURL,sportsNewsURL,awelMerciNewsURL,childrensNewsURL,cityNewsURL,peopleNewsURL;
	private URL cultureSurveyURL,generalCultureNewsURL,expoNewsURL,musicalNewsURL,filmNewsURL,stageNewsURL,eventNewsURL,shoppingNewsURL;
	private URL foodAndDrinksSurveyURL,generalFoodAndDrinksNewsURL,culinaryNewsURL,barNewsURL,restaurantNewsURL;
	private URL opinionSurveyURL;
	private URL anderlechtNewsURL,brusselNewsURL,elseneNewsURL,etterbeekNewsURL,evereNewsURL,ganshorenNewsURL,harenNewsURL,jetteNewsURL,
				koekelbergNewsURL,lakenNewsURL,nederOverHeembeekNewsURL,oudergemNewsURL,schaarbeekNewsURL,sintAgathaBerchemNewsURL,
				sintGillisNewsURL,sintJansMolenbeekNewsURL,sintJoostTenNodeNewsURL,sintLambrechtsWoluweNewsURL,sintPietersWoluweNewsURL,
				ukkelNewsURL,vorstNewsURL,watermaalBosvoordeNewsURL;
	
	private final FEED getFeed(final URL url) {
		FEED feed=feedManager.findByLink(url);
		feed=feed==null ? feedFactory.create(url) : feed;
		update(feed);
		return feed;
	}
	
	public void update(final FEED feed) {
		if(feed!=null && feed.getLink()!=null) {
			brusselNieuwsRssReader.updateFeed(feed);
			feedManager.save(feed);
		}
	}
	
	/* FEED GETTERS */
	
	/* NEWS */
	
	public FEED getNewsHeadLines() {
		return getFeed(newsHeadlinesURL);
	}
	
	public FEED getNewsSurvey() {
		return getFeed(newsSurveyURL);
	}

	public FEED getSocietyNews() {
		return getFeed(societyNewsURL);
	}
	
	public FEED getPoliticalNews() {
		return getFeed(politicalNewsURL);
	}
	
	public FEED getEconomicalNews() {
		return getFeed(economicalNewsURL);
	}
	
	public FEED getSportsNews() {
		return getFeed(sportsNewsURL);
	}
	
	public FEED getAwelMerciNews() {
		return getFeed(awelMerciNewsURL);
	}
	
	public FEED getChildrensNews() {
		return getFeed(childrensNewsURL);
	}
	
	public FEED getCityNews() {
		return getFeed(cityNewsURL);
	}
	
	public FEED getPeopleNews() {
		return getFeed(peopleNewsURL);
	}
	
	/* CULTURE */
	
	public FEED getCultureSurvey() {
		return getFeed(cultureSurveyURL);
	}
	
	public FEED getGeneralCultureNews() {
		return getFeed(generalCultureNewsURL);
	}
	
	public FEED getExpoNews() {
		return getFeed(expoNewsURL);
	}
	
	public FEED getMusicalNews() {
		return getFeed(musicalNewsURL);
	}
	
	public FEED getFilmNews() {
		return getFeed(filmNewsURL);
	}
	
	public FEED getStageNews() {
		return getFeed(stageNewsURL);
	}
	
	public FEED getEventNews() {
		return getFeed(eventNewsURL);
	}
	
	public FEED getShoppingNews() {
		return getFeed(shoppingNewsURL);
	}
	
	/* FOOD & DRINKS */
	
	public FEED getFoodAndDrinksSurvey() {
		return getFeed(foodAndDrinksSurveyURL);
	}

	public FEED getGeneralFoodAndDrinksNews() {
		return getFeed(generalFoodAndDrinksNewsURL);
	}

	public FEED getCulinaryNews() {
		return getFeed(culinaryNewsURL);
	}

	public FEED getBarNews() {
		return getFeed(barNewsURL);
	}

	public FEED getRestaurantNews() {
		return getFeed(restaurantNewsURL);
	}
	
	/* OPINION */
	
	public FEED getOpinionSurvey() {
		return getFeed(opinionSurveyURL);
	}
	
	/* MUNICIPALITIES */
	
	public FEED getAnderlechtNews() {
		return getFeed(anderlechtNewsURL);
	}

	public FEED getBrusselNews() {
		return getFeed(brusselNewsURL);
	}

	public FEED getElseneNews() {
		return getFeed(elseneNewsURL);
	}

	public FEED getEtterbeekNews() {
		return getFeed(etterbeekNewsURL);
	}

	public FEED getEvereNews() {
		return getFeed(evereNewsURL);
	}

	public FEED getGanshorenNews() {
		return getFeed(ganshorenNewsURL);
	}

	public FEED getHarenNews() {
		return getFeed(harenNewsURL);
	}

	public FEED getJetteNews() {
		return getFeed(jetteNewsURL);
	}

	public FEED getKoekelbergNews() {
		return getFeed(koekelbergNewsURL);
	}

	public FEED getLakenNews() {
		return getFeed(lakenNewsURL);
	}

	public FEED getNederOverHeembeekNews() {
		return getFeed(nederOverHeembeekNewsURL);
	}

	public FEED getOudergemNews() {
		return getFeed(oudergemNewsURL);
	}

	public FEED getSchaarbeekNews() {
		return getFeed(schaarbeekNewsURL);
	}

	public FEED getSintAgathaBerchemNews() {
		return getFeed(sintAgathaBerchemNewsURL);
	}

	public FEED getSintGillisNews() {
		return getFeed(sintGillisNewsURL);
	}

	public FEED getSintJansMolenbeekNews() {
		return getFeed(sintJansMolenbeekNewsURL);
	}

	public FEED getSintJoostTenNodeNews() {
		return getFeed(sintJoostTenNodeNewsURL);
	}

	public FEED getSintLambrechtsWoluweNews() {
		return getFeed(sintLambrechtsWoluweNewsURL);
	}

	public FEED getSintPietersWoluweNews() {
		return getFeed(sintPietersWoluweNewsURL);
	}

	public FEED getUkkelNews() {
		return getFeed(ukkelNewsURL);
	}

	public FEED getVorstNews() {
		return getFeed(vorstNewsURL);
	}

	public FEED getWatermaalBosvoordeNews() {
		return getFeed(watermaalBosvoordeNewsURL);
	}
	
	/* SETTERS */

	@Required
	public void setFeedManager(final FeedManager<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> feedManager) {
		this.feedManager = feedManager;
	}
	
	@Required
	public void setBrusselNieuwsRssReader(final BrusselNieuwsRssReader<FEED> brusselNieuwsRssReader) {
		this.brusselNieuwsRssReader = brusselNieuwsRssReader;
	}

	@Required
	public void setFeedFactory(final FeedFactory<FEED> feedFactory) {
		this.feedFactory = feedFactory;
	}
	
	/* NEWS */
	
	@Required
	public void setNewsHeadlinesURL(final URL newsHeadlines) {
		this.newsHeadlinesURL=newsHeadlines;
	}
	
	@Required
	public void setNewsSurveyURL(final URL newsSurvey) {
		this.newsSurveyURL=newsSurvey;
	}

	@Required
	public void setSocietyNewsURL(final URL societyNewsURL) {
		this.societyNewsURL = societyNewsURL;
	}

	@Required
	public void setPoliticalNewsURL(final URL politicalNewsURL) {
		this.politicalNewsURL = politicalNewsURL;
	}

	@Required
	public void setEconomicalNewsURL(final URL economicalNewsURL) {
		this.economicalNewsURL = economicalNewsURL;
	}

	@Required
	public void setSportsNewsURL(final URL sportsNewsURL) {
		this.sportsNewsURL = sportsNewsURL;
	}

	@Required
	public void setAwelMerciNewsURL(final URL awelMerciNewsURL) {
		this.awelMerciNewsURL = awelMerciNewsURL;
	}

	@Required
	public void setChildrensNewsURL(final URL childrensNewsURL) {
		this.childrensNewsURL = childrensNewsURL;
	}
	
	@Required
	public void setCityNewsURL(final URL cityNewsURL) {
		this.cityNewsURL = cityNewsURL;
	}
	
	@Required
	public void setPeopleNewsURL(final URL peopleNewsURL) {
		this.peopleNewsURL = peopleNewsURL;
	}
	
	/* CULTURE */

	@Required
	public void setCultureSurveyURL(final URL cultureSurveyURL) {
		this.cultureSurveyURL = cultureSurveyURL;
	}

	@Required
	public void setGeneralCultureNewsURL(final URL generalCultureNewsURL) {
		this.generalCultureNewsURL = generalCultureNewsURL;
	}

	@Required
	public void setExpoNewsURL(final URL expoNewsURL) {
		this.expoNewsURL = expoNewsURL;
	}

	@Required
	public void setMusicalNewsURL(final URL musicalNewsURL) {
		this.musicalNewsURL = musicalNewsURL;
	}

	@Required
	public void setFilmNewsURL(final URL filmNewsURL) {
		this.filmNewsURL = filmNewsURL;
	}

	@Required
	public void setStageNewsURL(final URL stageNewsURL) {
		this.stageNewsURL = stageNewsURL;
	}

	@Required
	public void setEventNewsURL(final URL eventNewsURL) {
		this.eventNewsURL = eventNewsURL;
	}

	@Required
	public void setShoppingNewsURL(final URL shoppingNewsURL) {
		this.shoppingNewsURL = shoppingNewsURL;
	}
	
	/* FOOD & DRINKS */
	
	@Required
	public void setFoodAndDrinksSurveyURL(final URL foodAndDrinksSurveyURL) {
		this.foodAndDrinksSurveyURL = foodAndDrinksSurveyURL;
	}

	@Required
	public void setGeneralFoodAndDrinksNewsURL(final URL generalFoodAndDrinksNewsURL) {
		this.generalFoodAndDrinksNewsURL = generalFoodAndDrinksNewsURL;
	}

	@Required
	public void setCulinaryNewsURL(final URL culinaryNewsURL) {
		this.culinaryNewsURL = culinaryNewsURL;
	}

	@Required
	public void setBarNewsURL(final URL barNewsURL) {
		this.barNewsURL = barNewsURL;
	}

	@Required
	public void setRestaurantNewsURL(final URL restaurantNewsURL) {
		this.restaurantNewsURL = restaurantNewsURL;
	}	
	
	/* OPINION */
	
	@Required
	public void setOpinionSurveyURL(final URL opinionSurveyURL) {
		this.opinionSurveyURL = opinionSurveyURL;
	}
	
	/* MUNICIPALITIES */
	
	@Required
	public void setAnderlechtNewsURL(final URL anderlechtNewsURL) {
		this.anderlechtNewsURL = anderlechtNewsURL;
	}

	@Required
	public void setBrusselNewsURL(final URL brusselNewsURL) {
		this.brusselNewsURL = brusselNewsURL;
	}

	@Required
	public void setElseneNewsURL(final URL elseneNewsURL) {
		this.elseneNewsURL = elseneNewsURL;
	}

	@Required
	public void setEtterbeekNewsURL(final URL etterbeekNewsURL) {
		this.etterbeekNewsURL = etterbeekNewsURL;
	}

	@Required
	public void setEvereNewsURL(final URL evereNewsURL) {
		this.evereNewsURL = evereNewsURL;
	}

	@Required
	public void setGanshorenNewsURL(final URL ganshorenNewsURL) {
		this.ganshorenNewsURL = ganshorenNewsURL;
	}

	@Required
	public void setHarenNewsURL(final URL harenNewsURL) {
		this.harenNewsURL = harenNewsURL;
	}

	@Required
	public void setJetteNewsURL(final URL jetteNewsURL) {
		this.jetteNewsURL = jetteNewsURL;
	}

	@Required
	public void setKoekelbergNewsURL(final URL koekelbergNewsURL) {
		this.koekelbergNewsURL = koekelbergNewsURL;
	}

	@Required
	public void setLakenNewsURL(final URL lakenNewsURL) {
		this.lakenNewsURL = lakenNewsURL;
	}

	@Required
	public void setNederOverHeembeekNewsURL(final URL nederOverHeembeekNewsURL) {
		this.nederOverHeembeekNewsURL = nederOverHeembeekNewsURL;
	}

	@Required
	public void setOudergemNewsURL(final URL oudergemNewsURL) {
		this.oudergemNewsURL = oudergemNewsURL;
	}

	@Required
	public void setSchaarbeekNewsURL(final URL schaarbeekNewsURL) {
		this.schaarbeekNewsURL = schaarbeekNewsURL;
	}

	@Required
	public void setSintAgathaBerchemNewsURL(final URL sintAgathaBerchemNewsURL) {
		this.sintAgathaBerchemNewsURL = sintAgathaBerchemNewsURL;
	}

	@Required
	public void setSintGillisNewsURL(final URL sintGillisNewsURL) {
		this.sintGillisNewsURL = sintGillisNewsURL;
	}

	@Required
	public void setSintJansMolenbeekNewsURL(final URL sintJansMolenbeekNewsURL) {
		this.sintJansMolenbeekNewsURL = sintJansMolenbeekNewsURL;
	}

	@Required
	public void setSintJoostTenNodeNewsURL(final URL sintJoostTenNodeNewsURL) {
		this.sintJoostTenNodeNewsURL = sintJoostTenNodeNewsURL;
	}

	@Required
	public void setSintLambrechtsWoluweNewsURL(final URL sintLambrechtsWoluweNewsURL) {
		this.sintLambrechtsWoluweNewsURL = sintLambrechtsWoluweNewsURL;
	}

	@Required
	public void setSintPietersWoluweNewsURL(final URL sintPietersWoluweNewsURL) {
		this.sintPietersWoluweNewsURL = sintPietersWoluweNewsURL;
	}

	@Required
	public void setUkkelNewsURL(final URL ukkelNewsURL) {
		this.ukkelNewsURL = ukkelNewsURL;
	}

	@Required
	public void setVorstNewsURL(final URL vorstNewsURL) {
		this.vorstNewsURL = vorstNewsURL;
	}

	@Required
	public void setWatermaalBosvoordeNewsURL(final URL watermaalBosvoordeNewsURL) {
		this.watermaalBosvoordeNewsURL = watermaalBosvoordeNewsURL;
	}
	
}
