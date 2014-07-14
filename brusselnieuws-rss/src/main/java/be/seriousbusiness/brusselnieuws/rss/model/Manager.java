package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.Set;

/**
 * Manages a certain type of entities.
 * @author Stefan Borghys
 * @author Serious Business
 *
 * @param <E> the entity type
 */
public interface Manager<E> {

	/**
	 * Get the number of managed {@link E}.
	 * @return number of {@link E}
	 */
	int size();
	
	/**
	 * Get a copy of all {@link E}.
	 * @return a set of {@link E}, empty when none
	 */
	Set<E> getAll();
	
	/**
	 * Check if a manager contains {@link E} or not
	 * @param e
	 * @return <code>true</code> when {@link E} is found
	 */
	boolean has(final E e);
	
	/**
	 * Add a new {@link E}.</br>
	 * No action is performed when <code<null</code>
	 * @param e
	 */
	void add(final E e);
}
