package be.seriousbusiness.brusselnieuws.rss.common.mapping.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

/**
 * Dozer {@link Mapper} helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version %I%, %G%
 * @since 1.0
 */
public class MapperUtil {
	
	/**
	 * Maps a {@link Collection} of source type objects to a {@link List} of destination type objects.
	 * @param mapper a Dozer {@link Mapper} instance
	 * @param sources a {@link Collection} of source type objects
	 * @param destinationClass the destination object's {@link Class}
	 * @return a {@link List} of destination type objects, empty when nothing to map
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
