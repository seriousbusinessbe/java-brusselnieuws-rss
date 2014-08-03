package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.stub;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumTypeDTOStub implements MediumTypeDTO {

	@Override
	public Long getId() {
		return 123123123l;
	}

	@Override
	public void setId(final Long id) {}

	@Override
	public String getType() {
		return "image/png";
	}

	@Override
	public void setType(final String type) {}

}
