package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoMedium;

public class MongoMediumFactory {
	
	/**
	 * Create a {@link MongoMedium} with id and data set.
	 * @return
	 */
	public static final MongoMedium createMongoMediumJPGImage() {
		final MongoMedium medium=new MongoMedium();
		medium.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/thumbnails/jellab_zoubida.jpg?itok=KY3z2BZc");
		medium.setSize(20166l);
		medium.setMediumTypeDTO(MongoMediumTypeFactory.createMongoMediumTypeJPG());
		return medium;
	}
	
	/**
	 * Create a {@link MongoMedium} with id and data set.
	 * @return
	 */
	public static final MongoMedium createMongoMediumPNGImage() {
		final MongoMedium medium=new MongoMedium();
		medium.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/dapp.png?itok=OyzHfATx");
		medium.setSize(3462896211l);
		medium.setMediumTypeDTO(MongoMediumTypeFactory.createMongoMediumTypePNG());
		return medium;
	}

}
