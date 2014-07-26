package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import java.util.Set;

public interface FeedDTO extends DTO<Long> {
	
	String getTitle();
	void setTitle(final String title);
	String getLink();
	void setLink(final String link);
	String getDescription();
	void setDescription(final String description);
	Set<ArticleDTO> getArticleDTOs();
	void setArticleDTOs(final Set<ArticleDTO> articleDTOs);
	
}
