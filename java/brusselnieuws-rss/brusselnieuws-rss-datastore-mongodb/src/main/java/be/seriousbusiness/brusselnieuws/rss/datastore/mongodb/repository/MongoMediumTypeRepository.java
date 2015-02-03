package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;

/**
 * Spring-data {@link MongoMediumType} repository.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
public interface MongoMediumTypeRepository extends CrudRepository<MongoMediumType,BigInteger> {
	
	MongoMediumType findByType(final String type);

}
