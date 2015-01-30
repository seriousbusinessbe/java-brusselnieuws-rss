package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

/**
 * Compares {@link Medium}s by type.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see {@link Article}
 * @param <MEDIUMTYPE> the type of {@link MediumType}
 * @param <MEDIUM> the type of {@link Medium}
 */
public class MediumMediumTypeComparator<MEDIUMTYPE extends MediumType,
										MEDIUM extends Medium<MEDIUMTYPE>> implements Comparator<MEDIUM> {

	/**
	 * Compares two {@link Medium} by type.
	 */
	@Override
	public int compare(final MEDIUM medium1,final MEDIUM medium2) {
		return medium1.getType().compareTo(medium2.getType());
	}

}
