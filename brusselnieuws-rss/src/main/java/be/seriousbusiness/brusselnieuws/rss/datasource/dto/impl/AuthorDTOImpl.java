package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.AuthorDTO;

public class AuthorDTOImpl extends DTOImpl<Long> implements AuthorDTO {
	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

}
