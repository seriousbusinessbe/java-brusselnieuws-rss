package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

public class MediumTypeDTOMediumTypeMapperUtil {
	
	/**
	 * Assert if a {@link MediumTypeDTO} and {@link MediumType} are equal.
	 * @param mediumTypeDTO
	 * @param mediumType
	 */
	public static final void assertEquals(final MediumTypeDTO mediumTypeDTO,final MediumType mediumType){
		Assert.assertEquals("The ids are not equal",mediumTypeDTO.getId(),mediumType.getId());
		Assert.assertEquals("The types are not equal",mediumTypeDTO.getType().trim().toLowerCase(),mediumType.getType());
	}

}
