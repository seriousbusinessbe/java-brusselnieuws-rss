package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link FeedDAO}.
 * @author stefanborghys
 *
 */
public interface FeedDAO extends IdDAO<Long,FeedDTO> {
	
	/**
	 * Find a {@link FeedDTO} by link
	 * @param link the link to look for
	 * @return a found {@link FeedDTO} or <code>null</code>
	 */
	FeedDTO findByLink(final String link);

}
