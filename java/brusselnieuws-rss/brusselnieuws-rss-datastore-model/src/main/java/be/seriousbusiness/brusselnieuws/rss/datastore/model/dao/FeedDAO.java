package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link FeedDTO}.
 * @author stefanborghys
 * @param <DTO> the type of {@link FeedDTO}
 */
public interface FeedDAO<DTO extends FeedDTO> extends IdDAO<Long,DTO> {
	
	/**
	 * Find a {@link FeedDTO} by link
	 * @param link the link to look for
	 * @return a found {@link FeedDTO} or <code>null</code>
	 */
	FeedDTO findByLink(final String link);

}
