package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleArtikelCategoryDTOMock implements CategoryDTO {

	@Override
	public Long getId() {
		return 25262728l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getName() {
		return "simple artikel category dto mock";
	}

	@Override
	public void setName(String name) {}

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/nl/media-type/artikel";
	}

	@Override
	public void setLink(String link) {}

}
