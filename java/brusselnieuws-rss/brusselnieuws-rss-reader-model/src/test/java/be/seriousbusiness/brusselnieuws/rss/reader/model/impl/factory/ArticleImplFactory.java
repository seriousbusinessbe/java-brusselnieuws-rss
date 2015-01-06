package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;

public class ArticleImplFactory {
	private static final Logger LOGGER=LoggerFactory.getLogger(ArticleImplFactory.class);

	public static final ArticleImpl create(){
		try {
			final Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
			authors.add(AuthorImplFactory.createFMBrussel());
			final Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
			categories.add(CategoryImplFactory.createStad());
			final Collection<MediumImpl> media=new ArrayList<MediumImpl>();
			media.add(MediumImplFactory.createJPEG());
			return new ArticleImpl.Builder().
					id(BigInteger.valueOf(98472733l))
					.archived(true)
					.authors(authors)
					.categories(categories)
					.description("&lt;p&gt;27.500 gefietste kilometers en een karrenvracht fantastische verhalen: dat is het resultaat van de wereldreis die Quentin Jossen (28), Mélik Khiari (29) en Yvan Paquot (28) het afgelopen jaar hebben afgewerkt. Ze zamelden duizenden euro’s in voor het Nationaal Centrum voor Ontwikkelingssamenwerking en ontdekten hoe gastvrij de mens wel kan zijn.&lt;/p&gt;Tim Schoonjans  © Brussel Deze Week")
					.favorite(false)
					.link(new URL("http://www.brusselnieuws.be/nl/nieuws/drie-brusselaars-fietsen-wereld-rond-met-bike-meet-you"))
					.media(media)
					.publicationDate(DateTime.now())
					.read(true)
					.title("Drie Brusselaars fietsen wereld rond met Bike to Meet You")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A ArticleImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The ArticleImpl URL is incorrect",e);
		}
		return null;
	}

}
