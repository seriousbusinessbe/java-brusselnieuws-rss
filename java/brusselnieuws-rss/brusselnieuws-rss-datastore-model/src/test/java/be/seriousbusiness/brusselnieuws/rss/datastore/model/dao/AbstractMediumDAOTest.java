package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.util.DAOTestUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumDTOImplFactory;

/**
 * Abstract Test Case for {@link MediumDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractMediumDAOTest extends AbstractDAOTest<MediumDTOImpl,MediumDAO> {
	private static final Logger LOGGER=LoggerFactory.getLogger(AbstractMediumDAOTest.class);
	protected MediumTypeDAO mediumTypeDAO;
	
	@Override
	public MediumDTOImpl createDTO() {
		return MediumDTOImplFactory.createNewPNGImage();
	}
	
	protected abstract MediumTypeDAO createMediumTypeDAO();
	
	@Override
	@Before
	public void before(){
		super.before();
		mediumTypeDAO=createMediumTypeDAO();
		assert mediumTypeDAO!=null;
	}
	
	@Override
	@After
	public void after(){
		mediumTypeDAO.delete(getDTO().getMediumTypeDTO());
		super.after();
	}

	@Override
	@Test
	public void testGetDAO(){
		super.testGetDAO();
		assertNotNull("The created DTO link should not be null",getDTO().getLink());
	}
	
	/**
	 * Test finding a {@link MediumDTOImpl} by type before and after saving it.
	 */
	@Test
	public void testFindByLink(){
		MediumDTOImpl mediumDTOImpl=getDAO().findByLink(getDTO().getLink());
		assertNull("No MediumDTO should be found when nothing is saved",mediumDTOImpl);
		setDTO(getDAO().save(getDTO()));
		LOGGER.debug("Stored MediumDTOImpl:\n{}",getDTO());
		mediumDTOImpl=getDAO().findByLink(getDTO().getLink());
		assertNotNull("A MediumDTO should be found by type when saved",mediumDTOImpl);
		LOGGER.debug("Found MediumDTOImpl by link '{}':\n{}",getDTO().getLink(),mediumDTOImpl);
		assertEquals("The found MediumDTO should equal to the one saved",getDTO(),mediumDTOImpl);
	}
	
	@Test
	public void testFindByLinkNull(){
		assertNull("No MediumDTO should be found",getDAO().findByLink(null));
	}
	
	@Test
	public void testFindByLinkEmpty(){
		assertNull("No MediumDTO should be found",getDAO().findByLink(""));
	}
	
	/**
	 * Test saving a {@link MediumDTOImpl} multiple times.
	 */
	@Test
	public void testSaveDTO(){
		final MediumDTOImpl mediumDTOImpl=getDTO();
		super.testSaveDTO();
		assertEquals("The found MediumDTO should equal to the one saved",getDTO(),getDAO().save(mediumDTOImpl));
		DAOTestUtil.assertFindAll(getDAO(),1);
		assertEquals("The found MediumDTO should equal to the one saved",getDTO(),getDAO().save(getDTO()));
		DAOTestUtil.assertFindAll(getDAO(),1);
	}

}
