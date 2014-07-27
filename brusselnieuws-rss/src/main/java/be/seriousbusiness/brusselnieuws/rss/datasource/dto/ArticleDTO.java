package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import java.util.Set;

public interface ArticleDTO extends DTO<Long> {
	
	String getTitle();
	void setTitle(final String title);
	String getLink();
	void setLink(String link);
	String getDescription();
	void setDescription(final String description);
	long getPublicationDate();
	void setPublicationDate(final long publicationDate);
	boolean isRead();
	void setRead(final boolean read);
	boolean isArchived();
	void setArchived(final boolean archived);
	boolean isFavorite();
	void setFavorite(final boolean favorite);
	Set<MediumDTO> getMediumDTOs();
	void setMediumDTOs(final Set<MediumDTO> mediumDTOs);
	Set<CategoryDTO> getCategoryDTOs();
	void setCategoryDTOs(final Set<CategoryDTO> categoryDTOs);
	Set<AuthorDTO> getAuthorDTOs();
	void setAuthorDTOs(final Set<AuthorDTO> authorDTOs);

}
