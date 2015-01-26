package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * {@link AuthorDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorDTOUtil {
	
	/**
	 * Asserts two {@link AuthorDTO} for equality.
	 * @param authorDTOA the first {@link AuthorDTO}
	 * @param authorDTOB the second {@link AuthorDTO}
	 */
	public static final void assertEquals(final AuthorDTO authorDTOA,final AuthorDTO authorDTOB) {
		Assert.assertNotNull("AuthorDTO A cannot be null",authorDTOA);
		Assert.assertNotNull("AuthorDTO B cannot be null",authorDTOB);
		Assert.assertEquals("The AuthorDTO ids are not equal",authorDTOA.getId(), authorDTOB.getId());
		Assert.assertEquals("The AuthorDTO names are not equal",authorDTOA.getName(), authorDTOB.getName());
	}

}
