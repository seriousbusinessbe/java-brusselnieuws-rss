package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;

public class AuthorImpl extends AbstractIdImpl<BigInteger> implements Author {
	private String name;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private AuthorImpl(){}
	
	private AuthorImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setName(builder.name);
	}
	
	public static class Builder{
		private BigInteger id;
		private String name;
		
		public AuthorImpl build() throws IllegalArgumentException{
			return new AuthorImpl(this);
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
	public void setName(final String name) throws IllegalArgumentException {
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The name is null or empty");
		}
		this.name=name.trim().toLowerCase();
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof AuthorImpl && 
				ObjectUtil.isNullOrEqual(name,((AuthorImpl)obj).name);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(name);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}

}
