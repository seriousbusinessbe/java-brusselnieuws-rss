package be.seriousbusiness.brusselnieuws.rss.reader.model.dozer.converter;

import org.dozer.CustomConverter;
import org.joda.time.DateTime;

public class DateTimeLongDozerConverter implements CustomConverter {
	
	private static final boolean isLong(final Class<?> cls){
		return cls.equals(Long.class) || cls.equals(long.class);
	}
	
	private static final boolean isDateTime(final Class<?> cls){
		return cls.equals(DateTime.class);
	}

	@Override
	public Object convert(final Object existingDestinationFieldValue,
			final Object sourceFieldValue,
			final Class<?> destinationClass,
			final Class<?> sourceClass) {
		if(sourceFieldValue!=null){
			if(isLong(sourceClass) && isDateTime(destinationClass)){
				return new DateTime((Long)sourceFieldValue);
			}else if(isLong(destinationClass) && isDateTime(sourceClass)){
				return ((DateTime)sourceFieldValue).getMillis();
			}
		}
		return sourceFieldValue;
	}

}
