package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * Abstract Test Case for {@link ArticleDAO} implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link ArticleDTO} used by the {@link ArticleDAO} implementation
 * @param <D> the type of {@link ArticleDAO<DTO>} implementation under test
 */
public abstract class AbstractArticleDAOTest<DTO extends ArticleDTO,D extends ArticleDAO<DTO>> extends AbstractIdDAOTest<Long,DTO,D> {

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
	 * Test finding an ArticleDTO by title, before and after saving.
	 */
	@Test
	public void testFindByTitle(){
		List<ArticleDTO> articleDTOs=getDAO().findByTitle(getDTO().getTitle());
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByTitle(getDTO().getTitle());
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO in a range of one day before and after the set publication date.
	 * Before and after saving the ArticleDTO. 
	 */
	@Test 
	public void testFindBetweenPublicationDates(){
		final DateTime from=new DateTime(getDTO().getPublicationDate()).minusDays(1);
		final DateTime to=new DateTime(getDTO().getPublicationDate()).plusDays(1);
		List<ArticleDTO> articleDTOs=getDAO().findBetweenPublicationDates(from,to);
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findBetweenPublicationDates(from,to);
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO by his read value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByRead(){
		List<ArticleDTO> articleDTOs=getDAO().findByRead(getDTO().isRead());
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByRead(getDTO().isRead());
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO by his favorite value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByFavorite(){
		List<ArticleDTO> articleDTOs=getDAO().findByFavorite(getDTO().isFavorite());
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByFavorite(getDTO().isFavorite());
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO by his archived value,</br>
	 * before and after saving.
	 */
	@Test 
	public void testFindByArchived(){
		List<ArticleDTO> articleDTOs=getDAO().findByArchived(getDTO().isArchived());
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByArchived(getDTO().isArchived());
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO by one of it's CategoryDTO,</br>
	 * before an after saving.
	 */
	@Test 
	public void testFindByCategory(){
		final CategoryDTO categoryDTO=getDTO().getCategoryDTOs().get(0);
		assertNotNull("The List of CategoryDTO should not be null",categoryDTO);
		List<ArticleDTO> articleDTOs=getDAO().findByCategory(categoryDTO);
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByCategory(categoryDTO);
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}
	
	/**
	 * Test finding an ArticleDTO by one of it's AuthorDTO,</br>
	 * before an after saving.
	 */
	@Test 
	public void testFindByAuthor(){
		final AuthorDTO authorDTO=getDTO().getAuthorDTOs().get(0);
		assertNotNull("The List of AuthorDTO should not be null",authorDTO);
		List<ArticleDTO> articleDTOs=getDAO().findByAuthor(authorDTO);
		assertNotNull("The List of ArticleDTO should not be null before saving",articleDTOs);
		assertTrue("The List of ArticleDTO should be empty before saving",articleDTOs.isEmpty());
		getDAO().save(getDTO());
		articleDTOs=getDAO().findByAuthor(authorDTO);
		assertNotNull("The List of ArticleDTO should not be null after saving",articleDTOs);
		assertTrue("The List of ArticleDTO should not be empty after saving",articleDTOs.isEmpty());
		assertEquals("The List of ArticleDTO should contain one ArticleDTO after saving",1,articleDTOs.size());
		assertEquals("The found ArticleDTO should be equal to the one saved",getDTO(),articleDTOs.get(0));
	}

}
