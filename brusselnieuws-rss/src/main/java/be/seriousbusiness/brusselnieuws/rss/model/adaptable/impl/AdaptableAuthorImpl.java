package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableAuthor;

public class AdaptableAuthorImpl extends AdaptableIdImpl<Long> implements AdaptableAuthor {
	private String name;
	
	public static class Builder{
		private Long id;
		private String name;
		
		public Builder id(final long id){
			this.id=id;
			return this;
		}
		
		public AdaptableAuthorImpl build(){
			return new AdaptableAuthorImpl(this);
		}
		
		public Builder name(final String name){
			this.name=name;
			return this;
		}
	}
	
	private AdaptableAuthorImpl(final Builder builder) throws IllegalArgumentException {
		this(builder.name);
		if(builder.id!=null){
			setId(builder.id);
		}
	}
	
	/**
	 * Create a new Author
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	protected AdaptableAuthorImpl(final String name) throws IllegalArgumentException{
		setName(name);
	}
	
	public AdaptableAuthorImpl(){
		
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
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof Author && name.equals(((Author)obj).getName()) && super.equals(obj);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * name.hashCode();
	}
	
	@Override
	public String toString(){
		return super.toString() + " " + name;
	}

}
