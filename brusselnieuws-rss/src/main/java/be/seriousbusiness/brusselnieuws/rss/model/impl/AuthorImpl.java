package be.seriousbusiness.brusselnieuws.rss.model.impl;

import be.seriousbusiness.brusselnieuws.rss.model.Author;

public class AuthorImpl implements Author {
	private String name;
	
	public static class Builder{
		private String name;
		
		public AuthorImpl build(){
			return new AuthorImpl(this);
		}
		
		public Builder name(final String name){
			this.name=name;
			return this;
		}
	}
	
	private AuthorImpl(final Builder builder) throws IllegalArgumentException {
		this(builder.name);
	}
	
	/**
	 * Create a new Author
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	protected AuthorImpl(final String name) throws IllegalArgumentException{
		setName(name);
	}
	
	/**
	 * Set a name
	 * @param name
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	protected void setName(final String name) throws IllegalArgumentException{
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The name is null or empty");
		}
		this.name=name.trim();
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof Author && name.equals(((Author)obj).getName());
	}
	
	@Override
	public String toString(){
		return name;
	}

}
