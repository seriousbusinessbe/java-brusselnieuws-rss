package be.seriousbusiness.brusselnieuws.rss.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.model.Medium;

public class MediumMediumTypeComparator implements Comparator<Medium> {

	@Override
	public int compare(Medium medium1, Medium medium2) {
		return medium1.getType().compareTo(medium2.getType());
	}

}
