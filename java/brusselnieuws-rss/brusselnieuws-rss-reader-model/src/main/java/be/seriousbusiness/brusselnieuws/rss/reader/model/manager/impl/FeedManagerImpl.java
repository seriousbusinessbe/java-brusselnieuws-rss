package be.seriousbusiness.brusselnieuws.rss.reader.model.manager.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.FeedDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.manager.FeedManager;

public class FeedManagerImpl implements FeedManager<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,CreatorImpl,ArticleImpl,FeedImpl> {
	private FeedDAO feedDAO;
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	
	public Collection<FeedImpl> findAll(){
		final Collection<FeedImpl> feeds=new ArrayList<FeedImpl>();
		final Collection<FeedDTOImpl> feedDTOImpls=feedDAO.findAll();
		if(feedDTOImpls!=null){
			for(final FeedDTOImpl feedDTOImpl : feedDTOImpls){
				final FeedImpl feedImpl=mapper.map(feedDTOImpl, FeedImpl.class);
				feeds.add(feedImpl);
			}
		}
		return feeds;
	}
	
	@Override
	public FeedImpl findByLink(final URL url) {
		final FeedDTOImpl feedDTOImpl=feedDAO.findByLink(url.toString());
		if(feedDTOImpl!=null) {
			return mapper.map(feedDTOImpl,FeedImpl.class);
		}
		return null;
	}
	
	@Override
	public FeedImpl save(final FeedImpl feed) {
		if(feed!=null) {
			final FeedDTOImpl feedDTOImpl=mapper.map(feed,FeedDTOImpl.class);
			final FeedDTOImpl savedFeedDTOImpl=feedDAO.save(feedDTOImpl);
			return mapper.map(savedFeedDTOImpl,FeedImpl.class);
		}
		return feed;
	}
	
	public void setFeedDAO(final FeedDAO feedDAO){
		this.feedDAO=feedDAO;
	}

}
