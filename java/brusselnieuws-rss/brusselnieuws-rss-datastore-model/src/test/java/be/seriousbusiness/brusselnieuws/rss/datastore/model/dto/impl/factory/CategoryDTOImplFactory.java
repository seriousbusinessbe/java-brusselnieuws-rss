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
		final CategoryDTOImpl categoryDTOImpl=createNewPolitiek();
		categoryDTOImpl.setId(BigInteger.valueOf(468238l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewPolitiek(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/bn-section/politiek");
		categoryDTOImpl.setName("Politiek");
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createSamenleving(){
		final CategoryDTOImpl categoryDTOImpl=createNewSamenleving();
		categoryDTOImpl.setId(BigInteger.valueOf(532178900l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createFilm(){
		final CategoryDTOImpl categoryDTOImpl=createNewFilm();
		categoryDTOImpl.setId(BigInteger.valueOf(58939213l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createArtikel(){
		final CategoryDTOImpl categoryDTOImpl=createNewArtikel();
		categoryDTOImpl.setId(BigInteger.valueOf(6983942l));
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewSamenleving(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/bn-section/samenleving");
		categoryDTOImpl.setName("Samenleving");
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewFilm(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/bn-section/film");
		categoryDTOImpl.setName("Film");
		return categoryDTOImpl;
	}
	
	public static final CategoryDTOImpl createNewArtikel(){
		final CategoryDTOImpl categoryDTOImpl=new CategoryDTOImpl();
		categoryDTOImpl.setLink("http://www.brusselnieuws.be/nl/media-type/artikel");
		categoryDTOImpl.setName("artikel");
		return categoryDTOImpl;
	}

}
