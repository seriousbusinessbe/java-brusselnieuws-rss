package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Category;

public class CategoryImpl implements Category {
	private String name;
	private URL link;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public URL getLink() {
		return link;
	}

}
