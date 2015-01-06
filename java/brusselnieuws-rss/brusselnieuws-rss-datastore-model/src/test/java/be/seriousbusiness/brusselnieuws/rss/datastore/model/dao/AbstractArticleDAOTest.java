package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.ArticleDTOImplFactory;

/**
 * Abstract Test Case for {@link ArticleDTOImpl} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractArticleDAOTest extends AbstractIdDAOTest<BigInteger,ArticleDTOImpl,ArticleDAO> {
	protected AuthorDAO authorDAO;
	protected CategoryDAO categoryDAO;
	protected MediumDAO mediumDAO;
	protected MediumTypeDAO mediumTypeDAO;
	
	protected abstract AuthorDAO createAuthorDAO();
	
	protected abstract CategoryDAO createCategoryDAO();
	
	protected abstract MediumDAO createMediumDAO();
	
	protected abstract MediumTypeDAO createMediumTypeDAO();
	
	@Override
	public ArticleDTOImpl createDTO() {
		return ArticleDTOImplFactory.createNew();
	}
	
	@Override
	@Before
	public void before(){
		super.before();
		authorDAO=createAuthorDAO();
		assert authorDAO!=null;
		categoryDAO=createCategoryDAO();
		assert categoryDAO!=null;
		mediumDAO=createMediumDAO();
		assert mediumDAO!=null;
		mediumTypeDAO=createMediumTypeDAO();
		assert mediumTypeDAO!=null;
	}
	
	@Override
	@After
	public void after(){
		for(final MediumDTOImpl mediumDTOImpl : getDTO().getMediumDTOs()){
			mediumTypeDAO.delete(mediumDTOImpl.getMediumTypeDTO());
			mediumDAO.delete(mediumDTOImpl);
		}
		for(final CategoryDTOImpl categoryDTOImpl : getDTO().getCategoryDTOs()){
			categoryDAO.delete(categoryDTOImpl);
		}
		for(final AuthorDTOImpl authorDTOImpl : getDTO().getAuthorDTOs()){
			authorDAO.delete(authorDTOImpl);
		}
		super.after();
	}

	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created CategoryDTO link should not be null",getDTO().getLink());
		assertNotNull("The created CategoryDTO title should not be null",getDTO().getTitle());
		assertNotNull("The created CategoryDTO publication date should not be null",getDTO().getPublicationDate());
		assertNotNull("The created CategoryDTO read should not be null",getDTO().isRead());
		assertTrue("The created CategoryDTO read should be set true",getDTO().isRead());
		assertNotNull("The created CategoryDTO favorite should not be null",getDTO().isFavorite());
		assertTrue("The created CategoryDTO favorite should be set true",getDTO().isFavorite());
		assertNotNull("The created CategoryDTO archived should not be null",getDTO().isArchived());
		assertTrue("The created CategoryDTO archived should be set true",getDTO().isArchived());
		assertNotNull("The created CategoryDTO List of AuthorDTO should not be null",getDTO().getAuthorDTOs());
		assertFalse("The created CategoryDTO List of AuthorDTO should not be empty",getDTO().getAuthorDTOs().isEmpty());
		assertNotNull("The created CategoryDTO List of CategoryDTO should not be null",getDTO().getCategoryDTOs());
		assertFalse("The created CategoryDTO List of CategoryDTO should not be empty",getDTO().getAuthorDTOs().isEmpty());
		assertNotNull("The created CategoryDTO List of MediumDTO should not be null",getDTO().getMediumDTOs());
		assertFalse("The created CategoryDTO List of MediumDTO should not be empty",getDTO().getAuthorDTOs().isEmpty());
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by title, before and after saving.
	 */
	@Test
	public void testFindByTitle(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByTitle(getDTO().getTitle()));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByTitle(getDTO().getTitle()));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	@Test
	public void testFindByTitleNull(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByTitle(null));
		assertNotNull("The List of ArticleDTO should not be null",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty",articleDTOImpls.isEmpty());
	}
	
	@Test
	public void testFindByTitleEmpty(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByTitle(""));
		assertNotNull("The List of ArticleDTO should not be null",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty",articleDTOImpls.isEmpty());
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} in a range of one day before and after the set publication date.
	 * Before and after saving the ArticleDTO. 
	 */
	@Test 
	public void testFindBetweenPublicationDates(){
		final DateTime from=new DateTime(getDTO().getPublicationDate()).minusDays(1);
		final DateTime to=new DateTime(getDTO().getPublicationDate()).plusDays(1);
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByPublicationDateBetween(from,to));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByPublicationDateBetween(from,to));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	/**
	 * Test if an {@link ArticleDTOImpl} can be found using it's specific publication date.
	 */
	@Test 
	public void testFindBetweenPublicationDatesExact(){
		setDTO(getDAO().save(getDTO()));
		final DateTime exactDateTime=new DateTime(getDTO().getPublicationDate());
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByPublicationDateBetween(exactDateTime,exactDateTime));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	/**
	 * Test if finding a {@link ArticleDTOImpl} by <code>null</code> values returns an empty <code>list</code> of {@link ArticleDTOImpl}.
	 */
	@Test 
	public void testFindBetweenPublicationDatesNull(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByPublicationDateBetween(null,null));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by his read value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByRead(){
		List<ArticleDTOImpl> articleDTOiMPLs=new ArrayList<ArticleDTOImpl>(getDAO().findByRead(getDTO().isRead()));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOiMPLs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOiMPLs.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOiMPLs=new ArrayList<ArticleDTOImpl>(getDAO().findByRead(getDTO().isRead()));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOiMPLs);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOiMPLs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOiMPLs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOiMPLs.get(0));
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by his favorite value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByFavorite(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByFavorite(getDTO().isFavorite()));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByFavorite(getDTO().isFavorite()));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by his archived value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByArchived(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByArchived(getDTO().isArchived()));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByArchived(getDTO().isArchived()));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by one of it's {@link CategoryDTOImpl},</br>
	 * before an after saving.
	 */
	@Test 
	public void testFindByCategory(){
		final CategoryDTOImpl categoryDTOImpl=categoryDAO.save(new ArrayList<CategoryDTOImpl>(getDTO().getCategoryDTOs()).get(0));
		final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>(getDTO().getCategoryDTOs()); 
		categoryDTOImpls.set(0,categoryDTOImpl);
		getDTO().setCategoryDTOs(categoryDTOImpls);
		assertNotNull("The List of CategoryDTO should not be null",categoryDTOImpl);
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByCategory(categoryDTOImpl));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByCategory(categoryDTOImpl));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	@Test 
	public void testFindByCategoryNull(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByCategory(null));
		assertNotNull("The List of ArticleDTO should not be null",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty",articleDTOImpls.isEmpty());
	}
	
	/**
	 * Test finding an {@link ArticleDTOImpl} by one of it's {@link AuthorDTOImpl},</br>
	 * before an after saving.
	 */
	@Test 
	public void testFindByAuthor(){
		final AuthorDTOImpl authorDTOImpl=authorDAO.save(new ArrayList<AuthorDTOImpl>(getDTO().getAuthorDTOs()).get(0));
		final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>(getDTO().getAuthorDTOs());  
		authorDTOImpls.add(0,authorDTOImpl);
		getDTO().setAuthorDTOs(authorDTOImpls);
		assertNotNull("The List of AuthorDTO should not be null",authorDTOImpl);
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByAuthor(authorDTOImpl));
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOImpls.isEmpty());
		setDTO(getDAO().save(getDTO()));
		articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByAuthor(authorDTOImpl));
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOImpls);
		assertFalse("The List of ArticleDTO should not be empty after saving",articleDTOImpls.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOImpls.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOImpls.get(0));
	}
	
	@Test 
	public void testFindByAuthorNull(){
		List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(getDAO().findByAuthor(null));
		assertNotNull("The List of ArticleDTO should not be null",articleDTOImpls);
		assertTrue("The List of ArticleDTO should be empty",articleDTOImpls.isEmpty());
	}

}
