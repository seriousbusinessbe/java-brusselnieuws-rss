package be.seriousbusiness.brusselnieuws.rss.reader.model.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.AuthorDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.AuthorNameComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.manager.AuthorManager;

public class AuthorManagerImpl implements AuthorManager {
	private AuthorDAO authorDAO;
	@Autowired
	private Mapper mapper;
	private static final Comparator<Author> authorComparator=new AuthorNameComparator();

	@Override
	public Collection<Author> findAll() {
		final List<Author> authors=new ArrayList<Author>();
		final Collection<AuthorDTOImpl> authorDTOImpls=authorDAO.findAll();
		if(authorDTOImpls!=null){
			for(final AuthorDTOImpl authorDTOImpl : authorDTOImpls){
				final Author author=mapper.map(authorDTOImpl, Author.class);
				authors.add(author);
			}
		}
		Collections.sort(authors,authorComparator);
		return authors;
	}
	
	public void setAuthorDAO(final AuthorDAO authorDAO){
		this.authorDAO=authorDAO;
	}

}
