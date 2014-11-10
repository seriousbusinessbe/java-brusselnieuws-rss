package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;

public interface MongoCategoryRepository extends CrudRepository<MongoCategory,BigInteger> {
	
	Collection<MongoCategory> findByName(final String name);
	
	MongoCategory findByLink(final String link);

}
