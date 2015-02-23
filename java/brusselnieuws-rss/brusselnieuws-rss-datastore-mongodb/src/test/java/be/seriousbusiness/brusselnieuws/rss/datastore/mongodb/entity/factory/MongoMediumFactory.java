package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;

public class MongoMediumFactory {
	
	/**
	 * Create a {@link MongoMedium} with id and data set.
	 * @return
	 */
	public static final MongoMedium createMongoMediumJPGImage() {
		return new MongoMedium.Builder().link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/thumbnails/jellab_zoubida.jpg?itok=KY3z2BZc")
				.size(20166l)
				.mediumTypeDTO(MongoMediumTypeFactory.createMongoMediumTypeJPG()).build();
	}
	
	/**
	 * Create a {@link MongoMedium} with id and data set.
	 * @return
	 */
	public static final MongoMedium createMongoMediumPNGImage() {
		return new MongoMedium.Builder().link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/dapp.png?itok=OyzHfATx")
				.size(3462896211l)
				.mediumTypeDTO(MongoMediumTypeFactory.createMongoMediumTypePNG()).build();
	}

}
