package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.MediumDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoMediumRepository;

/**
 * MongoDb {@link MediumDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoMediumDAO implements MediumDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoMediumDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;
	@Autowired
	private MongoMediumRepository mongoMediumRepository;
	@Autowired
	private MongoMediumTypeDAO mongoMediumTypeDAO;

	@Override
	public MediumDTOImpl save(final MediumDTOImpl mediumDTOImpl) {
		LOGGER.debug("Save MediumDTOImpl:\n{}",mediumDTOImpl);
		if(mediumDTOImpl!=null){
			MediumDTOImpl saveableMediumDTOImpl=null;
			final MediumDTOImpl foundByLinkMediumDTOImpl=findByLink(mediumDTOImpl.getLink());
			if(foundByLinkMediumDTOImpl==null) { // New medium:
				mediumDTOImpl.setMediumTypeDTO(mongoMediumTypeDAO.save(mediumDTOImpl.getMediumTypeDTO()));
				saveableMediumDTOImpl=mediumDTOImpl;
			}else {
				if(mediumDTOImpl.equals(foundByLinkMediumDTOImpl)) {
					return foundByLinkMediumDTOImpl;
				}
				foundByLinkMediumDTOImpl.setMediumTypeDTO(mongoMediumTypeDAO.save(mediumDTOImpl.getMediumTypeDTO()));
				foundByLinkMediumDTOImpl.setSize(mediumDTOImpl.getSize());
				saveableMediumDTOImpl=foundByLinkMediumDTOImpl;
			}
			if(saveableMediumDTOImpl!=null) {
				final MongoMedium savedMedium=mongoMediumRepository.save(mapper.map(saveableMediumDTOImpl,MongoMedium.class));
				return mapper.map(savedMedium, MediumDTOImpl.class);
			}
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
