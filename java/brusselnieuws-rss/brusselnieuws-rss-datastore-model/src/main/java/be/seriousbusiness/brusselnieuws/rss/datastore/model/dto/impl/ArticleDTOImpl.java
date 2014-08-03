package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

public class ArticleDTOImpl extends IdDTOImpl<Long> implements ArticleDTO {
	private String title,link,description;
	private Long publicationDate;
	private Boolean read,archived,favorite;
	private Set<MediumDTO> mediumDTOs;
	private Set<CategoryDTO> categoryDTOs;
	private Set<AuthorDTO> authorDTOs;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(final String title) {
		this.title=title;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		this.description=description;
	}

	@Override
	public Long getPublicationDate() {
		return publicationDate;
	}

	@Override
	public void setPublicationDate(final Long publicationDate) {
		this.publicationDate=publicationDate;
	}

	@Override
	public Boolean isRead() {
		return read;
	}

	@Override
	public void setRead(final Boolean read) {
		this.read=read;
	}

	@Override
	public Boolean isArchived() {
		return archived;
	}

	@Override
	public void setArchived(final Boolean archived) {
		this.archived=archived;
	}

	@Override
	public Boolean isFavorite() {
		return favorite;
	}

	@Override
	public void setFavorite(final Boolean favorite) {
		this.favorite=favorite;
	}

	@Override
	public Set<MediumDTO> getMediumDTOs() {
		return mediumDTOs;
	}

	@Override
	public void setMediumDTOs(final Set<MediumDTO> mediumDTOs) {
		this.mediumDTOs=mediumDTOs;
	}

	@Override
	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}

	@Override
	public void setCategoryDTOs(final Set<CategoryDTO> categoryDTOs) {
		this.categoryDTOs=categoryDTOs;
	}

	@Override
	public Set<AuthorDTO> getAuthorDTOs() {
		return authorDTOs;
	}

	@Override
	public void setAuthorDTOs(final Set<AuthorDTO> authorDTOs) {
		this.authorDTOs=authorDTOs;
	}

}
