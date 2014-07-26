package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.CategoryDTO;

public interface CategoryDAO extends IdDAO<CategoryDTO,Long> {
	
	CategoryDTO findByName(final String name);
	CategoryDTO findByLink(final String link);

}
