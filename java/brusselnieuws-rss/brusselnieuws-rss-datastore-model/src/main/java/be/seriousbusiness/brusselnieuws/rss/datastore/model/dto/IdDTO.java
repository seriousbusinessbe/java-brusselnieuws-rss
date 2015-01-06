package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for {@link ID} (identifier) information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 * @param <ID> the id type
 */
public interface IdDTO<ID> {
	
	/**
	 * Get the unique {@link ID}.
	 * @return unique {@link ID}, <code>null</code> when not set
	 */
	ID getId();
	
	/**
	 * Set a unique {@link ID}.
	 * @param id
	 */
	void setId(final ID id);

}
