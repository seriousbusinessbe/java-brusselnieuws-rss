package be.seriousbusiness.brusselnieuws.rss.webservice.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedCategoryResponse;
 
/**
 * Compares {@link FeedCategoryResponse}s by translated name.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedCategoryResponseTranslatedNameComparator implements Comparator<FeedCategoryResponse> {

	/**
	 * Compares {@link FeedCategoryResponse}s by translated name.
	 */
	@Override
	public int compare(final FeedCategoryResponse feedCategoryResponse1,final FeedCategoryResponse feedCategoryResponse2) {
		return feedCategoryResponse1.getTranslatedName().compareTo(feedCategoryResponse2.getTranslatedName());
	}

}
