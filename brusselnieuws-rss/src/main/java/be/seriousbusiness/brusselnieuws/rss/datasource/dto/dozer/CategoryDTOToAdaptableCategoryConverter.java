package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableCategory;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;

public class CategoryDTOToAdaptableCategoryConverter implements CustomConverter {
	@Autowired
	private Mapper mapper;

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if(sourceClass==null || sourceFieldValue==null){
			return null;
		}else{
			final CategoryDTO categoryDTO=(CategoryDTO)sourceFieldValue;
			final AdaptableCategory adaptableCategory=new AdaptableCategoryImpl();
			mapper.map(categoryDTO,adaptableCategory);
			return adaptableCategory;
		}
	}

}
