package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * {@link CategoryDTOImpl} factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImplFactory {
	
	public static final CategoryDTOImpl createPolitiek(){
		return new CategoryDTOImpl.Builder().link("http://www.brusselnieuws.be/nl/bn-section/politiek").id(BigInteger.valueOf(468238l)).name("Politiek").build();
	}
	
	public static final CategoryDTOImpl createNewPolitiek(){
		return new CategoryDTOImpl.Builder().link("http://www.brusselnieuws.be/nl/bn-section/politiek").name("Politiek").build();
	}
	
	public static final CategoryDTOImpl createSamenleving(){
		return new CategoryDTOImpl.Builder().id(BigInteger.valueOf(532178900l)).link("http://www.brusselnieuws.be/nl/bn-section/samenleving").name("Samenleving").build();
	}
	
	public static final CategoryDTOImpl createFilm(){
		return new CategoryDTOImpl.Builder().id(BigInteger.valueOf(58939213l)).link("http://www.brusselnieuws.be/nl/bn-section/film").name("Film").build();
	}
	
	public static final CategoryDTOImpl createArtikel(){
		return new CategoryDTOImpl.Builder().id(BigInteger.valueOf(6983942l)).link("http://www.brusselnieuws.be/nl/media-type/artikel").name("artikel").build();
	}
	
	public static final CategoryDTOImpl createNewSamenleving(){
		return new CategoryDTOImpl.Builder().link("http://www.brusselnieuws.be/nl/bn-section/samenleving").name("Samenleving").build();
	}
	
	public static final CategoryDTOImpl createNewFilm(){
		return new CategoryDTOImpl.Builder().link("http://www.brusselnieuws.be/nl/bn-section/film").name("Film").build();
	}
	
	public static final CategoryDTOImpl createNewArtikel(){
		return new CategoryDTOImpl.Builder().link("http://www.brusselnieuws.be/nl/media-type/artikel").name("artikel").build();
	}

}
