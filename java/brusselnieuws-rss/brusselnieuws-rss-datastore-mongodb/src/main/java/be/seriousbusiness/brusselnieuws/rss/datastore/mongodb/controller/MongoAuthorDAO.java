package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoAuthorRepository;

public class MongoAuthorDAO implements AuthorDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoAuthorDAO.class);
	@Autowired
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
			return mapper.map(mongoAuthorRepository.save(mapper.map(authorDTOImpl, MongoAuthor.class)),AuthorDTOImpl.class);
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

}
