package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * {@link MediumTypeDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeDTOUtil {
	
	/**
	 * Asserts two {@link MediumTypeDTO} for equality.
	 * @param mediumTypeDTOA the first {@link MediumTypeDTO}
	 * @param mediumTypeDTOB the second {@link MediumTypeDTO}
	 */
	public static final void assertEquals(final MediumTypeDTO mediumTypeDTOA,final MediumTypeDTO mediumTypeDTOB) {
		Assert.assertNotNull("MediumTypeDTO A cannot be null",mediumTypeDTOA);
		Assert.assertNotNull("MediumTypeDTO B cannot be null",mediumTypeDTOB);
		Assert.assertEquals("The MediumTypeDTO ids are not equal",mediumTypeDTOA.getId(), mediumTypeDTOB.getId());
		Assert.assertEquals("The MediumTypeDTO types are not equal",mediumTypeDTOA.getType(), mediumTypeDTOB.getType());
	}

}
