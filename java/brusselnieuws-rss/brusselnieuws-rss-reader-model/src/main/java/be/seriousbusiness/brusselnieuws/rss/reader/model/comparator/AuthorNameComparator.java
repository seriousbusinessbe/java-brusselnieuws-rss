package be.seriousbusiness.brusselnieuws.rss.reader.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;

public class AuthorNameComparator implements Comparator<Author> {

	@Override
	public int compare(final Author author1,final Author author2) {
		return author2.getName().compareTo(author1.getName());
	}

}
