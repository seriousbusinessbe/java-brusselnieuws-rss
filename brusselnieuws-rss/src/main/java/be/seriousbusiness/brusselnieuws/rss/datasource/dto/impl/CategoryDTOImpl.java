package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.CategoryDTO;

public class CategoryDTOImpl extends DTOImpl<Long> implements CategoryDTO {
	private String name,link;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link = link;
	}

}
