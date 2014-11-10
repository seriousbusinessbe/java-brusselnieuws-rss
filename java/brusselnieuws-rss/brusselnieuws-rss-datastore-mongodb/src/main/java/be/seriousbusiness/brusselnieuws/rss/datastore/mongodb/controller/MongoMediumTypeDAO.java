package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller.mapping.util.MapUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoMediumTypeRepository;

public class MongoMediumTypeDAO implements MediumTypeDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoMediumTypeDAO.class);
	@Autowired
	private Mapper mapper;
	@Autowired
	private MongoMediumTypeRepository mongoMediumTypeRepository;

	@Override
	public MediumTypeDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find MediumTypeDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoMediumType mediumType=mongoMediumTypeRepository.findOne(id);
			if(mediumType!=null){
				return mapper.map(mediumType,MediumTypeDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public MediumTypeDTOImpl save(final MediumTypeDTOImpl mediumTypeDTOImpl) throws NotUniqueException {
		LOGGER.debug("Save MediumTypeDTOImpl:\n{}",mediumTypeDTOImpl);
		if(mediumTypeDTOImpl!=null){
			try{
				final MongoMediumType mediumType=mapper.map(mediumTypeDTOImpl, MongoMediumType.class);
				final MongoMediumType savedMediumType=mongoMediumTypeRepository.save(mediumType);
				return mapper.map(savedMediumType, MediumTypeDTOImpl.class);
			}catch(final DuplicateKeyException e){
				LOGGER.warn("MediumTypeDTOImpl '{}' could not be saved because type '{}' is already in use",mediumTypeDTOImpl,mediumTypeDTOImpl.getType(),e);
				final NotUniqueException notUniqueException=new NotUniqueException("type",mediumTypeDTOImpl.getType(),e.getCause());
				notUniqueException.setStackTrace(e.getStackTrace());
				throw notUniqueException;
			}
		}
		return mediumTypeDTOImpl;
	}

	@Override
	public List<MediumTypeDTOImpl> findAll() {
		LOGGER.debug("Find all MediumTypeDTOImpl(s)");
		return MapUtil.map(mapper,(List<MongoMediumType>)mongoMediumTypeRepository.findAll(),MediumTypeDTOImpl.class);
	}

	@Override
	public MediumTypeDTOImpl findByType(final String type) {
		LOGGER.debug("Find MediumTypeDTOImpl by type '{}'",type);
		if(type!=null){
			final MongoMediumType mediumType=mongoMediumTypeRepository.findByType(type);
			if(mediumType!=null){
				return mapper.map(mediumType,MediumTypeDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public void delete(final MediumTypeDTOImpl mediumTypeDTOImpl) {
		LOGGER.debug("Delete MediumTypeDTOImpl:\n{}",mediumTypeDTOImpl);
		if(mediumTypeDTOImpl!=null && mediumTypeDTOImpl.getId()!=null){
			mongoMediumTypeRepository.delete(mapper.map(mediumTypeDTOImpl,MongoMediumType.class));
		}		
	}	

}
