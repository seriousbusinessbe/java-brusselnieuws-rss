package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;

/**
 * {@link MediumTypeDTOImpl} factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeDTOImplFactory {
	
	public static final MediumTypeDTOImpl createPNG() {
		return new MediumTypeDTOImpl.Builder().id(BigInteger.valueOf(51942l)).type("image/png").build();
	}
	
	/**
	 * Create a new {@link MediumTypeDTOImpl} which has never been saved before.
	 * @return a new {@link MediumTypeDTOImpl}
	 */
	public static final MediumTypeDTOImpl createNewPNG() {
		return new MediumTypeDTOImpl.Builder().type("image/png").build();
	}
	
	public static final MediumTypeDTOImpl createJPEG() {
		return new MediumTypeDTOImpl.Builder().id(BigInteger.valueOf(45236772244l)).type("image/jpeg").build();
	}
	
	public static final MediumTypeDTOImpl createNewJPEG() {
		return new MediumTypeDTOImpl.Builder().type("image/jpeg").build();
	}

}
