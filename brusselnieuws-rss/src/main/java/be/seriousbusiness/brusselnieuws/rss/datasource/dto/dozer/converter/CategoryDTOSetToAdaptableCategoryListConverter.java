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
import org.springframework.stereotype.Component;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableCategory;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;

@Component
public class CategoryDTOSetToAdaptableCategoryListConverter implements CustomConverter {
	private static final Logger LOGGER=LoggerFactory.getLogger(CategoryDTOSetToAdaptableCategoryListConverter.class);
	@Autowired
	@Qualifier("dozerBeanMapper")
	private Mapper mapper;
	
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			LOGGER.debug("Converted Set<CategoryDTO> 'null' to empty List<AdaptableCategory>");
			return new ArrayList<AdaptableCategory>(0);
		}else{
			@SuppressWarnings("unchecked")
			final Set<CategoryDTO> categoryDTOs=(Set<CategoryDTO>)sourceFieldValue;
			final List<AdaptableCategory> adaptableCategories=new ArrayList<AdaptableCategory>();
			for(final CategoryDTO categoryDTO : categoryDTOs){
				final AdaptableCategory adaptableCategory=new AdaptableCategoryImpl();
				this.mapper.map(categoryDTO,adaptableCategory);
				adaptableCategories.add(adaptableCategory);
			}
			LOGGER.debug("Converted Set<CategoryDTO> '{}' to List<AdaptableCategory> '{}'",categoryDTOs,adaptableCategories);
			return adaptableCategories;
		}
	}

}
