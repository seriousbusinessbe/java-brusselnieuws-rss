package be.seriousbusiness.brusselnieuws.rss.reader.model.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.CategoryDAO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.comparator.CategoryNameComparator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.manager.CategoryManager;

public class CategoryManagerImpl implements CategoryManager {
	private CategoryDAO categoryDAO;
	@Autowired
	private Mapper mapper;
	private static final Comparator<Category> categoryComparator=new CategoryNameComparator();
	
	@Override
	public Collection<Category> findAll(){
		final List<Category> categories=new ArrayList<Category>();
		final Collection<CategoryDTOImpl> categoryDTOImpls=categoryDAO.findAll();
		if(categoryDTOImpls!=null){
			for(final CategoryDTOImpl categoryDTOImpl : categoryDTOImpls){
				final Category category=mapper.map(categoryDTOImpl, Category.class);
				categories.add(category);
			}
		}
		Collections.sort(categories,categoryComparator);
		return categories;
	}
	
	public void setCategoryDAO(final CategoryDAO categoryDAO){
		this.categoryDAO=categoryDAO;
	}

}
