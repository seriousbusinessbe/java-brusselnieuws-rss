package be.seriousbusiness.brusselnieuws.rss.webservice.dozer.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.CustomConverter;
import org.joda.time.DateTime;

/**
 * Converts a {@link DateTime} to a simple date format {@link String} representation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class DateTimeStringSimpleDateFormatDozerConverter implements CustomConverter {
	private static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm";
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
	
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
			return SIMPLE_DATE_FORMAT.format(new Date(((DateTime)sourceFieldValue).getMillis()));
		}
		return sourceFieldValue;
	}
	
}