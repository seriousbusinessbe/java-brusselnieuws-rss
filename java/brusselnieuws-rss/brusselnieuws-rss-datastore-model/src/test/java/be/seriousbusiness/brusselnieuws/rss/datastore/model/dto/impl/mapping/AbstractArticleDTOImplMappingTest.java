package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.ArticleDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.ArticleDTOUtil;

public abstract class AbstractArticleDTOImplMappingTest<A extends ArticleDTO<?,?,?,?>> extends AbstractMappingTest<ArticleDTO<?,?,?,?>,A,ArticleDTOImpl> {

	@Override
	protected ArticleDTOImpl createDTOB() {
		return ArticleDTOImplFactory.createArticleMichelBorcy();
	}

	@Override
	protected void assertEquals(final A dtoA,final ArticleDTOImpl dtoB) {
		ArticleDTOUtil.assertEquals(dtoA, dtoB);
	}

}
