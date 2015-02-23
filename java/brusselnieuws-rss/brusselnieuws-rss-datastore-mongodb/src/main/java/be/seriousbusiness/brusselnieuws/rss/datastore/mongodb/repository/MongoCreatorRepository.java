package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;

/**
 * Spring-data {@link MongoCreator} repository.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
public interface MongoCreatorRepository extends CrudRepository<MongoCreator,BigInteger> {
	
	/**
	 * Finds all {@link MongoCreator}(s) by name.
	 * @param name the name to look for
	 * @return a collection of found {@link MongoCreator}(s) <code>null</code> when none found
	 */
	Collection<MongoCreator> findByName(final String name);
	
	/**
	 * Finds the first {@link MongoCreator} by name.
	 * @param name the name to look for
	 * @return the found {@link MongoCreator} <code>null</code> when not found
	 */
	MongoCreator findFirstByName(final String name);

}
