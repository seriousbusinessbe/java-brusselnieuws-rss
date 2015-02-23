package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;

public class MongoMediumTypeFactory {
	
	/**
	 * Create a {@link MongoMediumType} with id and data set.
	 * @return
	 */
	public static final MongoMediumType createMongoMediumTypeJPG() {
		return new MongoMediumType.Builder().id(BigInteger.valueOf(8739l)).type("image/jpg").build();
	}
	
	/**
	 * Create a {@link MongoMediumType} with id and data set.
	 * @return
	 */
	public static final MongoMediumType createMongoMediumTypePNG() {
		return new MongoMediumType.Builder().id(BigInteger.valueOf(523853465433l)).type("image/png").build();
	}

}
