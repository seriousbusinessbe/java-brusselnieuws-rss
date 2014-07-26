package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

import java.util.Set;

public interface DAO<DTO> {
	
	void save(final DTO dto);
	Set<DTO> findAll();

}
