package be.seriousbusiness.brusselnieuws.rss.datasource.dto;

public interface MediumTypeDTO extends DTO<Long> {
	
	String getType();
	void setType(final String type);

}
