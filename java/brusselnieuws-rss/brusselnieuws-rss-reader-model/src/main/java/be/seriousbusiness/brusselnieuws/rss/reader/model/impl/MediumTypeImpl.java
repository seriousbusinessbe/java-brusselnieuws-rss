package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MediumTypeImpl && 
				ObjectUtil.isNullOrEqual(type,((MediumTypeImpl)obj).type);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(type);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).type(type).build();
	}

}
