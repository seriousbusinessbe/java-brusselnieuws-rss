package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.math.BigInteger;
import java.net.URL;

import org.dozer.Mapper;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;

public class CategoryImpl extends AbstractIdImpl<BigInteger> implements Category {
	private String name;
	private URL link;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private CategoryImpl(){}
	
	private CategoryImpl(final Builder builder) throws IllegalArgumentException{
		setId(builder.id);
		setLink(builder.link);
		setName(builder.name);
	}
	
	public static final class Builder{
		private BigInteger id;
		private URL link;
		private String name;
		
		public CategoryImpl build() throws IllegalArgumentException{
			return new CategoryImpl(this);
		}
		
		public Builder id(final BigInteger id){
			this.id=id;
			return this;
		}
		
		public Builder name(final String name){
			this.name=name;
			return this;
		}
		
		public Builder link(final URL link){
			this.link=link;
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
	public URL getLink() {
		return link;
	}

	@Override
	public void setLink(URL link) throws IllegalArgumentException {
		if(link==null){
			throw new IllegalArgumentException("The link is null");
		}
		this.link=link;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof CategoryImpl && 
				ObjectUtil.isNullOrEqual(name,((CategoryImpl)obj).name) &&
				ObjectUtil.isNullOrEqual(link,((CategoryImpl)obj).link);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(name) * ObjectUtil.hashCode(link);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		return new Builder().id(id).name(name).link(link).build();
	}

}
