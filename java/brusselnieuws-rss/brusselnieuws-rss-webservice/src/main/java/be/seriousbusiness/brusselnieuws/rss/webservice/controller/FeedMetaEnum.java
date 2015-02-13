package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import static be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedCategoryMetaEnum.CULTURE;
import static be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedCategoryMetaEnum.FOOD_AND_DRINKS;
import static be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedCategoryMetaEnum.MUNICIPALITY;
import static be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedCategoryMetaEnum.NEWS;
import static be.seriousbusiness.brusselnieuws.rss.webservice.controller.FeedCategoryMetaEnum.OPINION;

/**
 * Lists all feed meta data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public enum FeedMetaEnum {
	NEWS_HEADLINES("Hoofdpunten",1,NEWS),
	NEWS_SURVEY("Overzicht",2,NEWS),
	CITY_NEWS("Stad",3,NEWS),
	SOCIETY_NEWS("Samenleving",4,NEWS),
	POLITICAL_NEWS("Politiek",5,NEWS),
	PEOPLE_NEWS("Mensen",6,NEWS),
	ECONOMICAL_NEWS("Economie",7,NEWS),
	SPORTS_NEWS("Sport",8,NEWS),
	AWEL_MERCI_NEWS("Awel merci",9,NEWS),
	CHILDREN_NEWS("Kinderen",10,NEWS),
	CULTURE_SURVEY("Overzicht",11,CULTURE),
	GENERAL_CULTURE_NEWS("Algemeen",12,CULTURE),
	EXPO_NEWS("Expo",13,CULTURE),
	MUSICAL_NEWS("Muziek",14,CULTURE),
	FILM_NEWS("Film",15,CULTURE),
	STAGE_NEWS("Podium",16,CULTURE),
	EVENT_NEWS("Evenementen",17,CULTURE),
	SHOPPING_NEWS("Shopping",18,CULTURE),
	FOOD_AND_DRINKS_SURVEY("Overzicht",19,FOOD_AND_DRINKS),
	GENERAL_FOOD_AND_DRINKS("Algemeen",20,FOOD_AND_DRINKS),
	CULINARY_NEWS("Culinair ontdekt",21,FOOD_AND_DRINKS),
	BAR_NEWS("Cafés",22,FOOD_AND_DRINKS),
	RESTAURANT_NEWS("Restaurants",23,FOOD_AND_DRINKS),
	OPINION_SURVEY("Overzicht",24,OPINION),
	ANDERLECHT_NEWS("Anderlecht",25,MUNICIPALITY),
	BRUSSEL_NEWS("Brussel",26,MUNICIPALITY),
	ELSENE_NEWS("Elsene",27,MUNICIPALITY),
	ETTERBEEK_NEWS("Etterbeek",28,MUNICIPALITY),
	EVERE_NEWS("Evere",29,MUNICIPALITY),
	GANSHOREN_NEWS("Ganshoren",30,MUNICIPALITY),
	HAREN_NEWS("Haren",31,MUNICIPALITY),
	JETTE_NEWS("Jette",32,MUNICIPALITY),
	KOEKELBERG_NEWS("Koekelberg",33,MUNICIPALITY),
	LAKEN_NEWS("Laken",34,MUNICIPALITY),
	NEDER_OVER_HEEMBEEK_NEWS("Neder-over-heembeek",35,MUNICIPALITY),
	OUDERGEM_NEWS("Oudergem",36,MUNICIPALITY),
	SCHAARBEEK_NEWS("Schaarbeek",37,MUNICIPALITY),
	SINT_AGATHA_BERCHEM_NEWS("Sint-Agatha-Berchem",38,MUNICIPALITY),
	SINT_GILLIS_NEWS("Sint-Gillis",39,MUNICIPALITY),
	SINT_JANS_MOLENBEEK_NEWS("Sint-Jans-Molenbeek",40,MUNICIPALITY),
	SINT_JOOST_TEN_NODE_NEWS("Sint-Joost-ten-Node",41,MUNICIPALITY),
	SINT_LAMBRECHTS_WOLUWE_NEWS("Sint-Lambrechts-Woluwe",42,MUNICIPALITY),
	SINT_PIETERS_WOLUWE_NEWS("Sint-Pieters-Woluwe",43,MUNICIPALITY),
	UKKEL_NEWS("Ukkel",44,MUNICIPALITY),
	VORST_NEWS("Vorst",45,MUNICIPALITY),
	WATERMAAL_BOSVOORDE("Watermaal-Bosvoorde",46,MUNICIPALITY);
	
	private String dutchName;
	private int requestId;
	private FeedCategoryMetaEnum category;
	
	private FeedMetaEnum(final String dutchName,final int requestId,final FeedCategoryMetaEnum category) {
		this.dutchName=dutchName;
		this.requestId=requestId;
		this.category=category;
	}
	
	/**
	 * Returns this feed's Dutch name.
	 * @return Dutch feed name
	 */
	public String getDutchName() {
		return dutchName;
	}
	
	/**
	 * Returns this feed's unique request identifier.
	 * @return unique identifier
	 */
	public int getRequestId() {
		return requestId;
	}
	
	/**
	 * Returns this feed's category.
	 * @return category
	 */
	public FeedCategoryMetaEnum getCategory() {
		return category;
	}
	
	/**
	 * Finds {@link FeedMetaEnum} with corresponding request id.
	 * @param requestId a non negative request id
	 * @return {@link FeedMetaEnum} if found otherwise <code>null</code>
	 */
	public static final FeedMetaEnum find(final int requestId) {
		for(final FeedMetaEnum feedMetaEnum : values()) {
			if(feedMetaEnum.getRequestId()==requestId) {
				return feedMetaEnum;
			}
		}
		return null;
	}

}
