package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity;

import java.math.BigInteger;
import java.util.ArrayList;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractFeedDTOTest;

public class MongoFeedTest extends AbstractFeedDTOTest<MongoMediumType,MongoMedium,MongoCategory,MongoAuthor,MongoArticle,MongoFeed> {

	public MongoFeedTest() {
		super(BigInteger.valueOf(689321l),
				new ArrayList<MongoArticle>(),"",
				"http://www.brusselnieuws.be/nl/hoofdpunten/feed",
				"BrusselNieuws RSS - Hoofdpunten");
	}

	@Override
	public MongoFeed create() {
		return new MongoFeed();
	}

}
