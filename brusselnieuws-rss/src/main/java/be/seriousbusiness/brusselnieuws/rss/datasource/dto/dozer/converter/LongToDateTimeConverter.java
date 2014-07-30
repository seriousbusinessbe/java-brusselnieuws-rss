package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer.converter;

import org.dozer.CustomConverter;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongToDateTimeConverter implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(LongToDateTimeConverter.class);

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			final DateTime dateTime=DateTime.now();
			LOGGER.debug("Converted 'null' to DateTime '{}'",dateTime);
			return dateTime;
		}else{
			final DateTime dateTime=new DateTime((Long)sourceFieldValue);
			LOGGER.debug("Converted '{}' to DateTime '{}'",(Long)sourceFieldValue,dateTime);
			return dateTime;
		}
	}

}
