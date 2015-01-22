package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID>
 */
public abstract class AbstractIdDTOImpl<ID> implements IdDTO<ID> {
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
		return obj!=null && obj instanceof AbstractIdDTOImpl && 
				ObjectUtil.isNullOrEqual(id,((AbstractIdDTOImpl<ID>)obj).id);
	}
	
	@Override
	public int hashCode(){
		return ObjectUtil.hashCode(id);
	}

}
