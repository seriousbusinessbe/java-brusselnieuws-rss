package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableMedium;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableMediumImpl;

public class MediumDTOSetToAdaptableMediumListConverter implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(MediumDTOSetToAdaptableMediumListConverter.class);
	@Autowired
	@Qualifier("dozerBeanMapper")
	private Mapper mapper;
	
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			LOGGER.debug("Converted Set<MediumDTO> 'null' to empty List<AdaptableMedium>");
			return new ArrayList<AdaptableMedium>(0);
		}else{
			@SuppressWarnings("unchecked")
			final Set<MediumDTO> mediumDTOs=(Set<MediumDTO>)sourceFieldValue;
			final List<AdaptableMedium> adaptableMediums=new ArrayList<AdaptableMedium>();
			for(final MediumDTO mediumDTO : mediumDTOs){
				final AdaptableMedium adaptableMedium=new AdaptableMediumImpl();
				this.mapper.map(mediumDTO,adaptableMedium);
				adaptableMediums.add(adaptableMedium);
			}
			LOGGER.debug("Converted Set<MediumDTO> '{}' to List<AdaptableMedium> '{}'",mediumDTOs,adaptableMediums);
			return adaptableMediums;
		}
	}

}
