package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;

public class MongoArticleFactory {
	
	/**
	 * Create a {@link MongoArticle} with id and data set.
	 * @return
	 */
	public static final MongoArticle createMongoArticleEbola(){
		final List<MongoAuthor> mongoAuthors=new ArrayList<MongoAuthor>();
		mongoAuthors.add(MongoAuthorFactory.createMongoAuthorBrusselDezeWeek());
		mongoAuthors.add(MongoAuthorFactory.createMongoAuthorFMBrussel());
		final List<MongoCategory> mongoCategories=new ArrayList<MongoCategory>();
		mongoCategories.add(MongoCategoryFactory.createMonoCategoryArtikel());
		mongoCategories.add(MongoCategoryFactory.createMongoCategoryEconomie());
		final List<MongoMedium> mongoMediums=new ArrayList<MongoMedium>();
		mongoMediums.add(MongoMediumFactory.createMongoMediumJPGImage());
		mongoMediums.add(MongoMediumFactory.createMongoMediumPNGImage());
		final List<MongoCreator> mongoCreators=new ArrayList<MongoCreator>();
		mongoCreators.add(MongoCreatorFactory.createFMBrussel());
		mongoCreators.add(MongoCreatorFactory.createBrusselNieuwsBe());
		return new MongoArticle.Builder().id(BigInteger.valueOf(48323388554422110l))
				.archived(true)
				.authorDTOs(mongoAuthors)
				.categoryDTOs(mongoCategories)
				.creatorDTOs(mongoCreators)
				.description("&lt;p&gt;In het militair hospitaal van Neder-Over-Heembeek zal geen vleugel ingericht worden in de strijd tegen ebola. Zo’n vleugel wordt te duur bevonden.&lt;/p&gt;© FM Brussel")
				.favorite(false)
				.link("http://www.brusselnieuws.be/nl/nieuws/geen-ebolavleugel-neder-over-heembeek")
				.mediumDTOs(mongoMediums)
				.publicationDate(System.currentTimeMillis())
				.title("Geen ebolavleugel in Neder-Over-Heembeek")
				.read(false).build();
	}

}
