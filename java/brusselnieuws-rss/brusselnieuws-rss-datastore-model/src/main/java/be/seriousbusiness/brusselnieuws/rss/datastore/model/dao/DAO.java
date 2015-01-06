package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;

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
	 * @return the saved {@link DTO}
	 * @throws NotUniqueException when the given {@link DTO} is not unique
	 */
	DTO save(final DTO dto) throws NotUniqueException;
	
	/**
	 * Retrieve all stored {@link DTO} entities.
	 * @return a {@link Collection} of {@link DTO}
	 */
	Collection<DTO> findAll();
	
	/**
	 * Delete an existing {@link DTO}.
	 * @param dto the {@link DTO} to delete
	 */
	void delete(final DTO dto);

}
