package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;

/**
 * Spring-data {@link MongoCategory} repository.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
public interface MongoCategoryRepository extends CrudRepository<MongoCategory,BigInteger> {
	
	Collection<MongoCategory> findByName(final String name);
	
	MongoCategory findByLink(final String link);

}
