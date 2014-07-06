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
	int getSize();
	
	/**
	 * Add a unique {@link E}.</br>
	 * When the {@link E} is already added nothing will happen.
	 * @param e
	 */
	void add(final E e);
	
	/**
	 * Get all {@link E}.
	 * @return a set of {@link E}, empty when none
	 */
	Set<E> getAll();
}
