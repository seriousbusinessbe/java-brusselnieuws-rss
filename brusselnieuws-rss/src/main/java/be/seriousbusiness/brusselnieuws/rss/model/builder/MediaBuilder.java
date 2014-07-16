package be.seriousbusiness.brusselnieuws.rss.model.builder;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;

/**
 * Defines a Media builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface MediaBuilder extends Builder<Medium> {
	
	/**
	 * Set a size
	 * @param size
	 * @return this MediaBuilder
	 */
	MediaBuilder size(final long size);
	
	/**
	 * Set an URL link
	 * @param link
	 * @return this MediaBuilder
	 */
	MediaBuilder link(final URL link);
	
	/**
	 * Set a MediaType
	 * @param mediaType
	 * @return this MediaBuilder
	 */
	MediaBuilder type(final MediumType mediaType);

}
