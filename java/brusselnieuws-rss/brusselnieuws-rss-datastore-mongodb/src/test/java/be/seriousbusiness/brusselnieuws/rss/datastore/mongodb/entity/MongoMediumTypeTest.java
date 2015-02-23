package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumTypeDTOTest;

public class MongoMediumTypeTest extends AbstractMediumTypeDTOTest<MongoMediumType> {

	public MongoMediumTypeTest() {
		super(BigInteger.valueOf(123456789l),"image/png");
	}

	@Override
	public MongoMediumType create() {
		return new MongoMediumType.Builder().build();
	}

}
