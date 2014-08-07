package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;




import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public abstract class AbstractMediumTypeDAOTest extends AbstractIdDAOTest<Long,MediumTypeDTO,MediumTypeDAO> {
	
	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created MediumTypeDTO type should not be null",getDTO().getType());
	}
	
	/**
	 * Test finding a MediumTypeDTO implementation by type,</br>
	 * before and after saving it.
	 */
	@Test
	public void testFindByType(){
		MediumTypeDTO mediumTypeDTO=getDAO().findByType(getDTO().getType());
		assertNull("No MediumTypeDTO should not be found when nothing is saved",mediumTypeDTO);
		getDAO().save(getDTO());
		mediumTypeDTO=getDAO().findByType(getDTO().getType());
		assertNotNull("A MediumTypeDTO should be found by type when saved",mediumTypeDTO);
		assertEquals("The found MediumTypeDTO should be equal to the one saved",getDTO(),mediumTypeDTO);
	}

}
