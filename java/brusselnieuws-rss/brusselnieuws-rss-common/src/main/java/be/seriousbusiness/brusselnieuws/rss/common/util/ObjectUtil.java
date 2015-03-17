package be.seriousbusiness.brusselnieuws.rss.common.util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Object} helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class ObjectUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(ObjectUtil.class);
	
	/**
	 * Checks if all {@link Object}s are <code>null</code> or non <code>null</code>. 
	 * @param nill 	<code>true</code> when the {@link Object}(s) needs to be <code>null</code>
	 * 				<code>false</code> when the {@link Object}(s) needs to be NOT <code>null</code>
	 * @param objs array of {@link Object}(s) to check
	 * @return <code>true</code> or <code>false</code> depending upon the chosen {@link nill} argument
	 */
	public static final <T extends Object> boolean isNull(final boolean nill,@SuppressWarnings("unchecked") final T... objs){
		if(objs==null) { return nill; }
		for(final Object obj : objs){
			if(nill==(obj!=null)) { return false; }
		}
		return true;
	}
	
	/**
	 * Helper method for {@link #isNull(boolean, Object...)} with nill set to <code>true</code>.</br>
	 * Checks if all array {@link Object}(s) are <code>null</code>.
	 * @param objs the array of {@link Object}(s) to check
	 * @return 	<code>true</code> when all {@link Object}(s) are <code>null</code></br>
	 * 			<code>false</code> when one or more {@link Object}(s) are not <code>null</code>
	 * @see ObjectUtil#isNull(boolean, Object...)
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> boolean isNull(@SuppressWarnings("unchecked") final T... objs){
		return isNull(true,objs);
	}
	
	/**
	 * Helper method for {@link #isNull(boolean, Object...)} with nill set to <code>false</code>.</br>
	 * Checks if all array {@link Object}(s) are not <code>null</code>.
	 * @param objs the array of {@link Object}(s) to check
	 * @return 	<code>true</code> when all {@link Object}(s) are not <code>null</code>.</br>
	 * 			<code>false</code> when one or more {@link Object}(s) are <code>null</code>.
	 * @see ObjectUtil#isNull(boolean, Object...)
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> boolean isNotNull(@SuppressWarnings("unchecked") final T... objs){
		return isNull(false,objs);
	}
	
	/**
	 * Counts the number of <code>null</code> or not <code>null</code> {@link Object}(s).
	 * @param nill 	<code>true</code> when counting <code>null</code>
	 * 				<code>false</code> when counting non <code>null</code>
	 * @param objs the array of {@link Object}(s) to count
	 * @return when <code>true</code> the number of <code>null</code> values
	 * 				<code>false</code> the number of non <code>null</code> values
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> int numberOfNull(final boolean nill,@SuppressWarnings("unchecked") final T... objs){
		int i=0;
		if(objs==null) { return i; }
		for(final Object obj : objs){
			if(nill==(obj==null)) { i++; }
		}
		return i;
	}
	
	/**
	 * Helper method for {@link #numberOfNull(boolean, Object...)} with nill set to <code>true</code>.
	 * @param objs the array of {@link Object}(s) to count
	 * @return the number of <code>null</code> values
	 * @see #numberOfNull(boolean, Object...)
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> int numberOfNull(@SuppressWarnings("unchecked") final T... objs){
		return numberOfNull(true,objs);
	}
	
	/**
	 * Helper method for {@link #numberOfNull(boolean, Object...)} with nill set to <code>false</code>.
	 * @param objs the array of {@link Object}(s) to count
	 * @return the number of non <code>null</code> values
	 * @see #numberOfNull(boolean, Object...)
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> int numberOfNotNull(@SuppressWarnings("unchecked") final T... objs){ 
		return numberOfNull(false,objs);
	}
	
	/**
	 * Checks if all {@link Object}(s) have the same reference.
	 * @param objs the array of {@link Object}(s) to check
	 * @return  <code>true</code> when all references are the same
	 * 			<code>false</code> when at least one reference is different
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> boolean equalReference(@SuppressWarnings("unchecked") final T... objs) {
		if(isNull(objs) || objs.length<=1) { return true; }
		for(int i=1 ; i<objs.length ; i++) {
			if(objs[0]!=objs[i]) { return false; }
		}
		return true;
	}
	
	/**
	 * Checks if all {@link Object}(s) have the same class.
	 * @param objs the array of {@link Object}(s) to check
	 * @return	<code>true</code> when all classes are the same, otherwise <code>false</code>
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> boolean equalClass(@SuppressWarnings("unchecked") final T... objs) {
		final int numberOfNull=numberOfNull(objs),length=objs.length;
		if(numberOfNull==length || length<=1) { return true; }
		if(numberOfNull>0) { return false; }
		for(int i=1 ; i<length ; i++) {
			if(objs[0].getClass()!=objs[i].getClass()) { return false; }
		}
		return true;
	}
	
	/**
	 * Checks if all {@link Object}(s) are equal or <code>null</code>.
	 * @param objs the array of {@link Object}(s) to equalize
	 * @return <code>true</code> when the {@link Object}(s) are all equal or all <code>null</code>
	 * @see {@link ObjectUtil#equalReference(Object...)}
	 * @see {@link ObjectUtil#equalClass(Object...)}
	 * @see {@link Object}
	 * @since 1.0
	 */
	public static final <T extends Object> boolean equals(@SuppressWarnings("unchecked") final T... objs) {
		if(equalReference(objs)) { return true; }
		if(!equalClass(objs)) { return false; }
		for(int i=1 ; i<objs.length ; i++) {
			if(!objs[0].equals(objs[i])) { return false; }
		}
		return true;
	}
	
	/**
	 * Returns a hashCode even when the {@link Object} argument is <code>null</code>.
	 * @param obj the {@link Object} to calculate a hashCode for
	 * @return the {@link Object} hashCode or one when <code>null</code>
	 */
	public static final int hashCode(final Object obj){
		return obj==null ? 1 : obj.hashCode();
	}
	
	/**
	 * Builds a {@link String} representation of an {@link Object}'s fields.
	 * @param obj the {@link Object} to represent
	 * @return a {@link String} representation
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
	
	/**
	 * Appends a {@link String} representation of an {@link Object}'s accessible fields to a {@link StringBuilder}. 
	 * found in a given {@link Object}
	 * @param fields an array of {@link Field}
	 * @param obj the {@link Object} to represent
	 * @param stringBuilder the {@link StringBuilder} to add the representation to
	 * @return the number of represented {@link Field}(s)
	 */
	private static final int appendFields(final Field[] fields,final Object obj,final StringBuilder stringBuilder){
		int numberOfFields=fields.length;
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
					numberOfFields--;
				} catch (final IllegalAccessException e) {
					LOGGER.error("Field {} of Class {} is not accessible",fieldName,objectName,e);
					numberOfFields--;
				}			
			}
		}
		return numberOfFields;
	}
	
}
