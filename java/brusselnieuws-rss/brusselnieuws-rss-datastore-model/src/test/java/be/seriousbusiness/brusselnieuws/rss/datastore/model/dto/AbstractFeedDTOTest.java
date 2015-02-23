package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;

/**
 * Abstract Test Case for {@link FeedDTO} implementations.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <MEDIUMTYPEDTO> the type of {@link MediumTypeDTO} implementation
 * @param <MEDIUMDTO> the type of {@link MediumDTO} implementation
 * @param <CATEGORYDTO> the type of {@link CategoryDTO} implementation
 * @param <AUTHORDTO> the type of {@link AuthorDTO} implementation
 * @param <ARTICLEDTO> the type of {@link ArticleDTO} implementation
 * @param <FEEDDTO> the type of {@link FeedDTO} implementation
 */
public abstract class AbstractFeedDTOTest<MEDIUMTYPEDTO extends MediumTypeDTO,
										MEDIUMDTO extends MediumDTO<MEDIUMTYPEDTO>,
										CATEGORYDTO extends CategoryDTO,
										AUTHORDTO extends AuthorDTO,
										CREATORDTO extends CreatorDTO,
										ARTICLEDTO extends ArticleDTO<MEDIUMTYPEDTO,MEDIUMDTO,CATEGORYDTO,AUTHORDTO,CREATORDTO>,
										FEEDDTO extends FeedDTO<MEDIUMTYPEDTO,MEDIUMDTO,CATEGORYDTO,AUTHORDTO,CREATORDTO,ARTICLEDTO>> extends AbstractIdDTOTest<BigInteger,FEEDDTO> {
	private List<ARTICLEDTO> articleDTOs;
	private String description,title,link;

	/**
	 * Creates a new test case for {@link FeedDTO} implementations.
	 * @param id a positive, non zero id
	 * @param articleDTOs a valid non <code>null</code> set of {@link ARTICLEDTO}'s
	 * @param description a valid non <code>null</code> description
	 * @param link a valid non <code>null</code> link
	 * @param title a valid non <code>null</code> title
	 */
	public AbstractFeedDTOTest(final BigInteger id,final List<ARTICLEDTO> articleDTOs,final String description,final String link,final String title) {
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
