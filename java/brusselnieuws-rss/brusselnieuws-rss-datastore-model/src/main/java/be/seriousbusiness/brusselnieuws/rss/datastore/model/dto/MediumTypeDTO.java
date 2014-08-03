package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for medium type information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 */
public interface MediumTypeDTO extends IdDTO<Long> {
	
	/**
	 * Get the medium type representation.
	 * @return a <code>String</code> medium type representation, <code>null</code> when not set
	 */
	String getType();
	
	/**
	 * Set a medium type representation.
	 * @param type <code>String</code> medium type representation
	 */
	void setType(final String type);

}
