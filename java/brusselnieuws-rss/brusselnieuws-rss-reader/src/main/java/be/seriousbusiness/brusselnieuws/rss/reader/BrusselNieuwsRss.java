package be.seriousbusiness.brusselnieuws.rss.reader;

import java.net.URL;

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
	private URL newsHeadlines,newsSurvey,societyNews,politicalNews,economicalNews,sportsNews,awelMerciNews,childrensNews,cityNews,peopleNews;
	
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
	
	public FEED getNewsHeadLines() {
		return getFeed(newsHeadlines);
	}
	
	public FEED getNewsSurvey() {
		return getFeed(newsSurvey);
	}

	public FEED getSocietyNews() {
		return getFeed(societyNews);
	}
	
	public FEED getPoliticalNews() {
		return getFeed(politicalNews);
	}
	
	public FEED getEconomicalNews() {
		return getFeed(economicalNews);
	}
	
	public FEED getSportsNews() {
		return getFeed(sportsNews);
	}
	
	public FEED getAwelMerciNews() {
		return getFeed(awelMerciNews);
	}
	
	public FEED getChildrensNews() {
		return getFeed(childrensNews);
	}
	
	public FEED getCityNews() {
		return getFeed(cityNews);
	}
	
	public FEED getPeopleNews() {
		return getFeed(peopleNews);
	}
	
	/* SETTERS */
	
	public void setFeedManager(final FeedManager<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE,FEED> feedManager) {
		this.feedManager = feedManager;
	}
	
	public void setBrusselNieuwsRssReader(final BrusselNieuwsRssReader<FEED> brusselNieuwsRssReader) {
		this.brusselNieuwsRssReader = brusselNieuwsRssReader;
	}

	public void setFeedFactory(final FeedFactory<FEED> feedFactory) {
		this.feedFactory = feedFactory;
	}
	
	public void setNewsHeadlinesURL(final URL newsHeadlines) {
		this.newsHeadlines=newsHeadlines;
	}
	
	public void setNewsSurveyURL(final URL newsSurvey) {
		this.newsSurvey=newsSurvey;
	}

	public void setSocietyNewsURL(final URL societyNews) {
		this.societyNews = societyNews;
	}

	public void setPoliticalNewsURL(final URL politicalNews) {
		this.politicalNews = politicalNews;
	}

	public void setEconomicalNewsURL(final URL economicalNews) {
		this.economicalNews = economicalNews;
	}

	public void setSportsNewsURL(final URL sportsNews) {
		this.sportsNews = sportsNews;
	}

	public void setAwelMerciNewsURL(final URL awelMerciNews) {
		this.awelMerciNews = awelMerciNews;
	}

	public void setChildrensNewsURL(final URL childrensNews) {
		this.childrensNews = childrensNews;
	}
	
	public void setCityNewsURL(final URL cityNews) {
		this.cityNews = cityNews;
	}
	
	public void setPeopleNewsURL(final URL peopleNews) {
		this.peopleNews = peopleNews;
	}
	
}
