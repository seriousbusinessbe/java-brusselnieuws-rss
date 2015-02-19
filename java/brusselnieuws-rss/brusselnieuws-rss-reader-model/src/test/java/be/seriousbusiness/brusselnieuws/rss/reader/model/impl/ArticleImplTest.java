package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.ArticleImplFactory;

/**
 * {@link ArticleImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleImplTest {
	
	/**
	 * Tests if a clone of a given {@link ArticleImpl} is equal and non-equal after altering it.
	 * @param articleImpl
	 */
	private static final void assertCloneable(final ArticleImpl articleImpl) {
		ArticleImpl clonedArticleImpl=(ArticleImpl) articleImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",articleImpl,clonedArticleImpl);
		clonedArticleImpl.setDescription(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",articleImpl,clonedArticleImpl);
		// AuthorImpl:
		clonedArticleImpl=(ArticleImpl) articleImpl.clone();
		for(final AuthorImpl authorImpl : clonedArticleImpl.getAuthors()) {
			authorImpl.setName(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",articleImpl,clonedArticleImpl);
		// CategoryImpl:
		clonedArticleImpl=(ArticleImpl) articleImpl.clone();
		for(final CategoryImpl categoryImpl : clonedArticleImpl.getCategories()) {
			categoryImpl.setName(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",articleImpl,clonedArticleImpl);
		// MediumImpl:
		clonedArticleImpl=(ArticleImpl) articleImpl.clone();
		for(final MediumImpl mediumImpl : clonedArticleImpl.getMedia()) {
			mediumImpl.setSize(System.currentTimeMillis());
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",articleImpl,clonedArticleImpl);
		// MediumTypeImpl:
		clonedArticleImpl=(ArticleImpl) articleImpl.clone();
		for(final MediumImpl mediumImpl : clonedArticleImpl.getMedia()) {
			mediumImpl.getType().setType(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",articleImpl,clonedArticleImpl);
	}
	
	/**
	 * Tests if cloning a {@link ArticleImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(ArticleImplFactory.createBrusselaarsFietsenWereldRond());
		assertCloneable(ArticleImplFactory.createNewGatzOverKaaitheater());
	}

}
