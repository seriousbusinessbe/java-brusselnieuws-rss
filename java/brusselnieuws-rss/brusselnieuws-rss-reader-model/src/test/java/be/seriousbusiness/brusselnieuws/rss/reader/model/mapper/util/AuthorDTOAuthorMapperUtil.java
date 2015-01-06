package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;

public class AuthorDTOAuthorMapperUtil {
	
	/**
	 * Assert if a {@link AuthorDTO} and {@link Author} are equal.
	 * @param authorDTO
	 * @param author
	 */
	public static final void assertEquals(final AuthorDTO authorDTO,final Author author){
		Assert.assertEquals("The ids are not equal",authorDTO.getId(),author.getId());
		Assert.assertEquals("The names are not equal",authorDTO.getName().trim().toLowerCase(),author.getName());
	}

}
