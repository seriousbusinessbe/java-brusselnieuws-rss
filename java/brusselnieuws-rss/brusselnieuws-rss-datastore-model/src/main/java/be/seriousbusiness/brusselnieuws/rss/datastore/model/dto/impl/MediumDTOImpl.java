package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumDTOImpl extends IdDTOImpl<Long> implements MediumDTO  {
	private String link;
	private MediumTypeDTO mediumTypeDTO;
	private Long size;

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}

	@Override
	public MediumTypeDTO getMediumTypeDTO() {
		return mediumTypeDTO;
	}

	@Override
	public void setMediumTypeDTO(final MediumTypeDTO mediumTypeDTO) {
		this.mediumTypeDTO=mediumTypeDTO;
	}

	@Override
	public Long getSize() {
		return size;
	}

	@Override
	public void setSize(final Long size) {
		this.size=size;
	}

}
