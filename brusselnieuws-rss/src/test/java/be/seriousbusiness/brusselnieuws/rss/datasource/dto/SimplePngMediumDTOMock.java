package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimplePngMediumDTOMock implements MediumDTO {
	private final MediumTypeDTO mediumTypeDTO=new SimpleImagePngMediumTypeDTOMock();


	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/nationalebank.png";
	}

	@Override
	public void setLink(String link) {}

	@Override
	public MediumTypeDTO getMediumTypeDTO() {
		return mediumTypeDTO;
	}

	@Override
	public void setMediumTypeDTO(MediumTypeDTO mediumTypeDTO) {}

	@Override
	public long getSize() {
		return 89092;
	}

	@Override
	public void setSize(long size) {}

}
