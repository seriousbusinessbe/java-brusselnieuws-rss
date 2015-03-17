package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;

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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(type,((MediumTypeDTOImpl) obj).getType()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(25,89).appendSuper(super.hashCode()).append(type).toHashCode();
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).type(type).build();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("type",type).toString();
	}

}
