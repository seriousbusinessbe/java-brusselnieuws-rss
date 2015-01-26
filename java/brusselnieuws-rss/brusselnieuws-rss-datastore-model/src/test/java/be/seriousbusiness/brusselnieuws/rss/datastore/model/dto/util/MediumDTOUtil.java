package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

/**
 * {@link MediumDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumDTOUtil {
	
	/**
	 * Asserts two {@link MediumDTO} for equality.
	 * @param mediumDTOA the first {@link MediumDTO}
	 * @param mediumDTOB the second {@link MediumDTO}
	 */
	public static final void assertEquals(final MediumDTO<?> mediumDTOA,final MediumDTO<?> mediumDTOB) {
		Assert.assertNotNull("MediumDTO A cannot be null",mediumDTOA);
		Assert.assertNotNull("MediumDTO B cannot be null",mediumDTOB);
		Assert.assertEquals("The MediumDTO links are not equal",mediumDTOA.getLink(), mediumDTOB.getLink());
		Assert.assertEquals("The MediumDTO sizes are not equal",mediumDTOA.getSize(), mediumDTOB.getSize());
		MediumTypeDTOUtil.assertEquals(mediumDTOA.getMediumTypeDTO(), mediumDTOB.getMediumTypeDTO());
	}

}
