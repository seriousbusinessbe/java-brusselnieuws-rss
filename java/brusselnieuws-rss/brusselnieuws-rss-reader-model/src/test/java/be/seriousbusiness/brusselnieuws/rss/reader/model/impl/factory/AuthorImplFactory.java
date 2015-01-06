package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;

public class AuthorImplFactory {
	
	public static final AuthorImpl createFMBrussel(){
		return new AuthorImpl.Builder().
				id(BigInteger.valueOf(98472733l)).
				name("© FM Brussel").build();
	}

}
