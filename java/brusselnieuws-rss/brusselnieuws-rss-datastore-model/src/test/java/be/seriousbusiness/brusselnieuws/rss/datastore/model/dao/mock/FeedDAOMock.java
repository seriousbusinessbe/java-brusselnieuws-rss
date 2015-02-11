package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.mock;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.FeedDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception.NotUniqueException;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.FeedDTOImpl;

public class FeedDAOMock implements FeedDAO {
	private Set<FeedDTOImpl> feedDTOImpls=new HashSet<FeedDTOImpl>();

	@Override
	public FeedDTOImpl findById(final BigInteger id) {
		for(final FeedDTOImpl feedDTOImpl : feedDTOImpls) {
			if(feedDTOImpl.getId().equals(id)) {
				return feedDTOImpl;
			}
		}
		return null;
	}

	@Override
	public FeedDTOImpl save(final FeedDTOImpl dto) throws NotUniqueException {
		if(feedDTOImpls.contains(dto)) {
			delete(dto);
		}
		feedDTOImpls.add(dto);
		return dto;
	}

	@Override
	public Collection<FeedDTOImpl> findAll() {
		return new HashSet<FeedDTOImpl>(feedDTOImpls);
	}

	@Override
	public void delete(final FeedDTOImpl dto) {
		final Iterator<FeedDTOImpl> feedDTOImplsIterator=feedDTOImpls.iterator();
		while(feedDTOImplsIterator.hasNext()) {
			final FeedDTOImpl feedDTOImpl=feedDTOImplsIterator.next();
			if(feedDTOImpl.getId().equals(dto.getId())) {
				feedDTOImplsIterator.remove();
			}
		}
	}

	@Override
	public FeedDTOImpl findByLink(final String link) {
		for(final FeedDTOImpl feedDTOImpl : feedDTOImpls) {
			if(feedDTOImpl.getLink().equals(link)) {
				return feedDTOImpl;
			}
		}
		return null;
	}

}
