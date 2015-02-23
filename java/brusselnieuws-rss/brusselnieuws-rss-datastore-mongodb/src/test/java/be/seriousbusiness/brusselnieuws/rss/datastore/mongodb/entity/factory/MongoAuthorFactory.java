package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;

public class MongoAuthorFactory {
	
	/**
	 * Create a {@link MongoAuthor} with id and data set.
	 * @return
	 */
	public static final MongoAuthor createMongoAuthorBrusselDezeWeek(){
		return new MongoAuthor.Builder().id(BigInteger.valueOf(632893557l)).name("Brussel Deze Week").build();
	}
	
	/**
	 * Create a {@link MongoAuthor} with id and data set.
	 * @return
	 */
	public static final MongoAuthor createMongoAuthorFMBrussel(){
		return new MongoAuthor.Builder().id(BigInteger.valueOf(432167534l)).name("FM Brussel").build();
	}

}
