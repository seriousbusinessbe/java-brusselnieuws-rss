package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dozer.Mapper;
import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.AuthorNameComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.CategoryNameComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.CreatorNameComparator;

public class ArticleImpl extends AbstractIdImpl<BigInteger> implements Article<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,CreatorImpl> {
	private String title;
	private URL link;
	private String description;
	private Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
	private Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
	private Collection<MediumImpl> media=new ArrayList<MediumImpl>();
	private Collection<CreatorImpl> creators=new ArrayList<CreatorImpl>();
	private DateTime publicationDate;
	private boolean read=false;
	private boolean archived=false;
	private boolean favorite=false;
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final Comparator<Author> AUTHOR_COMPARATOR=new AuthorNameComparator(); 
	private static final Comparator<Category> CATEGORY_COMPARATOR=new CategoryNameComparator();
	private static final Comparator<Creator> CREATOR_COMPARATOR=new CreatorNameComparator();
	
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
		setCreators(builder.creators);
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
		private Collection<CreatorImpl> creators=new ArrayList<CreatorImpl>();
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
		
		public Builder creators(final Collection<CreatorImpl> creators){
			this.creators=creators;
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
	public int numberOfCreators() {
		return creators.size();
	}

	@Override
	public Collection<CreatorImpl> getCreators() {
		final List<CreatorImpl> creators=new ArrayList<CreatorImpl>(this.creators);
		Collections.sort(creators,CREATOR_COMPARATOR);
		return creators;
	}

	@Override
	public void setCreators(final Collection<CreatorImpl> creators) {
		if(creators!=null){
			for(final CreatorImpl creator : creators){
				add(creator);
			}
		}
	}

	@Override
	public void add(final CreatorImpl creator) {
		if(creator!=null && !creators.contains(creator)){
			creators.add(creator);
		}
	}

	@Override
	public boolean hasCreator(final CreatorImpl creator) {
		return creators.contains(creator);
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
	public void setPublicationDate(final DateTime publicationDate)
			throws IllegalArgumentException {
		if(publicationDate==null){
			throw new IllegalArgumentException("The publication date is null");
		}else if(publicationDate.isAfterNow()) {
			final String simplePublicationDate=SIMPLE_DATE_FORMAT.format(publicationDate.toDate());
			final String simpleNow=SIMPLE_DATE_FORMAT.format(new Date());
			throw new IllegalArgumentException("The publication date '"+simplePublicationDate+"' is in the future (now : '"+simpleNow+"')") ;
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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final ArticleImpl articleImpl = (ArticleImpl) obj;
		return new EqualsBuilder()
				.append(title,articleImpl.getTitle())
				.append(link,articleImpl.getLink())
				.append(description,articleImpl.getDescription())
				.append(publicationDate,articleImpl.getPublicationDate())
				.append(read,articleImpl.isRead())
				.append(archived,articleImpl.isArchived())
				.append(favorite,articleImpl.isFavorite())
                .isEquals() 
                && CollectionUtils.isEqualCollection(media,articleImpl.getMedia())
                && CollectionUtils.isEqualCollection(categories,articleImpl.getCategories())
                && CollectionUtils.isEqualCollection(authors,articleImpl.getAuthors())
                && CollectionUtils.isEqualCollection(creators,articleImpl.getCreators());		
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(57,53)
		       .append(title)
		       .append(link)
		       .append(description)
		       .append(publicationDate)
		       .append(read)
		       .append(archived)
		       .append(favorite)
		       .append(media)
		       .append(categories)
		       .append(authors)
		       .append(creators)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			    .append("title",title)
		        .append("link",link)
		        .append("description",description)
		        .append("publicationDate",publicationDate)
		        .append("read",read)
		        .append("archived",archived)
		        .append("favorite",favorite)
		        .append("media",media)
		        .append("categories",categories)
		        .append("authors",authors)
		        .append("creators",creators)
				.toString();
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
		final Collection<CreatorImpl> clonedCreators=new ArrayList<CreatorImpl>();
		for(final CreatorImpl creatorImpl : creators) {
			clonedCreators.add((CreatorImpl)creatorImpl.clone());
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
				.creators(clonedCreators)
				.media(clonedMedia).build();
	}
	
}
