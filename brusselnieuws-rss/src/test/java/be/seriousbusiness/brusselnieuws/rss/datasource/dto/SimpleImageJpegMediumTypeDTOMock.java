package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleImageJpegMediumTypeDTOMock implements MediumTypeDTO{

	@Override
	public Long getId() {
		return 9101112l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getType() {
		return "image/jpeg";
	}

	@Override
	public void setType(String type) {}

}
