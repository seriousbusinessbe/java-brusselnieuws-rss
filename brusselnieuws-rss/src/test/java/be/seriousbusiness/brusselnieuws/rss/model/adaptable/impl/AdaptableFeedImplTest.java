package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AbstractAdaptableFeedTest;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableFeedImpl;

public class AdaptableFeedImplTest extends AbstractAdaptableFeedTest<AdaptableFeedImpl> {

	@Override
	public void before() {
		adaptable=new AdaptableFeedImpl.Builder().title("Test title").build();
	}

}
