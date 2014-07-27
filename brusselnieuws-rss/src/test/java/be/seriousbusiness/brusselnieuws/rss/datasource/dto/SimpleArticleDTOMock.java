package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

public class SimpleArticleDTOMock implements ArticleDTO {
	private DateTime now=DateTime.now();

	@Override
	public Long getId() {
		return 13141516l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getTitle() {
		return "simple article dto mock";
	}

	@Override
	public void setTitle(String title) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/nieuws/500-mensen-op-pro-israelbetoging";
	}

	@Override
	public void setLink(String link) {}

	@Override
	public String getDescription() {
		return "Simple article dto mock description";
	}

	@Override
	public void setDescription(String description) {}

	@Override
	public long getPublicationDate() {
		return now.getMillis();
	}

	@Override
	public void setPublicationDate(long publicationDate) {}

	@Override
	public boolean isRead() {
		return false;
	}

	@Override
	public void setRead(boolean read) {}

	@Override
	public boolean isArchived() {
		return false;
	}

	@Override
	public void setArchived(boolean archived) {}

	@Override
	public boolean isFavorite() {
		return false;
	}

	@Override
	public void setFavorite(boolean favorite) {}

	@Override
	public Set<MediumDTO> getMediumDTOs() {
		return new HashSet<MediumDTO>();
	}

	@Override
	public void setMediumDTOs(Set<MediumDTO> mediumDTOs) {}

	@Override
	public Set<CategoryDTO> getCategoryDTOs() {
		return new HashSet<CategoryDTO>();
	}

	@Override
	public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs) {}

	@Override
	public Set<AuthorDTO> getAuthorDTOs() {
		return new HashSet<AuthorDTO>();
	}

	@Override
	public void setAuthorDTOs(Set<AuthorDTO> authorDTOs) {}

}
