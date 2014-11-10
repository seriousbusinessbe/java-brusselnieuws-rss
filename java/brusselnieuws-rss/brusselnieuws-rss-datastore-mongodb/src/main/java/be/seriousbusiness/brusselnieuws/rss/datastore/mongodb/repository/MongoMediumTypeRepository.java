package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;

public interface MongoMediumTypeRepository extends CrudRepository<MongoMediumType,BigInteger> {
	
	MongoMediumType findByType(final String type);

}
