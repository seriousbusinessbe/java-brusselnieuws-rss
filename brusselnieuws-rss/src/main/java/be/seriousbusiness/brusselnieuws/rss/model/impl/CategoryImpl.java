package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Category;

public class CategoryImpl implements Category {
	private String name;
	private URL link;
	
	/**
	 * Create a new Category
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	protected CategoryImpl(final String name) throws IllegalArgumentException{
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
	
	/**
	 * Set a link
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	protected void setLink(final URL link) throws IllegalArgumentException{
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
	public String toString(){
		return name;
	}

}
