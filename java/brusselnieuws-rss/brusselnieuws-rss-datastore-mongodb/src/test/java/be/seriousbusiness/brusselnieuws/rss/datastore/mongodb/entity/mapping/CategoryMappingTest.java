package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractCategoryDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoCategoryFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class CategoryMappingTest extends AbstractCategoryDTOImplMappingTest<MongoCategory> {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;

	@Override
	protected MongoCategory createDTOA() {
		return MongoCategoryFactory.createMonoCategoryArtikel();
	}

	@Override
	protected CategoryDTOImpl mapToDTOB(final MongoCategory mongoCategory) {
		return mapper.map(mongoCategory, CategoryDTOImpl.class);
	}

	@Override
	protected MongoCategory mapToDTOA(final CategoryDTOImpl categoryDTOImpl) {
		return mapper.map(categoryDTOImpl, MongoCategory.class);
	}

}
