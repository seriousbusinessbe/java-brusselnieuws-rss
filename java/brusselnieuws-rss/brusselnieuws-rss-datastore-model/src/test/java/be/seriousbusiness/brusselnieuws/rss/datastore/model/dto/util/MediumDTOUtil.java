package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

public class MediumDTOUtil {
	
	public static final void assertEquals(final MediumDTO<?> mediumDTOA,final MediumDTO<?> mediumDTOB) {
		Assert.assertNotNull("MediumDTO A cannot be null",mediumDTOA);
		Assert.assertNotNull("MediumDTO B cannot be null",mediumDTOB);
		Assert.assertEquals("The MediumDTO links are not equal",mediumDTOA.getLink(), mediumDTOB.getLink());
		Assert.assertEquals("The MediumDTO sizes are not equal",mediumDTOA.getSize(), mediumDTOB.getSize());
		MediumTypeDTOUtil.assertEquals(mediumDTOA.getMediumTypeDTO(), mediumDTOB.getMediumTypeDTO());
	}

}
