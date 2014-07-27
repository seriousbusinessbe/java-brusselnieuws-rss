package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public class SimpleAuthorDTOMock implements AuthorDTO {

	@Override
	public Long getId() {
		return 5678l;
	}

	@Override
	public void setId(Long id) {}

	@Override
	public String getName() {
		return "simple author dto mock";
	}

	@Override
	public void setName(String name) {}

}
