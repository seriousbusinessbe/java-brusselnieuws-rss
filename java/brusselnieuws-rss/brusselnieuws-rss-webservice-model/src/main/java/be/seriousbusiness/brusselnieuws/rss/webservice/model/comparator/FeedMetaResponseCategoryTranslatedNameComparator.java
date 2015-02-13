package be.seriousbusiness.brusselnieuws.rss.webservice.model.comparator;

import java.util.Comparator;

import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaResponse;

/**
 * Compares {@link FeedMetaResponse}s by category and translated name.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedMetaResponseCategoryTranslatedNameComparator implements Comparator<FeedMetaResponse> {

	/**
	 * Compares {@link FeedMetaResponse}s by category and translated name.
	 */
	@Override
	public int compare(final FeedMetaResponse feedMetaResponse1,final FeedMetaResponse feedMetaResponse2) {
		final int categoryComparison=feedMetaResponse1.getCategory().compareTo(feedMetaResponse2.getCategory());
		if(categoryComparison==0) {
			return feedMetaResponse1.getTranslatedName().compareTo(feedMetaResponse2.getTranslatedName());
		}
		return categoryComparison;
	}

}
