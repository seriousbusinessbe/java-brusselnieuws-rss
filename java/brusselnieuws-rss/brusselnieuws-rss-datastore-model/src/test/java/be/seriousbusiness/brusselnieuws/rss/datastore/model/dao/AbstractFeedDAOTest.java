package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

public abstract class AbstractFeedDAOTest extends AbstractIdDAOTest<Long,FeedDTO,FeedDAO> {

	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created CategoryDTO link should not be null",getDTO().getLink());
		assertNotNull("The created CategoryDTO title should not be null",getDTO().getTitle());
		assertNotNull("The created CategoryDTO List of ArticleDTO should not be null",getDTO().getArticleDTOs());
		assertFalse("The created CategoryDTO List of ArticleDTO should not be empty",getDTO().getArticleDTOs().isEmpty());
	}
	
	@Test
	public void testFindByLink(){
		final String link=getDTO().getLink();
		FeedDTO feedDTO=getDAO().findByLink(link);
		assertNull("The FeedDTO should be null before saving",feedDTO);
		getDAO().save(getDTO());
		feedDTO=getDAO().findByLink(link);
		assertNotNull("The FeedDTO should not be null after saving",feedDTO);
		assertEquals("The found FeedDTO should be equal to the one saved",feedDTO,getDTO());
	}

}