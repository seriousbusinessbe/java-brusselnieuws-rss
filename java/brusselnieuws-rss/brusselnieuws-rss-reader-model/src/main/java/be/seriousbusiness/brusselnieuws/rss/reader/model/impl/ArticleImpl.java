package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dozer.Mapper;
import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.AuthorNameComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.CategoryNameComparator;

public class ArticleImpl extends AbstractIdImpl<BigInteger> implements Article<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl> {
	private String title;
	private URL link;
	private String description;
	private Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
	private Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
	private Collection<MediumImpl> media=new ArrayList<MediumImpl>();
	private DateTime publicationDate;
	private boolean read=false;
	private boolean archived=false;
	private boolean favorite=false;
	private static final Comparator<Author> AUTHOR_COMPARATOR=new AuthorNameComparator(); 
	private static final Comparator<Category> CATEGORY_COMPARATOR=new CategoryNameComparator();
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private ArticleImpl(){}
	
	private ArticleImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		if(builder.description!=null){
			setDescription(builder.description);
		}
		setAuthors(builder.authors);
		setCategories(builder.categories);
		setMedia(builder.media);
		setPublicationDate(builder.publicationDate);
		if(builder.read!=null){
			setRead(builder.read);
		}
		if(builder.archived!=null){
			setArchived(builder.archived);
		}
		if(builder.favorite!=null){
			setFavorite(builder.favorite);
		}
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,description;
		private URL link;
		private Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
		private Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
		private Collection<MediumImpl> media=new ArrayList<MediumImpl>();
		private DateTime publicationDate;
		private Boolean read,archived,favorite;
		
