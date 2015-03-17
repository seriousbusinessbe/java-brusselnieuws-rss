package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

/**
 * Spring-data {@link MongoMedium} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="medium")
public class MongoMedium implements MediumDTO<MongoMediumType> {
	@Id
	private String link;
	@DBRef
	private MongoMediumType mongoMediumType;
	@Field("size")
	private Long size;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoMedium(){}
	
	private MongoMedium(final Builder builder) throws IllegalArgumentException{
		setLink(builder.link);
		setSize(builder.size);
		setMediumTypeDTO(builder.mongoMediumType);
	}
	
	public static class Builder{
		private String link;
		private MongoMediumType mongoMediumType;
		private Long size;
		
		public MongoMedium build() throws IllegalArgumentException{
			return new MongoMedium(this);
		}
		
		public Builder size(final Long size) {
			this.size=size;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
			return this;
		}
		
		public Builder mediumTypeDTO(final MongoMediumType mongoMediumType) {
			this.mongoMediumType=mongoMediumType;
			return this;
		}
		
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
	public MongoMediumType getMediumTypeDTO() {
		return mongoMediumType;
	}

	@Override
	public void setMediumTypeDTO(final MongoMediumType mongoMediumType) {
		this.mongoMediumType=mongoMediumType;
	}

	@Override
	public Long getSize() {
		return size;
	}

	@Override
	public void setSize(final Long size) {
		this.size=size;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MongoMedium mongoMedium = (MongoMedium) obj;
		return new EqualsBuilder().append(link,mongoMedium.getLink()).append(mongoMediumType,mongoMedium.getMediumTypeDTO()).append(size,mongoMedium.getSize()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(37,43).append(link).append(mongoMediumType).append(size).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id",link).append("mongoMediumType",mongoMediumType).append("size",size).toString();
	}

}
