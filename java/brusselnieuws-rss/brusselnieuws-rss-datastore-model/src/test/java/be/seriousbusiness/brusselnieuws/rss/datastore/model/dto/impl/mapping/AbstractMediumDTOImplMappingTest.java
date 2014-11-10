package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.MediumDTOUtil;

public abstract class AbstractMediumDTOImplMappingTest<A extends MediumDTO<?>> extends AbstractMappingTest<MediumDTO<?>,A,MediumDTOImpl> {

	@Override
	protected MediumDTOImpl createDTOB() {
		return MediumDTOImplFactory.createPNGImage();
	}

	@Override
	protected void assertEquals(final A dtoA,final MediumDTOImpl dtoB) {
		MediumDTOUtil.assertEquals(dtoA, dtoB);
	}
	
}
