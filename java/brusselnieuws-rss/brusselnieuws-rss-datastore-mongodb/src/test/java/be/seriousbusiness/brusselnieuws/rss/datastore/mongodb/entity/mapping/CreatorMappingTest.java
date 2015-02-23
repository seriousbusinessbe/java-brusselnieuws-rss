package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractCreatorDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoCreatorFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class CreatorMappingTest extends AbstractCreatorDTOImplMappingTest<MongoCreator> {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;

	@Override
	protected MongoCreator createDTOA() {
		return MongoCreatorFactory.createTVBrussel();
	}

	@Override
	protected CreatorDTOImpl mapToDTOB(final MongoCreator mongoCreator) {
		return mapper.map(mongoCreator, CreatorDTOImpl.class);
	}

	@Override
	protected MongoCreator mapToDTOA(final CreatorDTOImpl creatorDTOImpl) {
		return mapper.map(creatorDTOImpl, MongoCreator.class);
	}

}
