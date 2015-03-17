package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;

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
	public Object clone() {
		return new Builder().link(link).mediumTypeDTO(mediumTypeDTOImpl).size(size).build();
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final MediumDTOImpl mediumDTOImpl = (MediumDTOImpl) obj;
		return new EqualsBuilder()
				.append(link,mediumDTOImpl.getLink())
				.append(size,mediumDTOImpl.getSize())
				.append(mediumTypeDTOImpl,mediumDTOImpl.getMediumTypeDTO())
                .isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(63,737)
		       .append(link)
		       .append(size)
		       .append(mediumTypeDTOImpl)
		       .toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("link",link)
			    .append("size",size)
			    .append("mediumTypeDTOImpl",mediumTypeDTOImpl)
				.toString();
	}

}
