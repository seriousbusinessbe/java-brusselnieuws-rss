package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Content;

public abstract class AbstractContent implements Content {
	private String title,description;
	private URL link;
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public URL getLink() {
		return link;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean hasDescription() {
		return description!=null;
	}

}
