package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CategoryDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.util.CategoryDTOImplUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoCategoryRepository;

public class MongoCategoryDAO implements CategoryDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoCategoryDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;
	@Autowired
	private MongoCategoryRepository mongoCategoryRepository;

	@Override
	public CategoryDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find CategoryDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoCategory foundCategory=mongoCategoryRepository.findOne(id);
			if(foundCategory!=null){
				return mapper.map(foundCategory,CategoryDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public CategoryDTOImpl save(final CategoryDTOImpl categoryDTOImpl) {
		LOGGER.debug("Save CategoryDTOImpl:\n{}",categoryDTOImpl);
		if(categoryDTOImpl!=null){
			CategoryDTOImpl saveableCategoryDTOImpl=null;
			if(categoryDTOImpl.getId()==null) { 
				final CategoryDTOImpl foundByLinkCategoryDTOImpl=findByLink(categoryDTOImpl.getLink());
				if(foundByLinkCategoryDTOImpl==null) {
					saveableCategoryDTOImpl=categoryDTOImpl;
				}else {
					saveableCategoryDTOImpl=CategoryDTOImplUtil.update(foundByLinkCategoryDTOImpl,categoryDTOImpl);
				}
			}else { // Retrieve by id and update:
				saveableCategoryDTOImpl=CategoryDTOImplUtil.update(findById(categoryDTOImpl.getId()),categoryDTOImpl);
			}
			if(saveableCategoryDTOImpl!=null) {
				final MongoCategory savedCategory=mongoCategoryRepository.save(mapper.map(categoryDTOImpl, MongoCategory.class));
				return mapper.map(savedCategory, CategoryDTOImpl.class);
			}
		}
		return categoryDTOImpl;
	}

	@Override
	public List<CategoryDTOImpl> findAll() {
		LOGGER.debug("Find all CategoryDTOImpl(s)");
		return MapperUtil.map(mapper,(Collection<MongoCategory>)mongoCategoryRepository.findAll(),CategoryDTOImpl.class);
	}

	@Override
	public List<CategoryDTOImpl> findByName(final String name) {
		LOGGER.debug("Find CategoryDTOImpl by name '{}'",name);
		if(name!=null && !name.isEmpty()){
			return MapperUtil.map(mapper,(Collection<MongoCategory>)mongoCategoryRepository.findByName(name),CategoryDTOImpl.class);
		}
		return new ArrayList<CategoryDTOImpl>();
	}

	@Override
	public CategoryDTOImpl findByLink(final String link) {
		LOGGER.debug("Find CategoryDTOImpl by link '{}'",link);
		if(link!=null && !link.isEmpty()){
			final MongoCategory foundCategory=mongoCategoryRepository.findByLink(link);
			if(foundCategory!=null){
				return mapper.map(foundCategory,CategoryDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public void delete(final CategoryDTOImpl categoryDTOImpl) {
		LOGGER.debug("Delete CategoryDTOImpl:\n{}",categoryDTOImpl);
		if(categoryDTOImpl!=null && categoryDTOImpl.getId()!=null){
			mongoCategoryRepository.delete(mapper.map(categoryDTOImpl, MongoCategory.class));
		}
	}

}
