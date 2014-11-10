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
public class MongoAuthorRepositoryTest {
	@Autowired
	private MongoAuthorRepository mongoAuthorRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoAuthorRepository cannot be null",mongoAuthorRepository);
	}
	
	@After
	public void after(){
		mongoAuthorRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoAuthorRepository should be empty",0,mongoAuthorRepository.count());
	}
}
