package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Generic {@link IdDTO} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID> the type of id
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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		return new EqualsBuilder().append(id,((AbstractIdDTOImpl<ID>) obj).getId()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(43,33).append(id).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id",id).toString();
	}

}
