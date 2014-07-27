package be.seriousbusiness.brusselnieuws.rss.datasource.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datasource.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datasource.dto.MediumTypeDTO;

public class MediumDTOImpl implements MediumDTO {
	private String link;
	private MediumTypeDTO mediumTypeDTO;
	private long size;
	
	@Override
	public String getLink() {
		return link;
	}
	
	@Override
	public void setLink(final String link) {
		this.link = link;
	}
	
	@Override
	public MediumTypeDTO getMediumTypeDTO() {
		return mediumTypeDTO;
	}
	
	@Override
	public void setMediumTypeDTO(final MediumTypeDTO mediumTypeDTO) {
		this.mediumTypeDTO = mediumTypeDTO;
	}
	
	@Override
	public long getSize() {
		return size;
	}
	
	@Override
	public void setSize(final long size) {
		this.size = size;
	}

}
