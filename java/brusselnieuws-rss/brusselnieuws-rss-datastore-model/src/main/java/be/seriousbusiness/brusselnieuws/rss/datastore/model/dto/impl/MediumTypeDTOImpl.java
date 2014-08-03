package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumTypeDTOImpl extends IdDTOImpl<Long> implements MediumTypeDTO {
	private String type;

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(final String type) {
		this.type=type;
	}

}
