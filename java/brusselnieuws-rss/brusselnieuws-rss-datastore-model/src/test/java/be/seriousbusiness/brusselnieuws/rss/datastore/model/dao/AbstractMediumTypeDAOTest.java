package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumTypeDTOImplFactory;

/**
 * Abstract Test Case for {@link MediumTypeDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractMediumTypeDAOTest extends AbstractIdDAOTest<BigInteger,MediumTypeDTOImpl,MediumTypeDAO> {
	
	@Override
	public MediumTypeDTOImpl createDTO() {
		return MediumTypeDTOImplFactory.createNewPNG();
	}
	
	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created MediumTypeDTOImpl type should not be null",getDTO().getType());
	}
	
	/**
	 * Test finding a {@link MediumTypeDTOImpl} by type,</br>
	 * before and after saving it.
	 */
	@Test
	public void testFindByType(){
		MediumTypeDTOImpl mediumTypeDTOImpl=getDAO().findByType(getDTO().getType());
		assertNull("MediumTypeDTO should not be found when nothing is saved",mediumTypeDTOImpl);
		setDTO(getDAO().save(getDTO()));
		mediumTypeDTOImpl=getDAO().findByType(getDTO().getType());
		assertNotNull("A MediumTypeDTO should be found by type when saved",mediumTypeDTOImpl);
		Assert.assertEquals("The found MediumTypeDTO is  not equal to the one saved",getDTO(),mediumTypeDTOImpl);
	}
	
	@Test
	public void testFindByTypeNull(){
		assertNull("MediumTypeDTO should not be found",getDAO().findByType(null));
	}
	
	@Test
	public void testFindByTypeEmpty(){
		assertNull("MediumTypeDTO should not be found",getDAO().findByType(""));
	}
	
	/**
	 * Test saving a {@link MediumTypeDTOImpl} twice.
	 */
	@Test
	public void testSaveDTONotUniqueException(){
		final MediumTypeDTOImpl mediumTypeDTOImpl=getDTO();
		setDTO(getDAO().save(mediumTypeDTOImpl));
		getDAO().save(mediumTypeDTOImpl);
	}

}
