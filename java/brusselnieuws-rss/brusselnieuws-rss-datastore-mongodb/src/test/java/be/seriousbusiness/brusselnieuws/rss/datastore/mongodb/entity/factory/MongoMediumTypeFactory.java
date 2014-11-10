package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;

public class MongoMediumTypeFactory {
	
	/**
	 * Create a {@link MongoMediumType} with id and data set.
	 * @return
	 */
	public static final MongoMediumType createMongoMediumTypeJPG() {
		final MongoMediumType mediumType=new MongoMediumType();
		mediumType.setId(BigInteger.valueOf(8739l));
		mediumType.setType("image/jpg");
		return mediumType;
	}
	
	/**
	 * Create a {@link MongoMediumType} with id and data set.
	 * @return
	 */
	public static final MongoMediumType createMongoMediumTypePNG() {
		final MongoMediumType mediumType=new MongoMediumType();
		mediumType.setId(BigInteger.valueOf(523853465433l));
		mediumType.setType("image/png");
		return mediumType;
	}

}
