package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception;

/**
 * Throw a {@link NotUniqueException} when a field value is not unique</br>
 * while being saved or updated into a datastore.
 * @author stefanborghys
 */
public class NotUniqueException extends RuntimeException {
	private static final long serialVersionUID = 5923556422660858554L;
	private final String fieldName;
	private final Object fieldValue; 
	
	/**
	 * Create a new {@link NotUniqueException}</br>
	 * when saving or updating a field fails because it's not unique.
	 * @param fieldName the failing field name
	 * @param fieldValue the failing field value 
	 * @param cause the specific cause thrown by the datastore implementation
	 */
	public NotUniqueException(final String fieldName,final Object fieldValue,final Throwable cause){
		super("Field '"+fieldName+"' with value '"+fieldValue.toString()+"' is not unique",cause);
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
	
	/**
	 * Get the not unique field name. 
	 * @return
	 */
	public String getFieldName(){
		return fieldName;
	}
	
	/**
	 * Get the not unique field value.
	 * @return
	 */
	public Object getFieldValue(){
		return fieldValue;
	}

}
