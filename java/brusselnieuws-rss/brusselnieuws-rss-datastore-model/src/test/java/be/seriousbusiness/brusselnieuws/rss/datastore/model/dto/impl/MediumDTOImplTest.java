package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumDTOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.stub.MediumTypeDTOStub;

public class MediumDTOImplTest extends AbstractMediumDTOTest<MediumDTOImpl> {

	public MediumDTOImplTest() {
		super("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/image/kermis02.jpg?itok=8fRRYMA1",new MediumTypeDTOStub(),31478l);
	}

	@Override
	public MediumDTOImpl create() {
		return new MediumDTOImpl();
	}

}
