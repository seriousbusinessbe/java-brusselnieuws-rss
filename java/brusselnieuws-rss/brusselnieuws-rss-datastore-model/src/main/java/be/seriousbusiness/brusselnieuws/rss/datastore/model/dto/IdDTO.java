package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for identifier information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID> the type of id
 */
public interface IdDTO<ID> extends Cloneable {
	
	/**
	 * Gets the unique {@link ID} identifier.
	 * @return unique {@link ID} or <code>null</code> when not set
	 */
	ID getId();
	
	/**
	 * Sets the {@link ID} identifier.
	 * @param id new or existing identifier
	 */
	void setId(final ID id);

}
