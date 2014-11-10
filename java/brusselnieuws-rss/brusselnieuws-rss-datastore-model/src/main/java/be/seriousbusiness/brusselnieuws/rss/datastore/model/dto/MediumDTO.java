package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

/**
 * Represents a DTO (data transfer object) responsible for medium information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 * 
 * @param <MEDIUMTYPEDTO> the {@link MediumTypeDTO} implementation
 */
public interface MediumDTO<MEDIUMTYPEDTO extends MediumTypeDTO> {
	
	/**
	 * Get the URL location of this medium. 
	 * @return <code>String</code> URL location, <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Set an URL medium storage location
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);
	
	/**
	 * Get the {@link MEDIUMTYPEDTO} implementation which represents the type medium.
	 * @return the type of medium, <code>null</code> when not set
	 */
	MEDIUMTYPEDTO getMediumTypeDTO();
	
	/**
	 * Set the type of medium.
	 * @param mediumTypeDTO
	 */
	void setMediumTypeDTO(final MEDIUMTYPEDTO mediumTypeDTO);
	
	/**
	 * Get the size expressed in bytes
	 * @return number of bytes, <code>null</code> when not set
	 */
	Long getSize();
	
	/**
	 * Set a size in bytes
	 * @param size number of bytes
	 */
	void setSize(final Long size);

}
