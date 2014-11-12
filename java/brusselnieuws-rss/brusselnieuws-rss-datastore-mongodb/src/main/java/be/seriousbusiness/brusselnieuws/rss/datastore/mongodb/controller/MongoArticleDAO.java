package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.ArticleDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller.mapping.util.MapUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoArticleRepository;

public class MongoArticleDAO implements ArticleDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoArticleDAO.class);
	@Autowired
	private Mapper mapper;
	@Autowired
	private MongoArticleRepository mongoArticleRepository;
	@Autowired
	private MongoMediumDAO mongoMediumDAO;
	@Autowired
	private MongoCategoryDAO mongoCategoryDAO;
	@Autowired
	private MongoAuthorDAO mongoAuthorDAO;

	@Override
	public ArticleDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find ArticleDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoArticle foundArticle=mongoArticleRepository.findOne(id);
			if(foundArticle!=null){
				return mapper.map(foundArticle,ArticleDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public ArticleDTOImpl save(final ArticleDTOImpl articleDTOImpl) {
		LOGGER.debug("Save ArticleDTOImpl:\n{}",articleDTOImpl);
		if(articleDTOImpl!=null){
			final List<MediumDTOImpl> mediumDTOImpls=new ArrayList<MediumDTOImpl>(articleDTOImpl.getMediumDTOs().size());
			for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()){
				mediumDTOImpls.add(mongoMediumDAO.save(mediumDTOImpl));
			}
			articleDTOImpl.setMediumDTOs(mediumDTOImpls);
			final List<CategoryDTOImpl> categoryDTOImpls=new ArrayList<CategoryDTOImpl>(articleDTOImpl.getCategoryDTOs().size());
			for(final CategoryDTOImpl categoryDTOImpl : articleDTOImpl.getCategoryDTOs()){
				categoryDTOImpls.add(mongoCategoryDAO.save(categoryDTOImpl));
			}
			articleDTOImpl.setCategoryDTOs(categoryDTOImpls);
			final List<AuthorDTOImpl> authorDTOImpls=new ArrayList<AuthorDTOImpl>(articleDTOImpl.getAuthorDTOs().size());
			for(final AuthorDTOImpl authorDTOImpl : articleDTOImpl.getAuthorDTOs()){
				authorDTOImpls.add(mongoAuthorDAO.save(authorDTOImpl));
			}
			articleDTOImpl.setAuthorDTOs(authorDTOImpls);
			final MongoArticle savedArticle=mongoArticleRepository.save(mapper.map(articleDTOImpl,MongoArticle.class));
			return mapper.map(savedArticle, ArticleDTOImpl.class);
		}
		return articleDTOImpl;
	}

	@Override
	public List<ArticleDTOImpl> findAll() {
		LOGGER.debug("Find all ArticleDTOImpl(s)");
		return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findAll(),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByTitle(final String title) {
		LOGGER.debug("Find ArticleDTOImpl(s) by title '{}'",title);
		if(title!=null && !title.isEmpty()){
			return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByTitle(title),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByPublicationDateBetween(final DateTime from,final DateTime to) {
		LOGGER.debug("Find ArticleDTOImpl(s) by publication date between '{}' and '{}'",from,to);
		if(from!=null && to!=null){
			return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByPublicationDateBetween(from.getMillis()-1, to.getMillis()+1),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByRead(final boolean read) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked read '{}'",read);
		return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByRead(read),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByFavorite(final boolean favorite) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked favorite '{}'",favorite);
		return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByFavorite(favorite),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByArchived(final boolean archived) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked archived '{}'",archived);
		return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByArchived(archived),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByCategory(final CategoryDTOImpl categoryDTOImpl) {
		LOGGER.debug("Find ArticleDTOImpl(s) by categoryDTOImpl '{}'",categoryDTOImpl);
		if(categoryDTOImpl!=null){
			return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByMongoCategories(mapper.map(categoryDTOImpl,MongoCategory.class)),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByAuthor(final AuthorDTOImpl authorDTOImpl) {
		LOGGER.debug("Find ArticleDTOImpl(s) by authorDTOImpl '{}'",authorDTOImpl);
		if(authorDTOImpl!=null){
			return MapUtil.map(mapper,(List<MongoArticle>)mongoArticleRepository.findByMongoAuthors(mapper.map(authorDTOImpl,MongoAuthor.class)),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public void delete(final ArticleDTOImpl articleDTOImpl) {
		LOGGER.debug("Delete ArticleDTOImpl:\n{}",articleDTOImpl);
		if(articleDTOImpl!=null && articleDTOImpl.getId()!=null){
			mongoArticleRepository.delete(mapper.map(articleDTOImpl,MongoArticle.class));
		}
	}

}
