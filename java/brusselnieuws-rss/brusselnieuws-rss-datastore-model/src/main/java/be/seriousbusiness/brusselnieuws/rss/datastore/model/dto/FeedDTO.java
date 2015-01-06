package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Represents a DTO (data transfer object) responsible for feed information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 * @param <MEDIUMTYPEDTO> the type of {@link MediumTypeDTO} implementation
 * @param <MEDIUM> the type of {@link MediumDTO} implementation
 * @param <CATEGORYDTO> the type of {@link CategoryDTO} implementation
 * @param <AUTHORDTO> the type of {@link AuthorDTO} implementation
 * @param <ARTICLEDTO> the type of {@link ArticleDTO} implementation
 */
public interface FeedDTO<MEDIUMTYPEDTO extends MediumTypeDTO,
						MEDIUM extends MediumDTO<MEDIUMTYPEDTO>,
						CATEGORYDTO extends CategoryDTO,
						AUTHORDTO extends AuthorDTO,
						ARTICLEDTO extends ArticleDTO<MEDIUMTYPEDTO,MEDIUM,CATEGORYDTO,AUTHORDTO>> extends IdDTO<BigInteger> {
	
	/**
	 * Get the feed's title.
	 * @return title, <code>null</code> when not set
	 */
	String getTitle();
	
	/**
	 * Set a title
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Get the URL host location of this feed.
	 * @return <code>String</code> URL location, <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Set the URL host location of this feed.
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);
	
	/**
	 * Get the description.
	 * @return description, <code>null</code> when not set
	 */
	String getDescription();
	
	/**
	 * Set a description.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Get all published {@link ARTICLEDTO}(s)
	 * @return a {@link Collection} of {@link ARTICLEDTO}, <code>null</code> when not set
	 */
	Collection<ARTICLEDTO> getArticleDTOs();
	
	/**
	 * Set all published {@link ArticleDTO}(s)
	 * @param articleDTOs a {@link Collection} of {@link ArticleDTO}
	 */
	void setArticleDTOs(final Collection<ARTICLEDTO> articleDTOs);

}
