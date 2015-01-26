package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;

/**
 * {@link MediumDTOImpl} factory.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumDTOImplFactory {
	
	public static final MediumDTOImpl createNewPNGImage() {
		final MediumDTOImpl mediumDTOImpl=new MediumDTOImpl();
		mediumDTOImpl.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/nmbs_1.jpg?itok=0prpIVwm");
		mediumDTOImpl.setMediumTypeDTO(MediumTypeDTOImplFactory.createNewPNG());
		mediumDTOImpl.setSize(34190l);
		return mediumDTOImpl;
	}
	
	public static final MediumDTOImpl createPNGImage() {
		final MediumDTOImpl mediumDTOImpl=new MediumDTOImpl();
		mediumDTOImpl.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/nmbs_1.jpg?itok=0prpIVwm");
		mediumDTOImpl.setMediumTypeDTO(MediumTypeDTOImplFactory.createPNG());
		mediumDTOImpl.setSize(34190l);
		return mediumDTOImpl;
	}
	
	public static final MediumDTOImpl createJPEGImage() {
		final MediumDTOImpl mediumDTOImpl=new MediumDTOImpl();
		mediumDTOImpl.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/michel_borcy_plat.jpg?itok=MAKUDTl1");
		mediumDTOImpl.setMediumTypeDTO(MediumTypeDTOImplFactory.createJPEG());
		mediumDTOImpl.setSize(22934l);
		return mediumDTOImpl;
	}
	
	public static final MediumDTOImpl createNewJPEGImage() {
		final MediumDTOImpl mediumDTOImpl=new MediumDTOImpl();
		mediumDTOImpl.setLink("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/michel_borcy_plat.jpg?itok=MAKUDTl1");
		mediumDTOImpl.setMediumTypeDTO(MediumTypeDTOImplFactory.createNewJPEG());
		mediumDTOImpl.setSize(22934l);
		return mediumDTOImpl;
	}

}
