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

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.AuthorDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.AuthorImplFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-dozer-config.xml")
public class AuthorDTOImplAuthorImplMapperTest {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	
	@Test
	public void testAuthorDTOImplToAuthorImplMapping() throws IOException{
		final AuthorDTOImpl authorDTOImpl=AuthorDTOImplFactory.createBrusselNieuws();
		final AuthorImpl authorImpl=mapper.map(authorDTOImpl, AuthorImpl.class);
		Assert.assertEquals("The ids are not equal",authorDTOImpl.getId(),authorImpl.getId());
		Assert.assertEquals("The names are not equal",authorDTOImpl.getName().trim().toLowerCase(),authorImpl.getName());
	}
	
	@Test
	public void testAuthorImplToAuthorDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final AuthorImpl authorImpl=AuthorImplFactory.createFMBrussel();
		final AuthorDTOImpl authorDTOImpl=mapper.map(authorImpl,AuthorDTOImpl.class);
		Assert.assertEquals("The ids are not equal",authorImpl.getId(),authorDTOImpl.getId());
		Assert.assertEquals("The names are not equal",authorImpl.getName(),authorDTOImpl.getName());
	}

}
