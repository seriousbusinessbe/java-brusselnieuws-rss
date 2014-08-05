package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

/**
 * Describes the base functionality of a DAO (Data Access Object)</br>
 * responsible for the storage and retrieval of DTO (Data Transfer Object) in a datastore.
 * @author stefanborghys
 *
 * @param <DTO> the type of DTO
 */
public interface DAO<DTO> {
	
	/**
	 * Store or update an existing {@link DTO}.</br>
	 * A new, unique identifier is set if none is provided.
	 * @param dto the {@link DTO} to store
	 */
	void save(final DTO dto);
	
	/**
	 * Retrieve all stored {@link DTO} entities.
	 * @return a List of {@link DTO}
	 */
	List<DTO> findAll();

}
