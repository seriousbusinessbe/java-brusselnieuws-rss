package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;

/**
 * Spring-data {@link MongoArticle} repository.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @see Spring-data mongodb reference: <a href="http://docs.spring.io/spring-data/mongodb/docs/current/reference/">http://docs.spring.io/spring-data/mongodb/docs/current/reference/</a>
 */
public interface MongoArticleRepository extends CrudRepository<MongoArticle,BigInteger> {
	
	Collection<MongoArticle> findByTitle(final String title);
	
	Collection<MongoArticle> findByRead(final Boolean read);
	
	Collection<MongoArticle> findByFavorite(final Boolean favorite);
	
	Collection<MongoArticle> findByArchived(final Boolean archived);
	
	Collection<MongoArticle> findByMongoCategories(final MongoCategory category);
	
	Collection<MongoArticle> findByMongoAuthors(final MongoAuthor author);
	
	Collection<MongoArticle> findByMongoCreators(final MongoCreator creator);
	
	Collection<MongoArticle> findByPublicationDateBetween(final Long from,final Long to);
	
	/**
	 * Finds a {@link MongoArticle} by title and publication date.
	 * @param title the title to look for
	 * @param publicationDate the publication date to look for
	 * @return the found {@link MongoArticle} <code>null</code> when not found
	 */
	MongoArticle findByTitleAndPublicationDate(final String title,final Long publicationDate);
	
	/**
	 * Finds the first {@link MongoArticle} by title.</br>
	 * @param title the title to look for
	 * @return the found {@link MongoArticle} <code>null</code> when not found
	 */
	MongoArticle findFirstByTitle(final String title);

}
