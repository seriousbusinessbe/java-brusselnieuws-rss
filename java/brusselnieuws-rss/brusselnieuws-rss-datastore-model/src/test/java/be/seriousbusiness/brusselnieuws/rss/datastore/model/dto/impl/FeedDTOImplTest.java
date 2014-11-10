package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractFeedDTOTest;

public class FeedDTOImplTest extends AbstractFeedDTOTest<MediumTypeDTOImpl,
														MediumDTOImpl,
														CategoryDTOImpl,
														AuthorDTOImpl,
														ArticleDTOImpl,
														FeedDTOImpl> {

	public FeedDTOImplTest() {
		super(BigInteger.valueOf(111222333l),
				new ArrayList<ArticleDTOImpl>(),
				"",
				"http://www.brusselnieuws.be/nl/hoofdpunten/feed",
				"BrusselNieuws RSS - Hoofdpunten");
	}

	@Override
	public FeedDTOImpl create() {
		return new FeedDTOImpl();
	}

}
