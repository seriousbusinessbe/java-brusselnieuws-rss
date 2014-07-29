package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableCategory;

public class AdaptableCategoryImpl extends AdaptableIdImpl<Long> implements AdaptableCategory {
	private String name;
	private URL link;
	
	public static class Builder{
		private String name;
		private URL link;
		private Long id;
		
		public AdaptableCategoryImpl build(){
			return new AdaptableCategoryImpl(this);
		}
		
		public Builder id(final long id){
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
	
	private AdaptableCategoryImpl(final Builder builder) throws IllegalArgumentException{
		this(builder.name);
		if(builder.id!=null){
			setId(builder.id);
		}
		if(builder.link!=null){
			setLink(builder.link);
		}
	}
	
	/**
	 * Create a new Category
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	protected AdaptableCategoryImpl(final String name) throws IllegalArgumentException{
		setName(name);
	}
	
	/**
	 * Dozer constructor.
	 */
	public AdaptableCategoryImpl(){
	}
	
	@Override
	public void setName(final String name) throws IllegalArgumentException{
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The name is null or empty");
		}
		this.name=name.trim().toLowerCase();
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setLink(final URL link) throws IllegalArgumentException{
		if(link==null){
			throw new IllegalArgumentException("The link cannot be null");
		}
		this.link=link;
	}

	@Override
	public URL getLink() {
		return link;
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Category){
			final Category category=(Category)obj;
			return super.equals(obj) && 
					link.equals(category.getLink()) &&
					name.equals(category.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * link.hashCode() * name.hashCode();
	}
	
	@Override
	public String toString(){
		return super.toString() + " " + name;
	}

}
