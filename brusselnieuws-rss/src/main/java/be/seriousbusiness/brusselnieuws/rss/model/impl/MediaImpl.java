package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Media;
import be.seriousbusiness.brusselnieuws.rss.model.MediaType;

public class MediaImpl implements Media {
	private long size;
	private URL link;
	private MediaType mediaType;
	
	public MediaImpl(final URL link,final MediaType mediaType) throws IllegalArgumentException{
		size=0;
		setLink(link);
		setType(mediaType);
	}
	
	/**
	 * Set a size
	 * @param size
	 * @throws IllegalArgumentException when negative
	 */
	protected void setSize(final long size) throws IllegalArgumentException{
		if(size<0){
			throw new IllegalArgumentException("The size is negative");
		}
		this.size=size;
	}

	@Override
	public long getSize() {
		return size;
	}
	
	/**
	 * Set a link
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	protected void setLink(final URL link) throws IllegalArgumentException{
		if(link==null){
			throw new IllegalArgumentException("The link cannot be null");
		}
		this.link=link;
	}

	@Override
	public URL getLink() {
		return link;
	}
	
	protected void setType(final MediaType mediaType) throws IllegalArgumentException{
		if(mediaType==null){
			throw new IllegalArgumentException("The media type is null");
		}
		this.mediaType=mediaType;
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
