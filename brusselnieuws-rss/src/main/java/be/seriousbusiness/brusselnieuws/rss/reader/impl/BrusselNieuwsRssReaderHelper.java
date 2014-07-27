package be.seriousbusiness.brusselnieuws.rss.reader.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableAuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableMediumImpl;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndPerson;

public class BrusselNieuwsRssReaderHelper {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssReaderHelper.class);
	
	public static final  Author map(final SyndPerson syndPerson){
		return new AdaptableAuthorImpl.Builder().name(syndPerson.getName()).build();
	}
	
	public static final Category map(final SyndCategory syndCategory){
		try {
			return new AdaptableCategoryImpl.Builder().name(syndCategory.getName()).link(new URL(syndCategory.getTaxonomyUri())).build();
		} catch (final MalformedURLException e) {
			LOGGER.error("The category's link was incorrect",e);
			return new AdaptableCategoryImpl.Builder().name(syndCategory.getName()).build();
		}
	}
	
	public static final Medium map(final SyndEnclosure syndEnclosure){
		try {
			return new AdaptableMediumImpl.Builder().link(new URL(syndEnclosure.getUrl())).size(syndEnclosure.getLength()).type(MediumType.find(syndEnclosure.getType())).build();
		} catch (final MalformedURLException e) {
			LOGGER.error("The medium's link was incorrect",e);
			return new AdaptableMediumImpl.Builder().size(syndEnclosure.getLength()).type(MediumType.find(syndEnclosure.getType())).build();
		}
	}

}
