package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoMediumRepository;

public class MongoMediumDAO implements MediumDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoMediumDAO.class);
	@Autowired
	private Mapper mapper;
	@Autowired
	private MongoMediumRepository mongoMediumRepository;
	@Autowired
	private MongoMediumTypeDAO mongoMediumTypeDAO;

	@Override
	public MediumDTOImpl save(final MediumDTOImpl mediumDTOImpl) {
		LOGGER.debug("Save MediumDTOImpl:\n{}",mediumDTOImpl);
		if(mediumDTOImpl!=null){
			final MediumTypeDTOImpl mediumTypeDTOImpl=mediumDTOImpl.getMediumTypeDTO();
			if(mediumTypeDTOImpl.getId()==null){
				try{
					// A Medium with new MediumType is given, save the MediumType before saving the Medium:
					mediumDTOImpl.setMediumTypeDTO(mongoMediumTypeDAO.save(mediumDTOImpl.getMediumTypeDTO()));	
				}catch(final NotUniqueException e){
					// An MediumType of the same type was already stored, let's retrieve this one:
					mediumDTOImpl.setMediumTypeDTO(mongoMediumTypeDAO.findByType(mediumTypeDTOImpl.getType()));
				}
			}
			final MongoMedium savedMedium=mongoMediumRepository.save(mapper.map(mediumDTOImpl, MongoMedium.class));
			return mapper.map(savedMedium, MediumDTOImpl.class);
		}
		return mediumDTOImpl;
		
	}

	@Override
	public List<MediumDTOImpl> findAll() {
		LOGGER.debug("Find all MediumDTOImpl(s)");
		return MapperUtil.map(mapper,(Collection<MongoMedium>)mongoMediumRepository.findAll(),MediumDTOImpl.class);
	}

	@Override
	public MediumDTOImpl findByLink(final String link) {
		LOGGER.debug("Find MediumDTOImpl by link '{}'",link);
		if(link!=null){
			final MongoMedium foundMedium=mongoMediumRepository.findByLink(link);
			if(foundMedium!=null){
				return mapper.map(foundMedium,MediumDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public void delete(final MediumDTOImpl mediumDTOImpl) {
		LOGGER.debug("Delete MediumDTOImpl:\n{}",mediumDTOImpl);
		if(mediumDTOImpl!=null && mediumDTOImpl.getLink()!=null){
			mongoMediumRepository.delete(mapper.map(mediumDTOImpl, MongoMedium.class));
		}
	}

}
