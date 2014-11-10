package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CategoryDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.CategoryDTOUtil;

public abstract class AbstractCategoryDTOImplMappingTest<A extends CategoryDTO> extends AbstractMappingTest<CategoryDTO,A,CategoryDTOImpl> {

	@Override
	protected CategoryDTOImpl createDTOB() {
		return CategoryDTOImplFactory.createPolitiek();
	}

	@Override
	protected void assertEquals(final A dtoA,final CategoryDTOImpl dtoB) {
		CategoryDTOUtil.assertEquals(dtoA, dtoB);
	}

}
