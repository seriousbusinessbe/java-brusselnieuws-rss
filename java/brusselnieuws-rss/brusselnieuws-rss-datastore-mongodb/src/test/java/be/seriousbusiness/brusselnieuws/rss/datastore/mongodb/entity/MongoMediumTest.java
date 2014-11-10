package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumDTOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.stub.MediumTypeStub;

public class MongoMediumTest extends AbstractMediumDTOTest<MongoMediumType,MongoMedium> {

	public MongoMediumTest() {
		super("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/actiris3.jpg?itok=o113Pncd",
				new MediumTypeStub(),39271l);
	}

	@Override
	public MongoMedium create() {
		return new MongoMedium();
	}

}
