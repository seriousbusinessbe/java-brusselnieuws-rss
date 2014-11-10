package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;

public interface MongoAuthorRepository extends CrudRepository<MongoAuthor,BigInteger> {
	
	Collection<MongoAuthor> findByName(final String name);

}
