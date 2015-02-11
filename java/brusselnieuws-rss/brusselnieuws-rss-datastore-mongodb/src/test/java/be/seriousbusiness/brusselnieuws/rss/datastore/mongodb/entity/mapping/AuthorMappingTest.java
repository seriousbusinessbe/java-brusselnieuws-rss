package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractAuthorDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoAuthorFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class AuthorMappingTest extends AbstractAuthorDTOImplMappingTest<MongoAuthor> {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;

	@Override
	protected MongoAuthor createDTOA() {
		return MongoAuthorFactory.createMongoAuthorBrusselDezeWeek();
	}

	@Override
	protected AuthorDTOImpl mapToDTOB(final MongoAuthor mongoAuthor) {
		return mapper.map(mongoAuthor, AuthorDTOImpl.class);
	}

	@Override
	protected MongoAuthor mapToDTOA(final AuthorDTOImpl authorDTOImpl) {
		return mapper.map(authorDTOImpl, MongoAuthor.class);
	}

}
