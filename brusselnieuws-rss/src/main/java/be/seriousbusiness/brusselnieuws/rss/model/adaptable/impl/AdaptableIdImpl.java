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
		return obj!=null && obj instanceof Id<?> && this.id.equals(((Id<?>)obj).getId());
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
	@Override
	public String toString(){
		return id==null ? "" : id.toString();
	}

}
