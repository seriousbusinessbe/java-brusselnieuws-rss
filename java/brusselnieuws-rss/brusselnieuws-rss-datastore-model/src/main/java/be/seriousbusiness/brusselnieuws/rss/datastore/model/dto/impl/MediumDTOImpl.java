package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.util.HashMap;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.DTOUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.util.ObjectUtil;

public class MediumDTOImpl implements MediumDTO<MediumTypeDTOImpl>  {
	private String link;
	private MediumTypeDTOImpl mediumTypeDTOImpl;
	private Long size;

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}

	@Override
	public MediumTypeDTOImpl getMediumTypeDTO() {
		return mediumTypeDTOImpl;
	}

	@Override
	public void setMediumTypeDTO(final MediumTypeDTOImpl mediumTypeDTOImpl) {
		this.mediumTypeDTOImpl=mediumTypeDTOImpl;
	}

	@Override
	public Long getSize() {
		return size;
	}

	@Override
	public void setSize(final Long size) {
		this.size=size;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof MediumDTOImpl && 
				ObjectUtil.isNullOrEqual(link,((MediumDTOImpl)obj).link) &&
				ObjectUtil.isNullOrEqual(size,((MediumDTOImpl)obj).size) &&
				ObjectUtil.isNullOrEqual(mediumTypeDTOImpl,((MediumDTOImpl)obj).mediumTypeDTOImpl);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * 
				ObjectUtil.hashCode(link) *
				ObjectUtil.hashCode(size) *
				ObjectUtil.hashCode(mediumTypeDTOImpl);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("link",link);
		fields.put("mediumTypeDTOImpl",mediumTypeDTOImpl);
		fields.put("size",size);
		return DTOUtil.stringBuilder("mediumDTOImpl", fields);
	}

}
