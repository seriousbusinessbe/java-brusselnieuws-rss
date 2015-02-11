package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;

public class AuthorImplFactory {
	
	public static final AuthorImpl createFMBrussel(){
		return new AuthorImpl.Builder().
				id(BigInteger.valueOf(98472733l)).
				name("© FM Brussel").build();
	}
	
	public static final AuthorImpl createNewFMBrussel(){
		return new AuthorImpl.Builder().name("© FM Brussel").build();
	}
	
	public static final AuthorImpl createBrusselNieuws(){
		return new AuthorImpl.Builder().
				id(BigInteger.valueOf(44231313l)).
				name("© brusselnieuws.be").build();
	}
	
	public static final AuthorImpl createNewBrusselNieuws(){
		return new AuthorImpl.Builder().name("© brusselnieuws.be").build();
	}

}
