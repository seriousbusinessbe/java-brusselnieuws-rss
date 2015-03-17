package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.CollectionsUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;

/**
 * Spring-data {@link MongoArticle} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="article")
public class MongoArticle implements ArticleDTO<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor,MongoCreator> {
	@Id
	private BigInteger id;
	@Field("title")
	private String title;
	@Field("link")
	private String link;
	@Field("description")
	private String description;
	@Field("publication_date")
	private Long publicationDate;
	@Field("read")
	private Boolean read;
	@Field("archived")
	private Boolean archived;
	@Field("favorite")
	private Boolean favorite;
	@DBRef
	private Collection<MongoMedium> mongoMediums;
	@DBRef
	private Collection<MongoCategory> mongoCategories;
	@DBRef
	private Collection<MongoAuthor> mongoAuthors;
	@DBRef
	private Collection<MongoCreator> mongoCreators;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoArticle(){}
	
	private MongoArticle(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		setDescription(builder.description);
		setPublicationDate(builder.publicationDate);
		setRead(builder.read);
		setArchived(builder.archived);
		setFavorite(builder.favorite);
		setMediumDTOs(builder.mongoMediums);
		setCategoryDTOs(builder.mongoCategories);
		setAuthorDTOs(builder.mongoAuthors);
		setCreatorDTOs(builder.mongoCreators);
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,link,description;
		private Long publicationDate;
		private Boolean read,archived,favorite;
		private Collection<MongoMedium> mongoMediums=new ArrayList<MongoMedium>();
		private Collection<MongoCategory> mongoCategories=new ArrayList<MongoCategory>();
		private Collection<MongoAuthor> mongoAuthors=new ArrayList<MongoAuthor>();
		private Collection<MongoCreator> mongoCreators=new ArrayList<MongoCreator>();
		
		public MongoArticle build() throws IllegalArgumentException{
			return new MongoArticle(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder title(final String title){
			this.title=title;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
			return this;
		}
		
		public Builder description(final String description) {
			this.description=description;
			return this;
		}
		
		public Builder publicationDate(final Long publicationDate) {
			this.publicationDate=publicationDate;
			return this;
		}
		
		public Builder read(final Boolean read) {
			this.read=read;
			return this;
		}
		
		public Builder archived(final Boolean archived) {
			this.archived=archived;
			return this;
		}
		
		public Builder favorite(final Boolean favorite) {
			this.favorite=favorite;
			return this;
		}
				
		public Builder mediumDTOs(final Collection<MongoMedium> mongoMediums) {
			this.mongoMediums=mongoMediums;
			return this;
		}
		
		public Builder categoryDTOs(final Collection<MongoCategory> mongoCategories) {
			this.mongoCategories=mongoCategories;
			return this;
		}
		
		public Builder authorDTOs(final Collection<MongoAuthor> mongoAuthors) {
			this.mongoAuthors=mongoAuthors;
			return this;
		}
		
		public Builder creatorDTOs(final Collection<MongoCreator> mongoCreators) {
			this.mongoCreators=mongoCreators;
			return this;
		}
		
	}

	@Override
	public BigInteger getId() {
		return id;
	}

	@Override
	public void setId(final BigInteger id) {
		this.id=id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(final String title) {
		this.title=title;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		this.description=description;
	}

	@Override
	public Long getPublicationDate() {
		return publicationDate;
	}

	@Override
	public void setPublicationDate(final Long publicationDate) {
		this.publicationDate=publicationDate;
	}

	@Override
	public Boolean isRead() {
		return read;
	}

	@Override
	public void setRead(final Boolean read) {
		this.read=read;
	}
	
	@Override
	public Boolean getRead(){
		return read;
	}

	@Override
	public Boolean isArchived() {
		return archived;
	}

	@Override
	public void setArchived(final Boolean archived) {
		this.archived=archived;
	}
	
	@Override
	public Boolean getArchived(){
		return archived;
	}

	@Override
	public Boolean isFavorite() {
		return favorite;
	}

	@Override
	public void setFavorite(final Boolean favorite) {
		this.favorite=favorite;
	}
	
	@Override
	public Boolean getFavorite(){
		return favorite;
	}

	@Override
	public Collection<MongoMedium> getMediumDTOs() {
		return mongoMediums;
	}

	@Override
	public void setMediumDTOs(final Collection<MongoMedium> mongoMediums) {
		this.mongoMediums=mongoMediums;
	}
	
	@Override
	public void add(final MongoMedium mongoMedium) {
		if(mongoMedium!=null && !mongoMediums.contains(mongoMedium)) {
			mongoMediums.add(mongoMedium);
		}
	}

	@Override
	public Collection<MongoCategory> getCategoryDTOs() {
		return mongoCategories;
	}

	@Override
	public void setCategoryDTOs(final Collection<MongoCategory> mongoCategories) {
		this.mongoCategories=mongoCategories;
	}
	
	@Override
	public void add(final MongoCategory mongoCategory) {
		if(mongoCategory!=null && !mongoCategories.contains(mongoCategory)) {
			mongoCategories.add(mongoCategory);
		}
	}

	@Override
	public Collection<MongoAuthor> getAuthorDTOs() {
		return mongoAuthors;
	}

	@Override
	public void setAuthorDTOs(final Collection<MongoAuthor> mongoAuthors) {
		this.mongoAuthors=mongoAuthors;
	}
	
	@Override
	public void add(final MongoAuthor mongoAuthor) {
		if(mongoAuthor!=null && !mongoAuthors.contains(mongoAuthor)) {
			mongoAuthors.add(mongoAuthor);
		}
	}
	
	@Override
	public Collection<MongoCreator> getCreatorDTOs() {
		return mongoCreators;
	}

	@Override
	public void setCreatorDTOs(final Collection<MongoCreator> mongoCreators) {
		this.mongoCreators=mongoCreators;
	}
	
	@Override
	public void add(final MongoCreator mongoCreator) {
		if(mongoCreator!=null && !mongoCreators.contains(mongoCreator)) {
			mongoCreators.add(mongoCreator);
		}
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoArticle mongoArticle = (MongoArticle) obj;
		return new EqualsBuilder()
				.append(id,mongoArticle.getId())
				.append(title,mongoArticle.getTitle())
				.append(link,mongoArticle.getLink())
				.append(description,mongoArticle.getDescription())
				.append(publicationDate,mongoArticle.getPublicationDate())
				.append(read,mongoArticle.getRead())
				.append(archived,mongoArticle.getArchived())
				.append(favorite,mongoArticle.getFavorite())
                .isEquals()
                && CollectionsUtil.equals(mongoMediums,mongoArticle.getMediumDTOs())
                && CollectionsUtil.equals(mongoCategories,mongoArticle.getCategoryDTOs())
                && CollectionsUtil.equals(mongoAuthors,mongoArticle.getAuthorDTOs())
                && CollectionsUtil.equals(mongoCreators,mongoArticle.getCreatorDTOs());
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(99,5)
		       .append(id)
		       .append(title)
		       .append(link)
		       .append(description)
		       .append(publicationDate)
		       .append(read)
			   .append(archived)
			   .append(favorite)
			   .append(mongoMediums)
			   .append(mongoCategories)
			   .append(mongoAuthors)
			   .append(mongoCreators)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			    .append(id)
			    .append(title)
			    .append(link)
			    .append(description)
			    .append(publicationDate)
			    .append(read)
			    .append(archived)
			    .append(favorite)
			    .append(mongoMediums)
			    .append(mongoCategories)
			    .append(mongoAuthors)
			    .append(mongoCreators)
				.toString();
	}

}
