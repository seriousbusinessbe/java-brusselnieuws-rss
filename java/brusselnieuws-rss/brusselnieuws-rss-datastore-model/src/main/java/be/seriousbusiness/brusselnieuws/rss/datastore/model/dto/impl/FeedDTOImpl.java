package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

public class FeedDTOImpl extends IdDTOImpl<Long> implements FeedDTO {
	private String title,link,description;
	private Set<ArticleDTO> articleDTOs;

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
	public Set<ArticleDTO> getArticleDTOs() {
		return articleDTOs;
	}

	@Override
	public void setArticleDTOs(final Set<ArticleDTO> articleDTOs) {
		this.articleDTOs=articleDTOs;
	}

}