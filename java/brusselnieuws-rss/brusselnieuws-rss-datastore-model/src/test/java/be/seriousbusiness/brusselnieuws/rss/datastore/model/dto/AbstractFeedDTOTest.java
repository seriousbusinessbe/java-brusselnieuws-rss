package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.Test;

/**
 * Abstract Test Case for FeedDTO implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link FeedDTO} implementation
 */
public abstract class AbstractFeedDTOTest<DTO extends FeedDTO> extends AbstractIdDTOTest<Long,DTO> {
	private Set<ArticleDTO> articleDTOs;
	private String description,title,link;

	/**
	 * 
	 * @param id a positive, non zero id
	 * @param articleDTOs a valid non <code>null</code> set of ArticleDTO's
	 * @param description a valid non <code>null</code> description
	 * @param link a valid non <code>null</code> link
	 * @param title a valid non <code>null</code> title
	 */
	public AbstractFeedDTOTest(final long id,final Set<ArticleDTO> articleDTOs,final String description,final String link,final String title) {
		super(id);
		this.articleDTOs=articleDTOs;
		this.description=description;
		this.title=title;
		this.link=link;
	}
	
	@Test 
	@Override
	public void test(){
		super.test();
		assertNull("The set of ArticleDTO should be null",getDTO().getArticleDTOs());
		assertNull("The description should be null",getDTO().getDescription());
		assertNull("The link should be null",getDTO().getLink());
		assertNull("The title should be null",getDTO().getTitle());	
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		getDTO().setArticleDTOs(articleDTOs);
		assertEquals("The retrieved set of ArticleDTO is not equal to the one set",articleDTOs,getDTO().getArticleDTOs());
		getDTO().setDescription(description);
		assertEquals("The retrieved description is not equal to the one set",description,getDTO().getDescription());
		getDTO().setLink(link);
		assertEquals("The retrieved link is not equal to the one set",link,getDTO().getLink());
		getDTO().setTitle(title);
		assertEquals("The retrieved title is not equal to the one set",title,getDTO().getTitle());
	}

}
