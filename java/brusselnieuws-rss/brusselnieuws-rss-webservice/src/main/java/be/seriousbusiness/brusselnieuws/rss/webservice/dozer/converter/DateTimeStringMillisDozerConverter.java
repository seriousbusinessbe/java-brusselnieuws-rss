package be.seriousbusiness.brusselnieuws.rss.webservice.dozer.converter;

import org.dozer.CustomConverter;
import org.joda.time.DateTime;

/**
 * Converts a {@link DateTime} to a milliseconds {@link String} representation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class DateTimeStringMillisDozerConverter implements CustomConverter {
	
	/**
	 * Checks if a {@link Class} is of type {@link DateTime}
	 * @param cls The {@link Class} to check
	 * @return <code>true</code> when of type {@link DateTime} otherwise <code>false</code> 
	 */
	private static final boolean isDateTime(final Class<?> cls){
		return cls.equals(DateTime.class);
	}
	
	/**
	 * Checks if a {@link Class} is of type {@link String}
	 * @param cls The {@link Class} to check
	 * @return <code>true</code> when of type {@link String} otherwise <code>false</code> 
	 */
	private static final boolean isString(final Class<?> cls){
		return cls.equals(String.class);
	}

	@Override
	public Object convert(final Object existingDestinationFieldValue,
			final Object sourceFieldValue,
			final Class<?> destinationClass,
			final Class<?> sourceClass) {
		if(sourceFieldValue!=null && isDateTime(sourceClass) && isString(destinationClass)){
			return String.valueOf(((DateTime)sourceFieldValue).getMillis());
		}
		return sourceFieldValue;
	}

}
