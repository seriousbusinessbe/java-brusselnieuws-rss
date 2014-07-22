package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AbstractAdaptableArticleTest;

public class AdaptableArticleImplTest extends AbstractAdaptableArticleTest<AdaptableArticleImpl> {

	@Override
	public void before() {
		adaptable=new AdaptableArticleImpl.Builder().title("Test title").build();
	}

}
