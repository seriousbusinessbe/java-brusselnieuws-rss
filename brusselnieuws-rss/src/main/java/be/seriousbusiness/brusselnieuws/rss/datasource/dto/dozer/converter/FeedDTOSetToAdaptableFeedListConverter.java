package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableArticle;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableArticleImpl;

public class FeedDTOSetToAdaptableFeedListConverter implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(FeedDTOSetToAdaptableFeedListConverter.class);
	@Autowired
	@Qualifier("dozerBeanMapper")
	private Mapper mapper;
	
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			LOGGER.debug("Converted Set<ArticleDTO> 'null' to empty List<AdaptableArticle>");
			return new ArrayList<AdaptableArticle>(0);
		}else{
			@SuppressWarnings("unchecked")
			final Set<ArticleDTO> articleDTOs=(Set<ArticleDTO>)sourceFieldValue;
			final List<AdaptableArticle> adaptableArticles=new ArrayList<AdaptableArticle>();
			for(final ArticleDTO articleDTO : articleDTOs){
				final AdaptableArticle adaptableArticle=new AdaptableArticleImpl();
				this.mapper.map(articleDTO,adaptableArticle);
				adaptableArticles.add(adaptableArticle);
			}
			LOGGER.debug("Converted Set<ArticleDTO> '{}' to List<AdaptableArticle> '{}'",articleDTOs,adaptableArticles);
			return adaptableArticles;
		}
	}

}
