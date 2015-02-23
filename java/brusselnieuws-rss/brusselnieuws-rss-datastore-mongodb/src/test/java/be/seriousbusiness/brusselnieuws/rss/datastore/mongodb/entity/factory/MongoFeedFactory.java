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
		final List<MongoArticle> mongoArticles=new ArrayList<MongoArticle>();
		mongoArticles.add(MongoArticleFactory.createMongoArticleEbola());
		return new MongoFeed.Builder().id(BigInteger.valueOf(44524253262634l))
				.description("")
				.link("http://www.brusselnieuws.be/nl/rubriek/4795/feed")
				.title("BrusselNieuws RSS - Samenleving")
				.articleDTOs(mongoArticles).build();
	}

}
