package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.FeedDTO;

public interface FeedDAO extends IdDAO<FeedDTO,Long> {
	
	FeedDTO findByLink(final String link);

}
