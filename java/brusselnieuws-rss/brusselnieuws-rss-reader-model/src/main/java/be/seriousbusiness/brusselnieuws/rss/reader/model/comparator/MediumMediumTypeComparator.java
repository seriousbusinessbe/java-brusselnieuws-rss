package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

public class MediumMediumTypeComparator<MEDIUMTYPE extends MediumType,
										MEDIUM extends Medium<MEDIUMTYPE>> implements Comparator<MEDIUM> {

	@Override
	public int compare(final MEDIUM medium1,final MEDIUM medium2) {
		return medium1.getType().compareTo(medium2.getType());
	}

}
