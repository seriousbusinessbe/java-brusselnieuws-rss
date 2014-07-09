package be.seriousbusiness.brusselnieuws.rss.model.builder;

import java.net.URL;

/**
 * Defines a Content builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 * @param <E> the entity type
 */
public interface ContentBuilder<E> extends Builder<E> {
	
	/**
	 * Set a title
	 * @param title
	 * @return this ContentBuilder<E>
	 */
	ContentBuilder<E> title(final String title);
	
	/**
	 * Set a link
	 * @param link
	 * @return this ContentBuilder<E>
	 */
	ContentBuilder<E> link(final URL link);
	
	/**
	 * Set a description
	 * @param description
	 * @return this ContentBuilder<E>
	 */
	ContentBuilder<E> description(final String description);

}
