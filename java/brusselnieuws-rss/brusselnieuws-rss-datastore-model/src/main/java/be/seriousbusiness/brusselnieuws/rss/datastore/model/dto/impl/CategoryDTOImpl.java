package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * {@link CategoryDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImpl extends AbstractIdDTOImpl<BigInteger> implements CategoryDTO {
	private String name,link;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name=name;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(final String link) {
		this.link=link;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof CategoryDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(name,((CategoryDTOImpl)obj).name) &&
				ObjectUtil.isNullOrEqual(link,((CategoryDTOImpl)obj).link);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * ObjectUtil.hashCode(name) * ObjectUtil.hashCode(link);
	}
	
	@Override
	public String toString(){
		return ObjectUtil.toString(this);
	}

}
