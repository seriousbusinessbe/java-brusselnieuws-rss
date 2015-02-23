package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;

public class CreatorImplFactory {
	
	public static final CreatorImpl createFMBrussel(){
		return new CreatorImpl.Builder().
				id(BigInteger.valueOf(98472733l)).
				name("© FM Brussel").build();
	}
	
	public static final CreatorImpl createNewFMBrussel(){
		return new CreatorImpl.Builder().name("© FM Brussel").build();
	}
	
	public static final CreatorImpl createBrusselNieuws(){
		return new CreatorImpl.Builder().
				id(BigInteger.valueOf(44231313l)).
				name("© brusselnieuws.be").build();
	}
	
	public static final CreatorImpl createNewBrusselNieuws(){
		return new CreatorImpl.Builder().name("© brusselnieuws.be").build();
	}

}
