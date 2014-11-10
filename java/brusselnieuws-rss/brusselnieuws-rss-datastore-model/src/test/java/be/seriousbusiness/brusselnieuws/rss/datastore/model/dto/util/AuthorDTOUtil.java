package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

public class AuthorDTOUtil {
	
	public static final void assertEquals(final AuthorDTO authorDTOA,final AuthorDTO authorDTOB) {
		Assert.assertNotNull("AuthorDTO A cannot be null",authorDTOA);
		Assert.assertNotNull("AuthorDTO B cannot be null",authorDTOB);
		Assert.assertEquals("The AuthorDTO ids are not equal",authorDTOA.getId(), authorDTOB.getId());
		Assert.assertEquals("The AuthorDTO names are not equal",authorDTOA.getName(), authorDTOB.getName());
	}

}
