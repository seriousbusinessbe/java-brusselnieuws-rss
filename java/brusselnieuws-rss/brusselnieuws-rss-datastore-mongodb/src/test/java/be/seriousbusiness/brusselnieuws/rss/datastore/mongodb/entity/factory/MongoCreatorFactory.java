package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.entity.MongoCreator;

public class MongoCreatorFactory {
	
	public static final MongoCreator createBrusselNieuwsBe() {
		return new MongoCreator.Builder().id(BigInteger.valueOf(352346432246l)).name("© brusselnieuws.be").build();
	}
	
	public static final MongoCreator createFMBrussel() {
		return new MongoCreator.Builder().id(BigInteger.valueOf(654354754l)).name("© FM Brussel").build();
	}
	
	public static final MongoCreator createTVBrussel() {
		return new MongoCreator.Builder().id(BigInteger.valueOf(24324534l)).name("© tvbrussel").build();
	}

}
