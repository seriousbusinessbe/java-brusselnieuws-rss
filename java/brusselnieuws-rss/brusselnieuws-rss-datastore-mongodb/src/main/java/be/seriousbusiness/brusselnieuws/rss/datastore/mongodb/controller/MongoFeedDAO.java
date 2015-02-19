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
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.FeedDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoFeed;
import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.repository.MongoFeedRepository;

/**
 * MongoDb {@link FeedDAO} implementation. 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MongoFeedDAO implements FeedDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoFeedDAO.class);
	@Autowired(required=true)
	@Qualifier("brusselNieuwsRssDatastoreMongoDbDozerBeanMapper")
	private Mapper mapper;
	@Autowired
	private MongoFeedRepository mongoFeedRepository;
	@Autowired
	private MongoArticleDAO mongoArticleDAO;

	@Override
	public FeedDTOImpl findById(final BigInteger id) {
		LOGGER.debug("Find FeedDTOImpl by id '{}'",id);
		if(id!=null){
			final MongoFeed foundFeed=mongoFeedRepository.findOne(id);
			if(foundFeed!=null){
				return mapper.map(foundFeed,FeedDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public FeedDTOImpl save(final FeedDTOImpl feedDTOImpl) {
		LOGGER.debug("Save FeedDTOImpl:\n{}",feedDTOImpl);
		if(feedDTOImpl!=null){
			FeedDTOImpl saveableFeedDTOImpl=null;
			if(feedDTOImpl.getId()==null) {
				final FeedDTOImpl foundByLinkFeedDTOImpl=findByLink(feedDTOImpl.getLink());
				if(foundByLinkFeedDTOImpl==null) { // New feed:
					final List<ArticleDTOImpl> articleDTOImpls=new ArrayList<ArticleDTOImpl>(feedDTOImpl.getArticleDTOs().size());
					for(final ArticleDTOImpl articleDTOImpl : feedDTOImpl.getArticleDTOs()){
						articleDTOImpls.add(mapper.map(mongoArticleDAO.save(articleDTOImpl),ArticleDTOImpl.class));
					}
					feedDTOImpl.setArticleDTOs(articleDTOImpls);
					saveableFeedDTOImpl=feedDTOImpl;
				}else { // Existing feed:
					final FeedDTOImpl clonedFeedDTOImpl=(FeedDTOImpl) feedDTOImpl.clone();
					clonedFeedDTOImpl.setId(foundByLinkFeedDTOImpl.getId());
					if(clonedFeedDTOImpl.equals(foundByLinkFeedDTOImpl)) {
						return foundByLinkFeedDTOImpl;
					}
					foundByLinkFeedDTOImpl.setDescription(feedDTOImpl.getDescription());
					foundByLinkFeedDTOImpl.setLink(feedDTOImpl.getLink());
					foundByLinkFeedDTOImpl.setTitle(feedDTOImpl.getTitle());
					for(final ArticleDTOImpl articleDTOImpl : feedDTOImpl.getArticleDTOs()){
						foundByLinkFeedDTOImpl.add(mapper.map(mongoArticleDAO.save(articleDTOImpl),ArticleDTOImpl.class));
					}
					saveableFeedDTOImpl=foundByLinkFeedDTOImpl;
				}
			}else {
				final FeedDTOImpl foundByIdFeedDTOImpl=findById(feedDTOImpl.getId());
				if(feedDTOImpl.equals(foundByIdFeedDTOImpl)) {
					return foundByIdFeedDTOImpl;
				}
				foundByIdFeedDTOImpl.setDescription(feedDTOImpl.getDescription());
				foundByIdFeedDTOImpl.setLink(feedDTOImpl.getLink());
				foundByIdFeedDTOImpl.setTitle(feedDTOImpl.getTitle());
				for(final ArticleDTOImpl articleDTOImpl : feedDTOImpl.getArticleDTOs()){
					foundByIdFeedDTOImpl.add(mapper.map(mongoArticleDAO.save(articleDTOImpl),ArticleDTOImpl.class));
				}
				saveableFeedDTOImpl=foundByIdFeedDTOImpl;
			}
			if(saveableFeedDTOImpl!=null) {
				final MongoFeed savedFeed=mongoFeedRepository.save(mapper.map(saveableFeedDTOImpl,MongoFeed.class));
				return mapper.map(savedFeed, FeedDTOImpl.class);
			}
		}
		return feedDTOImpl;
	}

	@Override
	public List<FeedDTOImpl> findAll() {
		LOGGER.debug("Find all FeedDTOImpl(s)");
		return MapperUtil.map(mapper,(Collection<MongoFeed>)mongoFeedRepository.findAll(),FeedDTOImpl.class);
	}

	@Override
	public FeedDTOImpl findByLink(final String link) {
		LOGGER.debug("Find FeedDTOImpl by link '{}'",link);
		if(link!=null && !link.isEmpty()){
			final MongoFeed foundFeed=mongoFeedRepository.findByLink(link);
			if(foundFeed!=null){
				return mapper.map(foundFeed,FeedDTOImpl.class);
			}
		}
		return null;
	}

	@Override
	public void delete(final FeedDTOImpl feedDTOImpl) {
		LOGGER.debug("Delete FeedDTOImpl:\n{}",feedDTOImpl);
		if(feedDTOImpl!=null && feedDTOImpl.getId()!=null){
			mongoFeedRepository.delete(mapper.map(feedDTOImpl,MongoFeed.class));
		}
	}

}
