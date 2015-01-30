package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;

/**
 * Compares {@link Author}s by name.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Author}
 */
public class AuthorNameComparator implements Comparator<Author> {
	
	/**
	 * Compares two {@link Author}s by name.
	 */
	@Override
	public int compare(final Author author1,final Author author2) {
		return author2.getName().compareTo(author1.getName());
	}

}
