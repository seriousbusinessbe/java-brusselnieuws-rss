package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.FeedImplFactory;

/**
 * {@link FeedImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedImplTest {
	
	/**
	 * Tests if a clone of a given {@link FeedImpl} is equal and non-equal after altering it.
	 * @param articleImpl
	 */
	private static final void assertCloneable(final FeedImpl feedImpl) {
		FeedImpl clonedFeedImpl=(FeedImpl) feedImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",feedImpl,clonedFeedImpl);
		clonedFeedImpl.setDescription(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
		// ArticleImpl:
		clonedFeedImpl=(FeedImpl) feedImpl.clone();
		for(final ArticleImpl articleImpl : clonedFeedImpl.getArticles()) {
			articleImpl.setDescription(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
		// AuthorImpl:
		clonedFeedImpl=(FeedImpl) feedImpl.clone();
		for(final ArticleImpl articleImpl : clonedFeedImpl.getArticles()) {
			for(final AuthorImpl authorImpl : articleImpl.getAuthors()) {
				authorImpl.setName(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
		// CategoryImpl:
		clonedFeedImpl=(FeedImpl) feedImpl.clone();
		for(final ArticleImpl articleImpl : clonedFeedImpl.getArticles()) {
			for(final CategoryImpl categoryImpl : articleImpl.getCategories()) {
				categoryImpl.setName(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
		// MediumImpl:
		clonedFeedImpl=(FeedImpl) feedImpl.clone();
		for(final ArticleImpl articleImpl : clonedFeedImpl.getArticles()) {
			for(final MediumImpl mediumImpl : articleImpl.getMedia()) {
				mediumImpl.setSize(System.currentTimeMillis());
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
		// MediumTypeImpl:
		clonedFeedImpl=(FeedImpl) feedImpl.clone();
		for(final ArticleImpl articleImpl : clonedFeedImpl.getArticles()) {
			for(final MediumImpl mediumImpl : articleImpl.getMedia()) {
				mediumImpl.getType().setType(String.valueOf(System.currentTimeMillis()));
				break;
			}
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",feedImpl,clonedFeedImpl);
	}
	
	/**
	 * Tests if cloning a {@link FeedImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(FeedImplFactory.createNieuws());
		assertCloneable(FeedImplFactory.createNewNieuws());
	}

}
