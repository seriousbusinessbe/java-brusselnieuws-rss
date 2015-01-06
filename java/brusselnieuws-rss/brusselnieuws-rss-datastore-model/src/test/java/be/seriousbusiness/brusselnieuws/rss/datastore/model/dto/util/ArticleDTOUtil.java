package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import java.util.List;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

public class ArticleDTOUtil {
	
	@SuppressWarnings("unchecked")
	public static final void assertEquals(final ArticleDTO<?,?,?,?> articleDTOA,final ArticleDTO<?,?,?,?> articleDTOB) {
		Assert.assertNotNull("ArticleDTO A cannot be null",articleDTOA);
		Assert.assertNotNull("ArticleDTO B cannot be null",articleDTOB);
		Assert.assertEquals("The ArticleDTO ids are not equal",articleDTOA.getId(), articleDTOB.getId());
		Assert.assertEquals("The ArticleDTO titles are not equal",articleDTOA.getTitle(), articleDTOB.getTitle());
		Assert.assertEquals("The ArticleDTO links are not equal",articleDTOA.getLink(), articleDTOB.getLink());
		Assert.assertEquals("The ArticleDTO descriptions are not equal",articleDTOA.getDescription(), articleDTOB.getDescription());
		Assert.assertEquals("The ArticleDTO publication dates are not equal",articleDTOA.getPublicationDate(), articleDTOB.getPublicationDate());
		Assert.assertEquals("The ArticleDTO is read are not equal",articleDTOA.isRead(), articleDTOB.isRead());
		Assert.assertEquals("The ArticleDTO is archived are not equal",articleDTOA.isArchived(), articleDTOB.isArchived());
		Assert.assertEquals("The ArticleDTO is favorite are not equal",articleDTOA.isFavorite(), articleDTOB.isFavorite());
		assertEqualsAuthorDTOList((List<AuthorDTO>)articleDTOA.getAuthorDTOs(), (List<AuthorDTO>)articleDTOB.getAuthorDTOs());
		assertEqualsCategoryDTOList((List<CategoryDTO>)articleDTOA.getCategoryDTOs(), (List<CategoryDTO>)articleDTOB.getCategoryDTOs());
		assertEqualsMediumDTOList((List<MediumDTO<?>>)articleDTOA.getMediumDTOs(), (List<MediumDTO<?>>)articleDTOB.getMediumDTOs());
	}
	
	private static final void assertEqualsAuthorDTOList(final List<AuthorDTO> authorDTOAs,final List<AuthorDTO> authorDTOBs){
		Assert.assertNotNull("ArticleDTO A List of AuthorDTO cannot be null",authorDTOAs);
		Assert.assertNotNull("ArticleDTO B List of AuthorDTO cannot be null",authorDTOBs);
		int numberOfAsserted=0;
		for(final AuthorDTO authorDTOA : authorDTOAs){
			for(final AuthorDTO authorDTOB : authorDTOBs){
				if(authorDTOB.getId()==authorDTOA.getId()){
					AuthorDTOUtil.assertEquals(authorDTOA, authorDTOB);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of AuthorDTO is not equal",authorDTOAs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of AuthorDTO is not equal",authorDTOBs.size(),numberOfAsserted);
	}
	
	private static final void assertEqualsCategoryDTOList(final List<CategoryDTO> categoryDTOAs,final List<CategoryDTO> categoryDTOBs){
		Assert.assertNotNull("ArticleDTO A List of CategoryDTO cannot be null",categoryDTOAs);
		Assert.assertNotNull("ArticleDTO B List of CategoryDTO cannot be null",categoryDTOBs);
		int numberOfAsserted=0;
		for(final CategoryDTO categoryDTOA : categoryDTOAs){
			for(final CategoryDTO categoryDTOB : categoryDTOBs){
				if(categoryDTOB.getId()==categoryDTOA.getId()){
					CategoryDTOUtil.assertEquals(categoryDTOA, categoryDTOB);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of CategoryDTO is not equal",categoryDTOAs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of CategoryDTO is not equal",categoryDTOBs.size(),numberOfAsserted);
	}
	
	private static final void assertEqualsMediumDTOList(final List<MediumDTO<?>> mediumDTOAs,final List<MediumDTO<?>> mediumDTOBs){
		Assert.assertNotNull("ArticleDTO A List of MediumDTO cannot be null",mediumDTOAs);
		Assert.assertNotNull("ArticleDTO B List of MediumDTO cannot be null",mediumDTOBs);
		int numberOfAsserted=0;
		for(final MediumDTO<?> mediumDTOA : mediumDTOAs){
			for(final MediumDTO<?> mediumDTOB : mediumDTOBs){
				if(mediumDTOB.getLink().equals(mediumDTOA.getLink())){
					MediumDTOUtil.assertEquals(mediumDTOA, mediumDTOB);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of MediumDTO is not equal",mediumDTOAs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of MediumDTO is not equal",mediumDTOBs.size(),numberOfAsserted);
	}

}
