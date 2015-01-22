package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Represents a DTO (data transfer object) responsible for article information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
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
	 * Gets the title.
	 * @return title, <code>null</code> when not set
	 */
	String getTitle();
	
	/**
	 * Sets the title.
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Gets the URL location of this article. 
	 * @return <code>String</code> URL location or <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Sets the URL location of this article
	 * @param link <code>String</code> URL location
	 */
	void setLink(String link);
	
	/**
	 * Gets the description.
	 * @return description or <code>null</code> when not set
	 */
	String getDescription();
	
	/**
	 * Sets the description.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Gets the publication date expressed as the number of elapsed milliseconds since midnight, January 1, 1970 UTC and the moment of publication.
	 * @return the difference, measured in milliseconds, between the publication time and midnight, January 1, 1970 UTC</br>
	 * 		   or <code>null</code> when not set
	 */
	Long getPublicationDate();
	
	/**
	 * Sets the publication date as the number of elapsed milliseconds since midnight, January 1, 1970 UTC.
	 * @param publicationDate in milliseconds since 01/01/1970 UTC
	 */
	void setPublicationDate(final Long publicationDate);
	
	/**
	 * Checks if this article is marked read or not.
	 * @return <code>true</code> when marked read, otherwise <code>false</code>
	 */
	Boolean isRead();
	
	/**
	 * Marks this article read or not.
	 * @param read <code>true</code> when read or <code>false</code> when not
	 */
	void setRead(final Boolean read);
	
	/**
	 * Checks if this article is marked read or not.
	 * @return <code>true</code> when marked read, otherwise <code>false</code>
	 */
	Boolean getRead();
	
	/**
	 * Checks if this article is marked archived or not.
	 * @return <code>true</code> when archived, otherwise <code>false</code>
	 */
	Boolean isArchived();
	
	/**
	 * Mark this article archived or not.
	 * @param archived <code>true</code> when archived or <code>false</code> when not
	 */
	void setArchived(final Boolean archived);
	
	/**
	 * Checks if this article is marked archived or not.
	 * @return <code>true</code> when archived, otherwise <code>false</code>
	 */
	Boolean getArchived();
	
	/**
	 * Check if this article is marked favorite or not.
	 * @return <code>true</code> when marked favorite, othrwise <code>false</code>
	 */
	Boolean isFavorite();
	
	/**
	 * Mark this article favorite or not.
	 * @param favorite <code>true</code> when favorite
	 */
	void setFavorite(final Boolean favorite);
	
	/**
	 * Check if this article is marked favorite or not.
	 * @return <code>true</code> when favorite, otherwise <code>false</code>
	 */
	Boolean getFavorite();
	
	/**
	 * Gets all attached {@link MEDIUMDTO}(s).
	 * @return a {@link Collection} of {@link MEDIUMDTO} or <code>null</code> when not set
	 */
	Collection<MEDIUMDTO> getMediumDTOs();
	
	/**
	 * Sets all attached {@link MEDIUMDTO}(s).
	 * @param mediumDTOs a {@link Collection} of {@link MEDIUMDTO}
	 */
	void setMediumDTOs(final Collection<MEDIUMDTO> mediumDTOs);
	
	/**
	 * Gets all attached {@link CATEGORYDTO}(s).
	 * @return a {@link Collection} of {@link CATEGORYDTO} or <code>null</code> when not set
	 */
	Collection<CATEGORYDTO> getCategoryDTOs();
	
	/**
	 * Sets all attached {@link CATEGORYDTO}(s).
	 * @param categoryDTOs a {@link Collection} of {@link CATEGORYDTO}
	 */
	void setCategoryDTOs(final Collection<CATEGORYDTO> categoryDTOs);
	
	/**
	 * Gets all attached {@link AuthorDTO}(s).
	 * @return a {@link Collection} of {@link AuthorDTO} or <code>null</code> when not set
	 */ 
	Collection<AUTHORDTO> getAuthorDTOs();
	
	/**
	 * Sets all attached {@link AUTHORDTO}(s).
	 * @param authorDTOs a {@link Collection} of {@link AUTHORDTO}
	 */
	void setAuthorDTOs(final Collection<AUTHORDTO> authorDTOs);

}
