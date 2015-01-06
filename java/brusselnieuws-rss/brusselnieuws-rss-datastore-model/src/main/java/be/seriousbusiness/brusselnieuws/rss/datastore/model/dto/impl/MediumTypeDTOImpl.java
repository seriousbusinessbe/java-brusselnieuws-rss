package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

public class MediumTypeDTOImpl extends AbstractIdDTOImpl<BigInteger> implements MediumTypeDTO {
	private String type;

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

}
