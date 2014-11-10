package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoFeed;

public class MongoFeedFactory {
	
	/**
	 * Create a {@link MongoFeed} with id and data set.
	 * @return
	 */
	public static final MongoFeed createMongoFeedSamenleving(){
		final MongoFeed feed=new MongoFeed();
		feed.setId(BigInteger.valueOf(44524253262634l));
		feed.setDescription("");
		feed.setLink("http://www.brusselnieuws.be/nl/rubriek/4795/feed");
		feed.setTitle("BrusselNieuws RSS - Samenleving");
		final List<MongoArticle> articles=new ArrayList<MongoArticle>();
		articles.add(MongoArticleFactory.createMongoArticleEbola());
		feed.setArticleDTOs(articles);
		return feed;
	}

}
