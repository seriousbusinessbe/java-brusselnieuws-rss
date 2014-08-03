package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

public class IdDTOImpl<ID> implements IdDTO<ID> {
	private ID id;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(ID id) {
		this.id=id;
	}

}
