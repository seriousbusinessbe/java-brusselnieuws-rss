package be.seriousbusiness.brusselnieuws.rss.datasource.dto.dozer;

import java.lang.reflect.Type;

public class MapperUtil {
	
	/**
	 * Check if a class implements a given interface.
	 * @param classClass the class to inspect
	 * @param interfaceClass the interface it should use
	 * @return <code>true</code> when the interface is implemented
	 */
	public static final boolean hasInterface(final Class<?> classClass,final Class<?>... interfaceClasses){
		for(final Class<?> cls : classClass.getInterfaces()){
			for(final Class<?> interfaceClass : interfaceClasses){
				if(cls.equals(interfaceClass)){
					return true;
				}
			}	
		}
		return false;
	}

}
