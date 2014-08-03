package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

public class AuthorDTOImpl extends IdDTOImpl<Long> implements AuthorDTO  {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name=name;
	}

}
