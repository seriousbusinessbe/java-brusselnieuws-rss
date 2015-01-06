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

	public static final FeedImpl create(){
		try {
			final Collection<ArticleImpl> articles=new ArrayList<ArticleImpl>();
			articles.add(ArticleImplFactory.create());
			return new FeedImpl.Builder().
					id(BigInteger.valueOf(98472733l))
					.articles(articles)
					.description("&lt;p&gt;27.500 gefietste kilometers en een karrenvracht fantastische verhalen: dat is het resultaat van de wereldreis die Quentin Jossen (28), Mélik Khiari (29) en Yvan Paquot (28) het afgelopen jaar hebben afgewerkt. Ze zamelden duizenden euro’s in voor het Nationaal Centrum voor Ontwikkelingssamenwerking en ontdekten hoe gastvrij de mens wel kan zijn.&lt;/p&gt;Tim Schoonjans  © Brussel Deze Week")
					.link(new URL("http://www.brusselnieuws.be/nl/nieuws/drie-brusselaars-fietsen-wereld-rond-met-bike-meet-you"))
					.title("Drie Brusselaars fietsen wereld rond met Bike to Meet You")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A FeedImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The FeedImpl URL is incorrect",e);
		}
		return null;
	}

}
