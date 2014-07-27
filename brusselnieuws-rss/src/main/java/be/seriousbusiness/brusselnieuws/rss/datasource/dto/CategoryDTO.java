package be.seriousbusiness.brusselnieuws.rss.datasource.dto;


public interface CategoryDTO extends DTO<Long> {
	
	String getName();
	void setName(final String name);
	String getLink();
	void setLink(final String link);

}
