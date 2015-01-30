package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCategoryDTOTest;

/**
 * {@link CategoryDTOImpl test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImplTest extends AbstractCategoryDTOTest<CategoryDTOImpl> {

	public CategoryDTOImplTest() {
		super(BigInteger.valueOf(321321321l),"http://www.brusselnieuws.be/nl/media-type/artikel","artikel");
	}

	@Override
	public CategoryDTOImpl create() {
		return new CategoryDTOImpl();
	}

}
