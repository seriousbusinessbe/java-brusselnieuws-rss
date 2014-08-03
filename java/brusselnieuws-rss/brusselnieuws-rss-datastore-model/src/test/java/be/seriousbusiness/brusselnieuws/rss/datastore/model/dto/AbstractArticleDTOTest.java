package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.Test;

/**
 * Abstract Test Case for ArticleDTO implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link ArticleDTO} implementation
 */
public abstract class AbstractArticleDTOTest<DTO extends ArticleDTO> extends AbstractIdDTOTest<Long,DTO> {
	private Set<AuthorDTO> authorDTOs;
	private Set<CategoryDTO> categoryDTOs;
	private Set<MediumDTO> mediumDTOs;
	private String description,link,title;
	private long publicationDate;
	private boolean archived,favorite,read;

	/**
	 * Create a new Test Case for ArticleDTO implementations.
	 * @param id a positive, non zero id
	 * @param authorDTOs a valid non <code>null</code> set of AuthorDTO's
	 * @param categoryDTOs a valid non <code>null</code> set of CategoryDTO's
	 * @param mediumDTOs a valid non <code>null</code> set of MediumDTO's
	 * @param description a valid non <code>null</code> description
	 * @param link a valid non <code>null</code> link
	 * @param title a valid non <code>null</code> title
	 * @param publicationDate a valid positive publication date
	 * @param archived <code>true</code> or <code>false</code>
	 * @param favorite <code>true</code> or <code>false</code>
	 * @param read <code>true</code> or <code>false</code>
	 */
	public AbstractArticleDTOTest(final long id,final Set<AuthorDTO> authorDTOs,final Set<CategoryDTO> categoryDTOs,final Set<MediumDTO> mediumDTOs,
			final String description,final String link,final String title,final long publicationDate,
			final boolean archived,final boolean favorite,final boolean read) {
		super(id);
		this.authorDTOs=authorDTOs;
		this.categoryDTOs=categoryDTOs;
		this.mediumDTOs=mediumDTOs;
		this.description=description;
		this.link=link;
		this.title=title;
		this.publicationDate=publicationDate;
		this.archived=archived;
		this.favorite=favorite;
		this.read=read;
	}

	@Test 
	@Override
	public void test(){
		super.test();
		assertNull("The set of AuthorDTO should be null",getDTO().getAuthorDTOs());
		assertNull("The set of CategoryDTO should be null",getDTO().getCategoryDTOs());
		assertNull("The set of MediumDTO should be null",getDTO().getMediumDTOs());
		assertNull("The description should be null",getDTO().getDescription());
		assertNull("The link should be null",getDTO().getLink());
		assertNull("The publication date should be null",getDTO().getPublicationDate());
		assertNull("The title should be null",getDTO().getTitle());
		assertNull("The is archived should be null",getDTO().isArchived());
		assertNull("The is favorite should be null",getDTO().isFavorite());
		assertNull("The is read should be null",getDTO().isRead());		
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		getDTO().setAuthorDTOs(authorDTOs);
		assertEquals("The retrieved set of AuthorDTO is not equal to the one set",authorDTOs,getDTO().getAuthorDTOs());
		getDTO().setCategoryDTOs(categoryDTOs);
		assertEquals("The retrieved set of CategoryDTO is not equal to the one set",categoryDTOs,getDTO().getCategoryDTOs());
		getDTO().setMediumDTOs(mediumDTOs);
		assertEquals("The retrieved set of MediumDTO is not equal to the one set",mediumDTOs,getDTO().getMediumDTOs());
		getDTO().setDescription(description);
		assertEquals("The retrieved description is not equal to the one set",description,getDTO().getDescription());
		getDTO().setLink(link);
		assertEquals("The retrieved link is not equal to the one set",link,getDTO().getLink());
		getDTO().setPublicationDate(publicationDate);
		assertEquals("The retrieved publication date is not equal to the one set",publicationDate,getDTO().getPublicationDate(),0.0);
		getDTO().setTitle(title);
		assertEquals("The retrieved title is not equal to the one set",title,getDTO().getTitle());
		getDTO().setArchived(archived);
		assertEquals("The retrieved archived is not equal to the one set",archived,getDTO().isArchived());
		getDTO().setFavorite(favorite);
		assertEquals("The retrieved favorite is not equal to the one set",favorite,getDTO().isFavorite());
		getDTO().setRead(read);
		assertEquals("The retrieved read is not equal to the one set",read,getDTO().isRead());
	}

}
