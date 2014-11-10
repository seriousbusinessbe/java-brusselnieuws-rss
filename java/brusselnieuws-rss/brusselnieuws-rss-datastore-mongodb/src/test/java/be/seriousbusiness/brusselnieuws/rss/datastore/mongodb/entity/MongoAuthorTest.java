package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractAuthorDTOTest;

public class MongoAuthorTest extends AbstractAuthorDTOTest<MongoAuthor> {

	public MongoAuthorTest() {
		super(BigInteger.valueOf(97362l),"Steven Van Garsse");
	}

	@Override
	public MongoAuthor create() {
		return new MongoAuthor();
	}

}
