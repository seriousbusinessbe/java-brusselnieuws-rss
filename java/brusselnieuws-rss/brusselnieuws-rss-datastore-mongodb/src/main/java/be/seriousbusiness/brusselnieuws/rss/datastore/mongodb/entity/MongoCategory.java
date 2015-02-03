package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoCategory && 
				ObjectUtil.isNullOrEqual(id,((MongoCategory)obj).id) &&
				ObjectUtil.isNullOrEqual(name,((MongoCategory)obj).name) &&
				ObjectUtil.isNullOrEqual(link,((MongoCategory)obj).link);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id) * ObjectUtil.hashCode(name) * ObjectUtil.hashCode(link);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("name",name);
		fields.put("link",link);
		return EntityUtil.stringBuilder("mongoCategory", fields);
	}

}
