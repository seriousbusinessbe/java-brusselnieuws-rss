package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.FeedDTOImplFactory;

/**
 * Abstract Test Case for {@link FeedDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractFeedDAOTest extends AbstractIdDAOTest<BigInteger,FeedDTOImpl,FeedDAO> {
	protected ArticleDAO articleDAO;
	protected AuthorDAO authorDAO;
	protected CategoryDAO categoryDAO;
	protected MediumTypeDAO mediumTypeDAO;
	protected MediumDAO mediumDAO;
	
	@Override
	@Before
	public void before(){
		super.before();
		articleDAO=createArticleDAO();
		assert articleDAO!=null;
		authorDAO=createAuthorDAO();
		assert authorDAO!=null;
		categoryDAO=createCategoryDAO();
		assert categoryDAO!=null;
		mediumTypeDAO=createMediumTypeDAO();
		assert mediumTypeDAO!=null;
		mediumDAO=createMediumDAO();
		assert mediumDAO!=null;
	}
	
	/**
	 * Tear down after every test case.</br>
	 * Delete's {@link DTO} if set.
	 */
	@After
	public void after(){
		for(final ArticleDTOImpl articleDTOImpl : getDTO().getArticleDTOs()){
			for(final AuthorDTOImpl authorDTOImpl : articleDTOImpl.getAuthorDTOs()){
				authorDAO.delete(authorDTOImpl);
			}
			for(final CategoryDTOImpl categoryDTOImpl : articleDTOImpl.getCategoryDTOs()){
				categoryDAO.delete(categoryDTOImpl);
			}
			for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()){
				mediumTypeDAO.delete(mediumDTOImpl.getMediumTypeDTO());
				mediumDAO.delete(mediumDTOImpl);
			}
			articleDAO.delete(articleDTOImpl);
		}
		super.after();
	}
	
	protected abstract ArticleDAO createArticleDAO();
	
	protected abstract AuthorDAO createAuthorDAO();
	
	protected abstract CategoryDAO createCategoryDAO();
	
	protected abstract MediumTypeDAO createMediumTypeDAO();
	
	protected abstract MediumDAO createMediumDAO();
	
	@Override
	public FeedDTOImpl createDTO() {
		return FeedDTOImplFactory.createNewPolitiek();
	}

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
		FeedDTOImpl feedDTOImpl=getDAO().findByLink(link);
		assertNull("The FeedDTO should be null before saving",feedDTOImpl);
		setDTO(getDAO().save(getDTO()));
		feedDTOImpl=getDAO().findByLink(link);
		assertNotNull("The FeedDTO should not be null after saving",feedDTOImpl);
		assertEquals("The found FeedDTO should be equal to the one saved",feedDTOImpl,getDTO());
	}
	
	@Test
	public void testFindByLinkNull(){
		assertNull("The FeedDTO should be null",getDAO().findByLink(null));
	}
	
	@Test
	public void testFindByLinkEmpty(){
		assertNull("The FeedDTO should be null",getDAO().findByLink(""));
	}

}
