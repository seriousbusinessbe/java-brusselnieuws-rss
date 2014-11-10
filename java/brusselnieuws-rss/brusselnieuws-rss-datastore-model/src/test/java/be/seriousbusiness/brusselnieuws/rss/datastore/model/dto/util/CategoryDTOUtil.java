package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

public class CategoryDTOUtil {
	
	public static final void assertEquals(final CategoryDTO categoryDTOA,final CategoryDTO categoryDTOB) {
		Assert.assertNotNull("CategoryDTO A cannot be null",categoryDTOA);
		Assert.assertNotNull("CategoryDTO B cannot be null",categoryDTOB);
		Assert.assertEquals("The CategoryDTO ids are not equal",categoryDTOA.getId(), categoryDTOB.getId());
		Assert.assertEquals("The CategoryDTO names are not equal",categoryDTOA.getName(), categoryDTOB.getName());
		Assert.assertEquals("The CategoryDTO links are not equal",categoryDTOA.getLink(), categoryDTOB.getLink());
	}

}
