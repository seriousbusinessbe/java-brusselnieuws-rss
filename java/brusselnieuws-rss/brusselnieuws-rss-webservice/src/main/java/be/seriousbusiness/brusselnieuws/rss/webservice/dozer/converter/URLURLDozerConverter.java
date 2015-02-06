package be.seriousbusiness.brusselnieuws.rss.webservice.dozer.converter;

import java.net.MalformedURLException;
import java.net.URL;

import org.dozer.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts an {@link URL} into an {@link URL}.</br>
 * Dozer was not able to do this by itself because the {@link URL} has no proper init constructor.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class URLURLDozerConverter implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(URLURLDozerConverter.class);
	
	/**
	 * Checks if a {@link Class} is of type {@link URL}
	 * @param cls The {@link Class} to check
	 * @return <code>true</code> when of type {@link URL} otherwise <code>false</code> 
	 */
	private static final boolean isURL(final Class<?> cls){
		return cls.equals(URL.class);
	}

	@Override
	public Object convert(final Object existingDestinationFieldValue,
			final Object sourceFieldValue,
			final Class<?> destinationClass,
			final Class<?> sourceClass) {
		if(sourceFieldValue!=null && isURL(sourceClass) && isURL(destinationClass)){
			try {
				return new URL(((URL)sourceFieldValue).toString());
			} catch (final MalformedURLException e) {
				LOGGER.error("URL '{}' could not be converted",((URL)sourceFieldValue).toString(),e);
			}
		}
		return sourceFieldValue;
	}

}
