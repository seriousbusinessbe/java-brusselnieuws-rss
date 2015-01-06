package be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;

public class MediumImplFactory {
	private static final Logger LOGGER=LoggerFactory.getLogger(MediumImplFactory.class);
	
	public static final MediumImpl createJPEG(){
		try {
			return new MediumImpl.Builder().link(new URL("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/Illustratie_wolf_roodkapje_cmyk.jpg?itok=_JupP2Hy")).
					size(45623l).
					type(MediumTypeImplFactory.createJPEG()).build();
		} catch (final IllegalArgumentException e) {
			LOGGER.error("A MediumImpl could not be created.",e);
		} catch (final MalformedURLException e) {
			LOGGER.error("The MediumImpl URL is incorrect",e);
		}
		return null;
	}

}
