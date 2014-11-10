package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;

public class FeedDTOImplFactory {
	
	public static final FeedDTOImpl create(){
		final FeedDTOImpl feedDTOImpl=new FeedDTOImpl();
		feedDTOImpl.setId(BigInteger.valueOf(5123456789076432l));
		feedDTOImpl.setDescription("");
		feedDTOImpl.setLink("http://www.brusselnieuws.be/nl/rubriek/4797/feed");
		feedDTOImpl.setTitle("BrusselNieuws RSS - Politiek");
		final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>();
		articleDTOImpls.add(ArticleDTOImplFactory.create());
		feedDTOImpl.setArticleDTOs(articleDTOImpls);
		return feedDTOImpl;
	}
	
	public static final FeedDTOImpl createNew(){
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
