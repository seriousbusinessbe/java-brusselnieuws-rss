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
public class MongoMediumTypeRepositoryTest {
	@Autowired
	private MongoMediumTypeRepository mongoMediumTypeRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoMediumTypeRepository cannot be null",mongoMediumTypeRepository);
	}
	
	@After
	public void after(){
		mongoMediumTypeRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoMediumTypeRepository should be empty",0,mongoMediumTypeRepository.count());
	}

}
