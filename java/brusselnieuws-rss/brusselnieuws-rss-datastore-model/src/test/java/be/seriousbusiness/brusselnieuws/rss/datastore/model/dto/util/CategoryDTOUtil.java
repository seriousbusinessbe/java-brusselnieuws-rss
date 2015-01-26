package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * {@link CategoryDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOUtil {
	
	/**
	 * Asserts two {@link CategoryDTO} for equality.
	 * @param categoryDTOA the first {@link CategoryDTO}
	 * @param categoryDTOB the second {@link CategoryDTO}
	 */
	public static final void assertEquals(final CategoryDTO categoryDTOA,final CategoryDTO categoryDTOB) {
		Assert.assertNotNull("CategoryDTO A cannot be null",categoryDTOA);
		Assert.assertNotNull("CategoryDTO B cannot be null",categoryDTOB);
		Assert.assertEquals("The CategoryDTO ids are not equal",categoryDTOA.getId(), categoryDTOB.getId());
		Assert.assertEquals("The CategoryDTO names are not equal",categoryDTOA.getName(), categoryDTOB.getName());
		Assert.assertEquals("The CategoryDTO links are not equal",categoryDTOA.getLink(), categoryDTOB.getLink());
	}

}
