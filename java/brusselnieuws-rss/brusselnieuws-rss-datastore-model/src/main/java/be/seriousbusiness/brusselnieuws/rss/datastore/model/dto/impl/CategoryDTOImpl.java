package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.DTOUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.util.ObjectUtil;

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
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("name",name);
		fields.put("link",link);
		return DTOUtil.stringBuilder("categoryDTOImpl", fields);
	}

}
