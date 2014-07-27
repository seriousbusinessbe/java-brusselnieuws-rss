package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import be.seriousbusiness.brusselnieuws.rss.model.Author;

public interface AdaptableAuthor extends Author, AdaptableId<Long> {
	
	/**
	 * Set a new name.</br>
	 * The name will be converted to lower case and empty spaces will be trimmed off.
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	void setName(final String name) throws IllegalArgumentException;

}
