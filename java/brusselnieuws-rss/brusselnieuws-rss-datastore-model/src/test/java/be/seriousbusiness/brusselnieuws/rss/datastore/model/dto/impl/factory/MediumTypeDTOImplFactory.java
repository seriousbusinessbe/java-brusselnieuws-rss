package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;

public class MediumTypeDTOImplFactory {
	
	public static final MediumTypeDTOImpl createPNG() {
		final MediumTypeDTOImpl mediumTypeDTOImpl=createNewPNG();
		mediumTypeDTOImpl.setId(BigInteger.valueOf(51942l));
		return mediumTypeDTOImpl;
	}
	
	/**
	 * Create a new {@link MediumTypeDTOImpl} which has never been saved before.
	 * @return a new {@link MediumTypeDTOImpl}
	 */
	public static final MediumTypeDTOImpl createNewPNG() {
		final MediumTypeDTOImpl mediumTypeDTOImpl=new MediumTypeDTOImpl();
		mediumTypeDTOImpl.setType("image/png");
		return mediumTypeDTOImpl;
	}
	
	public static final MediumTypeDTOImpl createJPEG() {
		final MediumTypeDTOImpl mediumTypeDTOImpl=createNewJPEG();
		mediumTypeDTOImpl.setId(BigInteger.valueOf(45236772244l));
		return mediumTypeDTOImpl;
	}
	
	public static final MediumTypeDTOImpl createNewJPEG() {
		final MediumTypeDTOImpl mediumTypeDTOImpl=new MediumTypeDTOImpl();
		mediumTypeDTOImpl.setType("image/jpeg");
		return mediumTypeDTOImpl;
	}

}
