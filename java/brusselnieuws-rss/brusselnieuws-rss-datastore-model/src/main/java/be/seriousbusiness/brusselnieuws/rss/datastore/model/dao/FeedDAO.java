package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link FeedDTO}.
 * @author stefanborghys
 * 
 */
public interface FeedDAO extends IdDAO<BigInteger,FeedDTOImpl> {
	
	/**
	 * Find a {@link FeedDTOImpl} by link
	 * @param link the link to look for
	 * @return a found {@link FeedDTOImpl} or <code>null</code>
	 */
	FeedDTOImpl findByLink(final String link);

}
