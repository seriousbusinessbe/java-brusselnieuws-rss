package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.stub;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumDTOStub implements MediumDTO {
	private MediumTypeDTO mediumTypeDTO=new MediumTypeDTOStub();

	@Override
	public String getLink() {
		return "http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/image/potlood3.png?itok=8pJznK26";
	}

	@Override
	public void setLink(final String link) {}

	@Override
	public MediumTypeDTO getMediumTypeDTO() {
		return mediumTypeDTO;
	}

	@Override
	public void setMediumTypeDTO(final MediumTypeDTO mediumTypeDTO) {}

	@Override
	public Long getSize() {
		return 76612l;
	}

	@Override
	public void setSize(final Long size) {}

}
