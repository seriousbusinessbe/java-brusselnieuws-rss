package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;

public class MediumDTOMediumMapperUtil {
	
	/**
	 * Assert if a {@link MediumDTO} and {@link Medium} are equal.
	 * @param mediumDTO
	 * @param medium
	 */
	public static final void assertEquals(final MediumDTO<?> mediumDTO,final Medium<?> medium){		
		Assert.assertEquals("The links are not equal",mediumDTO.getLink(),medium.getLink().toString());
		Assert.assertEquals("The sizes are not equal",mediumDTO.getSize(),medium.getSize(),0.0);
		MediumTypeDTOMediumTypeMapperUtil.assertEquals(mediumDTO.getMediumTypeDTO(),medium.getType());
	}

}
