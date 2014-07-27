package be.seriousbusiness.brusselnieuws.rss.datasource.dto;


public interface MediumDTO {
	
	String getLink();
	void setLink(final String link);
	MediumTypeDTO getMediumTypeDTO();
	void setMediumTypeDTO(final MediumTypeDTO mediumTypeDTO);
	long getSize();
	void setSize(final long size);

}
