package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Represents a DTO (data transfer object) responsible for feed information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
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
						ARTICLEDTO extends ArticleDTO<MEDIUMTYPEDTO,MEDIUM,CATEGORYDTO,AUTHORDTO>> extends IdDTO<BigInteger>, Cloneable {
	
	/**
	 * Gets the title.
	 * @return title, <code>null</code> when not set
	 */
	String getTitle();
	
	/**
	 * Sets the title
	 * @param title
	 */
	void setTitle(final String title);
	
	/**
	 * Gets the URL host location of this feed.
	 * @return <code>String</code> URL location or <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Sets the URL host location of this feed.
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);
	
	/**
	 * Gets the description.
	 * @return description, <code>null</code> when not set
	 */
	String getDescription();
	
	/**
	 * Sets a description.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Gets all published {@link ARTICLEDTO}(s).
	 * @return a {@link Collection} of {@link ARTICLEDTO} or <code>null</code> when not set
	 */
	Collection<ARTICLEDTO> getArticleDTOs();
	
	/**
	 * Sets all published {@link ArticleDTO}(s) of this feed.
	 * @param articleDTOs a {@link Collection} of {@link ArticleDTO}
	 */
	void setArticleDTOs(final Collection<ARTICLEDTO> articleDTOs);
	
	/**
	 * Adds a unique non <code>null</code> {@link ARTICLEDTO}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param article
	 */
	void add(final ARTICLEDTO articleDTO);

}
