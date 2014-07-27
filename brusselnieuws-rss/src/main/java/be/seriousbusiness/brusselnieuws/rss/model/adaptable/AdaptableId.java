package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import be.seriousbusiness.brusselnieuws.rss.model.Id;

public interface AdaptableId<ID> extends Id<ID> {
	
	/**
	 * Set a unique id
	 * @param id
	 */
	void setId(final ID id) throws IllegalArgumentException;

}
