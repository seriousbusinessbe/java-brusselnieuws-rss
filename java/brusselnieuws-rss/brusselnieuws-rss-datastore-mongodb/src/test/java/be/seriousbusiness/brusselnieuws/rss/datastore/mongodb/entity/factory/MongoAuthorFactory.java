package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;

public class MongoAuthorFactory {
	
	/**
	 * Create a {@link MongoAuthor} with id and data set.
	 * @return
	 */
	public static final MongoAuthor createMongoAuthorBrusselDezeWeek(){
		final MongoAuthor author=new MongoAuthor();
		author.setId(BigInteger.valueOf(632893557l));
		author.setName("Brussel Deze Week");
		return author;
	}
	
	/**
	 * Create a {@link MongoAuthor} with id and data set.
	 * @return
	 */
	public static final MongoAuthor createMongoAuthorFMBrussel(){
		final MongoAuthor author=new MongoAuthor();
		author.setId(BigInteger.valueOf(432167534l));
		author.setName("FM Brussel");
		return author;
	}

}
