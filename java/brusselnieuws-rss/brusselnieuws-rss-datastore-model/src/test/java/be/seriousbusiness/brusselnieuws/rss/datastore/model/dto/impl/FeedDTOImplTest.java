package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractFeedDTOTest;

/**
 * {@link FeedDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedDTOImplTest extends AbstractFeedDTOTest<MediumTypeDTOImpl,
														MediumDTOImpl,
														CategoryDTOImpl,
														AuthorDTOImpl,
														CreatorDTOImpl,
														ArticleDTOImpl,
														FeedDTOImpl> {

	public FeedDTOImplTest() {
		super(BigInteger.valueOf(111222333l),
				new ArrayList<ArticleDTOImpl>(),
				"",
				"http://www.brusselnieuws.be/nl/hoofdpunten/feed",
				"BrusselNieuws RSS - Hoofdpunten");
	}

	@Override
	public FeedDTOImpl create() {
		return new FeedDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCloneable() {
		FeedDTOImpl clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedFeedDTOImpl);
		clonedFeedDTOImpl.setDescription(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
		// ArticleImpl:
		clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		for(final ArticleDTOImpl articleDTOImpl : clonedFeedDTOImpl.getArticleDTOs()) {
			articleDTOImpl.setDescription(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
		// AuthorImpl:
		clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		for(final ArticleDTOImpl articleDTOImpl : clonedFeedDTOImpl.getArticleDTOs()) {
			for(final AuthorDTOImpl authorDTOImpl : articleDTOImpl.getAuthorDTOs()) {
				authorDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
		// CategoryImpl:
		clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		for(final ArticleDTOImpl articleDTOImpl : clonedFeedDTOImpl.getArticleDTOs()) {
			for(final CategoryDTOImpl categoryDTOImpl : articleDTOImpl.getCategoryDTOs()) {
				categoryDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
		// MediumImpl:
		clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		for(final ArticleDTOImpl articleDTOImpl : clonedFeedDTOImpl.getArticleDTOs()) {
			for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()) {
				mediumDTOImpl.setSize(System.currentTimeMillis());
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
		// MediumTypeImpl:
		clonedFeedDTOImpl=(FeedDTOImpl) getDTO().clone();
		for(final ArticleDTOImpl articleDTOImpl : clonedFeedDTOImpl.getArticleDTOs()) {
			for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()) {
				mediumDTOImpl.getMediumTypeDTO().setType(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedFeedDTOImpl);
	}

}
