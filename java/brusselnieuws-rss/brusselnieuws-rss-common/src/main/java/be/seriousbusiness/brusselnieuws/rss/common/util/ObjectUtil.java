package be.seriousbusiness.brusselnieuws.rss.common.util;

import java.lang.reflect.Field;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Object} utility.
 * @author stefanborghys
 */
public class ObjectUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(ObjectUtil.class);
	
	/**
	 * Check if all {@link Object} are <code>null</code>.
	 * @param objs all {@link Object} to perform a <code>null</code> check on
	 * @return <code>true</code> when all {@link Object} are <code>null</code>.</br>
	 * <code>false</code> when one {@link Object} is not <code>null</code>.
	 */
	public static final boolean isNull(final Object... objs){
		for(final Object obj : objs){
			if(obj!=null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if all {@link Object} are not <code>null</code>.
	 * @param objs all {@link Object} to perform a not <code>null</code> check on
	 * @return <code>true</code> when all {@link Object} are not <code>null</code>.</br>
	 * <code>false</code> when one {@link Object} is <code>null</code>.
	 */
	public static final boolean isNotNull(final Object... objs){
		for(final Object obj : objs){
			if(obj==null){
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if both {@link Object} are <code>null</code> or equal.
	 * @param obj1 the first {@link Object} to compare
	 * @param obj2 the second {@link Object} to compare
	 * @return <code>true</code> when both <code>null</code> or equal.
	 */
	public static final boolean isNullOrEqual(final Object obj1,final Object obj2){
		return isNull(obj1,obj2) || (isNotNull(obj1,obj2) && obj1.equals(obj2));
	}
	
	/**
	 * Return a hashCode even when the {@link Object} is <code>null</code>.
	 * @param obj the {@link Object} to calculte the hashCode for
	 * @return the {@link Object} hashCode, 1 when <code>null</code>
	 */
	public static final int hashCode(final Object obj){
		return obj==null ? 1 : obj.hashCode();
	}
	
	/**
	 * Build an {@link Object} {@link String} representation.
	 * @param clss the {@link Class} to create a {@link String} representation of 
	 * @param fields a {@link Map} of 
	 * @return
	 */
	public static final String toString(final Object obj){
		final StringBuilder stringBuilder=new StringBuilder();
		final Class<?> objectClass=obj.getClass();
		final String objectName=objectClass.getSimpleName();
		stringBuilder.append(objectName);
		stringBuilder.append(" [");
		if(appendFields(objectClass.getDeclaredFields(),obj,stringBuilder)>0){
			stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	private static final int appendFields(final Field[] fields,final Object obj,final StringBuilder stringBuilder){
		final int numberOfFields=fields.length;
		if(numberOfFields>0){
			final String objectName=obj.getClass().getSimpleName();
			for(final Field field : fields){
				field.setAccessible(true);
				String fieldName="NOT-SET";
				try {
					fieldName=field.getName();
					final Object fieldValue = field.get(obj);
					final Class<?> fieldTypeClass = field.getType();
					String stringValue="NULL";
					if(fieldValue!=null){
						stringValue=fieldValue.toString();
					}
					if(fieldTypeClass.equals(Logger.class)){
						continue;
					}else if(fieldTypeClass.equals(String.class)){
						stringBuilder.append(fieldName).append("='").append(stringValue).append("',\n");
					}else{
						stringBuilder.append(fieldName).append("=").append(stringValue).append(",\n");
					}
				} catch (final IllegalArgumentException e) {
					LOGGER.error("Class {} does not contain field {}",objectName,fieldName,e);
				} catch (final IllegalAccessException e) {
					LOGGER.error("Field {} of Class {} is not accessable",fieldName,objectName,e);
				}			
			}
		}
		return numberOfFields;
	}
}
