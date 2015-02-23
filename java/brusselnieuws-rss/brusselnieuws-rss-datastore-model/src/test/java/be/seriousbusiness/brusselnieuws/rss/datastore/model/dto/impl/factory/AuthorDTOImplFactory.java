package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;

/**
 * {@link AuthorDTOImpl} Factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorDTOImplFactory {
	
	public static final AuthorDTOImpl createErikaVlieghe(){
		return new AuthorDTOImpl.Builder().id(BigInteger.valueOf(3759158l)).name("Erika Vlieghe").build();
	}
	
	public static final AuthorDTOImpl createNewErikaVlieghe(){
		return new AuthorDTOImpl.Builder().name("Erika Vlieghe").build();
	}
	
	public static final AuthorDTOImpl createBrusselNieuws(){
		return new AuthorDTOImpl.Builder().id(BigInteger.valueOf(9934628843l)).name("brusselnieuws.be").build();
	}
	
	public static final AuthorDTOImpl createNewBrusselNieuws(){
		return new AuthorDTOImpl.Builder().name("brusselnieuws.be").build();
	}

}
