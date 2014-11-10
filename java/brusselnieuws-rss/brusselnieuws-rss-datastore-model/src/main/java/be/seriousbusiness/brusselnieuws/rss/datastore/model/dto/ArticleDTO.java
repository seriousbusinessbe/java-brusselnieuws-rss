package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;
import java.util.List;

/**
 * Represents a DTO (data transfer object) responsible for article information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 * @param <MEDIUMTYPEDTO> the type of {@link MediumTypeDTO} implementation
 * @param <MEDIUMDTO> the type of {@link MediumDTO} implementation
 * @param <CATEGORYDTO> the type of {@link CategoryDTO} implementation
 * @param <AUTHORDTO> the type of {@link AuthorDTO} implementation
 */
public interface ArticleDTO<MEDIUMTYPEDTO extends MediumTypeDTO,
							MEDIUMDTO extends MediumDTO<MEDIUMTYPEDTO>,
							CATEGORYDTO extends CategoryDTO,
							AUTHORDTO extends AuthorDTO> extends IdDTO<BigInteger> {
	
	/**
	 * Get the title
	 * @return title, <code>null</code> when not set
	 */
	String getTitle();
	
	/**
	 * Set a title
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Get the URL location of this article. 
	 * @return <code>String</code> URL location, <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Set the URL location of this article
	 * @param link <code>String</code> URL location
	 */
	void setLink(String link);
	
	/**
	 * Get the description
	 * @return description, <code>null</code> when not set
	 */
	String getDescription();
	
	/**
	 * Set a description
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Get the publication date of elapsed milliseconds since midnight, January 1, 1970 UTC and the moment of publication.
	 * @return the difference, measured in milliseconds, between the publication time and midnight, January 1, 1970 UTC</br>
	 * <code>null</code> when not set
	 */
	Long getPublicationDate();
	
	/**
	 * Set the publication date of elapsed milliseconds since midnight, January 1, 1970 UTC.
	 * @param publicationDate in milliseconds since 01/01/1970 UTC
	 */
	void setPublicationDate(final Long publicationDate);
	
	/**
	 * Check if this article is read or not.
	 * @return <code>true</code> when read
	 */
	Boolean isRead();
	
	/**
	 * Set if the article is read or not.
	 * @param read <code>true</code> when read
	 */
	void setRead(final Boolean read);
	
	/**
	 * Get if the article is read or not.
	 * @return <code>true</code> when read
	 */
	Boolean getRead();
	
	/**
	 * Check if this article is archived or not.
	 * @return <code>true</code> when archived
	 */
	Boolean isArchived();
	
	/**
	 * Set if the article is archived or not.
	 * @param archived <code>true</code> when archived
	 */
	void setArchived(final Boolean archived);
	
	/**
	 * Get if the article is archived or not.
	 * @return <code>true</code> when archived
	 */
	Boolean getArchived();
	
	/**
	 * Check if this article is marked favorite or not.
	 * @return <code>true</code> when a favorite
	 */
	Boolean isFavorite();
	
	/**
	 * Set if the article is a favorite or not.
	 * @param favorite <code>true</code> when favorite
	 */
	void setFavorite(final Boolean favorite);
	
	/**
	 * Get if the article is a favorite or not.
	 * @return <code>true</code> when favorite
	 */
	Boolean getFavorite();
	
	/**
	 * Get all attached {@link MEDIUMDTO}(s)
	 * @return a List of {@link MEDIUMDTO}, <code>null</code> when not set
	 */
	List<MEDIUMDTO> getMediumDTOs();
	
	/**
	 * Set all attached {@link MEDIUMDTO}(s).
	 * @param mediumDTOs a List of {@link MEDIUMDTO}
	 */
	void setMediumDTOs(final List<MEDIUMDTO> mediumDTOs);
	
	/**
	 * Get all attached {@link CATEGORYDTO}(s).
	 * @return a List of {@link CATEGORYDTO}, <code>null</code> when not set
	 */
	List<CATEGORYDTO> getCategoryDTOs();
	
	/**
	 * Set all attached {@link CATEGORYDTO}(s).
	 * @param categoryDTOs a List of {@link CATEGORYDTO}
	 */
	void setCategoryDTOs(final List<CATEGORYDTO> categoryDTOs);
	
	/**
	 * Get all attached {@link AuthorDTO}(s).
	 * @return a List of {@link AuthorDTO}, <code>null</code> when not set
	 */ 
	List<AUTHORDTO> getAuthorDTOs();
	
	/**
	 * Set all attached {@link AUTHORDTO}(s).
	 * @param authorDTOs a List of {@link AUTHORDTO}
	 */
	void setAuthorDTOs(final List<AUTHORDTO> authorDTOs);

}
