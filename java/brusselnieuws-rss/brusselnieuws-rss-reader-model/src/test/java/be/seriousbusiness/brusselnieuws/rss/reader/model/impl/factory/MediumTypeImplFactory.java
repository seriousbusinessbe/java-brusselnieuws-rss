package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;

public class MediumTypeImplFactory {
	
	public static final MediumTypeImpl createJPEG(){
		return new MediumTypeImpl.Builder().
				id(BigInteger.valueOf(34217435741l)).
				type("image/jpeg").build();
	}

}
