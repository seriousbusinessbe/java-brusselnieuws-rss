package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CreatorDTO;

/**
 * {@link CreatorDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CreatorDTOUtil {
	
	/**
	 * Asserts two {@link CreatorDTO} for equality.
	 * @param creatorDTOA the first {@link CreatorDTO}
	 * @param creatorDTOB the second {@link CreatorDTO}
	 */
	public static final void assertEquals(final CreatorDTO creatorDTOA,final CreatorDTO creatorDTOB) {
		Assert.assertNotNull("CreatorDTO A cannot be null",creatorDTOA);
		Assert.assertNotNull("CreatorDTO B cannot be null",creatorDTOB);
		Assert.assertEquals("The CreatorDTO ids are not equal",creatorDTOA.getId(), creatorDTOB.getId());
		Assert.assertEquals("The CreatorDTO names are not equal",creatorDTOA.getName(), creatorDTOB.getName());
	}

}
