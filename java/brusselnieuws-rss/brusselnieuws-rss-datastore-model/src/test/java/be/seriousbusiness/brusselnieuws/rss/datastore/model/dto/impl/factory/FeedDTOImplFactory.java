package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;

/**
 * {@link FeedDTOImpl} factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedDTOImplFactory {
	
	public static final FeedDTOImpl createPolitiek(){
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		articleDTOImpls.add(ArticleDTOImplFactory.createArticleMichelBorcy());
		articleDTOImpls.add(ArticleDTOImplFactory.createArticleNlFilmsiteCinebelVerdwijnt());
		return new FeedDTOImpl.Builder().articleDTOs(articleDTOImpls)
				.id(BigInteger.valueOf(5123456789076432l))
				.title("BrusselNieuws RSS - Politiek")
				.link("http://www.brusselnieuws.be/nl/rubriek/4797/feed")
				.description("").build();
	}
	
	public static final FeedDTOImpl createNewPolitiek(){
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		articleDTOImpls.add(ArticleDTOImplFactory.createNew());
		return new FeedDTOImpl.Builder().articleDTOs(articleDTOImpls)
				.title("BrusselNieuws RSS - Politiek")
				.link("http://www.brusselnieuws.be/nl/rubriek/4797/feed")
				.description("").build();
	}

}
