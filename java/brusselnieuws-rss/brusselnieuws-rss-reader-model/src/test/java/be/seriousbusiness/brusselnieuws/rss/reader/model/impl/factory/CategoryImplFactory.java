package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;

public class CategoryImplFactory {
	
	public static final CategoryImpl createStad() throws IllegalArgumentException, MalformedURLException{
		return new CategoryImpl.Builder().
				id(BigInteger.valueOf(12345678)).
				name("Stad").
				link(new URL("http://www.brusselnieuws.be/nl/bn-section/stad")).build();
	}

}
