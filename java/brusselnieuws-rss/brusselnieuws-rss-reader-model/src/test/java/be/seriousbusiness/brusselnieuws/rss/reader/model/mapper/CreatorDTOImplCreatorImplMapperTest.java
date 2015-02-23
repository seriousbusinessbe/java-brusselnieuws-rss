package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CreatorDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.CreatorImplFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-dozer-config.xml")
public class CreatorDTOImplCreatorImplMapperTest {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	
	@Test
	public void testCreatorDTOImplToCreatorImplMapping() throws IOException{
		final CreatorDTOImpl creatorDTOImpl=CreatorDTOImplFactory.createBrusselNieuwsBe();
		final CreatorImpl creatorImpl=mapper.map(creatorDTOImpl,CreatorImpl.class);
		Assert.assertEquals("The ids are not equal",creatorDTOImpl.getId(),creatorImpl.getId());
		Assert.assertEquals("The names are not equal",creatorDTOImpl.getName().trim().toLowerCase(),creatorImpl.getName());
	}
	
	@Test
	public void testCreatorImplToCreatorDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final CreatorImpl creatorImpl=CreatorImplFactory.createFMBrussel();
		final CreatorDTOImpl creatorDTOImpl=mapper.map(creatorImpl,CreatorDTOImpl.class);
		Assert.assertEquals("The ids are not equal",creatorImpl.getId(),creatorDTOImpl.getId());
		Assert.assertEquals("The names are not equal",creatorImpl.getName(),creatorDTOImpl.getName());
	}


}
