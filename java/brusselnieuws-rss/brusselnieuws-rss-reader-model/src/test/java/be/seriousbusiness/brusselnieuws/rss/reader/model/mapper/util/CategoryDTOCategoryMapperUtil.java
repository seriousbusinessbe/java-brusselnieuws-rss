package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;

public class CategoryDTOCategoryMapperUtil {
	
	/**
	 * Assert if a {@link CategoryDTO} and {@link Category} are equal.
	 * @param categoryDTO
	 * @param category
	 */
	public static final void assertEquals(final CategoryDTO categoryDTO,final Category category){
		Assert.assertEquals("The ids are not equal",categoryDTO.getId(),category.getId());
		Assert.assertEquals("The links are not equal",categoryDTO.getLink(),category.getLink().toString());
		Assert.assertEquals("The names are not equal",categoryDTO.getName().trim().toLowerCase(),category.getName());
	}

}
