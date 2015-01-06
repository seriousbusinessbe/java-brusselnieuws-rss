package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Id;

public abstract class AbstractIdImpl<ID> implements Id<ID> {
	protected ID id;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(final ID id) {
		this.id=id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof AbstractIdImpl && 
				ObjectUtil.isNullOrEqual(id,((AbstractIdImpl<ID>)obj).id);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id);
	}

}
