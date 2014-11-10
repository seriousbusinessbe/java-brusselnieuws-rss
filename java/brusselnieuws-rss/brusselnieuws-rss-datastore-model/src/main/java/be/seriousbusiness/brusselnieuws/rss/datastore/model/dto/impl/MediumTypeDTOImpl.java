package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.DTOUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.util.ObjectUtil;

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
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("type",type);
		return DTOUtil.stringBuilder("mediumTypeDTOImpl", fields);
	}

}
