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
public class MongoMediumRepositoryTest {
	@Autowired
	private MongoMediumRepository mongoMediumRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoMediumRepository cannot be null",mongoMediumRepository);
	}
	
	@After
	public void after(){
		mongoMediumRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoMediumRepository should be empty",0,mongoMediumRepository.count());
	}

}
