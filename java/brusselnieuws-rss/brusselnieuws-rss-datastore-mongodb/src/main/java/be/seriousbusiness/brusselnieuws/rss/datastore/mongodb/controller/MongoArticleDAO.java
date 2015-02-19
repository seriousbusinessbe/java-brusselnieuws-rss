package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be.seriousbusiness.brusselnieuws.rss.common.mapping.util.MapperUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.ArticleDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoArticle;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoAuthor;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCategory;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoArticleRepository;

/**
 * MongoDb {@link ArticleDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoArticleDAO implements ArticleDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoArticleDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
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
			ArticleDTOImpl saveableArticleDTOImpl=null;
			if(articleDTOImpl.getId()==null) {
				final ArticleDTOImpl foundByTitleAndPublicationDateArticleDTOImpl=findFirstByTitle(articleDTOImpl.getTitle());
				if(foundByTitleAndPublicationDateArticleDTOImpl==null) { // New article:
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
					saveableArticleDTOImpl=articleDTOImpl;
				}else { // Existing article:
					final ArticleDTOImpl clonedArticleDTOImpl=(ArticleDTOImpl) articleDTOImpl.clone();
					clonedArticleDTOImpl.setId(foundByTitleAndPublicationDateArticleDTOImpl.getId());
					if(clonedArticleDTOImpl.equals(foundByTitleAndPublicationDateArticleDTOImpl)) {
						return foundByTitleAndPublicationDateArticleDTOImpl;
					}
					foundByTitleAndPublicationDateArticleDTOImpl.setArchived(articleDTOImpl.isArchived());
					foundByTitleAndPublicationDateArticleDTOImpl.setDescription(articleDTOImpl.getDescription());
					foundByTitleAndPublicationDateArticleDTOImpl.setFavorite(articleDTOImpl.isFavorite());
					foundByTitleAndPublicationDateArticleDTOImpl.setLink(articleDTOImpl.getLink());
					foundByTitleAndPublicationDateArticleDTOImpl.setPublicationDate(articleDTOImpl.getPublicationDate());
					foundByTitleAndPublicationDateArticleDTOImpl.setRead(articleDTOImpl.isRead());
					foundByTitleAndPublicationDateArticleDTOImpl.setTitle(articleDTOImpl.getTitle());
					for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()){
						foundByTitleAndPublicationDateArticleDTOImpl.add(mongoMediumDAO.save(mediumDTOImpl));
					}
					for(final CategoryDTOImpl categoryDTOImpl : articleDTOImpl.getCategoryDTOs()){
						foundByTitleAndPublicationDateArticleDTOImpl.add(mongoCategoryDAO.save(categoryDTOImpl));
					}
					for(final AuthorDTOImpl authorDTOImpl : articleDTOImpl.getAuthorDTOs()){
						foundByTitleAndPublicationDateArticleDTOImpl.add(mongoAuthorDAO.save(authorDTOImpl));
					}
					saveableArticleDTOImpl=foundByTitleAndPublicationDateArticleDTOImpl;
				}
			}else { // Existing article:
				final ArticleDTOImpl foundByIdArticleDTOImpl=findById(articleDTOImpl.getId());
				if(articleDTOImpl.equals(foundByIdArticleDTOImpl)) {
					return foundByIdArticleDTOImpl;
				}
				foundByIdArticleDTOImpl.setArchived(articleDTOImpl.isArchived());
 				foundByIdArticleDTOImpl.setDescription(articleDTOImpl.getDescription());
				foundByIdArticleDTOImpl.setFavorite(articleDTOImpl.isFavorite());
				foundByIdArticleDTOImpl.setLink(articleDTOImpl.getLink());
				foundByIdArticleDTOImpl.setPublicationDate(articleDTOImpl.getPublicationDate());
				foundByIdArticleDTOImpl.setRead(articleDTOImpl.isRead());
				foundByIdArticleDTOImpl.setTitle(articleDTOImpl.getTitle());
				for(final MediumDTOImpl mediumDTOImpl : articleDTOImpl.getMediumDTOs()){
					foundByIdArticleDTOImpl.add(mongoMediumDAO.save(mediumDTOImpl));
				}
				for(final CategoryDTOImpl categoryDTOImpl : articleDTOImpl.getCategoryDTOs()){
					foundByIdArticleDTOImpl.add(mongoCategoryDAO.save(categoryDTOImpl));
				}
				for(final AuthorDTOImpl authorDTOImpl : articleDTOImpl.getAuthorDTOs()){
					foundByIdArticleDTOImpl.add(mongoAuthorDAO.save(authorDTOImpl));
				}
				saveableArticleDTOImpl=foundByIdArticleDTOImpl;
			}
			if(saveableArticleDTOImpl!=null) {
				final MongoArticle savedArticle=mongoArticleRepository.save(mapper.map(saveableArticleDTOImpl,MongoArticle.class));
				return mapper.map(savedArticle, ArticleDTOImpl.class);
			}
		}
		return articleDTOImpl;
	}

	@Override
	public List<ArticleDTOImpl> findAll() {
		LOGGER.debug("Find all ArticleDTOImpl(s)");
		return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findAll(),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByTitle(final String title) {
		LOGGER.debug("Find ArticleDTOImpl(s) by title '{}'",title);
		if(title!=null && !title.isEmpty()){
			return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByTitle(title),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByPublicationDateBetween(final DateTime from,final DateTime to) {
		LOGGER.debug("Find ArticleDTOImpl(s) by publication date between '{}' and '{}'",from,to);
		if(from!=null && to!=null){
			return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByPublicationDateBetween(from.getMillis()-1, to.getMillis()+1),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByRead(final boolean read) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked read '{}'",read);
		return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByRead(read),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByFavorite(final boolean favorite) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked favorite '{}'",favorite);
		return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByFavorite(favorite),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByArchived(final boolean archived) {
		LOGGER.debug("Find ArticleDTOImpl(s) marked archived '{}'",archived);
		return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByArchived(archived),ArticleDTOImpl.class);
	}

	@Override
	public List<ArticleDTOImpl> findByCategory(final CategoryDTOImpl categoryDTOImpl) {
		LOGGER.debug("Find ArticleDTOImpl(s) by categoryDTOImpl '{}'",categoryDTOImpl);
		if(categoryDTOImpl!=null){
			return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByMongoCategories(mapper.map(categoryDTOImpl,MongoCategory.class)),ArticleDTOImpl.class);
		}
		return new ArrayList<ArticleDTOImpl>();
	}

	@Override
	public List<ArticleDTOImpl> findByAuthor(final AuthorDTOImpl authorDTOImpl) {
		LOGGER.debug("Find ArticleDTOImpl(s) by authorDTOImpl '{}'",authorDTOImpl);
		if(authorDTOImpl!=null){
			return MapperUtil.map(mapper,(Collection<MongoArticle>)mongoArticleRepository.findByMongoAuthors(mapper.map(authorDTOImpl,MongoAuthor.class)),ArticleDTOImpl.class);
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

	@Override
	public ArticleDTOImpl findByTitleAndPublicationDate(final String title,final DateTime publicationDate) {
		LOGGER.debug("Find ArticleDTOImpl by title '{}' and publication date '{}'",title,publicationDate);
		if(title!=null && publicationDate!=null) {
			final MongoArticle mongoArticle=mongoArticleRepository.findByTitleAndPublicationDate(title,publicationDate.getMillis());
			if(mongoArticle!=null) {
				return mapper.map(mongoArticle,ArticleDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public ArticleDTOImpl findFirstByTitle(final String title) {
		LOGGER.debug("Find first ArticleDTOImpl by title '{}'",title);
		if(title!=null) {
			final MongoArticle mongoArticle=mongoArticleRepository.findFirstByTitle(title);
			if(mongoArticle!=null) {
				return mapper.map(mongoArticle,ArticleDTOImpl.class);
			}
		}
		return null;
	}

}
