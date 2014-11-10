package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.DAO;

public class DAOTestUtil {
	
	/**
	 * Check if a {@link D} {@link #findAll() findAll} returns a non <code>null</code> list of {@link DTO}. 
	 * Containing the expected number of {@link DTO}.
	 * @param dao the {@link D} to apply to
	 * @param expectedSize the expected number of found {@link DTO}
	 * @return the found list of {@link DTO}
	 */
	public static final <DTO,D extends DAO<DTO>> List<DTO> assertFindAll(final D dao,final int expectedSize){
		final List<DTO> dtos=dao.findAll();
		assertNotNull("The found list of DTO should never be null",dtos);
		assertEquals("The number of found DTO should be "+expectedSize,expectedSize,dtos.size());
		return dtos;
	}

}
