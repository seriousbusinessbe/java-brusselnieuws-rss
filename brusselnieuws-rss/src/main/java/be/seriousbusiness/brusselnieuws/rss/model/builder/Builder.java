package be.seriousbusiness.brusselnieuws.rss.model.builder;

/**
 * General builder used to build an entity.</br>
 * @author Stefan Borghys
 * @author Serious Business
 *
 * @param <E> the entity type
 */
public interface Builder<E> {
	/**
	 * Build an entity of type {@link E}.
	 * @return a new {@link E}
	 */
	E build();
}
