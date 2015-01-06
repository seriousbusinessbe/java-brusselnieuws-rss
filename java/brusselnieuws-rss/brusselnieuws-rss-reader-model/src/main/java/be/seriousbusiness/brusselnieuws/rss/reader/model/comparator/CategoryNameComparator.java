package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;

public class CategoryNameComparator implements Comparator<Category> {

	@Override 
	public int compare(final Category category1,final Category category2) {
		return category1.getName().compareTo(category2.getName());
	}

}
