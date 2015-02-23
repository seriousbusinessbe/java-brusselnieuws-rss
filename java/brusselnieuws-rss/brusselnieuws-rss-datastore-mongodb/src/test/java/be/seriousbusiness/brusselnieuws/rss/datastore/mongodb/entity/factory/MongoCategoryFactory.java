package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;

public class MongoCategoryFactory {
	
	/**
	 * Create a {@MongoCategory} with id and data set.
	 * @return
	 */
	public static final MongoCategory createMonoCategoryArtikel(){
		return new MongoCategory.Builder().id(BigInteger.valueOf(4972658l))
				.link("http://www.brusselnieuws.be/nl/media-type/artikel")
				.name("artikel").build();
	}
	
	/**
	 * Create a {@MongoCategory} with id and data set.
	 * @return
	 */
	public static final MongoCategory createMongoCategoryEconomie(){
		return new MongoCategory.Builder().id(BigInteger.valueOf(32654382277l))
				.link("http://www.brusselnieuws.be/nl/bn-section/economie")
				.name("Economie").build();
	}

}
