package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumTypeDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.MediumTypeDTOUtil;

public abstract class AbstractMediumTypeDTOImplMappingTest<A extends MediumTypeDTO> extends AbstractMappingTest<MediumTypeDTO,A,MediumTypeDTOImpl> {

	@Override
	protected MediumTypeDTOImpl createDTOB() {
		return MediumTypeDTOImplFactory.createPNG();
	}

	@Override
	protected void assertEquals(final A dtoA,final MediumTypeDTOImpl dtoB) {
		MediumTypeDTOUtil.assertEquals(dtoA, dtoB);
	}

}
