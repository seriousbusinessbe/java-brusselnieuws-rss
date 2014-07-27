package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.math.BigDecimal;
import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableMedium;

public class AdaptableMediumImpl extends AdaptableIdImpl<Long>  implements AdaptableMedium {
	private long size;
	private URL link;
	private MediumType mediumType;
	
	public static class Builder{
		private Long id;
		private Long size;
		private URL link;
		private MediumType mediumType;
		
		public AdaptableMediumImpl build(){
			return new AdaptableMediumImpl(this);
		}
		
		public Builder id(final long id){
			this.id=id;
			return this;
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
	
	private AdaptableMediumImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.link,builder.mediumType);
		if(builder.id!=null){
			setId(builder.id);
		}
		if(builder.size!=null){
			setSize(builder.size);
		}
	}
	
	protected AdaptableMediumImpl(final URL link,final MediumType mediumType) throws IllegalArgumentException{
		size=0;
		setLink(link);
		setType(mediumType);
	}
	
	public AdaptableMediumImpl(){
		
	}
	
	@Override
	public void setSize(final long size) throws IllegalArgumentException{
		if(size<0){
			throw new IllegalArgumentException("The size is negative");
		}
		this.size=size;
	}

	@Override
	public long getSize() {
		return size;
	}
	
	@Override
	public void setLink(final URL link) throws IllegalArgumentException{
		if(link==null){
			throw new IllegalArgumentException("The link cannot be null");
		}
		this.link=link;
	}

	@Override
	public URL getLink() {
		return link;
	}
	
	@Override
	public void setType(final MediumType mediumType) throws IllegalArgumentException{
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
			return super.equals(obj) && 
					link.equals(medium.getLink()) &&
					mediumType.equals(medium.getType()) &&
					size==medium.getSize();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return new BigDecimal(super.hashCode() * link.hashCode() * mediumType.hashCode() + size).intValueExact();
	}
	
	@Override
	public String toString(){
		return super.toString() + " " + link.toString();
	}

}
