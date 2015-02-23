package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;

public class CreatorDTOImplFactory {
	
	public static final CreatorDTOImpl createBrusselNieuwsBe() {
		return new CreatorDTOImpl.Builder().id(BigInteger.valueOf(5243524352345l)).name("© brusselnieuws.be").build();
	}
	
	public static final CreatorDTOImpl createFMBrussel() {
		return new CreatorDTOImpl.Builder().id(BigInteger.valueOf(94842824l)).name("© FM Brussel").build();
	}
	
	public static final CreatorDTOImpl createTVBrussel() {
		return new CreatorDTOImpl.Builder().id(BigInteger.valueOf(435433424l)).name("© tvbrussel").build();
	}
	
	public static final CreatorDTOImpl createNewFMBrussel() {
		return new CreatorDTOImpl.Builder().name("© FM Brussel").build();
	}
	
	public static final CreatorDTOImpl createNewTVBrussel() {
		return new CreatorDTOImpl.Builder().name("© tvbrussel").build();
	}
	
}
