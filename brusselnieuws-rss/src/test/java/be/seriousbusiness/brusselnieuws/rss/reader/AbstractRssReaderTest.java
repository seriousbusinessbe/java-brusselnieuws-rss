package be.seriousbusiness.brusselnieuws.rss.reader;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;

public class AbstractRssReaderTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(AbstractRssReaderTest.class);

	
	public static final void assertAdaptableFeed(final AdaptableFeed adaptableFeed){
		assertNotNull("The feed should not be null",adaptableFeed);
		assertNotNull("The feed title should not be null",adaptableFeed.getTitle());
		assertNotNull("The feed link should not be null",adaptableFeed.getLink());
		final List<Article> articles=adaptableFeed.getArticles();
		assertNotNull("The feed's list of articles should not be null",articles);
		for(final Article article : articles){
			assertNotNull("The article should not be null",article);
			assertNotNull("The article title should not be null",article.getTitle());
			assertNotNull("The article publication date should not be null",article.getPublicationDate());
			assertNotNull("The article link should not be null",article.getLink());
			assertNotNull("The article descripton should not be null",article.getDescription());
			final List<Author> authors=article.getAuthors();
			assertNotNull("The article's list of authors should not be null",authors);
			for(final Author author : authors){
				assertNotNull("The article's author should not be null",author);
				assertNotNull("The author name should not be null",author.getName());
			}
			final List<Category> categories=article.getCategories();
			assertNotNull("The article's list of categories should not be null",categories);
			for(final Category category : categories){
				assertNotNull("The article's category should not be null",category);
				assertNotNull("The category name should not be null",category.getName());
				assertNotNull("The category link should not be null",category.getLink());
			}
			final List<Medium> media=article.getMedia();
			assertNotNull("The article's list of medium's should not be null",media);
			for(final Medium medium : media){
				assertNotNull("The article's medium should not be null",medium);
				assertNotNull("The medium size should not be null",medium.getSize());
				assertNotNull("The medium type should not be null",medium.getType());
				assertNotNull("The medium link should not be null",medium.getLink());
				assertNotEquals("An unknown medium type is found",MediumType.UNKNOWN,medium.getType());
			}
		}
		LOGGER.debug("Live feed under test:\n{}",adaptableFeed);
	}

}
