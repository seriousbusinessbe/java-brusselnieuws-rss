package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;

public class FeedImplFactory {
	private static final Logger LOGGER=LoggerFactory.getLogger(FeedImplFactory.class);

	public static final FeedImpl createNieuws(){
		try {
			final Collection<ArticleImpl> articles=new ArrayList<ArticleImpl>();
			articles.add(ArticleImplFactory.createBrusselaarsFietsenWereldRond());
			articles.add(ArticleImplFactory.createGatzOverKaaitheater());
			return new FeedImpl.Builder().
					id(BigInteger.valueOf(98472733l))
					.articles(articles)
					.description("")
					.link(new URL("http://www.brusselnieuws.be/nl/rubriek/11/feed"))
					.title("BrusselNieuws RSS - Nieuws")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A FeedImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The FeedImpl URL is incorrect",e);
		}
		return null;
	}
	
	public static final FeedImpl createNewNieuws(){
		try {
			final Collection<ArticleImpl> articles=new ArrayList<ArticleImpl>();
			articles.add(ArticleImplFactory.createNewBrusselaarsFietsenWereldRond());
			articles.add(ArticleImplFactory.createGatzOverKaaitheater());
			return new FeedImpl.Builder().articles(articles)
					.description("")
					.link(new URL("http://www.brusselnieuws.be/nl/rubriek/11/feed"))
					.title("BrusselNieuws RSS - Nieuws")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A FeedImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The FeedImpl URL is incorrect",e);
		}
		return null;
	}

}
