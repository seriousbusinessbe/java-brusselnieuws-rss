package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import java.math.BigInteger;
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
	
	private static final void assertEqualsAuthorDTOList(final List<AuthorDTO> articleDTOAAuthorDTOs,final List<AuthorDTO> articleDTOBAuthorDTOs){
		Assert.assertNotNull("ArticleDTO A List of AuthorDTO cannot be null",articleDTOAAuthorDTOs);
		Assert.assertNotNull("ArticleDTO B List of AuthorDTO cannot be null",articleDTOBAuthorDTOs);
		int numberOfAsserted=0;
		for(final AuthorDTO articleDTOAAuthorDTO : articleDTOAAuthorDTOs){
			final BigInteger articleDTOAAuthorDTOId=articleDTOAAuthorDTO.getId();
			for(final AuthorDTO articleDTOBAuthorDTO : articleDTOBAuthorDTOs){
				if(articleDTOBAuthorDTO.getId()==articleDTOAAuthorDTOId){
					AuthorDTOUtil.assertEquals(articleDTOAAuthorDTO, articleDTOBAuthorDTO);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of AuthorDTO is not equal",articleDTOAAuthorDTOs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of AuthorDTO is not equal",articleDTOBAuthorDTOs.size(),numberOfAsserted);
	}
	
	private static final void assertEqualsCategoryDTOList(final List<CategoryDTO> articleDTOACategoryDTOs,final List<CategoryDTO> articleDTOBCategoryDTOs){
		Assert.assertNotNull("ArticleDTO A List of CategoryDTO cannot be null",articleDTOACategoryDTOs);
		Assert.assertNotNull("ArticleDTO B List of CategoryDTO cannot be null",articleDTOBCategoryDTOs);
		int numberOfAsserted=0;
		for(final CategoryDTO articleDTOACategoryDTO : articleDTOACategoryDTOs){
			final BigInteger articleDTOACategoryDTOId=articleDTOACategoryDTO.getId();
			for(final CategoryDTO articleDTOBCategoryDTO : articleDTOBCategoryDTOs){
				if(articleDTOBCategoryDTO.getId()==articleDTOACategoryDTOId){
					CategoryDTOUtil.assertEquals(articleDTOACategoryDTO, articleDTOBCategoryDTO);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of CategoryDTO is not equal",articleDTOACategoryDTOs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of CategoryDTO is not equal",articleDTOBCategoryDTOs.size(),numberOfAsserted);
	}
	
	private static final void assertEqualsMediumDTOList(final List<MediumDTO<?>> articleDTOAMediumDTOs,final List<MediumDTO<?>> articleDTOBMediumDTOs){
		Assert.assertNotNull("ArticleDTO A List of MediumDTO cannot be null",articleDTOAMediumDTOs);
		Assert.assertNotNull("ArticleDTO B List of MediumDTO cannot be null",articleDTOBMediumDTOs);
		int numberOfAsserted=0;
		for(final MediumDTO<?> articleDTOAMediumDTO : articleDTOAMediumDTOs){
			final String articleDTOACategoryDTOLink=articleDTOAMediumDTO.getLink();
			for(final MediumDTO<?> articleDTOBAuthorDTO : articleDTOBMediumDTOs){
				if(articleDTOBAuthorDTO.getLink().equals(articleDTOACategoryDTOLink)){
					MediumDTOUtil.assertEquals(articleDTOAMediumDTO, articleDTOBAuthorDTO);
					numberOfAsserted++;
				}
			}
		}
		Assert.assertEquals("ArticleDTO A List of MediumDTO is not equal",articleDTOAMediumDTOs.size(),numberOfAsserted);
		Assert.assertEquals("ArticleDTO B List of MediumDTO is not equal",articleDTOBMediumDTOs.size(),numberOfAsserted);
	}

}
