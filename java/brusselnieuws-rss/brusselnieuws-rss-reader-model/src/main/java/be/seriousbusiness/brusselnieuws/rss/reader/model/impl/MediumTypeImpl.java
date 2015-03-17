package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

public class MediumTypeImpl extends AbstractIdImpl<BigInteger> implements MediumType  {
	private String type;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MediumTypeImpl(){}
	
	private MediumTypeImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setType(builder.type);
	}
	
	public static class Builder{
		private BigInteger id;
		private String type;
		
		public MediumTypeImpl build() throws IllegalArgumentException{
			return new MediumTypeImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder type(final String type){
			this.type=type;
			return this;
		}
		
	}

	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public void setType(final String type) throws IllegalArgumentException {
		if(type==null || type.isEmpty()){
			throw new IllegalArgumentException("The type is null or empty");
		}
		this.type=type.trim().toLowerCase();
	}
	
	@Override
	public int compareTo(final MediumType mediumType) {
		return this.type.compareTo(mediumType.getType());
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		return new EqualsBuilder().append(type,((MediumTypeImpl) obj).getType()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(85,69).append(type).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append("type",type).toString();
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).type(type).build();
	}

}