		public ArticleImpl build() throws IllegalArgumentException{
			return new ArticleImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder title(final String title){
			this.title=title;
			return this;
		}
		
		public Builder link(final URL link){
			this.link=link;
			return this;
		}
		
		public Builder description(final String description){
			this.description=description;
			return this;
		}
		
		public Builder authors(final Collection<AuthorImpl> authors){
			this.authors=authors;
			return this;
		}
		
		public Builder categories(final Collection<CategoryImpl> categories){
			this.categories=categories;
			return this;
		}
		
		public Builder media(final Collection<MediumImpl> media){
			this.media=media;
			return this;
		}
		
		public Builder publicationDate(final DateTime publicationDate){
			this.publicationDate=publicationDate;
			return this;
		}
		
		public Builder read(final boolean read){
			this.read=read;
			return this;
		}
		
		public Builder archived(final boolean archived){
			this.archived=archived;
			return this;
		}
		
		public Builder favorite(final boolean favorite){
			this.favorite=favorite;
			return this;
		}
		
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(final String title) throws IllegalArgumentException {
		if(title==null || title.isEmpty()){
			throw new IllegalArgumentException("The title is null or empty");
		}
		this.title=title.trim();
	}

	@Override
	public URL getLink() {
		return link;
	}

	@Override
	public void setLink(final URL link) throws IllegalArgumentException {
		if(link==null){
			throw new IllegalArgumentException("The link is null");
		}
		this.link=link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description)
			throws IllegalArgumentException {
		if(description==null || description.isEmpty()){
			throw new IllegalArgumentException("The description is null or empty");
		}
		this.description=description.trim();
	}

	@Override
	public boolean hasDescription() {
		return description!=null;
	}

	@Override
	public int numberOfAuthors() {
		return authors.size();
	}

	@Override
	public Collection<AuthorImpl> getAuthors() {
		final List<AuthorImpl> authors=new ArrayList<AuthorImpl>(this.authors);
		Collections.sort(authors,AUTHOR_COMPARATOR);
		return authors;
	}

	@Override
	public void setAuthors(final Collection<AuthorImpl> authors) {
		if(authors!=null){
			for(final AuthorImpl author : authors){
				add(author);
			}
		}
	}

	@Override
	public void add(final AuthorImpl author) {
		if(author!=null && !this.authors.contains(author)){
			this.authors.add(author);
		}
	}

	@Override
	public boolean hasAuthor(AuthorImpl author) {
		return authors.contains(author);
	}

	@Override
	public int numberOfCategories() {
		return categories.size();
	}

	@Override
	public Collection<CategoryImpl> getCategories() {
		final List<CategoryImpl> categories=new ArrayList<CategoryImpl>(this.categories);
		Collections.sort(categories,CATEGORY_COMPARATOR);
		return categories;
	}

	@Override
	public void setCategories(final Collection<CategoryImpl> categories) {
		if(categories!=null){
			for(final CategoryImpl category : categories){
				add(category);
			}
		}
	}

	@Override
	public void add(final CategoryImpl category) {
		if(category!=null && !this.categories.contains(category)){
			this.categories.add(category);
		}
	}

	@Override
	public boolean hasCategory(final CategoryImpl category) {
		return categories.contains(category);
	}

	@Override
	public int numberOfMedia() {
		return media.size();
	}

	@Override
	public Collection<MediumImpl> getMedia() {
		return new ArrayList<MediumImpl>(media);
	}

	@Override
	public void setMedia(final Collection<MediumImpl> media) {
		if(media!=null){
			for(final MediumImpl medium : media){
				add(medium);
			}
		}
	}
	
	@Override
	public void add(final MediumImpl medium) {
		if(medium!=null && !this.media.contains(medium)){
			this.media.add(medium);
		}
	}

	@Override
	public DateTime getPublicationDate() {
		return new DateTime(publicationDate);
	}

	@Override
	public void setPublicationDate(DateTime publicationDate)
			throws IllegalArgumentException {
		if(publicationDate==null || publicationDate.isAfterNow()){
			throw new IllegalArgumentException("The publication date is null or in the future");
		}
		this.publicationDate=publicationDate;
	}

	@Override
	public boolean isRead() {
		return read;
	}

	@Override
	public void setRead(final boolean read) {
		this.read=read;
	}

	@Override
	public void read() {
		read=true;
	}

	@Override
	public boolean isArchived() {
		return archived;
	}

	@Override
	public void setArchived(boolean archived) {
		this.archived=archived;
	}

	@Override
	public void archive() {
		archived=true;
	}

	@Override
	public boolean isFavorite() {
		return favorite;
	}

	@Override
	public void setFavorite(boolean favorite) {
		this.favorite=favorite;
	}

	@Override
	public void favorite() {
		favorite=true;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof ArticleImpl && 
				ObjectUtil.isNullOrEqual(title,((ArticleImpl)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((ArticleImpl)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((ArticleImpl)obj).description) &&
				ObjectUtil.isNullOrEqual(publicationDate,((ArticleImpl)obj).publicationDate) &&
				ObjectUtil.isNullOrEqual(read,((ArticleImpl)obj).read) &&
				ObjectUtil.isNullOrEqual(archived,((ArticleImpl)obj).archived) &&
				ObjectUtil.isNullOrEqual(favorite,((ArticleImpl)obj).favorite) &&
				ObjectUtil.isNullOrEqual(media,((ArticleImpl)obj).media) &&
				ObjectUtil.isNullOrEqual(categories,((ArticleImpl)obj).categories) &&
				ObjectUtil.isNullOrEqual(authors,((ArticleImpl)obj).authors);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(publicationDate) *
				ObjectUtil.hashCode(read) *
				ObjectUtil.hashCode(archived) *
				ObjectUtil.hashCode(favorite) *
				ObjectUtil.hashCode(media) *
				ObjectUtil.hashCode(categories) *
				ObjectUtil.hashCode(authors);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		final Collection<AuthorImpl> clonedAuthors=new ArrayList<AuthorImpl>();
		for(final AuthorImpl authorImpl : authors) {
			clonedAuthors.add((AuthorImpl)authorImpl.clone());
		}
		final Collection<CategoryImpl> clonedCategories=new ArrayList<CategoryImpl>();
		for(final CategoryImpl categoryImpl : categories) {
			clonedCategories.add((CategoryImpl)categoryImpl.clone());
		}
		final Collection<MediumImpl> clonedMedia=new ArrayList<MediumImpl>();
		for(final MediumImpl mediumImpl : media) {
			clonedMedia.add((MediumImpl)mediumImpl.clone());
		}
		return new Builder().id(id)
				.title(title)
				.link(link)
				.description(description)
				.publicationDate(publicationDate)
				.read(read)
				.archived(archived)
				.favorite(favorite)
				.authors(clonedAuthors)
				.categories(clonedCategories)
				.media(clonedMedia).build();
	}
	
}
