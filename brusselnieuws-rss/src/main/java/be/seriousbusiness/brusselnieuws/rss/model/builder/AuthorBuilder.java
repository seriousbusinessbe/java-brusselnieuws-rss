package be.seriousbusiness.brusselnieuws.rss.model.builder;

import be.seriousbusiness.brusselnieuws.rss.model.Author;

/**
 * Defines an Author builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface AuthorBuilder extends Builder<Author> {
	/**
	 * Set a name.
	 * @param name
	 * @return this AuthorBuilder
	 */
	AuthorBuilder name(final String name);
}
