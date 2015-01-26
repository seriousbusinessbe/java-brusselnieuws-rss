package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception;

/**
 * Thrown when a value is marked not unique while being saved or updated into a datastore.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class NotUniqueException extends RuntimeException {
	private static final long serialVersionUID = 5923556422660858554L;
	private final String fieldName;
	private final Object fieldValue; 
	
	/**
	 * Creates a new {@link NotUniqueException}.
	 * @param fieldName the failing field's name
	 * @param fieldValue the failing field's value 
	 * @param cause the specific cause thrown by the datastore implementation when a value is non-unique when required to be unique
	 */
	public NotUniqueException(final String fieldName,final Object fieldValue,final Throwable cause){
		super("Field '"+fieldName+"' with value '"+fieldValue.toString()+"' is not unique",cause);
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
	
	/**
	 * Gets the non unique field name. 
	 * @return non unique field name
	 */
	public String getFieldName(){
		return fieldName;
	}
	
	/**
	 * Gets the non unique field value.
	 * @return non unique field value
	 */
	public Object getFieldValue(){
		return fieldValue;
	}

}
