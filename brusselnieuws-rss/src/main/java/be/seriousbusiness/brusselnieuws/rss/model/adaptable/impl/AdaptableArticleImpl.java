package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableArticle;
import be.seriousbusiness.brusselnieuws.rss.model.comparator.AuthorNameComparator;
import be.seriousbusiness.brusselnieuws.rss.model.comparator.CategoryNameComparator;
import be.seriousbusiness.brusselnieuws.rss.model.comparator.MediumMediumTypeComparator;
import be.seriousbusiness.brusselnieuws.rss.model.impl.ManagerImpl;

public class AdaptableArticleImpl extends AbstractAdaptableContent<Long> implements AdaptableArticle {
	private final Manager<Author> authorManager;
	private final Manager<Medium> mediumManager;
	private final Manager<Category> categoryManager;
	private DateTime publicationDate;
	private boolean read,archived,favorite;
	
	/**
	 * Build a new AdaptableArticle.</br>
	 * By default the article is not read, archived, or marked favorite.
	 * @author stefanborghys
	 *
	 */
	public static class Builder {
		private Long id;
		private String title,description;
		private URL link;
		private final Set<Author> authors=new HashSet<Author>();
		private final Set<Medium> media=new HashSet<Medium>();
		private final Set<Category> categories=new HashSet<Category>();
		private DateTime publicationDate;
		private boolean read=false,archived=false,favorite=false;

		public AdaptableArticleImpl build() {
			return new AdaptableArticleImpl(this);
		}
		
		public Builder id(final long id){
			this.id=id;
			return this;
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
		
		public Builder read(final boolean read){
			this.read=read;
			return this;
		}
		
		public Builder archive(final boolean archived){
			this.archived=archived;
			return this;
		}
		
		public Builder favorite(final boolean favorite){
			this.favorite=favorite;
			return this;
		}

	}
	
	private AdaptableArticleImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.title,new ManagerImpl<Author>(),new ManagerImpl<Medium>(),new ManagerImpl<Category>(),builder.read,builder.archived,builder.favorite);
		if(builder.id!=null){
			setId(builder.id);
		}
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
	
	protected AdaptableArticleImpl(final String title,final Manager<Author> authorManager,final Manager<Medium> mediumManager,final Manager<Category> categoryManager,final boolean read,final boolean archived,final boolean favorite) throws IllegalArgumentException{
		super(title);
		if(authorManager==null){
			throw new IllegalArgumentException("The author manager is null");
		}
		if(mediumManager==null){
			throw new IllegalArgumentException("The medium manager is null");
		}
		if(categoryManager==null){
			throw new IllegalArgumentException("The category manager is null");
		}
		this.authorManager=authorManager;
		this.mediumManager=mediumManager;
		this.categoryManager=categoryManager;
		this.read=read;
		this.archived=archived;
		this.favorite=favorite;
	}
	
	public AdaptableArticleImpl(){
		authorManager=new ManagerImpl<Author>();
		mediumManager=new ManagerImpl<Medium>();
		categoryManager=new ManagerImpl<Category>();
		
	}
	
	@Override
	public int numberOfAuthors() {
		return authorManager.size();
	}
	
	@Override
	public void add(final Author author) {
		authorManager.add(author);
	}

	@Override
	public List<Author> getAuthors() {
		return authorManager.getAll(new AuthorNameComparator());
	}
	
	@Override
	public void setAuthors(Set<Author> authors) {
		if(authors!=null){
			for(final Author author : authors){
				authorManager.add(author);
			}
		}
	}
	
	@Override
	public boolean hasAuthor(final Author author) {
		return authorManager.has(author);
	}
	
	@Override
	public boolean hasCategory(final Category category) {
		return categoryManager.has(category);
	}
	
	@Override
	public int numberOfMedia() {
		return mediumManager.size();
	}
	
	/**
	 * Add a new Media.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	@Override
	public void add(final Medium medium) {
		mediumManager.add(medium);
	}

	@Override
	public List<Medium> getMedia() {
		return mediumManager.getAll(new MediumMediumTypeComparator());
	}
	
	@Override
	public int numberOfCategories() {
		return categoryManager.size();
	}
	
	/**
	 * Add a new Category.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	@Override
	public void add(final Category category) {
		categoryManager.add(category);
	}

	@Override
	public List<Category> getCategories() {
		return categoryManager.getAll(new CategoryNameComparator());
	}
	
	@Override
	public void setPublicationDate(final DateTime publicationDate) throws IllegalArgumentException{
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
	public boolean isRead() {
		return read;
	}
	
	@Override
	public void setRead(boolean read) {
		this.read=read;
	}
	
	@Override
	public void read() {
		setRead(true);
	}
	
	@Override
	public boolean isArchived() {
		return archived;
	}
	
	@Override
	public void setArchived(final boolean archived) {
		this.archived=archived;
	}

	@Override
	public void archive() {
		setArchived(true);
	}
	
	@Override
	public boolean isFavorite() {
		return favorite;
	}

	@Override
	public void setFavorite(final boolean favorite) {
		this.favorite=favorite;
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Manager){
			final Article article=(Article)obj;
			return super.equals(obj) && 
					authorManager.equals(article.getAuthors()) &&
					categoryManager.equals(article.getCategories()) &&
					mediumManager.equals(article.getMedia()) &&
					publicationDate.equals(article.getPublicationDate()) &&
					super.equals(obj);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * authorManager.hashCode() * categoryManager.hashCode() * mediumManager.hashCode() * publicationDate.hashCode() * super.hashCode();
	}
	
	@Override
	public String toString(){
		return super.toString() + " " + (publicationDate!=null ? new SimpleDateFormat("dd/MM/yyyy HH:mm").format(publicationDate.toDate()) : "") + " - " + super.toString();
	}

}
