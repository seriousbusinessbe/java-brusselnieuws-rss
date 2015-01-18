package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractArticleDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.ArticleDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CategoryDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MongoArticleDAOTest extends AbstractArticleDAOTest {
	@Autowired
	private MongoArticleDAO mongoArticleDAO;
	@Autowired
	private MongoAuthorDAO mongoAuthorDAO;
	@Autowired
	private MongoCategoryDAO mongoCategoryDAO;
	@Autowired
	private MongoMediumDAO mongoMediumDAO;
	@Autowired
	private MongoMediumTypeDAO mongoMediumTypeDAO;

	@Override
	public ArticleDAO createDAO() {
		return mongoArticleDAO;
	}

	@Override
	protected AuthorDAO createAuthorDAO() {
		return mongoAuthorDAO;
	}

	@Override
	protected CategoryDAO createCategoryDAO() {
		return mongoCategoryDAO;
	}

	@Override
	protected MediumDAO createMediumDAO() {
		return mongoMediumDAO;
	}

	@Override
	protected MediumTypeDAO createMediumTypeDAO() {
		return mongoMediumTypeDAO;
	}

}
