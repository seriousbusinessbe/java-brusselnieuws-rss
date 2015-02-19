package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import be.seriousbusiness.brusselnieuws.rss.reader.BrusselNieuwsRss;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

/**
 * Feed utility helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedUtil {
	
	/**
	 * Gets a feed by {@link FeedMetaEnum}.
	 * @param feedMetaEnum the {@link FeedMetaEnum} to look for
	 * @param brusselNieuwsRss the {@link BrusselNieuwsRss} to retrieve the correct feed from.
	 * @return the corresponding feed
	 */
	public static final <MEDIUMTYPE extends MediumType,
			MEDIUM extends Medium<MEDIUMTYPE>,
			CATEGORY extends Category,
			AUTHOR extends Author,
			ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR>,
			FEED extends Feed<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE>> FEED getFeed(final FeedMetaEnum feedMetaEnum,
																					   final BrusselNieuwsRss<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> brusselNieuwsRss) {
		FEED feed=null;
		switch(feedMetaEnum) {
			case CITY_NEWS : feed=brusselNieuwsRss.getCityNews(); break;
			case NEWS_HEADLINES : feed=brusselNieuwsRss.getNewsHeadLines(); break;
			case NEWS_SURVEY : feed=brusselNieuwsRss.getNewsSurvey(); break;
			case AWEL_MERCI_NEWS : feed=brusselNieuwsRss.getAwelMerciNews(); break;
			case CHILDREN_NEWS : feed=brusselNieuwsRss.getChildrensNews(); break;
			case ECONOMICAL_NEWS : feed=brusselNieuwsRss.getEconomicalNews(); break;
			case PEOPLE_NEWS : feed=brusselNieuwsRss.getPeopleNews(); break;
			case POLITICAL_NEWS : feed=brusselNieuwsRss.getPoliticalNews(); break;
			case SOCIETY_NEWS : feed=brusselNieuwsRss.getSocietyNews(); break;
			case SPORTS_NEWS : feed=brusselNieuwsRss.getSportsNews(); break;
			case CULTURE_SURVEY : feed=brusselNieuwsRss.getCultureSurvey(); break;
			case EVENT_NEWS : feed=brusselNieuwsRss.getEventNews(); break;
			case EXPO_NEWS : feed=brusselNieuwsRss.getExpoNews(); break;
			case FILM_NEWS : feed=brusselNieuwsRss.getFilmNews(); break;
			case GENERAL_CULTURE_NEWS : feed=brusselNieuwsRss.getGeneralCultureNews(); break;
			case MUSICAL_NEWS : feed=brusselNieuwsRss.getMusicalNews(); break;
			case SHOPPING_NEWS : feed=brusselNieuwsRss.getShoppingNews(); break;
			case STAGE_NEWS : feed=brusselNieuwsRss.getStageNews(); break;
			case BAR_NEWS : feed=brusselNieuwsRss.getBarNews(); break;
			case CULINARY_NEWS : feed=brusselNieuwsRss.getCulinaryNews(); break;
			case FOOD_AND_DRINKS_SURVEY : feed=brusselNieuwsRss.getFoodAndDrinksSurvey(); break;
			case GENERAL_FOOD_AND_DRINKS : feed=brusselNieuwsRss.getGeneralFoodAndDrinksNews(); break;
			case RESTAURANT_NEWS : feed=brusselNieuwsRss.getRestaurantNews(); break;
			case OPINION_SURVEY : feed=brusselNieuwsRss.getOpinionSurvey(); break;
			case ANDERLECHT_NEWS : feed=brusselNieuwsRss.getAnderlechtNews(); break;
			case BRUSSEL_NEWS : feed=brusselNieuwsRss.getBrusselNews(); break;
			case ELSENE_NEWS : feed=brusselNieuwsRss.getElseneNews(); break;
			case ETTERBEEK_NEWS : feed=brusselNieuwsRss.getEtterbeekNews(); break;
			case EVERE_NEWS : feed=brusselNieuwsRss.getEvereNews(); break;
			case GANSHOREN_NEWS : feed=brusselNieuwsRss.getGanshorenNews(); break;
			case HAREN_NEWS : feed=brusselNieuwsRss.getHarenNews(); break;
			case JETTE_NEWS : feed=brusselNieuwsRss.getJetteNews(); break;
			case KOEKELBERG_NEWS : feed=brusselNieuwsRss.getKoekelbergNews(); break;
			case LAKEN_NEWS : feed=brusselNieuwsRss.getLakenNews(); break;
			case NEDER_OVER_HEEMBEEK_NEWS : feed=brusselNieuwsRss.getNederOverHeembeekNews(); break;
			case OUDERGEM_NEWS : feed=brusselNieuwsRss.getOudergemNews(); break;
			case SCHAARBEEK_NEWS : feed=brusselNieuwsRss.getSchaarbeekNews(); break;
			case SINT_AGATHA_BERCHEM_NEWS : feed=brusselNieuwsRss.getSintAgathaBerchemNews(); break;
			case SINT_GILLIS_NEWS : feed=brusselNieuwsRss.getSintGillisNews(); break;
			case SINT_JANS_MOLENBEEK_NEWS : feed=brusselNieuwsRss.getSintJansMolenbeekNews(); break;
			case SINT_JOOST_TEN_NODE_NEWS : feed=brusselNieuwsRss.getSintJoostTenNodeNews(); break;
			case SINT_LAMBRECHTS_WOLUWE_NEWS : feed=brusselNieuwsRss.getSintLambrechtsWoluweNews(); break;
			case SINT_PIETERS_WOLUWE_NEWS : feed=brusselNieuwsRss.getSintPietersWoluweNews(); break;
			case UKKEL_NEWS : feed=brusselNieuwsRss.getUkkelNews(); break;
			case VORST_NEWS : feed=brusselNieuwsRss.getVorstNews(); break;
			case WATERMAAL_BOSVOORDE : feed=brusselNieuwsRss.getWatermaalBosvoordeNews(); break;
		}
		return feed;
	}

}
