package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;

public class MongoCategoryFactory {
	
	/**
	 * Create a {@MongoCategory} with id and data set.
	 * @return
	 */
	public static final MongoCategory createMonoCategoryArtikel(){
		final MongoCategory category=new MongoCategory();
		category.setId(BigInteger.valueOf(4972658l));
		category.setLink("http://www.brusselnieuws.be/nl/media-type/artikel");
		category.setName("artikel");
		return category;
	}
	
	/**
	 * Create a {@MongoCategory} with id and data set.
	 * @return
	 */
	public static final MongoCategory createMongoCategoryEconomie(){
		final MongoCategory category=new MongoCategory();
		category.setId(BigInteger.valueOf(32654382277l));
		category.setLink("http://www.brusselnieuws.be/nl/bn-section/economie");
		category.setName("Economie");
		return category;
	}

}
