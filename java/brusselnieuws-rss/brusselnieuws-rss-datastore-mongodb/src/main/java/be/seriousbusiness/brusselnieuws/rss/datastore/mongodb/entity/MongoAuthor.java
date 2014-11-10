package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

@Document(collection="author")
public class MongoAuthor implements AuthorDTO {
	@Id
	private BigInteger id;
	@Field("name")
	private String name;

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
		return obj!=null && obj instanceof MongoAuthor && 
				ObjectUtil.isNullOrEqual(id,((MongoAuthor)obj).id) &&
				ObjectUtil.isNullOrEqual(name,((MongoAuthor)obj).name);
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
		return EntityUtil.stringBuilder("mongoAuthor", fields);
	}

}
