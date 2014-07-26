package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datasource.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datasource.dto.CategoryDTO;

public class ArticleDTOImpl extends DTOImpl<Long> implements ArticleDTO {
	private String title,link,description;
	private long publicationDate;
	private boolean read,archived,favorite;
	private Set<MediumDTOImpl> mediumDTOs;
	private Set<CategoryDTO> categoryDTOs;
	private Set<AuthorDTO> authorDTOs;
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(final String title) {
		this.title = title;
	}
	
	@Override
	public String getLink() {
		return link;
	}
	
	@Override
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(final String description) {
		this.description = description;
	}
	
	@Override
	public long getPublicationDate() {
		return publicationDate;
	}
	
	@Override
	public void setPublicationDate(final long publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public boolean isRead() {
		return read;
	}
	
	@Override
	public void setRead(final boolean read) {
		this.read = read;
	}
	
	@Override
	public boolean isArchived() {
		return archived;
	}
	
	@Override
	public void setArchived(final boolean archived) {
		this.archived = archived;
	}
	
	@Override
	public boolean isFavorite() {
		return favorite;
	}
	
	@Override
	public void setFavorite(final boolean favorite) {
		this.favorite = favorite;
	}
	
	@Override
	public Set<MediumDTOImpl> getMediumDTOs() {
		return mediumDTOs;
	}
	
	@Override
	public void setMediumDTOs(final Set<MediumDTOImpl> mediumDTOs) {
		this.mediumDTOs = mediumDTOs;
	}
	
	@Override
	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}
	
	@Override
	public void setCategoryDTOs(final Set<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
	}
	
	@Override
	public Set<AuthorDTO> getAuthorDTOs() {
		return authorDTOs;
	}
	
	@Override
	public void setAuthorDTOs(final Set<AuthorDTO> authorDTOs) {
		this.authorDTOs = authorDTOs;
	}

}
