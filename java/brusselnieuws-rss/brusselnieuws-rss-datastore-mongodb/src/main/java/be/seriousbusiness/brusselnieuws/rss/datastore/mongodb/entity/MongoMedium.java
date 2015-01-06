package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

@Document(collection="medium")
public class MongoMedium implements MediumDTO<MongoMediumType> {
	@Id
	private String link;
	@DBRef
	private MongoMediumType mongoMediumType;
	@Field("size")
	private Long size;

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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoMedium && 
				ObjectUtil.isNullOrEqual(link,((MongoMedium)obj).link) &&
				ObjectUtil.isNullOrEqual(size,((MongoMedium)obj).size) &&
				ObjectUtil.isNullOrEqual(mongoMediumType,((MongoMedium)obj).mongoMediumType);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(size) *
				ObjectUtil.hashCode(mongoMediumType);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("link",link);
		fields.put("mediumType",mongoMediumType);
		fields.put("size",size);
		return EntityUtil.stringBuilder("mongoMedium", fields);
	}

}
