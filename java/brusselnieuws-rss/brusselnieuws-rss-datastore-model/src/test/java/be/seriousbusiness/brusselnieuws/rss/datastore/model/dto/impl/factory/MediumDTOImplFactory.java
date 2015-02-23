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
		return new MediumDTOImpl.Builder()
		.link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/nmbs_1.jpg?itok=0prpIVwm")
		.mediumTypeDTO(MediumTypeDTOImplFactory.createNewPNG())
		.size(351690l).build();
	}
	
	public static final MediumDTOImpl createPNGImage() {
		return new MediumDTOImpl.Builder()
				.link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/nmbs_1.jpg?itok=0prpIVwm")
				.mediumTypeDTO(MediumTypeDTOImplFactory.createPNG())
				.size(34190l).build();
	}
	
	public static final MediumDTOImpl createJPEGImage() {
		return new MediumDTOImpl.Builder()
			.link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/michel_borcy_plat.jpg?itok=MAKUDTl1")
			.mediumTypeDTO(MediumTypeDTOImplFactory.createJPEG())
			.size(22934l).build();
	}
	
	public static final MediumDTOImpl createNewJPEGImage() {
		return new MediumDTOImpl.Builder()
			.link("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/michel_borcy_plat.jpg?itok=MAKUDTl1")
			.mediumTypeDTO(MediumTypeDTOImplFactory.createNewJPEG())
			.size(22432934l).build();
	}

}
