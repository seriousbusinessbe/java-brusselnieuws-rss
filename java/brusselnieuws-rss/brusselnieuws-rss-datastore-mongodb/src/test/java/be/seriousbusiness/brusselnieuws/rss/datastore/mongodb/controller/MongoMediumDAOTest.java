package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractMediumDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-application-config.xml")
public class MongoMediumDAOTest extends AbstractMediumDAOTest {
	@Autowired
	private MongoMediumDAO mongoMediumDAO;
	@Autowired
	private MongoMediumTypeDAO mongoMediumTypeDAO;

	@Override
	public MediumDAO createDAO() {
		return mongoMediumDAO;
	}

	@Override
	protected MediumTypeDAO createMediumTypeDAO() {
		return mongoMediumTypeDAO;
	}

}
