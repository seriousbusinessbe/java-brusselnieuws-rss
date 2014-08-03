package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for author information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 */
public interface AuthorDTO extends IdDTO<Long> {
	
	/**
	 * Get the author's name
	 * @return author name, <code>null</code> when not set
	 */
	String getName();
	
	/**
	 * Set an author name
	 * @param name
	 */
	void setName(final String name);

}
