package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Content;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableContent;

public abstract class AbstractAdaptableContent<ID> extends AdaptableIdImpl<ID> implements AdaptableContent<ID> {
	private String title,description;
	private URL link;
	
	/**
	 * @param title
	 * @throws IllegalArgumentException when the title is <code>null</code>
	 */
	protected AbstractAdaptableContent(final String title) throws IllegalArgumentException{
		setTitle(title);
	}
	
	public AbstractAdaptableContent(){
		
	}
	
	/**
	 * Set a title
	 * @param title
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	@Override
	public void setTitle(final String title) throws IllegalArgumentException{
		if(title==null || title.isEmpty()){
			throw new IllegalArgumentException("The title cannot be null or empty");
		}
		this.title=title.trim();
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set a link
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
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
	
	/**
	 * Set a description
	 * @param description
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	@Override
	public void setDescription(final String description) throws IllegalArgumentException{
		if(description==null){
			throw new IllegalArgumentException("The description cannot be null");
		}
		this.description=description.trim();
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean hasDescription() {
		return description!=null;
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Content){
			@SuppressWarnings("unchecked")
			final Content<ID> content=(Content<ID>)obj;
			return super.equals(content) && 
					title.equals(content.getTitle()) &&
					description.equals(content.getDescription()) &&
					link.equals(content.getLink());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * title.hashCode() * description.hashCode() * link.hashCode();
	}
	
	@Override
	public String toString(){
		return super.toString() + " " + title;
	}

}
