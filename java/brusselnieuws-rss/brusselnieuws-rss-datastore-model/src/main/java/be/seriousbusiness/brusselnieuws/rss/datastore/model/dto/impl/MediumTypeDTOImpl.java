package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

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
		final MediumTypeDTOImpl mediumTypeDTOImpl=new MediumTypeDTOImpl();
		mediumTypeDTOImpl.setId(id);
		mediumTypeDTOImpl.setType(type);
		return mediumTypeDTOImpl;
	}

}
