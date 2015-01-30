package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;

/**
 * Compares two {@link Category} by name.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Category}
 */
public class CategoryNameComparator implements Comparator<Category> {

	/**
	 * Compares two {@link Category} by name.
	 */
	@Override 
	public int compare(final Category category1,final Category category2) {
		return category1.getName().compareTo(category2.getName());
	}

}
