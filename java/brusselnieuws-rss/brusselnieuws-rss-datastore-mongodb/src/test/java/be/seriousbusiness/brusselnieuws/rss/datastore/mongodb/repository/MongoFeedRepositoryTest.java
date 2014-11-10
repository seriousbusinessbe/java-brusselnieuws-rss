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
@ContextConfiguration("classpath:config/test-application-config.xml")
public class MongoFeedRepositoryTest {
	@Autowired
	private MongoFeedRepository mongoFeedRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoFeedRepository cannot be null",mongoFeedRepository);
	}
	
	@After
	public void after(){
		mongoFeedRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoFeedRepository should be empty",0,mongoFeedRepository.count());
	}

}
