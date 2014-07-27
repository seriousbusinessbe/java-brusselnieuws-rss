package be.seriousbusiness.brusselnieuws.rss.model;

public interface Id<ID> {
	
	/**
	 * Get the unique id.
	 * @return a unique id or <code>null</code> when not yet set
	 */
	ID getId();

}
