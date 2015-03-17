package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * Spring-data {@link MongoCategory} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="category")
public class MongoCategory implements CategoryDTO {
	@Id
	private BigInteger id;
	@Field("name")
	private String name;
	@Field("link")
	private String link;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoCategory(){}
	
	private MongoCategory(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
		setLink(builder.link);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name,link;
		
		public MongoCategory build() throws IllegalArgumentException{
			return new MongoCategory(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder name(final String name){
			this.name=name;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name=name;
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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoCategory mongoCategory = (MongoCategory) obj;
		return new EqualsBuilder().append(id,mongoCategory.getId()).append(name,mongoCategory.getName()).append(link,mongoCategory.getLink()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(27,19).append(id).append(name).append(link).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(name).append(link).toString();
	}

}
