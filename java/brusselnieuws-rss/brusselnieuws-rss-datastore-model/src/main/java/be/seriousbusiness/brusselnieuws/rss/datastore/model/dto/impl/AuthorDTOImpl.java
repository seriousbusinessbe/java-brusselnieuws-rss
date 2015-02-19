package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.common.util.ObjectUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * {@link AuthorDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
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
		return ObjectUtil.toString(this);
	}
	
	@Override
	public Object clone() {
		final AuthorDTOImpl authorDTOImpl=new AuthorDTOImpl();
		authorDTOImpl.setId(id);
		authorDTOImpl.setName(name);
		return authorDTOImpl;
	}

}
