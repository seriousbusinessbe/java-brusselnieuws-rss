package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleMediumDTOMock implements MediumDTO {

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/gazabetoging.jpg";
	}

	@Override
	public void setLink(String link) {}

	@Override
	public MediumTypeDTO getMediumTypeDTO() {
		return new SimpleMediumTypeDTOMock();
	}

	@Override
	public void setMediumTypeDTO(MediumTypeDTO mediumTypeDTO) {}

	@Override
	public long getSize() {
		return 4892l;
	}

	@Override
	public void setSize(long size) {}

}
