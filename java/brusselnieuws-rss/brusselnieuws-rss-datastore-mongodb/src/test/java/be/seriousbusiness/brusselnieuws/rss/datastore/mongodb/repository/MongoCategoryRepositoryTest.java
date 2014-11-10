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
public class MongoCategoryRepositoryTest {
	@Autowired
	private MongoCategoryRepository mongoCategoryRepository;
	
	@Before
	public void before(){
		Assert.assertNotNull("The MongoCategoryRepository cannot be null",mongoCategoryRepository);
	}
	
	@After
	public void after(){
		mongoCategoryRepository.deleteAll();
	}
	
	@Test
	public void test(){
		Assert.assertEquals("The MongoCategoryRepository should be empty",0,mongoCategoryRepository.count());
	}

}
