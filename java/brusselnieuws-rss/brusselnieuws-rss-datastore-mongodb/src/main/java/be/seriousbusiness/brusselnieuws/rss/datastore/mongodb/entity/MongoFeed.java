package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * Spring-data {@link MongoFeed} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="feed")
public class MongoFeed implements FeedDTO<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor,MongoCreator,MongoArticle> {
	@Id
	private BigInteger id;
	@Field("title")
	private String title;
	@Field("link")
	private String link;
	@Field("description")
	private String description;
	@DBRef
	private Collection<MongoArticle> mongoArticles;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoFeed(){}
	
	private MongoFeed(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setTitle(builder.title);
		setLink(builder.link);
		setDescription(builder.description);
		setArticleDTOs(builder.mongoArticles);
	}
	
	public static class Builder{
		private BigInteger id;
		private String title,link,description;
		private Collection<MongoArticle> mongoArticles=new ArrayList<MongoArticle>();
		
		public MongoFeed build() throws IllegalArgumentException{
			return new MongoFeed(this);
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
		
		public Builder articleDTOs(final Collection<MongoArticle> mongoArticles) {
			this.mongoArticles=mongoArticles;
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
	public Collection<MongoArticle> getArticleDTOs() {
		return mongoArticles;
	}

	@Override
	public void setArticleDTOs(final Collection<MongoArticle> mongoArticles) {
		this.mongoArticles=mongoArticles;
	}
	
	@Override
	public void add(final MongoArticle mongoArticle) {
		if(mongoArticle!=null && !mongoArticles.contains(mongoArticle)) {
			mongoArticles.add(mongoArticle);
		}
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoFeed mongoFeed = (MongoFeed) obj;
		return new EqualsBuilder()
				.append(id,mongoFeed.getId())
				.append(title,mongoFeed.getTitle())
				.append(link,mongoFeed.getLink())
				.append(description,mongoFeed.getDescription())
                .isEquals()
                && CollectionUtils.isEqualCollection(mongoArticles,mongoFeed.getArticleDTOs());
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(13,37)
		       .append(id)
		       .append(title)
		       .append(link)
		       .append(description)
		       .append(mongoArticles)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append(id)
				.append(title)
				.append(link)
				.append(description)
				.append(mongoArticles)
				.toString();
	}

}
