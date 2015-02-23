package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractArticleDTOTest;

/**
 * {@link ArticleDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ArticleDTOImplTest extends AbstractArticleDTOTest<MediumTypeDTOImpl,
															MediumDTOImpl,
															CategoryDTOImpl,
															AuthorDTOImpl,
															CreatorDTOImpl,
															ArticleDTOImpl> {

	public ArticleDTOImplTest() {
		super(BigInteger.valueOf(212212212l),
				new ArrayList<AuthorDTOImpl>(),
				new ArrayList<CategoryDTOImpl>(),
				new ArrayList<MediumDTOImpl>(),
				new ArrayList<CreatorDTOImpl>(),
				"&lt;p&gt;Wie zijn kroost of petekind nog eens vanuit een telefooncel wil laten bellen, moet zich reppen. Belgacom is bezig de allerlaatste duizend exemplaren weg te halen, waarvan 109 in Brussel. Vooral in Ukkel kunt u er nog makkelijk een vinden.&lt;/p&gt;SDS © brusselnieuws.be",
				"http://www.brusselnieuws.be/nl/nieuws/laatste-1000-telefoonhokjes-verdwijnen-definitief",
				"Laatste 1.000 telefoonhokjes verdwijnen definitief",
				System.currentTimeMillis(),true,false,true);
	}

	@Override
	public ArticleDTOImpl create() {
		return new ArticleDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCloneble() {
		ArticleDTOImpl clonedArticleDTOImpl=(ArticleDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedArticleDTOImpl);
		clonedArticleDTOImpl.setDescription(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedArticleDTOImpl);
		// AuthorDTOImpl:
		clonedArticleDTOImpl=(ArticleDTOImpl) getDTO().clone();
		for(final AuthorDTOImpl authorDTOImpl : clonedArticleDTOImpl.getAuthorDTOs()) {
			authorDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedArticleDTOImpl);
		// CategoryDTOImpl:
		clonedArticleDTOImpl=(ArticleDTOImpl) getDTO().clone();
		for(final CategoryDTOImpl categoryDTOImpl : clonedArticleDTOImpl.getCategoryDTOs()) {
			categoryDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedArticleDTOImpl);
		// MediumDTOImpl:
		clonedArticleDTOImpl=(ArticleDTOImpl) getDTO().clone();
		for(final MediumDTOImpl mediumDTOImpl : clonedArticleDTOImpl.getMediumDTOs()) {
			mediumDTOImpl.setSize(System.currentTimeMillis());
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedArticleDTOImpl);
		// MediumTypeDTOImpl:
		clonedArticleDTOImpl=(ArticleDTOImpl) getDTO().clone();
		for(final MediumDTOImpl mediumDTOImpl : clonedArticleDTOImpl.getMediumDTOs()) {
			mediumDTOImpl.getMediumTypeDTO().setType(String.valueOf(System.currentTimeMillis()));
			break;
		}
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedArticleDTOImpl);
	}

}
