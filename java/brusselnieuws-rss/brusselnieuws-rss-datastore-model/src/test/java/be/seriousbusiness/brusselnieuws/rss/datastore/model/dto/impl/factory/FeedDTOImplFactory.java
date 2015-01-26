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
		final FeedDTOImpl feedDTOImpl=new FeedDTOImpl();
		feedDTOImpl.setId(BigInteger.valueOf(5123456789076432l));
		feedDTOImpl.setDescription("");
		feedDTOImpl.setLink("http://www.brusselnieuws.be/nl/rubriek/4797/feed");
		feedDTOImpl.setTitle("BrusselNieuws RSS - Politiek");
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		articleDTOImpls.add(ArticleDTOImplFactory.createArticleMichelBorcy());
		articleDTOImpls.add(ArticleDTOImplFactory.createArticleNlFilmsiteCinebelVerdwijnt());
		feedDTOImpl.setArticleDTOs(articleDTOImpls);
		return feedDTOImpl;
	}
	
	public static final FeedDTOImpl createNewPolitiek(){
		final FeedDTOImpl feedDTOImpl=new FeedDTOImpl();
		feedDTOImpl.setDescription("");
		feedDTOImpl.setLink("http://www.brusselnieuws.be/nl/rubriek/4797/feed");
		feedDTOImpl.setTitle("BrusselNieuws RSS - Politiek");
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		articleDTOImpls.add(ArticleDTOImplFactory.createNew());
		feedDTOImpl.setArticleDTOs(articleDTOImpls);
		return feedDTOImpl;
	}

}
