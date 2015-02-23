package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * {@link MediumTypeDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeDTOImpl extends AbstractIdDTOImpl<BigInteger> implements MediumTypeDTO {
	private String type;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MediumTypeDTOImpl(){}
	
	private MediumTypeDTOImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setType(builder.type);
	}
	
	public static class Builder{
		private BigInteger id;
		private String type;
		
		public MediumTypeDTOImpl build() throws IllegalArgumentException{
			return new MediumTypeDTOImpl(this);
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
	public void setType(final String type) {
		this.type=type;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MediumTypeDTOImpl && super.equals(obj) && 
				ObjectUtil.isNullOrEqual(type,((MediumTypeDTOImpl)obj).type);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * ObjectUtil.hashCode(type);
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
