package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractMediumTypeDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoMediumTypeFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MediumTypeMappingTest extends AbstractMediumTypeDTOImplMappingTest<MongoMediumType> {
	@Autowired
	private Mapper mapper;

	@Override
	protected MongoMediumType createDTOA() {
		return MongoMediumTypeFactory.createMongoMediumTypeJPG();
	}

	@Override
	protected MediumTypeDTOImpl mapToDTOB(final MongoMediumType mongoMediumType) {
		return mapper.map(mongoMediumType,MediumTypeDTOImpl.class);
	}

	@Override
	protected MongoMediumType mapToDTOA(final MediumTypeDTOImpl mediumTypeDTOImpl) {
		return mapper.map(mediumTypeDTOImpl,MongoMediumType.class);
	}

}
