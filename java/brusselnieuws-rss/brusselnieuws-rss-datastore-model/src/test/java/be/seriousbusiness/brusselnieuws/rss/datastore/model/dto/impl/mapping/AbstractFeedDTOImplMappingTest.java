package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.FeedDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.FeedDTOUtil;

public abstract class AbstractFeedDTOImplMappingTest<A extends FeedDTO<?,?,?,?,?>> extends AbstractMappingTest<FeedDTO<?,?,?,?,?>,A,FeedDTOImpl> {

	@Override
	protected FeedDTOImpl createDTOB() {
		return FeedDTOImplFactory.createPolitiek();
	}

	@Override
	protected void assertEquals(final A dtoA,final FeedDTOImpl dtoB) {
		FeedDTOUtil.assertEquals(dtoA, dtoB);
	}

}
