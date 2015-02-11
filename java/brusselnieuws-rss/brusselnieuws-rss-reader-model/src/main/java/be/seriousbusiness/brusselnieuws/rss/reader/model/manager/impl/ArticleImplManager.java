package be.seriousbusiness.brusselnieuws.rss.reader.model.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.ArticleDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.ArticlePublicationDateComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.manager.ArticleManager;

public class ArticleImplManager implements ArticleManager<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,ArticleImpl> {
	private ArticleDAO articleDAO;
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssReaderModelDozerBeanMapper")
	private Mapper mapper;
	private static final Comparator<Article<?,?,?,?>> ARTICLE_COMPARATOR=new ArticlePublicationDateComparator();

	@Override
	public Collection<ArticleImpl> findAll() {
		final List<ArticleImpl> articles=new ArrayList<ArticleImpl>();
		final Collection<ArticleDTOImpl> articleDTOImpls=articleDAO.findAll();
		if(articleDTOImpls!=null){
			for(final ArticleDTOImpl articleDTOImpl : articleDTOImpls){
				final ArticleImpl article=mapper.map(articleDTOImpl, ArticleImpl.class);
				articles.add(article);
			}
		}
		Collections.sort(articles,ARTICLE_COMPARATOR);
		return articles;
	}
	
	public void setArticleDAO(final ArticleDAO articleDAO){
		this.articleDAO=articleDAO;
	}

}
