package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;

public class MongoArticleFactory {
	
	/**
	 * Create a {@link MongoArticle} with id and data set.
	 * @return
	 */
	public static final MongoArticle createMongoArticleEbola(){
		final MongoArticle article=new MongoArticle();
		article.setId(BigInteger.valueOf(48323388554422110l));
		article.setArchived(true);
		final List<MongoAuthor> authors=new ArrayList<MongoAuthor>();
		authors.add(MongoAuthorFactory.createMongoAuthorBrusselDezeWeek());
		authors.add(MongoAuthorFactory.createMongoAuthorFMBrussel());
		article.setAuthorDTOs(authors);
		final List<MongoCategory> categories=new ArrayList<MongoCategory>();
		categories.add(MongoCategoryFactory.createMonoCategoryArtikel());
		categories.add(MongoCategoryFactory.createMongoCategoryEconomie());
		article.setCategoryDTOs(categories);
		article.setDescription("&lt;p&gt;In het militair hospitaal van Neder-Over-Heembeek zal geen vleugel ingericht worden in de strijd tegen ebola. Zo’n vleugel wordt te duur bevonden.&lt;/p&gt;© FM Brussel");
		article.setFavorite(false);
		article.setLink("http://www.brusselnieuws.be/nl/nieuws/geen-ebolavleugel-neder-over-heembeek");
		final List<MongoMedium> mediums=new ArrayList<MongoMedium>();
		mediums.add(MongoMediumFactory.createMongoMediumJPGImage());
		mediums.add(MongoMediumFactory.createMongoMediumPNGImage());
		article.setMediumDTOs(mediums);
		article.setPublicationDate(System.currentTimeMillis());
		article.setTitle("Geen ebolavleugel in Neder-Over-Heembeek");
		article.setRead(false);
		return article;
	}

}
