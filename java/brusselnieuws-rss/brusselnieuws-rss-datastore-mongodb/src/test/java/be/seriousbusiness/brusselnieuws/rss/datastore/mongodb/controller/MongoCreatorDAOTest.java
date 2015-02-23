package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractCreatorDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CreatorDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MongoCreatorDAOTest extends AbstractCreatorDAOTest {
	@Autowired
	private MongoCreatorDAO mongoCreatorDAO;

	@Override
	public CreatorDAO createDAO() {
		return mongoCreatorDAO;
	}
}
