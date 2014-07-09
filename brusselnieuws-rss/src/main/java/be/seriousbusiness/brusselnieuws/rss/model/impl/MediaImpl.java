package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Media;
import be.seriousbusiness.brusselnieuws.rss.model.MediaType;

public class MediaImpl implements Media {
	private long size;
	private URL link;
	private MediaType mediaType;
	
	public MediaImpl(){
		size=0;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public URL getLink() {
		return link;
	}

	@Override
	public MediaType getType() {
		return mediaType;
	}
	
	@Override
	public String toString(){
		return link.toString();
	}

}
