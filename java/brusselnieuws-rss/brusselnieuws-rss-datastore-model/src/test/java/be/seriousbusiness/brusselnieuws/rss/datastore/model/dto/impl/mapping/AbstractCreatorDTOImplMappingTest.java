package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CreatorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CreatorDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.CreatorDTOUtil;

/**
 * Abstract {@link CreatorDTOImpl} mapping test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <C> the type of {@link CreatorDTO} to perform a mapping test against
 */
public abstract class AbstractCreatorDTOImplMappingTest<C extends CreatorDTO> extends AbstractMappingTest<CreatorDTO,C,CreatorDTOImpl> {

	@Override
	protected CreatorDTOImpl createDTOB() {
		return CreatorDTOImplFactory.createBrusselNieuwsBe();
	}

	@Override
	protected void assertEquals(final C dtoA,final CreatorDTOImpl dtoB) {
		CreatorDTOUtil.assertEquals(dtoA, dtoB);
	}

}
