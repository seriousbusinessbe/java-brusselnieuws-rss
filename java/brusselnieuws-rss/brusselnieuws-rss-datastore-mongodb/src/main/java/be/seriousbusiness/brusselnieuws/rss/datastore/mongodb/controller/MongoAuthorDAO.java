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
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoAuthorRepository;

/**
 * MongoDb {@link AuthorDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoAuthorDAO implements AuthorDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoAuthorDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;
	@Autowired
	private MongoAuthorRepository mongoAuthorRepository;

	@Override
	public AuthorDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find AuthorDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoAuthor foundAuthor=mongoAuthorRepository.findOne(id);
			if(foundAuthor!=null){
				return mapper.map(foundAuthor,AuthorDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public AuthorDTOImpl save(final AuthorDTOImpl authorDTOImpl) {
		LOGGER.debug("Save AuthorDTOImpl:\n{}",authorDTOImpl);
		if(authorDTOImpl!=null){
			AuthorDTOImpl saveableAuthorDTOImpl=null;
			if(authorDTOImpl.getId()==null) { 
				final AuthorDTOImpl foundByNameAuthorDTOImpl=findFirstByName(authorDTOImpl.getName());
				if(foundByNameAuthorDTOImpl==null) { // New author:
					saveableAuthorDTOImpl=authorDTOImpl;
				}else { // Existing author:
					return foundByNameAuthorDTOImpl;
				}
			}else { // Retrieve by id and update:
				final AuthorDTOImpl foundByIdAuthorDTOImpl=findById(authorDTOImpl.getId());
				if(authorDTOImpl.equals(foundByIdAuthorDTOImpl)) {
					return foundByIdAuthorDTOImpl;
				}
				foundByIdAuthorDTOImpl.setName(authorDTOImpl.getName());
				saveableAuthorDTOImpl=foundByIdAuthorDTOImpl;
			}
			if(saveableAuthorDTOImpl!=null) {
				return mapper.map(mongoAuthorRepository.save(mapper.map(saveableAuthorDTOImpl, MongoAuthor.class)),AuthorDTOImpl.class);
			}
		}
		return authorDTOImpl;
	}
	
	@Override
	public List<AuthorDTOImpl> findAll() {
		LOGGER.debug("Find all AuthorDTOImpl(s)");
		return MapperUtil.map(mapper,(List<MongoAuthor>)mongoAuthorRepository.findAll(),AuthorDTOImpl.class);
	}

	@Override
	public List<AuthorDTOImpl> findByName(final String name) {
		LOGGER.debug("Find AuthorDTOImpl by name '{}'",name);
		if(name!=null){
			return MapperUtil.map(mapper,(Collection<MongoAuthor>)mongoAuthorRepository.findByName(name),AuthorDTOImpl.class);
		}
		return new ArrayList<AuthorDTOImpl>();
	}

	@Override
	public void delete(final AuthorDTOImpl authorDTOImpl) {
		LOGGER.debug("Delete AuthorDTOImpl:\n{}",authorDTOImpl);
		if(authorDTOImpl!=null && authorDTOImpl.getId()!=null){
			mongoAuthorRepository.delete(mapper.map(authorDTOImpl, MongoAuthor.class));
		}
	}

	@Override
	public AuthorDTOImpl findFirstByName(String name) {
		LOGGER.debug("Find first AuthorDTOImpl by name '{}'",name);
		if(name!=null) {
			final MongoAuthor mongoAuthor=mongoAuthorRepository.findFirstByName(name);
			if(mongoAuthor!=null) {
				mapper.map(mongoAuthor,AuthorDTOImpl.class);
			}
		}
		return null;
	}

}
