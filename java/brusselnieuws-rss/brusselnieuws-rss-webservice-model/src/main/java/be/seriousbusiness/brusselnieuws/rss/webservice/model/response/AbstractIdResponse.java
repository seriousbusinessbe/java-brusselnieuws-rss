package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

import java.math.BigInteger;

/**
 * Abstract web service response bean containing id data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public abstract class AbstractIdResponse {
	protected BigInteger id;

	public BigInteger getId() {
		return id;
	}

	public void setId(final BigInteger id) {
		this.id = id;
	}

}
