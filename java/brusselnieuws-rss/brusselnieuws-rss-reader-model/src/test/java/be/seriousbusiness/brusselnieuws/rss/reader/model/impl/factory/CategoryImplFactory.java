package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;

public class CategoryImplFactory {
	
	public static final CategoryImpl createStad() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				id(BigInteger.valueOf(12345678l)).
				name("Stad").
				link(new URL("http://www.brusselnieuws.be/nl/bn-section/stad")).build();
	}
	
	public static final CategoryImpl createNewStad() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				name("Stad").
				link(new URL("http://www.brusselnieuws.be/nl/bn-section/stad")).build();
	}
	
	public static final CategoryImpl createSamenleving() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				id(BigInteger.valueOf(32324235l)).
				name("Samenleving").
				link(new URL("http://www.brusselnieuws.be/nl/bn-section/samenleving")).build();
	}
	
	public static final CategoryImpl createNewSamenleving() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				name("Samenleving").
				link(new URL("http://www.brusselnieuws.be/nl/bn-section/samenleving")).build();
	}
	
	public static final CategoryImpl createArtikel() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				id(BigInteger.valueOf(88966505l)).
				name("artikel").
				link(new URL("http://www.brusselnieuws.be/nl/media-type/artikel")).build();
	}
	
	public static final CategoryImpl createNewArtikel() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				name("artikel").
				link(new URL("http://www.brusselnieuws.be/nl/media-type/artikel")).build();
	}

}
