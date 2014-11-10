package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb.controller.mapping.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class MapUtil {
	
	/**
	 * Maps a <code>List</code> of MongoDB {@link ENTITY} into a <code>List</code> of {@link DTO}
	 * @param mapper a Dozer mapper instance
	 * @param entities a <code>List</code> of {@link ENTITY}
	 * @param dtoClass the {@link DTO} <code>Class</code>
	 * @return a <code>List</code> of {@link DTO}
	 */
	public static final <DTO,ENTITY> List<DTO> map(final Mapper mapper,final List<ENTITY> entities,final Class<DTO> dtoClass){
		final List<DTO> dtos=new ArrayList<DTO>();
		for(final ENTITY entity : entities){
			dtos.add(mapper.map(entity,dtoClass));
		}
		return dtos;
	}

}
