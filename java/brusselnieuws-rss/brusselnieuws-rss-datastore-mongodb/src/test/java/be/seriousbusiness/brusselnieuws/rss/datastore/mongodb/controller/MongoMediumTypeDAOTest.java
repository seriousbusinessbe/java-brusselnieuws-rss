package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractMediumTypeDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MongoMediumTypeDAOTest extends AbstractMediumTypeDAOTest {
	@Autowired
	private MongoMediumTypeDAO mongoMediumTypeDAO;

	@Override
	public MediumTypeDAO createDAO() {
		return mongoMediumTypeDAO;
	}

}
