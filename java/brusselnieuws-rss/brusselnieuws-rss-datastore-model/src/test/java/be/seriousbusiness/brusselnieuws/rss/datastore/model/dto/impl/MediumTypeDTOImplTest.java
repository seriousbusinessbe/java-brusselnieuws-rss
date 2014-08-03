package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumTypeDTOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumTypeDTOImplTest extends AbstractMediumTypeDTOTest<MediumTypeDTO> {

	public MediumTypeDTOImplTest() {
		super(123456789l,"image/jpeg");
	}

	@Override
	public MediumTypeDTO create() {
		return new MediumTypeDTOImpl();
	}

}
