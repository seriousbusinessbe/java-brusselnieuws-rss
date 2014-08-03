package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCategoryDTOTest;

public class CategoryDTOImplTest extends AbstractCategoryDTOTest<CategoryDTOImpl> {

	public CategoryDTOImplTest() {
		super(321321321l,"http://www.brusselnieuws.be/nl/media-type/artikel","artikel");
	}

	@Override
	public CategoryDTOImpl create() {
		return new CategoryDTOImpl();
	}

}
