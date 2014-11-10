package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util;

import java.util.Map;

public class DTOUtil {
	
	/**
	 * Constructs a String representation of a DTO.
	 * @param name the document name
	 * @param fields a map of document fields, containing the name as key and it's actual value
	 * @return a new String representation 
	 */
	public static final String stringBuilder(final String name,final Map<String,Object> fields){
		final StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(name);
		if(fields!=null && !fields.isEmpty()){
			stringBuilder.append(" [");
			for(final Map.Entry<String,Object> field : fields.entrySet()){
				final Object value=field.getValue();
				String stringValue="NULL";
				if(value!=null){
					stringValue=value.toString();
				}
				if(value instanceof String){
					stringBuilder.append(field.getKey()).append("='").append(stringValue).append("', ");
				}else{
					stringBuilder.append(field.getKey()).append("=").append(stringValue).append(", ");
				}
			}
			stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
			stringBuilder.append("]");
		}
		return stringBuilder.toString();
	}

}
