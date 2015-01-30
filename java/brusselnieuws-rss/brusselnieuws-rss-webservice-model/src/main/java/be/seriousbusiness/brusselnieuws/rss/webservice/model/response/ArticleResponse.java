package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

import java.util.ArrayList;
import java.util.Collection;

import org.joda.time.DateTime;

/**
 * Web service response bean containing article data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleResponse extends AbstractIdResponse {
	private String title;
	private String link;
	private String description;
	private Collection<AuthorResponse> authors=new ArrayList<AuthorResponse>();
	private Collection<CategoryResponse> categories=new ArrayList<CategoryResponse>();
	private Collection<MediumResponse> media=new ArrayList<MediumResponse>();
	private DateTime publicationDate;
	private boolean read=false;
	private boolean archived=false;
	private boolean favorite=false;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(final String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(final String link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public Collection<AuthorResponse> getAuthors() {
		return authors;
	}
	
	public void setAuthors(final Collection<AuthorResponse> authors) {
		this.authors = authors;
	}
	
	public Collection<CategoryResponse> getCategories() {
		return categories;
	}
	
	public void setCategories(final Collection<CategoryResponse> categories) {
		this.categories = categories;
	}
	
	public Collection<MediumResponse> getMedia() {
		return media;
	}
	
	public void setMedia(final Collection<MediumResponse> media) {
		this.media = media;
	}
	
	public DateTime getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(final DateTime publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public boolean isRead() {
		return read;
	}
	
	public void setRead(final boolean read) {
		this.read = read;
	}
	
	public boolean isArchived() {
		return archived;
	}
	
	public void setArchived(final boolean archived) {
		this.archived = archived;
	}
	
	public boolean isFavorite() {
		return favorite;
	}
	
	public void setFavorite(final boolean favorite) {
		this.favorite = favorite;
	}

}
