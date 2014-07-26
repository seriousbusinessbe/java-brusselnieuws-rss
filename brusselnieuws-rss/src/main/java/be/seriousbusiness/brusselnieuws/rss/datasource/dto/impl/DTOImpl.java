package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.DTO;

public class DTOImpl<ID> implements DTO<ID> {
	private ID id;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(final ID id) {
		this.id = id;
	}
	
}
