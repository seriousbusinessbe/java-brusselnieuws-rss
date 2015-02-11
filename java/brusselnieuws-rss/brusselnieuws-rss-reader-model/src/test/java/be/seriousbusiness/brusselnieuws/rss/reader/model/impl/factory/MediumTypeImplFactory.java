package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;

public class MediumTypeImplFactory {
	
	public static final MediumTypeImpl createJPEG(){
		return new MediumTypeImpl.Builder().
				id(BigInteger.valueOf(34217435741l)).
				type("image/jpeg").build();
	}
	
	public static final MediumTypeImpl createNewJPEG(){
		return new MediumTypeImpl.Builder().
				type("image/jpeg").build();
	}
	
	public static final MediumTypeImpl createPNG(){
		return new MediumTypeImpl.Builder().
				id(BigInteger.valueOf(3251325l)).
				type("image/png").build();
	}
	
	public static final MediumTypeImpl createNewPNG(){
		return new MediumTypeImpl.Builder().
				type("image/png").build();
	}

}
