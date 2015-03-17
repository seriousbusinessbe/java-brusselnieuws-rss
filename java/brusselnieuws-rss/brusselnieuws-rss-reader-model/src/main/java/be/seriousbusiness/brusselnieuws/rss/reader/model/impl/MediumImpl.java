package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.net.URL;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;

public class MediumImpl implements Medium<MediumTypeImpl> {
	private long size;
	private URL link;
	private MediumTypeImpl mediumTypeImpl;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MediumImpl(){}
	
	private MediumImpl(final Builder builder) throws IllegalArgumentException{
		setSize(builder.size);
		setLink(builder.link);
		setType(builder.mediumTypeImpl);
	}
	
	public static class Builder{
		private long size;
		private URL link;
		private MediumTypeImpl mediumTypeImpl;
		
		public MediumImpl build() throws IllegalArgumentException{
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
		
		public Builder type(final MediumTypeImpl mediumTypeImpl){
			this.mediumTypeImpl=mediumTypeImpl;
			return this;
		}
		
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setSize(final long size) throws IllegalArgumentException {
		if(size<0){
			throw new IllegalArgumentException("The size is negative");
		}
		this.size=size;
	}

	@Override
	public URL getLink() {
		return link;
	}

	@Override
	public void setLink(final URL link) throws IllegalArgumentException {
		if(link==null){
			throw new IllegalArgumentException("The link is null");
		}
		this.link=link;
	}

	@Override
	public MediumTypeImpl getType() {
		return mediumTypeImpl;
	}

	@Override
	public void setType(final MediumTypeImpl mediumTypeImpl) throws IllegalArgumentException {
		if(mediumTypeImpl==null){
			throw new IllegalArgumentException("The medium type is null");
		}
		this.mediumTypeImpl=mediumTypeImpl;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MediumImpl mediumImpl = (MediumImpl) obj;
		return new EqualsBuilder()
				.append(link,mediumImpl.getLink())
				.append(size,mediumImpl.getSize())
				.append(mediumTypeImpl,mediumImpl.getType())
                .isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(13,23)
		       .append(link)
		       .append(size)
		       .append(mediumTypeImpl)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("link",link)
			    .append("size",size)
			    .append("mediumTypeImpl",mediumTypeImpl)
				.toString();
	}
	
	@Override
	public Object clone() {
		return new Builder().link(link).size(size).type((MediumTypeImpl)mediumTypeImpl.clone()).build();
	}

}
