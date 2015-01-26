package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link FeedDTO}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface FeedDAO extends IdDAO<BigInteger,FeedDTOImpl> {
	
	/**
	 * Finds a {@link FeedDTOImpl} by link
	 * @param link the URL location link to look for
	 * @return a found {@link FeedDTOImpl} or <code>null</code> when not found
	 */
	FeedDTOImpl findByLink(final String link);

}
