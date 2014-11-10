package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoFeed;

public interface MongoFeedRepository extends CrudRepository<MongoFeed,BigInteger> {
	
	MongoFeed findByLink(final String link);

}
