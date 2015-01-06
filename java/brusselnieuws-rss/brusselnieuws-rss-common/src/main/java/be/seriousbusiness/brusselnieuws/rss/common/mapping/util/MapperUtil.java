package be.seriousbusiness.brusselnieuws.rss.common.mapping.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

/**
 * Dozer {@link Mapper} utility <code>class</code>.
 * @author stefanborghys
 *
 */
public class MapperUtil {
	
	/**
	 * Map a <code>List</code> of {@link SOURCE} into a <code>List</code> of {@link DESTINATION}.
	 * @param mapper a Dozer {@link Mapper} instance
	 * @param sources a <code>List</code> of {@link SOURCE}
	 * @param destinationClass the {@link DESTINATION} <code>Class</code>
	 * @return a <code>List</code> of {@link DESTINATION}, or empty when nothing to map
	 */
	public static final <DESTINATION,SOURCE> List<DESTINATION> map(final Mapper mapper,final Collection<SOURCE> sources,final Class<DESTINATION> destinationClass){
		final List<DESTINATION> destinations=new ArrayList<DESTINATION>();
		if(sources!=null){
			for(final SOURCE source : sources){
				destinations.add(mapper.map(source,destinationClass));
			}
		}
		return destinations;
	}

}
