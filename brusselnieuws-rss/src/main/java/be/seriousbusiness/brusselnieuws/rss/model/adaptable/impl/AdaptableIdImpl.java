package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import be.seriousbusiness.brusselnieuws.rss.model.Id;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableId;

public class AdaptableIdImpl<ID> implements AdaptableId<ID> {
	private ID id;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(final ID id) throws IllegalArgumentException {
		if(id==null){
			throw new IllegalArgumentException("The id is null");
		}
		this.id=id;
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj!=null && obj instanceof Id<?>){
			@SuppressWarnings("unchecked")
			final Id<ID> id=(Id<ID>)obj;
			return (this.id==null && id.getId()==null) || (this.id.equals(id.getId()));
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id==null ? 1 : id.hashCode();
	}
	
	@Override
	public String toString(){
		return id==null ? "" : id.toString();
	}

}
