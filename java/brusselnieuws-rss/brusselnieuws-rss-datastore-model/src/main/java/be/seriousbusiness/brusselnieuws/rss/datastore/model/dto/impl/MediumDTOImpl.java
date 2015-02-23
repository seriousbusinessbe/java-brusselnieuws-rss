package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

/**
 * {@link MediumDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumDTOImpl implements MediumDTO<MediumTypeDTOImpl>  {
	private String link;
	private MediumTypeDTOImpl mediumTypeDTOImpl;
	private Long size;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MediumDTOImpl(){}
	
	private MediumDTOImpl(final Builder builder) throws IllegalArgumentException{
		setLink(builder.link);
		setSize(builder.size);
		setMediumTypeDTO(builder.mediumTypeDTOImpl);
	}
	
	public static class Builder{
		private String link;
		private MediumTypeDTOImpl mediumTypeDTOImpl;
		private Long size;
		
		public MediumDTOImpl build() throws IllegalArgumentException{
			return new MediumDTOImpl(this);
		}
		
		public Builder size(final Long size) {
			this.size=size;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
			return this;
		}
		
		public Builder mediumTypeDTO(final MediumTypeDTOImpl mediumTypeDTOImpl) {
			this.mediumTypeDTOImpl=mediumTypeDTOImpl;
			return this;
		}
		
	}

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
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		return new Builder().link(link).mediumTypeDTO(mediumTypeDTOImpl).size(size).build();
	}

}
