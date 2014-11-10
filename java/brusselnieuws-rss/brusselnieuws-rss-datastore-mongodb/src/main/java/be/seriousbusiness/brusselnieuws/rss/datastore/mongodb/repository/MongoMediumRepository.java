package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;

public interface MongoMediumRepository extends CrudRepository<MongoMedium,BigInteger> {
	
	MongoMedium findByLink(final String link);

}
