package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Media;

public class ArticleImpl extends AbstractContent implements Article {
	private Set<Author> authors;
	private Set<Media> media;
	private Set<Category> categories;
	private DateTime publicationDate;
	
	public ArticleImpl(){
		authors=new HashSet<Author>();
		media=new HashSet<Media>();
		categories=new HashSet<Category>();
	}

	@Override
	public Set<Author> getAuthors() {
		return new HashSet<Author>(authors);
	}
	
	@Override
	public boolean hasAuthor(final Author author) {
		return authors.contains(author);
	}
	
	@Override
	public boolean inCategory(final Category category) {
		return categories.contains(category);
	}

	@Override
	public Set<Media> getMedia() {
		return new HashSet<Media>(media);
	}

	@Override
	public Set<Category> getCategories() {
		return new HashSet<Category>(categories);
	}

	@Override
	public DateTime getPublicationDate() {
		return publicationDate;
	}

}
