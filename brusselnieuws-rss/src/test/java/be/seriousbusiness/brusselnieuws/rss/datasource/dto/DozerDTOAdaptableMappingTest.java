package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Id;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableArticle;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableAuthor;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableCategory;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableMedium;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableAuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableMediumImpl;

@ContextConfiguration("classpath:test-dozer-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DozerDTOAdaptableMappingTest {
	@Autowired
	private Mapper mapper;
	
	private final <ID,D extends DTO<ID>,I extends Id<ID>> void assertIdMapping(final D dto,final I id){
		assertNotNull("The dto cannot be null",dto);
		assertNotNull("The id connot be null",id);
		mapper.map(dto,id);
		assertEquals("The id is not correctly mapped",dto.getId(),id.getId());
	}
	
	@Test
	public void testCategoryDTOToAdaptableCategoryMapping(){
		final CategoryDTO categoryDTO=new SimpleSamenlevingCategoryDTOMock();
		final AdaptableCategory adaptableCategory=new AdaptableCategoryImpl();
		assertIdMapping(categoryDTO,adaptableCategory);
		assertEquals("The name is not correctly mapped",categoryDTO.getName(),adaptableCategory.getName());
		assertEquals("The link is not correctly mapped",categoryDTO.getLink(),adaptableCategory.getLink().toString());
	}
	
	@Test
	public void testAuthorDTOToAdaptableAuthorMapping(){
		final AuthorDTO authorDTO=new SimpleAuthorDTOMock();
		final AdaptableAuthor adaptableAuthor=new AdaptableAuthorImpl();
		assertIdMapping(authorDTO,adaptableAuthor);
		assertEquals("The name is not correctly mapped",authorDTO.getName(),adaptableAuthor.getName());
	}
	
	@Test
	public void testMediumDTOToAdaptableMediumMapping(){
		final MediumDTO mediumDTO=new SimpleJpegMediumDTOMock();
		final AdaptableMedium adaptableMedium=new AdaptableMediumImpl();
		mapper.map(mediumDTO,adaptableMedium);
		assertEquals("The link is not correctly mapped",mediumDTO.getLink(),adaptableMedium.getLink().toString());
		assertEquals("The size is not correctly mapped",mediumDTO.getSize(),adaptableMedium.getSize(),0.0);
		assertEquals("The medium type is not correctly mapped",MediumType.find(mediumDTO.getMediumTypeDTO().getType()),adaptableMedium.getType());
	}
	
	@Test
	public void testArticleDTOToAdaptableArticleMapping(){
		final ArticleDTO articleDTO=new SimpleArticleDTOMock();
		final AdaptableArticle adaptableArticle=new AdaptableArticleImpl();
		mapper.map(articleDTO,adaptableArticle);
		assertEquals("The link is not correctly mapped",articleDTO.getLink(),adaptableArticle.getLink().toString());
		assertEquals("The description is not correctly mapped",articleDTO.getDescription(),adaptableArticle.getDescription());
		assertEquals("The publication date is not correctly mapped",new DateTime(articleDTO.getPublicationDate()),adaptableArticle.getPublicationDate());
		assertEquals("The title is not correctly mapped",articleDTO.getTitle(),adaptableArticle.getTitle());
		assertEquals("The archived is not correctly mapped",articleDTO.isArchived(),adaptableArticle.isArchived());
		assertEquals("The read is not correctly mapped",articleDTO.isRead(),adaptableArticle.isRead());
		assertEquals("The favorite is not correctly mapped",articleDTO.isFavorite(),adaptableArticle.isFavorite());
		assertEquals("The collection of authors is not correctly mapped",articleDTO.getAuthorDTOs().size(),adaptableArticle.getAuthors().size());
		assertEquals("The collection of categories is not correctly mapped",articleDTO.getCategoryDTOs().size(),adaptableArticle.getCategories().size());
		assertEquals("The collection of mediums is not correctly mapped",articleDTO.getMediumDTOs().size(),adaptableArticle.getMedia().size());
	}
	
	@Ignore
	@Test
	public void testArticleDTOToAdaptableArticleDeepMapping(){
		final ArticleDTO articleDTO=new CompleteArticleDTOMock();
		final AdaptableArticle adaptableArticle=new AdaptableArticleImpl();
		mapper.map(articleDTO,adaptableArticle);
		assertEquals("The link is not correctly mapped",articleDTO.getLink(),adaptableArticle.getLink().toString());
		assertEquals("The description is not correctly mapped",articleDTO.getDescription(),adaptableArticle.getDescription());
		assertEquals("The publication date is not correctly mapped",new DateTime(articleDTO.getPublicationDate()),adaptableArticle.getPublicationDate());
		assertEquals("The title is not correctly mapped",articleDTO.getTitle(),adaptableArticle.getTitle());
		assertEquals("The archived is not correctly mapped",articleDTO.isArchived(),adaptableArticle.isArchived());
		assertEquals("The read is not correctly mapped",articleDTO.isRead(),adaptableArticle.isRead());
		assertEquals("The favorite is not correctly mapped",articleDTO.isFavorite(),adaptableArticle.isFavorite());
		final Set<AuthorDTO> authorDTOs=articleDTO.getAuthorDTOs();
		final List<Author> authors=adaptableArticle.getAuthors();
		assertEquals("The collection of authors is not correctly mapped",authorDTOs.size(),authors.size());
		for(final AuthorDTO authorDTO : authorDTOs){
			//authors.c
		}
		assertEquals("The collection of categories is not correctly mapped",articleDTO.getCategoryDTOs().size(),adaptableArticle.getCategories().size());
		assertEquals("The collection of mediums is not correctly mapped",articleDTO.getMediumDTOs().size(),adaptableArticle.getMedia().size());
	}

}
