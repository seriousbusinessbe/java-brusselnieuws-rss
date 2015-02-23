package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractFeedDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.ArticleDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CategoryDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CreatorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.FeedDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MongoFeedDAOTest extends AbstractFeedDAOTest {
	@Autowired
	private MongoFeedDAO mongoFeedDAO;
	@Autowired
	private MongoArticleDAO mongoArticleDAO;
	@Autowired
	private MongoAuthorDAO mongoAuthorDAO;
	@Autowired
	private MongoCategoryDAO mongoCateogoryDAO;
	@Autowired
	private MongoMediumTypeDAO monoMediumTypeDAO;
	@Autowired
	private MongoMediumDAO mongoMediumDAO;
	@Autowired
	private MongoCreatorDAO mongoCreatorDAO;

	@Override
	public FeedDAO createDAO() {
		return mongoFeedDAO;
	}

	@Override
	protected ArticleDAO createArticleDAO() {
		return mongoArticleDAO;
	}

	@Override
	protected AuthorDAO createAuthorDAO() {
		return mongoAuthorDAO;
	}

	@Override
	protected CategoryDAO createCategoryDAO() {
		return mongoCateogoryDAO;
	}

	@Override
	protected MediumTypeDAO createMediumTypeDAO() {
		return monoMediumTypeDAO;
	}

	@Override
	protected MediumDAO createMediumDAO() {
		return mongoMediumDAO;
	}
	
	@Override
	protected CreatorDAO createCreatorDAO() {
		return mongoCreatorDAO;
	}

}
