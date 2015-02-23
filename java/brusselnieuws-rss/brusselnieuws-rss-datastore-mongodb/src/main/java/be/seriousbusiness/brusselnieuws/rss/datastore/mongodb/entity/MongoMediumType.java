package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoMediumType && 
				ObjectUtil.isNullOrEqual(id,((MongoMediumType)obj).id) &&
				ObjectUtil.isNullOrEqual(type,((MongoMediumType)obj).type);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id) * ObjectUtil.hashCode(type);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("type",type);
		return EntityUtil.stringBuilder("mongoMediumType", fields);
	}

}
