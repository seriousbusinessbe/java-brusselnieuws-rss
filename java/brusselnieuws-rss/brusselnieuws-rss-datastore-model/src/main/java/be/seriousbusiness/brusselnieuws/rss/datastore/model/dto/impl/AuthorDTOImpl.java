package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * {@link AuthorDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorDTOImpl extends AbstractIdDTOImpl<BigInteger> implements AuthorDTO  {
	private String name;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private AuthorDTOImpl(){}
	
	private AuthorDTOImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name;
		
		public AuthorDTOImpl build() throws IllegalArgumentException{
			return new AuthorDTOImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder name(final String name){
			this.name=name;
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof AuthorDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(name,((AuthorDTOImpl)obj).name);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * ObjectUtil.hashCode(name);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).name(name).build();
	}

}
