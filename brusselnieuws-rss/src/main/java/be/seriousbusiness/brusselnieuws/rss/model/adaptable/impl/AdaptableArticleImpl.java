package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
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

public class AdaptableArticleImpl extends AbstractAdaptableContent implements AdaptableArticle {
	private final Manager<Author> authorManager;
	private final Manager<Medium> mediumManager;
	private final Manager<Category> categoryManager;
	private DateTime publicationDate;
	
	public static class Builder {
		private String title,description;
		private URL link;
		private final Set<Author> authors=new HashSet<Author>();
		private final Set<Medium> media=new HashSet<Medium>();
		private final Set<Category> categories=new HashSet<Category>();
		private DateTime publicationDate;

		public AdaptableArticleImpl build() {
			return new AdaptableArticleImpl(this);
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
	
	private AdaptableArticleImpl(final Builder builder) throws IllegalArgumentException{
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
	
	protected AdaptableArticleImpl(final String title,final Manager<Author> authorManager,final Manager<Medium> mediumManager,final Manager<Category> categoryManager) throws IllegalArgumentException{
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
		final Set<Author> authors=authorManager.getAll();
		final List<Author> orderedAuthorList=Arrays.asList(authors.toArray(new Author[authors.size()]));
		Collections.sort(orderedAuthorList,new AuthorNameComparator());
		return orderedAuthorList;
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
		final Set<Medium> media=mediumManager.getAll();
		final List<Medium> orderedMediumList=Arrays.asList(media.toArray(new Medium[media.size()]));
		Collections.sort(orderedMediumList,new MediumMediumTypeComparator());
		return orderedMediumList;
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
		final Set<Category> categories=categoryManager.getAll();
		final List<Category> orderedCategoryList=Arrays.asList(categories.toArray(new Category[categories.size()]));
		Collections.sort(orderedCategoryList,new CategoryNameComparator());
		return orderedCategoryList;
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
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Manager){
			final Article article=(Article)obj;
			return authorManager.equals(article.getAuthors()) &&
					categoryManager.equals(article.getCategories()) &&
					mediumManager.equals(article.getMedia()) &&
					publicationDate.equals(article.getPublicationDate()) &&
					super.equals(obj);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return (publicationDate!=null ? new SimpleDateFormat("dd/MM/yyyy HH:mm").format(publicationDate.toDate()) : "") + " - " + super.toString();
	}

}
