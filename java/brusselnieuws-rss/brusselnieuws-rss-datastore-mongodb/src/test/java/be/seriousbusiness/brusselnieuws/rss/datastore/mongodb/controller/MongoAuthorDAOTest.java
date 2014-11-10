package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AbstractAuthorDAOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-application-config.xml")
public class MongoAuthorDAOTest extends AbstractAuthorDAOTest {
	@Autowired
	private MongoAuthorDAO mongoAuthorDAO;

	@Override
	public AuthorDAO createDAO() {
		return mongoAuthorDAO;
	}

}
