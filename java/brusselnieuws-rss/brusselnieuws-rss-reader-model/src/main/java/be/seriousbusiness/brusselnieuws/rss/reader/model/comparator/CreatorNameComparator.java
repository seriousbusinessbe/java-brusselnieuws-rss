package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;

/**
 * Compares {@link Creator}s by name.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Creator}
 */
public class CreatorNameComparator implements Comparator<Creator> {

	/**
	 * Compares two {@link Creator}s by name.
	 */
	@Override
	public int compare(final Creator creator1,final Creator creator2) {
		return creator2.getName().compareTo(creator1.getName());
	}
}
