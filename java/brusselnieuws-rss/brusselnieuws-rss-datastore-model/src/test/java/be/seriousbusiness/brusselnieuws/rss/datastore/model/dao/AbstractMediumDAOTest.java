package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

/**
 * Abstract Test Case for {@link MediumDAO} implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link MediumDTO} used by the {@link MediumDAO} implementation
 * @param <D> the type of {@link MediumDAO<DTO>} implementation under test
 */
public abstract class AbstractMediumDAOTest<DTO extends MediumDTO,D extends MediumDAO<DTO>> extends AbstractDAOTest<DTO,D> {

	@Override
	@Test
	public void testGetDAO(){
		super.testGetDAO();
		assertNotNull("The created DTO link should not be null",getDTO().getLink());
	}
	
	/**
	 * Test finding a MediumDTO implementation by type before and after saving it.
	 */
	@Test
	public void testFindByLink(){
		MediumDTO mediumDTO=getDAO().findByLink(getDTO().getLink());
		assertNull("No MediumDTO should be found when nothing is saved",mediumDTO);
		getDAO().save(getDTO());
		mediumDTO=getDAO().findByLink(getDTO().getLink());
		assertNotNull("A MediumDTO should be found by type when saved",mediumDTO);
		assertEquals("The found MediumDTO should equal to the one saved",getDTO(),mediumDTO);
	}

}
