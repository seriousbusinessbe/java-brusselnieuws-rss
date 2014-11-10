package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.stub;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;

public class MediumTypeStub extends MongoMediumType {

	@Override
	public BigInteger getId() {
		return BigInteger.valueOf(3478912l);
	}

	@Override
	public void setId(final BigInteger id) {}

	@Override
	public String getType() {
		return "image/jpeg";
	}

	@Override
	public void setType(final String type) {}

}
