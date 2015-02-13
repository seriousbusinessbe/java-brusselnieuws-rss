package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

/**
 * Lists all feed categories.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public enum FeedCategoryMetaEnum {
	NEWS("Nieuws"),
	CULTURE("Cultuur"),
	FOOD_AND_DRINKS("Eten en drinken"),
	OPINION("Opinie"),
	MUNICIPALITY("Gemeenten");
	
	private String translatedName;
	
	private FeedCategoryMetaEnum(final String translatedName) {
		this.translatedName=translatedName;
	}
	
	/**
	 * Returns this category translated name.
	 * @return category translated name
	 */
	public String getTranslatedName() {
		return translatedName;
	}
	
	/**
	 * Finds {@link FeedCategoryMetaEnum} by feed category.
	 * @param feedCategory a non <code>null</code> non empty feed category
	 * @return {@link FeedCategoryMetaEnum} if found otherwise <code>null</code>
	 */
	public static final FeedCategoryMetaEnum find(final String feedCategory) {
		for(final FeedCategoryMetaEnum feedCategoryMetaEnum : values()) {
			if(feedCategoryMetaEnum.name().equals(feedCategory)) {
				return feedCategoryMetaEnum;
			}
		}
		return null;
	}
}
