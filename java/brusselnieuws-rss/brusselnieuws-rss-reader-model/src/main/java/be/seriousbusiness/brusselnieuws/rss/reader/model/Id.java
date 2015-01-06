package be.seriousbusiness.brusselnieuws.rss.reader.model;

/**
 * Represents a unique {@link ID} (identifier).
 * @author stefanborghys
 * @param <ID>
 */
public interface Id<ID> {
	
	/**
	 * Get the unique id.
	 * @return unique id or <code>null</code> when not yet set
	 */
	ID getId();
	
	/**
	 * Set a unique id.
	 * @param id
	 */
	void setId(final ID id);

}
