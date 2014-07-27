package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer;

import org.dozer.CustomConverter;
import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.MediumTypeDTO;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;

/**
 * "Custom Converters get invoked when the source value is null, 
 * so you need to explicitly handle null values in your custom converter implementation."
 * @author Stefan Borghys
 *
 */
public class MediumTypeDTOToMediumTypeConverter extends DozerConverter<MediumTypeDTO,MediumType> implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(MediumTypeDTOToMediumTypeConverter.class);
	
	public MediumTypeDTOToMediumTypeConverter() {
		super(MediumTypeDTO.class,MediumType.class);
	}

	
	private static final boolean implementsInterface(final Class<?> classClass,final Class<?> interfaceClass){
		for(final Class<?> cls : classClass.getInterfaces()){
			if(cls.equals(interfaceClass)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {	
		if(sourceClass==null || sourceFieldValue==null){
			LOGGER.debug("Converted MediumTypeDTO 'null' to MediumType '{}'",MediumType.UNKNOWN);
			return MediumType.UNKNOWN;
		}else if(implementsInterface(sourceClass,MediumTypeDTO.class) && destinationClass.isEnum() && destinationClass.equals(MediumType.class)){
			final MediumTypeDTO mediumTypeDTO=(MediumTypeDTO)sourceFieldValue;
			final MediumType mediumType=MediumType.find(mediumTypeDTO.getType());
			LOGGER.debug("Converted MediumTypeDTO '{}' to MediumType '{}'",mediumTypeDTO.getType(),mediumType.toString());
			return mediumType;
		}
		LOGGER.debug("The source '{}' or destination '{}' class are not an instance of MediumTypeDTO and MediumType",sourceClass,destinationClass);
		LOGGER.debug("Converted MediumTypeDTO 'null' to MediumType '{}'",MediumType.UNKNOWN);
		return MediumType.UNKNOWN;
	}

	@Override
	public MediumType convertTo(final MediumTypeDTO mediumTypeDTO,final MediumType mediumType) {
		final MediumType foundMediumType=MediumType.find(mediumTypeDTO.getType());
		LOGGER.debug("Converted MediumTypeDTO '{}' to MediumType '{}'",mediumTypeDTO.getType(),foundMediumType.toString());
		return foundMediumType;
	}

	@Override
	public MediumTypeDTO convertFrom(MediumType source,
			MediumTypeDTO destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
