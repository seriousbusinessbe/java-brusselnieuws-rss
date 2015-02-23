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
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CreatorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoCreatorRepository;

/**
 * MongoDb {@link CreatorDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoCreatorDAO implements CreatorDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoCreatorDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;
	@Autowired
	private MongoCreatorRepository mongoCreatorRepository;

	@Override
	public CreatorDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find CreatorDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoCreator foundCreator=mongoCreatorRepository.findOne(id);
			if(foundCreator!=null){
				return mapper.map(foundCreator,CreatorDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public CreatorDTOImpl save(final CreatorDTOImpl creatorDTOImpl) {
		LOGGER.debug("Save CreatorDTOImpl:\n{}",creatorDTOImpl);
		if(creatorDTOImpl!=null){
			CreatorDTOImpl saveableCreatorDTOImpl=null;
			if(creatorDTOImpl.getId()==null) { 
				final CreatorDTOImpl foundByNameCreatorDTOImpl=findFirstByName(creatorDTOImpl.getName());
				if(foundByNameCreatorDTOImpl==null) { // New creator:
					saveableCreatorDTOImpl=creatorDTOImpl;
				}else { // Existing creator:
					return foundByNameCreatorDTOImpl;
				}
			}else { // Retrieve by id and update:
				final CreatorDTOImpl foundByIdCreatorDTOImpl=findById(creatorDTOImpl.getId());
				if(creatorDTOImpl.equals(foundByIdCreatorDTOImpl)) {
					return foundByIdCreatorDTOImpl;
				}
				foundByIdCreatorDTOImpl.setName(creatorDTOImpl.getName());
				saveableCreatorDTOImpl=foundByIdCreatorDTOImpl;
			}
			if(saveableCreatorDTOImpl!=null) {
				return mapper.map(mongoCreatorRepository.save(mapper.map(saveableCreatorDTOImpl,MongoCreator.class)),CreatorDTOImpl.class);
			}
		}
		return creatorDTOImpl;
	}
	
	@Override
	public List<CreatorDTOImpl> findAll() {
		LOGGER.debug("Find all CreatorDTOImpl(s)");
		return MapperUtil.map(mapper,(List<MongoCreator>)mongoCreatorRepository.findAll(),CreatorDTOImpl.class);
	}

	@Override
	public List<CreatorDTOImpl> findByName(final String name) {
		LOGGER.debug("Find CreatorDTOImpl by name '{}'",name);
		if(name!=null){
			return MapperUtil.map(mapper,(Collection<MongoCreator>)mongoCreatorRepository.findByName(name),CreatorDTOImpl.class);
		}
		return new ArrayList<CreatorDTOImpl>();
	}

	@Override
	public void delete(final CreatorDTOImpl creatorDTOImpl) {
		LOGGER.debug("Delete CreatorDTOImpl:\n{}",creatorDTOImpl);
		if(creatorDTOImpl!=null && creatorDTOImpl.getId()!=null){
			mongoCreatorRepository.delete(mapper.map(creatorDTOImpl,MongoCreator.class));
		}
	}

	@Override
	public CreatorDTOImpl findFirstByName(final String name) {
		LOGGER.debug("Find first CreatorDTOImpl by name '{}'",name);
		if(name!=null) {
			final MongoCreator mongoCreator=mongoCreatorRepository.findFirstByName(name);
			if(mongoCreator!=null) {
				return mapper.map(mongoCreator,CreatorDTOImpl.class);
			}
		}
		return null;
	}

}
