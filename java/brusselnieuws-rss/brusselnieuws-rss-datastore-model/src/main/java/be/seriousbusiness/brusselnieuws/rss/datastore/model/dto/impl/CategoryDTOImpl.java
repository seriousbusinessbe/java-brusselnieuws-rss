package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof CategoryDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(name,((CategoryDTOImpl)obj).name) &&
				ObjectUtil.isNullOrEqual(link,((CategoryDTOImpl)obj).link);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * ObjectUtil.hashCode(name) * ObjectUtil.hashCode(link);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).link(link).name(name).build();
	}

}
