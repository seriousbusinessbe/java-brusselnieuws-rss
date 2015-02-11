package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.util;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * {@link CategoryDTOImpl} util helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImplUtil {
	
	/**
	 * Updates an existing {@link CategoryDTOImpl} with (new) data from another {@link CategoryDTOImpl}.
	 * @param existingCategoryDTOImpl
	 * @param newCategoryDTOImpl
	 * @return the updated existing {@link CategoryDTOImpl}
	 */
	public static final CategoryDTOImpl update(final CategoryDTOImpl existingCategoryDTOImpl,final CategoryDTOImpl newCategoryDTOImpl) {
		existingCategoryDTOImpl.setLink(newCategoryDTOImpl.getLink());
		existingCategoryDTOImpl.setName(newCategoryDTOImpl.getName());
		return existingCategoryDTOImpl;
	}

}
