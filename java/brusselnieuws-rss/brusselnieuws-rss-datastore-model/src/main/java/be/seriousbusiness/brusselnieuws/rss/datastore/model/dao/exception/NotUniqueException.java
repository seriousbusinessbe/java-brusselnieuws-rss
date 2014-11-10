package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.exception;

public class NotUniqueException extends RuntimeException {
	private static final long serialVersionUID = 5923556422660858554L;
	private final String fieldName;
	private final Object fieldValue; 
	
	public NotUniqueException(final String fieldName,final Object fieldValue,final Throwable cause){
		super("Field '"+fieldName+"' with value '"+fieldValue.toString()+"' is not unique",cause);
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
	
	public String getFieldName(){
		return fieldName;
	}
	
	public Object getFieldValue(){
		return fieldValue;
	}

}
