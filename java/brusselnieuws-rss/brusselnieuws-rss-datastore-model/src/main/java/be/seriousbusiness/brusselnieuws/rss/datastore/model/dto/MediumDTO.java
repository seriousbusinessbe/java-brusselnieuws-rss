package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for medium information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <MEDIUMTYPEDTO> the {@link MediumTypeDTO} implementation
 */
public interface MediumDTO<MEDIUMTYPEDTO extends MediumTypeDTO> {
	
	/**
	 * Gets the URL location. 
	 * @return <code>String</code> URL location or <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Sets the URL location
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);
	
	/**
	 * Gets the type of medium.
	 * @return the type of medium or <code>null</code> when not set
	 */
	MEDIUMTYPEDTO getMediumTypeDTO();
	
	/**
	 * Sets the type of medium.
	 * @param mediumTypeDTO {@link MEDIUMTYPEDTO
	 */
	void setMediumTypeDTO(final MEDIUMTYPEDTO mediumTypeDTO);
	
	/**
	 * Gets the size in bytes
	 * @return number of bytes or <code>null</code> when not set
	 */
	Long getSize();
	
	/**
	 * Sets the size in bytes
	 * @param size number of bytes
	 */
	void setSize(final Long size);

}
