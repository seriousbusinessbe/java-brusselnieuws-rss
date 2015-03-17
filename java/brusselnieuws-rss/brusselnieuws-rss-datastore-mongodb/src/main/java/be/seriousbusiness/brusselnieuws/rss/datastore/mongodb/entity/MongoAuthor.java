package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * Spring-data {@link MongoAuthor} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="author")
public class MongoAuthor implements AuthorDTO {
	@Id
	private BigInteger id;
	@Field("name")
	@Indexed(unique = true)
	private String name;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoAuthor(){}
	
	private MongoAuthor(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name;
		
		public MongoAuthor build() throws IllegalArgumentException{
			return new MongoAuthor(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder name(final String name){
			this.name=name;
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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoAuthor mongoAuthor = (MongoAuthor) obj;
		return new EqualsBuilder().append(id,mongoAuthor.getId()).append(name,mongoAuthor.getName()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(37,43).append(id).append(name).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(name).toString();
	}

}
