package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * {@link CategoryDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImpl extends AbstractIdDTOImpl<BigInteger> implements CategoryDTO {
	private String name,link;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private CategoryDTOImpl(){}
	
	private CategoryDTOImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
		setLink(builder.link);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name,link;
		
		public CategoryDTOImpl build() throws IllegalArgumentException{
			return new CategoryDTOImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder name(final String name){
			this.name=name;
			return this;
		}
		
		public Builder link(final String link) {
			this.link=link;
			return this;
		}
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name=name;
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
	public Object clone() {
		return new Builder().id(id).link(link).name(name).build();
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		final CategoryDTOImpl accountDTOImpl = (CategoryDTOImpl) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(name,accountDTOImpl.getName()).append(link,accountDTOImpl.getLink()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(51,85).appendSuper(super.hashCode()).append(name).append(link).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("name",name).append("link",link).toString();
	}

}
