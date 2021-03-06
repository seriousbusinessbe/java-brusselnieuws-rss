package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumTypeDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMediumType;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoMediumTypeRepository;

/**
 * MongoDb {@link MediumTypeDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoMediumTypeDAO implements MediumTypeDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoMediumTypeDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
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
			MediumTypeDTOImpl saveableMediumTypeDTOImpl=null;
			if(mediumTypeDTOImpl.getId()==null) {
				final MediumTypeDTOImpl foundByTypeMediumTypeDTOImpl=findByType(mediumTypeDTOImpl.getType());
				if(foundByTypeMediumTypeDTOImpl==null) {
					saveableMediumTypeDTOImpl=mediumTypeDTOImpl;
				}else {
					final MediumTypeDTOImpl clonedMediumTypeDTOImpl=(MediumTypeDTOImpl) mediumTypeDTOImpl.clone();
					clonedMediumTypeDTOImpl.setId(foundByTypeMediumTypeDTOImpl.getId());
					if(clonedMediumTypeDTOImpl.equals(foundByTypeMediumTypeDTOImpl)) {
						return foundByTypeMediumTypeDTOImpl;
					}
					foundByTypeMediumTypeDTOImpl.setType(mediumTypeDTOImpl.getType());
					saveableMediumTypeDTOImpl=foundByTypeMediumTypeDTOImpl;
				}
			}else {
				final MediumTypeDTOImpl foundByIdMediumTypeDTOImpl=findById(mediumTypeDTOImpl.getId());
				if(mediumTypeDTOImpl.equals(foundByIdMediumTypeDTOImpl)) {
					return foundByIdMediumTypeDTOImpl;
				}
				foundByIdMediumTypeDTOImpl.setType(mediumTypeDTOImpl.getType());
				saveableMediumTypeDTOImpl=foundByIdMediumTypeDTOImpl;
			}
			if(saveableMediumTypeDTOImpl!=null) {
				final MongoMediumType savedMediumType=mongoMediumTypeRepository.save(mapper.map(saveableMediumTypeDTOImpl,MongoMediumType.class));
				return mapper.map(savedMediumType, MediumTypeDTOImpl.class);
			}
		}
		return mediumTypeDTOImpl;
	}

	@Override
	public List<MediumTypeDTOImpl> findAll() {
		LOGGER.debug("Find all MediumTypeDTOImpl(s)");
		return MapperUtil.map(mapper,(Collection<MongoMediumType>)mongoMediumTypeRepository.findAll(),MediumTypeDTOImpl.class);
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
