package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;

/**
 * Compares {@link Article}s by publication date from newest to oldest.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Article}
 */
public class ArticlePublicationDateComparator implements Comparator<Article<?,?,?,?,?>> {

	/**
	 * Compares two {@link Article}s by publication date, newest to oldest.
	 */
	@Override
	public int compare(final Article<?,?,?,?,?> article1,final Article<?,?,?,?,?> article2) {
		return article2.getPublicationDate().compareTo(article1.getPublicationDate());
	}

}
