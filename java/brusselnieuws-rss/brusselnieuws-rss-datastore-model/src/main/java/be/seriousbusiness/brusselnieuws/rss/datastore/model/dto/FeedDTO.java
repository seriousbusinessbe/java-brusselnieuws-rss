package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.util.Set;

/**
 * Represents a DTO (data transfer object) responsible for feed information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 */
public interface FeedDTO extends IdDTO<Long> {
	
	/**
	 * Get the feed's title.
	 * @return title
	 */
	String getTitle();
	
	/**
	 * Set a title
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Get the URL host location of this feed.
	 * @return <code>String</code> URL location
	 */
	String getLink();
	
	/**
	 * Set the URL host location of this feed.
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);
	
	/**
	 * Get the description.
	 * @return description
	 */
	String getDescription();
	
	/**
	 * Set a description.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Get all published {@link ArticleDTO}(s)
	 * @return a Set of {@link ArticleDTO}
	 */
	Set<ArticleDTO> getArticleDTOs();
	
	/**
	 * Set all published {@link ArticleDTO}(s)
	 * @param articleDTOs a Set of {@link ArticleDTO}
	 */
	void setArticleDTOs(final Set<ArticleDTO> articleDTOs);

}
