package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;

/**
 * Describes the base functionality of a DAO (Data Access Object)</br>
 * responsible for the storage and retrieval of DTO(s) (Data Transfer Object(s)) in a datastore.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <DTO> the type of DTO
 */
public interface DAO<DTO> {
	
	/**
	 * Stores new or updates existing {@link DTO}.</br>
	 * A new, unique identifier is set if none is provided.</br>
	 * Which denotes the {@link DTO} is new and non existing.
	 * @param dto the {@link DTO} to store
	 * @return the saved {@link DTO} containing updated data 
	 * @throws NotUniqueException when the given {@link DTO} is not unique
	 */
	DTO save(final DTO dto) throws NotUniqueException;
	
	/**
	 * Retrieves all stored {@link DTO} entities.
	 * @return a {@link Collection} of {@link DTO}
	 */
	Collection<DTO> findAll();
	
	/**
	 * Deletes an existing {@link DTO}.</br>
	 * When not found no action is performed.
	 * @param dto the {@link DTO} to delete
	 */
	void delete(final DTO dto);

}
