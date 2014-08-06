package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;

public abstract class AbstractArticleDAOTest extends AbstractIdDAOTest<Long,ArticleDTO,ArticleDAO> {

	@Override
	@Test
	public void assertDAODTO(){
		super.assertDAODTO();
		//assertNotNull("The created CategoryDTO name should not be null",getDTO().());
		assertNotNull("The created CategoryDTO link should not be null",getDTO().getLink());
	}
	
	@Test
	public void testFindByTitle(){
		List<ArticleDTO> articleDTOs=getDAO().findByTitle(getDTO().getTitle());
	}
	
	@Test 
	public void testFindBetweenPublicationDates(){
		List<ArticleDTO> articleDTOs=getDAO().findBetweenPublicationDates(null,null);
	}
	
	@Test 
	public void testFindByRead(){
		List<ArticleDTO> articleDTOs=getDAO().findByRead(getDTO().isRead());
	}
	
	@Test 
	public void testFindByFavorite(){
		List<ArticleDTO> articleDTOs=getDAO().findByFavorite(getDTO().isFavorite());
	}
	
	@Test 
	public void testFindByArchived(){
		List<ArticleDTO> articleDTOs=getDAO().findByArchived(getDTO().isArchived());
	}
	
	@Test 
	public void testFindByCategory(){
		List<ArticleDTO> articleDTOs=getDAO().findByCategory(null);
	}
	
	@Test 
	public void testFindByAuthor(){
		List<ArticleDTO> articleDTOs=getDAO().findByAuthor(null);
	}
	

}
