package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
	public boolean equals(final Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		return new EqualsBuilder().append(id,((AbstractIdImpl<ID>) obj).getId()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(73,13).append(id).toHashCode();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).append("id",id).toString();
	}

}
