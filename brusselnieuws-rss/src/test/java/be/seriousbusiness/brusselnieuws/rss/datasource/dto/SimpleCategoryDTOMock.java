package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleCategoryDTOMock implements CategoryDTO {

	@Override
	public Long getId() {
		return 1234l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getName() {
		return "simple category dto mock";
	}

	@Override
	public void setName(String name) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/bn-section/samenleving";
	}

	@Override
	public void setLink(String link) {}

}
