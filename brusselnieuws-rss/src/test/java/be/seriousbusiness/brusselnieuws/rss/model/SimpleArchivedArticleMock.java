package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleArchivedArticleMock implements Article {
	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleArchivedArticleMock.class);
	private DateTime publicationDate=DateTime.now();

	@Override
	public String getTitle() {
		return "Simple Archived Article Mock";
	}

	@Override
	public URL getLink() {
		try {
			return new URL("http://www.brusselnieuws.be");
		} catch (final MalformedURLException e) {
			LOGGER.error("Malformed URL",e);
			return null;
		}
	}

	@Override
	public String getDescription() {
		return "Simple Archived Article Mock description";
	}

	@Override
	public boolean hasDescription() {
		return true;
	}

	@Override
	public int numberOfAuthors() {
		return 0;
	}

	@Override
	public List<Author> getAuthors() {
		return new ArrayList<Author>();
	}

	@Override
	public boolean hasAuthor(final Author author) {
		return false;
	}

	@Override
	public int numberOfCategories() {
		return 0;
	}

	@Override
	public boolean hasCategory(final Category category) {
		return false;
	}

	@Override
	public int numberOfMedia() {
		return 0;
	}

	@Override
	public List<Medium> getMedia() {
		return new ArrayList<Medium>();
	}

	@Override
	public List<Category> getCategories() {
		return new ArrayList<Category>();
	}

	@Override
	public DateTime getPublicationDate() {
		return publicationDate;
	}

	@Override
	public boolean isRead() {
		return false;
	}

	@Override
	public void read() {}

	@Override
	public boolean isArchived() {
		return true;
	}

	@Override
	public void archive() {}

	@Override
	public boolean isFavorite() {
		return false;
	}

	@Override
	public void setFavorite(boolean favorite) {}

}

