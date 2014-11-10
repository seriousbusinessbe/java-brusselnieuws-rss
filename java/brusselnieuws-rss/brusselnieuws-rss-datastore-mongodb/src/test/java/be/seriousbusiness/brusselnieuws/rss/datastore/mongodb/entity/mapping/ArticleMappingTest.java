package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.mapping;

import org.dozer.Mapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping.AbstractArticleDTOImplMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory.MongoArticleFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-dozer-config.xml")
public class ArticleMappingTest extends AbstractArticleDTOImplMappingTest<MongoArticle> {
	@Autowired
	private Mapper mapper;

	@Override
	protected MongoArticle createDTOA() {
		return MongoArticleFactory.createMongoArticleEbola();
	}

	@Override
	protected ArticleDTOImpl mapToDTOB(final MongoArticle mongoArticle) {
		return mapper.map(mongoArticle, ArticleDTOImpl.class);
	}

	@Override
	protected MongoArticle mapToDTOA(final ArticleDTOImpl articleDTOImpl) {
		return mapper.map(articleDTOImpl, MongoArticle.class);
	}

}
