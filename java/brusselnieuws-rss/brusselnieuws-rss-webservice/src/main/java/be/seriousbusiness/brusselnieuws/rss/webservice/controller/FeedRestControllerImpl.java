package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.seriousbusiness.brusselnieuws.rss.reader.BrusselNieuwsRss;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.comparator.FeedCategoryResponseTranslatedNameComparator;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.comparator.FeedMetaResponseCategoryTranslatedNameComparator;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.controller.FeedRestController;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedCategoryResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedsCategoriesResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedsMetaResponse;

/**
 * Spring-boot {@link FeedRestController} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-boot reference: <a href="http://docs.spring.io/spring-boot/docs/current/reference/">http://docs.spring.io/spring-boot/docs/current/reference/</a>
 * @see Spring-boot example: Building a RESTful Web Service - <a href="http://spring.io/guides/gs/rest-service/">http://spring.io/guides/gs/rest-service/</a>
 * @see Spring-boot example: Building an Application with Spring Boot - <a href="http://spring.io/guides/gs/spring-boot/">http://spring.io/guides/gs/spring-boot/</a>
 */
@RestController()
public class FeedRestControllerImpl<MEDIUMTYPE extends MediumType,
									MEDIUM extends Medium<MEDIUMTYPE>,
									CATEGORY extends Category,
									AUTHOR extends Author,
									ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR>,
									FEED extends Feed<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE>> implements FeedRestController {
	private static final Comparator<FeedMetaResponse> FEEDMETARESPONSE_COMPARATOR=new FeedMetaResponseCategoryTranslatedNameComparator();
	private static final Comparator<FeedCategoryResponse> FEEDCATEGORYRESPONSE_COMPARATOR=new FeedCategoryResponseTranslatedNameComparator();
	private final Map<FeedMetaEnum,FEED> FEEDS_MAP=new HashMap<FeedMetaEnum,FEED>();
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssWebserviceDozerBeanMapper")
	private Mapper mapper;
	private BrusselNieuwsRss<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> brusselNieuwsRss;
	public static final String FEED="feed",FEEDS_META="feedsMeta",FEED_CATEGORIES="feedsCategories";
	
	/**
	 * Retrieves a feed by {@link FeedMetaEnum}.
	 * @param feedMetaEnum  a non <code>null</code> {@link FeedMetaEnum}
	 * @return the found feed
	 */
	private final FEED getFeed(final FeedMetaEnum feedMetaEnum) {
		FEED feed=null;
		if(FEEDS_MAP.containsKey(feedMetaEnum)) {
			feed=brusselNieuwsRss.update(FEEDS_MAP.get(feedMetaEnum));
		} else {
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
		}
		FEEDS_MAP.put(feedMetaEnum,feed);
		return feed;
	}
	
	@Override
	@RequestMapping(value="/"+FEED_CATEGORIES, method=RequestMethod.GET)
	public FeedsCategoriesResponse getFeedCategories() {
		final List<FeedCategoryResponse> feedCategoryResponses=new ArrayList<FeedCategoryResponse>();
		for(final FeedCategoryMetaEnum feedCategoryMetaEnum : FeedCategoryMetaEnum.values()) {
			feedCategoryResponses.add(new FeedCategoryResponse(feedCategoryMetaEnum.name(),feedCategoryMetaEnum.getTranslatedName()));
		}
		Collections.sort(feedCategoryResponses,FEEDCATEGORYRESPONSE_COMPARATOR);
		return new FeedsCategoriesResponse(feedCategoryResponses);
	}
	
	@Override
	@RequestMapping(value="/"+FEEDS_META, method=RequestMethod.GET)
	public FeedsMetaResponse getFeedsMeta() {
		final List<FeedMetaResponse> feedMetaResponses=new ArrayList<FeedMetaResponse>();
		for(final FeedMetaEnum feedMetaEnum : FeedMetaEnum.values()) {
			feedMetaResponses.add(new FeedMetaResponse(feedMetaEnum.getDutchName(),feedMetaEnum.getRequestId(),feedMetaEnum.getCategory().name()));
		}		
		Collections.sort(feedMetaResponses,FEEDMETARESPONSE_COMPARATOR);
		final FeedsMetaResponse feedMetaListResponse=new FeedsMetaResponse(feedMetaResponses);		
		return feedMetaListResponse;
	}
	
	@Override
	@RequestMapping(value="/"+FEED+"/{id}", method=RequestMethod.GET)
	public FeedResponse getFeed(final @PathVariable(value="id") int id) {
		final FeedMetaEnum feedMetaEnum=FeedMetaEnum.find(id);
		return feedMetaEnum==null ? new FeedResponse() : mapper.map(getFeed(feedMetaEnum),FeedResponse.class);
	}
	
	/* SETTERS */
	
	@Required
	public void setBrusselNieuwsRss(final BrusselNieuwsRss<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> brusselNieuwsRss) {
		this.brusselNieuwsRss = brusselNieuwsRss;
	}

}
