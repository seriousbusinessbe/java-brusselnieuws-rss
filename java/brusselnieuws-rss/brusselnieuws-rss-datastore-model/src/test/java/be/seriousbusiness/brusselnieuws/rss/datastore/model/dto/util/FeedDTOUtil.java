package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import java.math.BigInteger;
import java.util.List;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.FeedDTO;

/**
 * {@link FeedDTO} test helper methods. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedDTOUtil {
	
	/**
	 * Asserts two {@link FeedDTO} for equality.
	 * @param feedDTOA the first {@link FeedDTO}
	 * @param feedDTOB the second {@link FeedDTO}
	 */
	@SuppressWarnings("unchecked")
	public static final void assertEquals(final FeedDTO<?,?,?,?,?> feedDTOA,final FeedDTO<?,?,?,?,?> feedDTOB) {
		Assert.assertNotNull("FeedDTO A cannot be null",feedDTOA);
		Assert.assertNotNull("FeedDTO B cannot be null",feedDTOB);
		Assert.assertEquals("The FeedDTO ids are not equal",feedDTOA.getId(), feedDTOB.getId());
		Assert.assertEquals("The FeedDTO titles are not equal",feedDTOA.getTitle(), feedDTOB.getTitle());
		Assert.assertEquals("The FeedDTO descriptions are not equal",feedDTOA.getDescription(), feedDTOB.getDescription());
		Assert.assertEquals("The FeedDTO links are not equal",feedDTOA.getLink(), feedDTOB.getLink());
		assertEqualsArticleDTOList((List<ArticleDTO<?,?,?,?>>)feedDTOA.getArticleDTOs(),(List<ArticleDTO<?,?,?,?>>)feedDTOB.getArticleDTOs());
	}
	
	private static final void assertEqualsArticleDTOList(final List<ArticleDTO<?,?,?,?>> feedDTOAArticleDTOs,final List<ArticleDTO<?,?,?,?>> feedDTOBArticleDTOs){
		Assert.assertNotNull("FeedDTO A List of ArticleDTO cannot be null",feedDTOAArticleDTOs);
		Assert.assertNotNull("FeedDTO B List of ArticleDTO cannot be null",feedDTOBArticleDTOs);
		int numberOfAsserted=0;
		for(final ArticleDTO<?,?,?,?> feedDTOAArticleDTO : feedDTOAArticleDTOs){
			final BigInteger feedDTOAArticleDTOId=feedDTOAArticleDTO.getId();
			for(final ArticleDTO<?,?,?,?> feedDTOBArticleDTO : feedDTOBArticleDTOs){
				if(feedDTOBArticleDTO.getId()==feedDTOAArticleDTOId){
					ArticleDTOUtil.assertEquals(feedDTOAArticleDTO, feedDTOBArticleDTO);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("FeedDTO A List of ArticleDTO is not equal",feedDTOAArticleDTOs.size(),numberOfAsserted);
		Assert.assertEquals("FeedDTO B List of ArticleDTO is not equal",feedDTOBArticleDTOs.size(),numberOfAsserted);
	}

}
