package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for id information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 * @param <ID> the id type
 */
public interface IdDTO<ID> {
	
	/**
	 * Get the unique id.
	 * @return unique id
	 */
	ID getId();
	
	/**
	 * Set a unique id.
	 * @param id
	 */
	void setId(final ID id);

}
