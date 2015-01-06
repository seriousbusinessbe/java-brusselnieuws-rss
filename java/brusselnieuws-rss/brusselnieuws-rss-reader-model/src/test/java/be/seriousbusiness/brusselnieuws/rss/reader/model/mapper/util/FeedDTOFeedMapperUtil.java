package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

public class FeedDTOFeedMapperUtil {
	
	/**
	 * Assert if a {@link FeedDTO} and {@link Feed} are equal.
	 * @param feedDTO
	 * @param feed
	 */
	public static final void assertEquals(final FeedDTO<?,?,?,?,?> feedDTO,final Feed<?,?,?,?,?> feed){		
		Assert.assertEquals("The ids are not equal",feedDTO.getId(),feed.getId());
		if(feedDTO.getDescription()!=null && feedDTO.getDescription().isEmpty()){
			Assert.assertNull("The descriptions is not null",feed.getDescription());
		}else{
			Assert.assertEquals("The descriptions are not equal",feedDTO.getDescription(),feed.getDescription());
		}
		Assert.assertEquals("The links are not equal",feedDTO.getLink(),feed.getLink().toString());
		Assert.assertEquals("The titles are not equal",feedDTO.getTitle(),feed.getTitle());
		// Articles:
		Assert.assertEquals("The articles are not equal",feedDTO.getArticleDTOs().size(),feed.getArticles().size());
		int i=0;
		for(final ArticleDTO<?,?,?,?> articleDTO : feedDTO.getArticleDTOs()){
			for(final Article<?,?,?,?> article : feed.getArticles()){
				if(articleDTO.getId().equals(article.getId())){
					ArticleDTOArticleMapperUtil.assertEquals(articleDTO, article);
					i++;
				}
			}
		}
		Assert.assertEquals("Not all articles are equal",feedDTO.getArticleDTOs().size(),i);
		Assert.assertEquals("Not all articles are equal",feed.getArticles().size(),i);
	}

}
