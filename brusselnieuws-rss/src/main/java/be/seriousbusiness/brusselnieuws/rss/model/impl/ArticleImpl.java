package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.text.SimpleDateFormat;
import java.util.Set;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Media;

public class ArticleImpl extends AbstractContent implements Article {
	private final Manager<Author> authorManager;
	private final Manager<Media> mediaManager;
	private final Manager<Category> categoryManager;
	private DateTime publicationDate;
	
	protected ArticleImpl(final String title,final Manager<Author> authorManager,final Manager<Media> mediaManager,final Manager<Category> categoryManager) throws IllegalArgumentException{
		super(title);
		if(authorManager==null){
			throw new IllegalArgumentException("The author manager is null");
		}
		if(mediaManager==null){
			throw new IllegalArgumentException("The media manager is null");
		}
		if(categoryManager==null){
			throw new IllegalArgumentException("The category manager is null");
		}
		this.authorManager=authorManager;
		this.mediaManager=mediaManager;
		this.categoryManager=categoryManager;
	}
	
	/**
	 * Add a new Author.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	protected void add(final Author author) {
		authorManager.add(author);
	}

	@Override
	public Set<Author> getAuthors() {
		return authorManager.getAll();
	}
	
	@Override
	public boolean hasAuthor(final Author author) {
		return authorManager.has(author);
	}
	
	@Override
	public boolean hasCategory(final Category category) {
		return categoryManager.has(category);
	}
	
	/**
	 * Add a new Media.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	protected void add(final Media media) {
		mediaManager.add(media);
	}

	@Override
	public Set<Media> getMedia() {
		return mediaManager.getAll();
	}
	
	/**
	 * Add a new Category.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	protected void add(final Category category) {
		categoryManager.add(category);
	}

	@Override
	public Set<Category> getCategories() {
		return categoryManager.getAll();
	}
	
	/**
	 * Set a publication date
	 * @param publicationDate
	 * @throws IllegalArgumentException when <code>null</code> or in the future
	 */
	protected void setPublicationDate(final DateTime publicationDate) throws IllegalArgumentException{
		if(publicationDate==null || publicationDate.isAfterNow()){
			throw new IllegalArgumentException("The publication date is null or in the future");
		}
		this.publicationDate=publicationDate;
	}

	@Override
	public DateTime getPublicationDate() {
		return publicationDate;
	}
	
	@Override
	public String toString(){
		return publicationDate!=null ? new SimpleDateFormat("dd/MM/yyyy HH:mm").format(publicationDate.toDate()) : "" + super.toString();
	}

}
