package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.dozer.Mapper;

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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		return new EqualsBuilder().append(name,((AuthorImpl) obj).getName()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(37,91).append(name).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append("name",name).toString();
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).name(name).build();
	}

}
