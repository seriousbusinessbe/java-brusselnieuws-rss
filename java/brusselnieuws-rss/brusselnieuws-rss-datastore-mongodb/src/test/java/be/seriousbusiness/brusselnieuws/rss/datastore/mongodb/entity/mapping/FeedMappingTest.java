package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractFeedDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoFeed;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoFeedFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-dozer-config.xml")
public class FeedMappingTest extends AbstractFeedDTOImplMappingTest<MongoFeed> {
	@Autowired
	private Mapper mapper;

	@Override
	protected MongoFeed createDTOA() {
		return MongoFeedFactory.createMongoFeedSamenleving();
	}

	@Override
	protected FeedDTOImpl mapToDTOB(final MongoFeed mongoFeed) {
		return mapper.map(mongoFeed,FeedDTOImpl.class);
	}

	@Override
	protected MongoFeed mapToDTOA(final FeedDTOImpl feedDTOImpl) {
		return mapper.map(feedDTOImpl,MongoFeed.class);
	}

}
