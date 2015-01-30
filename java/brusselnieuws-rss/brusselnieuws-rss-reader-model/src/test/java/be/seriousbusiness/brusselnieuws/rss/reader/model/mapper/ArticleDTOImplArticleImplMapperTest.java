package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper;

import java.io.IOException;
import java.net.MalformedURLException;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.ArticleDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.ArticleImplFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util.ArticleDTOArticleMapperUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-model-dozer-config.xml")
public class ArticleDTOImplArticleImplMapperTest {
	@Autowired
	private Mapper mapper;
	
	@Test
	public void testArticleDTOImplToArticleImplMapping() throws IOException{
		final ArticleDTOImpl articleDTOImpl=ArticleDTOImplFactory.createArticleMichelBorcy();
		final ArticleImpl articleImpl=mapper.map(articleDTOImpl, ArticleImpl.class);
		ArticleDTOArticleMapperUtil.assertEquals(articleDTOImpl, articleImpl);
	}
	
	@Test
	public void testArticleImplToArticleDTOImplMapping() throws IllegalArgumentException, MalformedURLException{
		final ArticleImpl articleImpl=ArticleImplFactory.create();
		final ArticleDTOImpl articleDTOImpl=mapper.map(articleImpl,ArticleDTOImpl.class);
		ArticleDTOArticleMapperUtil.assertEquals(articleDTOImpl, articleImpl);
	}

}
