package be.seriousbusiness.brusselnieuws.rss.model.builder;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Category;

/**
 * Defines a Category builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface CategoryBuilder extends Builder<Category> {
	
	/**
	 * Set a name
	 * @param name
	 * @return this CategoryBuilder
	 */
	CategoryBuilder name(final String name);
	
	/**
	 * Set a link
	 * @param link
	 * @return this CategoryBuilder
	 */
	CategoryBuilder link(final URL link);
}
