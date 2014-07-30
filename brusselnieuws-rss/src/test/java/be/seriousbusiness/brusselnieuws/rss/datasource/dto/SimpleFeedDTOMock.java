package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import java.util.HashSet;
import java.util.Set;

public class SimpleFeedDTOMock implements FeedDTO {

	@Override
	public Long getId() {
		return 11223344l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getTitle() {
		return "BrusselNieuws RSS - Awel merci";
	}

	@Override
	public void setTitle(String title) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/rubriek/4801/feed";
	}

	@Override
	public void setLink(String link) {}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Simple feed dto mock description";
	}

	@Override
	public void setDescription(String description) {}

	@Override
	public Set<ArticleDTO> getArticleDTOs() {
		return new HashSet<ArticleDTO>();
	}

	@Override
	public void setArticleDTOs(Set<ArticleDTO> articleDTOs) {}

}
