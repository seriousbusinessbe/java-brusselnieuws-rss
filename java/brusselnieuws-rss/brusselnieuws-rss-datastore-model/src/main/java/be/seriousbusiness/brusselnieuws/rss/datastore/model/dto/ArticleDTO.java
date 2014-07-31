package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.util.Set;

/**
 * Represents a DTO (data transfer object) responsible for article information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 */
public interface ArticleDTO extends IdDTO<Long> {
	
	/**
	 * Get the title
	 * @return title
	 */
	String getTitle();
	
	/**
	 * Set a title
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Get the URL location of this article. 
	 * @return <code>String</code> URL location
	 */
	String getLink();
	
	/**
	 * Set the URL location of this article
	 * @param link <code>String</code> URL location
	 */
	void setLink(String link);
	
	/**
	 * Get the description
	 * @return description
	 */
	String getDescription();
	
	/**
	 * Set a description
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Get the publication date of elapsed milliseconds since midnight, January 1, 1970 UTC and the moment of publication.
	 * @return the difference, measured in milliseconds, between the publication time and midnight, January 1, 1970 UTC
	 */
	long getPublicationDate();
	
	/**
	 * Set the publication date of elapsed milliseconds since midnight, January 1, 1970 UTC.
	 * @param publicationDate in milliseconds since 01/01/1970 UTC
	 */
	void setPublicationDate(final long publicationDate);
	
	/**
	 * Check if this article is read or not.
	 * @return <code>true</code> when read
	 */
	boolean isRead();
	
	/**
	 * Set if the article is read or not.
	 * @param read <code>true</code> when read
	 */
	void setRead(final boolean read);
	
	/**
	 * Check if this article is archived or not.
	 * @return <code>true</code> when archived
	 */
	boolean isArchived();
	
	/**
	 * Set if the article is archived or not.
	 * @param archived <code>true</code> when archived
	 */
	void setArchived(final boolean archived);
	
	/**
	 * Check if this article is marked favorite or not.
	 * @return <code>true</code> when a favorite
	 */
	boolean isFavorite();
	
	/**
	 * Set if the article is a favorite or not.
	 * @param favorite <code>true</code> when favorite
	 */
	void setFavorite(final boolean favorite);
	
	/**
	 * Get all attached {@link MediumDTO}(s)
	 * @return a Set of {@link MediumDTO}
	 */
	Set<MediumDTO> getMediumDTOs();
	
	/**
	 * Set all attached {@link MediumDTO}(s).
	 * @param mediumDTOs a Set of {@link MediumDTO}
	 */
	void setMediumDTOs(final Set<MediumDTO> mediumDTOs);
	
	/**
	 * Get all attached {@link CategoryDTO}(s).
	 * @return a Set of {@link CategoryDTO}
	 */
	Set<CategoryDTO> getCategoryDTOs();
	
	/**
	 * Set all attached {@link CategoryDTO}(s).
	 * @param categoryDTOs a Set of {@link CategoryDTO}
	 */
	void setCategoryDTOs(final Set<CategoryDTO> categoryDTOs);
	
	/**
	 * Get all attached {@link AuthorDTO}(s).
	 * @return a Set of {@link AuthorDTO}
	 */ 
	Set<AuthorDTO> getAuthorDTOs();
	
	/**
	 * Set all attached {@link AuthorDTO}(s).
	 * @param authorDTOs a Set of {@link AuthorDTO}
	 */
	void setAuthorDTOs(final Set<AuthorDTO> authorDTOs);

}
