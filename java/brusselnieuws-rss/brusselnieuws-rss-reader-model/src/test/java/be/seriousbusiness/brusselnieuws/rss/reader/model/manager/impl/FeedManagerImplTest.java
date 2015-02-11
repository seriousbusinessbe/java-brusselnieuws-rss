package be.seriousbusiness.brusselnieuws.rss.reader.model.manager.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.FeedDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.FeedImplFactory;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-config.xml")
public class FeedManagerImplTest {
	@Autowired
	private FeedManagerImpl feedManagerImpl;
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	
	/**
	 * Tests mapping of an {@link FeedImpl} to {@link FeedDTOImpl} when saving.</br>
	 * In production the collection of {@link ArticleImpl} is not mapped resulting in non saved articles.</br>
	 * This test should reproduce the scenario but unfortunately it is working as expected and the problem could not be reproduced.
	 */
	@Test
	public void testSaveMapping() {
		// Mocked scenario:
		final FeedDAO feedDAO=mock(FeedDAO.class);
		final FeedImpl feed=FeedImplFactory.createNewNieuws();
		final FeedDTOImpl feedDTOImpl=mapper.map(feed,FeedDTOImpl.class);
		when(feedDAO.save(feedDTOImpl)).thenReturn(feedDTOImpl); // return value is not important
		// Test scenario:
		feedManagerImpl.setFeedDAO(feedDAO);
		feedManagerImpl.save(feed);
	}

}
