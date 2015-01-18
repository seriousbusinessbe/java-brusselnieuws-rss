package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;


import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CategoryDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.CategoryImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util.CategoryDTOCategoryMapperUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brussel-rss-reader-model-dozer-config.xml")
public class CategoryDTOImplCategoryImplMapperTest {
	@Autowired
	private Mapper mapper;
	
	@Test
	public void testCategoryDTOImplToCategoryImplMapping() throws IOException{
		final CategoryDTOImpl categoryDTOImpl=CategoryDTOImplFactory.createNewPolitiek();
		final CategoryImpl categoryImpl=mapper.map(categoryDTOImpl, CategoryImpl.class);
		CategoryDTOCategoryMapperUtil.assertEquals(categoryDTOImpl, categoryImpl);
	}
	
	@Test
	public void testCategoryImplToCategoryDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final CategoryImpl categoryImpl=CategoryImplFactory.createStad();
		final CategoryDTOImpl categoryDTOImpl=mapper.map(categoryImpl,CategoryDTOImpl.class);
		CategoryDTOCategoryMapperUtil.assertEquals(categoryDTOImpl, categoryImpl);
	}

}
