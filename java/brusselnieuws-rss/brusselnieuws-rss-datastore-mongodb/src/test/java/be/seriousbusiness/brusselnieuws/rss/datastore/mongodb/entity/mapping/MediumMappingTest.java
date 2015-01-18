package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractMediumDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoMediumFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MediumMappingTest extends AbstractMediumDTOImplMappingTest<MongoMedium> {
	@Autowired
	private Mapper mapper;

	@Override
	protected MongoMedium createDTOA() {
		return MongoMediumFactory.createMongoMediumJPGImage();
	}

	@Override
	protected MediumDTOImpl mapToDTOB(final MongoMedium mongoMedium) {
		return mapper.map(mongoMedium, MediumDTOImpl.class);
	}

	@Override
	protected MongoMedium mapToDTOA(final MediumDTOImpl mediumDTOImpl) {
		return mapper.map(mediumDTOImpl, MongoMedium.class);
	}

}
