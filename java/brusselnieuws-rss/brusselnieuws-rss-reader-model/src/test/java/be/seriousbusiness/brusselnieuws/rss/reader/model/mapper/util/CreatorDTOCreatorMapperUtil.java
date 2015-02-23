package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CreatorDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;

public class CreatorDTOCreatorMapperUtil {
	
	/**
	 * Assert if a {@link CreatorDTO} and {@link Creator} are equal.
	 * @param creatorDTO
	 * @param creator
	 */
	public static final void assertEquals(final CreatorDTO creatorDTO,final Creator creator){
		Assert.assertEquals("The ids are not equal",creatorDTO.getId(),creator.getId());
		Assert.assertEquals("The names are not equal",creatorDTO.getName().trim().toLowerCase(),creator.getName());
	}

}
