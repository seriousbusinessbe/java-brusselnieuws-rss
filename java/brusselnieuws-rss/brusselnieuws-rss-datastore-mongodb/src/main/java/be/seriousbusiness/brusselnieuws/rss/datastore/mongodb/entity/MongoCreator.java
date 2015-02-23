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
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CreatorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

/**
 * Spring-data {@link MongoCreator} entity.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
@Document(collection="creator")
public class MongoCreator implements CreatorDTO {
	@Id
	private BigInteger id;
	@Field("name")
	@Indexed(unique = true)
	private String name;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MongoCreator(){}
	
	private MongoCreator(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name;
		
		public MongoCreator build() throws IllegalArgumentException{
			return new MongoCreator(this);
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoCreator && 
				ObjectUtil.isNullOrEqual(id,((MongoCreator)obj).id) &&
				ObjectUtil.isNullOrEqual(name,((MongoCreator)obj).name);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id) * ObjectUtil.hashCode(name);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("name",name);
		return EntityUtil.stringBuilder("mongoCreator",fields);
	}

}
