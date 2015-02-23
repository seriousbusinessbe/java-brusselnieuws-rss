package be.seriousbusiness.brusselnieuws.rss.reader.model.mapper.util;

import org.junit.Assert;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CreatorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;

public class ArticleDTOArticleMapperUtil {
	
	/**
	 * Assert if a {@link ArticleDTO} and {@link Article} are equal.
	 * @param articleDTO
	 * @param article
	 */
	public static final void assertEquals(final ArticleDTO<?,?,?,?,?> articleDTO,final Article<?,?,?,?,?> article){		
		Assert.assertEquals("The ids are not equal",articleDTO.getId(),article.getId());
		Assert.assertEquals("The articles are not equally marked archived",articleDTO.isArchived(),article.isArchived());
		Assert.assertEquals("The articles are not equally marked archived",articleDTO.getArchived(),article.isArchived());
		Assert.assertEquals("The descriptions are not equal",articleDTO.getDescription(),article.getDescription());
		Assert.assertEquals("The articles are not equally marked favorite",articleDTO.isFavorite(),article.isFavorite());
		Assert.assertEquals("The articles are not equally marked favorite",articleDTO.getFavorite(),article.isFavorite());
		Assert.assertEquals("The links are not equal",articleDTO.getLink(),article.getLink().toString());
		Assert.assertEquals("The publication dates are not equal",articleDTO.getPublicationDate(),article.getPublicationDate().getMillis(),0.0);
		Assert.assertEquals("The articles are not equally marked read",articleDTO.isRead(),article.isRead());
		Assert.assertEquals("The articles are not equally marked read",articleDTO.getRead(),article.isRead());
		Assert.assertEquals("The titles are not equal",articleDTO.getTitle(),article.getTitle());
		// Categories:
		Assert.assertEquals("The categories are not equal",articleDTO.getCategoryDTOs().size(),article.getCategories().size());
		int i=0;
		for(final CategoryDTO categoryDTO : articleDTO.getCategoryDTOs()){
			for(final Category category : article.getCategories()){
				if(categoryDTO.getId().equals(category.getId())){
					CategoryDTOCategoryMapperUtil.assertEquals(categoryDTO, category);
					i++;
				}
			}
		}
		Assert.assertEquals("Not all categories are equal",articleDTO.getCategoryDTOs().size(),i);
		Assert.assertEquals("Not all categories are equal",article.getCategories().size(),i);
		// Authors:
		Assert.assertEquals("The authors are not equal",articleDTO.getAuthorDTOs().size(),article.getAuthors().size());
		i=0;
		for(final AuthorDTO authorDTO : articleDTO.getAuthorDTOs()){
			for(final Author author : article.getAuthors()){
				if(authorDTO.getId().equals(author.getId())){
					AuthorDTOAuthorMapperUtil.assertEquals(authorDTO, author);
					i++;
				}
			}
		}
		Assert.assertEquals("Not all authors are equal",articleDTO.getAuthorDTOs().size(),i);
		Assert.assertEquals("Not all authors are equal",article.getAuthors().size(),i);
		// Mediums:
		Assert.assertEquals("The mediums are not equal",articleDTO.getMediumDTOs().size(),article.getMedia().size());
		i=0;
		for(final MediumDTO<?> mediumDTO : articleDTO.getMediumDTOs()){
			for(final Medium<?> medium : article.getMedia()){
				if(mediumDTO.getLink().equals(medium.getLink().toString())){
					MediumDTOMediumMapperUtil.assertEquals(mediumDTO, medium);
					i++;
				}
			}
		}
		Assert.assertEquals("Not all mediums are equal",articleDTO.getMediumDTOs().size(),i);
		Assert.assertEquals("Not all mediums are equal",article.getMedia().size(),i);
		// Creators:
		Assert.assertEquals("The creators are not equal",articleDTO.getCreatorDTOs().size(),article.getCreators().size());
		i=0;
		for(final CreatorDTO creatorDTO : articleDTO.getCreatorDTOs()){
			for(final Creator creator : article.getCreators()){
				if(creatorDTO.getId().equals(creator.getId())){
					CreatorDTOCreatorMapperUtil.assertEquals(creatorDTO,creator);
					i++;
				}
			}
		}
		Assert.assertEquals("Not all creators are equal",articleDTO.getCreatorDTOs().size(),i);
		Assert.assertEquals("Not all creators are equal",article.getCreators().size(),i);
	}

}
