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

	public static final ArticleImpl createBrusselaarsFietsenWereldRond(){
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
	
	public static final ArticleImpl createNewBrusselaarsFietsenWereldRond(){
		try {
			final Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
			authors.add(AuthorImplFactory.createNewFMBrussel());
			final Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
			categories.add(CategoryImplFactory.createNewStad());
			final Collection<MediumImpl> media=new ArrayList<MediumImpl>();
			media.add(MediumImplFactory.createNewJPEG());
			return new ArticleImpl.Builder().archived(true)
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
	
	public static final ArticleImpl createGatzOverKaaitheater(){
		try {
			final Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
			authors.add(AuthorImplFactory.createBrusselNieuws());
			final Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
			categories.add(CategoryImplFactory.createSamenleving());
			categories.add(CategoryImplFactory.createArtikel());
			final Collection<MediumImpl> media=new ArrayList<MediumImpl>();
			media.add(MediumImplFactory.createPNG());
			media.add(MediumImplFactory.createJPEG());
			return new ArticleImpl.Builder().
					id(BigInteger.valueOf(424344344l))
					.archived(false)
					.authors(authors)
					.categories(categories)
					.description("&lt;p&gt;Vlaams minister van Cultuur Sven Gatz (Open VLD) begrijpt de teleurstelling van de kunstencentra die niet door hem zijn voorgedragen als Kunstinstelling van de Vlaamse Gemeenschap. Volgens hem gaat het echter om “disproportionele emotionele reacties”.&lt;/p&gt;Eric Vancoppenolle © brusselnieuws.be")
					.favorite(false)
					.link(new URL("http://www.brusselnieuws.be/nl/nieuws/gatz-over-kaaitheater-emotionele-reactie-buiten-proportie"))
					.media(media)
					.publicationDate(DateTime.now())
					.read(false)
					.title("Gatz over Kaaitheater: ‘Emotionele reactie buiten proportie’")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A ArticleImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The ArticleImpl URL is incorrect",e);
		}
		return null;
	}
	
	public static final ArticleImpl createNewGatzOverKaaitheater(){
		try {
			final Collection<AuthorImpl> authors=new ArrayList<AuthorImpl>();
			authors.add(AuthorImplFactory.createNewBrusselNieuws());
			final Collection<CategoryImpl> categories=new ArrayList<CategoryImpl>();
			categories.add(CategoryImplFactory.createNewSamenleving());
			categories.add(CategoryImplFactory.createNewArtikel());
			final Collection<MediumImpl> media=new ArrayList<MediumImpl>();
			media.add(MediumImplFactory.createNewPNG());
			media.add(MediumImplFactory.createNewJPEG());
			return new ArticleImpl.Builder().archived(false)
					.authors(authors)
					.categories(categories)
					.description("&lt;p&gt;Vlaams minister van Cultuur Sven Gatz (Open VLD) begrijpt de teleurstelling van de kunstencentra die niet door hem zijn voorgedragen als Kunstinstelling van de Vlaamse Gemeenschap. Volgens hem gaat het echter om “disproportionele emotionele reacties”.&lt;/p&gt;Eric Vancoppenolle © brusselnieuws.be")
					.favorite(false)
					.link(new URL("http://www.brusselnieuws.be/nl/nieuws/gatz-over-kaaitheater-emotionele-reactie-buiten-proportie"))
					.media(media)
					.publicationDate(DateTime.now())
					.read(false)
					.title("Gatz over Kaaitheater: ‘Emotionele reactie buiten proportie’")
					.build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A ArticleImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The ArticleImpl URL is incorrect",e);
		}
		return null;
	}

}
