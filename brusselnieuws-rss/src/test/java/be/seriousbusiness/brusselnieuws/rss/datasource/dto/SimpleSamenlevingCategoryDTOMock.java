package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleSamenlevingCategoryDTOMock implements CategoryDTO {

	@Override
	public Long getId() {
		return 1234l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getName() {
		return "simple samenleving category dto mock";
	}

	@Override
	public void setName(final String name) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/bn-section/samenleving";
	}

	@Override
	public void setLink(final String link) {}

}
