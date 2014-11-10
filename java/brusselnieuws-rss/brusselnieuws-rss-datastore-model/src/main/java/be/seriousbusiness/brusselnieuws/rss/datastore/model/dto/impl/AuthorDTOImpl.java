package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.DTOUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.util.ObjectUtil;

public class AuthorDTOImpl extends AbstractIdDTOImpl<BigInteger> implements AuthorDTO  {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name=name;
	}
	
	@Override
	public boolean equals(final Object obj){
		return obj!=null && obj instanceof AuthorDTOImpl && super.equals(obj) &&
				ObjectUtil.isNullOrEqual(name,((AuthorDTOImpl)obj).name);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() * ObjectUtil.hashCode(name);
	}
	
	@Override
	public String toString(){
		final Map<String,Object> fields=new HashMap<String,Object>();
		fields.put("id",id);
		fields.put("name",name);
		return DTOUtil.stringBuilder("authorDTOImpl", fields);
	}

}
