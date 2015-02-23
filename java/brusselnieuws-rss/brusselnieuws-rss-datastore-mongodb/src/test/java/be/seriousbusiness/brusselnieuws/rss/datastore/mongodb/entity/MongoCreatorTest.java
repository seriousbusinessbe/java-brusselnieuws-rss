package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCreatorDTOTest;

public class MongoCreatorTest extends AbstractCreatorDTOTest<MongoCreator> {
	
	public MongoCreatorTest() {
		super(BigInteger.valueOf(97362l),"FM Brussel");
	}

	@Override
	public MongoCreator create() {
		return new MongoCreator.Builder().build();
	}

}
