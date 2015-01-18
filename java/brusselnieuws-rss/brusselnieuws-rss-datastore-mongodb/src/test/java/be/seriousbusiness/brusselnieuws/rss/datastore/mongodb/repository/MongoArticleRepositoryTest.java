package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-datastore-mongodb-config.xml")
public class MongoArticleRepositoryTest {
	@Autowired
	private MongoArticleRepository mongoArticleRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoArticleRepository cannot be null",mongoArticleRepository);
	}
	
	@After
	public void after(){
		mongoArticleRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoArticleRepository should be empty",0,mongoArticleRepository.count());
	}

}
