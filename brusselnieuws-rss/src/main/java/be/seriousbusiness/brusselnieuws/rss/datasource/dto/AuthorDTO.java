package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public interface AuthorDTO extends DTO<Long> {
	
	String getName();
	void setName(final String name);
	
}
