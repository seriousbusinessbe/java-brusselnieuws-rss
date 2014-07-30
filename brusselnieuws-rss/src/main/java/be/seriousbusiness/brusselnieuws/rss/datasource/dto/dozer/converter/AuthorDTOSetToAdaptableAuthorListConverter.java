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

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableAuthor;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableAuthorImpl;

public class AuthorDTOSetToAdaptableAuthorListConverter implements CustomConverter  {
	private static final Logger LOGGER=LoggerFactory.getLogger(AuthorDTOSetToAdaptableAuthorListConverter.class);
	@Autowired
	@Qualifier("dozerBeanMapper")
	private Mapper mapper;
	
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			LOGGER.debug("Converted Set<AuthorDTO> 'null' to empty List<AdaptableAuthor>");
			return new ArrayList<AdaptableAuthor>(0);
		}else{
			@SuppressWarnings("unchecked")
			final Set<AuthorDTO> authorDTOs=(Set<AuthorDTO>)sourceFieldValue;
			final List<AdaptableAuthor> adaptableAuthors=new ArrayList<AdaptableAuthor>();
			for(final AuthorDTO authorDTO : authorDTOs){
				final AdaptableAuthor adaptableMedium=new AdaptableAuthorImpl();
				this.mapper.map(authorDTO,adaptableMedium);
				adaptableAuthors.add(adaptableMedium);
			}
			LOGGER.debug("Converted Set<AuthorDTO> '{}' to List<AdaptableAuthor> '{}'",authorDTOs,adaptableAuthors);
			return adaptableAuthors;
		}
	}

}
