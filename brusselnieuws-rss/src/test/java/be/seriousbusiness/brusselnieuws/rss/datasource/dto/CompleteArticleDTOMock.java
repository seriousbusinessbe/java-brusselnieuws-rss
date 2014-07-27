package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

public class CompleteArticleDTOMock implements ArticleDTO {
	private final DateTime publicationDate=DateTime.now();
	private final Set<MediumDTO> mediumDTOs;
	private final Set<CategoryDTO> categoryDTOs;
	private final Set<AuthorDTO> authorDTOs;
	
	public CompleteArticleDTOMock(){
		mediumDTOs=new HashSet<MediumDTO>();
		mediumDTOs.add(new SimpleJpegMediumDTOMock());
		mediumDTOs.add(new SimplePngMediumDTOMock());
		categoryDTOs=new HashSet<CategoryDTO>();
		categoryDTOs.add(new SimpleSamenlevingCategoryDTOMock());
		categoryDTOs.add(new SimpleArtikelCategoryDTOMock());
		authorDTOs=new HashSet<AuthorDTO>();
		authorDTOs.add(new SimpleAuthorDTOMock());
		authorDTOs.add(new SimpleBrusselNieuwsAuthorDTOMock());
	}

	@Override
	public Long getId() {
		return 17181920l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getTitle() {
		return "complete article dto mock";
	}

	@Override
	public void setTitle(String title) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/nieuws/sportcomplex-nationale-bank-open-vanaf-september";
	}

	@Override
	public void setLink(String link) {}

	@Override
	public String getDescription() {
		return "Complete article dto mock description";
	}

	@Override
	public void setDescription(String description) {}

	@Override
	public long getPublicationDate() {
		return publicationDate.getMillis();
	}

	@Override
	public void setPublicationDate(long publicationDate) {}

	@Override
	public boolean isRead() {
		return true;
	}

	@Override
	public void setRead(boolean read) {}

	@Override
	public boolean isArchived() {
		return true;
	}

	@Override
	public void setArchived(boolean archived) {}

	@Override
	public boolean isFavorite() {
		return true;
	}

	@Override
	public void setFavorite(boolean favorite) {}

	@Override
	public Set<MediumDTO> getMediumDTOs() {
		return mediumDTOs;
	}

	@Override
	public void setMediumDTOs(Set<MediumDTO> mediumDTOs) {}

	@Override
	public Set<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}

	@Override
	public void setCategoryDTOs(Set<CategoryDTO> categoryDTOs) {}

	@Override
	public Set<AuthorDTO> getAuthorDTOs() {
		return authorDTOs;
	}

	@Override
	public void setAuthorDTOs(Set<AuthorDTO> authorDTOs) {}

}
