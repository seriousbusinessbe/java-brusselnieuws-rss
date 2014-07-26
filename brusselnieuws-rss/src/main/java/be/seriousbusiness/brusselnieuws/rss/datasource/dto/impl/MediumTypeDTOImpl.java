package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.MediumTypeDTO;

public class MediumTypeDTOImpl extends DTOImpl<Long> implements MediumTypeDTO {
	private String type;

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(final String type) {
		this.type = type;
	}

}
