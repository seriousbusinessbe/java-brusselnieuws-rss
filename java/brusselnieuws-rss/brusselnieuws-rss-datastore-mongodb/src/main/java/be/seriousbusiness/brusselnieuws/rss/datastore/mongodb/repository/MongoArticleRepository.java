package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;

public interface MongoArticleRepository extends CrudRepository<MongoArticle,BigInteger> {
	
	Collection<MongoArticle> findByTitle(final String title);
	
	Collection<MongoArticle> findByRead(final Boolean read);
	
	Collection<MongoArticle> findByFavorite(final Boolean favorite);
	
	Collection<MongoArticle> findByArchived(final Boolean archived);
	
	Collection<MongoArticle> findByMongoCategories(final MongoCategory category);
	
	Collection<MongoArticle> findByMongoAuthors(final MongoAuthor author);
	
	Collection<MongoArticle> findByPublicationDateBetween(final Long from,final Long to);

}
