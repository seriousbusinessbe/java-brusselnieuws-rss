package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.seriousbusiness.brusselnieuws.rss.reader.BrusselNieuwsRss;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;
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
 * @see Spring-boot reference: <a href="http://docs.spring.io/spring-boot/docs/current/reference/">http://docs.spring.io/spring-boot/docs/current/reference/</a></br>
 * @see Spring-boot example: Building a RESTful Web Service - <a href="http://spring.io/guides/gs/rest-service/">http://spring.io/guides/gs/rest-service/</a></br>
 * @see Spring-boot example: Building an Application with Spring Boot - <a href="http://spring.io/guides/gs/spring-boot/">http://spring.io/guides/gs/spring-boot/</a></br>
 * @see Spring-framework reference: Scheduling - <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html">http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html</a></br>
 * @see Spring-boot example: Scheduling Tasks - <a href="http://spring.io/guides/gs/scheduling-tasks/">http://spring.io/guides/gs/scheduling-tasks/</a></br>
 */
@RestController()
public class FeedRestControllerImpl<MEDIUMTYPE extends MediumType,
									MEDIUM extends Medium<MEDIUMTYPE>,
									CATEGORY extends Category,
									AUTHOR extends Author,
									CREATOR extends Creator,
									ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,CREATOR>,
									FEED extends Feed<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,CREATOR,ARTICLE>> implements FeedRestController {
	private static final Logger LOGGER=LoggerFactory.getLogger(FeedRestControllerImpl.class);
	private static final Comparator<FeedMetaResponse> FEEDMETARESPONSE_COMPARATOR=new FeedMetaResponseCategoryTranslatedNameComparator();
	private static final Comparator<FeedCategoryResponse> FEEDCATEGORYRESPONSE_COMPARATOR=new FeedCategoryResponseTranslatedNameComparator();
	private final Map<FeedMetaEnum,FEED> FEEDS_MAP=new HashMap<FeedMetaEnum,FEED>();
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssWebserviceDozerBeanMapper")
	private Mapper mapper;
	private BrusselNieuwsRss<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,CREATOR,ARTICLE,FEED> brusselNieuwsRss;
	public static final String FEED="feed",FEEDS_META="feedsMeta",FEED_CATEGORIES="feedsCategories";
	
	/**
	 * Updates feeds on a daily schedule every 5 minutes from 8 to 24 midnight.</br>
	 * CRON format: seconds minutes hours dayOfMonth month dayOfWeek year (year = optional)</br>
	 * @see Spring-framework reference: Scheduling - <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html">http://docs.spring.io/spring/docs/current/spring-framework-reference/html/scheduling.html</a></br>
	 * @see Spring-boot example: Scheduling Tasks - <a href="http://spring.io/guides/gs/scheduling-tasks/">http://spring.io/guides/gs/scheduling-tasks/</a>
	 * @see CRON format: <a href="http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger">http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger</a>
	 */
	@Async
    @Scheduled(cron = "0 0/5 7-23 * * *")
	private void scheduledFeedUpdate() {
		if(FEEDS_MAP!=null && brusselNieuwsRss!=null) {
			LOGGER.info("STARTED scheduled update of feeds");
			final long startFeeds=System.currentTimeMillis();
			for(final FeedMetaEnum feedMetaEnum : FeedMetaEnum.values()) {
			   try {
				   LOGGER.debug("STARTED scheduled update of feed '{}'",feedMetaEnum.getTranslatedName());
				   final long startFeed=System.currentTimeMillis();
				   final FEED feed=FEEDS_MAP.containsKey(feedMetaEnum) ?
						brusselNieuwsRss.update(FEEDS_MAP.get(feedMetaEnum)) : 
						FeedUtil.getFeed(feedMetaEnum, brusselNieuwsRss);
						FEEDS_MAP.put(feedMetaEnum,feed);
				   final long stopFeed=System.currentTimeMillis();
				   LOGGER.debug("FINISHED scheduled update of feed '{}' in {} {}",feedMetaEnum.getTranslatedName(),SimpleDateFormatUtil.format(stopFeed-startFeed),SimpleDateFormatUtil.isLessThanMinute(stopFeed-startFeed) ? "seconds" : "minute(s)");
			   }catch(final Throwable t) {
				   LOGGER.error("An unexpected error occurred while updating feed '{}'",feedMetaEnum.getTranslatedName(),t);
			   }
		    }
			final long stopFeeds=System.currentTimeMillis();
			LOGGER.info("FINISHED scheduled update of feeds in {} {}",SimpleDateFormatUtil.format(stopFeeds-startFeeds),SimpleDateFormatUtil.isLessThanMinute(stopFeeds-startFeeds) ? "seconds" : "minute(s)");
		}
	}
	
	/**
	 * Retrieves a feed by {@link FeedMetaEnum}.
	 * @param feedMetaEnum  a non <code>null</code> {@link FeedMetaEnum}
	 * @return the found feed
	 */
	private final FEED getFeed(final FeedMetaEnum feedMetaEnum) {
		final FEED feed=FEEDS_MAP.containsKey(feedMetaEnum) ? 
				FEEDS_MAP.get(feedMetaEnum) :
				FeedUtil.getFeed(feedMetaEnum, brusselNieuwsRss);
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
			feedMetaResponses.add(new FeedMetaResponse(feedMetaEnum.getTranslatedName(),feedMetaEnum.getRequestId(),feedMetaEnum.getCategory().name()));
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
	public void setBrusselNieuwsRss(final BrusselNieuwsRss<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,CREATOR,ARTICLE,FEED> brusselNieuwsRss) {
		this.brusselNieuwsRss = brusselNieuwsRss;
	}

}
