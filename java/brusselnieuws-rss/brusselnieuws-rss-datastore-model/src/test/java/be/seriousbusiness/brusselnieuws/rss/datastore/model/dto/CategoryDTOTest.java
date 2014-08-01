package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Abstract Test Case for CategoryDTO implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link CategoryDTO} implementation
 */
public abstract class CategoryDTOTest<DTO extends CategoryDTO> extends AbstractIdDTOTest<Long,DTO> {
	private final String link,name;

	/**
	 * Create a new Test Case for CategoryDTO implementations.
	 * @param id a positive, non zero id
	 * @param link a valid non <code>null</code> link
	 * @param name a valid non <code>null</code> name
	 */
	CategoryDTOTest(final Long id,final String link,final String name) {
		super(id);
		this.link=link;
		this.name=name;
	}
	
	@Test 
	@Override
	public void test(){
		super.test();
		assertNull("The link should be null",getDTO().getLink());
		assertNull("The name should be null",getDTO().getName());
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		getDTO().setName(name);
		assertEquals("The retrieved name is not equal to the one set",name,getDTO().getName());
		getDTO().setLink(link);
		assertEquals("The retrieved link is not equal to the one set",link,getDTO().getLink());
	}

}
