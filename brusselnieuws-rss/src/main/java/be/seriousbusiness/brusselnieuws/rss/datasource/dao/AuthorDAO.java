package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.AuthorDTO;

public interface AuthorDAO extends IdDAO<AuthorDTO,Long> {
	
	AuthorDTO findByName(final String name);
	
}
