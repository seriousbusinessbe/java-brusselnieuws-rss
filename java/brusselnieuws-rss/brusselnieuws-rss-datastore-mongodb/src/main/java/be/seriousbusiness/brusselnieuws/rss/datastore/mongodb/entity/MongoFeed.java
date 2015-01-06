package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.util.EntityUtil;

@Document(collection="feed")
public class MongoFeed implements FeedDTO<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor,MongoArticle> {
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MongoFeed && 
				ObjectUtil.isNullOrEqual(id,((MongoFeed)obj).id) &&
				ObjectUtil.isNullOrEqual(title,((MongoFeed)obj).title) &&
				ObjectUtil.isNullOrEqual(link,((MongoFeed)obj).link) &&
				ObjectUtil.isNullOrEqual(description,((MongoFeed)obj).description) &&
				ObjectUtil.isNullOrEqual(mongoArticles,((MongoFeed)obj).mongoArticles);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id) * 
				ObjectUtil.hashCode(title) * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(description) *
				ObjectUtil.hashCode(mongoArticles);

	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("title",title);
		fields.put("link",link);
		fields.put("description",description);
		fields.put("articles",mongoArticles);
		return EntityUtil.stringBuilder("mongoFeed", fields);
	}

}
