package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;

public class ArticleImpl extends AbstractContent implements Article {
	private final Manager<Author> authorManager;
	private final Manager<Medium> mediaManager;
	private final Manager<Category> categoryManager;
	private DateTime publicationDate;
	
	public static class Builder {
		private String title,description;
		private URL link;
		private final Set<Author> authors=new HashSet<Author>();
		private final Set<Medium> media=new HashSet<Medium>();
		private final Set<Category> categories=new HashSet<Category>();
		private DateTime publicationDate;

		public ArticleImpl build() {
			return new ArticleImpl(this);
		}
		
		public Builder title(final String title) {
			this.title=title;
			return this;
		}

		public Builder link(final URL link) {
			this.link=link;
			return this;
		}

		public Builder description(final String description) {
			this.description=description;
			return this;
		}

		public Builder add(final Author author) {
			authors.add(author);
			return this;
		}

		public Builder add(final Category category) {
			categories.add(category);
			return this;
		}

		public Builder add(final Medium medium) {
			media.add(medium);
			return this;
		}

		public Builder publicationDate(final DateTime publicationDate) {
			this.publicationDate=publicationDate;
			return this;
		}

	}
	
	private ArticleImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.title,new ManagerImpl<Author>(),new ManagerImpl<Medium>(),new ManagerImpl<Category>());
		if(builder.description!=null){
			setDescription(builder.description);
		}
		if(builder.link!=null){
			setLink(builder.link);
		}
		if(builder.publicationDate!=null){
			setPublicationDate(builder.publicationDate);
		}
		for(final Author author : builder.authors){
			add(author);
		}
		for(final Medium medium : builder.media){
			add(medium);
		}
		for(final Category category : builder.categories){
			add(category);
		}
	}
	
	protected ArticleImpl(final String title,final Manager<Author> authorManager,final Manager<Medium> mediaManager,final Manager<Category> categoryManager) throws IllegalArgumentException{
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
	protected void add(final Medium medium) {
		mediaManager.add(medium);
	}

	@Override
	public Set<Medium> getMedia() {
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
