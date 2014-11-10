package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.ArrayList;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractArticleDTOTest;

public class ArticleDTOImplTest extends AbstractArticleDTOTest<MediumTypeDTOImpl,
															MediumDTOImpl,
															CategoryDTOImpl,
															AuthorDTOImpl,
															ArticleDTOImpl> {

	public ArticleDTOImplTest() {
		super(BigInteger.valueOf(212212212l),
				new ArrayList<AuthorDTOImpl>(),
				new ArrayList<CategoryDTOImpl>(),
				new ArrayList<MediumDTOImpl>(),
				"&lt;p&gt;Wie zijn kroost of petekind nog eens vanuit een telefooncel wil laten bellen, moet zich reppen. Belgacom is bezig de allerlaatste duizend exemplaren weg te halen, waarvan 109 in Brussel. Vooral in Ukkel kunt u er nog makkelijk een vinden.&lt;/p&gt;SDS © brusselnieuws.be",
				"http://www.brusselnieuws.be/nl/nieuws/laatste-1000-telefoonhokjes-verdwijnen-definitief",
				"Laatste 1.000 telefoonhokjes verdwijnen definitief",
				System.currentTimeMillis(),true,false,true);
	}

	@Override
	public ArticleDTOImpl create() {
		return new ArticleDTOImpl();
	}

}
