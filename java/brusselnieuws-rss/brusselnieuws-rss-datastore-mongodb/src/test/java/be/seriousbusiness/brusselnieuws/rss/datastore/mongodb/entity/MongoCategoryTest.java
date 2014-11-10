package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCategoryDTOTest;

public class MongoCategoryTest extends AbstractCategoryDTOTest<MongoCategory> {

	public MongoCategoryTest() {
		super(BigInteger.valueOf(49824l),"http://www.brusselnieuws.be/nl/bn-section/stad","Stad");
	}

	@Override
	public MongoCategory create() {
		return new MongoCategory();
	}

}
