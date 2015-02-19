package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;

/**
 * Spring-data {@link MongoAuthor} repository.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
public interface MongoAuthorRepository extends CrudRepository<MongoAuthor,BigInteger> {
	
	/**
	 * Finds all {@link MongoAuthor}(s) by name.
	 * @param name the name to look for
	 * @return a collection of found {@link MongoAuthor}(s) <code>null</code> when none found
	 */
	Collection<MongoAuthor> findByName(final String name);
	
	/**
	 * Finds the first {@link MongoAuthor} by name.
	 * @param name the name to look for
	 * @return the found {@link MongoAuthor} <code>null</code> when not found
	 */
	MongoAuthor findFirstByName(final String name);

}
