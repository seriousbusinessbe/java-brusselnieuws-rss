package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;

public class AuthorDTOImplFactory {
	
	public static final AuthorDTOImpl createErikaVlieghe(){
		final AuthorDTOImpl authorDTOImpl=createNewErikaVlieghe();
		authorDTOImpl.setId(BigInteger.valueOf(3759158l));
		authorDTOImpl.setName("Erika Vlieghe");
		return authorDTOImpl;
	}
	
	public static final AuthorDTOImpl createNewErikaVlieghe(){
		final AuthorDTOImpl authorDTOImpl=new AuthorDTOImpl();
		authorDTOImpl.setName("Erika Vlieghe");
		return authorDTOImpl;
	}
	
	public static final AuthorDTOImpl createBrusselNieuws(){
		final AuthorDTOImpl authorDTOImpl=createNewBrusselNieuws();
		authorDTOImpl.setId(BigInteger.valueOf(9934628843l));
		return authorDTOImpl;
	}
	
	public static final AuthorDTOImpl createNewBrusselNieuws(){
		final AuthorDTOImpl authorDTOImpl=new AuthorDTOImpl();
		authorDTOImpl.setName("brusselnieuws.be");
		return authorDTOImpl;
	}

}
