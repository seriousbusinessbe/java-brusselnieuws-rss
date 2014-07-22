package be.seriousbusiness.brusselnieuws.rss.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.model.Article;

/**
 * Can be used to order articles by publication date</br>
 * from newest to oldest.
 * @author stefanborghys
 *
 */
public class ArticlePublicationDateComparator implements Comparator<Article> {

	/**
	 * Compares two articles by publication date.
	 */
	@Override
	public int compare(final Article article1,final Article article2) {
		return article2.getPublicationDate().compareTo(article1.getPublicationDate());
	}

}
