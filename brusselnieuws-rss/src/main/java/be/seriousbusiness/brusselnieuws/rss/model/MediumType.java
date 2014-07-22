package be.seriousbusiness.brusselnieuws.rss.model;

/**
 * Represents the type of medium attached to an article.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public enum MediumType {
	IMAGE_PNG("image/png"),
	IMAGE_JPEG("image/jpeg"),
	UNKNOWN("/");
	
	private final String type;
	private MediumType(final String type){
		this.type=type;
	}
	
	public static MediumType find(final String type){
		for(final MediumType mediumType : values()){
			if(mediumType.type.equals(type)){
				return mediumType;
			}
		}
		return UNKNOWN;
	}
}
