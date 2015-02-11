package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.FeedDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.FeedImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util.FeedDTOFeedMapperUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-dozer-config.xml")
public class FeedDTOImplFeedImplMapperTest {
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	
	@Test
	public void testFeedDTOImplToFeedImplMapping() throws IOException{
		final FeedDTOImpl feedDTOImpl=FeedDTOImplFactory.createPolitiek();
		final FeedImpl feedImpl=mapper.map(feedDTOImpl, FeedImpl.class);
		FeedDTOFeedMapperUtil.assertEquals(feedDTOImpl, feedImpl);
	}
	
	@Test
	public void testFeedImplToFeedDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final FeedImpl feedImpl=FeedImplFactory.createNieuws();
		final FeedDTOImpl feedDTOImpl=mapper.map(feedImpl,FeedDTOImpl.class);
		FeedDTOFeedMapperUtil.assertEquals(feedDTOImpl, feedImpl);
	}

}
