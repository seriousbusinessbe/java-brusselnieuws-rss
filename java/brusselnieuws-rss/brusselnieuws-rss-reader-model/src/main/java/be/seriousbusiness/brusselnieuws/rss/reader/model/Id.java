package be.seriousbusiness.brusselnieuws.rss.reader.model;

/**
 * Represents a unique {@link ID} (identifier).
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID> the type of identifier 
 */
public interface Id<ID> {
	
	/**
	 * Gets the unique identifier.
	 * @return unique identifier or <code>null</code> when not yet set
	 */
	ID getId();
	
	/**
	 * Sets a unique identifier.
	 * @param id the unique identifier
	 */
	void setId(final ID id);

}
