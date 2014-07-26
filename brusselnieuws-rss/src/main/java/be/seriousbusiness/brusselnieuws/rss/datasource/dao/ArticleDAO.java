package be.seriousbusiness.brusselnieuws.rss.datasource.dao;

import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.ArticleDTO;

public interface ArticleDAO extends IdDAO<ArticleDTO,Long> {
	
	ArticleDTO findByLink(final String link);
	Set<ArticleDTO> findByRead(final boolean read);
	Set<ArticleDTO> findByArchived(final boolean archived);
	Set<ArticleDTO> findByFavorite(final boolean favorite);

}
