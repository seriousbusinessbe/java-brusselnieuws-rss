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

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * Spring-data {@link MongoMediumType} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="medium_type")
public class MongoMediumType implements MediumTypeDTO {
	@Id
	private BigInteger id;
	@Field("type")
	@Indexed(unique = true)
	private String type;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoMediumType(){}
	
	private MongoMediumType(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setType(builder.type);
	}
	
	public static class Builder{
		private BigInteger id;
		private String type;
		
		public MongoMediumType build() throws IllegalArgumentException{
			return new MongoMediumType(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder type(final String type){
			this.type=type;
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
	public String getType() {
		return type;
	}

	@Override
	public void setType(final String type) {
		this.type=type;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoMediumType mongoMediumType = (MongoMediumType) obj;
		return new EqualsBuilder().append(id,mongoMediumType.getId()).append(type,mongoMediumType.getType()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(71,73).append(id).append(type).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id",id).append("type",type).toString();
	}

}
