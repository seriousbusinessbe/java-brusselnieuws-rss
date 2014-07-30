package be.seriousbusiness.brusselnieuws.rss.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.model.Category;

public class CategoryNameComparator implements Comparator<Category> {

	@Override 
	public int compare(Category category1, Category category2) {
		return category1.getName().compareTo(category2.getName());
	}

	

}
