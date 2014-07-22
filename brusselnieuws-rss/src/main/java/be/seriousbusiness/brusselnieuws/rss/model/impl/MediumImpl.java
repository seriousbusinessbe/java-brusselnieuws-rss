package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;

public class MediumImpl implements Medium {
	private long size;
	private URL link;
	private MediumType mediumType;
	
	public static class Builder{
		private Long size;
		private URL link;
		private MediumType mediumType;
		
		public MediumImpl build(){
			return new MediumImpl(this);
		}
		
		public Builder size(final long size){
			this.size=size;
			return this;
		}
		
		public Builder link(final URL link){
			this.link=link;
			return this;
		}
		
		public Builder type(final MediumType mediumType){
			this.mediumType=mediumType;
			return this;
		}
		
	}
	
	private MediumImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.link,builder.mediumType);
		if(builder.size!=null){
			setSize(builder.size);
		}
	}
	
	protected MediumImpl(final URL link,final MediumType mediumType) throws IllegalArgumentException{
		size=0;
		setLink(link);
		setType(mediumType);
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
	
	protected void setType(final MediumType mediumType) throws IllegalArgumentException{
		if(mediumType==null){
			throw new IllegalArgumentException("The medium type is null");
		}
		this.mediumType=mediumType;
	}

	@Override
	public MediumType getType() {
		return mediumType;
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Medium){
			final Medium medium=(Medium)obj;
			return link.equals(medium.getLink()) &&
					mediumType.equals(medium.getType()) &&
					size==medium.getSize();
		}
		return false;
	}
	
	@Override
	public String toString(){
		return link.toString();
	}

}
