package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

/**
 * Spring-data {@link MongoArticle} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="article")
public class MongoArticle implements ArticleDTO<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor> {
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoArticle && 
				ObjectUtil.isNullOrEqual(title,((MongoArticle)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((MongoArticle)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((MongoArticle)obj).description) &&
				ObjectUtil.isNullOrEqual(publicationDate,((MongoArticle)obj).publicationDate) &&
				ObjectUtil.isNullOrEqual(read,((MongoArticle)obj).read) &&
				ObjectUtil.isNullOrEqual(archived,((MongoArticle)obj).archived) &&
				ObjectUtil.isNullOrEqual(favorite,((MongoArticle)obj).favorite) &&
				ObjectUtil.isNullOrEqual(mongoMediums,((MongoArticle)obj).mongoMediums) &&
				ObjectUtil.isNullOrEqual(mongoCategories,((MongoArticle)obj).mongoCategories) &&
				ObjectUtil.isNullOrEqual(mongoAuthors,((MongoArticle)obj).mongoAuthors);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id) * 
				ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(publicationDate) *
				ObjectUtil.hashCode(read) *
				ObjectUtil.hashCode(archived) *
				ObjectUtil.hashCode(favorite) *
				ObjectUtil.hashCode(mongoMediums) *
				ObjectUtil.hashCode(mongoCategories) *
				ObjectUtil.hashCode(mongoAuthors);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("title",title);
		fields.put("link",link);
		fields.put("description",description);
		fields.put("publicationDate",publicationDate);
		fields.put("read",read);
		fields.put("archived",archived);
		fields.put("favorite",favorite);
		fields.put("mediums",mongoMediums);
		fields.put("categories",mongoCategories);
		fields.put("authors",mongoAuthors);
		return EntityUtil.stringBuilder("mongoArticle", fields);
	}

}
