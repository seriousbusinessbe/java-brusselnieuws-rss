package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.util.HashSet;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractFeedDTOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;

public class FeedDTOImplTest extends AbstractFeedDTOTest<FeedDTOImpl> {

	public FeedDTOImplTest() {
		super(111222333l,new HashSet<ArticleDTO>(),"","http://www.brusselnieuws.be/nl/hoofdpunten/feed","BrusselNieuws RSS - Hoofdpunten");
	}

	@Override
	public FeedDTOImpl create() {
		return new FeedDTOImpl();
	}

}
